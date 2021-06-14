package com.perschols.cafe;

import java.util.Scanner;

public abstract class Product {

	private String name;
	private double price;
	private String description;
	private int quantity;
	private double subTotal = 0;

	public Product() {
	}

	public Product(String name, double price, String description) {
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double d) {
		this.price = d;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public abstract double calculateProductTotal();

	public abstract void addOptions();

	public abstract void printOptions();

	public String getYesOrNo() {
		Scanner selectionScanner = new Scanner(System.in);
		String selection = selectionScanner.nextLine();
		while (!"y".equalsIgnoreCase(selection) && !"n".equalsIgnoreCase(selection)) {
			System.out.println("Please enter a valid option (Y = Yes  &  N = No)\n");
			System.out.println("Enter your Option: ");
			selection = selectionScanner.nextLine();
		}
		return selection;
	}

	public int getQuantityFromUser() {
		Scanner selectionScanner = new Scanner(System.in);
		System.out.println("\nEnter Quantity : ");
		int quantity = getIntegerSelectionFromString(selectionScanner.nextLine());
		while (quantity == -1) {
			System.out.println("\nPlease enter a valid quantity (It should be a number).\n");
			System.out.println("Enter Quantity : ");
		}
		return quantity;
	}

	private int getIntegerSelectionFromString(String str) {
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			return -1;
		}
	}

	public void printProductOptions() {
		System.out.println("\nItem : " + this.getName() + "\t\tSubtotal : " + this.calculateProductTotal());
		System.out.println("   Price\t: " + this.getPrice());
		System.out.println("   Quantity\t: " + this.getQuantity());
	}

	public String getYesOrNo(boolean opted) {
		return opted ? "Yes" : "No";
	}
}
