package com.qa.cogmento.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.cogmento.base.BasePage;
import com.qa.cogmento.utilities.ElementUtils;

public class ContactPage extends BasePage{
	
	private WebDriver driver;
	private ElementUtils eleutil;
	
	private By ConatctPageHeader=By.xpath("//div[@class='ui header item mb5 light-black']");
	private By ButtonsList=By.xpath("//button[@class='ui linkedin button']");
	private By ColumnList=By.xpath("//div[@class='table-wrapper']//tr/th");
	private By createBtn=By.xpath("(//button[@class='ui linkedin button'])[3]");
	
	
	public ContactPage(WebDriver driver) {
		this.driver=driver;
		eleutil=new ElementUtils(driver);
	}
	
	public String getConatactPageHeader() {
		return eleutil.getText(ConatctPageHeader);
	}
	
	public int getButtonlistSize() {
		return eleutil.getElements(ButtonsList).size();
	}
	
	public List<String> getButtonNameList() {
		List<String> btnList=new ArrayList<>();
		List<WebElement> buttonList=eleutil.getElements(ButtonsList);
		for(WebElement e:buttonList) {
			btnList.add(e.getText());
		}
		return btnList;
	}
	
	
	public int getColumnNameSize() {
	 int columnsize=eleutil.getElements(ColumnList).size();
	 System.out.println("The Size Of the Column Header Is...."+columnsize);
	 return columnsize;
	}
	
	public List<String> getColumnheaderList() {
		List<String> columnNameList=new ArrayList<>();
		List<WebElement> columnList=eleutil.getElements(ColumnList);
		
		for(WebElement e:columnList) {
			System.out.println("Column header is ...."+e.getText());
					
			columnNameList.add(e.getText());
		}
		return columnNameList;
		
	}
	
	public CreateContactPage navigateToCreateNewContactPage() {
		eleutil.getElement(createBtn).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.navigate().refresh();
		return new CreateContactPage(driver);
	}

}
