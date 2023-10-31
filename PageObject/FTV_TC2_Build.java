package FTVTestCases.PageObject;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GTVTestCases.ReusableMethods;
import io.appium.java_client.android.AndroidDriver;

public class FTV_TC2_Build extends ReusableMethods {

	AndroidDriver<?> driver;
	ArrayList<String> list = new ArrayList<String>();

	public FTV_TC2_Build(AndroidDriver<?> driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//*[@text='Device & Software']")
	WebElement dsElement;

	@FindBy(xpath = "//*[@text='About']")
	WebElement aboutbuttonElement;

	@FindBy(id = "com.amazon.tv.settings.v2:id/about_version_value")
	WebElement buildversion;

	@FindBy(id = "com.amazon.tv.settings.v2:id/launcher_version_value")
	WebElement FTVHomeversionElement;
	// 6400053.1
	@FindBy(id = "com.amazon.tv.settings.v2:id/about_model_value")
	WebElement fTVModelelElement;
	// TTE_L32R8-FVIN

	public void devicesoft() {
		dsElement.click();

	}

	public void about() {
		aboutbuttonElement.click();

	}

	public void build1() {
		// TODO Auto-generated method stub
		System.out.println("FTV Build version :" + buildversion.getText());

		for (String expString : buildversion.getText().split("/")) {
			list.add(expString);

		}

		String buiString = list.get(1).split("\\)")[0];
		// System.out.println(buiString);

		if (buiString.equalsIgnoreCase("3727")) {
			System.out.println("Matched with OTA Version");
		} else {
			System.out.println("Not Matched with OTA Version");
		}
	}

	public void homeversion() {
		System.out.println("FTV Home Version :" + FTVHomeversionElement.getText());

		if (FTVHomeversionElement.getText().equalsIgnoreCase("6400053.1")) {
			System.out.println("FTV Home version matched");
		} else {
			System.out.println("FTV Home version not matched");
		}
	}

	public void Model() {
		System.out.println("FTV Model  :" + fTVModelelElement.getText());

		if (fTVModelelElement.getText().equalsIgnoreCase("TTE_L32R8-FVIN")) {
			System.out.println("FTV Model matched");
		} else {
			System.out.println("FTV Model not matched");
		}

	}

}
