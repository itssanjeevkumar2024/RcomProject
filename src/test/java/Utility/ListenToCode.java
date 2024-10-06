package Utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenToCode implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod()+" :Now Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getTestName()+" :has been executed successfully");	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getTestName()+" :has been failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getTestName()+" :has been skipped");
	}

	/*@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}*/

	@Override
	public void onStart(ITestContext context) {
		System.out.println(context.getName()+" :Start Choore");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(context.getName()+" :Execution done");
	}
	

}
