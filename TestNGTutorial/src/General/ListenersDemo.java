package General;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersDemo implements ITestListener{
	
	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("TEST EXECUTION FAILED");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("SUCCESSFULLY IMPLEMENTED LISTENER");
	}
	

}
