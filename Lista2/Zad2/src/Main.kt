val <T> List<T>.head: T
    get() = this.first()

val <T> List<T>.tail: List<T>
    get() = this.drop(1)

fun main(){
    val lista = listOf(10, 20, 30)
    println(lista.head)
    println(lista.tail)

}