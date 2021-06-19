object harvestProblem{
    // calender monthe 2-d array
    var calenderArray = Array.ofDim[Int](5, 7)
    // calender day order
    val dayOrder = Array("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    val dayOrderShort = Array("MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN")

    //initialization
    def initialize():Unit={
        for(i <- 0 until 5){
            for(j <- 0 until 7){
                calenderArray(i)(j) = 0
            }
        }
    }

    //displaying the calender month
    def displayCal():Unit={
        println("#\t\tCalender\t\t#\n")
        for(i <- 0 until 7){
            print(dayOrderShort(i) + "\t")
        }

        print("\n")

        for(i <- 0 until 5){
            for(j <- 0 until 7){
                print(calenderArray(i)(j) + "\t")
            }
            print("\n")
        }

        print("\n")
    }

    // adding data to the calender array
    def addData():Unit={
        print("please enter the calender date : ")
        var calDate = scala.io.StdIn.readInt()

        if(calDate > 31) {
            print("invalid date !")
        }
        else{
            var weekDay = calDate % 7   // act as a column
            var week = calDate / 7      // act as a row
            
            if(weekDay==0)
                weekDay=7
            
            print("please enter the tea amount(kg) you plucked : ")
            var amount = scala.io.StdIn.readInt()
            calenderArray(week)(weekDay-1) = amount   // adding amount to the calender position
        }
        print("\n")
    }

    //find the max amount
    var maxAmount = 0
    def max():Unit={
        var posI = 0
        var posJ = 0
        var dayCount = 0

        for(i <- 0 until 5){
            for(j <- 0 until 7){
                if(calenderArray(i)(j) > maxAmount){
                    maxAmount = calenderArray(i)(j)
                    posI = i
                    posJ = j
                    dayCount = dayCount + 1
                }
            }
        }

        println("You have the max amount " + maxAmount + "kg at week" + (posI + 1) + " and the day " + dayCount + " (" + dayOrder(posJ) + ")")
    }

    //find the max amount
    var minAmount = 0
    def min():Unit={        
        var posI = 0
        var posJ = 0
        var dayCount = 0

        for(i <- 0 until 5){
            for(j <- 0 until 7){
                if(calenderArray(i)(j) < minAmount){
                    minAmount = calenderArray(i)(j)
                    posI = i
                    posJ = j
                    dayCount = dayCount + 1
                }
            }
        }

        println("You have the min amount " + minAmount + "kg at week" + (posI + 1) + " and the day " + dayCount + " (" + dayOrder(posJ) + ")")
    }

    //fint the range
    var rng = 0
    def range():Unit={
        rng = maxAmount - minAmount
        println("The range of " + minAmount + "kg to " + maxAmount + "kg is " + rng + "kg")
    }

    //find the average
    var avg = 0
    var total = 0
    def average():Unit={
        for(i <- 0 until 5){
            for(j <- 0 until 7){
                total = total + calenderArray(i)(j)
            }
        }

        avg = total / 31
        println("The average is " + avg + "kg")
    }

    //find the median
    var med = 0
    def median():Unit={
        var data = new Array[Int](35)               //with including 0 values
        var pos = 0

        // generate a linear 1-d array
        for(i <- 0 until 5){
            for(j <- 0 until 7){
                data(pos) =  calenderArray(i)(j)
                pos = pos + 1
            }
        }

        var filteredData = new Array[Int](35)       //without including 0 values
        var filteredDataPos = 0
        var filteredDataAmount = 0
        for(i <- 0 until 35){
            filteredData(i) = 0                //initialization
        }

        for(i <- 0 until 35){
            if(data(i) > 0){
                filteredData(filteredDataPos) = data(i)      //filtering
                filteredDataPos = filteredDataPos + 1
                filteredDataAmount = filteredDataAmount + 1
            }
        }

        //reverse sort that array
        scala.util.Sorting.quickSort[Int](filteredData)(Ordering.Int.reverse)     

        if(filteredDataAmount % 2 == 1){
            med = filteredData(filteredDataAmount/2)                                                                     //if we have odd amount then take the middle one directly 
        }
        else{
            med = (filteredData((filteredDataAmount/2) - 1) + filteredData((filteredDataAmount/2) - 1))/2     //if we have even amount then we take two middle elements and take the average 
        }

        println("The median is " + med + "kg") //because 31 days hence 31 amounts (15)+1+(15) hence 16 is the median position
    }

    //display detailed report
    def report():Unit={
        displayCal()
        max()
        min()
        range()
        average()
        median()
    }

    def main(args:Array[String]):Unit={
        initialize()

        var T = true
        while(T){
            println("\n\tTEA HARVEST SYSTEM")
            println("1. Add data")
            println("2. Display detailed report")
            println("3. Display calender")
            println("4. Display max amount")
            println("5. Display min amount")
            println("6. Display range")
            println("7. Display average")
            println("8. Display median")
            println("9 EXIT")
            print("please enter your option -> ")
            var opt = scala.io.StdIn.readInt()

            opt match{
                case 1 => addData()
                case 2 => report()
                case 3 => displayCal()
                case 4 => max()
                case 5 => min()
                case 6 => range()
                case 7 => average()
                case 8 => median()
                case 9 => T = false
                case _ => println("INVALID OPTION !")
            }
        }
    }
}
