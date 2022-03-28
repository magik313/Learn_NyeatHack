
const val TAVERN_NAME = "Szynk Hipolit'a"

fun main(args: Array<String>) {
//   placeOrder("shandy,Oddech Smoka,5.91")
    placeOrder("eliksir,Zdrowy wykop,4.83")

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


    val phrase = if (name == "Oddech Smoka"){
        "Mordowicz konstatuuje z zachwytem: ${toDragonSpeak("No... Ależ doskonały jest ten $name")}"
    } else {
        "Mordowicz mowi: dziekuję za ${name}"
    }
    println(phrase)
}
