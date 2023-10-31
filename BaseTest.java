package FTVTestCases;


import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import GTVTestCases.GenericMethod;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;


public class BaseTest extends GenericMethod {
	
	 public AndroidDriver<?> driver;
	   
		@BeforeClass
	    public void BaseClass() throws IOException {

	    	
	    	DesiredCapabilities cap=new DesiredCapabilities();
	    	//cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,AutomationName.APPIUM);
            cap.setCapability(MobileCapabilityType.UDID,GenericMethod.getvalue("FTVUdid"));
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME,GenericMethod.getvalue("FTVPlatfomName"));
            cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, GenericMethod.getvalue("FTVPlatformVersion"));
            cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, GenericMethod.getvalue("FTVActivity"));
            cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,GenericMethod.getvalue("FTVPackage"));
            


	        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
	        driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
	        
	       

	     
	    }
		
		
		@AfterClass
		public void testclose() {
			
			driver.quit();
		}

	}


