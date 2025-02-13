package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Addvisit {
	WebDriver driver;
	public Addvisit(WebDriver drv) {
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
	public void inst_type(){
		WebElement type=driver.findElement(By.xpath("(//div[@class='w-full'])[9]"));
		type.click();
	}
	public  void select_type() {
		WebElement select=driver.findElement(By.xpath("//div[text()='Academic Institutions']"));
		select.click();
	}
	public void inst_name() {
		WebElement name=driver.findElement(By.xpath("//input[@id='organizationName']"));
		name.sendKeys("Lourdes Matha Collage ");
	}
	public  void inst_mail() {
		WebElement mail=driver.findElement(By.xpath("//input[@id='email' and @placeholder='Institution Email']"));
		mail.sendKeys("Lourdeslmcst@gmail.com");
	}
	public void inst_place() {
		WebElement place=driver.findElement(By.xpath("//input[@id='place' and @placeholder='Place']"));
		place.sendKeys("Trivandrum");
	}
	public void inst_state() throws InterruptedException {
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);");
		WebElement state=driver.findElement(By.xpath("//div[@class=' css-1jqq78o-placeholder' and @id ='react-select-11-placeholder']"));
		Thread.sleep(1000);  // Small delay for smooth scrolling

		state.click();
		WebElement selectstate=driver.findElement(By.xpath("//input[@id='react-select-10-input']"));
		selectstate.click();
	}
	public void  inst_dist() {
		WebElement district=driver.findElement(By.xpath("(//div[text()='Select...'])[8]"));
		district.click();
		WebElement selectdist=driver.findElement(By.xpath("//input[@id='react-select-10-input']"));
		selectdist.click();
	}
	public void inst_submit() {
		WebElement submit=driver.findElement(By.xpath("(//button[text()='Submit'])[2]"));
		submit.click();
	}
	public void inst_cancel() {
		WebElement cancel=driver.findElement(By.xpath("(//button[@type='button' and text()='Cancel'])[3]"));
		cancel.click();
	}
	public void cancel_visit() {
		WebElement cancel=driver.findElement(By.xpath("(//button[text()='Cancel'])[3]"));
		cancel.click();
	}
}
