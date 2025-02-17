package pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Addinstitution {
		WebDriver driver;
		VisitLogs visit;
		
		
		public Addinstitution (WebDriver drv) {
			this.driver=drv;
			
		}
		
		public void btnAddInst() {
			visit=new VisitLogs(driver);
			visit.click_logs();
			WebElement btnvisit=driver.findElement(By.xpath("//button[text()='Add Institutions']"));
			btnvisit.click();
				
		}
		
		public void inst_type(){
				WebElement type=driver.findElement(By.xpath("(//div[@class=' css-hlgwow'])[9]"));
				type.click();
			}
		public void select_type(String role) {
		    String xpath;
		    
		    if (role.equalsIgnoreCase("manager")) {
		        xpath = "(//div[text()='Academic Institutions'])[10]";
		    } else {
		        xpath = "(//div[text()='Academic Institutions'])[6]";
		    }
		    
		    WebElement select = driver.findElement(By.xpath(xpath));
		    select.click();
		}

		public void inst_name() {
		    String randomText = getRandomString(5); // Generate a 5-letter random string
		    WebElement name = driver.findElement(By.xpath("//input[@id='organizationName']"));
		    name.sendKeys("Testing Institute " + randomText);  // Appends random characters
		}

		public void inst_mail() {
		    Random rand = new Random();
		    String randomText = getRandomString(5).toLowerCase(); // Ensure lowercase for email
		    WebElement mail = driver.findElement(By.xpath("//input[@id='email' and @placeholder='Institution Email']"));
		    mail.sendKeys("testinstitutes" + randomText + "@gmail.com"); // Unique alphabetic email
		}

		// Helper method to generate a random alphabetic string
		public String getRandomString(int length) {
		    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		    StringBuilder sb = new StringBuilder();
		    Random rand = new Random();
		    
		    for (int i = 0; i < length; i++) {
		        sb.append(alphabet.charAt(rand.nextInt(alphabet.length())));
		    }
		    
		    return sb.toString();
		}
			public void inst_place() {
				WebElement place=driver.findElement(By.xpath("//input[@id='place' and @placeholder='Place']"));
				place.sendKeys("Trivandrum");
			}
			public void inst_state()  {
			    WebElement state = driver.findElement(By.xpath("(//div[@class=' css-hlgwow'])[10]"));
			    state.click();

			    WebElement selectState = driver.findElement(By.xpath("//div[text()='Kerala']"));
			    selectState.click();
			   
			}

			public void  inst_dist() {
				WebElement district=driver.findElement(By.xpath("(//div[@class=' css-hlgwow'])[11]"));
				district.click();
				WebElement selectdist=driver.findElement(By.xpath("//div[text()='Thiruvananthapuram']"));
				selectdist.click();
			}
			public void inst_submit() {
				WebElement submit=driver.findElement(By.xpath("(//button[text()='Submit'])[4]"));
				submit.click();
			}
			public void inst_cancel() {
				WebElement cancel=driver.findElement(By.xpath("(//button[@type='button' and text()='Cancel'])[3]"));
				cancel.click();
			}
			public boolean isDisplayed() {
				try {
					WebElement success=driver.findElement(By.xpath("//h3[text()='Thanks for adding new Institution ']"));
					return success.isDisplayed();
				}catch(Exception e) {
					return false;
				}
			}
			public void popupclose() {
				WebElement close=driver.findElement(By.xpath("(//button[text()='Close'])[4]"));
				close.click();

			
			}
		}
		
		
		

