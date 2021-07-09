package com.qa.cogmento.utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementUtils {

	public WebDriver driver;
	
	
	public ElementUtils(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public String getTitle() {
		return driver.getTitle();
	}


	public boolean isDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	
	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public String getAttribute(By locator) {
		return getElement(locator).getAttribute("innerHtml");
	}
	
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public void clearField(By locator) {
		driver.findElement(locator).clear();
	}
	
	
	public void moveToElementAndClick(By locator) {
		Actions action=new Actions(driver);
		action.moveToElement(getElement(locator))
		.click()
		.build()
		.perform();
	}
}
