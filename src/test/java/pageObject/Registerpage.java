package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Registerpage extends Constructor_class{

	public Registerpage(WebDriver driver) {
		super(driver);
	}

@FindBy(xpath="//input[@id='input-firstname']") WebElement firstName;
@FindBy(xpath="//input[@id='input-lastname']") WebElement lastName;
@FindBy(xpath="//input[@id='input-email']") WebElement email;
@FindBy(xpath="//input[@id='input-telephone']") WebElement telephone;
@FindBy(xpath="//input[@id='input-password']") WebElement password;
@FindBy(xpath="//input[@id='input-confirm']") WebElement passwordConfirm;
@FindBy(xpath="//label[normalize-space()='Yes']") WebElement newslettercbox1;
@FindBy(xpath="//input[@value='0']") WebElement newslettercbox2;
@FindBy(xpath="//input[@name='agree']") WebElement agreecbox;
@FindBy(xpath="//input[@value='Continue']") WebElement continuebtn;

public void firstName(String value) {
	 firstName.sendKeys(value);
 }
public void lastName(String value) {
	 
	 lastName.sendKeys(value);
 }
public void email(String value) {
	email.sendKeys(value+"@gmail.com");
}
public void telephone(String value) {
	telephone.sendKeys(value);
}
public String password(String value) {
	password.sendKeys(value);
	return value;
}
public void passwordConfirm(String value) {
	passwordConfirm.sendKeys(value);
}
public void newslettercbox1() {
	newslettercbox1.click();
}
public void newslettercbox2() {
	newslettercbox2.click();
}
public void agreecbox() {
	agreecbox.click();
}
public void continuebtn() {
	continuebtn.click();
}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
}
