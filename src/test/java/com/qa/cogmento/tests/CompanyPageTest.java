package com.qa.cogmento.tests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.cogmento.base.BaseTest;
import com.qa.cogmento.utilities.Constants;

public class CompanyPageTest extends BaseTest{

	@BeforeClass
	public void companyPageSetUp() {
		homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		companyPage =homePage.navigateToCompanyPage();
	}

	@Test
	public void verifyCompanyPageHeaderTest() {
		String Actual_Header=companyPage.getCompanyPageHeader();
		Assert.assertEquals(Actual_Header, Constants.Comapny_Page_Header);
	}

	@Test
	public void verifyTheButtonSizeTest() {
		int Actual_btnSize=	companyPage.getButtonsCount();
		Assert.assertEquals(Actual_btnSize, Constants.buttonsCount);
	}

	@Test
	public void verifyTheNameOfbuttonsTest() {
		Assert.assertEquals(companyPage.getButtonsList(), Constants.getButtonsList());
	}
}
