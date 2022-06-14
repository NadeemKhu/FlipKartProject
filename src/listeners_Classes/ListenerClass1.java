package listeners_Classes;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass1 implements ITestListener {
	
	public void onTestStart(ITestResult result) 
	{
			System.out.println(result.getName() + " Test is Started" );
	  
	}

	  
	  public void onTestSuccess(ITestResult result) 
	  {
		  System.out.println(result.getName() + " Test is Success" );
	  }

	  
	  public void onTestFailure(ITestResult result) 
	  {
		  System.out.println(result.getName() + " Test is Failed" );
	  }

	  
	  public void onTestSkipped(ITestResult result)
	  {
		  System.out.println(result.getName() + " Test is Skipped" );
	  }

}
