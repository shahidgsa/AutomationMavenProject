package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterationPage {

	WebDriver driver;

	public RegisterationPage(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[text()=' Signup / Login']")
	WebElement signupbutton;

	@FindBy(xpath = "//*[@name='name']")
	WebElement name;

	@FindBy(xpath = "(//*[@name='email'])[2]")
	WebElement email;

	@FindBy(xpath = "//*[text()='Signup']")
	WebElement signup;

	@FindBy(id = "id_gender1")
	WebElement gender;

	@FindBy(id = "password")
	WebElement paswd;

	@FindBy(id = "days")
	WebElement days;

	@FindBy(id = "months")
	WebElement months;

	@FindBy(id = "years")
	WebElement years;

	@FindBy(id = "newsletter")
	WebElement newsleter;

	@FindBy(id = "optin")
	WebElement option;

	@FindBy(id = "first_name")
	WebElement fistname;

	@FindBy(id = "last_name")
	WebElement lastname;

	@FindBy(id = "company")
	WebElement company;

	@FindBy(id = "address1")
	WebElement address;

	@FindBy(id = "address2")
	WebElement address2;

	@FindBy(id = "state")
	WebElement state;

	@FindBy(id = "city")
	WebElement city;

	@FindBy(id = "zipcode")
	WebElement zipcode;

	@FindBy(id = "mobile_number")
	WebElement mobnumber;

	@FindBy(xpath = "//*[text()='Create Account']")
	WebElement createac;

	public void nameEmail(String name1, String email1) {
		name.sendKeys(name1);
		email.sendKeys(email1);

	}

	public void signu() {
		signup.click();
	}

	public void gender() {
		gender.click();
	}

	public void pwd(String pass) {
		paswd.sendKeys(pass);

	}

	public void days() {
		Select select = new Select(days);
		select.selectByValue("13");
	}

	public void months() {
		Select select1 = new Select(months);
		select1.selectByIndex(12);

	}

	public void years() throws InterruptedException {
		Select select2 = new Select(years);
		Thread.sleep(5000);
		select2.selectByVisibleText("2003");
	}

	public void newsleters() {
		newsleter.click();
	}

	public void options() {
		option.click();
	}

	public void fname(String fName) {
		fistname.sendKeys(fName);

	}

	public void lname(String lname) {
		lastname.sendKeys(lname);
	}

	public void company(String compa) {
		company.sendKeys(compa);
	}

	public void add1(String add) {
		address.sendKeys(add);

	}

	public void add2(String add2) {
		address2.sendKeys(add2);
	}

	public void state(String stat) {
		state.sendKeys(stat);
	}

	public void city(String cities) {
		city.sendKeys(cities);
	}

	public void zipnumber(String zip) {
		zipcode.sendKeys(zip);
	}

	public void mobile(String num) {
		mobnumber.sendKeys(num);
	}

}
