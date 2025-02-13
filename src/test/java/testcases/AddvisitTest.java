package testcases;

import java.time.Duration;

import org.testng.annotations.Test;

import base.Basetest;
import pages.Addvisit;

public class AddvisitTest extends Basetest {
    Addvisit add;
    @Test(priority = 1)
    public void testAddvisitmanager() throws InterruptedException {
    	
    	 //  Login as Manager
        loginAs("manager");
        
    	//add new visit as manager
        add=new Addvisit(driver);
        add.addvisit_displayed();
        add.add_visit();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        add.add_inst();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        add.inst_type();
        add.select_type();
        add.inst_name();
        add.inst_mail();
        add.inst_place();
        add.inst_state();
        add.inst_dist();  
//        add.inst_submit();
//        add.inst_cancel();
        add.cancel_visit();
    }
    
    @Test(priority = 2)
    public void testAddvisitassociate() {
    //  Login as Associate
    loginAs("associate");
    
  //add new visit as associate
    add=new Addvisit(driver);
    add.addvisit_displayed();
    add.add_visit();
    add.cancel_visit();
}
}