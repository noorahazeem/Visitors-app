package testcases;

import java.time.Duration;
import org.testng.annotations.Test;
import base.Basetest;
import pages.AddvisitManager;
import pages.ContactPerson;
import pages.Loginpage;

public class ContactPersonTest extends Basetest {
    ContactPerson cont;
    AddvisitManager add;
    Loginpage login;

    // Reusable method for both Manager & Associate
    private void performAddContactActions(String role) {
        loginAs(role);
        
        add = new AddvisitManager(driver);
        add.add_visit();
        add.select_inst();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        cont = new ContactPerson(driver);
        cont.addPerson();
        cont.addContactisDisplayed();
        cont.form();
        cont.cancel();
        add.cancel_visit();

        System.out.println(role + " completed Add Contact actions successfully.");
     // Logout
        login = new Loginpage(driver);
        if (role.equalsIgnoreCase("manager")) {
            login.prflClick();
        } else {
            login.associateClick();
        }
        login.profile_logout();
        System.out.println(role + " logged out successfully.");
    }

    @Test(priority = 1)
    public void verifyAddContactManager() {
        performAddContactActions("manager"); // Manager performs actions
    }

    @Test(priority = 2)
    public void verifyAddContactAssociate() {
        performAddContactActions("associate"); // Associate performs actions
    }
}
