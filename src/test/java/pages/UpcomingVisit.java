package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
		 WebElement view=driver.findElement(By.xpath("(//button[@class='text-blue-700 flex items-center space-x-1'])[4]"));
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
		 WebElement close=driver.findElement(By.xpath("(//button[text()='Close'])[2]"));
		 close.click();
	 }
	 public void actionUpdate() {
		 WebElement view=driver.findElement(By.xpath("(//button[@class='text-blue-700 flex items-center space-x-1'])[6]"));
		 view.click();
		 
	 }
	 public boolean updateformDisplay() {
		 viewData();
		 try {
			 WebElement form=driver.findElement(By.xpath("//h3[text()='Update visit']"));
			 return form.isDisplayed();
		 }catch(Exception e) {
			 return false;
		 }
	 }
	 public void update() {
		 WebElement update=driver.findElement(By.xpath("(//div[text()='Action Needed'])[2]"));
		 update.click();
		 WebElement submit=driver.findElement(By.xpath("(//button[text()='Submit'])[1]"));
		 submit.click();
	 }
	 public boolean updateSuccess() {
		 try {
			 WebElement popup=driver.findElement(By.xpath("//h3[text()='Updated Successfully']"));
			 WebElement closebtn=driver.findElement(By.xpath("(//button[text()='Close'])[1]"));
			 
			 return popup.isDisplayed() && closebtn.isDisplayed();
		 }catch(Exception e) {
			 return false;
		 }
	 }
	 public void updateClose() {
		 WebElement closebtn=driver.findElement(By.xpath("(//button[text()='Close'])[1]"));
		 closebtn.click();

	 }
	
	 
}
