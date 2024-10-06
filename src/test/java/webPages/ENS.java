package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ENS {

	public WebDriver driver;

	public void PageFactory(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(xpath = "(//input)[1]")
	private WebElement ENSSignInArea;

	public WebElement ENSSignInArea() {
		return ENSSignInArea;
	}

	@FindBy(xpath = "//input[@type=\"submit\"]")
	private WebElement ENSSignInButton;

	public WebElement ENSSignInButton() {
		return ENSSignInButton;
	}

	@FindBy(xpath = "//input[@name=\"passwd\"]")
	private WebElement ENSPasswordArea;

	public WebElement ENSPasswordArea() {
		return ENSPasswordArea;
	}

	@FindBy(xpath = "//input[@type=\"submit\"]")
	private WebElement ClickSignInENS;

	public WebElement ClickSignInENS() {
		return ClickSignInENS;
	}

	@FindBy(xpath = "//input[@type=\"submit\"]")
	private WebElement YesArea;

	public WebElement YesArea() {
		return YesArea;
	}

	@FindBy(xpath = "//input[@id=\"contactEmail\"]")
	private WebElement ENSEmailInput;

	public WebElement ENSEmailInput() {
		return ENSEmailInput;
	}

	@FindBy(xpath = "//input[@id=\"searchNotificationInViewer\"]")
	private WebElement SearchNotificationButton;

	public WebElement SearchNotificationButton() {
		return SearchNotificationButton;
	}

	@FindBy(xpath = "(//a[@class=\"img_html_png\"])[1]")
	private WebElement ENSMsg;

	public WebElement ENSMsg() {
		return ENSMsg;

	}

	public void ENSMsgClick() throws InterruptedException {
		Thread.sleep(3000);
		ENSMsg.click();
	}

	
}
