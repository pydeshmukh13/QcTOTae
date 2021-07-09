package com.qa.cogmento.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.cogmento.base.BasePage;
import com.qa.cogmento.utilities.ElementUtils;

public class CreateContactPage extends BasePage{
	
	
	private WebDriver driver;
	private ElementUtils eleutil;
	
	private By Firstname=By.name("first_name");
	private By Lastname=By.name("last_name");
	private By Address=By.name("address");
	private By Phone=By.xpath("//input[@placeholder='Home, Work, Mobile...']");
	private By Email=By.xpath("//input[@placeholder='Email address']");
	private By SaveBtn=By.xpath("//button[@class='ui linkedin button']");
	//private By CreatedUserName=By.xpath("//div[@class='ui header item mb5 light-black']");
	private By contactmenu=By.xpath("//a[@href='/contacts']");
	private By createBtn=By.xpath("(//button[@class='ui linkedin button'])[3]");
	
	public CreateContactPage(WebDriver driver) {
		this.driver=driver;
		eleutil=new ElementUtils(driver);
	}
	
	public void createNewContact(String firstname,String lastname,String address,String phone,String email) {
		eleutil.doSendKeys(Firstname, firstname);
		eleutil.doSendKeys(Lastname, lastname);
		eleutil.doSendKeys(Address, address);
		eleutil.doSendKeys(Phone, phone);
		eleutil.doSendKeys(Email, email);
		eleutil.doClick(SaveBtn);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eleutil.moveToElementAndClick(contactmenu);
		eleutil.doClick(createBtn);
	}
	

}
