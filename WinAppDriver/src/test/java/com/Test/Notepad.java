package com.Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;


import io.appium.java_client.windows.WindowsDriver;
import org.testng.Assert;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;




@Test
public class Notepad {

	public WindowsDriver driver=null;
	
	
	@BeforeClass
	public void startWinAppDriver() throws IOException {
		String Winappdriverpath = "C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver";
		ProcessBuilder builder=new ProcessBuilder(Winappdriverpath).inheritIO();
		Process process=builder.start();
	}

	@BeforeMethod
    public void setUp() 
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("app", "C:\\Windows\\System32\\notepad.exe");
		cap.setCapability("platformName","Windows");
		cap.setCapability("deviceName","WindowsPC");

		try {
			driver=new WindowsDriver(new URL("http://127.0.0.1:4723"),cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

	}
	
	@AfterMethod
	public void cleanUp()
	{
		driver.quit();
		//process.destroy();
		
	}
	
	@Test(priority=1)
	public void checkHelpAboutNowTest()
	{
		
	    driver.findElement(By.name("Help")).click();
		driver.findElement(By.name("About Notepad")).click();
		driver.findElement(By.name("OK")).click();
	}
	
	@Test(priority=2)
	public void sendTextTest()
	{
		driver.findElement(By.name("Text Editor")).sendKeys("This is My Notepad Automation" +  " \n This is my First desktop Automation application");
		driver.findElement(By.name("Text Editor")).clear();
	}
	
	@Test(priority=3)
	public void EnterDateTimeTest()
	{
		driver.findElement(By.name("Edit")).click();
		driver.findElementByAccessibilityId("26").click();
		//driver.findElement(By.id("43756")).click();
        String value=driver.findElement(By.name("Text Editor")).getAttribute("Value.Value");
		System.out.println(value);
		Assert.assertTrue(value.contains("1/13/2023"));
	
		
		}
}
	
