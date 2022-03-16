fun main(args: Array<String>) {
    val name = "Mordowicz"
    var healthPoints = 55
    val isBlessed = true
    val isImmortal = false

    val karma = (Math.pow(Math.random(), (110 - healthPoints)/ 100.0) * 20).toInt()

//    Aura
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) {
        when (karma){
            in 0..5 -> "czerwony"
            in 6..10 -> "pomaranczowy"
            in 11..15 -> "purpurowy"
            in 16..20 -> "zielonkawy"
            else -> "brak"
        }
    } else  "BRAK"

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