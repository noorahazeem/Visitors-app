package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class FollowUp {
    
    WebDriver driver;


    // Constructor
    public FollowUp(WebDriver driver) {
        this.driver = driver;
    }
    public void followupClick() {
    	WebElement followup=driver.findElement(By.xpath("(//img[@src='/static/media/followup.9f7f24aa1fa9e27c83d2.png'])[5]"));
    	followup.click();
    }

    public void enterActionDetails() {
        WebElement actionDetails = driver.findElement(By.xpath("//input[@id='actionDetails']"));  
        actionDetails.sendKeys("Manager Follow-Up");
    }

    public void enterActionDescription() {
        WebElement actionDescription = driver.findElement(By.xpath("//input[@id='actionDescription']"));  
        actionDescription.sendKeys("Need to review the project progress");
    }

    public void enterActionDueDate() {
        WebElement actionDueDate = driver.findElement(By.xpath("//input[@id='actionDueDate']"));  
        actionDueDate.sendKeys("25-02-2025");
    }

    public void selectStatus() {
        WebElement statusDropdown = driver.findElement(By.xpath("(//div[@class=' css-19bb58m'])[5]"));  
        statusDropdown.click();
        WebElement statusselect = driver.findElement(By.xpath("//div[text()='Completed']"));
        statusselect.click();
        
    }

    public void checkAddVisit() {
        WebElement addVisitCheckbox = driver.findElement(By.xpath("//input[@type='checkbox']"));  
        if (!addVisitCheckbox.isSelected()) {
            addVisitCheckbox.click();
        }
    }

    public void clickSubmit() {
        WebElement submitButton = driver.findElement(By.xpath("(//button[text()='Submit'])[2]")); 
        submitButton.click();
    }

    public void clickCancel() {
        WebElement cancelButton = driver.findElement(By.xpath("(//button[text()='Cancel'])[3]"));  
        cancelButton.click();
    }
}
