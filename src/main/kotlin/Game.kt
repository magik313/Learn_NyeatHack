fun main(args: Array<String>) {
    val name = "Mordowicz"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false

//    Aura
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) "ZIELONKAWA" else  "BRAK"

    val healthStatus = when (healthPoints){
        100 -> "cieszy sie swietnym zdrowiem!"
        in 90..99 -> "jest zadrapany"
        in 75..89 -> if (isBlessed){
            " jest lekko poobijany ale sie leczy"
        }else {
            " jest lekko poobijany"
        }
        in 15..75 -> "jest ciezko ranny"
        else -> "jest w oplakanym stanie"
    }
    
    println("(Aura: $auraColor) " +
            "(Pobłogosławiony: ${if (isBlessed) "TAK" else "NIE"})")
    println("$name $healthStatus")
}