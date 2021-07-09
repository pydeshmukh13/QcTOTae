package com.qa.cogmento.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.cogmento.page.CompanyPage;
import com.qa.cogmento.page.ContactPage;
import com.qa.cogmento.page.CreateContactPage;
import com.qa.cogmento.page.HomePage;
import com.qa.cogmento.page.LoginPage;

public class BaseTest {
	
	public WebDriver driver;
	public BasePage basePage;
	public Properties prop;
	public LoginPage loginPage;
	public HomePage homePage;
	public ContactPage contactPage;
	public CreateContactPage createContact;
	public CompanyPage companyPage;
	
	@BeforeTest
	public void SetUp() {
	 basePage=new BasePage();
	 prop=basePage.init_properties();
	 driver=basePage.init_driver(prop.getProperty("browser"));
	 driver.get(prop.getProperty("url"));
	 try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 loginPage=new LoginPage(driver);
	 homePage=new HomePage(driver);
	 contactPage=new ContactPage(driver);
	 createContact=new CreateContactPage(driver);
	 companyPage=new CompanyPage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		//driver.quit();
	}

}
