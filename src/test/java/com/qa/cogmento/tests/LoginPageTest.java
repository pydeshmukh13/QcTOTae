package com.qa.cogmento.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.cogmento.base.BaseTest;
import com.qa.cogmento.utilities.Constants;

public class LoginPageTest extends BaseTest{



	@Test
	public void verifyLoginPageTitleTest() {
		String ActualTitle=loginPage.getLoginPageTitle();	
		Assert.assertEquals(ActualTitle, Constants.Login_Page_Title);
	}


	@Test
	public void verifyIsForgotPasswordLinkExistTest() {
		Assert.assertTrue(loginPage.getForgotLink());
	}

	@Test
	public void verifyIsSignUpLinkExistTest() {
		Assert.assertTrue(loginPage.getSignUpLink());
	}

	@Test(priority=1)
	public void verifyToLoginWithInvalidCredentialTest() {
		String ActualErroMessage=loginPage.doLoginwithInvalidCredentials(prop.getProperty("InvalidUser"), prop.getProperty("InvalidPassword"));
		System.out.println(ActualErroMessage);
		Assert.assertEquals(ActualErroMessage, Constants.Expected_Error_Message);
		}

	@Test(priority=2)
	public void VerifyToLoginWithvalidCredentialsTest() {
		homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

}
