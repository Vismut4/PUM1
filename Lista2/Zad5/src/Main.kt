fun <A> setHead(list: List<A>, item: A): List<A> {
    return listOf(item) + list.drop(1)
}
fun main(){
    println(setHead(listOf(1, 2, 3), 5))
}