package pl.zych.nyethack

import java.io.File

class Player (_name: String,
                var healthPoints: Int = 100,
                val isBlessed: Boolean,
                private val isImmortal: Boolean) {
    var name = _name
        get() = "${field.capitalize()} z miasta $hometown"
        private set(value) {
            field = value.trim()
        }

    val hometown by lazy { selectHometown() }

    init {
        require(healthPoints > 0, { "Wartość healpoint ,usi być wieksza od zera." })
        require(name.isNotBlank(), {"Gracz musi się jakoś nazywać"})
    }

    constructor(name: String) : this(name,
        isBlessed = true,
        isImmortal = false){
        if (name.toLowerCase() == "jan") healthPoints = 40
    }

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

    private fun selectHometown() = File("data/towns.txt")
        .readText()
        .split("\n")
        .shuffled()
        .first()

}