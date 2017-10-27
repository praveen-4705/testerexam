Feature: Google Calculator 
	Calculator should calculate correct calculations

Scenario Outline: Add numbers 
	Given I am on google calculator page 
	When I add number "<number1>" to number "<number2>" 
	Then I should get an answer of "<answer>" 
	
	Examples: 
		| number1 | number2 | answer |
		| 1       | 2       | 3      |
		| 4       | 5       | 9      |
		
Scenario Outline: Subtract numbers 
	Given I am on google calculator page 
	When I subtract number "<number1>" to number "<number2>" 
	Then I should get an answer of "<answer>" 
	
	Examples: 
		| number1 | number2 | answer |
		| 10      | 5       | 5      |
		| 15      | 10      | 5     |