package FTVTestCases;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.annotations.Test;

import GTVTestCases.GTV_Bluetooth_Test;
import GTVTestCases.GenericMethod;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class BluetestWZ8D {
	
	
	
	AndroidDriver<?> driver;
	@Test
	public void WZ8D() throws IOException {
		

	DesiredCapabilities cap=new DesiredCapabilities();
	//cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,AutomationName.APPIUM);
    cap.setCapability(MobileCapabilityType.UDID,GenericMethod.getvalue("WZ8DUdid"));
    cap.setCapability(MobileCapabilityType.PLATFORM_NAME,GenericMethod.getvalue("WZ8DPlatfomName"));
    cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, GenericMethod.getvalue("WZ8DPlatformVersion"));
    cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, GenericMethod.getvalue("WZ8DActivity"));
    cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,GenericMethod.getvalue("WZ8DPackage"));
    


    driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
    driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
    
    WZ8D_Bluetooth_Test bt=new WZ8D_Bluetooth_Test(driver);
     bt.bleTest();
 

}}
