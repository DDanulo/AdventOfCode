import java.io.File

val gameNum = "\\d+".toRegex()
val redNum = "\\d+\\sred".toRegex()
val blueNum = "\\d+\\sblue".toRegex()
val greenNum = "\\d+\\sgreen".toRegex()
val numR = "\\d+".toRegex()

const val redBoundary = 12
const val greenBoundary = 13
const val blueBoundary = 14

var count = 0
var power = 0

fun main() {
    var gameN: Int
    var redN: ArrayList<Int>
    var greenN: ArrayList<Int>
    var blueN: ArrayList<Int>

    File("string2.txt").forEachLine {
        gameN = gameNum.find(it)?.value?.toInt()!!

        redN = getColorNumber(redNum, it)
        greenN = getColorNumber(greenNum, it)
        blueN = getColorNumber(blueNum, it)

        if (isInBound(redN, redBoundary)
            && isInBound(blueN, blueBoundary)
            && isInBound(greenN, greenBoundary)
        ) {
            count += gameN
        }
        power += (redN.max() * greenN.max() * blueN.max())
    }
    println(power)
    println(count)
}

fun isInBound(numberArray: ArrayList<Int>, boundary: Int): Boolean {
    for (i in numberArray){
        if (i>boundary){
            return false
        }
    }
    return true
}

fun getColorNumber(regex: Regex, string: String): ArrayList<Int> {
    val results = regex.findAll(string)
    val numArray: ArrayList<Int> = ArrayList()

    for (i in results){
        val number = numR.find(i.value)?.value?.toInt()
        if (number != null) {
            numArray.add(number)
        }
    }
    return numArray
}

