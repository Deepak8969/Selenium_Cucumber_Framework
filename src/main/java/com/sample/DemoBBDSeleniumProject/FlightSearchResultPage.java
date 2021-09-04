package com.sample.DemoBBDSeleniumProject;

import java.awt.Desktop.Action;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightSearchResultPage extends BaseWebUtil{
	
	public FlightSearchResultPage(WebDriver driver) {
		super(driver);
		System.out.println("driver==>" + driver);
	}
	
	@FindBy(css = ".hrtlCenter .buttonSecondry")
	public WebElement popupButton;
	

	@FindBy(css = "h4.headerTitle,h2.headerTitle ")
	public WebElement confirmbooking;
	
	@FindBy(css = ".timeInfoLeft .hrtlCenter span")
	public List<WebElement> flightTiming;
	
	@FindBy(css = ".textRight .white-space-no-wrap")
	public List<WebElement> flightPrice;
	
	@FindBy(css = ".ViewFareBtn .arrowDown")
	public List<WebElement> viewPrice;
	
	@FindBy(css = ".viewFaresOuter button[id*='_0']")
	public List<WebElement> bookNow;
	

	public void handlePopup() {
		popupButton.click();
	}
	
	public String comparetiming(String actualTiming, String targetTime) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");

		Date d1=df.parse(actualTiming);
		Date d2=df.parse(targetTime);

		long d1Ms=d1.getTime();
		long d2Ms=d2.getTime();

		if(d1Ms < d2Ms)
		{
		   return "Not Suitable";
		}
		else
		{
			return "Suitable";
		}
	}
	
	public void selectTheFlightBasedOnTimingandPrice(String price, String timing) throws ParseException, InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor)driver;
		String targetTime = convertTimeto24HourFormat(timing);
		
		Thread.sleep(3000);
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.visibilityOfAllElements(flightTiming));
		
		
	    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    Thread.sleep(1000);
	    js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
	    Thread.sleep(1000);
	    
		for (int i = 0; i < flightTiming.size(); i++) {
			 
			String ActualTiming = flightTiming.get(i).getText();
			System.out.println(i+ "  " + ActualTiming);
			
			if(!ActualTiming.equals("")) {
			String Flight = comparetiming(ActualTiming,targetTime);
			//System.out.println(i+ "  " +Flight);
			
			if(Flight.equals("Suitable")) {
				String Price = flightPrice.get(i).getText();
				int flightprice =  Integer.parseInt(Price.replaceAll("[^0-9]",""));
				System.out.println(i+ "  " +flightprice + "\n\n");
				
				if(flightprice > Integer.parseInt(price)) {
					System.out.println("Final Price " + flightprice);
					
					
					Actions actions = new Actions(driver); 
					actions.moveToElement(viewPrice.get(i)).click().build().perform();
					
					
					WebElement element = bookNow.get(i);
					js.executeScript("arguments[0].click();", element);
					break;
					
					}
				
				}
			}
				
		}
			
	}
	
	
	
	public String getConfirmationconfirmbookingLabel() {
		return confirmbooking.getText();
	}
	
	
}
