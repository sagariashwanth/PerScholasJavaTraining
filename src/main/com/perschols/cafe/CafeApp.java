package com.perschols.cafe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CafeApp {

	private static List<Product> products	= new ArrayList<>();
	private static final String CHECKOUT  	= "checkout";
	private static final String EXIT 	  	= "exit";
	private static final String PRODUCT_SELECTED = "productSelected";

	public static void main(String[] args) throws Exception {

		System.out.println("******************************************");
		System.out.println("*       Welcome to Sagari's Cafe!!       *");
		System.out.println("******************************************");

		String decision = handleSelection(printAndGetSelection());
		while (PRODUCT_SELECTED.equals(decision)) {
			System.out.println("\nDo you like to add more to your cart (Y/N)?	");
			String likeToAddMore = getYesOrNo();
			if ("n".equalsIgnoreCase(likeToAddMore)) {
				break;
			} else if ("y".equalsIgnoreCase(likeToAddMore)) { 
				decision = handleSelection(printAndGetSelection());
			}
		}
		
		double purchaseSubtotal = 0;
		if (!EXIT.equals(decision) && ! products.isEmpty()) {
			for (Product product : products) {
				product.printOptions();
				purchaseSubtotal = purchaseSubtotal + product.calculateProductTotal();
			}
			System.out.println("Purchase Subtotal	: " + purchaseSubtotal);
			System.out.println("Sales Tax		: " + (purchaseSubtotal * 0.1));
			System.out.println("Purchase Total		: " + (purchaseSubtotal * 1.1));
		}
		
		System.out.println("\n Thank you for choosing our Cafe! We like to see you soon.");
	}

	private static void printCafeOptions() {
		System.out.println("\nPlease select from the following menu\n");
		System.out.println("1 :	Coffee");
		System.out.println("2 :	Cappuccino");
		System.out.println("3 :	Expresso");
		System.out.println("4 :	Check Out");
		System.out.println("5 :	Exit");
	}

	private static int getSelection() {
		int selection;
		Scanner selectionScanner = new Scanner(System.in);

		System.out.println("\nEnter your selection : ");
		String selectionStr = selectionScanner.nextLine();

		try {
			selection = Integer.parseInt(selectionStr);
			if (1 <= selection && selection <= 5) {
				return selection;
			} else {
				return -1;
			}
		} catch (Exception e) {
			return -1;
		}
	}

	private static int printAndGetSelection() {
		printCafeOptions();

		int selection;
		selection = getSelection();
		while (selection == -1) {
			System.out.println("\nInvalid selection! Please enter a valid selection from the above menu options.\n");
			selection = getSelection();
		}

		return selection;
	}

	private static String handleSelection(int selection) throws Exception {
		Product product = null;
		if (1 == selection) {
			product = new Coffee();
		} else if (2 == selection) {
			product = new Cappuccino();
		} else if (3 == selection) {
			product = new Espresso();
		} else if (4 == selection) {
			if (products.isEmpty()) {
				System.out.println("No items added to the Cart!");
			}
			return CHECKOUT;
		} else if (5 == selection) {
			return EXIT;
		} else {
			throw new Exception("Incorrect Selection!!");
		}

		product.addOptions();
		products.add(product);
		return PRODUCT_SELECTED;
	}

	private static String getYesOrNo() {
		Scanner selectionScanner = new Scanner(System.in);
		String selection = selectionScanner.nextLine();
		while (!"y".equalsIgnoreCase(selection) && !"n".equalsIgnoreCase(selection)) {
			System.out.println("Please enter a valid option (Y = Yes  &  N = No)\n");
			System.out.println("Enter your option: ");
			selection = selectionScanner.nextLine();
		}
		return selection;
	}

	/*
	 * System.out.println("Enter the quantity of coffee required: ");
	 * coffee.setQuantity( user_input.nextInt());
	 * System.out.println(coffee.getDescription());
	 * System.out.println(coffee.getName());
	 * System.out.printf("the subtotal of your purchas is : %.2f",coffee.
	 * calculateProductTotal());
	 * 
	 * 
	 * System.out.println("Enter the quantity of espresso required: ");
	 * espresso.setQuantity(user_input.nextInt());
	 * System.out.println(espresso.getDescription());
	 * System.out.println(espresso.getName());
	 * System.out.printf("the subtotal of your purchas is :%.2f ",espresso.
	 * calculateProductTotal());
	 * 
	 * System.out.println("Enter the quantity of coffee required: ");
	 * cappuccino.setQuantity(user_input.nextInt());
	 * System.out.println(cappuccino.getDescription());
	 * System.out.println(cappuccino.getName());
	 * System.out.printf("the subtotal of your purchas is: %.2f",cappuccino.
	 * calculateProductTotal());
	 */

}
