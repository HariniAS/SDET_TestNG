package testNGTests;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class Activity9 {
	  WebDriver driver;
	  
	  @BeforeTest
	  public void beforeTest() {
		  driver=new FirefoxDriver();
		  driver.get("https://www.training-support.net/selenium/javascript-alerts");
		  Reporter.log("Opening brower and accessing the URL");
	  }	
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  driver.switchTo().defaultContent();
		  Reporter.log("Starting a new TC");
	  }
		
	  @Test
	  public void simpleAlertTestCase() {
		  driver.findElement(By.id("simple")).click();
		  Reporter.log("Clicking Simple alert");
		  
		  Alert al= driver.switchTo().alert();
		  
		  String txt = al.getText();
		  Reporter.log("Getting text from the Simple Alert");
		  System.out.println(txt);
		  Assert.assertEquals("This is a JavaScript Alert!", txt);
		  
		  al.accept();
		  Reporter.log("Accepting Simple Alert");
	  }
	
	  @Test
	  public void confirmAlertTestCase() {
		  driver.findElement(By.id("confirm")).click();
		  Reporter.log("Clicking Confirmation alert");
		  
		  Alert al= driver.switchTo().alert();
		  
		  String txt = al.getText();
		  Reporter.log("Getting text from the Confirmation Alert");
		  System.out.println(txt);
		  Assert.assertEquals("This is a JavaScript Confirmation!", txt);
		  
		  al.accept();
		  Reporter.log("Accepting Confirmation Alert");	  
		  
		  driver.findElement(By.id("confirm")).click();
		  Reporter.log("Clicking Confirmation alert again");
		  
		  Alert al1= driver.switchTo().alert();
		  
		  al1.dismiss();
		  Reporter.log("Dismisisng Confirmation Alert");	 
	  }
	
	  @Test
	  public void promptAlertTestCase() {
		  driver.findElement(By.id("prompt")).click();
		  Reporter.log("Clicking Prompt");
		  
		  Alert al= driver.switchTo().alert();
		  
		  String txt = al.getText();
		  Reporter.log("Getting text from the Prompt");
		  System.out.println(txt);
		  Assert.assertEquals("This is a JavaScript Prompt!", txt);
		  
		  al.sendKeys("Heyy");
		  Reporter.log("Entering 'Heyy' in the Prompt");
		  
		  al.accept();
		  Reporter.log("Accepting Prompt");	  
		  
		  driver.findElement(By.id("confirm")).click();
		  Reporter.log("Clicking Prompt again");
		  
		  Alert al1= driver.switchTo().alert();
		  
		  al1.dismiss();
		  Reporter.log("Dismisisng Prompt");	 
	  }
	
	  @AfterTest
	  public void afterTest() {
		  driver.close();
	  }

}
