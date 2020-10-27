package testNGTests;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Activity3 {
	  WebDriver driver;  
	
	  @BeforeClass
	  public void beforeClass() {
		  driver = new FirefoxDriver();
		  driver.get("https://www.training-support.net/selenium/login-form");
	  }
	
	  @Test
	  public void f() {
		  driver.findElement(By.id("username")).sendKeys("admin");
		  driver.findElement(By.id("password")).sendKeys("password");
		  driver.findElement(By.xpath("//button[@type='submit']")).click();
		  String confirmationText = driver.findElement(By.id("action-confirmation")).getText();
		  Assert.assertEquals(confirmationText, "Welcome Back, admin");
	  }

	  @AfterClass
	  public void afterClass() {
		  driver.close();
	  }
}
