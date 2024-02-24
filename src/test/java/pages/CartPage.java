package pages;

import org.openqa.selenium.By;

import resources.Reusable;

public class CartPage {
	
	public By btnAddToCart=By.id("add-to-cart-sauce-labs-backpack");
	public By btnCart=By.xpath("//div[@id='shopping_cart_container']/a");
	public By cartTitle=By.xpath("//div[@class='header_secondary_container']/span");
	public By btnCheckout=By.id("checkout");
	
	public By txtFirstName=By.id("first-name");
	public By txtLastName=By.id("last-name");
	public By txtPostalCode=By.id("postal-code");
	public By btnContinue=By.id("continue");
	
	public By btnFinish=By.id("finish");
	public By msgConfirOrder=By.xpath("//h2[@class='complete-header']");
	
	public String msgCartTitle="Your Cart";
	public String msgCheckoutTitle="Checkout: Your Information";
	public String msgCheckoutOverview="Checkout: Overview";
	
	public String msgCheckoutComplete="Checkout: Complete!";
	public String msgCompleteOrder="Thank you for your order!";
	
	public void addProductToCart() {
		try {
			Reusable.click(btnAddToCart);
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	public void goToCartPage() throws Exception {
		try {
			Reusable.click(btnCart);
			Reusable.compareMessages(Reusable.getText(cartTitle), msgCartTitle);
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	public void navigateToCheckoutPage() throws Exception {
		try {
			Reusable.click(btnCheckout);
			Reusable.compareMessages(Reusable.getText(cartTitle), msgCheckoutTitle);
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	public void checkout(String firstName, String lastName, String postalCode) {
		try {
			Reusable.sendKeys(txtFirstName, firstName);
			Reusable.sendKeys(txtLastName, lastName);
			Reusable.sendKeys(txtPostalCode, postalCode);
			Reusable.click(btnContinue);
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	public void validateOverviewPage() throws Exception {
		try {
			Reusable.compareMessages(Reusable.getText(cartTitle), msgCheckoutOverview);
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	public void completeOrder() throws Exception {
		try {
			Reusable.click(btnFinish);
			Reusable.compareMessages(Reusable.getText(cartTitle), msgCheckoutComplete);
			Reusable.compareMessages(Reusable.getText(msgConfirOrder), msgCompleteOrder);
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	
	

}
