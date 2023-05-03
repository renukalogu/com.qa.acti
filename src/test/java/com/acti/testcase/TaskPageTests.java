package com.acti.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskPageTests extends BaseTest {
	
	@Test(priority =1)
		public void testCreatecustomer() {
		lp.enterUsername("admin");
		lp.enterPassword("manager");
		lp.clickLoginButton();
		String actual = ep.getuserLoggedIn();
		Assert.assertTrue(actual.contains("John"));
		ep.clickTaskMenu();
		tp.clickAddnewButton();
		tp.newCustomerOption();
		tp.enterCustomerName("TestCustomer");
		tp.enterCustomerDescription("Dummy Customer");
		tp.clickCreateCustomer();
		String msg = tp.getSuccessMsg();
		System.out.println(msg);
		ep.clickLogout();
	}
	
	@Test(priority =2)
	public void testDeleteCustomer()
	{
		lp.enterUsername("admin");
		lp.enterPassword("manager");
		lp.clickLoginButton();
		String actual= ep.getuserLoggedIn();
		Assert.assertTrue(actual.contains("John Doe"));
		ep.clickTaskMenu();
		tp.enterSearchedCustomer("TestCustomer");
		tp.clickSearchedCustomer();
		tp.clickEditButton();
		tp.clickAction();
		tp.clickDelete();
		tp.clickDeletePermanently();
		String msg = tp.getSuccessMsg();
		Assert.assertTrue(msg.contains("has been deleted"));
		//System.out.println(msg);
		ep.clickLogout();
	}
	

}
