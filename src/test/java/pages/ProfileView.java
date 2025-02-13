package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfileView {
	 WebDriver driver;
	 Loginpage login;
	 public ProfileView(WebDriver drv) {
		 this.driver=drv;
	 }
	 public boolean profileManager() {
		 login=new Loginpage(driver);
		 login.prflClick();
		 try {
			 WebElement profile=driver.findElement(By.xpath("//div[text()='Profile']"));
			 return profile.isDisplayed();
		 }catch (Exception e) {
			 return false;
		 }
	 }
	 public void click_Profile() {
		 WebElement profile=driver.findElement(By.xpath("//div[text()='Profile']"));
		 profile.click();
	 }
	 public boolean isDisplayed() {
			try {
			WebElement name=driver.findElement(By.xpath("//p[text()='Name']"));
			WebElement namefield=driver.findElement(By.xpath("//input[@type='text' and @disabled and @value='Manager 1']"));
			WebElement department=driver.findElement(By.xpath("//p[text()='Department']"));
			WebElement depfield=driver.findElement(By.xpath("//input[@type='text' and @disabled and @value='Academic Relations (Test)']"));
			WebElement designation=driver.findElement(By.xpath("//p[text()='Designation']"));
			WebElement desifield=driver.findElement(By.xpath("//input[@type='text' and @disabled and @value='Academic Manager (Test)']"));
			WebElement email=driver.findElement(By.xpath("//p[text()='Email']"));
			WebElement emailfield=driver.findElement(By.xpath("//input[@type='text' and @disabled and @value='manager1@ictkerala.org']"));
			
			return name.isDisplayed() && namefield.isDisplayed() && 
					department.isDisplayed() && depfield.isDisplayed() && 
					designation.isDisplayed() && desifield.isDisplayed() && 
					email.isDisplayed() && emailfield.isDisplayed();
		}catch (Exception e) {
			return false;
		}
	 }
	}
