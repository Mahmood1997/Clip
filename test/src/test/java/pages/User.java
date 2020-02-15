package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import helper.Utility;

public class User {
WebDriver driver;
	
	public User(WebDriver Udriver)
	{
		this.driver=Udriver;
	}
	
	
	
	@FindBy(xpath = "//input[@id= 'searchSystemUser_userName' ]") WebElement userName;
	@FindBy(xpath = "//select[@id= 'searchSystemUser_userType' ]") WebElement userRole;
	@FindBy(xpath = "//input[@id= 'searchSystemUser_employeeName_empName' ]") WebElement empName;
	@FindBy(xpath = "//select[@id= 'searchSystemUser_status' ]") WebElement status;
	
	public void EnterUser(String userN)
	{
		Utility.waitForWebelement(driver, userName).sendKeys(userN);
		System.out.println("LOG: INFO- Username Entered");
	}
	
	public void EnterRole(String role)
	{
		Utility.waitForWebelement(driver, userRole).sendKeys(role);
	}
	
	public void EnterName(String employeeN)
	{
		Utility.waitForWebelement(driver, empName).sendKeys(employeeN);
	}
	
	public void EnterStatus(String stat)
	{
		Utility.waitForWebelement(driver, status).sendKeys(stat);
	}
}
