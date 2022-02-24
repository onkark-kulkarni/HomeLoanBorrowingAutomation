package wipro.HomeLoanBorrowing.functions;

import org.testng.Assert;

public class FunctionsHomeLoanBorrowing extends CommonFunctions {

	static FunctionsHomeLoanBorrowing fnLib = null;

	private FunctionsHomeLoanBorrowing(String module) {
		super(module);

	}

	public static FunctionsHomeLoanBorrowing getInstance(String module) {
		if (fnLib == null) {
			fnLib = new FunctionsHomeLoanBorrowing(module);
		}
		return fnLib;
	}

	public void verifyHomeLoanBorrowingPage() {
		String actualPageTitle = getPageTitle();
		Assert.assertEquals(actualPageTitle, "Home loan borrowing power calculator | ANZ");

	}

	public void verifyBorrowingEstimate(String applicationType, String numberOfDependents, String homeToLiveIn,
			String annualIncome, String otherIncome, String livingExpense, String currentHomeLoan, String otherLoan,
			String otherCommitments, String creditCardLimit) {
		clickOnElement("estimatePage:APPTYPESINGLE");
		selectFromDropDown("estimatePage:NUMBEROFDEPENDENTS", "text", numberOfDependents);
		if (homeToLiveIn.equalsIgnoreCase("Home to live in")) {
			clickOnElement("estimatePage:BUYHOMETO_LIVEIN");
		} else {
			clickOnElement("estimatePage:BUYHOMETO_INVESTMENT");
		}

		enterText("estimatePage:ANNUALINCOME", annualIncome);
		enterText("estimatePage:OTHERINCOME", otherIncome);
		enterText("estimatePage:LIVINGEXPENSES", livingExpense);
		enterText("estimatePage:CURRENTHOMELOAN", currentHomeLoan);
		enterText("estimatePage:OTHERLOANS", otherLoan);
		enterText("estimatePage:COMMITMENTS", otherCommitments);
		enterText("estimatePage:CREDITCARDLIMIT", creditCardLimit);

	}

	public void verifyBorrowingEstimateIsCalculation(String expectedEstimate) {
		waitForElement("estimatePage:WAITSPAN");

		Assert.assertEquals(getElementText("estimatePage:ESTIMATE"), expectedEstimate,
				"Actual and Expected estimate are different");

	}

	public void clickOnWorkoutButton() {
		clickOnElement("estimatePage:WORKOUTBUTTON");

	}

	public void clickOnStartOverButton() {
		clickOnElement("estimatePage:STARTOVERBUTTON");
		waitForElement("estimatePage:WORKOUTBUTTON");

	}

	public void verifyFormIsCleared() {
		Assert.assertEquals(getElementText("estimatePage:ESTIMATE"), "$0", "Form is not cleared");
		Assert.assertTrue(getElement("estimatePage:WORKOUTBUTTON").isDisplayed());

	}

	public String getDefaultValue(String locator) {
		return getElementAttribute(locator, "value");
	}

	public void verifyMessageForFillingOnlyLivingExpenses(String message) {
		Assert.assertEquals(getElementText("estimatePage:MESSAGE"), "Incorrect message is displayed",message);
	}

}
