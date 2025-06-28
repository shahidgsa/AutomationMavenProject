package StepDefinition;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObjects.LoginPage;
import PageObjects.RegisterationPage;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps extends BaseClass {

	@Before
	public void setup() throws IOException {

		// initialize the logger
		// log = LogManager.getLogger("Steps");

		try {
			readconfig = new ReadConfig();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String browser = readconfig.getBrowser();
		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "msedge":
			driver = new EdgeDriver();
			break;
		case "firfox":
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;

		}
		System.out.println("Opening the browser");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver();
		// log.info("Launching the Browser");

	}

	@Given("Launch browser")
	public void launch_browser() {

		loginpage = new LoginPage(driver);
		register = new RegisterationPage(driver);

	}

	@When("Navigate to url {string}")
	public void navigate_to_url(String URl) {
		driver.navigate().to(URl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// log.info("Navigating to URL");

	}

	@Then("Verify that home page is visible successfully")
	public void verify_that_home_page_is_visible_successfully() {
		String titlepage = driver.getTitle();
		// log.info("To verify the Title");
		if (titlepage.contains("Automation Exercise")) {
			System.out.println("HomePage title verified");
		} else {
			System.out.println("HomePage title not verified");

		}

	}

	@Then("Click on {string} button")
	public void click_on_button(String loginRsign) {
		loginpage.signupButton();
		// log.info("User Clicks on login btn");

	}

	@Then("Verify {string} is visible")
	public void verify_is_visible(String expectedresult1) {
		String title = driver.getTitle();
		if (title.contains("Automation Exercise - Signup / Login")) {
			System.out.println("Title verified");
		} else {
			System.out.println("title not verified");
		}

	}

	@When("Enter correct email address as {string} and password as {string}")
	public void enter_correct_email_address_as_and_password_as(String randomEmailId, String pwd) {

		// log.info("User enters Email and pass");
		loginpage.enterEmail(randomEmailId);
		loginpage.enterPass(pwd);

	}

	@When("Click login button")
	public void click_login_button() {
		loginpage.clickOnLoginBtn();
		// log.info("User clicks on Login Btn");

	}

	@Then("Verify that Logged in as username is visible")
	public void verify_that_logged_in_as_username_is_visible() throws InterruptedException {
		Thread.sleep(3000);
		String text = driver.findElement(By.xpath("//*[text()='shahidg'] ")).getText();
		System.out.println(text);

	}

	@Then("Verify New User Signup! is visible")
	public void verify_New_User_Signup_is_visible() {
		String signupTitle = driver.getTitle();
		if (signupTitle.contains("Automation Exercise - Signup / Login")) {
			System.out.println("sign up is visible");
		} else {
			System.out.println("sign up page isnt visible");
		}
	}

	@When("Enter name and email address")
	public void enter_name_and_email_address() {
		register.nameEmail("shahid", randomEmail() + "@gmail.com");

	}

	public String randomEmail() {
		return (RandomStringUtils.randomAlphabetic(5));

	}

	@When("Click Signup button")
	public void click_Signup_button() {
		register.signu();

	}

	@Then("Verify that ENTER ACCOUNT INFORMATION is visible")
	public void verify_that_ENTER_ACCOUNT_INFORMATION_is_visible() {
		String acinfo = driver.findElement(By.xpath("//*[text()='Enter Account Information']")).getText();
		System.out.println(acinfo);

	}

	@When("Fill details: Title, Name, Email, Password, Date of birth")
	public void fill_details_Title_Name_Email_Password_Date_of_birth() throws InterruptedException {

		register.gender();
		register.pwd("Coolboy@123");
		register.days();
		register.months();
		register.years();

	}

	@When("Select checkbox Sign up for our newsletter!")
	public void select_checkbox_Sign_up_for_our_newsletter() {
		register.newsleters();
	}

	@When("Select checkbox Receive special offers from our partners!")
	public void select_checkbox_Receive_special_offers_from_our_partners() {
		register.options();
	}

	@When("Fill details: First name, Last name, Company, Address, Address{int}, Country, State, City, Zipcode, Mobile Number")
	public void fill_details_First_name_Last_name_Company_Address_Address_Country_State_City_Zipcode_Mobile_Number(
			Integer int1) {
		// log.info("User provides the Customer detail");
		// log.info("Launching the Browser");
		register.fname("shahid");
		register.lname("ahmed");
		register.company("hcl");
		register.add1("bangalore");
		register.add2("karnataka");
		register.state("karnataka");
		register.city("banglaore rurul");
		register.zipnumber("654321");
		register.mobile("9876543210");

	}

	@Then("Verify that {string} is visible and click {string} button")
	public void verify_that_is_visible_and_click_button(String string, String string2) {
		String accreated = driver.findElement(By.xpath("//*[text()='Account Created!']")).getText();
		if (accreated.contains(string)) {
			System.out.println("test passed 1");

		} else {
			System.out.println("test fail 1");
		}

		String acdeletebtn = driver.findElement(By.xpath("//*[text()='Your account has been permanently deleted!']"))
				.getText();
		System.out.println(acdeletebtn);

		if (acdeletebtn.equals(string2)) {
			System.out.println("test passed2");

		} else {
			System.out.println("test failed2");
		}
	}

	@Then("close browser")
	public void close_browser() {

		// driver.quit();
	}

	@When("Enter correct email address and password")
	public void enter_correct_email_address_and_password() {
		loginpage.enterEmail("shahidgsa013@gmail.com");
		loginpage.enterPass("Coolboy@123");

	}

	@Then("Click {string} button")
	public void click_button(String string) {
		loginpage.clickOnLogoutBtn();

	}

	@Then("Verify that user is navigated to login page")
	public void verify_that_user_is_navigated_to_login_page() {
		String logintext = driver.findElement(By.xpath("//*[text()='Login to your account']")).getText();
		boolean actualtext = logintext.contains("Login to your account");
		System.out.println(actualtext);

	}

	@After
	public void tearDown(Scenario sc) throws IOException {
		System.out.println("closing the browser");
		if (sc.isFailed() == true) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File srcfile = ts.getScreenshotAs(OutputType.FILE);
			File destfile = new File("C:\\IDE-Workspace\\AutomationMavenProject\\Screenshots\\sample.png");

			FileUtils.copyFile(srcfile, destfile);

		}

		driver.quit();
	}

}
