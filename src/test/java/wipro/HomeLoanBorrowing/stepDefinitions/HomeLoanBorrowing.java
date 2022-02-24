package wipro.HomeLoanBorrowing.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import wipro.HomeLoanBorrowing.functions.FunctionsHomeLoanBorrowing;

public class HomeLoanBorrowing extends ConfigEntry {
	static FunctionsHomeLoanBorrowing fnLib;

	@BeforeAll
	public static void before_Class() {
		System.out.println("before class");
		fnLib = FunctionsHomeLoanBorrowing.getInstance("HomeLoanBorrowing");
		beforeClassConfig(fnLib);
	}

	@Given("user is on Home loan borrowing power calculator ANZ page")
	public void user_is_on_home_loan_borrowing_power_calculator_anz_page() {
		fnLib.verifyHomeLoanBorrowingPage();

	}

	@When("User enters the data in Your details, Your earnings and Your expenses as  {string} , {string} , {string} , {string}, {string},{string},{string},{string},{string},{string}")
	public void user_enters_the_data_in_your_details_your_earnings_and_your_expenses_as(String applicationType,
			String numberOfDependents, String homeToLiveIn, String annualIncome, String otherIncome,
			String livingExpense, String currentHomeLoan, String otherLoan, String otherCommitments,
			String creditCardLimit) {
		fnLib.verifyBorrowingEstimate(applicationType, numberOfDependents, homeToLiveIn, annualIncome, otherIncome,
				livingExpense, currentHomeLoan, otherLoan, otherCommitments, creditCardLimit);

	}

	@When("User clicks on Work out how much I could borrow button")
	public void user_clicks_on_work_out_how_much_i_could_borrow_button() {
		fnLib.clickOnWorkoutButton();
	}

	@Then("borrowing estimate should be {string}")
	public void borrowing_estimate_should_be(String expectedEstimate) {
		fnLib.verifyBorrowingEstimateIsCalculation(expectedEstimate);

	}

	@When("User clicks on Start Over button")
	public void user_clicks_on_start_over_button() {
		fnLib.clickOnStartOverButton();
	}

	@Then("All fields get reset to default values")
	public void all_fields_get_reset_to_default_values() {
		fnLib.verifyFormIsCleared();
	}

	@Then("message is displayed as {string}")
	public void message_is_displayed_as(String message) {
		fnLib.verifyMessageForFillingOnlyLivingExpenses(message);
	}

	@AfterAll
	public static void teardown_after_all() {
		fnLib.closeAll();
	}
}
