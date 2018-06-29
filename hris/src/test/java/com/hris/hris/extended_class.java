package com.hris.hris;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class extended_class {
	WebDriver driver;
	public void Open_Url() {
		driver.get("https://hris.qainfotech.com/login.php");
	}
	public void Login_Panel() {
		driver.findElement(By.xpath("//span[text()='Login Panel']")).click(); 
	}
	public void Set_Path() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
			}

	public void Log_in_with_correct_username_and_password() {
		driver.findElement(By.id("txtUserName")).sendKeys("Name");;   
		driver.findElement(By.id("txtPassword")).sendKeys("Password"); 
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	public void Log_In_with_Either_Username_or_Password_Incorrect() {
		driver.findElement(By.id("txtUserName")).sendKeys("Name");;   
		driver.findElement(By.id("txtPassword")).sendKeys("Password"); 
		driver.findElement(By.xpath("//input[@type='submit']")).click(); 
		WebElement invalid=driver.findElement(By.xpath("//div[contains(@class ,'alert')]"));
		String invalid_login=invalid.getAttribute("style");
		Assert.assertEquals(invalid_login,"display: block;");
		System.out.println("true");
	}
	public void Log_in_with_Username_and_Blank_password() {
		driver.findElement(By.id("txtUserName")).sendKeys("Name");;   
		WebElement pass=driver.findElement(By.id("txtPassword"));
		pass.sendKeys(""); 
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	    String styl=pass.getAttribute("style");
	     Assert.assertEquals(styl,"border: 1px solid red;");
	    System.out.println("true");
}
	public void Log_in_with_Blank_Username_and_Password() {
		WebElement user=driver.findElement(By.id("txtUserName"));
		user.sendKeys("");
		WebElement pass=driver.findElement(By.id("txtPassword"));
		pass.sendKeys("password"); 
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	    String styl=user.getAttribute("style");
	    Assert.assertEquals(styl,"border: 1px solid red; box-shadow: red 0px 1px 1px inset, red 0px 0px 4px;");
	    System.out.println("true");
	}
	public void Log_in_with_correct_username_and_password_and_get_value_from_columns() {
		driver.findElement(By.id("txtUserName")).sendKeys("uuuu");;   
		driver.findElement(By.id("txtPassword")).sendKeys("pppp"); 
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.id("addstatustag")).click();
		WebDriverWait wait=new WebDriverWait(driver,10);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".timesheet #dv_2018-06-11 .emp_time")));
		String txt=driver.findElement(By.cssSelector(".timesheet #dv_2018-06-11 .emp_time")).getText(); 
		System.out.println(txt);
	}
	public void Successful_Logout() {
		driver.findElement(By.id("txtUserName")).sendKeys("rr");;   
		driver.findElement(By.id("txtPassword")).sendKeys("ppppp"); 
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.id("addstatustag")).click();
		Actions act=new Actions(driver);
		WebElement hover=driver.findElement(By.xpath("//span[text()='Rachit']"));
		act.moveToElement(hover).build().perform();
		driver.findElement(By.xpath("//span[text()='Logout']']")).click();
	}
	public void Close() {
		driver.close();
	}
}