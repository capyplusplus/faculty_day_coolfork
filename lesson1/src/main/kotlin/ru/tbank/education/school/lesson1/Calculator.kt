package ru.tbank.education.school.lesson1
import kotlin.math.*
/**
 * Метод для вычисления простых арифметических операций.
 */
fun calculate(a: Double, b: Double, operation: OperationType = OperationType.ADD): Double? {
    val result = when (operation) {
        OperationType.ADD -> a + b
        OperationType.SUBTRACT -> a - b
        OperationType.MULTIPLY -> a * b
        OperationType.DIVIDE -> {
            if (b == 0.0) {
                null
            } else {
                a / b
            }
        }

        OperationType.SIN -> sin(a)
        OperationType.COS -> cos(a)
        OperationType.TG -> tan(a)
        OperationType.CTG -> 1 / tan(a)
        else -> null
    }

    return result
}

/**
 * Функция вычисления выражения, представленного строкой
 * @return результат вычисления строки или null, если вычисление невозможно
 * @sample "5 * 2".calculate()
 */
@Suppress("ReturnCount")
fun String.calculate(): Double? {
    var arr = this.split(" ")
    var operator: OperationType? = null
    var a: Double? = null
    var b: Double? = null

    if (arr.size == 3) {
        if (arr[1] == "+") {
            operator = OperationType.ADD
        } else if (arr[1] == "-") {
            operator = OperationType.SUBTRACT
        } else if (arr[1] == "*") {
            operator = OperationType.MULTIPLY
        } else if (arr[1] == "/") {
            operator = OperationType.DIVIDE
        } else {
            return null
        }
        a = arr[0].toDoubleOrNull()
        b = arr[2].toDoubleOrNull()
    } else if (arr.size == 2) {
        arr[0].lowercase()
        if (arr[0] == "sin") {
            operator = OperationType.SIN
        } else if (arr[0] == "cos") {
            operator = OperationType.COS
        } else if (arr[0] == "tg" || arr[0] == "tan") {
            operator = OperationType.TG
        } else if (arr[0] == "ctg" || arr[0] == "ctan") {
            operator = OperationType.CTG
        } else {
            return null
        }
        val inDegrees: Boolean = (arr[1].get(arr[1].length - 1) == '*')
        val value = if(!inDegrees) arr[1] else arr[1].dropLast(1)

        a = value.toDoubleOrNull()
        if (inDegrees && a != null) {
            a = a / 180 * 3.14
        }
        b = 0.0
    } else {
        return null
    }

    if (a == null || b == null || operator == null) {
        return null
    }

    return calculate(a = a, b = b, operator)
}