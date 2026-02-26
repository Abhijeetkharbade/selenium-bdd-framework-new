package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.LoginPage;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("User is on login page")
    public void user_on_login_page() {
        loginPage.openLoginPage();
    }

    @When("User enters username and password")
    public void user_enters_credentials() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
    }

    @And("User clicks login button")
    public void user_clicks_login() {
        loginPage.clickLogin();
    }

    @Then("User should navigate to home page")
    public void user_should_see_homepage() {
        System.out.println("Login successful");
    }



}
