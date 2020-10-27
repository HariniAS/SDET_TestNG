package testNGTests;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class Activity10 {
	  WebDriver driver;
	  WebElement slider;
	  WebElement volume;
	  Actions act;
	  
	  @BeforeClass
	  public void beforeClass() {
		  driver = new FirefoxDriver();
		  driver.get("https://www.training-support.net/selenium/sliders");
		  slider = driver.findElement(By.id("slider"));
		  volume = driver.findElement(By.xpath("//*[@id=\'value\']"));
		  act = new Actions(driver);
	  }
	 
	  @Test (priority=0)
	  public void middle() {
		  slider.click();
		  String volumeLvl = volume.getText();
		  System.out.println("Middle volume: "+volumeLvl);
		  Reporter.log("Middle volume level");
		  Assert.assertEquals(volumeLvl, "50");
	  }
	  
	  @Test (priority=1)
	  public void maximum() {
		  act.clickAndHold(slider)
		  	.moveByOffset(100, 0)
		  	.release()
		  	.build()
		  	.perform();
		  String volumeLvl = volume.getText();
		  System.out.println("Maximum volume: "+volumeLvl);
		  Reporter.log("Maximum volume level");
		  Assert.assertEquals(volumeLvl, "100");
	  }
	  
	  @Test (priority=3)
	  public void minimum() {
		  act.clickAndHold(slider)
		  	.moveByOffset(-100, 0)
		  	.release()
		  	.build()
		  	.perform();
		  String volumeLvl = volume.getText();
		  System.out.println("Minimum volume: "+volumeLvl);
		  Reporter.log("Minimum volume level");
		  Assert.assertEquals(volumeLvl, "0");
	  }
	  
	  @Test (priority=4)
	  public void thirty() {
		  act.clickAndHold(slider)
		  	.moveByOffset(-30, 0)
		  	.release()
		  	.build()
		  	.perform();
		  String volumeLvl = volume.getText();
		  System.out.println("30% volume: "+volumeLvl);
		  Reporter.log("30% volume level");
		//  Assert.assertEquals(volumeLvl, "30");
	  }
	  
	  @Test (priority=5)
	  public void eighty() {
		  act.clickAndHold(slider)
		  	.moveByOffset(50, 0)
		  	.release()
		  	.build()
		  	.perform();
		  String volumeLvl = volume.getText();
		  System.out.println("80% volume: "+volumeLvl);
		  Reporter.log("80% volume level");
		 // Assert.assertEquals(volumeLvl, "80");
	  }
	
	  @AfterClass
	  public void afterClass() {
		  //driver.close();
	  }

}
