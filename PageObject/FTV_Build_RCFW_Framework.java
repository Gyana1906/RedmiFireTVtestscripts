package FTVTestCases.PageObject;



import org.testng.annotations.Test;

import FTVTestCases.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class FTV_Build_RCFW_Framework extends BaseTest{
	
	@Test
	public void BuilRc() throws Exception {
		
	
//	System.out.println("Redmi Fire TV Home Screen");
//	
		Thread.sleep(2000);
	
	FTV_TC1_WIFI testwifi = new FTV_TC1_WIFI(driver);
	Thread.sleep(2500);
	testwifi.settingElementbutton();
	//Thread.sleep(2000);
	((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.DPAD_RIGHT));
	Thread.sleep(200);
	((AndroidDriver<?>)driver).pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
	Thread.sleep(200);
	((AndroidDriver<?>)driver).pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
	
	FTV_TC2_Build testBuild=new FTV_TC2_Build(driver);
	testBuild.devicesoft();
	testBuild.about();
	Thread.sleep(200);
	testBuild.build1();
	testBuild.homeversion();
	testBuild.Model();
	
  
	

    

}
}