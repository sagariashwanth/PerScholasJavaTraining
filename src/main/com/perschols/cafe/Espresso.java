package com.perschols.cafe;

public class Espresso extends Product {

	private boolean extraShot;
	private boolean macchiato;

	public Espresso() {
		this("Espresso", 3.99, "Espresso is a full-flavored, concentrated form of coffee that is served in shots.",
				false, false);
	}

	public Espresso(String name, double price, String description, boolean macchiato, boolean extraShot) {
		super(name, price, description);
		this.macchiato = macchiato;
		this.extraShot = extraShot;
	}

	public boolean isExtraShot() {
		return extraShot;
	}

	public void setExtraShot(boolean extraShot) {
		this.extraShot = extraShot;
	}

	public boolean isMacchiato() {
		return macchiato;
	}

	public void setMacchiato(boolean macchiato) {
		this.macchiato = macchiato;
	}

	@Override
	public double calculateProductTotal() {
		if (extraShot) {
			setPrice(getPrice() + 2.0);
		}
		if (macchiato) {
			setPrice(getPrice() + 1.0);
		}

		return getPrice() * getQuantity();
	}

	@Override
	public void addOptions() {
		System.out.println("\nWould you like to add Extra shot for $2 (Y / N)?	");
		String extraShotOption = getYesOrNo();
		extraShot = "y".equalsIgnoreCase(extraShotOption);
		
		System.out.println("\nWould you like to add Macchiato for $1 (Y / N)?	");
		String macchiatoOption = getYesOrNo();
		macchiato = "y".equalsIgnoreCase(macchiatoOption);
		
		setQuantity(getQuantityFromUser());
	}

	@Override
	public void printOptions() {
		printProductOptions();
		System.out.println("   Extra Shot (Add $2.00) : " + getYesOrNo(isExtraShot()));
		System.out.println("   Macchiato  (Add $1.00) : " + getYesOrNo(isMacchiato()));
	}

}
