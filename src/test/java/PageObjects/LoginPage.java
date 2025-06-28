package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[text()=' Signup / Login']")
	WebElement signupbtn;

	@FindBy(xpath = "(//*[@name='email'])[1]")
	WebElement email;

	@FindBy(xpath = "(//*[@name='password'])[1]")
	WebElement pass;

	@FindBy(xpath = "(//*[text()='Login'])[1]")
	WebElement loginbtn;

	@FindBy(xpath = "//*[text()=' Logout']")
	WebElement logoutbtn;

	public void signupButton() {
		signupbtn.click();
	}

	public void enterEmail(String mail) {
		email.sendKeys(mail);
	}

	public void enterPass(String passwd) {
		pass.sendKeys(passwd);
	}

	public void clickOnLoginBtn() {
		loginbtn.click();
	}

	public void clickOnLogoutBtn() {
		logoutbtn.click();
	}

}
