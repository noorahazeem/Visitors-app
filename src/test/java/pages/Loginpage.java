package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Loginpage {
	    WebDriver driver;

	    // Constructor to initialize the WebDriver
	    public Loginpage(WebDriver drv) {
	        this.driver = drv;
	    }

	 // Method to input username dynamically
	    public void enterUsername(String username) {
	        WebElement uname = driver.findElement(By.xpath("//input[@name='userId']"));
	        uname.clear();
	        uname.sendKeys(username);
	    }

	    // Method to input password dynamically
	    public void enterPassword(String password) {
	        WebElement pwd = driver.findElement(By.xpath("//input[@name='password']"));
	        pwd.clear();
	        pwd.sendKeys(password);
	    }
	     	     
	 // Click the visibility button if needed
	    public void viewButtonClick() {
	        WebElement loginButton = driver.findElement(By.cssSelector("svg.h-6.text-gray-700.block"));
	        loginButton.click();
	    }

	    // Click the login button
	    public void clickLoginButton() {
	        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Sign In']"));
	        loginButton.click();
	    }


	    public void prflClick() {
	    	WebElement prfl= driver.findElement(By.xpath("//img[contains(@src, '/profile/')]"));
	    	prfl.click();
	    }
	    public void profile_logout() {
	    	WebElement logout=driver.findElement(By.xpath("//div[text()='Logout']"));
	    	logout.click();
	    }
	
	    public void associateClick() {
	    	WebElement prfl= driver.findElement(By.xpath("//img[contains(@src, '/profile/')]"));
	    	prfl.click()	    	;
	    }
	    
	}

