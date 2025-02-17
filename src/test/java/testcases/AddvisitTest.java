package testcases;

import java.time.Duration;
import org.testng.annotations.Test;
import base.Basetest;
import pages.AddVisitAssociate;
import pages.AddvisitManager;
import pages.ContactPerson;
import pages.Loginpage;

public class AddvisitTest extends Basetest {
    AddvisitManager add;
    AddVisitAssociate asso;
    Loginpage login;
    ContactPerson cont;

    // Reusable method for both Manager & Associate
    private void performAddVisitActions(String role) {
        loginAs(role);

        if (role.equalsIgnoreCase("manager")) {
            add = new AddvisitManager(driver);
            add.addvisit_displayed();
            add.add_visit();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            add.select_inst();
            add.select_emp();
            add.date_time();
            add.purpose();
            add.contactPerson();
            
            //add contact person
            cont=new ContactPerson(driver);
            cont.addPerson();
            cont.form();
            cont.cancel();
            add.addNote();
            add.dis_topic();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Upload File
            add.upload_file("C:\\Users\\admin\\Desktop\\testfile.pdf");
            System.out.println("File uploaded successfully.");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            add.cancel_visit();
        } else if (role.equalsIgnoreCase("associate")) {
            asso = new AddVisitAssociate(driver);
            asso.addvisit_displayed();
            asso.add_visit();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            asso.select_inst();
            
            asso.select_emp();
            asso.date_time();
            asso.purpose();
            asso.contactPerson();
            asso.addNote();
            asso.dis_topic();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Upload File
            asso.upload_file("F:\\Software Testing\\Final Project\\Visitors-app\\src\\test\\resources\\Addvisit with Submit.pdf");
            System.out.println("File uploaded successfully.");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            asso.cancel_visit();
        }

        // Logout
        login = new Loginpage(driver);
        if (role.equalsIgnoreCase("manager")) {
            login.prflClick();
        } else {
            login.associateClick();
        }
        login.profile_logout();
        System.out.println(role + " completed Add Visit actions successfully.");
    }

    @Test(priority = 1)
    public void testAddVisitManager() {
        performAddVisitActions("manager");  // Manager actions
    }

    @Test(priority = 2)
    public void testAddVisitAssociate() {
        performAddVisitActions("associate");  // Associate actions
    }
}
