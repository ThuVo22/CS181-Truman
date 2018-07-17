/* Thu Vo
 * CS 181
 * 02/23/18
 * This program is to maintain the balance of a checking account.  
 * The program will allow the user to enter an initial balance, and then prompt
 * them for additional transactions.
 */
import java.util.Scanner;

public class AccountBalance {
 // Constants for service charge and additional fee
 public static final double SERVICE_CHARGE = 0.10;
 public static final double ADDITIONAL_FEE = 0.50;
 // Constant for the limit of free withdrawals
 public static final int ATM_SERVICE_CHARGE = 3;
 // Constants for the deposit command
 public static final String DEPOSIT_LETTER = "d";
 public static final String DEPOSIT_WORD = "dep";
 // Constants for the check command
 public static final String CHECK_LETTER = "c";
 public static final String CHECK_WORD = "check";
 // Constants for the withdrawal command
 public static final String ATM_LETTER = "a";
 public static final String ATM_WORD = "atm";
 
 //Constant for the exit command
 public static final String EXIT = "exit";
 
 /* This main program demonstrates input and output. They include
  * the initial balance and calculations of the user's requests
  */
 public static void main(String[] args) {
  double newBalance = 0.0;
  double amount;
  int count =0;
  String transType;
  // Attach the scanner to the input stream.
  Scanner input = new Scanner(System.in);
  System.out.print("Enter initial balance: ");
  // Prompt user for the initial balance.
  double initialBalance = input.nextDouble();
  do {
   System.out.printf("\nEnter transaction: ");
   //Prompt user for the transaction type.
   transType = input.next();
   
   if(!transType.equalsIgnoreCase(EXIT) ) {
   amount = input.nextDouble();
   if(transType.equalsIgnoreCase(DEPOSIT_LETTER) || 
      transType.equalsIgnoreCase(DEPOSIT_WORD)) {
    /* Calculate for the deposit request by adding the new 
     * amount to the current balance
    */
    initialBalance += amount;
    
   }if(transType.equalsIgnoreCase(CHECK_LETTER) ||
       transType.equalsIgnoreCase(CHECK_WORD)){
    System.out.printf("Service charge: $%4.2f \n", SERVICE_CHARGE );
    // Calculate for the check request including the service fee
    initialBalance = initialBalance - SERVICE_CHARGE - amount;
    
   }if(transType.equalsIgnoreCase(ATM_LETTER) ||
       transType.equalsIgnoreCase(ATM_WORD )) {
    /* Calculate for the withdraw request by subtracting the initial
     * balance by the amount.
    */
    initialBalance -= amount;
    count++;
    if(count >= ATM_SERVICE_CHARGE) {
     /*Calculate for the new balance of the third time or more 
      * withdrawals, which included the additional fee.
     */
     System.out.printf("Additional ATM charge: $%4.2f \n", ADDITIONAL_FEE);
     initialBalance = initialBalance- ADDITIONAL_FEE;
    }
    
    /* Because of the use of "next()". It will take any tokens that 
     * are typed. This "else if" statement is used to avoid the 
     * incorrect tokens.
    */
   }else if(!(transType.equalsIgnoreCase(DEPOSIT_LETTER) 
     || transType.equalsIgnoreCase(DEPOSIT_WORD)
     || transType.equalsIgnoreCase(CHECK_LETTER) 
     || transType.equalsIgnoreCase(CHECK_WORD)
     || transType.equalsIgnoreCase(ATM_LETTER) 
     || transType.equalsIgnoreCase(ATM_WORD ))){
    break;
   }
   
   // Assign the initial balance to the new balance
   newBalance = initialBalance;
  
   /*  Print out the warning if the balance above $0 and below $10. 
    *  Print out the warning if the balance below $0. Print out the
    *  balance for every other commands. 
    */
   if(newBalance>=0 && newBalance<=10) {
    System.out.printf("New Balance: $%5.2f\n", newBalance);
    System.out.println("Warning: Low Balance");
   }else if(newBalance<0 ) {
    System.out.println("You are overdrawn!");
    System.out.printf("New Balance: $%5.2f\n", newBalance);
   }else {
    System.out.printf("New Balance: $%5.2f\n", newBalance);
   }
   }
   // Execute the loop when the user type "exit"
  }while(!transType.equalsIgnoreCase(EXIT));
  // // Print out the final balance after all the transactions.
  System.out.printf("Final Balance: $%4.2f", newBalance);
}
}
