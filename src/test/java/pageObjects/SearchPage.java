package pageObjects;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SearchPage extends BasePage {

	public SearchPage(AndroidDriver driver)
	{
		super(driver);
	}
	
	//Locators
	
	@AndroidFindBy(uiAutomator="new UiSelector().text(\"Boys Bata Shoes\")")
	WebElement shoesResult1;
	
	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"za.com.mrp:id/oroduct_search_text_prompt\")")
	WebElement viewAllShoesResult1;
	
	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"za.com.mrp:id/search_input_clear_icon\")")
	WebElement clearSearchBar;
	
	@AndroidFindBy(uiAutomator="new UiSelector().text(\"Stripe Dad Pants\")")
	WebElement pantsResult1;

	@AndroidFindBy(uiAutomator="new UiSelector().text(\"Artclub and Friends Tote Bag\")")
	WebElement bagsResult1;
	
	@AndroidFindBy(uiAutomator="new UiSelector().text(\"Leopard Print Denim Jackets\")")
	WebElement jacketsResult1;
	
	@AndroidFindBy(uiAutomator="new UiSelector().text(\"3 Pack Hair Accessories\")")
	WebElement acessoriesResult1;
	
	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"za.com.mrp:id/search_input_text\")")
	WebElement searchBar;
	//Actions
	
	public void searchItem(String searchTxt)
	{
		searchBar.click();
		searchBar.sendKeys(searchTxt);
		viewAllShoesResult1.click();
		clearSearchBar.click();
	}
	
	public boolean shoesResult1Visible(String searchElemntTxt)
	{
	
		WebElement shoesResult = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+searchElemntTxt+"\").instance(0))"));
        return shoesResult.isDisplayed();	
	}
	
}
