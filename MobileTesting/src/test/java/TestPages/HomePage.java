package TestPages;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class HomePage {

	AndroidDriver driver;
	By echoMenu = By.xpath("//android.view.ViewGroup[@content-desc=\"Echo Box\"]");
	By type = By.className("android.widget.EditText");
	By saveButton = By.xpath("//android.widget.TextView[@text=\"Save\"]");
	
	public HomePage(AndroidDriver driver) {
		this.driver = driver;
	}

	public void ClickMenu() {
		driver.findElement(echoMenu).click();
	}
	
	public void WriteSomething(String DSP) {
		driver.findElement(type).sendKeys(DSP);
	}
	
	public void ClickSave() {
		driver.findElement(saveButton).click();
	}
	

}
