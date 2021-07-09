package com.qa.cogmento.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.cogmento.base.BasePage;
import com.qa.cogmento.utilities.ElementUtils;

public class HomePage extends BasePage{

	private WebDriver driver;
	private ElementUtils eleutil;
	

	private By Logo=By.xpath("//div[@class='header item']");
	private By LoginUsername=By.xpath("//span[@class='user-display']");
	private By SectionList=By.xpath("//div[@class='header']");
	private By contactmenu=By.xpath("//a[@href='/contacts']");
	private By Companypage=By.xpath("//span[@class='item-text' and text()='Companies']");


	public HomePage(WebDriver driver) {
		this.driver=driver;
		eleutil=new ElementUtils(driver);
	}
	
	public String getHomePageTitle() {
		return eleutil.getTitle();
	}
	
	public boolean HomePageLogo() {
		return eleutil.isDisplayed(Logo);
	}
	
	public boolean loginUsernameIsExist() {
		return eleutil.isDisplayed(LoginUsername);
	}
	
	public int getSectiolListSize() {
		return eleutil.getElements(SectionList).size();
	}
	
	public List<String> getSectionList() {
		List<String> SectList=new ArrayList<>();
		List<WebElement> homePageSectionList=eleutil.getElements(SectionList);
		
		for(WebElement e:homePageSectionList) {
			String ListofSection=e.getText();
			System.out.println(ListofSection);
		
			SectList.add(ListofSection);
		}
		
		return SectList;
	}
	
  public ContactPage navigateToContactPage() {
	  eleutil.moveToElementAndClick(contactmenu);
	  return new ContactPage(driver);
		
	}
  
  public CompanyPage navigateToCompanyPage() {
	  eleutil.moveToElementAndClick(Companypage);
	  return new CompanyPage(driver);
  }
	

}
