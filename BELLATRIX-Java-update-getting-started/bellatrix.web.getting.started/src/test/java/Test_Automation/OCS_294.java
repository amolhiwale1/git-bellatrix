package Test_Automation;

import org.testng.annotations.Test;

public class OCS_294 extends OCS_Main {
    String table_name = "x_nuvo_eam_unmatched_devices";
    String connectionType = "Wireless - IEEE 802.11";
    String ip = randomip();
    String ipUpdated = randomip();
    String mac = randomMacId();
    String macUpdated = randomMacId();
    String serialNo = randomSerial();
    String serialNoUpdated = randomSerial();
    String thirdPartyId = randomHostName();

    @Test
    public void test() {
        String[] partners = new String[]{"cyberMDX"};
        // "medigate", "ordr", "paloAlto", "asimily", "cynerio", "armis", "medsec", "cyberMDX"
        //"ordr", "medigate", "paloAlto", "asimily", "cynerio", "armis", "medsec", "cyberMDX"

        for (String partner : partners) {
            String payLoad = discoveryPartnerAllNew(partner, table_name,
                    connectionType, ip, mac, serialNo, thirdPartyId);
            restApiExplorer(payLoad);

//            String payLoadIp = discoveryPartnerAllNew(partner, table_name,
//                    connectionType, ipUpdated, mac, serialNo, thirdPartyId);
//            restApiExplorer(payLoadIp);
//
//            String payLoadMac = discoveryPartnerAllNew(partner, table_name,
//                    connectionType, ipUpdated, macUpdated, serialNo, thirdPartyId);
//            restApiExplorer(payLoadMac);
//
//            String payLoadUP = discoveryPartnerAllNew(partner, table_name,
//                    connectionType, ipUpdated, macUpdated, serialNoUpdated, thirdPartyId);
//            restApiExplorer(payLoadUP);


        }


    }

}
