package vendingMachineGroupProject;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

/*
 * GROUP PROJECT: Allen, John, Lisa, Monique, Tracey
 * This vending machine application is designed to 
 * Provide information about vending machine selection
 * Prompt the user to make a selection
 * Give proper response according to user-submitted information
 * Ask  the user to take their selection
 * User will have the option to make another selection.
 */
public class VendingMachine {

	public static void main(String[] args) {
		// Number Format ensures that a number entered is converted to a dollar
		// amount
		NumberFormat formatter = new DecimalFormat("#.00");
		// Scanner allows for input
		Scanner scan1 = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		// Declares the 9 element array
		TestClass[] array = new TestClass[9];

		double change = 0;
		int i = 0;
		double money = 0;

		String choice = null;
		String choice2 = null;
		String selection = null;

		for (i = 0; i < 9; i++) {

			array[i] = new TestClass();
		}
		// Set the item choices for each array element and the corresponding
		// prices
		array[0].setItemName("Snickers");
		array[0].setPrice(1.00);
		array[0].setLocation("A1");
		array[1].setItemName("Kit Kat");
		array[1].setPrice(1.00);
		array[1].setLocation("A2");
		array[2].setItemName("Twix");
		array[2].setPrice(1.00);
		array[2].setLocation("A3");
		array[3].setItemName("Trail Mix");
		array[3].setPrice(1.50);
		array[3].setLocation("B1");
		array[4].setItemName("Crunch");
		array[4].setPrice(1.50);
		array[4].setLocation("B2");
		array[5].setItemName("Milky Way");
		array[5].setPrice(1.50);
		array[5].setLocation("B3");
		array[6].setItemName("Hershey");
		array[6].setPrice(1.00);
		array[6].setLocation("C1");
		array[7].setItemName("Oh Henry");
		array[7].setPrice(1.00);
		array[7].setLocation("C2");
		array[8].setItemName("Cheetos");
		array[8].setPrice(2.00);
		array[8].setLocation("C3");

		System.out.println("Welcome to the Grand Circus Vending Machine!");
		System.out.println("");

		System.out.print("Would you like to use the Vending Machine:(y/n)");
		choice = scan1.nextLine();

		if (choice.equalsIgnoreCase("y")) {
			System.out.println("");
			System.out.println("How many dollars would you like to use:(Enter an amount))");
			int index = 0;
			money = index = validateFormat(scan1);

		}
		if (choice.equalsIgnoreCase("n")) {
			System.out.println("Get a Job!");
			return;
		}
		while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")) {
			System.out.println("");
			System.out.println("You have been drinking! Try again please!");
			System.out.println("");
			System.out.print("Would you like to use the Vending Machine:(y/n)");
			choice = scan1.nextLine();

			System.out.println("");
			System.out.println("How many dollars would you like to use:(Enter an amount)");
			money = scan1.nextDouble();
		}

		do {
			// This condition will ensure that an acceptable money amount is
			// enter, if correct the user will
			// be allowed to continued. If it is 0 or less, an error message
			// will display
			if (money <= 0) {
				System.out.println("You dont you have any money!");
				System.out.println("Please get some money!(Enter amount)");
				money = scan1.nextDouble();
			}
			// Displays the menu items with item numbers and prices
			System.out.println("");
			System.out.println("           ///////////////////////////////////////////////////////////////////");
			System.out.println("           || Snickers 1.00 A1   || Kit Kat 1.00 A2  ||   Twix 1.00 A3      ||");
			System.out.println("           || Trail Mix 1.50 B1  || Crunch 1.50 B2   ||   Milky Way 1.50 B3 ||");
			System.out.println("           || Hershey 1.00 C1    || Oh Henry 1.00 C2 ||   Cheetos 2.00 C3   ||");
			System.out.println("           ///////////////////////////////////////////////////////////////////");
			System.out.println("");
			System.out.println(
					"You have $" + formatter.format(money) + ". What would you like to purchase?(Enter Item Number)");
			selection = scan2.nextLine();
			selection = validateSelection(scan2, selection);

			for (i = 0; i < 9; i++) {

				if (array[i].getLocation().equalsIgnoreCase(selection)) {

					change = money - array[i].getPrice();
					if (money < array[i].getPrice()) {
						System.out.println("You can not afford this item please make another selection!");
						selection = scan2.nextLine();
						selection = validateSelection(scan2, selection);
					}

					System.out.println("You purchased " + array[i].getItemName() + ". You have $"
							+ formatter.format(change) + " left over.");

					break;
				}
			}

			System.out.print("Would you like to make another selection?(y/n): ");
			choice2 = scan1.next();

			System.out.println("");

			money = change;

		} while (choice2.equalsIgnoreCase("y"));

		if (choice2.equalsIgnoreCase("n") || (!choice2.equalsIgnoreCase("n"))) { ///////
			System.out.println("You have $" + formatter.format(change) + " left.");
			System.out.println("Goodbye. Enjoy your " + array[i].getItemName() + "!");
		}
	}

	// This method validates that the correct format is used, if correct the
	// user will be allowed to continue
	// if not an error message will display
	public static int validateFormat(Scanner scan1) {
		int index;
		while (!scan1.hasNextInt()) {
			System.out.println("The input is not in a valid format!, please try again.");
			System.out.println("How many dollars would you like to use:(Enter an amount)");
			scan1.nextLine();
		}

		index = scan1.nextInt();
		scan1.nextLine();
		return index;
	}

	// This method validates that the selected item exists. If it does, the user
	// will be allowed to continue.
	// If not, an error message will display
	public static String validateSelection(Scanner scan2, String selection) {

		while (!selection.equalsIgnoreCase("A1") && !selection.equalsIgnoreCase("A2")
				&& !selection.equalsIgnoreCase("A3") && !selection.equalsIgnoreCase("B1")
				&& !selection.equalsIgnoreCase("B2") && !selection.equalsIgnoreCase("B3")
				&& !selection.equalsIgnoreCase("C1") && !selection.equalsIgnoreCase("C2")
				&& !selection.equalsIgnoreCase("C3")) {
			System.out.println("That data does not exist. Please try again.");
			System.out.println("Enter a selection please.");
			selection = scan2.nextLine();
			selection = validateSelection(scan2, selection);
		}
		return selection;
	}
}
