package com.acti.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * Name: DriverScipt
 * Description: Manages the driver & browsers related configuration
 * Developed By:
 * Reviewed By:
 * Date Reviewed : 04-27-2023
 */




public class DriverScript {
	
	public static WebDriver driver;
	Properties prop;
	
	/*
	 * Constructor is responsible for getting details from the properties file
	 */
	
	public DriverScript() {
		try
		{
			File file = new File("./src/test/resources/config/config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
						
		}
		catch(Exception e)
		{
			System.out.println("Unable to load config.properties file" + e.getMessage());
			e.printStackTrace();
		}
	}
	/*
	 * initApplication will get the browser details from the properties file & launch the application
	 */
	

	public void initApplication()
	{
		String browser = prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.out.println(browser+ " : in use");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.out.println(browser+ " : in use");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("msedge"))
		{
			System.out.println(browser+ " : in use");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println(browser+ " is not supported browser please check config.properties file");
	
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		launchURL();
		
	}

	/*
	 *Load the url form the properties file & pass this method to initApplication
	 */
	
	public void launchURL()
	{
		String url = prop.getProperty("ur1");
		driver.get(url);
	}

	/*
	 * Quit the driver
	 */
	
	public void quitDriver()
	{
		driver.quit();
	}

}
