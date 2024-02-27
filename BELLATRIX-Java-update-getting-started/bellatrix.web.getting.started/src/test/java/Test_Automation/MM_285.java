package Test_Automation;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MM_285 extends OCS_Main{

    @BeforeMethod
    public void beforeMethod() {
        goTo("ven04040");
        login();
    }

    @Test
    public void identificationRule() throws InterruptedException {

        //STEP 1 AND 2 "Navigate to OT Cyber Security-> Identification -> Identification and search
        //by Medigate Data Source"
//        app().browser().waitUntilPageLoadsCompletely();
//        polarisImpersonateUser("OT CS Security Analyst");
//        app().browser().waitUntilPageLoadsCompletely();
//        app().browser().waitForAjax();
//        Thread.sleep(2000);
        leftNavigationTable("x_nuvo_eam_identification.list");
        app().browser().waitUntilPageLoadsCompletely();
        iFrame();

        searchList("Data source", "Medigate");
        Assert.assertTrue(getIdentificationValueForMedigate("Clinical Devices [x_nuvo_eam_clinical_devices]"));
        Assert.assertTrue(getIdentificationValueForMedigate("Unmatched Devices [x_nuvo_eam_unmatched_devices]"));
        Assert.assertTrue(getIdentificationValueForMedigate("Facilities Devices [x_nuvo_eam_facilities_devices]"));
        Assert.assertTrue(getIdentificationValueForMedigate("GAM Devices [x_nuvo_eam_lab_devices]"));

        //STEP 3 and 4 "Navigate to OT Cyber Security-> Identification -> Identification Rules and
        //search by Medigate Datasource"
        leftNavigationTable("x_nuvo_eam_identification_rules.list");
        app().browser().waitUntilPageLoadsCompletely();
        iFrame();

        searchInList("Name", "Medigate - MAC Address Match Rule");
        Assert.assertEquals(getOrderValue(), "100");
        Assert.assertTrue(identificationRulesForIs("mac_address"));
        backButton();

        searchInList("Name", "Medigate - Third Party ID Match Rule");
        Assert.assertEquals(getOrderValue(), "200");
        Assert.assertTrue(identificationRulesForIs("third_party_id"));
        backButton();

        searchInList("Name", "Medigate - Serial Number Match Rule");
        Assert.assertEquals(getOrderValue(), "300");
        Assert.assertTrue(identificationRulesForIs("serial_number"));
        backButton();

        //STEP 5 AND 6 "Navigate to OT Cyber Security > Administration > Key Field Mapping and
        //search for Medigate data source"
        leftNavigationTable("x_nuvo_eam_key_field_mapping.list");
        app().browser().waitUntilPageLoadsCompletely();
        iFrame();
        searchList("Data Source", "Medigate");
        Assert.assertEquals(getRowCount(), 104);

    }

}
