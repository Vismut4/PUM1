//fun suma(a: List<Int>): Int {
//    return a.filter { it > 0 }
//        .sum()
//}
fun suma(lst: List<Int>): Int {
    return lst.filter { it > 0 }
        .reduce { acc, num -> acc + num }
}

fun main(){
println(suma(listOf(1, -4, 12, 0, -3, 29, -150)))
}