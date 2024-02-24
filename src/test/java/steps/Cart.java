package steps;
import java.util.List;
import java.util.Map;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CartPage;

public class Cart {
	CartPage cartPage;

	@And("I add a product to the cart")
	public void i_add_a_product_to_the_cart() throws ClassNotFoundException {
		cartPage = new CartPage();
		cartPage.addProductToCart();
	}

	@And("I go to Cart page")
	public void i_go_to_cart_page() throws Exception {
		cartPage.goToCartPage();
	}

	@And("I checkout the purchase")
	public void i_checkout_the_purchase() throws Exception {

		cartPage.navigateToCheckoutPage();
	}

	@And("I enter checkout information and click continue")
	public void i_enter_checkout_information_and_click_continue(DataTable table) throws ClassNotFoundException {
		List<Map<String, String>> list=table.asMaps(String.class, String.class);
		cartPage.checkout(list.get(0).get("First_Name"), list.get(0).get("Last_Name"), list.get(0).get("Postal_Code"));
	}

	@And("I verify the checkout overview page")
	public void i_verify_the_checkout_overview_page() throws Exception {
		cartPage.validateOverviewPage();
	}

	@Then("I complete the order")
	public void i_complete_the_order() throws Exception {
		cartPage.completeOrder();
	}

}
