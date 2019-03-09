package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class addbook {
	  WebDriver driver;
	@BeforeMethod
	public void launch() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.get("http:localhost:8081/addressbook/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
  @Test
  public void verifyaddbook() {
	  driver.findElement(By.xpath("//div[@class='v-button v-widget']")).click();
	  driver.findElement(By.id("gwt-uid-5")).sendKeys("Varun");
	  driver.findElement(By.id("gwt-uid-7")).sendKeys("Selenium");
	  driver.findElement(By.id("gwt-uid-9")).sendKeys("12345643210");
	  driver.findElement(By.id("gwt-uid-11")).sendKeys("varun.edureka@gmail.com");
	  driver.findElement(By.id("gwt-uid-13")).sendKeys("06/01/2019");
	  driver.findElement(By.xpath("//div[@class='v-button v-widget primary v-button-primary']")).click();
  }
  
  @AfterMethod
  public void close() {
	  driver.close();
	}
}
