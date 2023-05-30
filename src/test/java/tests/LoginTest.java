package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import base.Baseclass;

public class LoginTest extends Baseclass{

	@Test
	public void loginTest() {
	
		driver.findElement(By.name("q")).sendKeys("Hey Java", Keys.ENTER);
		System.out.println(driver.getTitle().toString());
	}
	
}
