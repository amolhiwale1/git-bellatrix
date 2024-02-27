package Test_Automation;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class OCS_564 extends OCS_Main {

    String table_name = "x_nuvo_eam_clinical_devices";
    String connectionType = "Wireless - IEEE 802.11";
    String ip = randomip();
    String ipUpdated = randomip();
    String mac = randomMacId();
    String macUpdated = randomMacId();
    String serialNo = randomSerial();
    String serialNoUpdated = randomSerial();
    String thirdPartyId = randomHostName();
    String thirdPartyIdUpdated = randomHostName();

    @BeforeMethod
    public void beforeMethod() {
        goTo("ven04040");
        login();
    }

    @Test
    public void noMatchIdentification() throws IOException, InterruptedException {

        //STEP 1 AND 2 "the discovery payload for asimily for clinical table for no match data
        //, use unique identifier value in the payload, for example- ip/mac/third
        //party/serial number/hostname"
        String asimilyPayLoad = discoveryAsimily(table_name, connectionType, ip, mac, serialNo);
        String jsonString = restApiExplorer(asimilyPayLoad);
        String QueueRecord = extractQue(jsonString);

        //STEP 3 Navigate to Discovery queue and open the above record
        openDiscoveryQueue();
        iFrame();
        searchInList("Number", QueueRecord);
        //validations
        reloadFor("label.x_nuvo_cs_discovery_queue.state", "complete");
        validateSelectedTable("Unmatched Devices [x_nuvo_eam_unmatched_devices]");
        validateDropdownSelectedValue("state", "complete");
        validateDropdownSelectedValue("identification_state", "no_match");
        Assert.assertTrue(getFieldValue("Target").contains("Unmatched Devices"));
        Assert.assertTrue(getFieldValue("action_script").contains("Create Device"));

        //STEP 4 Open the target device
        openDevice();
        //validation
        validateVisibleTable().validateIsVisible();

        //STEP 5 "Send the discovery payload for any other partner than asimily for
        //facilities or lab table using the same data provided above for
        //identification"
        String paloAltoPayload = discoveryPaloAlto(table_name, ipUpdated, macUpdated, serialNoUpdated, thirdPartyIdUpdated);
        String paloAltoQueueRecord = extractQue(restApiExplorer(paloAltoPayload));

        //STEP 6 and 7 Navigate to Discovery queue and open the above record
        openDiscoveryQueue();
        iFrame();
        searchInList("Number", paloAltoQueueRecord);
        reloadFor("label.x_nuvo_cs_discovery_queue.state", "complete");
        validateSelectedTable("Unmatched Devices [x_nuvo_eam_unmatched_devices]");
        validateDropdownSelectedValue("state", "complete");
        validateDropdownSelectedValue("identification_state", "no_match");
        Assert.assertTrue(getFieldValue("Target").contains("Unmatched Devices"));
        Assert.assertTrue(getFieldValue("action_script").contains("Create Device"));
        openDevice();
        //validation
        validateVisibleTable().validateIsVisible();

    }
}
