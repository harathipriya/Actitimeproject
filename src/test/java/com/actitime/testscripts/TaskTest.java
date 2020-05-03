package com.actitime.testscripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.actitime.commonutils.WebDriverUtils;
import com.actitime.configuration.CommonSetup;
import com.actitime.pages.LoginPage;
import com.actitime.pages.TaskPage;

public class TaskTest extends CommonSetup {
	@Test

	public void TaskTest() throws IOException, InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(url);
		//LoginPage lp=new LoginPage(driver);
		TaskPage tp=new TaskPage(driver);
		WebDriverUtils utils=new WebDriverUtils();
		// String user=utils.getDataFromProperties("username");
		//String pass=utils.getDataFromProperties("password");
		Thread.sleep(2000);
		//lp.loginOperation(user,pass);
		tp.createCustomer();
		tp.createProject();
		

}
}
