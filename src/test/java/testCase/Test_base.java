package testCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Test_base {
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	@BeforeClass(groups= {"sanity","master","regression"})
	@Parameters({"browser","os"})
	public void setup(String value,String os) throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");                                                                                                   
		 p=new Properties();
		p.load(fis);
		logger=LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution").equalsIgnoreCase("remote")) {
			DesiredCapabilities cp=new DesiredCapabilities();
			if(os.equalsIgnoreCase("windows")) {
				cp.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac")) {
				cp.setPlatform(Platform.MAC);
			}
			else if(os.equalsIgnoreCase("linux")) {
				cp.setPlatform(Platform.LINUX);
			}
			else {
				System.out.println("not applicable");
			}
			switch(value) {
			case "chrome":cp.setBrowserName("chrome");break;
			case "edge":cp.setBrowserName("MicrosoftEdge");break;
			default:System.out.println("invalid");return;
			
			}
			
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cp);
			
			
			
		}
	//edit1 logger
	    if(p.getProperty("execution").equalsIgnoreCase("local")) {
		 
		 //edit 2 parallel testing
		 switch(value) {
		 case "chrome":		driver=new ChromeDriver();break;
		 case "edge":		driver=new EdgeDriver();break;
		 default:System.out.println("no value mf");return;
 } 
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//driver.get("https://tutorialsninja.com/demo/");
		//edit3 properties file reading 
		
		driver.get(p.getProperty("url"));
		
	}
	@AfterClass(groups= {"sanity","master","regression"})
	public void closing() {
		driver.quit();		
	}
	public String randomNumbers() {
		String v=RandomStringUtils.randomNumeric(10);
		return v;
		
	}
	public String randomString() {
		String v=RandomStringUtils.randomAlphabetic(7);
		return v;
		
	}
	public String randomAlphaNumeric() {
		String v=(RandomStringUtils.randomAlphanumeric(6)+"@$$");
		return v;
		
	}
	public static String getScreenShot(String name) {
		String timestamp=new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		TakesScreenshot tks=(TakesScreenshot)driver;
		File source=tks.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"\\ss\\"+name+"_"+timestamp+".png";
		File target= new File(path);
		source.renameTo(target);
		return path;
	}

}
