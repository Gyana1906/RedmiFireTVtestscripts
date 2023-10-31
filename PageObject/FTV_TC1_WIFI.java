package FTVTestCases.PageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GTVTestCases.GenericMethod;
import GTVTestCases.ReusableMethods;
import io.appium.java_client.android.AndroidDriver;

public class FTV_TC1_WIFI extends ReusableMethods {
	AndroidDriver<?> driver;

	public FTV_TC1_WIFI(AndroidDriver<?> driver) {

		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// String[] longpresshomeStrings = { "Programme Guide", "Display Mirroring",
	// "Apps", "Inputs" };
	// List<String> setStrings = Arrays.asList(longpresshomeStrings);

	@FindBy(id = "com.amazon.tv.quicksettings.ui:id/button_one_line_title")
	public List<WebElement> longpreeH;

	@FindBy(id = "com.amazon.tv.launcher:id/nav_bar_app_overflow")
	public WebElement appOverfElement;

	@FindBy(className = "android.widget.LinearLayout")
	List<WebElement> settingsElement;

	@FindBy(xpath = "//*[contains(@text,'All Networks')]")
	WebElement networkElement;

	@FindBy(id = "com.amazon.tv.settings.v2:id/action_description")

	List<WebElement> wificonnected;

	@FindBy(id = "com.amazon.tv.launcher:id/nav_bar_settings")
	WebElement settingElement;

	@FindBy(xpath = "//*[contains(@text,'Tvqmo-5G')]")
	WebElement wifissidElement1;

	public void wifiModule(List<String> setString) {

		String functions = null;
		for (WebElement text : longpreeH) {
			for (String optnString : setString) {

				if (optnString.equalsIgnoreCase(text.getText())) {
					functions = text.getText();
				}
			}

			System.out.println("Options available: " + text.getText());
		}
	}

	// return functions;

	public void MoreApps() {

		appOverfElement.click();

	}

	public void wifinetworkicon() throws InterruptedException {

		visibilityOfelements(settingsElement);
		WebElement wifiElement = settingsElement.get(3);
		wifiElement.click();
		

		
	}

	public void networktest() {
		// TODO Auto-generated method stub

		networkElement.click();

	}

	public void wifistatus() throws Exception {
		// TODO Auto-generated method stub
		
		Thread.sleep(2000);

		if (wificonnected.get(0).getText().equalsIgnoreCase("Connected")) {
			System.out.println("wifi status is connected");

			GenericMethod.captureScreen(driver);
		} else {
			System.out.println("wifi status is not connected");

			String wifissidElement = wifissidElement1.getText();
			GenericMethod.scrollUI(driver, wifissidElement).click();
		}

	}

	public String wifishellstatus() {

		String command = "adb shell dumpsys wifi | grep 'Wi-Fi is'";
		String wifiStatus = executeShellCommand(command);

		//System.out.println("WiFi Status: " + wifiStatus);
		return wifiStatus;

	}

	public void settingElementbutton() throws InterruptedException {
		
	visibilityOfelement(settingElement);
		settingElement.click();
		Thread.sleep(200);

		

	}

}
