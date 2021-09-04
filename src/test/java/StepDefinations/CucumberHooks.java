package StepDefinations;

import com.sample.DemoBBDSeleniumProject.base.BaseWebPage_stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks {
	
	public static BaseWebPage_stepdef test;
	
	@Before
	public void tearUP() {
		test= new BaseWebPage_stepdef();
	}
	
	@After
	public void teardown() {
		test.closeBrowser();
	}

}
