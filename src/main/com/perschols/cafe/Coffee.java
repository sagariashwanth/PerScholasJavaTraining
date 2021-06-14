package com.perschols.cafe;

import java.util.Scanner;

public class Coffee extends Product {

	private boolean sugar;
	private boolean milk;

	public Coffee() {
		this("Coffee", 3.49, 
			 "Coffee provides a complex blend of different flavours, which together produce a range of sensory experiences.",
			 false, false);
	}

	public Coffee(String name, double price, String description, boolean milk, boolean sugar) {
		super(name, price, description);
		this.milk = milk;
		this.sugar = sugar;
	}

	public boolean isSugar() {
		return sugar;
	}

	public void setSugar(boolean sugar) {
		this.sugar = sugar;
	}

	public boolean isMilk() {
		return milk;
	}

	public void setMilk(boolean milk) {
		this.milk = milk;
	}

	@Override
	public double calculateProductTotal() {
		return getPrice() * getQuantity();
	}

	@Override
	public void addOptions() {
		System.out.println("\nWould you like to add Sugar with your Coffee (Y / N)?	");
		String sugarOption = getYesOrNo();
		sugar = "y".equalsIgnoreCase(sugarOption);
		
		System.out.println("\nWould you like to add Milk (Y / N)?	");
		String milkOption = getYesOrNo();
		milk = "y".equalsIgnoreCase(milkOption);
		
		setQuantity(getQuantityFromUser());
	}

	@Override
	public void printOptions() {
		printProductOptions();
		System.out.println("   Sugar\t: " + getYesOrNo(isSugar()));
		System.out.println("   Milk\t\t: " + getYesOrNo(isMilk()));
	}
}
