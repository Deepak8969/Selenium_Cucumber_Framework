Feature: Flight Booking

@Test
Scenario Outline: Verify the Flight Booking Functionality based on User requirement
When User provide the source "<SourceCity>" and destination "<DestinationCity>" details
And User provide the departure date details
And User click on search flight button
Then User is navigated to Flight Search result page
When User Book the flight with price more than "<RequiredPrice>" and timing post "<RequiredTiming>"
Then User is navigated to Confirmation page with label "Complete your booking" or "Review your booking"


Examples:
|SourceCity	|DestinationCity|RequiredPrice|RequiredTiming	|
|Delhi			|Kolkata				|5000					|7:30 PM				|