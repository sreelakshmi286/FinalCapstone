package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Invalid_Login {
	
	WebDriver driver;

	@FindBy(id = "user-name")
	WebElement UserName2;
	public WebElement getUserName() {
	return UserName2;
	}

	@FindBy(id = "password")
	WebElement Password2;
	public WebElement getPassword() {
	return Password2;
	}

	@FindBy(id = "login-button")
	WebElement LoginButton;
	public WebElement getLoginButton() {
	return LoginButton;
	}

	public Invalid_Login(WebDriver rDriver) {
	this.driver = rDriver;
	PageFactory.initElements(rDriver, this);

	    }

}
