fun <A> isSorted(list: List<A>, order: (A, A) -> Boolean): Boolean {
    for (i in 0 until list.size - 1) {
        if (!order(list[i], list[i + 1]))
            return false
    }
    return true
}

fun main(){
    println(isSorted(listOf(1, 2, 3, 4), {i: Int, j: Int -> i < j}))
    println(isSorted(listOf(1, 1, 1, 1), {i: Int, j: Int -> i==j}))
    println(isSorted(listOf("ahyyhh", "bkjn", "cnn", "duu"), {i: String, j: String -> i.first() < j.first()}))
}

