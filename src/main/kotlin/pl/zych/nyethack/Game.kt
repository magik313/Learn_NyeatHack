package pl.zych.nyethack

fun main(args: Array<String>) {


    val player = Player("Mordowycz")
    player.castFireball()

//    Aura
    val auraColor = player.auraColor()


    var currentRoom = TownSquare()
    println(currentRoom.description())
    println(currentRoom.load())


    printPlayerStatus(player)

    player.auraColor()

}

private fun printPlayerStatus(player: Player) {
    println(
        "(Aura: ${player.auraColor()}) " +
                "(Pobłogosławiony: ${if (player.isBlessed) "TAK" else "NIE"})"
    )
    println("${player.name} ${player.formatHealthStatus()}")
}
