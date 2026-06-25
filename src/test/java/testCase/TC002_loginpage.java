package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Homepage;
import pageObject.Loginpage;

public class TC002_loginpage extends Test_base{
	@Test(groups= {"sanity","master"})
	public void login() throws InterruptedException {
		logger.info("home page opening");
		try {
	Homepage hpage=new Homepage(driver);

	hpage.myaccountlink();
	logger.info("clicking login");
	hpage.loginlink();
	Thread.sleep(6000);
	Loginpage lp=new Loginpage(driver);
	logger.info("clicking login");

	String em=p.getProperty("email");
	lp.email(em.toLowerCase());
	lp.password(p.getProperty("pwd"));
	lp.login();
	Assert.assertEquals(true,lp.account());
	
		}
		catch (Exception e) {
		    e.printStackTrace();
		    throw e;
		}
	
	}

}
