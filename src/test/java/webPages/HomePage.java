package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	public WebDriver driver;

	public void FageFactory(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(xpath = "//span[text()=\"Ignite Internet\"]")
	private WebElement IgniteInternetShopButton;

	public WebElement IgniteInternetShopButton() {
		return IgniteInternetShopButton;
	}

	@FindBy(xpath = "//span[text()=\"Shop internet\"]")
	private WebElement ShopInternetOption;

	public WebElement ShopInternetOption() {
		return ShopInternetOption;
	}

	@FindBy(xpath = "//span[text()=\"MyRogers\"]")
	private WebElement SignInArea;

	public WebElement SignInArea() {
		return SignInArea;
	}

	@FindBy(xpath = "//input[@id=\"ds-form-input-id-0\"]")
	private WebElement UserNameField;

	public WebElement UserNameInpur() {
		return UserNameField;
	}

	@FindBy(xpath = "//span[text()=\"Continue\"]")
	private WebElement ContinueButton;

	public WebElement ContinueButton() {
		return ContinueButton;
	}

	@FindBy(xpath = "//span[text()=\" Try Again \"]")
	private WebElement TryAgainButton;

	public WebElement TryAgainButton() {
		return TryAgainButton;
	}

	@FindBy(xpath = "//input[@name=\"input_password\"]")
	private WebElement PasswordField;

	public WebElement PasswordField() {
		return PasswordField;
	}

	@FindBy(xpath = "//span[text()=\"Sign in\"]")
	private WebElement SignInButton;

	public WebElement SignInButton() {
		return SignInButton;
	}

	@FindBy(xpath = "(//span[@role=\"text\"]/child::span)[3]")
	private WebElement EmailLink;

	public WebElement EmailLink() {
		return EmailLink;
	}

	@FindBy(xpath = "(//input)[2]")
	private WebElement OTPArea;

	public WebElement OTPArea() {
		return OTPArea;
	}

	public void LoginToRogersApplication(String username, String Password) throws InterruptedException {
		UserNameField.click();
		UserNameField.sendKeys(username);
		Thread.sleep(5000);
		ContinueButton.click();
		Thread.sleep(5000);
		TryAgainButton.click();
		Thread.sleep(2000);
		ContinueButton.click();
		Thread.sleep(3000);
		PasswordField.sendKeys(Password);
	}

	public void ClickOnSignin() throws InterruptedException {
		Thread.sleep(3000);
		SignInButton.click();
	}

	public void EnterOTP(String OTP) throws InterruptedException {
		Thread.sleep(3000);
		OTPArea.sendKeys(OTP);
	}

}
