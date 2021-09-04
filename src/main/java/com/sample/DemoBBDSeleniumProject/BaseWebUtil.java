package com.sample.DemoBBDSeleniumProject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseWebUtil {
	
public static WebDriver driver;
	
	public BaseWebUtil(WebDriver driver){
		BaseWebUtil.driver = driver;
	}
	
	public void waitForPageToLoad(WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, 10);
       wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public String getBrowserTitle() {
		return driver.getTitle();
	}
	
	public String convertTimeto24HourFormat(String timing) {
		String input = timing;
	    DateFormat df = new SimpleDateFormat("hh:mm aa");
	    
	    DateFormat outputformat = new SimpleDateFormat("HH:mm");
	      Date date = null;
	      String output = null;
	      
	    	 try {
				date= df.parse(input);
			} catch (ParseException e) {
				e.printStackTrace();
			}
	    	 output = outputformat.format(date);
	         System.out.println(output);
			return output;
	}
	
	public void windowHandles() {
		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();


		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

		String child_window=I1.next();


		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);
		}

		}
	}

}
