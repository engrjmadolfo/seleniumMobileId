package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
public AndroidDriver driver;

	public BasePage(AndroidDriver driver)
	{
		this.driver = driver;
	//	PageFactory.initElements(driver, this);
		PageFactory.initElements(new AppiumFieldDecorator(driver,Duration.ofSeconds(10)),this); //To extend PageFactory to include Appium functionalities
		
	}
	

}
