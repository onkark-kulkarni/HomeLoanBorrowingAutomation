package wipro.HomeLoanBorrowing.stepDefinitions;

import wipro.HomeLoanBorrowing.functions.CommonFunctions;

public class ConfigEntry {

	public static CommonFunctions commonLib;
	public static void beforeClassConfig(CommonFunctions fnLib) {
		commonLib=fnLib;
		commonLib.openApplication();
		}
	
	public void reportConfig(String tTitle) {
		commonLib.initReport(tTitle);
		
	}
	
}
