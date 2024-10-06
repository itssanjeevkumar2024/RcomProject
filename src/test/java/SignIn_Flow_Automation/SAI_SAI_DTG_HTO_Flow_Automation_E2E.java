package SignIn_Flow_Automation;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utility.Helper;
import webPages.BaseClass;
import webPages.ENS;
import webPages.HomePage;



public class SAI_SAI_DTG_HTO_Flow_Automation_E2E extends BaseClass {
	public ENS ENSObject;
	
	@BeforeMethod()
	public void setUpExtentTestObject(ITestResult result) {
		//String className = result.getTestClass().getName(); // CLASS NAME WITH PACKAGE
        String className= result.getTestClass().getRealClass().getSimpleName();
        String methodName = result.getMethod().getMethodName(); // Get the method name
        createTest(className, methodName); // Create the test with class and method names
		
	}

	@Test()
	public void LoginInToRogersWebsite() throws InterruptedException, IOException {
		
		log("Executing ShopInternet Method",3);
		String fullPageScreenshot = Helper.takeFullPageScreenshot(driver);
        logger.addScreenCaptureFromPath(fullPageScreenshot);
		HomePage HP = PageFactory.initElements(driver, HomePage.class);
		log("Browser is launching",4);
		HP.SignInArea().click();
		log("Clicked on MyRogers",4);
		HP.LoginToRogersApplication(excel.getStringData(0, 1, 1), excel.getStringData(0, 1, 2));
		log("Enter the Login Credenials",4);
		HP.ClickOnSignin();
		log("Click on Sign in button",4);
		Thread.sleep(3000);
		HP.EmailLink().click();
		Thread.sleep(5000);
		log("Click on EmailLink",1);
		assertTrue(true);
		
	}

	@Test(dependsOnMethods = "LoginInToRogersWebsite")
	public void ENSLaunch() {
		
		log("Launching ENS app to check the OTP",4);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open('"+config.getENSURL()+"')");
		assertTrue(true);
		
	}
	
	@Test(dependsOnMethods="ENSLaunch")
	public void SignInToENSPortal() throws InterruptedException {
		
		log("Signining in ENS App",5);
		ENSObject = PageFactory.initElements(driver, ENS.class);
		Set<String> windowsID = driver.getWindowHandles();
		Iterator<String> it = windowsID.iterator();
		String rogersWindow = it.next();
		System.out.println("Rogers Window ID:" + rogersWindow);
		Thread.sleep(2000);
		String ENSWindow = it.next();
		System.out.println("ENS Window ID:"+ENSWindow);
		driver.switchTo().window(ENSWindow);
		ENSObject.ENSSignInArea().sendKeys(config.getENSSignInEmail());
		Thread.sleep(2000);
		ENSObject.ENSSignInButton().click();
		Thread.sleep(2000);
		ENSObject.ENSPasswordArea().sendKeys(config.getENSSignInPassword());
		Thread.sleep(2000);
		ENSObject.ClickSignInENS().click();
		Thread.sleep(2000);
		ENSObject.YesArea().click();
		Thread.sleep(2000);
		assertTrue(true);
	}
	@Test(dependsOnMethods="SignInToENSPortal")
	public void SearchEmailInENS() throws InterruptedException {
		
		log("Searching Email in ENS",2);
		ENSObject.ENSEmailInput().sendKeys(config.getENSSearchEmail());
		Thread.sleep(3000);
		ENSObject.SearchNotificationButton().click();
		Thread.sleep(4000);
		assertTrue(true);
	}
	
	/*@Test(dependsOnMethods="SearchEmailInENS")
	public void ReadingENSOTP() throws InterruptedException {
		ENSOTP ensOTP = PageFactory.initElements(driver,ENSOTP.class);
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> wdl = ids.iterator();
		System.out.println("Main Window:" + wdl.next()+"ENS WINDOW: "+ wdl.next());
		String OTPWindow= wdl.next();
		Thread.sleep(3000);
		driver.switchTo().window(OTPWindow);
		Thread.sleep(3000);
		ensOTP.OTP().click();
		String OTP=ensOTP.ENSOTPReading();
		System.out.println(OTP);
		
		
		

	}*/

}
