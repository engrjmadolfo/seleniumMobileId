package pageObjects;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ExplorePage extends BasePage{

	public ExplorePage(AndroidDriver driver)
	{
		super(driver);
	}
	
	//LOCATORS
	
	//Tabs
//	@FindBy(xpath="//android.widget.TextView[@text=\"Fashion\"]")
//	WebElement fashionTab;
	
	@AndroidFindBy(uiAutomator ="new UiSelector().text(\"Fashion\")")
	WebElement fashionTab;
	
	//@FindBy(xpath="//android.widget.TextView[@text=\"Home\"]")
	//WebElement homeTab;
	
	@AndroidFindBy(uiAutomator ="new UiSelector().text(\"Home\")")
	WebElement homeTab;
	
	//@FindBy(xpath="//android.widget.TextView[@text=\"Sport\"]")
	//WebElement sportTab;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sport\")")
	WebElement sportTab;
	
	//@FindBy(xpath="//android.widget.LinearLayout[@content-desc=\"Money\"]")
	//WebElement moneyTab;
	
	@AndroidFindBy(uiAutomator="new UiSelector().text(\"Money\")")
    WebElement moneyTab;
	
	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"za.com.mrp:id/search_input_text\")")
	WebElement searchBar;
    
	//Fashion Tab
	//@FindBy(xpath="//android.widget.TextView[@text=\"SHOP DENIM\"]")
	//WebElement shopDenimButton;
    
    
    @AndroidFindBy(uiAutomator =
    		"new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"SHOP DENIM\"))")
    WebElement shopDenimButton;
    
	
//	@FindBy(xpath="//android.widget.TextView[@text=\"SHOP BASIC TOPS\"]")
//	WebElement shopBasicsButton;
	
    @AndroidFindBy(uiAutomator ="new UiScrollable(new UiSelector()).scrollIntoView("+"new UiSelector().text(\"SHOP BASIC TOPS\")")
    WebElement shopBasicsButton;
    

//	@FindBy(xpath="//android.widget.ImageView[@resource-id=\"za.com.mrp:id/explore_category_choose_button_chevron\"]")
//	WebElement fashionDropdownButton;
    
    @AndroidFindBy(uiAutomator="new UiScrollable(new UiSelector()).scrollIntoView("+"new UiSelector().resourceId(\"za.com.mrp:id/explore_category_choose_button_label\")")
    WebElement fashionDropdownButton;
	
	//WebElement fashionList = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId('za.com.mrp:id/switcher_recycler')"));
	
	//@FindBy(AppiumBy.androidUIAutomator="new UiSelector().resourceId('za.com.mrp:id/switcher_recycler')")
	//WebElement fashionList;
    
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView("+"new UiSelector().resourceId(\"za.com.mrp:id/switcher_title\"))")
    WebElement fashionList;
    
	//Home Tab
	//@FindBy(xpath="//android.widget.TextView[@text=\"SHOP FIND YOUR ZEN\"]")
	//WebElement findYourZenButton;
    
    @AndroidFindBy(uiAutomator="new UiScrollable(new UiSelector()).scrollIntoView("+"new UiSelector().text(\"SHOP FIND YOUR ZEN\"));")
    WebElement findYourZenButton;
	
	//@FindBy(xpath="//android.widget.TextView[@text=\"SHOP ALL PROMOS\"]")
	//WebElement shopAllPromosButton;
	
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView("+"new UiSelector().text(\"SHOP ALL PROMOS\"));")
    WebElement shopAllPromosButton;
	
	//Sports Tab
	
	//@FindBy(xpath="//android.widget.TextView[@text=\"Hot List\"]")
	//WebElement hotListButton;
	
    @AndroidFindBy(uiAutomator ="new UiScrollable(new UiSelector()).scrollIntoView("+"new UiSelector().text(\"Hot List\"));")
    WebElement hotListButton;
    
	//@FindBy(xpath="//android.widget.TextView[@text=\"Just Dropped In!\"]")
	//WebElement justDropInButton;
	
    @AndroidFindBy(uiAutomator ="new UiScrollable(new UiSelector()).scrollIntoView("+"new UiSelector().textStartsWith(\"Just Dropped\"));")
    WebElement justDropInButton;
    
    
	
	//Money Tab
	
	//@FindBy(xpath="//android.widget.TextView[@text=\"MY ACCOUNT\"]")
	//WebElement myAccountButton;
    
    @AndroidFindBy(uiAutomator ="new UiScrollable(new UiSelector()).scrollIntoView("+"new UiSelector().text(\"Apply for a Mr Price Money Account\"));")
    WebElement applyNowButton;
	
	//@FindBy(xpath="//android.widget.Image[@text=\"Apply for a Mr Price Money Account\"]")
	//WebElement applyNowButton;
    
    @AndroidFindBy(uiAutomator="new UiScrollable(new UiSelector()).scrollIntoView("+"new UiSelector().text(\"MY ACCOUNT\"));")
    WebElement myAccountButton;
	

	
	//Functions
    
    public boolean searchBarVisible()
    {
    	return searchBar.isDisplayed();
    }
	
	public boolean fashionTabVisible()
	{
		return fashionTab.isDisplayed();
	}
	
	public boolean homeTabVisible()
	{
		return homeTab.isDisplayed();
	}
	
	public boolean sportTabVisible()
	{
		return sportTab.isDisplayed();
	}
	
	public boolean moneyTabVisible()
	{
		return moneyTab.isDisplayed();
	}
	
	
	public boolean shopDenimButtonVisible()
	{
		return shopDenimButton.isDisplayed();
	}
	
	public boolean shopBasicsButtonVisible()
	{
		return shopBasicsButton.isDisplayed();
	}
	
	public boolean fashionDropdownButtonVisible()
	{
		return fashionDropdownButton.isDisplayed();
	}
	
	public boolean fashionListVisible()
	{
		return fashionList.isDisplayed();
	}
	
	public boolean findYourZenButtonVisible()
	{
		return  findYourZenButton.isDisplayed();
	}
	
	public boolean shopAllPromosButtonVisible()
	{
		return  shopAllPromosButton.isDisplayed();
	}
	
	public boolean hotListButtonVisible()
	{
		return  hotListButton.isDisplayed();
	}
	
	public boolean justDropInButtonVisible()
	{
		return  justDropInButton.isDisplayed();
	}
	
	public boolean applyNowButtonVisible()
	{
		return  applyNowButton.isDisplayed();
	}
	
	public boolean myAccountButtonVisible()
	{
		return  myAccountButton.isDisplayed();
	}
	
	public void fashionDropdownButtonClick()
	{
		fashionDropdownButton.click();
	}
	
	
	public void homeTabClick()
	{
		homeTab.click();
	}
	
	public void sportTabClick()
	{
		sportTab.click();
	}
	
	public void moneyTabClick()
	{
		moneyTab.click();
	}
}
