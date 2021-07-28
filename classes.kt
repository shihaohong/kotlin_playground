fun main() {
    val squareCabin = SquareCabin(6)

    // `with` keyword allows for convenient access to
    // all of the variable's methods and members.
    with(squareCabin) {
        println("\nSquare Cabin\n============")
        println("Capacity: ${capacity}")
        println("Material: ${buildingMaterial}")
        println("Has room? ${hasRoom()}")
    }

    val roundHut = RoundHut(3)
    with(roundHut) {
        println("\nRound Hut\n=========")
        println("Material: ${buildingMaterial}")
        println("Capacity: ${capacity}")
        println("Has room? ${hasRoom()}")
    }

    val roundTower = RoundTower(4)
    with(roundTower) {
        println("\nRound Tower\n==========")
        println("Material: ${buildingMaterial}")
        println("Capacity: ${capacity}")
        println("Has room? ${hasRoom()}")
    }
}

abstract class Dwelling(private var residents: Int) {
    abstract val buildingMaterial: String
    abstract val capacity: Int

    fun hasRoom(): Boolean {
        return residents < capacity
    }
}

class SquareCabin(residents: Int) : Dwelling(residents) {
    override val buildingMaterial = "Wood"
    override val capacity = 6
}

// By default, you can only inherit from abstract classes or `open`
// class. By default, you cannot inherit from a class.
open class RoundHut(residents: Int) : Dwelling(residents) {
    override val buildingMaterial = "Straw"
    override val capacity = 4
}

class RoundTower(
    // Becomes a member
    residents: Int,
    // A variable used for instantiating other members
    val floors: Int = 2) : RoundHut(residents) {
    override val buildingMaterial = "Stone"
    override val capacity = 4 * floors
}
