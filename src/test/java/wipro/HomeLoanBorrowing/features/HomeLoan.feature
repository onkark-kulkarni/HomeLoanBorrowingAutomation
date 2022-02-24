Feature: Borrowing calculator 

Scenario Outline: Verify borrowing amount calculation for given input data 

	Given user is on Home loan borrowing power calculator ANZ page 
	When User enters the data in Your details, Your earnings and Your expenses as  "<applicationType>" , "<numberOfDependents>" , "<homeToLiveIn>" , "<annualIncome>", "<otherIncome>","<livingExpense>","<currentHomeLoan>","<otherLoan>","<otherCommitments>","<creditCardLimit>" 
	And User clicks on Work out how much I could borrow button 
	Then borrowing estimate should be "$479,000" 
	
	Examples: 
	
		| applicationType|numberOfDependents|homeToLiveIn   |annualIncome|otherIncome|livingExpense|currentHomeLoan|otherLoan|otherCommitments|creditCardLimit|
		|    Single      |         0        |Home to live in|    80000   |   10000   |      500    |       0       |   100   |        0       |    10000      |
		
		
Scenario Outline: Verify that Start Over button clears all fields 

	Given user is on Home loan borrowing power calculator ANZ page 
	When User enters the data in Your details, Your earnings and Your expenses as  "<applicationType>" , "<numberOfDependents>" , "<homeToLiveIn>" , "<annualIncome>", "<otherIncome>","<livingExpense>","<currentHomeLoan>","<otherLoan>","<otherCommitments>","<creditCardLimit>" 
	And User clicks on Start Over button 
	Then All fields get reset to default values 
	
	Examples: 
	
		| applicationType|numberOfDependents|homeToLiveIn   |annualIncome|otherIncome|livingExpense|currentHomeLoan|otherLoan|otherCommitments|creditCardLimit|
		|    Single      |         0        |Home to live in|    80000   |   10000   |      500    |       0       |   100   |        0       |    10000      |
		
		
Scenario Outline: Verify the message displayed on entering only Living expenses and keeping all fields as blank 

	Given user is on Home loan borrowing power calculator ANZ page 
	When User enters the data in Your details, Your earnings and Your expenses as  "<applicationType>" , "<numberOfDependents>" , "<homeToLiveIn>" , "<annualIncome>", "<otherIncome>","<livingExpense>","<currentHomeLoan>","<otherLoan>","<otherCommitments>","<creditCardLimit>" 
	And User clicks on Work out how much I could borrow button 
	Then message is displayed as "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 100 641." 
	
	Examples: 
	
		| applicationType|numberOfDependents|homeToLiveIn   |annualIncome|otherIncome|livingExpense|currentHomeLoan|otherLoan|otherCommitments|creditCardLimit|
		|    Single      |         0        |Home to live in|      0     |     0     |      1      |       0       |    0    |        0       |        0      |
