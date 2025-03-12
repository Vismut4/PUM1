fun checkArmstrong(number: Int): Boolean {
    val digits = number.toString()
    val numDigits = digits.length

    var sum = 0
    var temp = number
    while (temp > 0) {
        val digit = temp % 10
        sum += Math.pow(digit.toDouble(), numDigits.toDouble()).toInt()
        temp /= 10
    }

    return sum == number
}

fun main() {
    val number: Int = 153
    println(checkArmstrong(number))
}
