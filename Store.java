import java.util.*;
import java.text.DecimalFormat;

class Store{
  public static void println(String words){
    System.out.println(words);
    return;
  }

  public static void print(String words){
    System.out.print(words);
    return;
  }

  public static void main(String[] args){
    // define final variables and class instances

    final double BOOKPRICE = 9;
    final double MOVIEPRICE = 13.97;
    final double PEANUTPRICE = 1.72;

    final double SHIPPINGCOSTBOOKS = 0.95;
    final double MOVIESHIPPINGPERCENT = 0.04;
    final double SHIPPINGCOSTPEANUTS = 0.30;

    final double TAX = 0.072;

    Scanner in = new Scanner(System.in);
    Random rand = new Random();
    DecimalFormat fmt = new DecimalFormat("0.##");

    // create date & time

    int dateMonth = rand.nextInt(9) + 1;
    int dateDay = rand.nextInt(19) + 10;
    int timeHours =rand.nextInt(14) + 10;
    int timeMinutes = rand.nextInt(50) + 10;

    // Welcome
    println("");
    println("");
    println("Welcome to Steve's S-Mart Store!");
    println("");
    println("Your cashier today will be Bob.");
    println("");
    println("------------------------------------");
    println("");

    // gather purchase
    print("Number of books purchased: ");
    double numberBooks = in.nextDouble();

    println("");

    print("Number of movies purchased: ");
    double numberMovies = in.nextDouble();

    println("");

    double poundsPeanuts = 0;

    int valid = 0;

    while (valid == 0){
      print("Pounds of peanuts purchased: ");
       poundsPeanuts = in.nextDouble();

      println("");

      if (0 > poundsPeanuts || poundsPeanuts > 50.0){
        println("You can purchase no more than 50 lbs of peanuts. ");
      }
      else{
        valid = 1;
      }
    }



    // process input

    double preTotal = numberBooks*BOOKPRICE + numberMovies*MOVIEPRICE +
                      poundsPeanuts*PEANUTPRICE;

    double totalAndTax = preTotal*(1.0 + TAX);

    double shippingCost = numberBooks*SHIPPINGCOSTBOOKS +
                          numberMovies*MOVIEPRICE*MOVIESHIPPINGPERCENT +
                          poundsPeanuts*SHIPPINGCOSTPEANUTS;

    double totalTotal = totalAndTax + shippingCost;

    // print recipt

    println("----------------------------------------------");
    println("|            STEVE'S S-MART STORE             |");
    println("|                                             |");
    println("|             Your Chasier: Bob               |");
    println("|               "+dateMonth+"/"+dateDay+"/19"+" "+
             timeHours+":"+timeMinutes+"                 |"); //for date
    println("|                                             |");
    println("| "+(int) (numberBooks)+ " Books..................... "+fmt.format((double) (numberBooks*BOOKPRICE)));


  }
}
