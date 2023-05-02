package com.acti.testcase;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.acti.base.DriverScript;
import com.acti.pages.LoginPage;

public class LoginPageTests2 extends DriverScript{
	
	@Test(enabled = true)
	public void testLoginPageTitle()
	{
		initApplication();
		LoginPage lp = new LoginPage();
		String expected ="actiTIME - Login";
		String actual=lp.getLoginPageTitle();
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
		quitDriver();
	}
	
	@Test(enabled = true)
	public void testActiImgDisplayed()
	{
		initApplication();
		LoginPage lp = new LoginPage();
		boolean flag = lp.verifyActiImg();
		Assert.assertTrue(flag);
		quitDriver();
	}
	

	@Test(enabled = true)
	public void testForgotPasswordDisplayed()
	{
		initApplication();
		LoginPage lp = new LoginPage();
		boolean flag = lp.verifyForgotPasswordLink();
		Assert.assertTrue(flag);
		quitDriver();
	}
	
	@Test(enabled = true)
	public void testLoginFunction()
	{
		initApplication();
		LoginPage lp = new LoginPage();
		lp.enterUsername("admin");
		lp.enterPassword("manager");
		lp.clickLoginButton();
		quitDriver();
	}
	
	@Test(enabled = true)
	public void testLoginInvalidCredentials() throws InterruptedException
	{
		initApplication();
		LoginPage lp = new LoginPage();
		lp.enterUsername("admin");
		lp.clickLoginButton();
		Thread.sleep(3000);
		String errmsg = lp.getErrMsgText();
		System.out.println(errmsg);
		Assert.assertTrue(errmsg.contains("Username or Password is invalid."));
		quitDriver();
	}
	
	
}
