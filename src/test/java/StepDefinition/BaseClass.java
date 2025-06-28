package StepDefinition;

import java.util.Properties;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import PageObjects.LoginPage;
import PageObjects.RegisterationPage;
import Utilities.ReadConfig;


public class BaseClass {

	WebDriver driver;
	LoginPage loginpage;
	RegisterationPage register;
	//create an object for logger
//	public static Logger log;
	ReadConfig readconfig;

}
