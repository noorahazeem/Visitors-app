package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
            WebElement prfl= driver.findElement(By.xpath("//img[contains(@src,'/profile/')]"));
            prfl.click();
        }
        public void profile_logout() {
            WebElement logout=driver.findElement(By.xpath("//div[text()='Logout']"));
            logout.click();
        }
        public void associateClick() {
            WebElement prfl= driver.findElement(By.xpath("//img[contains(@src, '/profile/')]"));
            prfl.click();
        }
        public void forgotPassword() {
        	WebElement forgot=driver.findElement(By.xpath("//p[text()='Forgotpassword?']"));
        	forgot.click();
        }
        public boolean emailpopupisDisplayed() {
        	try {
        		WebElement emailpop=driver.findElement(By.xpath("//h3[text()='Forgot Your Password']"));
        		return emailpop.isDisplayed();
        	}catch(Exception e) {
        		return false;
        	}
        }
        public void provideEmail() {
        	WebElement email=driver.findElement(By.xpath("//input[@name='email']"));
        	email.sendKeys("dummymail@gmail.com");
        	WebElement nextbtn=driver.findElement(By.xpath("//button[text()='Next']"));
        	nextbtn.click();
        }
        public boolean sendmailpopDisplayed() {
        	try {
        		WebElement popup=driver.findElement(By.xpath("//p[text()='If your email is registered with us, you will receive a password reset link shortly.']"));
        		return popup.isDisplayed();
        	}catch(Exception e) {
        		return false;
        	}
        }
        public void close_popup() {
        	WebElement close=driver.findElement(By.xpath("//button[text()='Close']"));
        	close.click();
        }
        public String blankUserid( ) {
            WebElement uname = driver.findElement(By.xpath("//p[text()='Please enter the user id']"));
            String userid=uname.getText();
            return userid;
        }
        public String blankPass() {
            WebElement pwd = driver.findElement(By.xpath("//p[text()='Please enter the password']"));
            String pass=pwd.getText();
            return pass;
        }
           

    }
