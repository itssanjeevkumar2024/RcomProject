package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ENSOTP {
	public WebDriver driver;
	public void PageFactory(WebDriver driver) {
		this.driver=driver;
	}
	

	@FindBy(xpath="//a[@href=\"#\"]")
	private WebElement OTP;
	public WebElement OTP() {
		return OTP;
	}
	public String ENSOTPReading() throws InterruptedException {
		Thread.sleep(3000);
		String OTPText = OTP.getText();
		System.out.println(OTPText);
		return OTPText;

	}

}
