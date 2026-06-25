package pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
public class Constructor_class{
	WebDriver driver;
	public Constructor_class(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	

}
