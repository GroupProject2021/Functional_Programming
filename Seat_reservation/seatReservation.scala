object seatReservation {
    var seatArray = Array.ofDim[Int](4, 100)

    //Initialization of the seat 2-d array
    def initializeSeats():Unit = {
        for(i <- 0 until 4){
            for(j <- 0 until 100){
                seatArray(i)(j) = 0     //Initial values are 0 indicates empty seats
            }
        }
    }

    //Print the content of the seat 2-d array
    def showSeats():Unit = {
        println("\n seat order ")
        for(i <- 0 until 4){
            for(j <- 0 until 100){
                print(seatArray(i)(j))
            }
            print("\n")
        }
    }

    def reserveSeat():Unit = {
        print("\tplease enter the suitable row for you -> ")
        var x = scala.io.StdIn.readInt()
        print("\tplease enter the suitable column for you -> ")
        var y = scala.io.StdIn.readInt()
        x = x - 1
        y = y - 1

        if(seatArray(x)(y) == 0){
            //seat can be reserved
            seatArray(x)(y) = 1     //reserved - 1
            println("Seat reserved succesfully !")
        }
        else
        {
            //seat can not be reserved
            println("This seat already reserved!")
        }
    }

    def freeSeat():Unit = {
        print("\tplease enter the row -> ")
        var x = scala.io.StdIn.readInt()
        print("\tplease enter the column -> ")
        var y = scala.io.StdIn.readInt()
        x = x - 1
        y = y - 1

        if(seatArray(x)(y) == 1)
        {
            //seat can be free
            seatArray(x)(y) = 0     //free - 0
            println("Seat free !")
        }
        else
        {
            println("This sear is free already!")
        }
    }


    def main(args:Array[String]):Unit = {
        initializeSeats()

        var T = true
        while(T)
        {
            println("\tAIR RESERVATION SYSTEM")
            println("1. Reserve a seat ")
            println("2. Free a seat")
            println("3. Show current seat orders")
            println("4. exit")
            print("enter your option -> ")
            var input = scala.io.StdIn.readInt()

            input match{
                case 1 => reserveSeat()
                case 2 => freeSeat()
                case 3 => showSeats()
                case 4 => T = false
                case _ => println("invalid option !!! ")
            }

            println("\n")
        }
    }
}