package testcases;

import java.time.Duration;

import org.testng.annotations.Test;

import base.Basetest;

import pages.ProfileView;

public class ProfileViewtest  extends Basetest {
    ProfileView pro;
    
    @Test(priority = 1)
    public void testProviewmanager() {
    	
    	 //  Login as Manager
        loginAs("manager");
        //Check manager profile
        pro=new ProfileView(driver);
        pro.profileManager();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        pro.click_Profile();
}
}