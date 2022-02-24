package wipro.HomeLoanBorrowing.functions;

import wipro.HomeLoanBorrowing.util.*;

public class CommonFunctions extends DriverFunctions {

	public CommonFunctions(String module) {
		super(module);
		
	}

	public void openApplication() {
		openAppURL(getConfigValue("URL"));
		browserMaximize();
		waitForElement("estimatePage:APPTYPESINGLE");
	}
		

}
