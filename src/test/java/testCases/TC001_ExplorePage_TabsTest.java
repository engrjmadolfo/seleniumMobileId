package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ExplorePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC001_ExplorePage_TabsTest extends BaseClass {
public ExplorePage eP;
public SearchPage sP;

	@Test(priority = 1, groups = {"sanity,regression"})
	public void explorePage_TabsTest()
	{
		logger.info("Starting Explore Page Tabs Testing......");
		eP = new ExplorePage(driver);
				
		Assert.assertTrue(eP.fashionTabVisible(), "Fashion Tab Missing");
		Assert.assertTrue(eP.homeTabVisible(), "Home Tab Missing");
		Assert.assertTrue(eP.sportTabVisible(),"Sports Tab Missing");
		Assert.assertTrue(eP.moneyTabVisible(),"Money Tab Missing"); 
	
		
	}
	
	@Test(priority = 2, enabled=false, dependsOnMethods = {"explorePage_TabsTest"},groups= {"sanity,regression"})
	public void ExplorePage_IndividualTabsTest()
	{
		logger.info("Starting Explore Page Individual Tabs Checking");
		Assert.assertTrue(eP.shopDenimButtonVisible(),"Shop Denim is missing");
		Assert.assertTrue(eP.shopBasicsButtonVisible(),"Shop Basics is missing");
		Assert.assertTrue(eP.fashionDropdownButtonVisible(),"Fashion dropdown is missing");
		
		eP.fashionDropdownButtonClick();
		Assert.assertTrue(eP.fashionListVisible(),"Fashion list is missing");
		
		eP.homeTabClick();
		Assert.assertTrue(eP.findYourZenButtonVisible(),"Find your zen is missing");
		Assert.assertTrue(eP.shopAllPromosButtonVisible(),"Shop All Promos is missing");
		
		eP.sportTabClick();
		Assert.assertTrue(eP.hotListButtonVisible(),"Hotlist is missing");
		Assert.assertTrue(eP.justDropInButtonVisible(),"Just Drop in is missing");
		
		eP.moneyTabClick();
		Assert.assertTrue(eP.applyNowButtonVisible(),"Apply Now is missing");
		Assert.assertTrue(eP.myAccountButtonVisible(),"My Account is missing");
	}
}
