package com.acti.pages;

import org.openqa.selenium.support.PageFactory;

import com.acti.base.DriverScript;

/*
 * Name: Enter Page
 * Description: Manages the Locators & methods of Login page
 * Developed By: Renu
 * Reviewed By: Muthu
 * Date Reviewed : 04-27-2023
 */

public class EnterPage  extends DriverScript{
	
	// **************************************** Page Locators **************************************//
	// **************************************** Page Initialization *******************************//
	
	public EnterPage() {
		PageFactory.initElements(driver, this);
	}

	// **************************************** Page Methods **************************************//


}
