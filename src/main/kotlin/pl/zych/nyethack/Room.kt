package pl.zych.nyethack

open class Room(val name: String) {
    protected open val dangerLevel = 5

    fun description() = "Pomieszcenie: $name\n" +
            "Poziom zagrożenia: $dangerLevel."

    open fun load() = "Nie ma tu nic ciekwego..."
}

open class TownSquare : Room("Skwer miejski"){
    override val dangerLevel = super.dangerLevel - 3
    private val bellSound = "DZYYN"

    final override fun load() = "Kiedy wszedłeś mieszkańcy uśmiechają się i witają!\n${ringBell()}"

    private fun ringBell() = "Dzwon na wieży obwieszcza twoje przybycie. $bellSound"
}