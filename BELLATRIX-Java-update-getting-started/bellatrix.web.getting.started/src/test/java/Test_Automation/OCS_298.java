package Test_Automation;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class OCS_298 extends OCS_Main{

    String table_name = "x_nuvo_eam_clinical_devices";
    String model = "Wireless - IEEE 802.11";
    String connectionType = "Wireless - IEEE 802.11";
    String ip = randomip();
    String mac = randomMacId();
    @BeforeMethod
    public void beforeMethod() {
        goTo("ven04040");
        login();
    }

    @Test
    public void updateNetworkAdaptors() throws IOException, InterruptedException {

        //STEP 1 Impersonate as a user with system admin role
        polarisImpersonateUser("OT CS Security Analyst");

        //STEP 2 "Navigate to System Definition > Tables and search for the name
        //x_nuvo_eam_ip_address"
        app().browser().waitUntilPageLoadsCompletely();
        leftNavigationTable("x_nuvo_eam_ip_address.list");
        app().browser().waitUntilPageLoadsCompletely();
        iFrame();

        //STEP 3 Click on the table name and view the adapter_type column record
        searchRecord(1);
//        validateOptionsForAdaptorType();

        //STEP 4 Impersonate as Clinical asset user and navigate to Clinical Asset
        //Management > Devices > Open any existing device's network adapter record
        //and perform the following validations
        polarisImpersonateUser("Clinical Asset User");
        leftNavigationTable("x_nuvo_eam_clinical_devices.list");
        app().browser().waitUntilPageLoadsCompletely();
        iFrame();
        adaptorsTypeConditions();

        //STEP 5 Go to the postman collection for createDiscovery API for Ordr and send the
        //request for a new unmatched device by providing a unique mac address and ip
        //address and a unique device id
        String partner = "ordr";
        String payLoad = discoveryPartner(partner, table_name, connectionType, model, ip, mac);
        String jsonString= restApiExplorer(payLoad);
        String QueueRecord = extractQue(jsonString);

        //STEP 6 Impersonate as a user with Security admin role
        polarisImpersonateUser("OT CS Security Analyst");

        //STEP 7 Go to OT Cyber Security > Queue Management > Discovery Queue
        openDiscoveryQueue();
        iFrame();

        //STEP 8 Go to the newly created queue record
        searchInList("Number", QueueRecord);

        //STEP 9 Navigate to the Queue Parameters tab
        validateQueueParameter("macAddress",mac);
        validateQueueParameter("ipAddress",ip);

        //STEP 10 TO 12 OPEN DEVICE
        reloadFor("label.x_nuvo_cs_discovery_queue.state", "complete");
        openDevice();

        //STEP 13 "Click on Convert to Clinical or Convert to Lab or Convert to Facilities
        //button and view the device form by impersonating as the respective EAM
        //admin"
        clickFormButton("Convert to Clinical");
        clickFormButton("Save");
        polarisImpersonateUser("EAM Admin");
        searchInList("Number", QueueRecord);
        openDevice();

        //STEP 14 View the Network Adapters related list section
        selectRelatedList("Network Adapters");

        gotoRelatedListRowRecord("Network Adapters", 1);

        //STEP 15 "Send in discovery payloads with below combinations of values and view the
        //network adapter record after it's converted into a clinical/lab/facilities
        //device by impersonating as respective EAM admin
        //1. No MAC address but with unique IP Address only for an unmatched table
        String ip1 = randomip();
        String payLoadNoMAC = discoveryPartner(partner, table_name, connectionType, model, ip1, "");
        String jsonStringNoMAC= restApiExplorer(payLoadNoMAC);
        String QueueRecordNoMAC = extractQue(jsonStringNoMAC);

        openDiscoveryQueue();
        iFrame();
        searchInList("Number", QueueRecordNoMAC);
        reloadFor("label.x_nuvo_cs_discovery_queue.state", "complete");
        openDevice();
        clickFormButton("Convert to Clinical");
        clickFormButton("Save");
        selectRelatedList("Network Adapters");
        gotoRelatedListRowRecord("Network Adapters", 1);
        Assert.assertEquals(verifyFieldValue("MAC Address"),"");


        //2. No IP Address but with unique MAC address only for an unmatched table
        String mac2 = randomMacId();
        String payLoadNoIP = discoveryPartner(partner, table_name, connectionType, model, "", mac2);
        String jsonStringNoIP = restApiExplorer(payLoadNoIP);
        String QueueRecordNoIP  = extractQue(jsonStringNoIP);

        openDiscoveryQueue();
        iFrame();
        searchInList("Number", QueueRecordNoIP);
        reloadFor("label.x_nuvo_cs_discovery_queue.state", "complete");
        openDevice();
        clickFormButton("Convert to Clinical");
        clickFormButton("Save");
        selectRelatedList("Network Adapters");
        gotoRelatedListRowRecord("Network Adapters", 1);
        Assert.assertEquals(verifyFieldValue("IP Address"),"");


        //3. Both IP and MAC addresses blank for unmatched table"
        String payLoadNoIPMAC = discoveryPartner(partner, table_name, connectionType, model, "", "");
        String jsonStringNoIPMAC = restApiExplorer(payLoadNoIPMAC);
        String QueueRecordNoIPMAC  = extractQue(jsonStringNoIPMAC);

        openDiscoveryQueue();
        iFrame();
        searchInList("Number", QueueRecordNoIPMAC);
        reloadFor("label.x_nuvo_cs_discovery_queue.state", "complete");
        openDevice();
        clickFormButton("Convert to Clinical");
        clickFormButton("Save");
        selectRelatedList("Network Adapters");
        gotoRelatedListRowRecord("Network Adapters", 1);

        //STEP 16 "Impersonate an EAM Admin and go to Clinical Asset Management > Devices and
        //search for the above device using the MAC Addresses and click on New button
        //in the Network Adapters related list  "
        polarisImpersonateUser("EAM Admin");
        openDiscoveryQueue();
        iFrame();
        searchInList("Number", QueueRecord);
        openDevice();
        selectRelatedList("Network Adapters");
        clickRelatedListButton("Network Adapters", "New");
        setFieldValue("MAC Address", mac2);
        clickFormButton("Submit");
        gotoRelatedListRowRecord("Network Adapters", 2);

        //STEP 17 View the Technical Information section.
        selectSectionTab("Technical Information");
        verifySectionTabValue("MAC Addresses",mac2,mac2);

        //STEP 18 "Add a new network adapter record with the existing MAC addresses of the
        //device and view the Technical Information section and the Network adapter
        //related list"
        searchInList("Number", QueueRecordNoIP);
        openDevice();
        selectRelatedList("Network Adapters");
        clickRelatedListButton("Network Adapters", "New");
        setFieldValue("MAC Address", mac2);
        clickFormButton("Submit");
        selectSectionTab("Technical Information");
        verifySectionTabValue("MAC Addresses",mac2);

        //STEP 19


    }

}
