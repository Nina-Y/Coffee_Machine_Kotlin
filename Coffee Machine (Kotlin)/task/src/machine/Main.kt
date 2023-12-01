fun main() {
    val coffeeMachine = CoffeeMachine()
    while (true) {
        println("Write action (buy, fill, take, remaining, exit):")
        when (Status.valueOf(readln().uppercase())) {
            Status.BUY -> coffeeMachine.buy()
            Status.FILL -> coffeeMachine.fill()
            Status.TAKE -> coffeeMachine.take()
            Status.REMAINING -> coffeeMachine.printRemaining()
            Status.EXIT -> return
        }
    }
}

enum class Status {
    BUY, FILL, TAKE, REMAINING, EXIT
}

class CoffeeMachine {
    var waterInStock = 400
    var milkInStock = 540
    var coffeeInStock = 120
    var cupsInStock = 9
    var cash = 550

     fun isEnoughIngredients(water: Int, milk: Int, beans: Int, cups: Int): Boolean {
        if (water > waterInStock) {
            println("Sorry, not enough water!")
            return false
        } else if (milk > milkInStock)  {
            println("Sorry, not enough milk!")
            return false
        } else if (beans > coffeeInStock) {
            println("Sorry, not enough beans!")
            return false
        } else if (cups > cupsInStock) {
            println("Sorry, not enough cups!")
            return false
        }
        println("I have enough resources, making you a coffee!")
        return true
    }
     
    fun buy() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
        when (readln()) {
            "1" -> {
                    if (!isEnoughIngredients(water = 250, milk = 0, beans = 16, cups = 1)) return
                        waterInStock -= 250
                        coffeeInStock -= 16
                        cupsInStock -= 1
                        cash += 4
                    }
            "2" -> {
                    if (!isEnoughIngredients(water = 350, milk = 75, beans = 20, cups = 1)) return
                        waterInStock -= 350
                        milkInStock -= 75
                        coffeeInStock -= 20
                        cupsInStock -= 1
                        cash += 7
                    }
            "3" -> {
                    if (!isEnoughIngredients(water = 200, milk = 100, beans = 12, cups = 1)) return
                        waterInStock -= 200
                        milkInStock -= 100
                        coffeeInStock -= 12
                        cupsInStock -= 1
                        cash += 6
                }
            "back" -> return
        }
        println()
    }

    fun fill() {
        println("Write how many ml of water you want to add:")
        waterInStock += readln().toInt()
        println("Write how many ml of milk you want to add:")
        milkInStock += readln().toInt()
        println("Write how many ml of coffee beans you want to add:")
        coffeeInStock += readln().toInt()
        println("Write how many disposable cups you want to add:")
        cupsInStock += readln().toInt()
        println()
    }

    fun take() {
        println("I gave you $$cash")
        cash -= cash
        println()
    }

    fun printRemaining() {
        println("""
        The coffee machine has:
        $waterInStock ml of water
        $milkInStock ml of milk         
        $coffeeInStock g of coffee beans
        $cupsInStock disposable cups
        $$cash of money
    """.trimIndent())
        println()
    }
}
   