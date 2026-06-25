package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Constructor_class{
	public  Loginpage(WebDriver driver) {
		
	super(driver);
	}
	@FindBy(xpath="//input[@id='input-email']") WebElement email;
	@FindBy(xpath="//input[@id='input-password']") WebElement password;
	@FindBy(xpath="//input[@value='Login']") WebElement login;
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement myAccount;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement logout;
	
	
	public void email(String value) {
		email.sendKeys(value);
		
	}
	public void password(String value) {
		password.sendKeys(value);
	}
	public void login() {
		login.click();
	}
	public boolean account() {
	    try {
	        return myAccount.isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}
	public void logout() {
		logout.click();
	}

}
