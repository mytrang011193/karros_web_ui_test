package karros_test.web_ui_test.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	WebDriver driver;
	String filters_btn_xpath = "//button[@class='btn btn-filter module_grid__btn_filter btn btn-default']";
	String filter_popup_request_status_css = "[name='status'][id='formControlsSelect']";
	String filter_popup_apply_filters_btn_xpath = "//button[@class='btn-filter btn btn-default']";
	String table_items_xpath = "//table[@class='table table-striped table-bordered table-hover table-condensed table-body']//child::tbody/child::tr"; 
	String header_title_xpath = "//div[@class='navbar-header']";
	boolean is_filter_popup_opened = false;
	
	public void open_filter_popup() {
		driver.findElement(By.xpath(filters_btn_xpath)).click();
		is_filter_popup_opened = true;
	}
	public void set_filter_request_status(String request_status) {
		if (is_filter_popup_opened==false) {
			open_filter_popup();
		};
		Select request_status_drp = new Select(driver.findElement(By.cssSelector(filter_popup_request_status_css)));
		request_status_drp.selectByVisibleText(request_status);
	}
	
	public void apply_filter() {
		driver.findElement(By.xpath(filter_popup_apply_filters_btn_xpath)).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(filter_popup_apply_filters_btn_xpath)));
	}
	
	public int count_items_by_year_submitted(String year_submitted) {
		int count=0;
		List<WebElement> date_submitted_els = driver.findElements(By.xpath("//td[@class='table-body-cols']//div[contains(text(),':')]"));
		for (int i=0; i<date_submitted_els.size(); i++) {
			if (date_submitted_els.get(i).getText().contains("/" + year_submitted)) {
				count+=1;
			}
		}
		System.out.println("Total items submitted in " + year_submitted + " is: " + count);
		return count;
	}
	
	public void wait_home_page_loaded() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(header_title_xpath)));
	}

}