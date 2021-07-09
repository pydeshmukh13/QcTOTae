package com.qa.cogmento.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.cogmento.base.BaseTest;
import com.qa.cogmento.page.ContactPage;
import com.qa.cogmento.utilities.Constants;

public class ContactPageTest extends BaseTest{

	public ContactPage contactPage;

	@BeforeClass
	public void contactPagesetUp() {
		homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactPage=homePage.navigateToContactPage();
	}

	@Test
	public void verifyContactPageHeaderTest() {
		String Header=contactPage.getConatactPageHeader();
		Assert.assertEquals(Header, Constants.Contact_Page_Header);
	}

	@Test
	public void verfiyExistButtonsCountTest() {
		Assert.assertTrue(contactPage.getButtonlistSize()==3);

	}

	@Test
	public void verifyButtonTextTest() {
		Assert.assertEquals(contactPage.getButtonNameList(), Constants.getButtonsList());
	}


	@Test(priority=1)
	public void VerifySizeoftheColumnnameTest() {
		Assert.assertTrue(contactPage.getColumnNameSize()==7);

	}



	@Test(priority=2)
	public void verifyColumnNamesTest() {
		Assert.assertEquals(contactPage.getColumnheaderList(), Constants.getColumnNameList());
	}
}
