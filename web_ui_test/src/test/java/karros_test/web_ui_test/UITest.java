package karros_test.web_ui_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.Assert;
import karros_test.web_ui_test.pom.LoginPage;
import karros_test.web_ui_test.pom.HomePage;
import java.io.File;

public class UITest {
	
	
	WebDriver driver;
	LoginPage login_page;
	HomePage home_page;
	
	public UITest() {
		super();
		File file = new File("");
		String currentPath = file.getAbsolutePath();
		//set path to checkodriver file so we can create firefox driver 
		System.setProperty("webdriver.gecko.driver", currentPath + "\\src\\test\\java\\karros_test\\web_ui_test\\geckodriver.exe");
		driver = new FirefoxDriver();
		login_page = new LoginPage(driver);
		home_page = new HomePage(driver);
	}
	
	@BeforeTest
	public void launch_login_web() {
		System.out.println("Launching web url: http://ktvn-test.s3-website.us-east-1.amazonaws.com");
		//launch web url
		driver.get("http://ktvn-test.s3-website.us-east-1.amazonaws.com");
		
		System.out.println("Entering username and password...");
		//input username
		login_page.enter_username("admin@test.com");
		//input password
		login_page.enter_password("test123");
		System.out.println("Clicking Login button...");
		//click login button
		login_page.click_login_btn();
		//waiting for home page is loaded
		home_page.wait_home_page_loaded();
	}
	
	@AfterTest
	public void close_driver() {
		driver.close();
	}
	
	@Test
	public void script_test() {
		System.out.println("Opening Filters popup...");
		//open Filters popup
		home_page.open_filter_popup();
		System.out.println("Set Request Status to Approved...");
		//set Request Status to Approved
		home_page.set_filter_request_status("Approved");
		System.out.println("Applying filter...");
		//click Apply button
		home_page.apply_filter();
		//count the total items in table data
		int items_count = home_page.count_items_by_year_submitted("2019");
		//verify the total items is correct
		Assert.assertEquals(items_count, 5);
		
	}
}