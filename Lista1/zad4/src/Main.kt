fun sumalik(n: Int): Int {
    var sum = 0
    for (i in 1 until n) {
        if (n % i == 0) {
            sum += i
        }
    }
    return sum
}

fun isPerfect(number: Int): String {
    val sum = sumalik(number)
    return when {
        sum == number -> "doskonała"
        sum > number -> "obfita"
        else -> "niedomiarowa"
    }
}

fun main() {
    val number1: Int = 28
    println(isPerfect(number1))

    val number2: Int = 12
    println(isPerfect(number2))

    val number3: Int = 8
    println(isPerfect(number3))
}
