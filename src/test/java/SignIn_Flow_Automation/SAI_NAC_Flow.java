package SignIn_Flow_Automation;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utility.Helper;
import webPages.BaseClass;
import webPages.HomePage;
import webPages.ServiceabilityModal;

public class SAI_NAC_Flow extends BaseClass {
	
	@BeforeMethod()
	public void setUp(ITestResult result) {
        //String className = result.getTestClass().getName(); // CLASS NAME WITH PACKAGE
        String className= result.getTestClass().getRealClass().getSimpleName();
        String methodName = result.getMethod().getMethodName(); // Get the method name
        createTest(className, methodName); // Create the test with class and method names
    }
	@Test()
	public void ShopInternet() throws InterruptedException {
	
		String fullPageScreenshot = Helper.takeFullPageScreenshot(driver);
        logger.addScreenCaptureFromPath(fullPageScreenshot);
        log("Executing ShopInternet Method",1);
	
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		HomePage.IgniteInternetShopButton().click();
		HomePage.ShopInternetOption().click();
		Thread.sleep(10000);
		assertTrue(true);
	

	}

	@Test(dependsOnMethods = "ShopInternet")
	public void Serviceability() throws InterruptedException {
		
		
		
		log("Executing Serviceability Method",2);
		
		ServiceabilityModal SM = PageFactory.initElements(driver, ServiceabilityModal.class);
		String Address = config.ServiceableAddress();
		SM.ServiceabilityCheck(Address, driver);
		assertTrue(true);

	}

}
