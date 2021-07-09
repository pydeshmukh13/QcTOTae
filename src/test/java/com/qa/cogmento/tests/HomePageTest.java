package com.qa.cogmento.tests;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.cogmento.base.BaseTest;
import com.qa.cogmento.page.HomePage;
import com.qa.cogmento.utilities.Constants;

public class HomePageTest extends BaseTest{

	public HomePage homePage;

	@BeforeClass
	public void HomePageSetUp() {
		homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}


	@Test()
	public void VerifyHomePageTitleTest() {
		String Title=homePage.getHomePageTitle();
		Assert.assertEquals(Title, Constants.Home_Page_Title);
	}

	@Test
	public void VerifyIsLoginUserNameExistTest() {
		Assert.assertTrue(homePage.loginUsernameIsExist());
	}

	@Test
	public void VerifyHomePageLogoIsExistTest() {
		Assert.assertTrue(homePage.HomePageLogo());
	}

	@Test
	public void VerifySectionHeaderSizeTest() {
		int ActualSize=homePage.getSectiolListSize();
		Assert.assertEquals(ActualSize, Constants.HomePage_Sections);
	}

	@Test
	public void VerifyHomePageSectionsTest() {
		List<String> ActualsectionList=homePage.getSectionList();
		List<String> ExpectedSectionList=Constants.getHomePageSectionsList();
		Assert.assertEquals(ActualsectionList, ExpectedSectionList);
	}
}





