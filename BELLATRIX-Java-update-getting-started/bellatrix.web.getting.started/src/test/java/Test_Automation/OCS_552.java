package Test_Automation;

import org.testng.annotations.BeforeMethod;

public class OCS_552 extends OCS_Main{

    @BeforeMethod
    public void beforeMethod() {
        goTo("ven04040");
        login();
    }

    public void assetVulneralibities(){

        //STEP 1 Impersonate a user as a Security Admin/Security Analyst
        polarisImpersonateUser("OT CS Security Analyst");

        //STEP 2 Navigate to OT Security->Security Events->New
        app().browser().waitUntilPageLoadsCompletely();
        app().browser().waitForAjax();
        leftNavigationTable("x_nuvo_cs_security_events.list");
        iFrame();
        clickFormButton("New");

        //STEP 3 Fill the required fields and add some data to the Asset Table / Asset Condition filters to a Affected Device and Click on Save button
        setFieldValue("Name", "securityEvent");

        clickFormButton("Save");
        app().browser().waitUntilPageLoadsCompletely();
        app().browser().waitForAjax();

        //STEP 4 Click on UI Action button (Add to Affected Assets) to add device to Affected Assets tab
        clickFormButton("Add to Affected Assets");

        //STEP 5 Scroll down to Affected Assets and click on Affected Asset tab
        selectRelatedList("Affected Assets");

        //STEP 6 Select the Checkbox to select the device and Click on Action to selected row drop to select option to "Create Asset Vulnerabilities"
        selectFirstRelatedRecord();
        actionsOnSelectedRow("Create Asset Vulnerability");

        //STEP 7 Go to Asset Vulnerability tab
        selectRelatedList("Asset Vulnerabilities");



    }
}
