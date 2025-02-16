package testcases;

import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Basetest;
import pages.Loginpage;
import utils.AutomationConstants;

public class Logintest    extends Basetest {
    
    Loginpage obj;
    
    
    @BeforeTest
    public void object() {
        obj=new Loginpage(driver);
    }
    
     @BeforeTest
        public void setupObjects() throws IOException {
            setup(); // Load properties
            obj = new Loginpage(driver);
        }
     @Test(priority = 1)
     public void forgotPasssword() {
    	 obj.forgotPassword();
    	 obj.emailpopupisDisplayed();
    	 obj.provideEmail();
    	 obj.sendmailpopDisplayed();
    	 obj.close_popup();
     }

        @Test(priority = 2)
        public void loginAsManager() {
            loginAs("manager");
            obj.prflClick();
            obj.profile_logout();
        }

        @Test(priority = 3)
        public void loginAsAssociate() {
            loginAs("associate");
            obj.associateClick();
            obj.profile_logout();
        }
        
        @Test(priority=4)
        public void blankCredentials() {
        	obj.clickLoginButton();
        	
        	String actuname=obj.blankUserid();
    		System.out.println(obj.blankUserid());
    		Assert.assertEquals(actuname, AutomationConstants.userId);
    		
    		String actpass=obj.blankPass();
    		System.out.println(obj.blankPass());
    		Assert.assertEquals(actpass,AutomationConstants.password );
        }
    }