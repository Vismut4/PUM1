fun evenPositiveSquare(lst: List<Int>): List<Int> {
    return lst.withIndex()
        .filter { it.index % 2 == 1 && it.value > 0 }
        .map { it.value * it.value }
}

fun main() {
    println(evenPositiveSquare(listOf(1, 2, 3, 5, -6, -1, -1, 2, 3)))
}