fun main() {
    val myFirstDice = LuckyDice(6)
    val rollResult = myFirstDice.roll()
    val luckyNumber = 4

    // when statement: Kind of like a `switch statement`
    when (rollResult) {
        luckyNumber -> println("You won!")
        1 -> println("So sorry! You rolled a 1. Try again!")
        2 -> println("Sadly, you rolled a 2. Try again!")
        3 -> println("Unfortunately, you rolled a 3. Try again!")
        5 -> println("Don't cry! You rolled a 5. Try again!")
        6 -> println("Apologies! you rolled a 6. Try again!")
   }
}

class LuckyDice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}
