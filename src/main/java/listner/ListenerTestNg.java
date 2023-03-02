package listner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTestNg implements ITestListener{
   
	public void onFinish(ITestContext Result) 
	{
		
	}
	public void onStart(ITestContext Result) 
	{
		
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) 
	{
		
	}
	// when test case get failed, this method is called.
	public void onTestFailure(ITestResult Result) 
	{
		System.out.println("The name of TestCase failed is :"+ Result.getName());
	}
	// When test case get skipped, this method is called
	public void onTestSkipped(ITestResult Result) 
	{
		System.out.println("The name of TestCase skipped is :"+ Result.getName());
	}
	
	public void onTestSatart(ITestResult Result) 
	{
		
	}
	// When test case get passed, this method is called
	public void onTestSuccess(ITestResult Result) 
	{
		System.out.println("The name of TestCaseget Passed is "+ Result.getName());
	}

}
