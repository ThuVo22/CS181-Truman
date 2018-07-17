/* Thu Vo
 * CS 181
 * 04/13/18
 * This program allows the user to enter and then search 
 * a list of student names and grades.  The program will 
 * execute in two phases.  In the first phase, the user will
 * enter student name and grade pairs.  In the second phase,
 * the user will search this data for matching parts of names,
 * or matching grades.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class GradeDatabase{
 public static final String EXIT = "exit";
 public static final String DONE = "done";
 public static final String GRADE = "grade";
 public static final String NAME = "name";
 // NOT_FOUND equals to -1 if there is no typed letter in the name.
 public static final int NOT_FOUND = -1;
/* The main program is used to declare the variables
  * and to invoke the methods.
  */
 public static void main(String[] args) {
  Scanner in = new Scanner(System.in);
  
  //The ArrayList which stores the Student class
  ArrayList<Student> sList = new ArrayList<Student>();
  
  
  String sName="";
  char sGrade=' ';
  String query="";
  String target="";
  
  // invoke the method
  executeNameSearch( sName, sGrade, query, target, sList, in) ;
 } 
 
 
 /* The method is used to read the data of the students's names
  * and grades and let the users search the students's
  * names and grades. It will let the users know if the grades 
  * or students's names do exist or not.
  */ 
  public static void executeNameSearch(
    String sName,    // student names
    char sGrade,     // student grades
    String query,    // prompt user the query
    String target,   // the searching name  
    ArrayList<Student> sList,  // the ArrayList of student  
    Scanner in)      // input
  {

  
  System.out.println("Enter student names and grades, each on a separate lines.");
  System.out.println("Enter \"done\" when done");
    do{  
      sName = in.nextLine();
    
      if(!(sName.equals(DONE))) 
      {
        sGrade = in.nextLine().charAt(0);
        //Store sName and sGrade into the object reference 'a'
        Student a = new Student(sName, sGrade);
        sList.add(a); 
      }
    
    }while( !(sName.equals(DONE))); 
     
    do {
     System.out.println("Enter query (name, grade, or exit): ");
        // Prompt user the query (name, grade, or exit).
     
     query = in.next(); 
     
       if(query.equals(NAME)) 
        {
          System.out.println("Enter whole or partial name to search for: ");
          target = in.next();
          System.out.printf("           Name Grade\n--------------- "
                              + "-----\n");
       
          boolean isEqual = false;
          for(int i = 0; i < sList.size(); ++i ) 
          { 
           int wordCount = sList.get(i).getName().indexOf(target);  
           // WordCount equals to -1 if there is no substring in the name.
           if(!(wordCount == NOT_FOUND)) 
             {
               System.out.printf("%15s %5s\n", sList.get(i).getName(), 
                                 sList.get(i).getGrade());
               isEqual = true;
             }      
          
          }
          
          if(isEqual == false) 
          {
            System.out.printf("%15s %5s\n", "","");
          }  
        }
       
       if(query.equals(GRADE)) 
        {
          System.out.println("Enter grade to search for: ");
          String grade = in.next();
          /* The isEqual boolean is used to distinguish and print
           * out when there is no grade that the users look for.
           */
          boolean isEqual = false;
          System.out.printf("           Name Grade\n--------------- "
                              + "-----\n");
          for(int i = 0; i< sList.size(); ++i) 
          {
            if(grade.charAt(0)==(sList.get(i).getGrade())) 
            {
              System.out.printf("%15s %5s\n", sList.get(i).getName(),
                                sList.get(i).getGrade());
              isEqual = true;
            }
          }
          if(isEqual == false) 
          {
            System.out.printf("%15s %5s\n", "","");
          }
        }    
   }while(!(query.equals(EXIT)));      
 }
}
