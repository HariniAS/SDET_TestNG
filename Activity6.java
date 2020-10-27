package testNGTests;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Activity6 {
	  WebDriver driver;

	  @BeforeClass
	  public void beforeClass() {
		  driver= new FirefoxDriver();
		  driver.get("https://www.training-support.net/selenium/login-form");
	  }

	  @Parameters ({"username","password"})
	  @Test
	  public void test(String uname,String pwd) {
		  driver.findElement(By.id("username")).sendKeys(uname);
		  driver.findElement(By.id("password")).sendKeys(pwd);
		  driver.findElement(By.xpath("//button[@type='submit']")).click();
		  System.out.println("Logged in successfully");
	  }
	
	  @AfterClass
	  public void afterClass() {
		  driver.close();
	  }

}
