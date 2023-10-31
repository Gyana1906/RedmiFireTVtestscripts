package FTVTestCases.PageObject;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import GTVTestCases.ReusableMethods;
import io.appium.java_client.android.AndroidDriver;

public class FTV_Bluetooth_Test extends ReusableMethods{
	
	public FTV_Bluetooth_Test(AndroidDriver<?> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	public void bleTest() {
		
		String command = "adb shell settings get global bluetooth_on";
        String bluetoothStatus = executeShellCommand1(command);

        // Parse the Bluetooth status from the shell command output
        int bluetoothState = -1; // Default state for error handling

        try {
            bluetoothState = Integer.parseInt(bluetoothStatus.trim());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        // Determine the Bluetooth status based on the state
        String bluetoothStatusText;
        if (bluetoothState == 0) {
            bluetoothStatusText = "Bluetooth is disabled";
        } else if (bluetoothState == 1) {
            bluetoothStatusText = "Bluetooth is enabled";
        } else {
            bluetoothStatusText = "Unknown Bluetooth status";
        }

        // Print the Bluetooth status
        System.out.println("Bluetooth Status: " + bluetoothStatusText);


		
	}

}
