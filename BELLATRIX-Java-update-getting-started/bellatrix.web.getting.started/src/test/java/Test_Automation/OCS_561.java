package Test_Automation;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class OCS_561 extends OCS_Main {


    String medigateSerialNumber = randomSerial();
    String ordrSerialNo = randomSerial();
    String paloAltoSerialNo = randomSerial();
    String asimilySerialNo = randomSerial();
    String cynerioSerialNo = randomSerial();
    String armisSerialNo = randomSerial();
    String medsecSerialNo = randomSerial();
    String cyberMDXSerialNo = randomSerial();


    String medigateThirdParty = randomHostName();
    String ordrThirdParty = randomHostName();
    String paloAltoThirdParty = randomHostName();
    String cynerioThirdParty = randomHostName();
    String armisThirdParty = randomHostName();
    String medsecThirdParty = randomHostName();
    String cyberMDXThirdParty = randomHostName();

    String table_name = "x_nuvo_eam_clinical_devices";
    String connectionType = "Wireless - IEEE 802.11";


    String medigateIp = randomip();
    String ordrIp = randomip();
    String paloAltoIp = randomip();
    String asimilyIp = randomip();
    String cynerioIp = randomip();
    String armisIp = randomip();
    String medsecIp = randomip();
    String cyberMDXIp = randomip();

    String medigateIpUpdated = randomip();
    String ordrIpUpdated = randomip();
    String paloAltoIpUpdated = randomip();
    String asimilyIpUpdated = randomip();
    String cynerioIpUpdated = randomip();
    String armisIpUpdated = randomip();
    String medsecIpUpdated = randomip();
    String cyberMDXIpUpdated = randomip();

    // "medigate", "ordr", "paloAlto", "asimily", "cynerio", "armis", "medsec", "cyberMDX"

    String medigateMac = randomMacId();
    String ordrMac = randomMacId();
    String paloAltoMac = randomMacId();
    String asimilyMac = randomMacId();
    String cynerioMac = randomMacId();
    String armisMac = randomMacId();
    String medsecMac = randomMacId();
    String cyberMDXMac = randomMacId();

    @BeforeMethod
    public void beforeMethod() {
        goTo("ven04040");
        login();
    }
    void medigate(String ip) throws IOException {
        openDiscoveryQueue();
        //1. Medigate
        String medigatePayload = discoveryMedigate(OCS_Main.table_name, connectionType, ip, medigateMac, medigateSerialNumber, medigateThirdParty);
        String medigateQueueRecord = extractQue(restApiExplorer(medigatePayload));

        iFrame();
        searchInList("Number", medigateQueueRecord);
    }

    @Test()
    public void identificationOperationMedigate() throws IOException {
        medigate(medigateIp);
        validateQueueParameter("mac_addresses", medigateMac);
        validateQueueParameter("ip_addresses", medigateIp);
        validateQueueParameter("third_party_id", medigateThirdParty);
        validateQueueParameter("serial", medigateSerialNumber);

        medigate(medigateIpUpdated);
        validateQueueParameter("mac_addresses", medigateMac);
        validateQueueParameter("ip_addresses", medigateIpUpdated);
        validateQueueParameter("third_party_id", medigateThirdParty);
        validateQueueParameter("serial", medigateSerialNumber);
        reloadFor("identification_state", "identified");
    }

   void ordr(String ip) throws IOException {
       openDiscoveryQueue();
       //2. "ordr"
       String ordrPayload = discoveryOrdr(table_name, ip, ordrMac, ordrSerialNo, ordrThirdParty);
       String ordrQueueRecord = extractQue(restApiExplorer(ordrPayload));


       iFrame();
       searchInList("Number", ordrQueueRecord);
    }
    @Test
    public void identificationOperationOrdr() throws IOException {
        ordr(ordrIp);
        validateQueueParameter("macAddress", ordrMac);
        validateQueueParameter("ipAddress", ordrIp);
        validateQueueParameter("third_party_id", ordrThirdParty);
        validateQueueParameter("serialNumber", ordrSerialNo);

        ordr(ordrIpUpdated);
        validateQueueParameter("macAddress", ordrMac);
        validateQueueParameter("ipAddress", ordrIpUpdated);
        validateQueueParameter("third_party_id", ordrThirdParty);
        validateQueueParameter("serialNumber", ordrSerialNo);
        reloadFor("identification_state", "identified");
    }

    void paloAlto(String ip) throws IOException {
        openDiscoveryQueue();
        //3. "paloAlto"
        String paloAltoPayload = discoveryPaloAlto(table_name, ip,
                paloAltoMac, paloAltoSerialNo, paloAltoThirdParty);
        String paloAltoQueueRecord = extractQue(restApiExplorer(paloAltoPayload));
        iFrame();
        searchInList("Number", paloAltoQueueRecord);
    }
    @Test
    public void identificationOperationPaloAlto() throws IOException {
        paloAlto(paloAltoIp);
        validateQueueParameter("mac_address", paloAltoMac);
        validateQueueParameter("ip", paloAltoIp);
        validateQueueParameter("third_party_id", paloAltoThirdParty);
        validateQueueParameter("Serial Number", paloAltoSerialNo);

        paloAlto(paloAltoIpUpdated);
        validateQueueParameter("mac_address", paloAltoMac);
        validateQueueParameter("ip", paloAltoIpUpdated);
        validateQueueParameter("third_party_id", paloAltoThirdParty);
        validateQueueParameter("Serial Number", paloAltoSerialNo);
        reloadFor("identification_state", "identified");
    }

    void asimily(String ip) throws IOException {
        openDiscoveryQueue();
        //4. "asimily"
        String asimilyPayload = discoveryAsimily(table_name, connectionType,
                ip, asimilyMac, asimilySerialNo);
        String asimilyQueueRecord = extractQue(restApiExplorer(asimilyPayload));

        iFrame();
        searchInList("Number", asimilyQueueRecord);
    }
    @Test
    public void identificationOperationAsimily() throws IOException {
        asimily(asimilyIp);
        validateQueueParameter("mac_address", asimilyMac);
        validateQueueParameter("ip_address", asimilyIp);
        validateQueueParameter("serial_number", asimilySerialNo);

        asimily(asimilyIpUpdated);
        validateQueueParameter("mac_address", asimilyMac);
        validateQueueParameter("ip_address", asimilyIpUpdated);
        validateQueueParameter("serial_number", asimilySerialNo);
        reloadFor("identification_state", "identified");
    }

    void cynerio(String ip) throws IOException {
        openDiscoveryQueue();
        //5. "cynerio"
        String cynerioPayload = discoveryCynerio(table_name, connectionType, ip,
                cynerioMac, cynerioSerialNo, cynerioThirdParty);
        String cynerioQueueRecord = extractQue(restApiExplorer(cynerioPayload));

        iFrame();
        searchInList("Number", cynerioQueueRecord);
    }
    @Test
    public void identificationOperationCynerio() throws IOException {
        cynerio(cynerioIp);
        validateQueueParameter("mac", cynerioMac);
        validateQueueParameter("ip", cynerioIp);
        validateQueueParameter("third_party_id", cynerioThirdParty);
        validateQueueParameter("serial_number", cynerioSerialNo);

        cynerio(cynerioIpUpdated);
        validateQueueParameter("mac", cynerioMac);
        validateQueueParameter("ip", cynerioIpUpdated);
        validateQueueParameter("third_party_id", cynerioThirdParty);
        validateQueueParameter("serial_number", cynerioSerialNo);
        reloadFor("identification_state", "identified");
    }

    void armis(String ip) throws IOException {
        openDiscoveryQueue();
        //6. "armis"
        String armisPayload = discoveryArmis(table_name, ip,
                armisMac, armisSerialNo, armisThirdParty);
        String armisQueueRecord = extractQue(restApiExplorer(armisPayload));
        iFrame();
        searchInList("Number", armisQueueRecord);
    }


    public void identificationOperationArmis() throws IOException {
        armis(armisIp);
        validateQueueParameter("macAddress", armisMac);
        validateQueueParameter("ipAddress", armisIp);
        validateQueueParameter("third_party_id", armisThirdParty);
        validateQueueParameter("serialNumber", armisSerialNo);

        armis(armisIpUpdated);
        validateQueueParameter("macAddress", armisMac);
        validateQueueParameter("ipAddress", armisIpUpdated);
        validateQueueParameter("third_party_id", armisThirdParty);
        validateQueueParameter("serialNumber", armisSerialNo);
        reloadFor("identification_state", "identified");
    }

    void medsec(String ip) throws IOException {
        openDiscoveryQueue();
        //7. "medsec"
        String medsecPayload = discoveryMedsec(table_name, ip,
                medsecMac, medsecSerialNo, medsecThirdParty);
        String medsecQueueRecord = extractQue(restApiExplorer(medsecPayload));
        iFrame();
        searchInList("Number", medsecQueueRecord);
    }
    @Test
    public void identificationOperationMedsec() throws IOException {
        medsec(medsecIp);
        validateQueueParameter("mac", medsecMac);
        validateQueueParameter("ip", medsecIp);
        validateQueueParameter("third_party_id", medsecThirdParty);
        validateQueueParameter("serial_number", medsecSerialNo);

        medsec(medsecIpUpdated);
        validateQueueParameter("mac", medsecMac);
        validateQueueParameter("ip", medsecIpUpdated);
        validateQueueParameter("third_party_id", medsecThirdParty);
        validateQueueParameter("serial_number", medsecSerialNo);
        reloadFor("identification_state", "identified");
    }

    void cyberMDX(String ip) throws IOException {
        openDiscoveryQueue();
        //8. "cyberMDX"
        String cyberMDXPayload = discoveryCyberMDX(table_name, connectionType, ip,
                cyberMDXMac, cyberMDXSerialNo, cyberMDXThirdParty);
        String cyberMDXQueueRecord = extractQue(restApiExplorer(cyberMDXPayload));
        iFrame();
        searchInList("Number", cyberMDXQueueRecord);
    }

    @Test
    public void identificationOperationCyberMDX() throws IOException {
        cyberMDX(cyberMDXIp);
        validateQueueParameter("mac", cyberMDXMac);
        validateQueueParameter("ip", cyberMDXIp);
        validateQueueParameter("third_party_id", cyberMDXThirdParty);
        validateQueueParameter("serial_number", cyberMDXSerialNo);

        cyberMDX(cyberMDXIpUpdated);
        validateQueueParameter("mac", cyberMDXMac);
        validateQueueParameter("ip", cyberMDXIpUpdated);
        validateQueueParameter("third_party_id", cyberMDXThirdParty);
        validateQueueParameter("serial_number", cyberMDXSerialNo);
        reloadFor("identification_state", "identified");
    }


}






