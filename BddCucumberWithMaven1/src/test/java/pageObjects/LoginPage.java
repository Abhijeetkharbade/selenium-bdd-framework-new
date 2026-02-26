package pageObjects;

	import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.CacheLookup;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import utilities.DriverFactory;

	public class LoginPage {

	    WebDriver driver = DriverFactory.getDriver();

	    private By username = By.id("user-name");
	    private By password = By.id("password");
	    private By loginBtn = By.id("login-button");

	    public void openLoginPage() {
	        driver.get("https://www.saucedemo.com/");
	    }

	    public void enterUsername(String user) {
	        driver.findElement(username).sendKeys("standard_user");
	    }

	    public void enterPassword(String pass) {
	        driver.findElement(password).sendKeys(pass);
	    }

	    public void clickLogin() {
	        driver.findElement(loginBtn).click();
	    }
	}