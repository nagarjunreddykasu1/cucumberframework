package steps;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import resources.Reusable;

public class Login {
	
	public LoginPage login;

	@Given("I launch the application in {word} browser")
	public void i_launch_the_application(String browser) throws IOException, ClassNotFoundException {
	    Reusable.launchApp(browser, Reusable.getConfig().getProperty("URL"));
	    login=new LoginPage();
	}
	
	@When("I enter valid user name and password")
	public void i_enter_valid_user_name_and_password(DataTable table) throws ClassNotFoundException {
		List<Map<String, String>> list=table.asMaps(String.class, String.class);
		Reusable.sendKeys(login.username, list.get(0).get("username"));
		Reusable.sendKeys(login.password, list.get(0).get("password"));
	}
	
	@And("I enter invalid user name and password")
	public void i_enter_invalid_user_name_and_password(DataTable table) throws ClassNotFoundException {
		List<Map<String, String>> list=table.asMaps(String.class, String.class);
		Reusable.sendKeys(login.username, list.get(0).get("username"));
		Reusable.sendKeys(login.password, list.get(0).get("password"));
	}
	
	@And("I click on Login button")
	public void click_on_login_button() throws ClassNotFoundException {
		Reusable.click(login.btnLogin);
	    System.out.println("clicked on Login button");
	}
	
	@Then("User should be logged in")
	public void user_should_be_logged_in() throws Exception {
		login.validateURL("inventory");
	}
	
	@Then("User should not be logged in")
	public void user_should_not_be_logged_in() throws Exception {
		login.validateErrorMessage();
	}

	
}
