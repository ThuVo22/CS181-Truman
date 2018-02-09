import java.util.Scanner;

public class ComputerCostCalculator {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter name of laptop computer: ");
		String nameOfLaptop = in.nextLine();
		//in.nextLine();
		System.out.println("Enter the cost of the " + nameOfLaptop + ": ");
		double costOfLaptop = in.nextDouble();
		in.nextLine();
		System.out.println("Enter name of desktop computer: " );
		String nameOfComputer = in.nextLine();
		//in.nextLine();
		System.out.println("Enter the cost of the " + nameOfComputer + ": ");
		double costOfComputer = in.nextDouble();
		System.out.println("How many hours will each computer be used in a year? ");
		int hourOfUse = in.nextInt();
		System.out.println("How many years will you own each computer? ");
		int yearOfOwning = in.nextInt();
		final double LAPTOP_DEPRECIATION = 0.15;
		final double COMPUTER_DEPRECIATION = 0.20;
		double laptopElectricity = 0.006;
		double computerElectricity = 0.015;
		final int BATTERY_COST = 300;
		int batteryCostPerYear = BATTERY_COST * (yearOfOwning / 3);

		
		double finalLaptopPrice = (costOfLaptop * (1- Math.pow((1- LAPTOP_DEPRECIATION), yearOfOwning)) + batteryCostPerYear + (hourOfUse * laptopElectricity * yearOfOwning));
		
		double finalComputerPrice = (costOfComputer * (1- Math.pow((1- COMPUTER_DEPRECIATION), yearOfOwning)) + (hourOfUse * computerElectricity * yearOfOwning));
	

		System.out.printf("\nCost of " + nameOfLaptop + " over " + yearOfOwning + " years is $%7.2f.\n", finalLaptopPrice);
		System.out.printf("Cost of " + nameOfComputer + " over " + yearOfOwning + " years is $%7.2f.\n", finalComputerPrice);
	}

}
