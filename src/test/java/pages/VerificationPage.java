package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
public class VerificationPage extends StartupPage{

	public VerificationPage(WebDriver driver) {
		super(driver);
	}

	private By emailInput = By.cssSelector("input#username_id");
	private By passwordInput = By.cssSelector("#password");
	private By signInButton = By.cssSelector("#login");
	private By headerProfileIcon = By.cssSelector("a#header-icon-profile");
	private By logoutButton = By.cssSelector("a#logout");
	
	public By getVerificationLocator() {
		return By.xpath("//a[@href='#/Verification']");
	}
	
	public By getAnchorTagLocatorByText(String anchorTagName) {
		return By.xpath("//a[contains(text(),'" + anchorTagName + "')]");
	}
	
	public void login() {
		 driver.findElement(emailInput).sendKeys("admin");
		 driver.findElement(passwordInput).sendKeys("pass123");
		 driver.findElement(signInButton).click();
		 
	}
	
	
	public void openVerificationMenu() {
		try {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			WebElement verificationTab = driver.findElement(getVerificationLocator());
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", verificationTab);
			verificationTab.click();
			
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	public void successfullNavigation(String module) throws InterruptedException {
		// Get the current URL
		Thread.sleep(3000);
        String currentURL = driver.getCurrentUrl();
        
        // Substring to verify
        String expectedSubstring = module;
        System.out.println("this is the current URL: "+currentURL);
        
        // Verify the substring
        if (currentURL.contains(expectedSubstring)) {
            System.out.println("URL contains the expected substring: " + expectedSubstring);
        } else {
            Assert.fail("URL does not contains the expected substring: " + expectedSubstring);
        }
	}
	
	
	public void  verifyButtonPresentWithText(String text) {
		WebElement element = driver.findElement(getAnchorTagLocatorByText(text));
		Boolean elementISDisplayed = element.isDisplayed();
		
		if(!elementISDisplayed) {
			Assert.fail("element with text:"+text +" is not visible");
		}
	}
	
	public void clickOnButtonByText(String text) {
		WebElement element = driver.findElement(getAnchorTagLocatorByText(text));
		element.click();
	}
}
