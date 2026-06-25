package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Homepage;
import pageObject.Loginpage;
import utilities.dataprovider_class;

public class TC003_logindata extends Test_base{
	@Test(dataProvider="logind",dataProviderClass=dataprovider_class.class, groups= "datadriven")
	public void loginusingdata(String email,String pwd,String result) {
		logger.info("clicking login");
		Homepage hp=new Homepage(driver);
		
		hp.myaccountlink();
		hp.loginlink();
		
		Loginpage lp=new Loginpage(driver);
		
		lp.email(email);
		lp.password(pwd);
		lp.login();
		Boolean value=lp.account();
		if(result.equalsIgnoreCase("valid")){
			if(value==true) {
				lp.logout();
				Assert.assertTrue(true);
			}
			else {
				Assert.fail();
			}
			
		}
		
		if(result.equalsIgnoreCase("invalid")) {
			if(value==true) {
				lp.logout();
				Assert.assertTrue(false);
			}
		}
		else {
			Assert.assertTrue(true);
		}
		
		
		
		
	}
}
