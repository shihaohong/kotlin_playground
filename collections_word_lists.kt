fun main() {
    val words = listOf("about", "acute", "awesome", "balloon", "best", "brief", "class", "coffee", "creative")

    // ignore case: ignore upper/lower casing
    val filteredWords = words.filter { it.startsWith("b", ignoreCase = true) }
        // function chaining
        .shuffled()
        .take(2)
        .sorted()
    println(filteredWords)
}
