package testNGTests;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;

public class Activity2 {
	  WebDriver driver;
	  
	  @BeforeClass
	  public void beforeClass() {
		  driver = new FirefoxDriver();
		  driver.get("https://www.training-support.net/selenium/target-practice");
	  }
	  
	  @Test
	  public void tc1() {
		  System.out.println("Title of the page is: "+ driver.getTitle());
		  Assert.assertEquals("Target Practice", driver.getTitle());
	  }
	  
	  @Test
	  public void tc2() {
		  WebElement blackButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[3]"));
		  Assert.assertTrue(blackButton.isDisplayed());
		  Assert.assertFalse(blackButton.getText()=="Black"); //Incorrect assertion-this test case is meant to throw an error
	  }
	  
	  @Test (enabled=false)
	  public void tc3() {
		  System.out.println("This is TC3, set as enabled=false");
	  }
	  
	  @Test
	  public void tc4() throws SkipException {
		  String skip = "skiptc";
		  if (skip=="skiptc") {
			  throw new SkipException ("Skipping this TC");
		  } else {
			  System.out.println("This is TC4, has a SkipException");
		  }
		  
	  }
	
	  @AfterClass
	  public void afterClass() {
		  driver.close();
	  }
}
