package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Constructor_class{
	public Homepage(WebDriver driver){
		super(driver);
		
	}
	
	@FindBy(xpath="//a[@title='My Account']")WebElement  myAccount;
	@FindBy(xpath="//a[normalize-space()='Register']")WebElement register;
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement login;
	
	public void registerlink() {
		register.click();
	}
	public void myaccountlink() {
		myAccount.click();
	}
	public void loginlink() {
		login.click(); 
	}
	

}
