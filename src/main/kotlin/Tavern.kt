fun main(args: Array<String>) {
    var beverage = readLine()

    beverage = null

    if (beverage != null){
        beverage = beverage.capitalize()
    }else{
        println("beverage rowne null")
    }

    val beverageServed: String = beverage ?: "Grzaniec na Porterze"
    print(beverageServed)

}