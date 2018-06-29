import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
public class NewTest {
WebDriver driver;
	@BeforeTest
	public void load_driver() {
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		
		
	}
	
	@Test
	public void Step_01_Open_Url() {
		driver.get("https://github.com/");   
	}
	@Test
	public void Step_02_Open_Sign_in() {
		driver.findElement(By.xpath("//a[text()='Sign in']")).click(); 
	}
//	@Test
//	public void Step_03_Log_in_with_correct_username_and_password() {
//	driver.findElement(By.id("login_field")).sendKeys("Name");;   
//	driver.findElement(By.id("password")).sendKeys("Password"); 
//	driver.findElement(By.xpath("//input[@type='submit']")).click(); 
//	}
//	@Test
//	public void Step_04_Log_in_with_correct_username_and_incorrect_password() {
//	driver.findElement(By.id("login_field")).sendKeys("Name");;   
//	driver.findElement(By.id("password")).sendKeys("Password"); 
//	driver.findElement(By.xpath("//input[@type='submit']")).click(); 
//	}
//	@Test
//	public void Step_05_Log_in_with_incorrect_username_and_password() {
//	driver.findElement(By.id("login_field")).sendKeys("Name");;   
//	driver.findElement(By.id("password")).sendKeys("Password"); 
//	driver.findElement(By.xpath("//input[@type='submit']")).click(); 
//	}

	@Test
	public void Step_06_Log_in_with_correct_username_and_password_and_create_new_repository_wth_name_of_existing_repository() {
		String b= "form-control js-repo-name short is-autocheck-errored";
		driver.findElement(By.id("login_field")).sendKeys("rachit212");;   
	driver.findElement(By.id("password")).sendKeys("rachit@123"); 
	driver.findElement(By.xpath("//input[@type='submit']")).click(); 
	driver.findElement(By.xpath("//a[text()='New repository']")).click(); 
	driver.findElement(By.id("repository_name")).sendKeys("tatoc1");
	
	WebDriverWait wait=new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".is-autocheck-successful")));
	
    String a=driver.findElement(By.id("repository_name")).getAttribute("class");
    System.out.println(a);  
Assert.assertEquals(a,"form-control js-repo-name short is-autocheck-successful");
System.out.println("true");
	
		
		
		
	}
	@AfterTest
	public void afterTest() {
		//driver.close();
		
	}

}