package ru.tbank.education.school.lesson1

open class Food {
    protected var condition:Int = 100
    open fun eat (bite:Int = 10) {
        condition -= bite
    }
}
class Apple (
    val color:String,
    val shape:String,
    val taste:String,
    val poisoned: Boolean,
    var hasLeaf: Boolean = false
    ): Food() {

    override fun eat(bite:Int) {
        if (!poisoned) {
            super.eat(bite)
        } else {
            error("the apple is poisoned!")
        }
    }

    fun getCondition():Int {
        return condition
    }
}

/**
 * МОДИФИКАТОРЫ ДОСТУПА:
 * private - недоступно извне
 * protected - недоступно извне, но доступно для дочерних классов
 * internal - доступ только внутри пакета
 * public - полная доступность (по дефолту)
 */
// Data классы запрещают наследование
fun main() {
    val str:String = "const string"
    println(str)

    var a:Byte = 1
    a++
    println(a)

    val n:Byte? = null
    println(n)

    for (x in 5 downTo 1 step 2) {
        println(x)
    }

    val apple = Apple("Green", "Cube", "Juicy", false)
    println("Цвет яблока: ${apple.color}")
}
