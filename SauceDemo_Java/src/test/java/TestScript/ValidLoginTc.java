package TestScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


public class ValidLoginTc extends SauceDemo{
	
	@Test(priority=1)
	public void testValidLogin() throws IOException {
		
		loginPage.getUserName().sendKeys(prop.getProperty("Username1"));
		loginPage.getPassword().sendKeys(prop.getProperty("Password1"));
		loginPage.getLoginButton().click();

		String title = driver.getTitle();
        System.out.println(title);
		if(title.contains("Swag Labs")) {
		Assert.assertTrue(title.contains("Swag Labs"));
		System.out.println("Successfully Login to HomePage");
		}else {
		captureScreenShot(driver, "loginfailed");
		System.out.println("Not Successfully Login to HomePage");
		Assert.assertTrue(title.contains("Swag Labs"));
		}
		
	}



	

}
