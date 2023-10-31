package FTVTestCases;


import java.util.Arrays;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import GTVTestCases.GenericMethod;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class FTVSettings_Wifi extends BaseTest {

	@Test
	public void Settingsfunction() throws Exception {

		System.out.println("Redmi Fire TV Home Screen");
		Thread.sleep(2000);
		((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.SETTINGS));

		String[] longpresshomeStrings = { "Programme Guide", "Display Mirroring", "Apps", "Inputs" };
		List<String> setStrings = Arrays.asList(longpresshomeStrings);

		List<WebElement> longpreeH = (List<WebElement>) driver.findElements(By.id("com.amazon.tv.quicksettings.ui:id/button_one_line_title"));

		for (WebElement text : longpreeH) {
			for (String optnString : setStrings) {

				if (optnString.equalsIgnoreCase(text.getText())) {
					System.out.println("Options available: " + text.getText());}}}

		((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.BACK));

	
		driver.findElement(By.id("com.amazon.tv.launcher:id/nav_bar_app_overflow")).click();
	
		
		
//		WebDriverWait waittime= new WebDriverWait(driver,20);
//		
//		waittime.until(ExpectedConditions.visibilityOfAllElements(moreAppsiconElement));
//		moreAppsiconElement.click();

		
		

		// Till App drawer click then right from D-Pad

		((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.DPAD_RIGHT));
		((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));

		//Thread.sleep(200);
		
		
		 
		 
		// WIFI tab search
		List<WebElement> settingsElement = (List<WebElement>) driver.findElements(By.className("android.widget.LinearLayout"));
		 
		 WebDriverWait wait= new WebDriverWait(driver,7);
		 wait.until(ExpectedConditions.visibilityOfAllElements(settingsElement));

		WebElement wifiElement = settingsElement.get(3);
		wifiElement.click();

		// click on see all SSIDs and check for SSID connected or not

		driver.findElement(By.xpath("//*[contains(@text,'All Networks')]")).click();
		
		//wifi status and scroll n connect if not connected

		Thread.sleep(200);
		
		
	   List< WebElement> wificonnected=(List<WebElement>) driver.findElements(By.id("com.amazon.tv.settings.v2:id/action_description"));
		
		if(wificonnected.get(0).getText().equalsIgnoreCase("Connected"))
		{System.out.println("wifi status is connected");
		GenericMethod.captureScreen(driver);}
		else {
			System.out.println("wifi status is not connected");
			
			String wifissidElement = driver.findElement(By.xpath("//*[contains(@text,'Tvqmo-5G')]")).getText();
			GenericMethod.scrollUI(driver, wifissidElement).click();
		}
		

		 driver.quit();

	}

}
