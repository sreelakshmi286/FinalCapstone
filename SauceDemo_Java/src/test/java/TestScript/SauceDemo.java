package TestScript;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import Pages.Invalid_Login;
import Pages.Login_Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SauceDemo {
	
	protected WebDriver driver;
	Login_Page loginPage;
	Invalid_Login invalidlogin;
	FileInputStream fileLoc;
	Properties prop;

	@Parameters({ "Browser", "Url" })
	@BeforeClass
	public void setUp(String Browser, String Url) throws IOException {
		fileLoc = new FileInputStream(
				"C:\\Users\\tirum\\eclipse-workspace\\Eclipse_Codes\\Capstone\\src\\test\\java\\com\\sdet\\testdata\\Credentials.properties");
		prop = new Properties();
		prop.load(fileLoc);
		
		if(Browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			}else if(Browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

			}
		driver.get(Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		

		

		loginPage = new Login_Page(driver);
		invalidlogin = new Invalid_Login(driver);
	}

	public void captureScreenShot(WebDriver driver, String tName) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File image = ts.getScreenshotAs(OutputType.FILE);
		File targetImage = new File(System.getProperty("user.dir")+"/Screenshots/"+tName+".png");
		FileUtils.copyFile(image, targetImage);
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
