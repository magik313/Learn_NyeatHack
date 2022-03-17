fun main(args: Array<String>) {
    val name = "Mordowicz"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false

//    Aura
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)

    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    printPlayerStatus(auraColor, isBlessed, name, healthStatus)

    castFireball()
}

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String
) {
    println(
        "(Aura: $auraColor) " +
                "(Pobłogosławiony: ${if (isBlessed) "TAK" else "NIE"})"
    )
    println("$name $healthStatus")
}

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean): String {
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) "ZIELONKAWA" else "BRAK"
    return auraColor
}


    private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean)
    = when (healthPoints) {
        100 -> "cieszy sie swietnym zdrowiem!"
        in 90..99 -> "jest zadrapany"
        in 75..89 -> if (isBlessed) {
            " jest lekko poobijany ale sie leczy"
        } else {
            " jest lekko poobijany"
        }
        in 15..75 -> "jest ciezko ranny"
        else -> "jest w oplakanym stanie"
    }


private fun castFireball(numFireballs: Int = 2) =
    println("nagle pojawila sie kula ognia (x$numFireballs)")
