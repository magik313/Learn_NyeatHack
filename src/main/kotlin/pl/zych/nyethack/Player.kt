package pl.zych.nyethack

class Player {
    var name = "mordowycz"
        get() = field.capitalize()
        private set(value) {
            field = value.trim()
        }

    var healthPoints = 89
    val isBlessed = true
    private val isImmortal = false

    fun auraColor(): String {
        val auraVisible = isBlessed && healthPoints > 50 || isImmortal
        val auraColor = if (auraVisible) "ZIELONKAWA" else "BRAK"
        return auraColor
    }


    fun formatHealthStatus()
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

    fun castFireball(numFireballs: Int = 2) =
        println("Nagle pojawiła sie kula ognia! (x$numFireballs)")

}