//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Test_Automation;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import solutions.bellatrix.web.components.Anchor;
import solutions.bellatrix.web.components.TextInput;

import java.io.IOException;

public class OCS_569 extends OCS_Main {
   

    @BeforeMethod
    public void beforeMethod() {
        goTo("ven02303");
        login();
    }

    @Test
    public void OCS_T569_All_Partner() throws InterruptedException, IOException {
        String app = "Clinical Asset Management";
        String eam = "clinical";
        String table_name = "x_nuvo_eam_clinical_devices";
        String model = "Wireless - IEEE 802.11";
        String ipUpdated = randomip();
        String macUpdated = randomMacId();
        String ip = randomip();
        String mac = randomMacId();
        String serialNoUpdated = randomSerial();
        String hostnameUpdated = randomHostName();
        String connectionType = "Wireless - IEEE 802.11";
        leftNavigationTable("x_nuvo_eam_ip_address.list");
        app().browser().waitUntilPageLoadsCompletely();
        iFrame();
        clickFormButton("New");
        app().browser().waitUntilPageLoadsCompletely();
        String[] partners = new String[]{"ordr"};
        // "medigate", "", "paloAlto", "asimily", "cynerio", "medigate", "armis", "medsec"
        String[] var14 = partners;
        int var13 = partners.length;

        for (String partner : partners) {
            String payLoad = discoveryPartner(partner, table_name, connectionType, model, ip, mac);
            String QueueRecord = createRequest("Discovery", payLoad);
            leftNavigationTable("x_nuvo_cs_discovery_queue.list");
            leftNavigationTable("x_nuvo_cs_discovery_queue.list");
            iFrame();
            searchInList("Number", QueueRecord);
            reloadForComplete();
            openDevice();

            // verify the IP and MAC address
            Assert.assertEquals(getFieldValue("IP Addresses"), ip);
            Assert.assertEquals(getFieldValue("MAC Addresses"), mac);

            // STEP 7 Convert the unmatched device to Clinical, Lab or Facilities (Anything of your choice)
            clickFormButton("Convert to Clinical");
            clickFormButton("Save");

            // STEP 8 Open the network adapter record from the related list at the bottom
            selectRelatedList("Network Adapters");
            gotoRelatedListRowRecord("Network Adapters", 1);






        }

    }
}
