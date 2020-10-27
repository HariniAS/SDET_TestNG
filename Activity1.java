package testNGTests;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class Activity1 {
	  WebDriver driver;
	  
	  @Test
	  public void act1() throws InterruptedException {
		  System.out.println(driver.getTitle());
		  Assert.assertEquals("Training Support", driver.getTitle());
		  driver.findElement(By.id("about-link")).click();
		  System.out.println(driver.getTitle());
		  Assert.assertEquals(driver.getTitle(), "About Training Support");
	  }
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  driver = new FirefoxDriver();
		  driver.get("https://www.training-support.net");		  		  
	  }

	  @AfterMethod
	  public void afterMethod() {
		  driver.close();
	  }

}
