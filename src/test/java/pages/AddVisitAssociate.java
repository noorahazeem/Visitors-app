package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddVisitAssociate {
	WebDriver driver;
	Addinstitution add;
	
	public  AddVisitAssociate (WebDriver drv) {
		this.driver=drv;
	}
	public boolean addvisit_displayed() {
		try {
			WebElement addvisit= driver.findElement(By.xpath("//h1[text()='Add New Visit']"));
			return addvisit.isDisplayed();
		}catch(Exception e) {
			return false;
		}
		
	}
	public void add_visit() {
		WebElement clicknew=driver.findElement(By.xpath("//h1[text()='Add New Visit']"));
		clicknew.click();
	}
	
	
	public  void add_inst() {
		WebElement add=driver.findElement(By.xpath("(//button[text()='Add'])[3]"));
		add.click();
	}
	
	public void select_inst() {
		WebElement inst=driver.findElement(By.xpath("(//div[@class=' css-19bb58m'])[5]"));
		inst.click();
    	WebElement select=driver.findElement(By.xpath("//div[contains(text(), 'Brennen college Thalassery')]"));
		select.click();
	}
	public void select_emp() {
		WebElement emp=driver.findElement(By.xpath("(//div[@class=' css-19bb58m'])[6]"));
		emp.click();
		WebElement select_emp=driver.findElement(By.xpath("//div[text()='Associate 2']"));
		select_emp.click();
	}
	public void date_time() {
		WebElement date = driver.findElement(By.xpath("(//input[@id='visitDateTime'])[2]"));
		date.click();
		
		// Clear any pre-existing value
		date.clear();
		// Set the date and time (Format: yyyy-MM-ddThh:mm)
		date.sendKeys("2025-02-15T10:30");
	}
	public void purpose() {
		WebElement purpose=driver.findElement(By.xpath("(//input[@id='purpose'])[2]"));
		purpose.sendKeys("Meeting");
	}
	public void contactPerson() {
		WebElement contact=driver.findElement(By.xpath("(//div[@class=' css-19bb58m'])[7]"));
		contact.click();
		WebElement person=driver.findElement(By.xpath("//div[text()='test (tester)']"));
		person.click();
	}
	public void addNote() {
		WebElement note=driver.findElement(By.xpath("(//input[@id='additionalNotes'])[2]"));
		note.sendKeys("NA");
	}
	public void dis_topic() {
		WebElement topic=driver.findElement(By.xpath("(//input[@id='discussionTopic'])[2]"));
		topic.sendKeys("Project Proposal");
	}
	
	// Upload File (Browse Button)
    public void upload_file(String filePath) {
        WebElement uploadButton = driver.findElement(By.xpath("(//label[text()='Browse'])[2]"));
        uploadButton.sendKeys(filePath); // Provide local file path
       
    }
    
	public void cancel_visit() {
		WebElement cancel=driver.findElement(By.xpath("(//button[text()='Cancel'])[3]"));
		cancel.click();
	}
}
