package ListenerClasses;


import org.testng.ITestResult;

public class ListenerTestNg {
   
	
	// when test case get failed, this method is called.
	public void onTestFailure(ITestResult Result) 
	{
		System.out.println("Test is failed  :"+ Result.getName());
	}
	// When test case get skipped, this method is called
	public void onTestSkipped(ITestResult Result) 
	{
		System.out.println("Test is  skipped :"+ Result.getName());
	}
	
	public void onTestSatart(ITestResult Result) 
	{
		System.out.println("Test is Start"+Result.getName());
	}
	// When test case get passed, this method is called
	public void onTestSuccess(ITestResult Result) 
	{
		System.out.println("Test Passed is "+ Result.getName());
	}

}
