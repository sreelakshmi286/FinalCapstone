package com.testing;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseClass {
	
	 public AndroidDriver driver;

		@BeforeClass
		public void AppiumApplication() throws MalformedURLException {
			DesiredCapabilities caps = new DesiredCapabilities();

			caps.setCapability("platformName", "Android");

			caps.setCapability("deviceName", "SDETDEVICE");

			caps.setCapability("appPackage",
					"C:\\Users\\tirum\\Downloads\\TheApp-v1.10.0.apk");																												// na
			caps.setCapability("appActivity", ".MainActivity"); // Replace with your app's main activity
			caps.setCapability("automationName", "UiAutomator2");

			try {

				// Initialize the driver

				UiAutomator2Options options = new UiAutomator2Options();
				options.setDeviceName("SDETDEVICE");
				options.setApp(
						"C:\\Users\\tirum\\Downloads\\TheApp-v1.10.0.apk");

				driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
				Thread.sleep(3000);

			} catch (Exception e) {

				e.printStackTrace();

			}
		}

}
