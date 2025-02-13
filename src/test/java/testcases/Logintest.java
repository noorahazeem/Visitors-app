package testcases;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Basetest;
import pages.Loginpage;

public class Logintest	extends Basetest {
	
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
	    public void loginAsManager() {
	    	loginAs("manager");
	        obj.prflClick();
	        obj.profile_logout();
	    }

	    @Test(priority = 2)
	    public void loginAsAssociate() {
	        loginAs("associate");
	        obj.associateClick();
	        obj.profile_logout();
	    }
	}

	