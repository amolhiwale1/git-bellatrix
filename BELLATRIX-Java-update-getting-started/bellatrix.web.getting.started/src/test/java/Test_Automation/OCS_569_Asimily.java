//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Test_Automation;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class OCS_569_Asimily extends OCS_Main {

    String table_name = "x_nuvo_eam_clinical_devices";
    String connectionType = "Wireless - IEEE 802.11";
    String ipUpdated = randomip();
    String macUpdated = randomMacId();
    String ip = randomip();
    String mac = randomMacId();
    String serialNo = randomSerial();
    String serialNoUpdated = randomSerial();

    @BeforeMethod
    public void beforeMethod() {
        goTo("ven04040");
        login();
    }

//    @Test
    public void multipleHostnamesAsimily() throws InterruptedException, IOException {

        //STEP 1 AND 2 Go to left navigator and search for x_nuvo_eam_ip_address.list
        leftNavigationTable("x_nuvo_eam_ip_address.list");
        app().browser().waitUntilPageLoadsCompletely();
        iFrame();

        //STEP 3 Click on the New button
        clickFormButton("New");
        app().browser().waitUntilPageLoadsCompletely();
        verifyField("Hostname");

        openDiscoveryQueue();
        //STEP 4 "Send the discovery queue request for Asimily clinical table for no match condition
        //Provide unique mac address, ip address, serial number, hostname, third
        //party id , etc."
        String asimilyPayLoad = discoveryAsimily(table_name, connectionType, ip, mac, serialNo);
        String jsonString = restApiExplorer(asimilyPayLoad);
        String QueueRecord = extractQue(jsonString);

        //STEP 5 "Navigate to Discovery queue and open the above request and wait till the
        //state changes to complete"

        iFrame();
        searchInList("Number", QueueRecord);
        reloadFor("label.x_nuvo_cs_discovery_queue.state", "complete");

        //STEP 6 Open the target record and go to the technical information tab
        openDevice();
        Assert.assertEquals(getFieldValue("IP Addresses"), ip);
        Assert.assertEquals(getFieldValue("MAC Addresses"), mac);
        Assert.assertEquals(getFieldValue("Serial Number"), serialNo);
        Assert.assertEquals(getFieldValue("Hostname "), "Hostname" + serialNo);


        //STEP 7 "Convert the unmatched device to Clinical, Lab or Facilities (Anything of
        //your choice)"
        clickFormButton("Convert to Clinical");
        clickFormButton("Save");

        // STEP 8 Open the network adapter record from the related list at the bottom
        selectRelatedList("Network Adapters");
        gotoRelatedListRowRecord("Network Adapters", 1);

        Assert.assertEquals(getFieldValue("IP Address"), ip);
        Assert.assertEquals(getFieldValue("MAC Address"), mac);
        Assert.assertEquals(getFieldValue("Hostname"), "Hostname" + serialNo);

        //STEP 9 "Send the same request changing only mac address, hostname and keep the rest
        //other things same as above"
        String asimilyPayLoadNoMac = discoveryAsimily(table_name, connectionType,
                ip, macUpdated, serialNo);
        String QueueRecordNoMac = extractQue(restApiExplorer(asimilyPayLoadNoMac));

        //STEP 10 "Navigate to Discovery queue and open the above request and wait till the
        //state changes to complete"
        openDiscoveryQueue();
        iFrame();
        searchInList("Number", QueueRecordNoMac);
        reloadFor("label.x_nuvo_cs_discovery_queue.state", "complete");

        //STEP 11 Open the target record and go to the technical information tab
        openDevice();
        Assert.assertEquals(getFieldValue("IP Addresses"), ip);
        Assert.assertEquals(getFieldValue("MAC Addresses"), mac + "," + macUpdated);
        Assert.assertEquals(getFieldValue("Serial Number"), serialNo);
        Assert.assertEquals(getFieldValue("Hostname "), "Hostname" + serialNo);

        //STEP 12 "Navigate to network adapters tab in the related list at the bottom and open
        //the new adapter created for the above mac address "
        selectRelatedList("Network Adapters");
        goToRelatedRecordBy("Network Adapters", macUpdated);

        Assert.assertEquals(getFieldValue("IP Address"), ip);
        Assert.assertEquals(getFieldValue("MAC Address"), macUpdated);
        Assert.assertEquals(getFieldValue("Hostname"), "Hostname" + serialNo);

        //STEP 13 "Send the same request, change the ip address and keep the hostname and rest
        //other things same as above"
        String asimilyPayLoadNoIp = discoveryAsimily(table_name, connectionType, ipUpdated, macUpdated, serialNo);
        String QueueRecordNoIp = extractQue(restApiExplorer(asimilyPayLoadNoIp));

        //STEP 14 "Navigate to Discovery queue and open the above request and wait till the
        //state changes to complete"
        openDiscoveryQueue();
        iFrame();
        searchInList("Number", QueueRecordNoIp);
        reloadFor("label.x_nuvo_cs_discovery_queue.state", "complete");

        //STEP 15 Open the target record and go to the technical information tab
        openDevice();
        Assert.assertEquals(getFieldValue("IP Addresses"), ip + "," + ipUpdated);
        Assert.assertEquals(getFieldValue("MAC Addresses"), mac + "," + macUpdated);
        Assert.assertEquals(getFieldValue("Serial Number"), serialNo);
        Assert.assertEquals(getFieldValue("Hostname "), "Hostname" + serialNo);

        //STEP 16 "Navigate to network adapters tab in the related list at the bottom and open
        //the new adapter created for the above ip address"
        selectRelatedList("Network Adapters");
        goToRelatedRecordBy("Network Adapters", macUpdated);

        Assert.assertEquals(getFieldValue("IP Address"), ipUpdated);
        Assert.assertEquals(getFieldValue("MAC Address"), macUpdated);
        Assert.assertEquals(getFieldValue("Hostname"), "Hostname" + serialNo);

        //STEP 17 "Send the same request, change the hostname and serial number and keep rest
        //other things same as above"
        String asimilyPayLoadNoHostSerial = discoveryAsimily(table_name, connectionType, ipUpdated, macUpdated, serialNoUpdated);
        String QueueRecordNoHostSerial = extractQue(restApiExplorer(asimilyPayLoadNoHostSerial));

        //STEP 18 "Navigate to Discovery queue and open the above request and wait till the
        //state changes to complete"
        openDiscoveryQueue();
        iFrame();
        searchInList("Number", QueueRecordNoHostSerial);
        reloadFor("label.x_nuvo_cs_discovery_queue.state", "complete");

        //STEP 19 Open the target record and go to the technical information tab
        openDevice();
        Assert.assertEquals(getFieldValue("IP Addresses"), ip + "," + ipUpdated);
        Assert.assertEquals(getFieldValue("MAC Addresses"), mac + "," + macUpdated);
        Assert.assertEquals(getFieldValue("Serial Number"), serialNoUpdated);
        Assert.assertEquals(getFieldValue("Hostname "), "Hostname" + serialNoUpdated);

        //STEP 20 "Navigate to network adapters tab in the related list at the bottom and open
        //the above adapter "
        selectRelatedList("Network Adapters");
        gotoRelatedListRowRecord("Network Adapters", 1);

        Assert.assertEquals(getFieldValue("IP Address"), ipUpdated);
        Assert.assertEquals(getFieldValue("MAC Address"), macUpdated);
        Assert.assertEquals(getFieldValue("Hostname"), "Hostname" + serialNoUpdated);

        //STEP 21 "Repeat the above steps for the partners containing hostname in the payload
        //across each table,
        //Test for - Armis, Asimily, CyberMDX, Medigate and Palo Alto Networks"


    }

    //    @Test
    public void multipleHostnameArmis() throws InterruptedException, IOException {

        openDiscoveryQueue();
        //STEP 4 "Send the discovery queue request for Asimily clinical table for no match condition
        //Provide unique mac address, ip address, serial number, hostname, third
        //party id , etc."
        String ArmisPayLoad = discoveryArmis(table_name, ip, mac, serialNo, armisThirdParty);
        String jsonString = restApiExplorer(ArmisPayLoad);
        String QueueRecord = extractQue(jsonString);

        //STEP 5 "Navigate to Discovery queue and open the above request and wait till the
        //state changes to complete"
        iFrame();
        searchInList("Number", QueueRecord);
        reloadFor("label.x_nuvo_cs_discovery_queue.state", "complete");

        //STEP 6 Open the target record and go to the technical information tab
        openDevice();
        Assert.assertEquals(getFieldValue("IP Addresses"), ip);
        Assert.assertEquals(getFieldValue("MAC Addresses"), mac);
//        Assert.assertEquals(getFieldValue("Serial Number"), serialNo);
        Assert.assertEquals(getFieldValue("Hostname "), "Hostname" + serialNo);


        //STEP 7 "Convert the unmatched device to Clinical, Lab or Facilities (Anything of
        //your choice)"
        clickFormButton("Convert to Clinical");
        clickFormButton("Save");

        // STEP 8 Open the network adapter record from the related list at the bottom
        selectRelatedList("Network Adapters");
        gotoRelatedListRowRecord("Network Adapters", 1);

        Assert.assertEquals(getFieldValue("IP Address"), ip);
        Assert.assertEquals(getFieldValue("MAC Address"), mac);
        Assert.assertEquals(getFieldValue("Hostname"), "Hostname" + serialNo);

        //STEP 9 "Send the same request changing only mac address, hostname and keep the rest
        //other things same as above"
        String ArmisPayLoadNoMac = discoveryArmis(table_name, ip, macUpdated, serialNo, armisThirdParty);
        String QueueRecordNoMac = extractQue(restApiExplorer(ArmisPayLoadNoMac));

        //STEP 10 "Navigate to Discovery queue and open the above request and wait till the
        //state changes to complete"
        openDiscoveryQueue();
        iFrame();
        searchInList("Number", QueueRecordNoMac);
        reloadFor("label.x_nuvo_cs_discovery_queue.state", "complete");

        //STEP 11 Open the target record and go to the technical information tab
        openDevice();
        Assert.assertEquals(getFieldValue("IP Addresses"), ip);
        Assert.assertEquals(getFieldValue("MAC Addresses"), mac + "," + macUpdated);
//        Assert.assertEquals(getFieldValue("Serial Number"), serialNo);
        Assert.assertEquals(getFieldValue("Hostname "), "Hostname" + serialNo);

        //STEP 12 "Navigate to network adapters tab in the related list at the bottom and open
        //the new adapter created for the above mac address "
        selectRelatedList("Network Adapters");
        goToRelatedRecordBy("Network Adapters", macUpdated);

        Assert.assertEquals(getFieldValue("IP Address"), ip);
        Assert.assertEquals(getFieldValue("MAC Address"), macUpdated);
        Assert.assertEquals(getFieldValue("Hostname"), "Hostname" + serialNo);

        //STEP 13 "Send the same request, change the ip address and keep the hostname and rest
        //other things same as above"
        String ArmisPayLoadNoIp = discoveryArmis(table_name, ipUpdated, macUpdated, serialNo, armisThirdParty);
        String QueueRecordNoIp = extractQue(restApiExplorer(ArmisPayLoadNoIp));

        //STEP 14 "Navigate to Discovery queue and open the above request and wait till the
        //state changes to complete"
        openDiscoveryQueue();
        iFrame();
        searchInList("Number", QueueRecordNoIp);
        reloadFor("label.x_nuvo_cs_discovery_queue.state", "complete");

        //STEP 15 Open the target record and go to the technical information tab
        openDevice();
        Assert.assertEquals(getFieldValue("IP Addresses"), ip + "," + ipUpdated);
        Assert.assertEquals(getFieldValue("MAC Addresses"), mac + "," + macUpdated);
//        Assert.assertEquals(getFieldValue("Serial Number"), serialNo);
        Assert.assertEquals(getFieldValue("Hostname "), "Hostname" + serialNo);

        //STEP 16 "Navigate to network adapters tab in the related list at the bottom and open
        //the new adapter created for the above ip address"
        selectRelatedList("Network Adapters");
        goToRelatedRecordBy("Network Adapters", macUpdated);

        Assert.assertEquals(getFieldValue("IP Address"), ipUpdated);
        Assert.assertEquals(getFieldValue("MAC Address"), macUpdated);
        Assert.assertEquals(getFieldValue("Hostname"), "Hostname" + serialNo);

        //STEP 17 "Send the same request, change the hostname and serial number and keep rest
        //other things same as above"
        String ArmisPayLoadNoHostSerial = discoveryArmis(table_name, ipUpdated, macUpdated, serialNoUpdated, armisThirdParty);
        String QueueRecordNoHostSerial = extractQue(restApiExplorer(ArmisPayLoadNoHostSerial));

        //STEP 18 "Navigate to Discovery queue and open the above request and wait till the
        //state changes to complete"
        openDiscoveryQueue();
        iFrame();
        searchInList("Number", QueueRecordNoHostSerial);
        reloadFor("label.x_nuvo_cs_discovery_queue.state", "complete");

        //STEP 19 Open the target record and go to the technical information tab
        openDevice();
        Assert.assertEquals(getFieldValue("IP Addresses"), ip + "," + ipUpdated);
        Assert.assertEquals(getFieldValue("MAC Addresses"), mac + "," + macUpdated);
//        Assert.assertEquals(getFieldValue("Serial Number"), serialNoUpdated);
        Assert.assertEquals(getFieldValue("Hostname "), "Hostname" + serialNoUpdated);

        //STEP 20 "Navigate to network adapters tab in the related list at the bottom and open
        //the above adapter "
        selectRelatedList("Network Adapters");
        goToRelatedRecordBy("Network Adapters", macUpdated);

        Assert.assertEquals(getFieldValue("IP Address"), ipUpdated);
        Assert.assertEquals(getFieldValue("MAC Address"), macUpdated);
        Assert.assertEquals(getFieldValue("Hostname"), "Hostname" + serialNoUpdated);

    }


    @Test
    public void multipleHostnameCyberMDX() throws InterruptedException, IOException {

        //STEP 4 "Send the discovery queue request for Asimily clinical table for no match condition
        //Provide unique mac address, ip address, serial number, hostname, third
        //party id , etc."
        openDiscoveryQueue();
        String CyberMDXPayLoad = discoveryCyberMDX(table_name, connectionType,
                ip, mac, serialNo, cyberMDXThirdParty);
        String jsonString = restApiExplorer(CyberMDXPayLoad);
        String QueueRecord = extractQue(jsonString);

        //STEP 5 "Navigate to Discovery queue and open the above request and wait till the
        //state changes to complete"

        iFrame();
        searchInList("Number", QueueRecord);
        reloadFor("label.x_nuvo_cs_discovery_queue.state", "complete");

        //STEP 6 Open the target record and go to the technical information tab
        openDevice();
        Assert.assertEquals(getFieldValue("IP Addresses"), ip);
        Assert.assertEquals(getFieldValue("MAC Addresses"), mac);
        Assert.assertEquals(getFieldValue("Serial Number"), serialNo);
        Assert.assertEquals(getFieldValue("Hostname "), "Hostname" + serialNo);


        //STEP 7 "Convert the unmatched device to Clinical, Lab or Facilities (Anything of
        //your choice)"
        clickFormButton("Convert to Clinical");
        clickFormButton("Save");

        // STEP 8 Open the network adapter record from the related list at the bottom
        selectRelatedList("Network Adapters");
        gotoRelatedListRowRecord("Network Adapters", 1);

        Assert.assertEquals(getFieldValue("IP Address"), ip);
        Assert.assertEquals(getFieldValue("MAC Address"), mac);
        Assert.assertEquals(getFieldValue("Hostname"), "Hostname" + serialNo);

        //STEP 9 "Send the same request changing only mac address, hostname and keep the rest
        //other things same as above"
        String CyberMDXPayLoadNoMac = discoveryCyberMDX(table_name, connectionType,
                ip, macUpdated, serialNo, cyberMDXThirdParty);
        String QueueRecordNoMac = extractQue(restApiExplorer(CyberMDXPayLoadNoMac));

        //STEP 10 "Navigate to Discovery queue and open the above request and wait till the
        //state changes to complete"
        openDiscoveryQueue();
        iFrame();
        searchInList("Number", QueueRecordNoMac);
        reloadFor("label.x_nuvo_cs_discovery_queue.state", "complete");

        //STEP 11 Open the target record and go to the technical information tab
        openDevice();
        Assert.assertEquals(getFieldValue("IP Addresses"), ip);
        Assert.assertEquals(getFieldValue("MAC Addresses"), mac + "," + macUpdated);
        Assert.assertEquals(getFieldValue("Serial Number"), serialNo);
        Assert.assertEquals(getFieldValue("Hostname "), "Hostname" + serialNo);

        //STEP 12 "Navigate to network adapters tab in the related list at the bottom and open
        //the new adapter created for the above mac address "
        selectRelatedList("Network Adapters");
        goToRelatedRecordBy("Network Adapters", macUpdated);

        Assert.assertEquals(getFieldValue("IP Address"), ip);
        Assert.assertEquals(getFieldValue("MAC Address"), macUpdated);
        Assert.assertEquals(getFieldValue("Hostname"), "Hostname" + serialNo);

        //STEP 13 "Send the same request, change the ip address and keep the hostname and rest
        //other things same as above"
        String CyberMDXPayLoadNoIp = discoveryCyberMDX(table_name, connectionType,
                ipUpdated, macUpdated, serialNo, cyberMDXThirdParty);
        String QueueRecordNoIp = extractQue(restApiExplorer(CyberMDXPayLoadNoIp));

        //STEP 14 "Navigate to Discovery queue and open the above request and wait till the
        //state changes to complete"
        openDiscoveryQueue();
        iFrame();
        searchInList("Number", QueueRecordNoIp);
        reloadFor("label.x_nuvo_cs_discovery_queue.state", "complete");

        //STEP 15 Open the target record and go to the technical information tab
        openDevice();
        Assert.assertEquals(getFieldValue("IP Addresses"), ip + "," + ipUpdated);
        Assert.assertEquals(getFieldValue("MAC Addresses"), mac + "," + macUpdated);
        Assert.assertEquals(getFieldValue("Serial Number"), serialNo);
        Assert.assertEquals(getFieldValue("Hostname "), "Hostname" + serialNo);

        //STEP 16 "Navigate to network adapters tab in the related list at the bottom and open
        //the new adapter created for the above ip address"
        selectRelatedList("Network Adapters");
        goToRelatedRecordBy("Network Adapters", macUpdated);

        Assert.assertEquals(getFieldValue("IP Address"), ipUpdated);
        Assert.assertEquals(getFieldValue("MAC Address"), macUpdated);
        Assert.assertEquals(getFieldValue("Hostname"), "Hostname" + serialNo);

        //STEP 17 "Send the same request, change the hostname and serial number and keep rest
        //other things same as above"
        String CyberMDXPayLoadNoHostSerial = discoveryCyberMDX(table_name, connectionType,
                ipUpdated, macUpdated, serialNoUpdated, cyberMDXThirdParty);
        String QueueRecordNoHostSerial = extractQue(restApiExplorer(CyberMDXPayLoadNoHostSerial));

        //STEP 18 "Navigate to Discovery queue and open the above request and wait till the
        //state changes to complete"
        openDiscoveryQueue();
        iFrame();
        searchInList("Number", QueueRecordNoHostSerial);
        reloadFor("label.x_nuvo_cs_discovery_queue.state", "complete");

        //STEP 19 Open the target record and go to the technical information tab
        openDevice();
        Assert.assertEquals(getFieldValue("IP Addresses"), ip + "," + ipUpdated);
        Assert.assertEquals(getFieldValue("MAC Addresses"), mac + "," + macUpdated);
        Assert.assertEquals(getFieldValue("Serial Number"), serialNoUpdated);
        Assert.assertEquals(getFieldValue("Hostname "), "Hostname" + serialNoUpdated);

        //STEP 20 "Navigate to network adapters tab in the related list at the bottom and open
        //the above adapter "
        selectRelatedList("Network Adapters");
        goToRelatedRecordBy("Network Adapters", macUpdated);

        Assert.assertEquals(getFieldValue("IP Address"), ipUpdated);
        Assert.assertEquals(getFieldValue("MAC Address"), macUpdated);
        Assert.assertEquals(getFieldValue("Hostname"), "Hostname" + serialNoUpdated);

    }


}
