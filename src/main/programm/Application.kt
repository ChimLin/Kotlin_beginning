fun main() {
  var numberOfPurchasedTickets: Int = 0
  var percentage: Double = 0.0
  var currentIncome: Int = 0

  val all: MutableList<MutableList<String>> = mutableListOf<MutableList<String>>()
  val row: MutableList<String> = mutableListOf<String>(" ")

  val rowsSeats: MutableList<Int> = readLineFun("Enter the number of rows:", "Enter the number of seats in each row:")

  for(number in 1..rowsSeats[1]){
    row.add(number.toString())
  }
  all.add(row)

  var totalIncome: Int = if(rowsSeats[0] <=4){
    rowsSeats[0] * rowsSeats[1] * 10
  } else{
    4 * rowsSeats[1] * 10 + (rowsSeats[0] - 4) * rowsSeats[1] * 8
  }

  for(number in 1..rowsSeats[0]){
    var rest: MutableList<String> = mutableListOf<String>()
    rest.add(number.toString())
    repeat(rowsSeats[1]){
      rest.add("S")
    }
    all.add(rest)
  }

  while(true){
     showOptions()
     when(readLine()!!.toInt()) {
       0 -> break
       1 -> {println("Cinema:")
            printAllValue(all)
            println()
            }
       2 -> {while(true){
              var rowSeat: MutableList<Int> = readLineFun("Enter a row number:", "Enter a seat number in that row:")
              if(rowSeat[0] > rowsSeats[0] || rowSeat[1] > rowsSeats[1]){
                println("Wrong input!")
                println()
                continue
              }else if(all[rowSeat[0]][rowSeat[1]] == "B"){
              println("That ticket has already been purchased!")
              println()
              continue
            } else{
              numberOfPurchasedTickets++
              percentage = (numberOfPurchasedTickets.toDouble()/(rowsSeats[0] * rowsSeats[1])) * 100
              all[rowSeat[0]][rowSeat[1]] = "B"
              if(rowSeat[0] <= 4 ) {
              println("Ticket price: $10")
              currentIncome += 10

            } else {
              println("Ticket price: $8")
              currentIncome += 8
            }
              break
            }
            }


            println()
            }
        3 -> showStatistics(numberOfPurchasedTickets, percentage ,currentIncome, totalIncome)
     }
  }

/*  println("Cinema:")
  printAllValue(all)
  println()


  var rowSeat: MutableList<Int> = readLineFun("Enter a row number:", "Enter a seat number in that row:")
  all[rowSeat[0]][rowSeat[1]] = "B"

  if(rowSeat[0] <= 4 ) {
    println("Ticket price: $10")
  } else {
    println("Ticket price: $8")
  }
  println()

  println("Cinema:")
  printAllValue(all)
  println()*/

}

fun readLineFun(rows: String, seats: String): MutableList<Int>{
  println(rows)
  val rows = readLine()!!.toInt()
  println(seats)
  val seats = readLine()!!.toInt()
  println()
  return mutableListOf<Int>(rows, seats)
}

fun printAllValue(all: MutableList<MutableList<String>>){
   for(stringArr in all){
    println(stringArr.joinToString(" "))
  }
}

fun showOptions() {
  println("""1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit""")
}

fun showStatistics(tickets: Int, perc: Double, income: Int, tInc: Int){
  val percantage = "%.2f".format(perc) + "%"
  println("Number of purchased tickets: $tickets")
  println("Percentage: $percantage")
  println("Current income: $$income")
  println("Total income: $$tInc")
  println()
}
