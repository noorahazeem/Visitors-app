package testcases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.Basetest;
import pages.AddVisitAssociate;
import pages.AddvisitManager;
import pages.ContactPerson;
import pages.Loginpage;

public class AddvisitTest extends Basetest {
    AddvisitManager add;
    AddVisitAssociate asso;
    ContactPerson cont;
    Loginpage login;
   
    @Test(priority = 1)
    public void testAddVisitManager() throws InterruptedException {
    	loginAs("manager");
   
    	add = new AddvisitManager(driver);
        add.addvisit_displayed();
        System.out.println("Add visit button is displayed");

        add.add_visit();
        System.out.println("Add visit button is clickable");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        add.select_inst();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        add.select_emp();
        add.date_time();
        System.out.println("Date selected");
        add.purpose();
        add.contactPerson();
        add.addNote();
        add.dis_topic();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        
     // Upload File
        add.upload_file("C:\\Users\\admin\\Desktop\\testfile.pdf");
        System.out.println("✅ File uploaded successfully: ");        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        add.submit_visit();
//        System.out.println("Submit clickeed");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        
//     // Check if success pop-up is displayed before closing it
//        if (add.isPopupDisplayed()) {
//            System.out.println("✅ Success pop-up displayed.");
//            add.popup_close();  // Close the pop-up
//        } else {
//            System.out.println("⚠️ Pop-up did not appear, skipping close action.");
//        }
//
//
//        add.isPopupDisplayed();
//        System.out.println("success message and close  displayed");
//
//        add.popup_close();
//        System.out.println("Pop-up closed");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        


        add.cancel_visit();
    	 login=new Loginpage(driver);
         login.prflClick();
         login.profile_logout();
    }


    @Test(priority = 2)
    public void testAddVisitAssociate() {
    	loginAs("associate");
    	
    	asso = new AddVisitAssociate(driver);
        asso.addvisit_displayed();
        System.out.println("Add visit button is displayed");

        asso.add_visit();
        System.out.println("Add visit button is clickable");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        asso.select_inst();
        asso.select_emp();
        asso.date_time();
        System.out.println("Date selected");
        asso.purpose();
        System.out.println("purpose selected");

        asso.contactPerson();
        System.out.println("contactperson selected");

        asso.addNote();
        System.out.println("note added");

        asso.dis_topic();
        System.out.println("topic selected");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        
     // Upload File
        add.upload_file("C:\\Users\\admin\\Desktop");
        
        System.out.println("✅ File uploaded successfully: ");
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        asso.cancel_visit();
    	login=new Loginpage(driver);
    	login.associateClick();
        login.profile_logout();
    }
}
