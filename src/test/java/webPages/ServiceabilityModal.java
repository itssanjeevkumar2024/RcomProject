package webPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ServiceabilityModal {
	
	

	public WebDriver driver;
	
	
	public void FageFactory(WebDriver driver) {
		this.driver=driver;
	
	}
	
	@FindBy(xpath="//input[@id=\"ds-form-input-id-0\"]")
	private WebElement AddessInptArea;
	public WebElement AddessInptArea() {
		return AddessInptArea;
	}
	
	@FindBy(xpath="//span[text()=\" Check address \"]")
	private WebElement CheckAddressButton;
	public WebElement CheckAddressButton() {
		return CheckAddressButton;
	}
	
	@FindBy(xpath="//span[text()=\"OK\"]")
	private WebElement OKButton;
	public WebElement OKButton() {
		return OKButton;
	}
	
	public WebDriver ServiceabilityCheck(String address, WebDriver driver) throws InterruptedException {
		AddessInptArea().sendKeys(address);
		Actions a=new Actions(driver);
		a.keyDown(Keys.ENTER).perform();
		a.keyUp(Keys.ENTER).perform();
		Thread.sleep(2000);
		a.keyDown(Keys.ARROW_DOWN).perform();
		a.keyUp(Keys.ARROW_DOWN).perform();
		Thread.sleep(2000);
		a.keyDown(Keys.ENTER).perform();
		a.keyUp(Keys.ENTER).perform();
		Thread.sleep(2000);
		a.keyDown(Keys.TAB).perform();
		a.keyUp(Keys.TAB).perform();
		Thread.sleep(2000);
		CheckAddressButton().click();
		
		return driver;
		
		
	}

	
	
	
	

}

