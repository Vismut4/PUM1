fun findDuplicates(lst: List<Int>): List<Int> {
    return lst.groupingBy { it }
        .eachCount()
        .filter { it.value > 1 }
        .keys
        .sorted()
}

fun main() {
    val lst = listOf(0, 1, 1, 1, 4, 4, 4, 9, 3, 3, 3, 3, 3, 3)
    println(findDuplicates(lst))
}
