package com.test;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class PhpAboutTest {
	WebDriver driver;
	@BeforeMethod
	public void launch() {
		String OSName = System.getProperty("os.name");
		if(OSName.startsWith("Windows")) {
			System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			driver = new ChromeDriver();
		}else {
			System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
			ChromeOptions options = new ChromeOptions();
	        options.addArguments("--headless");
	        options.addArguments("--no-sandbox");
	        options.addArguments("--disable-dev-shm-usage");
	        driver = new ChromeDriver(options);
		}
		  
		  driver.get("http://192.168.56.101:32770/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	
	@Test
	public void testAbout() {
		String abtValue = "This is about page. Lorem Ipsum Dipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
		driver.findElement(By.xpath("//a[@id='About Us']")).click();
		String testVal = driver.findElement(By.xpath("//p[@id='PID-ab2-pg']")).getText();
		Assert.assertEquals(abtValue, testVal);
	}
	@AfterMethod
	public void close() {
		  driver.close();
	}
}
