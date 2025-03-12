fun foo(num: Int) {
    for (i in 1..num) {
        var output = ""
        if (i % 3 == 0) output += "trzy"
        if (i % 5 == 0) output += "piec"
        if (i % 7 == 0) output += "siedem"
        if (i % 11 == 0) output += "jedenascie"
        if (i % 13 == 0) output += "trzynascie"
        println(if (output.isEmpty()) i else output)
    }
}

fun main() {
    val num: Int = 100
    foo(num)
}