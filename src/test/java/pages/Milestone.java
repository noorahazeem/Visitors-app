package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Milestone {
		WebDriver driver;
		
		public Milestone(WebDriver drv) {
			this.driver=drv;
		}
		
	public boolean isDisplayed() {
		try {
			WebElement title=driver.findElement(By.xpath("//h2[text()='Milestones']"));
			WebElement orgType=driver.findElement(By.xpath("//option[text()='Select Organization Type']"));
			WebElement org=driver.findElement(By.xpath("//option[text()='Select Organization']"));
			
			return title.isDisplayed() && orgType.isDisplayed() &&
					org.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	
	public void milestonedisplay() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	
		WebElement orgType=driver.findElement(By.xpath("//option[text()='Select Organization Type']"));
		orgType.click();
		WebElement option=driver.findElement(By.xpath("//option[text()='PUBLIC']"));
		option.click();
		WebElement org=driver.findElement(By.xpath("//option[text()='Select Organization']"));
		org.click();
		WebElement orgOption=driver.findElement(By.xpath("//option[text()='Test Intsn Name']"));
		orgOption.click();
		WebElement btnGo=driver.findElement(By.xpath("//button[text()='Go']"));
		btnGo.click();
		// **Wait for Export CSV button to appear**
	    WebElement btnCSV = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Export CSV'])[2]")));

	    // **Verify if Export CSV button is displayed**
	    if (btnCSV.isDisplayed()) {
	        System.out.println("✅ Export CSV button is visible after clicking 'Go'.");
	    } else {
	        System.out.println("❌ Export CSV button is NOT displayed.");
	    }

	    // Click "Go" again (if required)
	    btnGo.click();
	}
	
}
