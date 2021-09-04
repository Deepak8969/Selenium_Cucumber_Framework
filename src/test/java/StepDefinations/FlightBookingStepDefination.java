package StepDefinations;

import java.text.ParseException;

import org.testng.Assert;

import com.sample.DemoBBDSeleniumProject.base.BaseWebPage_stepdef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlightBookingStepDefination {
	
	private BaseWebPage_stepdef test= CucumberHooks.test;
	
	
	@When("User provide the source {string} and destination {string} details")
	public void user_provide_the_source_and_destination_details(String source, String destination) throws InterruptedException {
	   test.homePage.enterKeywordInSourceSearchBox(source);
	   test.homePage.enterKeywordInDestinationSearchBox(destination);
	}
	
	@When("User provide the departure date details")
	public void user_provide_the_departure_date_details() {
		test.homePage.selectDateFromTheCalender();
	    
	}
	
	@When("User click on search flight button")
	public void user_click_on_search_flight_button() {
	    test.homePage.performSearch();
	}
	
	@Then("User is navigated to Flight Search result page")
	public void user_is_navigated_to_flight_search_result_page() {
		test.resultPage.handlePopup();
	}
	
	@When("User Book the flight with price more than {string} and timing post {string}")
	public void user_select_the_flight_with_price_more_than_and_timing_post(String price, String timing) throws ParseException, InterruptedException {
	   test.resultPage.selectTheFlightBasedOnTimingandPrice(price,timing);
	}
	
	
	@Then("User is navigated to Confirmation page with label {string} or {string}")
	public void user_is_navigated_to_confirmation_page_with_label(String label, String label2) {
		test.resultPage.windowHandles();
		Assert.assertTrue((test.resultPage.getConfirmationconfirmbookingLabel().toString().equals(label))||(test.resultPage.getConfirmationconfirmbookingLabel().toString().equals(label2)));
	}

}
