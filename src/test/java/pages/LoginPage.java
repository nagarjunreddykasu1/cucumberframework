package pages;

import org.openqa.selenium.By;

import resources.Reusable;

public class LoginPage {
	
	
	public By username=By.id("user-name");
	public By password=By.id("password");
	public By btnLogin=By.id("login-button");
	public By errorMessage=By.xpath("//h3[@data-test='error']");
	
	String expectedMessage="Epic sadface: Username and password do not match any user in this service";
	
	
	public void validateURL(String page) throws Exception {
		try {
			if(Reusable.getCurrentUrl().contains(page)) {
				System.out.println("User is logged in");
			}
			else {
				System.out.println("There is an issue with login details. Please check credentials");
				throw new Exception("There is an issue with login details. Please check credentials");
			}
		}
		catch(Exception e) {
			throw e;
		}
		
	}
	
	public void validateErrorMessage() throws Exception {
		try {
			String actualMessage=Reusable.getText(errorMessage);
			Reusable.compareMessages(actualMessage, expectedMessage);
		}
		catch(Exception e) {
			throw e;
		}
		
	}
	

}
