package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import helper.BaseClass;
import pages.Login;

public class LoginTest extends BaseClass {
	
	Login login;
	@Test(description="", priority = 1)
	public void loginToAP()
	{
		login = PageFactory.initElements(driver, Login.class);
		
		logger = report.createTest("Login test for AP");
		
		login.validateHomePage();
		
		logger.pass("Home Page Validated");
		
//		login.clickSignIn();
//		
//		logger.info("Clicked on login button");
		
		login.enterUserName("");
		
		logger.info("Username entered");
		
		login.enterPassword("");
		
		logger.info("Password entered");
		
		login.confirmSignIn();
		
		logger.info("Clicked on login button");
		
	}
}


