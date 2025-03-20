fun <A> tailToHead(list: List<A>): List<A> {
    if (list.isEmpty()) throw IllegalStateException("Empty list")
    return listOf(list.last()) + list.dropLast(1)
}

fun main() {
    println(tailToHead(listOf(1, 2, 3)))
}