package webPages;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import Utility.BrowserFactory;
import Utility.ConfigureDataFile;
import Utility.ExcelDataProvider;
import Utility.Helper;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigureDataFile config;
	public static ExtentSparkReporter SparkReporter;
	public static ExtentReports report;
	public static ExtentTest logger;
	public File file;

	@BeforeSuite()
	public void suiteSetup() {
		String ReportPath = System.getProperty("user.dir") + "\\Reports\\SAIFlowReport_" + Helper.getTimeStamp()
				+ ".html";
		file = new File(ReportPath);
		SparkReporter = new ExtentSparkReporter(file);
		report = new ExtentReports();
		report.attachReporter(SparkReporter);

	}

	@BeforeClass()
	public void ApplicationLaunch() throws IOException {
		config = new ConfigureDataFile();
		excel = new ExcelDataProvider();
		driver = BrowserFactory.DriverLaunch(driver, config.getBrowser(), config.getTestURL());

	}

	@AfterClass()
	public void AppClosure() throws InterruptedException {
		BrowserFactory.BrowserClosing(driver);

		Thread.sleep(2000);

	}

	@AfterMethod()
	public void getSceenShot(ITestResult result) {

		logger.assignAuthor("Sanjeev Kumar");
		logger.assignDevice("Desktop/Laptop Window Chrome Browser");
		logger.assignCategory("Functional");
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.fail(result.getName()+"Test has got failed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.CapturedScreenShot(driver)).build());
			logger.fail(result.getThrowable());
		
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.pass(result.getName()+"Test has got pass",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.CapturedScreenShot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			logger.skip(result.getName()+"Test has got Skipped",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.CapturedScreenShot(driver)).build());
			logger.skip(result.getThrowable());
			
		}

	}

	@AfterSuite()
	public void ReportFlush() {
		report.flush();
		try {
			Desktop.getDesktop().browse(file.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void log(String message,int number) {
		
switch (number) {
	case 1:
		logger.log(Status.FAIL, MarkupHelper.createLabel("<u><i><b>" + message + "<b/><i/><u/>", ExtentColor.RED),
				MediaEntityBuilder.createScreenCaptureFromPath(Helper.CapturedScreenShot(driver)).build());
		report.flush();
		
		break;
	case 2:
		logger.log(Status.SKIP, MarkupHelper.createLabel("<u><i><b>" + message + "<b/><i/><u/>", ExtentColor.YELLOW),
				MediaEntityBuilder.createScreenCaptureFromPath(Helper.CapturedScreenShot(driver)).build());
		report.flush();
		
		break;
	case 3:
		logger.log(Status.WARNING, MarkupHelper.createLabel("<u><i><b>" + message + "<b/><i/><u/>", ExtentColor.PINK),
				MediaEntityBuilder.createScreenCaptureFromPath(Helper.CapturedScreenShot(driver)).build());
		report.flush();
		
		break;
	case 4:
		logger.log(Status.PASS, MarkupHelper.createLabel("<u><i><b>" + message + "<b/><i/><u/>", ExtentColor.GREEN),
				MediaEntityBuilder.createScreenCaptureFromPath(Helper.CapturedScreenShot(driver)).build());
		report.flush();
		break;
	case 5:
		logger.log(Status.INFO, MarkupHelper.createLabel("<u><i><b>" + message + "<b/><i/><u/>", ExtentColor.ORANGE),
				MediaEntityBuilder.createScreenCaptureFromPath(Helper.CapturedScreenShot(driver)).build());
		report.flush();
		
		break;
		
		default:
			System.out.println("No log configured here");
}

	}

	public void createTest(String className, String methodName) {
		logger = report.createTest(className + " - " + methodName);
	}
	
	 
}
