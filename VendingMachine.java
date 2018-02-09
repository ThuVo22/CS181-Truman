import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		final int PENNIES_IN_DOLLAR = 100;
		final int PENNIES_PER_QUARTER = 25;
		final int PENNIES_PER_DIME = 10;
		final int PENNIES_PER_NICKEL = 5;
		
		System.out.println("Enter bill value (1 = $1 bill, 5 = $5 bill, ect.): ");
		int billValue = in.nextInt();
		System.out.println("Enter item price in pennies: ");
		int itemPrice = in.nextInt();
		
		// Compute
		int changeDue = PENNIES_IN_DOLLAR * billValue -itemPrice;
		System.out.println("change :" + changeDue);
		int quarters = changeDue / PENNIES_PER_QUARTER;
		System.out.println(quarters);
		changeDue = changeDue % PENNIES_PER_QUARTER;
		System.out.println(changeDue);
		int dimes =0, nickels =0;
		//int nickels = changeDue / PENNIES_PER_NICKEL;
		System.out.println("change1 :" + changeDue);

		if(changeDue% PENNIES_PER_QUARTER != 0) {
			if(changeDue > PENNIES_PER_DIME ) {
				 dimes = changeDue/PENNIES_PER_DIME;
				 changeDue = changeDue %  PENNIES_PER_DIME;
			}
			if (changeDue >0 ) {
				 nickels = changeDue/ PENNIES_PER_NICKEL;
			}
			
		}
		
		//Print
		System.out.printf("Quarter: %6d\n", quarters);
		System.out.printf("Dimes: %6d\n", dimes);
		System.out.printf("Nickels: %6d\n", nickels);
	}

}
