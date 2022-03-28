import kotlin.math.roundToInt

const val TAVERN_NAME = "Szynk Hipolit'a"

var playerGold = 10
var playerSilver = 10

fun main(args: Array<String>) {
   placeOrder("shandy,Oddech Smoka,5.91")

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

fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(6 until indexOfApostrophe)
    println("Mordowicz i $tavernMaster rozmawiaja o zamowieniu")

    val (type, name, price) = menuData.split(',')
    val message = "Mordowycz kupil $name ($type) za $price."
    println(message)

    performPurchase(price.toDouble())

    val phrase = if (name == "Oddech Smoka"){
        "Mordowicz konstatuuje z zachwytem: ${toDragonSpeak("No... Ależ doskonały jest ten $name")}"
    } else {
        "Mordowicz mowi: dziekuję za ${name}"
    }
    println(phrase)
}
