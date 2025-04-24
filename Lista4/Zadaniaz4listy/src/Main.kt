import java.time.LocalDate
import java.time.Month
import kotlin.random.Random

enum class CostType(val costType: String) {
    REFUELING("Tankowanie"),
    SERVICE("Serwis"),
    PARKING("Parking"),
    INSURANCE("Ubezpieczenie"),
    TICKET("Mandat")
}

data class Cost(
    val type: CostType,
    val date: LocalDate,
    val amount: Int
)

data class Car(
    val name: String,
    val brand: String,
    val model: String,
    val yearOfProduction: Int,
    val costs: List<Cost>
)

object DataProvider {

    private fun generalCosts(size: Int) = List(size) {
        Cost(
            CostType.values()[Random.nextInt(CostType.values().size)],
            LocalDate.of(
                2025,
                Random.nextInt(1, 13),
                Random.nextInt(1, 28)
            ),
            Random.nextInt(5000)
        )
    }

    val cars = listOf(
        Car("Domowy", "Skoda", "Fabia", 2002, generalCosts(100)),
        Car("Służbowy", "BMW", "Coupe", 2015, generalCosts(50)),
        Car("Kolekcjonerski", "Fiat", "125p", 1985, generalCosts(10))
    )

    val generalCosts = generalCosts(5)
}

// ZADANIE 1
fun groupedCostMap(costs: List<Cost>): Map<Month, List<Cost>> {
    return costs
        .groupBy { it.date.month }
        .toSortedMap()
}

// ZADANIE 2
fun printGroupedCosts(costs: List<Cost>) {
    costs
        .groupBy { it.date.month }
        .toSortedMap()
        .forEach { (month, monthCosts) ->
            println(month.name)
            monthCosts
                .sortedBy { it.date }
                .forEach {
                    val day = it.date.dayOfMonth.toString().padStart(2, '0')
                    println("$day ${it.type.name} ${it.amount} zł")
                }
        }
}

// ZADANIE 3
fun getCarCosts(name: String): List<Pair<CostType, Int>> {
    val car = DataProvider.cars.find { it.name == name } ?: return emptyList()

    return CostType.values()
        .map { type ->
            val sum = car.costs.filter { it.type == type }.sumOf { it.amount }
            type to sum
        }
        .sortedByDescending { it.second }
}

fun printCarCosts(costs: List<Pair<CostType, Int>>) {
    costs.forEach {
        println("${it.first.name} ${it.second} zł")
    }
}

// ZADANIE 4
fun printFullCosts(cars: List<Car>): Map<CostType, Int> {
    return CostType.values().associateWith { type ->
        cars
            .flatMap { it.costs }
            .filter { it.type == type }
            .sumOf { it.amount }
    }
}

fun printFullCost(costs: Map<CostType, Int>) {
    costs.forEach { (type, sum) ->
        println("${type.name} $sum")
    }
}

fun main() {
    println("Zadanie 1")
    val grouped = groupedCostMap(DataProvider.generalCosts)
    println(grouped)

    println("\nZadanie 2")
    printGroupedCosts(DataProvider.generalCosts)

    println("\nZadanie 3")
    printCarCosts(getCarCosts("Domowy"))

    println("\nZadanie 4")
    printFullCost(printFullCosts(DataProvider.cars))
}
