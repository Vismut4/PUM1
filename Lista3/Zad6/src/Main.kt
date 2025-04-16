fun <T> perm(lst: List<T>): List<List<T>> {
    if (lst.size <= 1) {return listOf(lst)}
    else {return lst.flatMap { e -> perm(lst - e).map { listOf(e) + it } } }
}
fun main(){
println(perm(listOf(1, 2, 3)))
}