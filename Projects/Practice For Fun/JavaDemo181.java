/* Access the Scanner class by importing it from the 
 *  java.util package. */
import java.util.Scanner;

/** Demonstrate input and output in a simple Java
  * program.
  */
public class JavaDemo181
{
  //A constant char declaration
  public static final char EXCLAMATION = '!';
  //Constant for age range
  public static final int YOUTHFUL = 17;
  public static final int MIDDLE_AGED =20;
  
  /** The main program
    * @param args ignored
    */
  public static void main (String [] args)
  {
    // Attach a scanner to the input stream.
    Scanner input = new Scanner (System.in);
    
    //Prompt user for name and age.
    System.out.println("Please enter your name.");
    String userName = input.nextLine();
    System.out.println("Please enter your age.");
    int userAge = input.nextInt();
    
    // Assemble greeting
    String greeting = "Hello " + userName + EXCLAMATION;
    
    // Assemble the age message.
    String ageComment;
    if (userAge <= YOUTHFUL) {
      ageComment = "youthful";
    } else if (userAge <= MIDDLE_AGED) {
      ageComment = "getting up there in years";
    } else {
      ageComment = "ancient";
    }
    String ageMessage ="According to your age, you are "
      + ageComment + EXCLAMATION;
    
    //Print greeting and age message.
    System.out.println (greeting);
    System.out.println (ageMessage);
  }
}

    
    
    
    
