package com.perschols.cafe;

public class Cappuccino extends Product {

	private boolean peppermint;
	private boolean whippedCream;

	public Cappuccino() {
		this("Cappuccino", 4.99,
				"A cappuccino is an Italian coffee drink that is traditionally prepared with equal parts double espresso, steamed milk, and steamed milk foam on top.",
				false, false);
	}

	public Cappuccino(String name, double price, String description, boolean peppermint, boolean whippedCream) {
		super(name, price, description);
		this.peppermint = peppermint;
		this.whippedCream = whippedCream;
	}

	public boolean isPeppermint() {
		return peppermint;
	}

	public void setPeppermint(boolean peppermint) {
		this.peppermint = peppermint;
	}

	public boolean isWhippedCream() {
		return whippedCream;
	}

	public void setWhippedCream(boolean whippedCream) {
		this.whippedCream = whippedCream;
	}

	@Override
	public double calculateProductTotal() {
		if (peppermint == true) {
			setPrice(getPrice() + 2.0);
		}
		if (whippedCream == true) {
			setPrice(getPrice() + 1.0);
		}

		return getPrice() * getQuantity();
	}

	@Override
	public void addOptions() {
		System.out.println("\nWould you like to add PepperMint for $2 (Y / N)?	");
		String peppermintOption = getYesOrNo();
		peppermint = "y".equalsIgnoreCase(peppermintOption);
		
		System.out.println("\nWould you like to add Whipped Cream for $1 (Y / N)?	");
		String whippedCreamOption = getYesOrNo();
		whippedCream = "y".equalsIgnoreCase(whippedCreamOption);
		
		setQuantity(getQuantityFromUser());
	}

	@Override
	public void printOptions() {
		printProductOptions();
		System.out.println("   Pepper Mint    (Add $2.00) : " + getYesOrNo(isPeppermint()));
		System.out.println("   Whipped Cream  (Add $1.00) : " + getYesOrNo(isWhippedCream()));
	}

}
