package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SearchPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC002_SearchPage_ResultsTest extends BaseClass{
public SearchPage sP;	

	@Test(priority = 1, dataProvider="SearchData", dataProviderClass = DataProviders.class)
	public void searchTest(String searchTxt, String searchElementTxt)
	{
		sP = new SearchPage(driver);
		sP.searchItem(searchTxt);
		Assert.assertTrue(sP.shoesResult1Visible(searchElementTxt),"Shoes is not visible");
	}

}
