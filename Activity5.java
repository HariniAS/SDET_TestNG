package testNGTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity5 {
	  WebDriver driver;
	  
	  @BeforeClass 
	  public void beforeClass() {
		  driver = new FirefoxDriver();
		  driver.get("https://www.training-support.net/selenium/target-practice");
	  }
	
	  @Test (groups = {"HeaderTests", "ButtonTests"}) 
	  public void titleChk() {
		  String pgTitle = driver.getTitle();
		  Assert.assertEquals(pgTitle, "Target Practice");
	  }
	  
	  @Test (groups = {"HeaderTests"}, dependsOnMethods = {"titleChk"})
	  public void headerChk1() {
		  String thirdHeader = driver.findElement(By.id("third-header")).getText();
		  Assert.assertEquals(thirdHeader, "Third header");
	  }

	  @Test (groups = {"HeaderTests"}, dependsOnMethods = {"titleChk"})
	  public void headerChk2() {
		  WebElement fifthHeader = driver.findElement(By.xpath("//h5[text()='Fifth header']"));
		  Assert.assertEquals(fifthHeader.getCssValue("color"), "rgb(251, 189, 8)");
	  }
	  
	  @Test (groups = {"ButtonTests"}, dependsOnMethods = {"titleChk"})
	  public void buttonChk1() {
		  String buttonOlive = driver.findElement(By.xpath("//button[text()='Olive']")).getText();
		  Assert.assertEquals(buttonOlive, "Olive");
	  }
  
	  @Test (groups = {"ButtonTests"}, dependsOnMethods = {"titleChk"})
	  public void buttonChk2() {
		  WebElement fifthHeader = driver.findElement(By.xpath("//button[text()='Brown']"));
		  Assert.assertEquals(fifthHeader.getCssValue("color"), "rgb(255, 255, 255)");
	  }
	  
	  @AfterClass
	  public void afterClass() {
		  driver.close();
	  }
}
