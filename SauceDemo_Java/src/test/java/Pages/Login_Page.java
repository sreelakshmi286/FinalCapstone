package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	
	WebDriver driver;

	@FindBy(id = "user-name")
	WebElement UserName1;
	public WebElement getUserName() {
	return UserName1;
	}

	@FindBy(id = "password")
	WebElement Password1;
	public WebElement getPassword() {
	return Password1;
	}

	@FindBy(id = "login-button")
	WebElement LoginButton;
	public WebElement getLoginButton() {
	return LoginButton;
	}

	public Login_Page(WebDriver rDriver) {
	this.driver = rDriver;
	PageFactory.initElements(rDriver, this);

	    }

}
