object seatReservation {
  var seatArray = Array.ofDim[Int](16, 100)         //0-3 rows seat order in mathtala,4-7 rows seat order in katunayake
                                                    //8-11 rows seat order in dilhi, 12-15 rows seat order in mumbai

  //Initialization of the seat 2-d array
  def initializeSeats():Unit = {
    for(i <- 0 until 16){
      for(j <- 0 until 100){
        seatArray(i)(j) = 0    //Initial values are 0 indicates empty seats
      }
    }
  }

  //Print the content of the seat 2-d array
  def showSeats():Unit = {
    print("\n1.Maththala")
    print("\n2.Katunayake")
    print("\n3.Dilli")
    print("\n4.Mumbai")
    print("\nShow seat order in -> ")

    var input = scala.io.StdIn.readInt()
    println("\n seat order ")

    if (input < 1 || input > 4) {
      println("invalid option !!! ")
      return
    }
    input -= 1
    for (i <- (input * 4) until (input * 4) + 4) {
      for (j <- 0 until 100) {
        print(seatArray(i)(j))
      }
      print("\n")
    }
  }

  def reserveSeat():Unit = {
    print("\tplease enter the suitable row for you(max rows4) -> ")
    var x = scala.io.StdIn.readInt()
    print("\tplease enter the suitable column for you(max columns 100) -> ")
    var y = scala.io.StdIn.readInt()
    x = x - 1
    y = y - 1

    print("\n1.Maththala")
    print("\n2.Katunayake")
    print("\n3.Dilli")
    print("\n4.Mumbai")
    print("\n5.Chennai")
    print("\nbooking start from(enter no. of the city) -> ")
    var a = scala.io.StdIn.readInt()
    print("booking end(enter no. of the city) -> ")
    var b = scala.io.StdIn.readInt()

    if (a <= 0 || a > 5 || b <= 0 || b > 5) {
      print("\ninvalid option !!! ")
      return
    }
    a = a - 1
    b = b - 1

    //check seat is already reserved
    for (i <- a until b) {
      if (seatArray(4 * i + x)(y) == 1) {
        print("\nSeat already reserved. Can not reserve for you !")
        return
      }
    }
    //seat is not reserved already.can be reserved
    for (i <- a until b){
      seatArray(4 * i + x)(y) = 1  //reserved
    }
    print("\nSeat reserved successfully!")
  }

  def main(args:Array[String]):Unit = {
    initializeSeats()

    var T = true
    while(T)
    {
      println("\tAIR RESERVATION SYSTEM FROM MATHTHALA TO CHENNAI")
      println("1. Reserve a seat ")
      println("2. Show current seat orders")
      println("3. exit")
      print("enter your option -> ")
      var input = scala.io.StdIn.readInt()

      input match{
        case 1 => reserveSeat()
        case 2 => showSeats()
        case 3 => T = false
        case _ => println("invalid option !!! ")
      }
      println("\n")
    }
  }
}
