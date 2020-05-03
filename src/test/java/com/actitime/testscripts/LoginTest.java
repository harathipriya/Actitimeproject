package com.actitime.testscripts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.actitime.commonutils.WebDriverUtils;
import com.actitime.configuration.CommonSetup;
import com.actitime.pages.LoginPage;

public class LoginTest extends CommonSetup
{
	

	@Test
	public void loginTest() throws IOException, InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(url);
		LoginPage lp=new LoginPage(driver);
		WebDriverUtils utils=new WebDriverUtils();
		 String user=utils.getDataFromProperties("username");
		String pass=utils.getDataFromProperties("password");
		Thread.sleep(2000);
		lp.loginOperation(user,pass);
		
	if(driver.getTitle().contains("actiTIME"))
	{
		Assert.assertTrue(true);
	}
	else
	{
		Assert.assertTrue(false);
	}
		

	}
	

}
