package com.qa.cogmento.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.cogmento.base.BasePage;
import com.qa.cogmento.utilities.ElementUtils;

public class CompanyPage extends BasePage{
	
    private ElementUtils eleutils;
	
	private By header=By.xpath("//div[@class='ui header item mb5 light-black']");
	private By buttons=By.xpath("//div[@class='ui right secondary pointing menu toolbar-container']//button");
	private By createbtn=By.xpath("//button[@class='ui linkedin button' and text()='Create']");	
	
	
	public CompanyPage(WebDriver driver) {
		this.driver=driver;
		eleutils=new ElementUtils(driver);
	}
	
	public String getCompanyPageHeader() {
		return eleutils.getText(header);
	}
	
	public int getButtonsCount() {
		return eleutils.getElements(buttons).size();
	}

	public List<String> getButtonsList() {
		List<String> btnNameList=new ArrayList<>();
		List<WebElement> btnList=eleutils.getElements(buttons);
		for(WebElement e : btnList){
			System.out.println(e.getText());
			btnNameList.add(e.getText());
		}
		return btnNameList;
	}
	
	public void navigateToCreateNewCompanyPage() {
	  eleutils.doClick(createbtn);	
	}
}
