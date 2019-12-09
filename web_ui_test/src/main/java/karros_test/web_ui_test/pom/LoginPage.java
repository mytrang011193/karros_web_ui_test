package karros_test.web_ui_test.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	WebDriver driver;
	String username_textfield_css = "input[type='email'][placeholder='e-mail...'][id='formHorizontalEmail']";
	String password_textfield_css = "input[type='password'][placeholder='password...'][id='formHorizontalPassword']";
	String login_btn_xpath = "//a[@class='col-login__btn']";
	
	
	public void enter_username(String username) {
		driver.findElement(By.cssSelector(username_textfield_css)).sendKeys(username);
	}
	
	public void enter_password(String password) {
		driver.findElement(By.cssSelector(password_textfield_css)).sendKeys(password);
	}
	
	public void click_login_btn() {
		driver.findElement(By.xpath(login_btn_xpath)).click();
	}
}