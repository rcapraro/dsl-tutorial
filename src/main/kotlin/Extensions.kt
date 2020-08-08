fun Int.myPlus(other: Int): Int = this + other

fun main() {
    println(2.myPlus(3))

    val myPlus2 = fun Int.(other: Int) = this + other  //anonymous extension function

    //myPlus2.invoke(2, 2)
    //myPlus2(2, 2)
    println(10.myPlus2(10))

    val myPlus3: Int.(Int)-> Int  = { other -> this + other} // lambda: we can replace with { this + it }

}