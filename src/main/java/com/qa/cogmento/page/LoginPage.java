package com.qa.cogmento.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.cogmento.base.BasePage;
import com.qa.cogmento.utilities.ElementUtils;

public class LoginPage extends BasePage{

	private WebDriver driver;
	public ElementUtils eleutil;


	private By username=By.name("email");
	private By password=By.name("password");
	private By loginbtn=By.xpath("//div[text()='Login']");
	private By ForgotLink=By.xpath("//a[text()='Forgot your password?']");
	private By SignUp=By.xpath("//a[text()='Sign Up']");
	private By ErroMsg=By.xpath("//div[@class='header']");

//Login Page Constructors
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		eleutil=new ElementUtils(driver);
	}
	
// Login Page actions 	
	
	public String getLoginPageTitle() {
		return eleutil.getTitle();
	}
	
	public boolean getSignUpLink() {
		return eleutil.isDisplayed(SignUp);
	}
	
	public boolean getForgotLink() {
		return eleutil.isDisplayed(ForgotLink);
	}
	
	public String doLoginwithInvalidCredentials(String invuser, String invpass) {
		eleutil.doSendKeys(username, invuser);
		eleutil.doSendKeys(password, invpass);
		eleutil.doClick(loginbtn);
		return eleutil.getText(ErroMsg);
	}
	
	public HomePage doLogin(String un,String pass) {
		eleutil.clearField(username);
		eleutil.clearField(password);
		eleutil.doSendKeys(username, un);
		eleutil.doSendKeys(password, pass);
		eleutil.doClick(loginbtn);
		return new HomePage(driver);
	}

	


}