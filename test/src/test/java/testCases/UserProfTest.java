package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataProviderFactory.DataProviderFactory;
import helper.BaseClass;
import pages.User;

public class UserProfTest extends BaseClass {
	
	User user;
	
	@Test(dataProvider="UserData")
	public void userProf(String userN, String role, String employeeN, String stat) 
	{
		user = PageFactory.initElements(driver, User.class);
		
		logger = report.createTest("User Profile test initiated");
		
		user.EnterName(userN);
		
		logger.info("Username entered");
		
		user.EnterRole(role);
		
		logger.info("Employee Role Selected");
		
		user.EnterUser(employeeN);
		
		logger.info("Employee Name entered");
		
		user.EnterStatus(stat);
		
		logger.info("Status selected");
	}
	
	@DataProvider(name="UserData")
	public Object[][] getUserData()
	{
		System.out.println("LOG: INFO- Running Data Provider first to generate the data");
		
		int rows =DataProviderFactory.getExcel().getRows("UserData");
		
		System.out.println("Total number f rows in excel: "+rows);
		
		Object[][]uarr = new Object[rows-1][4];
		
		for (int i=0; i<rows-1;i++)
		{
			uarr[i][0]= DataProviderFactory.getExcel().getCellData("UserData", i+1, 0);
			uarr[i][1]= DataProviderFactory.getExcel().getCellData("UserData", i+1, 1);
			uarr[i][2]= DataProviderFactory.getExcel().getCellData("UserData", i+1, 2);
			uarr[i][3]= DataProviderFactory.getExcel().getCellData("UserData", i+1, 3);
		}
		 System.out.println("Data Provider Ready For Use");
		 
		 return uarr;
	}
	

}
