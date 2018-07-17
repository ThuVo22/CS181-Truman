/* Thu Vo
 * CS 181
 * 02/01/18
 * The program is used to analyze the cost of ownership of two different
 * computers over a number of years.
 */
import java.util.Scanner;

public class ComputerCostCalculator {
  // Constants for electricity rates of each computer. 
 public static final double laptopElectricity = 0.006;
 public static final double computerElectricity = 0.015;
  // A constant for the battery price.
 public static final double BATTERY_COST = 300;
  // Constants for laptop and computer depreciation.
 public static final double LAPTOP_DEPRECIATION = 0.15;
 public static final double COMPUTER_DEPRECIATION = 0.20;
 
  /* The main program demonstrates input and output. They include the name 
   * of the laptop, the cost of the laptop, name of the computer and its cost,
   * the hours each computer will be used in a year and the number of years you
   * are planning to own it.
   */
 public static void main(String[] args) { 
   // Attach a scanner to the input stream.
  Scanner in = new Scanner(System.in);
   // Prompt user for each computer's name and its cost.
  System.out.println("Enter name of laptop computer: ");
  String nameOfLaptop = in.nextLine();
  System.out.println("Enter the cost of the " + nameOfLaptop + ": ");
  double costOfLaptop = in.nextDouble();
  in.nextLine(); 
  System.out.println("Enter name of desktop computer: " );
  String nameOfComputer = in.nextLine();
  System.out.println("Enter the cost of the " + nameOfComputer + ": ");
  double costOfComputer = in.nextDouble();
  
  // Prompt user for each computer's hours and years will be used.
  System.out.println("How many hours will each computer be used in a year? ");
  int hourOfUse = in.nextInt();
  System.out.println("How many years will you own each computer? ");
  int yearOfOwning = in.nextInt();

  /* This calculation part is used to calculate the final each computer's price
   * after they lose their values over time. It is calculated by the sum of the 
   * depreciation, the hours of use, the electricity, the years of owning and the
   * battery (for laptop only).
  */
  
  // The laptop battery needs to be replaced every 3 years.
  double batteryCostPerYear = BATTERY_COST * (yearOfOwning / 3);
  
  double finalLaptopPrice = (costOfLaptop * 
                            (1- Math.pow((1- LAPTOP_DEPRECIATION),
                            yearOfOwning)) + batteryCostPerYear + 
                            (hourOfUse * laptopElectricity * yearOfOwning));
  
  double finalComputerPrice = (costOfComputer *
                              (1- Math.pow((1- COMPUTER_DEPRECIATION),
                              yearOfOwning)) + (hourOfUse * computerElectricity *
                              yearOfOwning));
 
  /* Print the calculated prices of the laptop and computer. The output is
   * formatted with the printf method. The result will be a double and it 
   * has 7 spaces with 2 decimals. 
  */
  System.out.printf("\nCost of " + nameOfLaptop + " over " + 
                    yearOfOwning + " years is $%7.2f.\n", finalLaptopPrice);
  System.out.printf("Cost of " + nameOfComputer + " over " + 
                    yearOfOwning + " years is $%7.2f.\n", finalComputerPrice);
 }
}
