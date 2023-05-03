package com.acti.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest{
	
	
	@Test(enabled = false)
	public void testLoginPageTitle()
	{
		String expected ="actiTIME - Login";
		String actual=lp.getLoginPageTitle();
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
	}
	
	@Test(enabled = false)
	public void testActiImgDisplayed()
	{
		boolean flag = lp.verifyActiImg();
		Assert.assertTrue(flag);
	}
	

	@Test(enabled = false)
	public void testForgotPasswordDisplayed()
	{		
		boolean flag = lp.verifyForgotPasswordLink();
		Assert.assertTrue(flag);
		}
	
	@Test(enabled = true)
	public void testLoginFunction()
	{
		
		lp.enterUsername("admin");
		lp.enterPassword("manager");
		lp.clickLoginButton();
		String actual = ep.getuserLoggedIn();
		System.out.println(actual);
		Assert.assertTrue(actual.contains("John"));
		ep.clickLogout();
	
	}
	
	@Test(enabled = false)
	public void testLoginInvalidCredentials() throws InterruptedException
	{
		lp.enterUsername("admin");
		lp.clickLoginButton();
		Thread.sleep(3000);
		String errmsg = lp.getErrMsgText();
		System.out.println(errmsg);
		Assert.assertTrue(errmsg.contains("Username or Password is invalid."));
		
	}
	
	
}
