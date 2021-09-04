package com.sample.DemoBBDSeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightHomePage extends BaseWebUtil{
	
	public FlightHomePage(WebDriver driver) {
		super(driver);
		System.out.println("driver==>" + driver);
	}
	
	
	@FindBy(css = "[data-cy='account']")
	public WebElement account;
	
	@FindBy(css = "#fromCity")
	public WebElement source;
	
	@FindBy(css = "#toCity")
	public WebElement destination;
	
	@FindBy(css = "[placeholder='From']")
	public WebElement sourceSearchBox;
	
	
	@FindBy(css = "[placeholder='To']")
	public WebElement destinationSearchBox;
	
	@FindBy(css = "[data-suggestion-index='0']")
	public WebElement autosuggestive;
	
	@FindBy(css = "[aria-label='Tue Oct 12 2021']")
	public WebElement selectDate;
	
	@FindBy(css = "[data-cy=\"submit\"] a.primaryBtn")
	public WebElement searchButton;
	
	
	public void selectOptionfromAutoSuggestiveDropDown() throws InterruptedException {
		Thread.sleep(2000);
		autosuggestive.click();
	}
	
	
	public void enterKeywordInSourceSearchBox(String sour) throws InterruptedException {
		waitForPageToLoad(source);
		account.click();
		source.click();
		sourceSearchBox.sendKeys(sour);
		selectOptionfromAutoSuggestiveDropDown();
	}
	
	public void enterKeywordInDestinationSearchBox(String dest) throws InterruptedException {
		waitForPageToLoad(destination);
		//destination.click();
		destinationSearchBox.sendKeys(dest);
		selectOptionfromAutoSuggestiveDropDown();
	}

	public void selectDateFromTheCalender() {
		selectDate.click();
	}
	
	public void performSearch() {
		searchButton.click();
	}
	

}
