package FTVTestCases.PageObject;

import java.util.Arrays;

import java.util.List;

import org.testng.annotations.Test;

import FTVTestCases.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class FTVSettings_Wifi_BT_Framework extends BaseTest {

	String[] longpresshomeStrings = { "Programme Guide", "Display Mirroring", "Apps", "Inputs" };
	List<String> setStrings = Arrays.asList(longpresshomeStrings);
	String wifienabledString = "Wi-Fi is enabled";

	@Test
	public void Settingsfunction() throws Exception {

		System.out.println("Redmi Fire TV Home Screen");
		Thread.sleep(2000);

		FTV_TC1_WIFI testwifi = new FTV_TC1_WIFI(driver);

		if (testwifi.wifishellstatus().trim().equalsIgnoreCase(wifienabledString.trim())) {
			((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.SETTINGS));
			

			Thread.sleep(3000);

			testwifi.wifiModule(setStrings);

			((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.BACK));

//			testwifi.MoreApps();


			// Till App drawer click then right from D-Pad
//
//		((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.DPAD_RIGHT));
//		((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
//		Thread.sleep(300);
			Thread.sleep(200);
			testwifi.settingElementbutton();

			((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.DPAD_RIGHT));
			Thread.sleep(200);

			testwifi.wifinetworkicon();

			Thread.sleep(200);

			testwifi.networktest();
			Thread.sleep(500);
			testwifi.wifistatus();

			System.out.println("WiFi Status: " + testwifi.wifishellstatus());

		}

		else {
			testwifi.settingElementbutton();
			((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.DPAD_RIGHT));
			testwifi.wifinetworkicon();

			Thread.sleep(200);
			System.out.println("WiFi Status: " + testwifi.wifishellstatus());

		}

		FTV_Bluetooth_Test bTest = new FTV_Bluetooth_Test(driver);

		bTest.bleTest();

		
	}

}
