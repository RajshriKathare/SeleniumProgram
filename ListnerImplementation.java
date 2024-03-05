package CommonUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementation implements ITestListener {

	
	ExtentReports report;
	

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//Reporter is class & call method Log(String s)
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"TestScript is started",true);
		
		
		
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		//Reporter.log(methodName+"TestScript is passed",true);
		
		
		
		
		
		
	
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		// getThrowable() throws exception or error immediately with the report
		String message = result.getThrowable().toString();
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"TestScript is failed"+message,true);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"TestScript is skipped",true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"TestScript is failed within success percentage",true);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"TestScript is FailedWithTimeout ",true);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//Reporter.log("TestScript is start",true);
		
		JavaUtil jutil = new JavaUtil();
		
  // **Use  ExtentSparkReporter class just to configure the extent
		
		
		// Step1: Create object of 
				ExtentSparkReporter reporter = new ExtentSparkReporter("./extentreport/report"+jutil.getRandomNumber()+".html");
				
		/*step2: call config()	method to configure extent report and call setDocumentTitle() method
				to give title for the report*/
				
				reporter.config().setDocumentTitle("vtigerCRM");
				
		// Step3: call setTheme() to set theme for extent report either
	    // Standard or dark
				reporter.config().setTheme(Theme.STANDARD);
				
		// step4: call method setReportName() to set name to extent report
				reporter.config().setReportName("Pune");
				
		
   // Step5: create object of extent report to generate extent report
				 report = new ExtentReports();
				
				
				
		// step6: call attachReporter() method  to add all configurations to extent report 
				report.attachReporter(reporter);
				
		// step7: call setSystemInfo() to give extra information to report
				report.setSystemInfo("OS", "Windows");
				report.setSystemInfo("Browser", "Chrome");
				report.setSystemInfo("Chromeversion", "121");
				report.setSystemInfo("Author", "Rajshri");
				
		// step8: call the method flush(); in onFinish() method;
				
				
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//Reporter.log("TestScript is finish",true);
		report.flush();
		
		
		
	}
}
