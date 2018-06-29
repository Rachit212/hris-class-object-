package com.hris.hris;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class hris extends extended_class {
	WebDriver driver;

	@BeforeTest
	public void load_driver() {
		Set_Path();
	}

	@Test
	public void Step_01_Open_Url() {
		Open_Url();
	}

	@Test
	public void Step_02_Open_Log_in_Panel() {
		Login_Panel();
	}

	@Test
	public void Step_03_Log_in_with_correct_username_and_password() {
	//	Log_in_with_correct_username_and_password();
	}

	@Test
	public void Step_04_Log_In_with_Either_Username_or_Password_Incorrect() {
		Log_In_with_Either_Username_or_Password_Incorrect();

	}

	@Test
	public void Step_05_Log_in_with_Username_and_Blank_password() {
	//	Log_in_with_Username_and_Blank_password();
	}

	@Test
	public void Step_06_Log_in_with_Blank_Username_and_Password() {
	//	Log_in_with_Blank_Username_and_Password();

	}

	@Test
	public void Step_07_Log_in_with_correct_username_and_password_and_get_value_from_columns() {
		//Log_in_with_correct_username_and_password_and_get_value_from_columns();
	}

	@Test
	public void Step_08_Successful_Logout() {
	//	Successful_Logout();

	}

	@AfterTest
	public void afterTest() {
		Close();

	}

}
