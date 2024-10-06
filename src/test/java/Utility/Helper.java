package Utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Helper {

	public static String CapturedScreenShot(WebDriver driver) {
		String SSPath = System.getProperty("user.dir") + "\\ScreenShot\\image_" + getTimeStamp() + ".jpg";

		File img = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(img, new File(SSPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SSPath;

	}

	public static String getTimeStamp() {
		// Calendar c=Calendar.getInstance();
		// Date D = c.getTime();
		// String timeStamp = D.toString().replace(":","_").replace(" ","_");
		DateFormat format = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date d = new Date();
		String timeStamp = format.format(d);
		return timeStamp;
	}

	public static String takeFullPageScreenshot(WebDriver driver) {

		String SSPathFullPage = System.getProperty("user.dir") + "\\FullPageSS\\image_" + getTimeStamp() + ".jpg";
		Screenshot fullPageSS = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver);
		try {
			ImageIO.write(fullPageSS.getImage(), "jpg", new File(SSPathFullPage));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SSPathFullPage;
	}

}
