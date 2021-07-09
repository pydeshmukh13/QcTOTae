package com.qa.cogmento.tests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.cogmento.base.BaseTest;
import com.qa.cogmento.utilities.Constants;
import com.qa.cogmento.utilities.ExcelUtil;

public class CreateNewContactTest extends BaseTest{

	@BeforeClass
	public void CreateNewContactPagesetUp() {
		homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactPage=homePage.navigateToContactPage();
		createContact=contactPage.navigateToCreateNewContactPage();
	}
	
	
	@DataProvider
	public Object[][] getContactData() {
		Object data[][]=ExcelUtil.getTestData(Constants.Contact_Sheet_Name);
		return data;
	}
	
	@Test(dataProvider="getContactData")
	public void createNewContactTest(String firstname,String lastname,String address,String phone,String email )
	{
		createContact.createNewContact( firstname, lastname, address, phone, email);
	}
}
