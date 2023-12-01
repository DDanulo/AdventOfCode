import java.io.File
fun main() {
    var sum = 0
    File("string.txt").forEachLine {
        val regex = "[0-9]|one|two|three|four|five|six|seven|eight|nine".toRegex()
        val num1 = stringConverter(regex.find(it)?.value.toString())
        val num2 = stringConverter(regex.findAll(it).last().value)
        val wholeNumber = num1 * 10 + num2
        sum += wholeNumber
    }
    println(sum)
}

fun stringConverter(string: String): Int {
    when (string) {
        "one", "1" -> return 1
        "two", "2" -> return 2
        "three", "3" -> return 3
        "four", "4" -> return 4
        "five", "5" -> return 5
        "six", "6" -> return 6
        "seven", "7" -> return 7
        "eight", "8" -> return 8
        "nine", "9" -> return 9
    }
    return 0
}