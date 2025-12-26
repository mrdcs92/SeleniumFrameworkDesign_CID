@tag
Feature: Error validation
		
	Background:
	Given I landed on Ecommerce Page	
		
	@ErrorValidation
	Scenario Outline:Title Positive Test of Submitting the order
		Given Logged in with username <name> and password <password>
		Then "Incorrect email or password." message is displayed

		
		Examples:
			| name  				| password 			  |
			| misterdcs92@gmail.com | 1999222st!taN199922 |
			

