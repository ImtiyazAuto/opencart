package testCase;

import org.testng.annotations.Test;

import pageObject.Homepage;
import pageObject.Registerpage;

public class Register_TC extends Test_base{
	@Test(groups= {"regression","master"})
	public void Register() throws InterruptedException {
	
		logger.info("accesing home page class through constructor ");
		Homepage hp=new Homepage(driver);
		
		hp.myaccountlink();
		hp.registerlink();
		logger.info("accesing register page class through constructor ");

		Registerpage rp=new Registerpage(driver);
		rp.firstName(randomString().toUpperCase());
		rp.lastName(randomString().toUpperCase());
		rp.email(randomString());
		rp.telephone(randomNumbers());
		String pass=rp.password(randomAlphaNumeric());
		
		rp.passwordConfirm(pass);
		rp.newslettercbox1();
		rp.agreecbox();
		rp.continuebtn();
		
		

		
	}
	
	

}
