fun main() {
    val numbers = listOf(0, 3, 8, 4, 0, 5, 5, 8, 9, 2)
    println("list : ${numbers}")
    println("sorted: ${numbers.sorted()}")

    val setOfNumbers = numbers.toSet()
    println("set:    ${setOfNumbers}")

    // By default, sets aren't mutable in Kotlin
    val set1 = setOf(1,2,3)
    val set2 = mutableSetOf(3,2,1)
    // Considered equal because they have the same set of
    // items
    println("$set1 == $set2: ${set1 == set2}")

    // By default, maps aren't mutable in Kotlin
    val peopleAges = mutableMapOf<String, Int>(
        "Fred" to 30,
        "Ann" to 23
    )
    println(peopleAges)

    // Two different types of syntax to add entries to the map
    peopleAges.put("Barbara", 42)
    peopleAges["Joe"] = 51
    // Modifies value of the entry "Fred"
    peopleAges["Fred"] = 31
    println(peopleAges)


    // Lambdas in Kotlin
    // Basically an unnamed function that can be used
    // as an expression.
    // Allows for functions to be stored in variables and
    // classes, and pass functions as arguments.
    // Can return functions as well.
    // Basically, similar idea as a function as
    // an Object in JavaScript.

    // Special identifier `it` for the entry in a map
    // forEach
    peopleAges.forEach { print("${it.key} is ${it.value}, ") }

    // map
    // applies a transformation and returns a new collection
    println(peopleAges.map { "${it.key} is ${it.value}" }.joinToString(", ") )

    // filter
    // returns subset of collection that "pass" the filter
    val filteredNames = peopleAges.filter { it.key.length < 4 }
    println(filteredNames)

    // Function types
    // Can define a type for a function based on its input params
    // and return value
    // ie. `(String) -> Int`
    // takes a String parameter, returns an Int result.

    // triple is a function that takes an Int and returns
    // an Int that triple the input.
    val triple: (Int) -> Int = { a: Int -> a * 3 }
    println(triple(5))

}
