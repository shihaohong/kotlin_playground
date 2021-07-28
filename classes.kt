import kotlin.math.PI
import kotlin.math.sqrt

fun main() {
    val squareCabin = SquareCabin(6, 50.0)

    // `with` keyword allows for convenient access to
    // all of the variable's methods and members.
    with(squareCabin) {
        println("\nSquare Cabin\n============")
        println("Capacity: ${capacity}")
        println("Material: ${buildingMaterial}")
        println("Has room? ${hasRoom()}")
        println("Floor area: ${floorArea()}")
    }

    val roundHut = RoundHut(3, 10.0)
    with(roundHut) {
        println("\nRound Hut\n=========")
        println("Material: ${buildingMaterial}")
        println("Capacity: ${capacity}")
        println("Has room? ${hasRoom()}")
        println("Floor area: ${floorArea()}")
        println("Carpet size: ${calculateMaxCarpetSize()}\n\n")

        println("Has room? ${hasRoom()}")
        getRoom()
        println("Has room? ${hasRoom()}")
        getRoom()
    }

    val roundTower = RoundTower(4, 10.0)
    with(roundTower) {
        println("\nRound Tower\n==========")
        println("Material: ${buildingMaterial}")
        println("Capacity: ${capacity}")
        println("Has room? ${hasRoom()}")
        println("Floor area: ${floorArea()}")
        println("Carpet size: ${calculateMaxCarpetSize()}")
    }
}

// `private` properties can only be accessed within the class.
abstract class Dwelling(private var residents: Int) {
    abstract val buildingMaterial: String
    abstract val capacity: Int

    fun hasRoom(): Boolean {
        return residents < capacity
    }

    abstract fun floorArea(): Double
    fun getRoom() {
        if (capacity > residents) {
            residents++
            println("You got a room!")
        } else {
            println("Sorry, at capacity and no rooms left.")
        }
    }
}

class SquareCabin(
    residents: Int,
    val length: Double) : Dwelling(residents) {
    override val buildingMaterial = "Wood"
    override val capacity = 6

    override fun floorArea(): Double {
        return length * length
    }
}

// By default, you can only inherit from abstract classes or `open`
// class. By default, you cannot inherit from a class.
open class RoundHut(
    residents: Int,
    val radius: Double) : Dwelling(residents) {
    override val buildingMaterial = "Straw"
    override val capacity = 4

    override fun floorArea(): Double {
        return PI * radius * radius
    }

    open fun calculateMaxCarpetSize(): Double {
        val diameter = 2 * radius
        return sqrt(diameter * diameter / 2)
    }
}

class RoundTower(
    // Parameters used for instantiating other members
    residents: Int,
    radius: Double,
    // Becomes a member
    val floors: Int = 2) : RoundHut(residents, radius) {
    override val buildingMaterial = "Stone"
    override val capacity = 4 * floors

    override fun floorArea(): Double {
        // super keyword for the superclass.
        return super.floorArea() * floors
    }

    override fun calculateMaxCarpetSize(): Double {
        return super.calculateMaxCarpetSize() * floors
    }
}
