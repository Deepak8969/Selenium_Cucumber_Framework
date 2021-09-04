package com.sample.DemoBBDSeleniumProject.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

import com.sample.DemoBBDSeleniumProject.FlightHomePage;
import com.sample.DemoBBDSeleniumProject.FlightSearchResultPage;

public class BaseWebPage_stepdef {
	
	public static WebDriver driver;
	Properties prop;
	public FlightHomePage homePage;
	public FlightSearchResultPage resultPage;
	
	public BaseWebPage_stepdef() {
		try {
			setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		}

	public void setUp() throws IOException {
		
		setUpSeleniumDriverFromEnvProperties();
		String URL = computeStartUrl();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		InitalizeAllPages();
	}
	
	
	public void setUpSeleniumDriverFromEnvProperties() throws IOException {
		
		prop = new Properties();
		
		FileInputStream file = new FileInputStream("src" + File.separator + "test" + File.separator + "resources" + File.separator + "Environment.properties");
		prop.load(file);
		
		String browserName = prop.getProperty("Browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src" + File.separator + "test" + File.separator + "resources" + File.separator + "chromedriver.exe");
			
			driver = new ChromeDriver();
		}
		
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "src" + File.separator + "test" + File.separator + "resources" + File.separator + "geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if(browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "src" + File.separator + "test" + File.separator + "resources" + File.separator + "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
	}
	
	
	protected String computeStartUrl() {
		String startUrl = prop.getProperty("URL");
		System.out.println("URL===> "+ startUrl);
		return startUrl;
	}
	
	public void InitalizeAllPages() {
		
		homePage= PageFactory.initElements(driver, FlightHomePage.class);
		resultPage= PageFactory.initElements(driver, FlightSearchResultPage.class);
		
	}
	
	public void closeBrowser() {
		driver.quit();
	}

}
