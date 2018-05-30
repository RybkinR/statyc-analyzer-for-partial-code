Feature: Static analyzer

  Scenario: Task1
  	Then check that contains FOR statement
  	And check for no unused actions
  	When code is complemented to full
  	Then check style google
  	When code is compiled
  	Then run program over test set
  	
  	