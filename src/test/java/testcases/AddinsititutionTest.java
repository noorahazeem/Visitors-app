package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Basetest;
import pages.Addinstitution;
import pages.Loginpage;

public class AddinsititutionTest extends Basetest {
    Addinstitution institution;
    Loginpage login;

    @Test(priority = 1)
    public void addInstitutionAsManager() {
        addInstitutionAsRole("manager");
    }

    @Test(priority = 2)
    public void addInstitutionAsAssociate() {
        addInstitutionAsRole("associate");
    }

    // Reusable method for both roles
    public void addInstitutionAsRole(String role)  {
        loginAs(role);  // Login using common method
        
        institution = new Addinstitution(driver);
        
        //open the form
        institution.btnAddInst();
        // Fill the form
        institution.inst_type();
        institution.select_type(role);
        institution.inst_name();
        institution.inst_mail();
        institution.inst_place();
        institution.inst_state();
        institution.inst_dist();
        institution.inst_submit();
        institution.isDisplayed();
        institution.popupclose();
        
        

        // Verify logout based on role
        login = new Loginpage(driver);
        if (role.equals("manager")) {
            login.prflClick();
        } else {
            login.associateClick();
        }
        login.profile_logout();
    }
}
