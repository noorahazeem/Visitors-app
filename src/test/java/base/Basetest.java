package base;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pages.Loginpage;

public class Basetest {
	protected WebDriver driver;
	protected Properties prop;
	protected Loginpage loginpage;
	
	public void setup() throws IOException {
		FileReader fread=new FileReader("F:\\Software Testing\\Final Project\\Visitors-app\\src\\test\\resources\\config.properties");
		prop=new Properties();
		prop.load(fread);
		
	}
	@BeforeTest
	public void config()  throws IOException {
		setup();
		driver=new ChromeDriver();
		//driver=new FirefoxDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 loginpage = new Loginpage(driver);
	}
	@AfterTest
	public void teardown() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
	//common method to log in as different users
	protected void loginAs(String role) {
		String username = prop.getProperty(role+"_username");
		String password = prop.getProperty(role+"_password");
		
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.viewButtonClick();
		loginpage.clickLoginButton();
		
	}
}

