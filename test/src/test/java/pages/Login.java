package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import helper.Utility;

public class Login {
WebDriver driver;
	//sign in, contact us, email, password, sign in button
	public Login(WebDriver Idriver)
	{
		this.driver=Idriver;
	
	}

//@FindBy(xpath="//a[@class= 'login' ]") WebElement signIn;
//@FindBy(xpath="//input[@id= 'email' ]") WebElement username;
//@FindBy(xpath="//input[@name= 'passwd' ]") WebElement password;
//@FindBy(xpath="//button[@id= 'SubmitLogin' ]") WebElement confirm;
	
	@FindBy(xpath= "//input[@name='txtUsername' ]") WebElement username;
	@FindBy(xpath="//input[@name='txtPassword' ]") WebElement password;
	@FindBy(xpath="//input[@name='Submit' ]") WebElement confirm;

	public void validateHomePage()
	{
		Utility.validateContainsTitle(driver, "OrangeHRM");
	}
	
	
//	public void clickSignIn()
//	{
//		
//		Utility.waitForWebelement(driver, signIn).click();
//		System.out.println("LOG: INFO- Sign In clicked");
//	}
	
	public void enterUserName(String uname)
	{
		System.out.println("LOG: INFO- Username entered");
		Utility.waitForWebelement(driver, username).sendKeys(uname);
	}
	public void enterPassword(String pass)
	{
		System.out.println("LOG: INFO- Password entered");
		Utility.waitForWebelement(driver, password).sendKeys(pass);
	}
	public void confirmSignIn()
	{
		Utility.waitForWebelement(driver, confirm).click();
		System.out.println("LOG: INFO- Sign In confirmed");
	}
}