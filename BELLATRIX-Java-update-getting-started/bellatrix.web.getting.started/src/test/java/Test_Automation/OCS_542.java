//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Test_Automation;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OCS_542 extends MapPolaris {

    @BeforeMethod
    public void beforeMethod() {
        goTo("ven02303");
        login();
    }

    public void securityEvent() {
        polarisLeftMenuNavigation("Security Events", "OT Security");
        iFrame();
        clickFormButton("New");
        setFieldValue("Name", "securityEvent");
        clickFormButton("Save");
        app().browser().waitUntilPageLoadsCompletely();
        app().browser().waitForAjax();
        hasReletedList("Affected Assets");
        hasReletedList("Asset Vulnerabilities");
        hasReletedList("Related Work Orders");
        hasReletedList("Vulnerabilities");
        selectRelatedListVulnerabilities();
//        hasRelatedListButton("Vulnerabilities", "New Third Party Vulnerability");
//        hasRelatedListButton("Vulnerabilities", "Edit...");
//        clickRelatedListButton("Vulnerabilities", "Edit...");

//        setFieldValue("ID", "123");
//        clickFormButton("Submit");
    }

    @Test
    public void OCS542() {
//        securityEvent();

        polarisImpersonateUser("OT CS Security Analyst");
        securityEvent();
    }
}
