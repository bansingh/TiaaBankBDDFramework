Feature: TIAA Submit Application feature 

Scenario: TIAA Submit Application Scenario

	Given user is already on Home Page 
	When title of Home page is TIAA Bank :: Bank on Better: High Yields, Home Loans, 24/7 Support  
	Then user clicks on Open an account button 
	Then user selects product 
	Then user click on Start Application button 
	Then user is redirected to Online Application page 
	Then user clicks on Continue button 
	Then user enters opening deposit amount 
		| OpeningDeposit |
		| 6000 |
	Then user clicks on continue button 
	Then user enters Applicant details 
	Then user clicks on ApplicantDetailsContinue button 
	Then user clicks on ReviewInfoContinue button 
	Then user Esigns and accepts the disclosures 
	Then user clicks on Submit Application button 
	#Then user enters funding details
	#Then user clicks on Choose Funding continue button
