package pageObjects;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.DriverFactory;

public class ProductPage {
	 WebDriver driver = DriverFactory.getDriver();

	    private By addSauceLabsBackpack = By.id("add-to-cart-sauce-labs-backpack");
	    private By addSauceLabsBikeLight = By.id("add-to-cart-sauce-labs-bike-light");
	    private By addSauceLabsFleeceJacket = By.id("add-to-cart-sauce-labs-fleece-jacket");
	    private By cartBtn = By.id("shopping_cart_container");
	    private By checkOutBtn = By.id("checkout");
	    private By firstName = By.id("first-name");
	    private By lastName = By.id("last-name");
	    private By zip = By.id("postal-code");
	    private By continueBtn = By.id("continue");
	    private By signIn = By.xpath("//a[@aria-controls=\"nav-flyout-accountList\"]");
	    private By myWishList = By.xpath("//a[@href=\"/hz/wishlist/ls?requiresSignIn=1&ref_=nav_AccountFlyout_wl\"]");
	    
	  
	    

	    public void verifyHomePage() {
	        String actualURL=driver.getCurrentUrl();
	        String expectedURL="https://www.saucedemo.com/inventory.html";
	        System.out.println(actualURL+"<console log");
	        Assert.assertEquals(expectedURL, actualURL);
	        System.out.println(actualURL+"<console log2");
	    }

	    public void SelectItems() {
	    	System.out.println("<console log3");
			driver.findElement(addSauceLabsBackpack).click();
			driver.findElement(addSauceLabsBikeLight).click();
			driver.findElement(addSauceLabsFleeceJacket).click();
			System.out.println("<console log4");
		}

	    public void clickCart() {
			driver.findElement(cartBtn).click();
			
		}

	    public void clickCheckout() {
	        driver.findElement(checkOutBtn).click();
	    }

		public void fillInfo() {
			driver.findElement(firstName).sendKeys("Abhijeet");
			driver.findElement(lastName).sendKeys("Kh");
			driver.findElement(zip).sendKeys("440000");
			
		}

		public void clickContinue() throws InterruptedException {
			driver.findElement(continueBtn).click();
			//Here I'm opening Amazon for complex xpath testing purpose
			driver.get("https://www.amazon.in/");
			Thread.sleep(3000);
			System.out.println("test1");
			Actions act=new Actions(driver);
			WebElement signInn=driver.findElement(By.id("nav-link-accountList"));
			act.moveToElement(signInn).perform();
			//driver.findElement(signIn).click();
			System.out.println("test2");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			WebElement myWishList = wait.until(
			    ExpectedConditions.elementToBeClickable(
			    		By.xpath("//a[@href=\"/hz/wishlist/ls?requiresSignIn=1&ref_=nav_AccountFlyout_wl\"]")));

			myWishList.click();
			
			//test
		}

		

		
}
