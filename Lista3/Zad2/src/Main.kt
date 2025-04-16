fun addToBoolean(): Map<Int, Boolean> {
    return (1..20).associateWith { it % 2 == 0 }
}
fun main(){
    println(addToBoolean())
}

