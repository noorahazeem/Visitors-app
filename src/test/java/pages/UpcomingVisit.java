package pages;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpcomingVisit {
	 WebDriver driver;
	 
	 public UpcomingVisit(WebDriver drv) {
		 this.driver=drv;
	 }
	 public boolean isdisplayed() {
		 try {
			 WebElement fieldTitle=driver.findElement(By.xpath("(//h2[text()='Upcoming Visits'])[2]"));
			 WebElement inst=driver.findElement(By.xpath("//th[text()='Institutions']"));
			 WebElement instType=driver.findElement(By.xpath("//th[text()='Institutions Type']"));
			 WebElement date=driver.findElement(By.xpath("//th[text()='Date']"));
			 WebElement empName=driver.findElement(By.xpath("//th[text()='Employee Name']"));
			 WebElement cntPerson=driver.findElement(By.xpath("//th[text()='Contact Person']"));
			 WebElement status=driver.findElement(By.xpath("//th[text()='Status']"));
			 WebElement action=driver.findElement(By.xpath("//th[text()='Action']"));

			 return fieldTitle.isDisplayed() && inst.isDisplayed() &&
					 instType.isDisplayed() && date.isDisplayed() &&
					 empName.isDisplayed() && cntPerson.isDisplayed() &&
					 status.isDisplayed() && action.isDisplayed();
	      }catch(Exception e) {
	    	  return false;
	      }
	 	}
	 
	 public void viewData() {
		 WebElement view=driver.findElement(By.xpath("(//button[@class='text-blue-700 hover:text-blue-300'])[5]"));
		 view.click();
	 }
	 public boolean viewdetailsDisplay() {
		 viewData();
		 try {
			 WebElement details=driver.findElement(By.xpath("//h3[text()='Visit Details']"));
			 WebElement purpose=driver.findElement(By.xpath("//h3[text()='Visit Purpose']"));
			 return details.isDisplayed() && purpose.isDisplayed();
		 }catch(Exception e) {
			 return false;
		 }
	 }
	 public void viewdataClose() {
		 WebElement close=driver.findElement(By.xpath("(//button[text()='Close'])[1]"));
		 close.click();
	 }
	 public void actionUpdate() {
		 WebElement view=driver.findElement(By.xpath("(//button[@class='text-blue-700 hover:text-blue-300 w-[20px] h-[20px]'])[3]"));
		 view.click();
		 
	 }
	
	 public void update(String optionToSelect) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Valid options
	        List<String> validOptions = Arrays.asList("Action Needed", "Pending");

	        if (!validOptions.contains(optionToSelect)) {
	            System.out.println("❌ Invalid option: " + optionToSelect);
	            return;
	        }

	        // Click the dropdown to open options
	        WebElement status = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class=' css-19bb58m'])[4]")));
	        status.click();

	        // Wait for options to be visible (better XPath)
	        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
	                By.xpath("//div[contains(@class, 'menu')]//div[text()='Action Needed' or text()='Pending']")
	        ));

	        boolean optionFound = false;
	        for (WebElement option : options) {
	            if (option.getText().equalsIgnoreCase(optionToSelect)) {
	                option.click();
	                optionFound = true;
	                break;
	            }
	        }

	        if (!optionFound) {
	            System.out.println("❌ Option '" + optionToSelect + "' not found in dropdown.");
	            return;
	        }

	        // Click Submit button
	        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='Submit'])[1]")));
	        submit.click();
	        System.out.println("✅ Status updated to: " + optionToSelect);
	    }
	
	      
	
	 public void updateSuccessClose() {
		 WebElement closebtn=driver.findElement(By.xpath("(//button[text()='Close'])[1]"));
		 closebtn.click();
	 }
	 
	 public void  actionDlt() {
		 WebElement dltbtn=driver.findElement(By.xpath("(//button[@class='text-blue-700 hover:text-blue-300'])[6]"));
		 dltbtn.click();
	 }
	// Method to handle the alert popup
	    public void handleDeletePopup(String reason) {
	        try {
	            // Switch to alert
	            Alert alert = driver.switchTo().alert();
	            
	            // Enter the reason for deletion if applicable
	            alert.sendKeys(reason);
	            
	            // Click OK
	            alert.accept();
	            
	        } catch (Exception e) {
	            System.out.println("Alert popup not found: " + e.getMessage());
	        }
	    }
	 
}
