//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Test_Automation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import solutions.bellatrix.web.components.Anchor;
import solutions.bellatrix.web.components.Option;
import solutions.bellatrix.web.components.Select;
import solutions.bellatrix.web.components.TextInput;

public class OCS_Main extends MapPolaris {

    public static String SerialNumber = randomSerial();
    public static String medigateSerialNumber = randomSerial();
    public static String ordrSerialNo = randomSerial();
    public static String paloAltoSerialNo = randomSerial();
    public static String asimilySerialNo = randomSerial();
    public static String cynerioSerialNo = randomSerial();
    public static String armisSerialNo = randomSerial();
    public static String medsecSerialNo = randomSerial();
    public static String cyberMDXSerialNo = randomSerial();

    public static String ThirdParty = randomHostName();
    public static String medigateThirdParty = randomHostName();
    public static String ordrThirdParty = randomHostName();
    public static String paloAltoThirdParty = randomHostName();
    public static String asimilyThirdParty = randomHostName();
    public static String cynerioThirdParty = randomHostName();
    public static String armisThirdParty = randomHostName();
    public static String medsecThirdParty = randomHostName();
    public static String cyberMDXThirdParty = randomHostName();

    public static String table_name = "x_nuvo_eam_clinical_devices";
    public static String connectionType = "Wireless - IEEE 802.11";

    public static String ip = randomip();
    public static String medigateIp = randomip();
    public static String ordrIp = randomip();
    public static String paloAltoIp = randomip();
    public static String asimilyIp = randomip();
    public static String cynerioIp = randomip();
    public static String armisIp = randomip();
    public static String medsecIp = randomip();
    public static String cyberMDXIp = randomip();

    public static String mac = randomMacId();
    public static String medigateMac = randomMacId();
    public static String ordrMac = randomMacId();
    public static String paloAltoMac = randomMacId();
    public static String asimilyMac = randomMacId();
    public static String cynerioMac = randomMacId();
    public static String armisMac = randomMacId();
    public static String medsecMac = randomMacId();
    public static String cyberMDXMac = randomMacId();

    public String randomString() {
        StringBuilder sb = new StringBuilder();
        String ch = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        for (int i = 0; (double)i < Math.random() * 100.0; ++i) {
            int index = (int)(Math.random() * (double)ch.length());
            sb.append(ch.charAt(index));
        }

        return sb.toString();
    }

    public static String randomSerial() {
        String str = "";
        String ch = "123456789";
        int len = ch.length();

        for (int i = 0; i < 10; ++i) {
            str = str + ch.charAt((int)Math.floor(Math.random() * (double)len));
        }

        return str;
    }

    public static String randomHostName() {
        String str = "";
        String ch = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int len = ch.length();

        for (int i = 0; i < 8; ++i) {
            str = str + ch.charAt((int)Math.floor(Math.random() * (double)len));
        }

        return str;
    }

    public static String randomMacId() {
        String str = "";
        String ch = "abcdef0123456789";
        int len = ch.length();

        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < 2; ++j) {
                str = str + ch.charAt((int)Math.floor(Math.random() * (double)len));
            }

            if (i != 5) {
                str = str + ":";
            }
        }

        return str;
    }

    public static String randomip() {
        StringBuilder ip = new StringBuilder("xx.xx.xx.xx");

        for (int i = 0; i < 11; ++i) {
            if (i != 2 && i != 5 && i != 8) {
                Random r = new Random();
                int random = r.nextInt(9) + 1;
                char c = (char)(random + 48);
                ip.setCharAt(i, c);
            }
        }

        return ip.toString();
    }


    public String discoveryPartner(String partner, String table_name, String connectionType, String model, String ip_1, String mac_1) {
        String deviceId_1;
        String serialNo_1;
        String thirdParty_1;
        String discovery_cynerio;
        String discovery_paloAlto;
        switch (partner) {
            case "medsec":
                deviceId_1 = randomString();
                serialNo_1 = randomSerial();
                thirdParty_1 = randomHostName();
                discovery_cynerio = "{\r\n  \"source_key\": \"abc\",\r\n  \"device_id\": \"" + deviceId_1 + "\",  \r\n  \"table_name\": \"" + table_name + "\",\r\n  \"parameters\": [\r\n    {\r\n      \"mac\": \"" + mac_1 + "\"\r\n    },\r\n    {\r\n      \"third_party_id\": \"" + thirdParty_1 + "\"  \r\n    },\r\n    {\r\n      \"vendor\": \"GE\"\r\n    },\r\n    {\r\n      \"modality\": \"Ultrasound\"\r\n    },\r\n    {\r\n      \"operating_system\": \"Linux\"\r\n    },\r\n    {\r\n      \"software_version\": \"R4.3.0\"\r\n    },\r\n    {\r\n      \"timestamp\": \"1624039466E9\"\r\n    },\r\n    {\r\n      \"ip\": \"" + ip_1 + "\"\r\n    },\r\n    {\r\n      \"old_ip\": \"1.2.3.4\"\r\n    },\r\n    {\r\n      \"serial_number\": \"" + serialNo_1 + "\"\r\n    },\r\n    {\r\n      \"identity\": \"VenueGO\"\r\n    }], \r\n\r\n  \"payload\": \"new_device / missing_device / ip_changed\"\r\n}";
                return discovery_cynerio;
            case "medigate":
                deviceId_1 = randomString();

                serialNo_1 = randomSerial();
                thirdParty_1 = randomHostName();
                discovery_cynerio = randomHostName();
                discovery_paloAlto = "{\r\n  \"source_key\": \"7cb2b1db1be4d810ccdcc91e1e4bcb46\",\r\n    \"device_id\": \"" + deviceId_1 + "\",\r\n    \"table_name\": \"" + table_name + "\",\r\n    \"parameters\": [\r\n        {\r\n            \"device_type\": \"Infusion Pump\"\r\n        },\r\n        {\r\n            \"device_id\": \"" + deviceId_1 + "\"\r\n        },\r\n        {\r\n            \"third_party_id\": \"" + thirdParty_1 + "\"\r\n        },\r\n        {\r\n            \"serial\": \"" + serialNo_1 + "\"\r\n        },\r\n        {\r\n            \"hostname\": \"" + discovery_cynerio + "\"\r\n        },\r\n        {\r\n            \"ip\": \"" + ip_1 + "\"\r\n        },\r\n        {\r\n            \"mac\": \"" + mac_1 + "\"\r\n        },\r\n        {\r\n            \"risk_score\": \"2\"\r\n        },\r\n        {\r\n            \"is_online\": \"TRUE\"\r\n        },\r\n        {\r\n            \"manufacturer\": \"Alaris\"\r\n        },\r\n        {\r\n            \"model\": \"8015 PC Unit\"\r\n        },\r\n        {\r\n            \"category\": \"Medical\"\r\n        },\r\n        {\r\n            \"sub_category\": \"Patient Devices\"\r\n        },\r\n        {\r\n            \"vendor\": \"Philips\"\r\n        },\r\n        {\r\n            \"first_seen\": \"2019-11-18T12:00:18.811418+00:00\"\r\n        },\r\n        {\r\n            \"last_seen\": \"2019-11-22T12:00:12.811418+00:00\"\r\n        },\r\n        {\r\n            \"last_seen_on_switch\": \"2019-11-22T12:00:12.811418+00:00\"\r\n        },\r\n        {\r\n            \"hw_version\": \"23F\"\r\n        },\r\n        {\r\n            \"is_component\": \"false\"\r\n        },\r\n        {\r\n            \"location\": \"PCU\"\r\n        },\r\n        {\r\n            \"os_name\": \"Proprietary\"\r\n        },\r\n        {\r\n            \"os_revision\": \"SP2\"\r\n        },\r\n        {\r\n            \"os_version\": \"Enea OSE\"\r\n        },\r\n        {\r\n            \"parent_id\": \"233132ec-8f7d-4e5f-8dba-60eea66e7bb0\"\r\n        },\r\n        {\r\n            \"protocols\": [\r\n                \"Unity\",\r\n                \"RWHAT\"\r\n            ]\r\n        },\r\n        {\r\n            \"sw_version\": \"32.b\"\r\n        },\r\n        {\r\n            \"connection_type\": \"" + connectionType + "\"\r\n        },\r\n        {\r\n            \"ip_assignment\": \"DHCP\"\r\n        },\r\n        {\r\n            \"vlan\": \"880\"\r\n        },\r\n        {\r\n            \"vlan_name\": \"floor1\"\r\n        },\r\n        {\r\n            \"vlan_desc\": \"Radiology floor 1\"\r\n        },\r\n        {\r\n            \"switch_port\": \"Ge/0/1\"\r\n        },\r\n        {\r\n            \"switch_ip\": \"1.2.3.4\"\r\n        },\r\n        {\r\n            \"switch_name\": \"OfficeSwitch\"\r\n        },\r\n        {\r\n            \"bssid\": \"00:c0:58:70:e4:a0\"\r\n        },\r\n        {\r\n            \"last_seen\": \"2019-11-18T11:28:19.380109+00:00\"\r\n        },\r\n        {\r\n            \"ssid\": \"MEDNET\"\r\n        },\r\n        {\r\n            \"ap_name\": \"CO01080010\"\r\n        },\r\n        {\r\n            \"ap_location\": \"Columbia -> Building 2 -> Floor 9\"\r\n        },\r\n        {\r\n            \"fda_class\": \"1\"\r\n        },\r\n        {\r\n            \"kingdom\": \"Medical\"\r\n        },\r\n        {\r\n            \"phi\": \"Stored & Transmitted\"\r\n        },\r\n        {\r\n            \"equipment_class\": \"Physiological Monitoring\"\r\n        },\r\n        {\r\n            \"consequence_of_failure\": \"Inappropriate Therapy or Misdiagnosis\"\r\n        },\r\n        {\r\n            \"wifi_last_seen\": \"2021-02-23 08:31:00.702468+00:00\"\r\n        }\r\n    ],\r\n    \"payload\": \"\"\r\n}";
                return discovery_paloAlto;
            case "asimily":
                deviceId_1 = randomString();
                serialNo_1 = randomSerial();
                thirdParty_1 = randomHostName();
                discovery_cynerio = randomHostName();
                discovery_paloAlto = "{\r\n  \"source_key\": \"78b2b1db1be4d810ccdcc91e1e4bcb45\",\r\n  \"device_id\": \"" + deviceId_1 + "\",\r\n  \"table_name\": \"" + table_name + "\",\r\n  \"parameters\": [\r\n    {\r\n      \"mac\": \"" + mac_1 + "\"\r\n    },\r\n    {\r\n      \"third_party_id\": \"" + thirdParty_1 + "\"\r\n    },\r\n    {\r\n      \"ip\": [{\"address\":\"" + ip_1 + "\",\"type\":\"Static\"}]\r\n    },\r\n    {\r\n      \"vlan_id\": [0, 1800, 2912, 430, 437, 408, 1318, 410, 405, 428, 407, 432]\r\n    },\r\n    {\r\n      \"hostname\": \"" + discovery_cynerio + "\"\r\n    },\r\n    {\r\n      \"mfg\": \"GE Healthcare\"\r\n    },\r\n    {\r\n      \"device_type\": \"Infusion Systems\"\r\n    },\r\n    {\r\n      \"device_model\": \"3M Ranger™ Pressure Infusor Model 90032\"\r\n    },\r\n    {\r\n      \"device_family\": \"[\\\"Imaging Devices\\\",\\\"Medical Devices\\\",\\\"Workstations\\\"]\"\r\n    },\r\n    {\r\n      \"device_master_family\": \"[\\\"Imaging Devices\\\",\\\"Medical Devices\\\",\\\"Workstations\\\"]\"\r\n    },\r\n    {\r\n      \"neighbor_device_types\": \"[\\\"Network Appliance\\\",\\\"IT Workstation\\\",\\\"IT Server\\\"]\"\r\n    },\r\n    {\r\n      \"network_location\": \"00:de:fb:7b:44:42\"\r\n    },\r\n    {\r\n      \"physical_location\": \"vlan_0, 431, 1800\"\r\n    },\r\n    {\r\n      \"connection_type\": \"" + connectionType + "\"\r\n    },\r\n    {\r\n      \"applications\": \"[\\\"chrome 64.0.3282.140\\\",\\\"Microsoft Bits 7.8\\\",\\\"mysql *\\\"]\"\r\n    },\r\n    {\r\n      \"http_host_names\": \"[\\\"dev.virtualearth.net\\\",\\\"enroll.cisco.com\\\",\\\"www.cvent.com\\\"]\"\r\n    },\r\n    {\r\n      \"services\": \"[\\\"VLAN\\\",\\\"arp\\\",\\\"entexthigh\\\",\\\"dhcpv6-func\\\",\\\"dicom\\\",\\\"IPv6\\\",\\\"IPv4\\\",\\\"WLAN\\\"]\"\r\n    },\r\n    {\r\n      \"software_version\": \"70.80.105.036\"\r\n    },\r\n    {\r\n      \"MDS2_present\": \"No\"\r\n    },\r\n    {\r\n      \"transmits_ePHI\": \"true\"\r\n    },\r\n    {\r\n      \"serial_number\": \"" + serialNo_1 + "\"\r\n    },\r\n    {\r\n      \"risk_score\": 9\r\n    },\r\n    {\r\n      \"impact\": {\"data\":\"HIGH\",\"business\":\"LOW\",\"patient\":\"LOW\",\"overall\":5}\r\n    },\r\n    {\r\n      \"peer_ip_services\" : [{\r\n          \"service\": \"string, protocol service name\",\r\n          \"ports\": [\"555\", \"8080\", \"2343\"],\r\n          \"peer_ip_list\": [\"5.5.5.5\", \"80.80.80.80\", \"23.43.23.34\"]\r\n      }]\r\n    },\r\n    {\r\n      \"external_ip_services\": [{\r\n          \"ip_addr\": \"123.34.234.234\",\r\n          \"service\": \"string, protocol service used with this external IP address\",\r\n          \"country\": \"USA\",\r\n          \"organization\": \"AT&T\",\r\n          \"reputation\": \"Good\",\r\n          \"whitelist\": \"Yes\"\r\n    }]\r\n    },\r\n    {\r\n      \"wireless_parameters\": [{\r\n          \"SSID_List\": [\"network1\",\"wi-fi2\",\"wi-fi3\"],\r\n          \"Supported_Rates_Mbps\": [128, 64, 128],\r\n          \"Extended_Supported_Rates_Mbps\": [128, 64, 128],\r\n          \"Max_Tx_Power_dBm\": 20,\r\n          \"Min_Tx_Power_dBm\": 5,\r\n          \"Supported_Channels\": [],\r\n          \"High_Throughput_Support\": \"\",\r\n          \"40MHz_Support\": \"Yes\",\r\n          \"Max_Rx_Data_Rate_Mbps\": 128,\r\n          \"Tx_STBC_Support\": \"No\",\r\n          \"Rx STBC Support\": \"No\",\r\n          \"Group_Cipher_Suite\": [\"string, WLAN Cipher\"],\r\n          \"Pairwise_Cipher_Suite_List\": [\"string, WLAN Cipher\"],\r\n          \"Akm_Suite_List\": [\"string, AKM Suite\"]\r\n      }]\r\n    },\r\n    {\r\n      \"high_risk_cves\": [\r\n        {\r\n          \"cve_id\": \"CVE-2015-2222\",\r\n          \"cve_score\": 9.2,\r\n          \"recommendation\": \"Block ports corresponding to RDP on device\",\r\n          \"description\": \"The Remote Desktop Protocol (RDP) server service in Microsoft Windows 7 SP1, Windows 8, and Windows Server 2012 allows remote attackers to execute arbitrary code via a series of crafted packets, aka Remote Desktop Protocol (RDP) Remote Code Execution Vulnerability.\",\r\n          \"exploit_vector\": \"string, CVE exploit vector\",\r\n          \"configuration_trigger\": \"string Trigger for CVE based on device configuration\",\r\n          \"work_order_priority\": \"HIGH\"\r\n        },\r\n        {\r\n          \"cve_id\": \"CVE-2012-0002\",\r\n          \"cve_score\": 9.2,\r\n          \"recommendation\": \"Block ports corresponding to RDP on device\"\r\n        },\r\n        {\r\n          \"cve_id\": \"CVE-2010-0020\",\r\n          \"cve_score\": 7.5,\r\n          \"recommendation\": \"Implement strong access controls for device to ensure only authorized personnel can access the device\"\r\n        }\r\n      ]\r\n    },\r\n    {\r\n      \"os\": \"windows_embedded_7\"\r\n    },\r\n    {\r\n      \"os_version\": \"unknown\"\r\n    },\r\n    {\r\n      \"impact\": [{\r\n        \"overall\": 7,\r\n        \"patient\": \"LOW\",\r\n        \"data\": \"HIGH\",\r\n        \"business\": \"MEDIUM\"\r\n      }]\r\n    }\r\n  ],\r\n  \"payload\": \"\"\r\n}";
                return discovery_paloAlto;
            case "cyberMDX":
                deviceId_1 = randomString();
                serialNo_1 = randomSerial();
                thirdParty_1 = randomHostName();
                discovery_cynerio = randomHostName();
                discovery_paloAlto = "{\r\n  \"source_key\": \"f4b2b1db1be4d810ccdcc91e1e4bcb46\",\r\n  \"device_id\": \"" + deviceId_1 + "\",\r\n  \"table_name\": \"" + table_name + "\",\r\n  \"parameters\": [\r\n    {\r\n      \"third_party_id\": \"" + thirdParty_1 + "\"\r\n    },\r\n    {\r\n      \"app_version\": \"Ver:13.41.00.002 2011/09/16\"\r\n    },\r\n    {\r\n      \"first_seen\": \"1.567953647255E9\"\r\n    },\r\n    {\r\n      \"hostname\": \"" + discovery_cynerio + "\"\r\n    },\r\n    {\r\n      \"last_seen\": \"1.58791896941E9\"\r\n    },\r\n    {\r\n      \"location\": \"Hospital1, Building 7, Floor 3 Room 3\"\r\n    },\r\n    {\r\n      \"manufacturer\": \"Rauland\"\r\n    },\r\n    {\r\n      \"model\": \"" + model + "\"\r\n    },\r\n    {\r\n      \"os\": \"Hospira Proprietary\"\r\n    },\r\n    {\r\n      \"serial_number\": \"" + serialNo_1 + "\"\r\n    },\r\n    {\r\n      \"type\": \"Infusion Pump\"\r\n    },\r\n    {\r\n      \"connection_encryption_type\": \"WPA2-PSK (TKIP)\"\r\n    },\r\n    {\r\n      \"connection_type\": \"" + connectionType + "\"\r\n    },\r\n    {\r\n      \"ip\": \"" + ip_1 + "\"\r\n    },\r\n    {\r\n      \"mac\": \"" + mac_1 + "\"\r\n    },\r\n    {\r\n      \"switch/access_point\": \"chirestricted(6c-99-89-f3-f4-70)\"\r\n    },\r\n    {\r\n      \"vlan\": \"200\"\r\n    },\r\n    {\r\n      \"link\": \"https://ui.cybermdx.app:33443/Assets/5cc697ba1c1e743bfcf688b8\"\r\n    }\r\n  ],\r\n  \"payload\": \"\"\r\n}";
                return discovery_paloAlto;
            case "ordr":
                deviceId_1 = randomString();
                serialNo_1 = randomSerial();
                thirdParty_1 = randomHostName();
                discovery_cynerio = randomHostName();
                discovery_paloAlto = "{\r\n    \"source_key\": \"f0b2b1db1be4d810ccdcc91e1e4bcb47\",\r\n    \"device_id\": \"" + deviceId_1 + "\",\r\n    \"table_name\": \"" + table_name + "\",\r\n    \"parameters\": [\r\n        {\r\n            \"third_party_id\": \"" + thirdParty_1 + "\"\r\n        },\r\n        {\r\n            \"ipAddress\": \"" + ip_1 + "\"\r\n        },\r\n        {\r\n            \"macAddress\": \"" + mac_1 + "\"\r\n        },\r\n        {\r\n            \"serial_number\": \"" + serialNo_1 + "\"\r\n        },\r\n        {\r\n            \"model\": \" P3214\"\r\n        },{\r\n            \"hostname\": \"newHostName\"\n" +
                        "        },\r\n        {\r\n            \"deviceDescription\": \"Ultrasound\"\r\n        },\r\n        {\r\n            \"firstSeen\": \"15886803599123\"\r\n        },\r\n        {\r\n            \"isActive\": \"true\"\r\n        },\r\n        {\r\n            \"behaviorState\": \"NORMAL\"\r\n        },\r\n        {\r\n            \"lastSeen\": \"1586803599321\"\r\n        },\r\n        {\r\n            \"manufacturer\": \"GE Healthscare\"\r\n        },\r\n        {\r\n            \"riskScore\": \"0\"\r\n        },\r\n        {\r\n            \"vlan\": \"VLAN0204\"\r\n        },\r\n        {\r\n            \"osType\": \"Linux\"\r\n        },\r\n        {\r\n            \"osVersion\": \"3.29\"\r\n        },\r\n        {\r\n            \"swVersion\": \"L.01.09\"\r\n        },\r\n        {\r\n            \"ssid\": \"cloudpost\"\r\n        },\r\n        {\r\n            \"accessPoint\": \"94:B8:02:7B:A9:6A\"\r\n        },\r\n        {\r\n            \"category\": \"Facility Devices\"\r\n        },\r\n        {\r\n            \"categoryGuid\": \"DG-Facility Devices\"\r\n        },\r\n        {\r\n            \"alarmCount\": \"0\"\r\n        },\r\n        {\r\n            \"interface\":\"NA\"\r\n        },\r\n        {\r\n            \"networkEquipmentHostName\":\"" + discovery_cynerio + "\"\r\n        }\r\n    ],\r\n    \"payload\": \"Ordr Data\"\r\n}";
                return discovery_paloAlto;
            case "armis":
                deviceId_1 = randomString();
                serialNo_1 = randomSerial();
                thirdParty_1 = randomHostName();
                discovery_cynerio = randomHostName();
                discovery_paloAlto = "{\r\n  \"source_key\": \"849a998bdb3210101db2278115961956\",\r\n  \"device_id\": \"" + deviceId_1 + "\",\r\n  \"table_name\": \"" + table_name + "\",\r\n  \"parameters\": [\r\n    {\r\n      \"third_party_id\": \"" + thirdParty_1 + "\"\r\n    },\r\n    {\r\n      \"name\": \"" + discovery_cynerio + "\"\r\n    },\r\n    {\r\n      \"networkInterface\": [\r\n        {\r\n          \"ipv4\": \"" + ip_1 + "\",\r\n          \"ipv6\": \"fe80::a650:46ff:fe66:70af\",\r\n          \"macAddress\": \"" + mac_1 + "\",\r\n          \"name\": \"MRC40273\",\r\n          \"type\": \"Ethernet / Wifi / Bluetooth / Serial / Virtual , \",\r\n          \"vlans\": [\r\n            1, 5, 6\r\n          ]\r\n        }\r\n      ]\r\n    },\r\n    {\r\n      \"publicIp\": \"52.0.71.49\"\r\n    },\r\n    \r\n    {\r\n      \"serialNumber\": \"" + serialNo_1 + "\"\r\n    },\r\n    {\r\n      \"udid\": \"002ebf12-a125-5ddf-a739-67c3c5d20177\"\r\n    },\r\n    {\r\n      \"phoneNumber\": \"+13479876543\"\r\n    },\r\n    {\r\n      \"imei\": \"35-209900-176148-1\"\r\n    },\r\n    {\r\n      \"meid\": \"352099001761481\"\r\n    },\r\n    {\r\n      \"user\": \"someone@mycompany.com\"\r\n    },\r\n    {\r\n      \"biosVendor\": \"HP\"\r\n    },\r\n    {\r\n      \"biosVersion\": \"I31\"\r\n    },\r\n    {\r\n      \"biosType\": \"UEFI\"\r\n    },\r\n    {\r\n      \"operatingSystem\": \"Microsoft Windows 10 Pro\"\r\n    },\r\n    {\r\n      \"operatingSystemVersion\": \"10.0.17763\"\r\n    },\r\n    {\r\n      \"osBuildNumber\": \"7601\"\r\n    },\r\n    {\r\n      \"firmwareVersion\": \"12.2(25)SEE4\"\r\n    },\r\n    {\r\n      \"warrantyExpiryDate\": \"2020-09-25T13:51:07.155154+00:00\"\r\n    },\r\n    {\r\n      \"domainName\": \"discover.armis.com\"\r\n    },\r\n    {\r\n      \"type\": \"X-Rays\"\r\n    },\r\n    {\r\n      \"category\": \"Medical Diagnostic\"\r\n    },\r\n    {\r\n      \"model\": \"Mini C-Arm\"\r\n    },\r\n    {\r\n      \"manufacturer\": \"OrthoScan Inc.\"\r\n    },\r\n    {\r\n      \"fdaRecall\": [\r\n        {\r\n          \"text\": \"FDA Recall for Hospira Plum A+ and Plum A+3 Due to an Alarm Error\",\r\n          \"href\": \"http://wayback.archive-it.org/7993/20170112083806/http://www.fda.gov/MedicalDevices/Safety/ListofRecalls/ucm436770.htm\"\r\n        }\r\n      ]\r\n    },\r\n    {\r\n      \"mds2\": [\r\n          \"Q.10-3 - The user cannot redefine manufacturer-installed AV\",\r\n          \"Q.10-2 - The user cannot install/update AV software\",\r\n          \"Q.10-1.3 - The user can independently repair the device after a threat is detected\",\r\n          \"Q.10-1.2 - AV's notification are disabled on user interface\",\r\n          \"Q.10-1.1 - The user cannot independently re-configure AV's settings\",\r\n          \"Q.10-1 - The device doesn't support internal AV\"\r\n      ]\r\n    },\r\n    {\r\n      \"deviceLocation\": \"server room\"\r\n    },\r\n    {\r\n      \"hardwareVersion\": \"0355a\"\r\n    },\r\n    {\r\n      \"aeTitle\": \"SERVER1\"\r\n    },\r\n    {\r\n      \"processorArchitecture\": \"x86_64\"\r\n    },\r\n    {\r\n      \"firstSeen\": \"2020-09-25T13:51:07.155154+00:00\"\r\n    },\r\n    {\r\n      \"lastSeen\": \"2020-09-25T13:51:07.155154+00:00\"\r\n    },\r\n    {\r\n      \"riskLevel\": 2\r\n    },\r\n    {\r\n      \"site\": {\r\n        \"location\": \"Palo Alot\",\r\n        \"name\": \"Palo Alto Offices\"\r\n      }\r\n    }\r\n  ],\r\n  \"payload\": \"devices\"\r\n}";
                return discovery_paloAlto;
            case "paloAlto":
                deviceId_1 = randomString();
                serialNo_1 = randomSerial();
                thirdParty_1 = randomHostName();
                discovery_cynerio = randomHostName();
                discovery_paloAlto = "{\r\n    \"source_key\": \"b4b2b1db1be4d810ccdcc91e1e4bcb47\",\r\n    \"device_id\": \"" + deviceId_1 + "\",\r\n    \"table_name\": \"" + table_name + "\",\r\n    \"parameters\": [\r\n        {\r\n            \"mac_address\": \"" + mac_1 + "\"\r\n        },\r\n        {\r\n            \"ip\": \"" + ip_1 + "\"\r\n        },\r\n        {\r\n            \"third_party_id\": \"" + thirdParty_1 + "\"\r\n        },\r\n        {\r\n            \"hostname\": \"" + discovery_cynerio + "\"\r\n        },\r\n        {\r\n            \"serial_number\": \"" + serialNo_1 + "\"\r\n        },\r\n        {\r\n            \"uid\": \"95:7b:f3:21:bd:84\"\r\n        },\r\n        {\r\n            \"Subnet\": \"212.45.65.233\"\r\n        },\r\n        {\r\n            \"Vlan\": \"1288\"\r\n        },\r\n        {\r\n            \"DHCP\": \"Yes\"\r\n        },\r\n        {\r\n            \"Risk Score\": \"25\"\r\n        },\r\n        {\r\n            \"Risk Level\": \"Low\"\r\n        },\r\n        {\r\n            \"Last Activity\": \"2020-10-29 17:21:56.792000\"\r\n        },\r\n        {\r\n            \"Wire/Wireless\": \"wireless\"\r\n        },\r\n        {\r\n            \"Profile\": \"DICOM-Imager-X-Ray\"\r\n        },\r\n        {\r\n            \"Category\": \"X-Ray Machine\"\r\n        },\r\n        {\r\n            \"OS Group\": \"Android\"\r\n        },\r\n        {\r\n            \"Make\": \"Crestron\"\r\n        },\r\n        {\r\n            \"Device Details Link\": \"https://testing-soho.zingbox.com/detail/device/98:7b:f3:21:bd:84\"\r\n        },\r\n        {\r\n            \"vendor\": \"GE\"\r\n        },\r\n        {\r\n            \"Model\": \"OEC 9800\"\r\n        },\r\n        {\r\n            \"Site Name\": \"St. Vincent Carmel Hospital\"\r\n        },\r\n        {\r\n            \"event_type\": \"Asset Identification\"\r\n        }\r\n    ],\r\n    \"payload\": \"Discovery Event\"\r\n}";
                return discovery_paloAlto;
            case "cynerio":
                deviceId_1 = randomString();
                serialNo_1 = randomSerial();
                thirdParty_1 = randomHostName();
                discovery_cynerio = "{\r\n  \"source_key\": \"b8b2b1db1be4d810ccdcc91e1e4bcb46\",\r\n  \"device_id\": \"" + deviceId_1 + "\",\r\n  \"table_name\": \"" + table_name + "\",\r\n  \"parameters\": [\r\n    {\r\n      \"category\": \"Device\"\r\n    },\r\n    {\r\n      \"third_party_id\": \"" + thirdParty_1 + "\"\r\n    },\r\n    {\r\n      \"connection_type\": \"" + connectionType + "\"\r\n    },\r\n    {\r\n      \"domain_member\": \"false\"\r\n    },\r\n    {\r\n      \"first_seen\": \"2019-12-13T05:05:29.384648+00:00\"\r\n    },\r\n    {\r\n      \"hardware_version\": \"4.32\"\r\n    },\r\n    {\r\n      \"id\": \"fa3a56a3-ab8c-433c-a631-2abf9870e340\"\r\n    },\r\n    {\r\n      \"last_seen\": \"2019-12-16T12:58:47.152832+00:00\"\r\n    },\r\n    {\r\n      \"model\": \"ACCU-CHEK Inform II1\"\r\n    },\r\n    {\r\n      \"names\": [{\"source\":\"POCT1\",\"value\":\"00-60-19-03-14-21-15-80\"}]\r\n    },\r\n    {\r\n      \"os\": \"Linux\"\r\n    },\r\n    {\r\n      \"phi\": true\r\n    },\r\n    {\r\n      \"serial_number\": \"" + serialNo_1 + "\"\r\n    },\r\n    {\r\n      \"site\": \"Main\"\r\n    },\r\n    {\r\n      \"software_version\": \"04.01.04\"\r\n    },\r\n    {\r\n      \"status\": \"ONLINE\"\r\n    },\r\n    {\r\n      \"tags\": {\"network.ip_allocation\":\"dynamic\",\"network.domain_member\":true,\"os.windows_update\":true, \"phi_details\":\"test\"}\r\n    },\r\n    {\r\n      \"type_display_name\": \"Glucometer\"\r\n    },\r\n    {\r\n      \"vendor\": \"Roche\"\r\n    },\r\n    {\r\n      \"dynamic_ip\": true\r\n    },\r\n    {\r\n      \"ip\": \"" + ip_1 + "\"\r\n    },\r\n    {\r\n      \"mac\": \"" + mac_1 + "\"\r\n    },\r\n    {\r\n      \"vlan\": \"72\"\r\n    }\r\n  ],\r\n  \"payload\": \"\"\r\n}";
                return discovery_cynerio;
        }

        throw new IllegalArgumentException("Unexpected value: " + partner);
    }

    public String discoveryPartnerAllUnique(String partner, String table_name, String connectionType, String model, String ip_1, String mac_1
            , String deviceId_1, String serialNo_1, String thirdParty_1) {

        String discovery_cynerio;
        String discovery_paloAlto;
        switch (partner) {
            case "medsec":
                discovery_cynerio = "{\r\n  \"source_key\": \"fda5113f1b87d810375b84ccdd4bcbe3\",\r\n  \"device_id\": \"" + deviceId_1 + "\",  \r\n  \"table_name\": \"" + table_name + "\",\r\n  \"parameters\": [\r\n    {\r\n      \"mac\": \"" + mac_1 + "\"\r\n    },\r\n    {\r\n      \"third_party_id\": \"" + thirdParty_1 + "\"  \r\n    },\r\n    {\r\n      \"vendor\": \"GE\"\r\n    },\r\n    {\r\n      \"modality\": \"Ultrasound\"\r\n    },\r\n    {\r\n      \"operating_system\": \"Linux\"\r\n    },\r\n    {\r\n      \"software_version\": \"R4.3.0\"\r\n    },\r\n    {\r\n      \"timestamp\": \"1624039466E9\"\r\n    },\r\n    {\r\n      \"ip\": \"" + ip_1 + "\"\r\n    },\r\n    {\r\n      \"old_ip\": \"1.2.3.4\"\r\n    },\r\n    {\r\n      \"serial_number\": \"" + serialNo_1 + "\"\r\n    },\r\n    {\r\n      \"identity\": \"VenueGO\"\r\n    }], \r\n\r\n  \"payload\": \"new_device / missing_device / ip_changed\"\r\n}";
                return discovery_cynerio;
            case "medigate":
                discovery_paloAlto = "{\r\n  \"source_key\": \"7cb2b1db1be4d810ccdcc91e1e4bcb46\",\r\n    \"device_id\": \"" + deviceId_1 + "\",\r\n    \"table_name\": \"" + table_name + "\",\r\n    \"parameters\": [\r\n        {\r\n            \"device_type\": \"Infusion Pump\"\r\n        },\r\n        {\r\n            \"device_id\": \"" + deviceId_1 + "\"\r\n        },\r\n        {\r\n            \"third_party_id\": \"" + thirdParty_1 + "\"\r\n        },\r\n        {\r\n            \"serial\": \"" + serialNo_1 + "\"\r\n        },\r\n        {\r\n            \"hostname\": \"" + mac_1 + "\"\r\n        },\r\n        {\r\n            \"ip\": \"" + ip_1 + "\"\r\n        },\r\n        {\r\n            \"mac\": \"" + mac_1 + "\"\r\n        },\r\n        {\r\n            \"risk_score\": \"2\"\r\n        },\r\n        {\r\n            \"is_online\": \"TRUE\"\r\n        },\r\n        {\r\n            \"manufacturer\": \"Alaris\"\r\n        },\r\n        {\r\n            \"model\": \"8015 PC Unit\"\r\n        },\r\n        {\r\n            \"category\": \"Medical\"\r\n        },\r\n        {\r\n            \"sub_category\": \"Patient Devices\"\r\n        },\r\n        {\r\n            \"vendor\": \"Philips\"\r\n        },\r\n        {\r\n            \"first_seen\": \"2019-11-18T12:00:18.811418+00:00\"\r\n        },\r\n        {\r\n            \"last_seen\": \"2019-11-22T12:00:12.811418+00:00\"\r\n        },\r\n        {\r\n            \"last_seen_on_switch\": \"2019-11-22T12:00:12.811418+00:00\"\r\n        },\r\n        {\r\n            \"hw_version\": \"23F\"\r\n        },\r\n        {\r\n            \"is_component\": \"false\"\r\n        },\r\n        {\r\n            \"location\": \"PCU\"\r\n        },\r\n        {\r\n            \"os_name\": \"Proprietary\"\r\n        },\r\n        {\r\n            \"os_revision\": \"SP2\"\r\n        },\r\n        {\r\n            \"os_version\": \"Enea OSE\"\r\n        },\r\n        {\r\n            \"parent_id\": \"233132ec-8f7d-4e5f-8dba-60eea66e7bb0\"\r\n        },\r\n        {\r\n            \"protocols\": [\r\n                \"Unity\",\r\n                \"RWHAT\"\r\n            ]\r\n        },\r\n        {\r\n            \"sw_version\": \"32.b\"\r\n        },\r\n        {\r\n            \"connection_type\": \"" + connectionType + "\"\r\n        },\r\n        {\r\n            \"ip_assignment\": \"DHCP\"\r\n        },\r\n        {\r\n            \"vlan\": \"880\"\r\n        },\r\n        {\r\n            \"vlan_name\": \"floor1\"\r\n        },\r\n        {\r\n            \"vlan_desc\": \"Radiology floor 1\"\r\n        },\r\n        {\r\n            \"switch_port\": \"Ge/0/1\"\r\n        },\r\n        {\r\n            \"switch_ip\": \"1.2.3.4\"\r\n        },\r\n        {\r\n            \"switch_name\": \"OfficeSwitch\"\r\n        },\r\n        {\r\n            \"bssid\": \"00:c0:58:70:e4:a0\"\r\n        },\r\n        {\r\n            \"last_seen\": \"2019-11-18T11:28:19.380109+00:00\"\r\n        },\r\n        {\r\n            \"ssid\": \"MEDNET\"\r\n        },\r\n        {\r\n            \"ap_name\": \"CO01080010\"\r\n        },\r\n        {\r\n            \"ap_location\": \"Columbia -> Building 2 -> Floor 9\"\r\n        },\r\n        {\r\n            \"fda_class\": \"1\"\r\n        },\r\n        {\r\n            \"kingdom\": \"Medical\"\r\n        },\r\n        {\r\n            \"phi\": \"Stored & Transmitted\"\r\n        },\r\n        {\r\n            \"equipment_class\": \"Physiological Monitoring\"\r\n        },\r\n        {\r\n            \"consequence_of_failure\": \"Inappropriate Therapy or Misdiagnosis\"\r\n        },\r\n        {\r\n            \"wifi_last_seen\": \"2021-02-23 08:31:00.702468+00:00\"\r\n        }\r\n    ],\r\n    \"payload\": \"\"\r\n}";
                return discovery_paloAlto;
            case "asimily":
                discovery_paloAlto = "{\r\n  \"source_key\": \"78b2b1db1be4d810ccdcc91e1e4bcb45\",\r\n  \"device_id\": \"" + deviceId_1 + "\",\r\n  \"table_name\": \"" + table_name + "\",\r\n  \"parameters\": [\r\n    {\r\n      \"mac\": \"" + mac_1 + "\"\r\n    },\r\n    {\r\n      \"third_party_id\": \"" + thirdParty_1 + "\"\r\n    },\r\n    {\r\n      \"ip\": [{\"address\":\"" + ip_1 + "\",\"type\":\"Static\"}]\r\n    },\r\n    {\r\n      \"vlan_id\": [0, 1800, 2912, 430, 437, 408, 1318, 410, 405, 428, 407, 432]\r\n    },\r\n    {\r\n      \"hostname\": \"" + mac_1 + "\"\r\n    },\r\n    {\r\n      \"mfg\": \"GE Healthcare\"\r\n    },\r\n    {\r\n      \"device_type\": \"Infusion Systems\"\r\n    },\r\n    {\r\n      \"device_model\": \"3M Ranger™ Pressure Infusor Model 90032\"\r\n    },\r\n    {\r\n      \"device_family\": \"[\\\"Imaging Devices\\\",\\\"Medical Devices\\\",\\\"Workstations\\\"]\"\r\n    },\r\n    {\r\n      \"device_master_family\": \"[\\\"Imaging Devices\\\",\\\"Medical Devices\\\",\\\"Workstations\\\"]\"\r\n    },\r\n    {\r\n      \"neighbor_device_types\": \"[\\\"Network Appliance\\\",\\\"IT Workstation\\\",\\\"IT Server\\\"]\"\r\n    },\r\n    {\r\n      \"network_location\": \"00:de:fb:7b:44:42\"\r\n    },\r\n    {\r\n      \"physical_location\": \"vlan_0, 431, 1800\"\r\n    },\r\n    {\r\n      \"connection_type\": \"" + connectionType + "\"\r\n    },\r\n    {\r\n      \"applications\": \"[\\\"chrome 64.0.3282.140\\\",\\\"Microsoft Bits 7.8\\\",\\\"mysql *\\\"]\"\r\n    },\r\n    {\r\n      \"http_host_names\": \"[\\\"dev.virtualearth.net\\\",\\\"enroll.cisco.com\\\",\\\"www.cvent.com\\\"]\"\r\n    },\r\n    {\r\n      \"services\": \"[\\\"VLAN\\\",\\\"arp\\\",\\\"entexthigh\\\",\\\"dhcpv6-func\\\",\\\"dicom\\\",\\\"IPv6\\\",\\\"IPv4\\\",\\\"WLAN\\\"]\"\r\n    },\r\n    {\r\n      \"software_version\": \"70.80.105.036\"\r\n    },\r\n    {\r\n      \"MDS2_present\": \"No\"\r\n    },\r\n    {\r\n      \"transmits_ePHI\": \"true\"\r\n    },\r\n    {\r\n      \"serial_number\": \"" + serialNo_1 + "\"\r\n    },\r\n    {\r\n      \"risk_score\": 9\r\n    },\r\n    {\r\n      \"impact\": {\"data\":\"HIGH\",\"business\":\"LOW\",\"patient\":\"LOW\",\"overall\":5}\r\n    },\r\n    {\r\n      \"peer_ip_services\" : [{\r\n          \"service\": \"string, protocol service name\",\r\n          \"ports\": [\"555\", \"8080\", \"2343\"],\r\n          \"peer_ip_list\": [\"5.5.5.5\", \"80.80.80.80\", \"23.43.23.34\"]\r\n      }]\r\n    },\r\n    {\r\n      \"external_ip_services\": [{\r\n          \"ip_addr\": \"123.34.234.234\",\r\n          \"service\": \"string, protocol service used with this external IP address\",\r\n          \"country\": \"USA\",\r\n          \"organization\": \"AT&T\",\r\n          \"reputation\": \"Good\",\r\n          \"whitelist\": \"Yes\"\r\n    }]\r\n    },\r\n    {\r\n      \"wireless_parameters\": [{\r\n          \"SSID_List\": [\"network1\",\"wi-fi2\",\"wi-fi3\"],\r\n          \"Supported_Rates_Mbps\": [128, 64, 128],\r\n          \"Extended_Supported_Rates_Mbps\": [128, 64, 128],\r\n          \"Max_Tx_Power_dBm\": 20,\r\n          \"Min_Tx_Power_dBm\": 5,\r\n          \"Supported_Channels\": [],\r\n          \"High_Throughput_Support\": \"\",\r\n          \"40MHz_Support\": \"Yes\",\r\n          \"Max_Rx_Data_Rate_Mbps\": 128,\r\n          \"Tx_STBC_Support\": \"No\",\r\n          \"Rx STBC Support\": \"No\",\r\n          \"Group_Cipher_Suite\": [\"string, WLAN Cipher\"],\r\n          \"Pairwise_Cipher_Suite_List\": [\"string, WLAN Cipher\"],\r\n          \"Akm_Suite_List\": [\"string, AKM Suite\"]\r\n      }]\r\n    },\r\n    {\r\n      \"high_risk_cves\": [\r\n        {\r\n          \"cve_id\": \"CVE-2015-2222\",\r\n          \"cve_score\": 9.2,\r\n          \"recommendation\": \"Block ports corresponding to RDP on device\",\r\n          \"description\": \"The Remote Desktop Protocol (RDP) server service in Microsoft Windows 7 SP1, Windows 8, and Windows Server 2012 allows remote attackers to execute arbitrary code via a series of crafted packets, aka Remote Desktop Protocol (RDP) Remote Code Execution Vulnerability.\",\r\n          \"exploit_vector\": \"string, CVE exploit vector\",\r\n          \"configuration_trigger\": \"string Trigger for CVE based on device configuration\",\r\n          \"work_order_priority\": \"HIGH\"\r\n        },\r\n        {\r\n          \"cve_id\": \"CVE-2012-0002\",\r\n          \"cve_score\": 9.2,\r\n          \"recommendation\": \"Block ports corresponding to RDP on device\"\r\n        },\r\n        {\r\n          \"cve_id\": \"CVE-2010-0020\",\r\n          \"cve_score\": 7.5,\r\n          \"recommendation\": \"Implement strong access controls for device to ensure only authorized personnel can access the device\"\r\n        }\r\n      ]\r\n    },\r\n    {\r\n      \"os\": \"windows_embedded_7\"\r\n    },\r\n    {\r\n      \"os_version\": \"unknown\"\r\n    },\r\n    {\r\n      \"impact\": [{\r\n        \"overall\": 7,\r\n        \"patient\": \"LOW\",\r\n        \"data\": \"HIGH\",\r\n        \"business\": \"MEDIUM\"\r\n      }]\r\n    }\r\n  ],\r\n  \"payload\": \"\"\r\n}";
                return discovery_paloAlto;
            case "cyberMDX":
                discovery_paloAlto = "{\r\n  \"source_key\": \"f4b2b1db1be4d810ccdcc91e1e4bcb46\",\r\n  \"device_id\": \"" + deviceId_1 + "\",\r\n  \"table_name\": \"" + table_name + "\",\r\n  \"parameters\": [\r\n    {\r\n      \"third_party_id\": \"" + thirdParty_1 + "\"\r\n    },\r\n    {\r\n      \"app_version\": \"Ver:13.41.00.002 2011/09/16\"\r\n    },\r\n    {\r\n      \"first_seen\": \"1.567953647255E9\"\r\n    },\r\n    {\r\n      \"hostname\": \"" + mac_1 + "\"\r\n    },\r\n    {\r\n      \"last_seen\": \"1.58791896941E9\"\r\n    },\r\n    {\r\n      \"location\": \"Hospital1, Building 7, Floor 3 Room 3\"\r\n    },\r\n    {\r\n      \"manufacturer\": \"Rauland\"\r\n    },\r\n    {\r\n      \"model\": \"" + model + "\"\r\n    },\r\n    {\r\n      \"os\": \"Hospira Proprietary\"\r\n    },\r\n    {\r\n      \"serial_number\": \"" + serialNo_1 + "\"\r\n    },\r\n    {\r\n      \"type\": \"Infusion Pump\"\r\n    },\r\n    {\r\n      \"connection_encryption_type\": \"WPA2-PSK (TKIP)\"\r\n    },\r\n    {\r\n      \"connection_type\": \"" + connectionType + "\"\r\n    },\r\n    {\r\n      \"ip\": \"" + ip_1 + "\"\r\n    },\r\n    {\r\n      \"mac\": \"" + mac_1 + "\"\r\n    },\r\n    {\r\n      \"switch/access_point\": \"chirestricted(6c-99-89-f3-f4-70)\"\r\n    },\r\n    {\r\n      \"vlan\": \"200\"\r\n    },\r\n    {\r\n      \"link\": \"https://ui.cybermdx.app:33443/Assets/5cc697ba1c1e743bfcf688b8\"\r\n    }\r\n  ],\r\n  \"payload\": \"\"\r\n}";
                return discovery_paloAlto;
            case "ordr":
                discovery_paloAlto = "{\r\n    \"source_key\": \"f0b2b1db1be4d810ccdcc91e1e4bcb47\",\r\n    \"device_id\": \"" + deviceId_1 + "\",\r\n    \"table_name\": \"" + table_name + "\",\r\n    \"parameters\": [\r\n        {\r\n            \"third_party_id\": \"" + thirdParty_1 + "\"\r\n        },\r\n        {\r\n            \"ipAddress\": \"" + ip_1 + "\"\r\n        },\r\n        {\r\n            \"macAddress\": \"" + mac_1 + "\"\r\n        },\r\n        {\r\n            \"serial_number\": \"" + serialNo_1 + "\"\r\n        },\r\n        {\r\n            \"model\": \" P3214\"\r\n        },{\r\n            \"hostname\": \"newHostName\"\n" +
                        "        },\r\n        {\r\n            \"deviceDescription\": \"Ultrasound\"\r\n        },\r\n        {\r\n            \"firstSeen\": \"15886803599123\"\r\n        },\r\n        {\r\n            \"isActive\": \"true\"\r\n        },\r\n        {\r\n            \"behaviorState\": \"NORMAL\"\r\n        },\r\n        {\r\n            \"lastSeen\": \"1586803599321\"\r\n        },\r\n        {\r\n            \"manufacturer\": \"GE Healthscare\"\r\n        },\r\n        {\r\n            \"riskScore\": \"0\"\r\n        },\r\n        {\r\n            \"vlan\": \"VLAN0204\"\r\n        },\r\n        {\r\n            \"osType\": \"Linux\"\r\n        },\r\n        {\r\n            \"osVersion\": \"3.29\"\r\n        },\r\n        {\r\n            \"swVersion\": \"L.01.09\"\r\n        },\r\n        {\r\n            \"ssid\": \"cloudpost\"\r\n        },\r\n        {\r\n            \"accessPoint\": \"94:B8:02:7B:A9:6A\"\r\n        },\r\n        {\r\n            \"category\": \"Facility Devices\"\r\n        },\r\n        {\r\n            \"categoryGuid\": \"DG-Facility Devices\"\r\n        },\r\n        {\r\n            \"alarmCount\": \"0\"\r\n        },\r\n        {\r\n            \"interface\":\"NA\"\r\n        },\r\n        {\r\n            \"networkEquipmentHostName\":\"" + mac_1 + "\"\r\n        }\r\n    ],\r\n    \"payload\": \"Ordr Data\"\r\n}";
                return discovery_paloAlto;
            case "armis":
                discovery_paloAlto = "{\r\n  \"source_key\": \"849a998bdb3210101db2278115961956\",\r\n  \"device_id\": \"" + deviceId_1 + "\",\r\n  \"table_name\": \"" + table_name + "\",\r\n  \"parameters\": [\r\n    {\r\n      \"third_party_id\": \"" + thirdParty_1 + "\"\r\n    },\r\n    {\r\n      \"name\": \"" + mac_1 + "\"\r\n    },\r\n    {\r\n      \"networkInterface\": [\r\n        {\r\n          \"ipv4\": \"" + ip_1 + "\",\r\n          \"ipv6\": \"fe80::a650:46ff:fe66:70af\",\r\n          \"macAddress\": \"" + mac_1 + "\",\r\n          \"name\": \"MRC40273\",\r\n          \"type\": \"Ethernet / Wifi / Bluetooth / Serial / Virtual , \",\r\n          \"vlans\": [\r\n            1, 5, 6\r\n          ]\r\n        }\r\n      ]\r\n    },\r\n    {\r\n      \"publicIp\": \"52.0.71.49\"\r\n    },\r\n    \r\n    {\r\n      \"serialNumber\": \"" + serialNo_1 + "\"\r\n    },\r\n    {\r\n      \"udid\": \"002ebf12-a125-5ddf-a739-67c3c5d20177\"\r\n    },\r\n    {\r\n      \"phoneNumber\": \"+13479876543\"\r\n    },\r\n    {\r\n      \"imei\": \"35-209900-176148-1\"\r\n    },\r\n    {\r\n      \"meid\": \"352099001761481\"\r\n    },\r\n    {\r\n      \"user\": \"someone@mycompany.com\"\r\n    },\r\n    {\r\n      \"biosVendor\": \"HP\"\r\n    },\r\n    {\r\n      \"biosVersion\": \"I31\"\r\n    },\r\n    {\r\n      \"biosType\": \"UEFI\"\r\n    },\r\n    {\r\n      \"operatingSystem\": \"Microsoft Windows 10 Pro\"\r\n    },\r\n    {\r\n      \"operatingSystemVersion\": \"10.0.17763\"\r\n    },\r\n    {\r\n      \"osBuildNumber\": \"7601\"\r\n    },\r\n    {\r\n      \"firmwareVersion\": \"12.2(25)SEE4\"\r\n    },\r\n    {\r\n      \"warrantyExpiryDate\": \"2020-09-25T13:51:07.155154+00:00\"\r\n    },\r\n    {\r\n      \"domainName\": \"discover.armis.com\"\r\n    },\r\n    {\r\n      \"type\": \"X-Rays\"\r\n    },\r\n    {\r\n      \"category\": \"Medical Diagnostic\"\r\n    },\r\n    {\r\n      \"model\": \"Mini C-Arm\"\r\n    },\r\n    {\r\n      \"manufacturer\": \"OrthoScan Inc.\"\r\n    },\r\n    {\r\n      \"fdaRecall\": [\r\n        {\r\n          \"text\": \"FDA Recall for Hospira Plum A+ and Plum A+3 Due to an Alarm Error\",\r\n          \"href\": \"http://wayback.archive-it.org/7993/20170112083806/http://www.fda.gov/MedicalDevices/Safety/ListofRecalls/ucm436770.htm\"\r\n        }\r\n      ]\r\n    },\r\n    {\r\n      \"mds2\": [\r\n          \"Q.10-3 - The user cannot redefine manufacturer-installed AV\",\r\n          \"Q.10-2 - The user cannot install/update AV software\",\r\n          \"Q.10-1.3 - The user can independently repair the device after a threat is detected\",\r\n          \"Q.10-1.2 - AV's notification are disabled on user interface\",\r\n          \"Q.10-1.1 - The user cannot independently re-configure AV's settings\",\r\n          \"Q.10-1 - The device doesn't support internal AV\"\r\n      ]\r\n    },\r\n    {\r\n      \"deviceLocation\": \"server room\"\r\n    },\r\n    {\r\n      \"hardwareVersion\": \"0355a\"\r\n    },\r\n    {\r\n      \"aeTitle\": \"SERVER1\"\r\n    },\r\n    {\r\n      \"processorArchitecture\": \"x86_64\"\r\n    },\r\n    {\r\n      \"firstSeen\": \"2020-09-25T13:51:07.155154+00:00\"\r\n    },\r\n    {\r\n      \"lastSeen\": \"2020-09-25T13:51:07.155154+00:00\"\r\n    },\r\n    {\r\n      \"riskLevel\": 2\r\n    },\r\n    {\r\n      \"site\": {\r\n        \"location\": \"Palo Alot\",\r\n        \"name\": \"Palo Alto Offices\"\r\n      }\r\n    }\r\n  ],\r\n  \"payload\": \"devices\"\r\n}";
                return discovery_paloAlto;
            case "paloAlto":
                discovery_paloAlto = "{\r\n    \"source_key\": \"b4b2b1db1be4d810ccdcc91e1e4bcb47\",\r\n    \"device_id\": \"" + deviceId_1 + "\",\r\n    \"table_name\": \"" + table_name + "\",\r\n    \"parameters\": [\r\n        {\r\n            \"mac_address\": \"" + mac_1 + "\"\r\n        },\r\n        {\r\n            \"ip\": \"" + ip_1 + "\"\r\n        },\r\n        {\r\n            \"third_party_id\": \"" + thirdParty_1 + "\"\r\n        },\r\n        {\r\n            \"hostname\": \"" + mac_1 + "\"\r\n        },\r\n        {\r\n            \"serial_number\": \"" + serialNo_1 + "\"\r\n        },\r\n        {\r\n            \"uid\": \"95:7b:f3:21:bd:84\"\r\n        },\r\n        {\r\n            \"Subnet\": \"212.45.65.233\"\r\n        },\r\n        {\r\n            \"Vlan\": \"1288\"\r\n        },\r\n        {\r\n            \"DHCP\": \"Yes\"\r\n        },\r\n        {\r\n            \"Risk Score\": \"25\"\r\n        },\r\n        {\r\n            \"Risk Level\": \"Low\"\r\n        },\r\n        {\r\n            \"Last Activity\": \"2020-10-29 17:21:56.792000\"\r\n        },\r\n        {\r\n            \"Wire/Wireless\": \"wireless\"\r\n        },\r\n        {\r\n            \"Profile\": \"DICOM-Imager-X-Ray\"\r\n        },\r\n        {\r\n            \"Category\": \"X-Ray Machine\"\r\n        },\r\n        {\r\n            \"OS Group\": \"Android\"\r\n        },\r\n        {\r\n            \"Make\": \"Crestron\"\r\n        },\r\n        {\r\n            \"Device Details Link\": \"https://testing-soho.zingbox.com/detail/device/98:7b:f3:21:bd:84\"\r\n        },\r\n        {\r\n            \"vendor\": \"GE\"\r\n        },\r\n        {\r\n            \"Model\": \"OEC 9800\"\r\n        },\r\n        {\r\n            \"Site Name\": \"St. Vincent Carmel Hospital\"\r\n        },\r\n        {\r\n            \"event_type\": \"Asset Identification\"\r\n        }\r\n    ],\r\n    \"payload\": \"Discovery Event\"\r\n}";
                return discovery_paloAlto;
            case "cynerio":
                discovery_cynerio = "{\r\n  \"source_key\": \"b8b2b1db1be4d810ccdcc91e1e4bcb46\",\r\n  \"device_id\": \"" + deviceId_1 + "\",\r\n  \"table_name\": \"" + table_name + "\",\r\n  \"parameters\": [\r\n    {\r\n      \"category\": \"Device\"\r\n    },\r\n    {\r\n      \"third_party_id\": \"" + thirdParty_1 + "\"\r\n    },\r\n    {\r\n      \"connection_type\": \"" + connectionType + "\"\r\n    },\r\n    {\r\n      \"domain_member\": \"false\"\r\n    },\r\n    {\r\n      \"first_seen\": \"2019-12-13T05:05:29.384648+00:00\"\r\n    },\r\n    {\r\n      \"hardware_version\": \"4.32\"\r\n    },\r\n    {\r\n      \"id\": \"fa3a56a3-ab8c-433c-a631-2abf9870e340\"\r\n    },\r\n    {\r\n      \"last_seen\": \"2019-12-16T12:58:47.152832+00:00\"\r\n    },\r\n    {\r\n      \"model\": \"ACCU-CHEK Inform II1\"\r\n    },\r\n    {\r\n      \"names\": [{\"source\":\"POCT1\",\"value\":\"00-60-19-03-14-21-15-80\"}]\r\n    },\r\n    {\r\n      \"os\": \"Linux\"\r\n    },\r\n    {\r\n      \"phi\": true\r\n    },\r\n    {\r\n      \"serial_number\": \"" + serialNo_1 + "\"\r\n    },\r\n    {\r\n      \"site\": \"Main\"\r\n    },\r\n    {\r\n      \"software_version\": \"04.01.04\"\r\n    },\r\n    {\r\n      \"status\": \"ONLINE\"\r\n    },\r\n    {\r\n      \"tags\": {\"network.ip_allocation\":\"dynamic\",\"network.domain_member\":true,\"os.windows_update\":true, \"phi_details\":\"test\"}\r\n    },\r\n    {\r\n      \"type_display_name\": \"Glucometer\"\r\n    },\r\n    {\r\n      \"vendor\": \"Roche\"\r\n    },\r\n    {\r\n      \"dynamic_ip\": true\r\n    },\r\n    {\r\n      \"ip\": \"" + ip_1 + "\"\r\n    },\r\n    {\r\n      \"mac\": \"" + mac_1 + "\"\r\n    },\r\n    {\r\n      \"vlan\": \"72\"\r\n    }\r\n  ],\r\n  \"payload\": \"\"\r\n}";
                return discovery_cynerio;
        }

        throw new IllegalArgumentException("Unexpected value: " + partner);

    }


    public String restApiExplorer(String payload) {
        RestAssured.baseURI = "https://ven04040.service-now.com";
        RestAssured.authentication = RestAssured.basic("Automation.admin", "Nuvolo@2022");

        // Create a request specification
        RequestSpecification request = RestAssured.given();
        // Define the request body (JSON data)
        String requestBody = payload;
        // Set the request content type
        request.contentType(ContentType.JSON);
        // Set the request body
        request.body(requestBody);
        // Send a POST request and capture the response
        Response response = request.post("/api/x_nuvo_cs/otcs/createDiscoveryQueue");
        // Get the response body as a string
        String responseBody = response.getBody().asString();
        // Get the response status code
        int statusCode = response.getStatusCode();
        // Print the response
        System.out.println("Response Body: " + responseBody);
        System.out.println("Status Code: " + statusCode);
        return responseBody;
    }


    public void scrollRawDataBody() {
        app().create().byXPath(Anchor.class, "//button[normalize-space()='Add header']").scrollToVisible();
    }

    public void clickRawDataBody() {

        app().create().byXPath(Anchor.class, "//a[normalize-space()='Raw']").waitToBe();
        app().create().byXPath(Anchor.class, "//a[normalize-space()='Raw']").click();
        app().create().byXPath(Anchor.class, "//a[normalize-space()='Raw']").click();
    }

    public void setRawDataBody(String body) {
        app().create().byXPath(Anchor.class, "//textarea[@id='post_body_ta']").waitToBe();
        app().create().byXPath(TextInput.class, "//textarea[@id='post_body_ta']").setText(body);
    }

    public void clickCreateQueueLink(String queueName) {
        ((Anchor)app().create().byXPath(Anchor.class, "//div[contains(text(),'Create " + queueName + " Queue')]")).click();
    }

    public void setDropDown(String id, String value) {
        Select select = (Select)app().create().byXPath(Select.class, "(//select[contains(@id,'" + id + "')])[1]");
        select.selectByText(value);
    }

    public String createRequest(String queueName, String api) throws InterruptedException, IOException {
        polarisLeftMenuNavigation("REST API Explorer", "REST API Explorer");//System Web Services
        iFrame();
        ((Anchor)app().create().byXPath(Anchor.class, "//b[text()='Table API']")).waitToBe();
        setDropDown("ns", "x_nuvo_cs");
        ((Anchor)app().create().byXPath(Anchor.class, "//b[text()='OT Cyber Security']")).waitToBe();
        setDropDown("service", "OT Cyber Security");
        app().browser().waitForAjax();
        app().create().byId(TextInput.class, "{vulnerabilityId}").setText("12345");
        clickCreateQueueLink(queueName);

        scrollRawDataBody();
        clickRawDataBody();
        setRawDataBody(api);

        ((Anchor)app().create().byXPath(Anchor.class, "//button[text()='Send']")).click();

        app().dialogs().handle();
        iFrame();
        ((Anchor)app().create().byXPath(Anchor.class, "//b[text()='Response']")).scrollToVisible();
        TextInput text = (TextInput)app().create().byXPath(TextInput.class, "//div[@id='responseStatus']//following-sibling::b");
        text.validateTextIs("200 OK");
        app().create().byXPath(Anchor.class, "//b[text()='Response Body']").scrollToVisible();
        String queueRecordNum = extractQue();
        System.out.println(queueName + " Queue record " + queueRecordNum + " created successfully");
        return queueRecordNum;
    }

    public String extractQue() throws IOException {
        String jsonString = app().create().byCss(TextInput.class, "pre[class='response-body'] span[class='ng-binding']").getText();


        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonString);

        // Extract the message
        String message = jsonNode.path("result").path("message").asText();

        // Extract only the numeric value
        String numericValue = message.replaceAll("\\D+", "");

        String queRecord = "QUE" + numericValue;
        return queRecord;
    }

    public String extractQue(String jsonString) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonString);

        // Extract the message
        String message = jsonNode.path("result").path("message").asText();

        // Extract only the numeric value
        String numericValue = message.replaceAll("\\D+", "");

        String queRecord = "QUE" + numericValue;
        return queRecord;
    }

    public void openDiscoveryQueue() {
        leftNavigationTable("x_nuvo_cs_discovery_queue.list");
    }

    public void selectFirstRelatedRecord() {
        app().create().byXPath(Anchor.class, "(//label[contains(@for,'check')])[2]").click();
    }

    public void actionsOnSelectedRow(String visibleText) {
        Select sortDropDown = app().create().byXPath(Select.class, "(//span[contains(@id,'x_nuvo_cs_security_events.REL:')]/child::select)[1]");
        sortDropDown.selectByText(visibleText);
    }

    String[] adaptorTypes = {"Wired", "Wi-Fi", "Bluetooth", "Gateway", "Serial"};

    public void validateOptionsForAdaptorType() {
        List<Option> option = app().create().byXPath(Select.class, "//select[@id='x_nuvo_eam_ip_address.adapter_type']").getAllOptions();
        System.out.println(option.toString());
        for (int i = 1; i <= option.size(); i++) {


            if (Objects.equals(option.get(i).toString(), adaptorTypes[i])) {
                System.out.println("The first option " + i + " is correct");
            } else {
                System.out.println(i + " is not matching with the given options");
            }


        }
    }

    String macAddress = "//input[@aria-label='MAC Address']";
    String ipAddress = "//input[@aria-label='IP Address']";
    String asset = "//[@data-name='asset']";
    String SSID = "//input[@aria-label='SSID']";

    public boolean checkMandatory(String locator) {
        String value = app().create().byXPath(Anchor.class, locator).getAttribute("Mandatory");
        return Boolean.parseBoolean(value);
    }

    public void wiredCondition() {
        Assert.assertTrue(checkMandatory(macAddress));
        Assert.assertFalse(checkMandatory(ipAddress));

    }

    public void wificondition() {
        Assert.assertTrue(checkMandatory(macAddress));
        Assert.assertTrue(checkMandatory(asset));
        Assert.assertTrue(checkMandatory(SSID));

    }

    public void bluetoothGatewaySerialCondition() {
        Assert.assertFalse(checkMandatory(ipAddress));
        Assert.assertFalse(checkMandatory(macAddress));
    }

    public void adaptorsTypeConditions() {
        Select option = app().create().byXPath(Select.class, "//select[@id='x_nuvo_eam_ip_address.adapter_type']");
        for (String type : adaptorTypes) {
            option.selectByText(type);
            switch (type) {
                case "Wired":
                    wiredCondition();
                case "Wi-Fi":
                    wificondition();
                case "Bluetooth":
                case "Gateway":
                case "Serial":
                    bluetoothGatewaySerialCondition();
            }


        }

    }

    public boolean getIdentificationValueForMedigate(String tableValue) {
        ArrayList<String> values = new ArrayList<>();
        int count = app().create().allByXPath(Anchor.class, "//p[contains(@id,'table_name')]").size();
        for (int i = 1; i <= count; i++) {
            String value = app().create().byXPath(Anchor.class, "(//p[contains(@id,'table_name')])[" + i + "]").getText();

            values.add(value);
        }
        return values.contains(tableValue);


    }

    public boolean identificationRulesForIs(String type) {
        return app().create().byXPath(Anchor.class, "//a[normalize-space()='" + type + "']/parent::td[@class='vt']/following-sibling::td[contains(text(),'Is')]").isVisible();
    }

    public String getOrderValue() {
        return getFieldValue("Order");
    }

    public int getRowCount() {
        String count = app().create().byXPath(Anchor.class, "((//input[@aria-label='Skip to row'])[2]/following-sibling::span)[2]/child::span[2]").getText();
        return Integer.parseInt(count);
    }

    public String discoveryAsimily(String table_name, String connectionType
            , String ip, String mac, String serialNo) {

        String asimily = "{\n" +
                "    \"source_key\": \"78b2b1db1be4d810ccdcc91e1e4bcb45\",\n" +
                "    \"device_id\": \"7000377477311114334\",\n" +
                "    \"table_name\": \"" + table_name + "\",\n" +
                "    \"parameters\": [\n" +
                "        {\n" +
                "            \"mac_address\": \"" + mac + "\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"ip_address\": [\n" +
                "                {\n" +
                "                    \"address\": \"" + ip + "\",\n" +
                "                    \"type\": \"Static\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"vlan_id\": [\n" +
                "                0,\n" +
                "                1800,\n" +
                "                2912,\n" +
                "                430,\n" +
                "                437,\n" +
                "                408,\n" +
                "                1318,\n" +
                "                410,\n" +
                "                405,\n" +
                "                428,\n" +
                "                407,\n" +
                "                432\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"hostname\": \"Hostname" + serialNo + "\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"mfg\": \"GE Healthcare\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"device_type\": \"Infusion Systems\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"device_model\": \"3M Ranger™ Pressure Infusor Model 90032\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"device_family\": \"[\\\"Imaging Devices\\\",\\\"Medical Devices\\\",\\\"Workstations\\\"]\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"device_master_family\": \"[\\\"Imaging Devices\\\",\\\"Medical Devices\\\",\\\"Workstations\\\"]\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"neighbor_device_types\": \"[\\\"Network Appliance\\\",\\\"IT Workstation\\\",\\\"IT Server\\\"]\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"network_location\": \"00:de:fb:7b:44:42\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"physical_location\": \"vlan_0, 431, 1800\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"connection_type\": \"" + connectionType + "\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"applications\": \"[\\\"chrome 64.0.3282.140\\\",\\\"Microsoft Bits 7.8\\\",\\\"mysql *\\\"]\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"http_host_names\": \"[\\\"dev.virtualearth.net\\\",\\\"enroll.cisco.com\\\",\\\"www.cvent.com\\\"]\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"services\": \"[\\\"VLAN\\\",\\\"arp\\\",\\\"entexthigh\\\",\\\"dhcpv6-client\\\",\\\"dicom\\\",\\\"IPv6\\\",\\\"IPv4\\\",\\\"WLAN\\\"]\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"software_version\": \"70.80.105.036\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"MDS2_present\": \"No\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"transmits_ePHI\": \"true\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"serial_number\": \"" + serialNo + "\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"risk_score\": 9\n" +
                "        },\n" +
                "        {\n" +
                "            \"impact\": {\n" +
                "                \"data\": \"HIGH\",\n" +
                "                \"business\": \"LOW\",\n" +
                "                \"patient\": \"LOW\",\n" +
                "                \"overall\": 5\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"peer_ip_services\": [\n" +
                "                {\n" +
                "                    \"service\": \"string, protocol service name\",\n" +
                "                    \"ports\": [\n" +
                "                        \"555\",\n" +
                "                        \"8080\",\n" +
                "                        \"2343\"\n" +
                "                    ],\n" +
                "                    \"peer_ip_list\": [\n" +
                "                        \"5.5.5.5\",\n" +
                "                        \"80.80.80.80\",\n" +
                "                        \"23.43.23.34\"\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"external_ip_services\": [\n" +
                "                {\n" +
                "                    \"ip_addr\": \"123.34.234.234\",\n" +
                "                    \"service\": \"string, protocol service used with this external IP address\",\n" +
                "                    \"country\": \"USA\",\n" +
                "                    \"organization\": \"AT&T\",\n" +
                "                    \"reputation\": \"Good\",\n" +
                "                    \"whitelist\": \"Yes\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"wireless_parameters\": [\n" +
                "                {\n" +
                "                    \"SSID_List\": [\n" +
                "                        \"network1\",\n" +
                "                        \"wi-fi2\",\n" +
                "                        \"wi-fi3\"\n" +
                "                    ],\n" +
                "                    \"Supported_Rates_Mbps\": [\n" +
                "                        128,\n" +
                "                        64,\n" +
                "                        128\n" +
                "                    ],\n" +
                "                    \"Extended_Supported_Rates_Mbps\": [\n" +
                "                        128,\n" +
                "                        64,\n" +
                "                        128\n" +
                "                    ],\n" +
                "                    \"Max_Tx_Power_dBm\": 20,\n" +
                "                    \"Min_Tx_Power_dBm\": 5,\n" +
                "                    \"Supported_Channels\": [],\n" +
                "                    \"High_Throughput_Support\": \"\",\n" +
                "                    \"40MHz_Support\": \"Yes\",\n" +
                "                    \"Max_Rx_Data_Rate_Mbps\": 128,\n" +
                "                    \"Tx_STBC_Support\": \"No\",\n" +
                "                    \"Rx STBC Support\": \"No\",\n" +
                "                    \"Group_Cipher_Suite\": [\n" +
                "                        \"string, WLAN Cipher\"\n" +
                "                    ],\n" +
                "                    \"Pairwise_Cipher_Suite_List\": [\n" +
                "                        \"string, WLAN Cipher\"\n" +
                "                    ],\n" +
                "                    \"Akm_Suite_List\": [\n" +
                "                        \"string, AKM Suite\"\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"high_risk_cves\": [\n" +
                "                {\n" +
                "                    \"cve_id\": \"CVE-2015-2222\",\n" +
                "                    \"cve_score\": 9.2,\n" +
                "                    \"recommendation\": \"Block ports corresponding to RDP on device\",\n" +
                "                    \"description\": \"The Remote Desktop Protocol (RDP) server service in Microsoft Windows 7 SP1, Windows 8, and Windows Server 2012 allows remote attackers to execute arbitrary code via a series of crafted packets, aka Remote Desktop Protocol (RDP) Remote Code Execution Vulnerability.\",\n" +
                "                    \"exploit_vector\": \"string, CVE exploit vector\",\n" +
                "                    \"configuration_trigger\": \"string Trigger for CVE based on device configuration\",\n" +
                "                    \"work_order_priority\": \"HIGH\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cve_id\": \"CVE-2012-0002\",\n" +
                "                    \"cve_score\": 9.2,\n" +
                "                    \"recommendation\": \"Block ports corresponding to RDP on device\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"cve_id\": \"CVE-2010-0020\",\n" +
                "                    \"cve_score\": 7.5,\n" +
                "                    \"recommendation\": \"Implement strong access controls for device to ensure only authorized personnel can access the device\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"os\": \"windows_embedded_7\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"os_version\": \"unknown\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"impact\": [\n" +
                "                {\n" +
                "                    \"overall\": 7,\n" +
                "                    \"patient\": \"LOW\",\n" +
                "                    \"data\": \"HIGH\",\n" +
                "                    \"business\": \"MEDIUM\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ],\n" +
                "    \"payload\": \"\"\n" +
                "}";
        return asimily;
    }

    public String discoveryCyberMDX(String table_name, String connectionType
            , String ip, String mac, String serialNo, String thirdPartyId) {
        String payload = "{\n" +
                "  \"source_key\": \"f4b2b1db1be4d810ccdcc91e1e4bcb46\",\n" +
                "  \"device_id\": \""+serialNo+"\",\n" +
                "  \"table_name\": \"" + table_name + "\",\n" +
                "  \"parameters\": [\n" +
                "    {\n" +
                "      \"third_party_id\": \"" + thirdPartyId + "\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"app_version\": \"Ver:13.41.00.002 2011/09/16\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"first_seen\": \"1.567953647255E9\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"hostname\": \"Hostname" + serialNo + "\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"last_seen\": \"1.58791896941E9\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"location\": \"Hospital1, Building 7, Floor 3 Room 3\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"manufacturer\": \"Rauland\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"model\": \"" + serialNo + "\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"os\": \"Hospira Proprietary\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"serial_number\": \"" + serialNo + "\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"Infusion Pump\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"connection_encryption_type\": \"WPA2-PSK (TKIP)\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"connection_type\": \"" + connectionType + "\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"ip\": \"" + ip + "\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"mac\": \"" + mac + "\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"switch/access_point\": \"chirestricted(6c-99-89-f3-f4-70)\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"vlan\": \"200\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"link\": \"https://ui.cybermdx.app:33443/Assets/5cc697ba1c1e743bfcf688b8\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"payload\": \"\"\n" +
                "}";
        return payload;
    }

    public String discoveryCynerio(String table_name, String connectionType
            , String ip, String mac, String serialNo, String thirdPartyId) {
        String payload = "{\n" +
                "  \"source_key\": \"b8b2b1db1be4d810ccdcc91e1e4bcb46\",\n" +
                "  \"device_id\": \"7257488\",\n" +
                "  \"table_name\": \"" + table_name + "\",\n" +
                "  \"parameters\": [\n" +
                "    {\n" +
                "      \"category\": \"Device\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"third_party_id\": \"" + thirdPartyId + "\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"connection_type\": \"" + connectionType + "\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"domain_member\": \"false\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"first_seen\": \"2019-12-13T05:05:29.384648+00:00\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"hardware_version\": \"4.32\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"fa3a56a3-ab8c-433c-a631-2abf9870e340\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"last_seen\": \"2019-12-16T12:58:47.152832+00:00\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"model\": \"ACCU-CHEK Inform II1\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"names\": [{\"source\":\"POCT1\",\"value\":\"00-60-19-03-14-21-15-80\"}]\n" +
                "    },\n" +
                "    {\n" +
                "      \"os\": \"Linux\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"phi\": true\n" +
                "    },\n" +
                "    {\n" +
                "      \"serial_number\": \"" + serialNo + "\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"site\": \"Main\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"software_version\": \"04.01.04\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"status\": \"ONLINE\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"tags\": {\"network.ip_allocation\":\"dynamic\",\"network.domain_member\":true,\"os.windows_update\":true, \"phi_details\":\"test\"}\n" +
                "    },\n" +
                "    {\n" +
                "      \"type_display_name\": \"Glucometer\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"vendor\": \"Roche\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"dynamic_ip\": true\n" +
                "    },\n" +
                "    {\n" +
                "      \"ip\": \"" + ip + "\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"mac\": \"" + mac + "\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"vlan\": \"72\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"payload\": \"\"\n" +
                "}";
        return payload;
    }

    public String discoveryMedigate(String table_name, String connectionType
            , String ip, String mac, String serialNo, String thirdPartyId) {
        String payload = "{\n" +
                "    \"source_key\": \"7cb2b1db1be4d810ccdcc91e1e4bcb46\",\n" +
                "    \"device_id\": \"312383331211234\",\n" +
                "    \"table_name\": \"" + table_name + "\",\n" +
                "    \"parameters\": [\n" +
                "        {\n" +
                "            \"device_type\": \"Infusion Pump\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"device_id\": \"567890oiuytrtghjki876tr\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"third_party_id\": \"" + thirdPartyId + "\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"serial\": \"" + serialNo + "\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"hostname\": \"Hostname" + serialNo + "\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"ip_addresses\": \"" + ip + "\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"mac_addresses\": \"" + mac + "\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"risk_score\": \"2\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"is_online\": \"TRUE\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"manufacturer\": \"Alaris\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"model\": \"8015 PC Unit\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"category\": \"Medical\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sub_category\": \"Patient Devices\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"vendor\": \"Philips\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"first_seen\": \"2019-11-18T12:00:18.811418+00:00\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"last_seen\": \"2019-11-22T12:00:12.811418+00:00\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"last_seen_on_switch\": \"2019-11-22T12:00:12.811418+00:00\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"hw_version\": \"23F\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"is_component\": \"false\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"location\": \"PCU\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"os_name\": \"Proprietary\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"os_revision\": \"SP2\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"os_version\": \"Enea OSE\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"parent_id\": \"233132ec-8f7d-4e5f-8dba-60eea66e7bb0\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"protocols\": [\n" +
                "                \"Unity\",\n" +
                "                \"RWHAT\"\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"sw_version\": \"32.b\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"connection_type\": \"" + connectionType + "\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"ip_assignment\": \"DHCP\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"vlan\": \"880\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"vlan_name\": \"floor1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"vlan_desc\": \"Radiology floor 1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"switch_port\": \"Ge/0/1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"switch_ip\": \"1.2.3.4\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"switch_name\": \"OfficeSwitch\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"bssid\": \"00:c0:58:70:e4:a0\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"last_seen\": \"2019-11-18T11:28:19.380109+00:00\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"ssid\": \"MEDNET\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"ap_name\": \"CO01080010\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"ap_location\": \"Columbia -> Building 2 -> Floor 9\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fda_class\": \"1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"kingdom\": \"Medical\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"phi\": \"Stored & Transmitted\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"equipment_class\": \"Physiological Monitoring\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"consequence_of_failure\": \"Inappropriate Therapy or Misdiagnosis\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"wifi_last_seen\": \"2021-02-23 08:31:00.702468+00:00\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"payload\": \"\"\n" +
                "}";
        return payload;
    }

    public String discoveryOrdr(String table_name
            , String ip, String mac, String serialNo, String thirdPartyId) {
        String payload = "{\n" +
                "    \"source_key\": \"f0b2b1db1be4d810ccdcc91e1e4bcb47\",\n" +
                "    \"device_id\": \"3d43889087\",\n" +
                "    \"table_name\": \"" + table_name + "\",\n" +
                "    \"parameters\": [\n" +
                "        {\n" +
                "            \"third_party_id\": \"" + thirdPartyId + "\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"ipAddress\": \"" + ip + "\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"macAddress\": \"" + mac + "\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"serialNumber\": \"" + serialNo + "\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"model\": \"P3214\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"hostname\": \"Hostname" + serialNo + "\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"deviceDescription\": \"Ultrasound\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"firstSeen\": \"15886803599123\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isActive\": \"true\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"behaviorState\": \"NORMAL\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"lastSeen\": \"1586803599321\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"manufacturer\": \"GE Healthscare\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"riskScore\": \"0\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"vlan\": \"VLAN0204\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"osType\": \"Linux\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"osVersion\": \"3.29\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"swVersion\": \"L.01.09\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"ssid\": \"cloudpost\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"accessPoint\": \"94:B8:02:7B:A9:6A\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"category\": \"Facility Devices\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"categoryGuid\": \"DG-Facility Devices\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"alarmCount\": \"0\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"interface\":\"NA\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"networkEquipmentHostName\":\"meraki:MX84:Q2PN-FS29-LAH5\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"payload\": \"Ordr Data\"\n" +
                "}";
        return payload;
    }

    public String discoveryPaloAlto(String table_name
            , String ip, String mac, String serialNo, String thirdPartyId) {
        String payload = "{\n" +
                "    \"source_key\": \"b4b2b1db1be4d810ccdcc91e1e4bcb47\",\n" +
                "    \"device_id\": \"3d44f85gtt85336g91312\",\n" +
                "    \"table_name\": \"" + table_name + "\",\n" +
                "    \"parameters\": [\n" +
                "        {\n" +
                "            \"mac_address\": \"" + mac + "\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"ip\": \"" + ip + "\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"third_party_id\": \"" + thirdPartyId + "\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"hostname\": \"Hostname" + serialNo + "\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"Serial Number\": \"" + serialNo + "\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"uid\": \"95:7b:f3:21:bd:84\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"Subnet\": \"212.45.65.233\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"Vlan\": \"1288\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"DHCP\": \"Yes\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"Risk Score\": \"25\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"Risk Level\": \"Low\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"Last Activity\": \"2020-10-29 17:21:56.792000\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"Wire/Wireless\": \"wireless\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"Profile\": \"DICOM-Imager-X-Ray\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"Category\": \"X-Ray Machine\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"OS Group\": \"Android\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"Make\": \"Crestron\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"Device Details Link\": \"https://testing-soho.zingbox.com/detail/device/98:7b:f3:21:bd:84\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"vendor\": \"GE\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"Model\": \"OEC 9800\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"Site Name\": \"St. Vincent Carmel Hospital\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"event_type\": \"Asset Identification\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"payload\": \"Discovery Event\"\n" +
                "}";
        return payload;
    }

    public String discoveryMedsec(String table_name
            , String ip, String mac, String serialNo, String thirdPartyId) {
        String payload = "{\n" +
                "  \"source_key\": \"fda5113f1b87d810375b84ccdd4bcbe3\",\n" +
                "  \"device_id\": \"60be4d35325123331232221222221\",  \n" +
                "  \"table_name\": \"" + table_name + "\",\n" +
                "  \"parameters\": [\n" +
                "    {\n" +
                "      \"mac\": \"" + mac + "\"\n" +
                "    },\n" +
                "      {\n" +
                "      \"name\": \"MRC4027321\"\n" +
                "    },\n" +
                "     {\n" +
                "      \"hostname\": \"Hostname" + serialNo + "\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"third_party_id\": \"" + thirdPartyId + "\"  \n" +
                "    },\n" +
                "    {\n" +
                "      \"vendor\": \"GE\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"modality\": \"Ultrasound\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"operating_system\": \"Linux\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"software_version\": \"R4.3.0\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"timestamp\": \"1624039466E9\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"ip\": \"" + ip + "\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"old_ip\": \"1.2.3.4\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"serial_number\": \"" + serialNo + "\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"identity\": \"VenueGO\"\n" +
                "    }], \n" +
                "\n" +
                "  \"payload\": \"new_device / missing_device / ip_changed\"\n" +
                "}";
        return payload;
    }

    public String discoveryArmis(String table_name
            , String ip, String mac, String serialNo, String thirdPartyId) {
        return "{\n" +
                "  \"source_key\": \"849a998bdb3210101db2278115961956\",\n" +
                "  \"device_id\": \"tenant_"+serialNo+"\",\n" +
                "  \"table_name\": \""+table_name+"\",\n" +
                "  \"parameters\": [\n" +
                "    {\n" +
                "      \"third_party_id\": \""+thirdPartyId+"\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"MRC402731\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"networkInterface\": [\n" +
                "        {\n" +
                "          \"ipv4\": \""+ip+"\",\n" +
                "          \"ipv6\": \"fe80::a650:46ff:fe66:70af\",\n" +
                "          \"macAddress\": \""+mac+"\",\n" +
                "          \"name\": \"Hostname"+serialNo+"\",\n" +
                "          \"type\": \"Ethernet / Wifi / Bluetooth / Serial / Virtual\",\n" +
                "          \"vlans\": [\n" +
                "            1, 5, 6\n" +
                "          ]\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"publicIp\": \"52.0.71.49\"\n" +
                "    },\n" +
                "    \n" +
                "    {\n" +
                "      \"serialNumber\": \""+serialNo+"\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"udid\": \"002ebf12-a125-5ddf-a739-67c3c5d20177\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"phoneNumber\": \"+13479876523\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"imei\": \"35-209900-176148-1\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"meid\": \"352099001761481\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"user\": \"someone@mycompany.com\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"biosVendor\": \"HP\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"biosVersion\": \"I31\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"biosType\": \"UEFI\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"operatingSystem\": \"Microsoft Windows 10 Pro\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"operatingSystemVersion\": \"10.0.17763\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"osBuildNumber\": \"7601\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"firmwareVersion\": \"12.2(25)SEE4\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"warrantyExpiryDate\": \"2020-09-25T13:51:07.155154+00:00\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"domainName\": \"discover.armis.com\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"X-Rays\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"category\": \"Medical Diagnostic\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"model\": \"Mini C-Arm\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"manufacturer\": \"OrthoScan Inc.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fdaRecall\": [\n" +
                "        {\n" +
                "          \"text\": \"FDA Recall for Hospira Plum A+ and Plum A+3 Due to an Alarm Error\",\n" +
                "          \"href\": \"http://wayback.archive-it.org/7993/20170112083806/http://www.fda.gov/MedicalDevices/Safety/ListofRecalls/ucm436770.htm\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"mds2\": [\n" +
                "          \"Q.10-3 - The user cannot redefine manufacturer-installed AV\",\n" +
                "          \"Q.10-2 - The user cannot install/update AV software\",\n" +
                "          \"Q.10-1.3 - The user can independently repair the device after a threat is detected\",\n" +
                "          \"Q.10-1.2 - AV's notification are disabled on user interface\",\n" +
                "          \"Q.10-1.1 - The user cannot independently re-configure AV's settings\",\n" +
                "          \"Q.10-1 - The device doesn't support internal AV\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"deviceLocation\": \"server room\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"hardwareVersion\": \"0355a\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"aeTitle\": \"SERVER1\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"processorArchitecture\": \"x86_64\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"firstSeen\": \"2020-09-25T13:51:07.155154+00:00\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"lastSeen\": \"2020-09-25T13:51:07.155154+00:00\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"riskLevel\": 2\n" +
                "    },\n" +
                "    {\n" +
                "      \"site\": {\n" +
                "        \"location\": \"Palo Alot\",\n" +
                "        \"name\": \"Palo Alto Offices\"\n" +
                "      }\n" +
                "    }\n" +
                "  ],\n" +
                "  \"payload\": \"devices\"\n" +
                "}";

    }

    public String discoveryPartnerAllNew(String partner, String table_name, String connectionType
            , String ip, String mac, String serialNo, String thirdPartyId) {
        switch (partner) {
            case "asimily":
                 return discoveryAsimily(table_name, connectionType, ip, mac, serialNo);

            case "cyberMDX":
                return discoveryCyberMDX(table_name, connectionType, ip, mac, serialNo, thirdPartyId);

            case "cynerio":
                return discoveryCynerio(table_name, connectionType, ip, mac, serialNo, thirdPartyId);

            case "medigate":
                return discoveryMedigate(table_name, connectionType, ip, mac, serialNo, thirdPartyId);
            case "ordr":
                return discoveryOrdr(table_name, ip, mac, serialNo, thirdPartyId);
            case "paloAlto":
                return discoveryPaloAlto(table_name, ip, mac, serialNo, thirdPartyId);
            case "medsec":
                return discoveryMedsec(table_name, ip, mac, serialNo, thirdPartyId);
            case "armis":
                return discoveryArmis(table_name, ip, mac, serialNo, thirdPartyId);
            default:
                System.out.println("Invalid entry for tab partner");
                break;

        }
        return partner;
    }
}

