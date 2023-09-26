package ru.smak.l4

class MyClass(var a: Int = 0) {

    companion object {
        const val name = "MyObject"
        var myClassCounter: Int = 0
            private set
    }

    init{
        myClassCounter++
    }

    operator fun plus(other: MyClass) = MyClass((a.toString()+other.a.toString()).toInt())
    operator fun times(other: MyClass) = MyClass(a * other.a)
    operator fun plusAssign(other: MyClass){
        a = (a.toString()+other.a.toString()).toInt()
    }
    operator fun get(index: Int) = a.toString().let{ aStr -> (aStr.length-1-index).let{ strIndex ->
        if (strIndex >= 0 && index >= 0) aStr[strIndex] else 0
    } }
    override fun toString(): String = "Obj with a = $a"
}

fun main() {
    var a1 = MyClass(5).also { println(it) }
    val a2 = MyClass(7).also { println(it) }
    val a3 = (a1 + a2).also { println(it) }
    a2 += a3
    println(a2)
    val a4 = (a1 * a2).also { println(it) }
    a1 *= a2
    println(a1)
    a1.also{
        println(it[0])
        println(it[1])
        println(it[2])
        println(it[3])
        println(it[4])
        println(it[-1])
    }

    println(MyClass.name)
    println(MyClass.myClassCounter)
}