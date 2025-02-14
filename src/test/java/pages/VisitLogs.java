package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VisitLogs {
	 WebDriver driver;
	 
	 public VisitLogs (WebDriver drv) {
		 this.driver=drv;
	 }
	 public boolean isIconDisplayed() {
			try {
			WebElement visitlogs=driver.findElement(By.xpath("//span[text()='Visit logs']"));
			return visitlogs.isDisplayed();
			}catch(Exception e) {
				
			}
			return false;
	 }
	 public void click_logs() {
		 WebElement logs=driver.findElement(By.xpath("//span[text()='Visit logs']"));
		 logs.click();
	 }
}
