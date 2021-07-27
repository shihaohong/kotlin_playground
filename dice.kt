fun main() {
    val diceRange = 1..6
    val randomNumber = diceRange.random()
    println("Random number: ${randomNumber}")

    val myFirstDice = Dice(6)
    println("${myFirstDice.numSides}-sided dice roll result is: ${myFirstDice.roll()}")
    val mySecondDice = Dice(20)
    println("${mySecondDice.numSides}-sided dice roll result is: ${mySecondDice.roll()}")

}

class Dice (val numSides: Int){
    fun roll() : Int {
        return (1..numSides).random()
    }
}
