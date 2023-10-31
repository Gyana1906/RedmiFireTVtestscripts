package FTVTestCases.PageObject;

import javax.sound.midi.SysexMessage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import FTVTestCases.BaseTest;
import io.appium.java_client.MobileBy;

public class FTV_InputTest_Framework  extends BaseTest{
	
	@Test
	public void InputTest() throws InterruptedException {
		
		System.out.println("FTV UI");
		driver.findElement(By.id("com.amazon.tv.launcher:id/nav_bar_inputs_text_icon")).click();
		
		
		Thread.sleep(2000);
		driver.findElement(MobileBy.AccessibilityId("HDMI1")).click();
		Thread.sleep(2000);
		
	
		
		//com.amazon.tv.inputpreference.service:id/passthroughTvView
try {
	
	if(!(driver.findElement(By.id("com.amazon.tv.inputpreference.service:id/passthroughTvView")).isDisplayed()))
	{		
//	WebElement inputElement=driver.findElement(By.className("android.widget.TextView"));
//	if (inputElement.getText().contains("No signal")) {
	System.out.println("HDMI  Signal detected");}
		else {
			System.out.println("HDMI  no Signal detected");
	
		}
	

	}
		
	catch (Exception e) {
		// TODO: handle exception
		//System.out.println("HDMI signal Detected");

	e.printStackTrace();
 

	}
	}

}
