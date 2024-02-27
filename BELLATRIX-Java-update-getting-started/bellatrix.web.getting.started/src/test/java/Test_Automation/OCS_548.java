package Test_Automation;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class OCS_548 extends OCS_Main{

    @BeforeMethod
    public void beforeMethod() {
        goTo("ven04040");
        login();
    }

    @Test
    public void networkAdapter_OCS_T548() throws IOException, InterruptedException {

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

        leftNavigationTable("x_nuvo_cs_discovery_queue_action_script.list");
        iFrame();
        searchListForNumericValue("Order", "100");


        String[] partners = {"ordr"};
        // , , "paloAlto", "cyberMDX", "cynerio", "medigate", "armis", "medsec", "cyberMDX", "medigate"

        for (String partner : partners) {
            String payLoad = discoveryPartner(partner, table_name, connectionType, model, ip, mac);
            String QueueRecord = createRequest("Discovery", payLoad);

            leftNavigationTable("x_nuvo_cs_discovery_queue.list");
            iFrame();
            searchInList("Number", QueueRecord);
            reloadFor("label.x_nuvo_cs_discovery_queue.state", "complete");
            String tapPartner = partner + " - Create Device";
            Assert.assertEquals(getFieldValue("action_script").toLowerCase(), tapPartner.toLowerCase());
//            Assert.assertEquals(getFieldValue("Target"), getFieldValue("Target").contains("Unmatched Devices"));

            openDevice();
            closeMessage();

            clickFormButton("Convert to Clinical");
            clickFormButton("Save");

            // STEP 8 Go to Network Adapter tab
            selectRelatedList("Network Adapters");
            System.out.println("Req-1 Completed Successfully for " + partner);

        }

    }
}
