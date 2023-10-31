package FTVTestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class FTV_Build_RCFW extends BaseTest{

	@Test
	public void SWVersion_RFW() throws InterruptedException {
		
		System.out.println("Home screen");
		
		
		//((AndroidDriver<?>) driver).startActivity(new Activity("com.amazon.tv.launcher.ui.HomeActivity_vNext", "com.amazon.tv.launcher"));
		
		driver.findElement(By.id("com.amazon.tv.launcher:id/nav_bar_app_overflow")).click();
		

		// Till App drawer click then right from D-Pad

		((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.DPAD_RIGHT));
		 
		Thread.sleep(2000);
		((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
		
		
		List<WebElement> settingsElement = (List<WebElement>) driver.findElements(By.className("android.widget.LinearLayout"));
		 
		 WebDriverWait wait= new WebDriverWait(driver,5);
		 wait.until(ExpectedConditions.visibilityOfAllElements(settingsElement));

		WebElement wifiElement = settingsElement.get(12);
		wifiElement.click();
		
		
	    WebElement aboutElement	=driver.findElement(By.xpath("//*[@text='About']"));
	    aboutElement.click();
	    
	    
	    
	   WebElement buildElement= driver.findElement(By.id("com.amazon.tv.settings.v2:id/about_version_value"));
	    System.out.println("Fire OS Build Version :"+ buildElement.getText());
		
		driver.quit();
	}
	
	
}
