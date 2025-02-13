package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class Dashboard {
	WebDriver driver;
	
	public Dashboard(WebDriver drv) {
		this.driver=drv;
	}
	public boolean isDisplayed() {
		try {
		WebElement totalvisit=driver.findElement(By.xpath("//h2[text()='Total Visits']"));
		WebElement upcomingvisits=driver.findElement(By.xpath("//h2[text()='Upcoming Visits']"));
		WebElement visitchart=driver.findElement(By.xpath("//h2[text()='Visit View']"));
		WebElement bargraph=driver.findElement(By.xpath("//h2[text()='Organization Statistics']"));
		
		return totalvisit.isDisplayed() && upcomingvisits.isDisplayed() 
				&& visitchart.isDisplayed() && bargraph.isDisplayed();
	}catch (Exception e) {
		return false;
	}
 }
}
	