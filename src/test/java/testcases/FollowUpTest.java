package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Basetest;
import pages.FollowUp;
import pages.Loginpage;

public class FollowUpTest extends Basetest {
	Loginpage login;
	FollowUp follow;
	
    @Test(priority=1)
    public void testFollowUpAction() {
    	loginAs("manager");
    
        follow.enterActionDetails();
        follow.enterActionDescription();
        follow.enterActionDueDate();
        follow.selectStatus();
        follow.checkAddVisit();
        follow.clickSubmit();
    }
	}

  

