package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.ProductPage;

public class ProductSteps {
	
	ProductPage productPage = new ProductPage();
	
	@Given("User is on home page")
	public void user_is_on_home_page() {
		productPage.verifyHomePage();
	    
	}

	@When("User adds products to cart")
	public void user_adds_products_to_cart() {
	    productPage.SelectItems();
	    
	}

	@When("User clicks on cart button")
	public void user_clicks_on_cart_button() {
		productPage.clickCart();
	    
	}

	@Then("User should navigate to cart")
	public void user_should_navigate_to_cart() {
		productPage.clickCheckout();
	    
	}
	
	@Then("User should fill checkout information")
	public void user_should_fill_checkout_information() {
		productPage.fillInfo();
	}

	@Then("User should click on continue")
	public void user_should_click_on_continue() throws InterruptedException {
		productPage.clickContinue();
	}

}
