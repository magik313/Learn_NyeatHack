import java.io.File
import kotlin.math.roundToInt

const val TAVERN_NAME = "Szynk Hipolit'a"

var playerGold = 10
var playerSilver = 10
val patronList = mutableListOf("Ela", "Mordeczka", "Zocha")
val lastName = listOf("Żelaznostopa", "Urwiłeb", "Zaraza")
val uniquePatrons = mutableSetOf<String>()
val menuList = File("data/tavern-menu-items.txt")
    .readText()
    .split("\n")

fun main(args: Array<String>) {
    if (patronList.contains("Ela")){
        println("Karczmarz mówi: Ela gra w karty w tylnej sali")
    }else{
        println("Karczmarz mówi: Eli nie ma ")
    }

    if (patronList.containsAll(listOf("Zocha", "Mordeczka"))){
        println("Karczmarz mówi: Tak, siedzą przy kociołku z gulszem")
    }else{
        println("Karczmarz mówi: nie wyjechali godzinę temu")
    }

    (0..9).forEach {
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        uniquePatrons += name
    }
    println(uniquePatrons)
    var orderCount = 0
    while (orderCount <= 9){
        placeOrder(uniquePatrons.shuffled().first(),
        menuList.shuffled().first())
        orderCount++
    }
}

fun performPurchase(price: Double){
    displayBalance()
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("Sumaryczna wartość sakiewki: $totalPurse")
    println("Zamawianie produktu za: $price")

    val remainingBalance = totalPurse - price
    println("W sakiewce zostało: ${"%.2f".format(remainingBalance)}")

    val remainingGold = remainingBalance.toInt()
    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
    playerGold = remainingGold
    playerSilver = remainingSilver
    displayBalance()
}

private fun displayBalance(){
    println("Stan sakiewki gracza: złoto: $playerGold, srebro: $playerSilver")
}

private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiou]")) {
        when (it.value){
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }

fun placeOrder(patronName: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(6 until indexOfApostrophe)
    println("$patronName i $tavernMaster rozmawiaja o zamowieniu")

    val (type, name, price) = menuData.split(',')
    val message = "$patronName kupil(a) $name ($type) za $price."
    println(message)

//    performPurchase(price.toDouble())

    val phrase = if (name == "Oddech Smoka"){
        "$patronName konstatuuje z zachwytem: ${toDragonSpeak("No... Ależ doskonały jest ten $name")}"
    } else {
        "$patronName mowi: dziekuję za ${name}"
    }
    println(phrase)
}
