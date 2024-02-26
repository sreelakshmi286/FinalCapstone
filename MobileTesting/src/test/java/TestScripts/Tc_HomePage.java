package TestScripts;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import com.testing.BaseClass;
import TestPages.HomePage;

public class Tc_HomePage extends BaseClass {

	@Test
	public void HomePage() throws InterruptedException, MalformedURLException {
		HomePage home = new HomePage(driver);
		home.ClickMenu();
		Thread.sleep(3000);
		home.WriteSomething("Hi,How are you?");
		home.ClickSave();
		
		

	}
}
