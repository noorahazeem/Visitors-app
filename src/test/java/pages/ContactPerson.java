package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactPerson {
	WebDriver driver;
	
	public ContactPerson(WebDriver drv) {
		this.driver=drv;
	}
	
	public void addPerson() {
		WebElement addbtn=driver.findElement(By.xpath("(//button[text()='Add'])[4]"));
		addbtn.click();
	}
	public boolean addContactisDisplayed() {
		try {
			WebElement form=driver.findElement(By.xpath("//h3[text()='Add Contact Person']"));
			WebElement inst=driver.findElement(By.xpath("//p[text()='Select Institution']"));
			return form.isDisplayed() && inst.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	public void form() {
		WebElement name=driver.findElement(By.xpath("//input[@id='name']"));
		name.sendKeys("Noora");
		WebElement designation=driver.findElement(By.xpath("//input[@id='designation']"));
		designation.sendKeys("Software Engineer");
		WebElement email=driver.findElement(By.xpath("(//input[@id='email'])[2]"));
		email.sendKeys("dummymail@gmail.com");
		WebElement number=driver.findElement(By.xpath("//input[@class='form-control ']"));
		number.sendKeys("1234567895");
	}
	public void submit() {
		WebElement btnsubmit=driver.findElement(By.xpath("(//button[text()='Submit'])[4]"));
		btnsubmit.click();
	}
	public void cancel() {
		WebElement cancelbtn=driver.findElement(By.xpath("(//button[text()='Cancel'])[5]"));
		cancelbtn.click();
	}
	public void x_btn() {
		WebElement closebtn=driver.findElement(By.xpath("(//span[text()='Close modal'])[4]"));
		closebtn.click();
	}
}
