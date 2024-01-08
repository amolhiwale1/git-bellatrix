//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Test_Automation;

import java.io.IOException;
import java.util.Random;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import solutions.bellatrix.web.components.Anchor;
import solutions.bellatrix.web.components.Select;
import solutions.bellatrix.web.components.TextInput;

public class OCS_Main extends MapPolaris {

    public String randomString() {
        StringBuilder sb = new StringBuilder();
        String ch = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        for(int i = 0; (double)i < Math.random() * 100.0; ++i) {
            int index = (int)(Math.random() * (double)ch.length());
            sb.append(ch.charAt(index));
        }

        return sb.toString();
    }

    public String randomSerial() {
        String str = "";
        String ch = "123456789";
        int len = ch.length();

        for(int i = 0; i < 10; ++i) {
            str = str + ch.charAt((int)Math.floor(Math.random() * (double)len));
        }

        return str;
    }

    public String randomHostName() {
        String str = "";
        String ch = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int len = ch.length();

        for(int i = 0; i < 8; ++i) {
            str = str + ch.charAt((int)Math.floor(Math.random() * (double)len));
        }

        return str;
    }

    public String randomMacId() {
        String str = "";
        String ch = "abcdef0123456789";
        int len = ch.length();

        for(int i = 0; i < 6; ++i) {
            for(int j = 0; j < 2; ++j) {
                str = str + ch.charAt((int)Math.floor(Math.random() * (double)len));
            }

            if (i != 5) {
                str = str + ":";
            }
        }

        return str;
    }

    public String randomip() {
        StringBuilder ip = new StringBuilder("xx.xx.xx.xx");

        for(int i = 0; i < 11; ++i) {
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
                ip_1 = randomip();
                mac_1 = randomMacId();
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
                discovery_paloAlto = "{\r\n    \"source_key\": \"f0b2b1db1be4d810ccdcc91e1e4bcb47\",\r\n    \"device_id\": \"" + deviceId_1 + "\",\r\n    \"table_name\": \"" + table_name + "\",\r\n    \"parameters\": [\r\n        {\r\n            \"third_party_id\": \"" + thirdParty_1 + "\"\r\n        },\r\n        {\r\n            \"ipAddress\": \"" + ip_1 + "\"\r\n        },\r\n        {\r\n            \"macAddress\": \"" + mac_1 + "\"\r\n        },\r\n        {\r\n            \"serial_number\": \"" + serialNo_1 + "\"\r\n        },\r\n        {\r\n            \"model\": \" P3214\"\r\n        },\r\n        {\r\n            \"deviceDescription\": \"Ultrasound\"\r\n        },\r\n        {\r\n            \"firstSeen\": \"15886803599123\"\r\n        },\r\n        {\r\n            \"isActive\": \"true\"\r\n        },\r\n        {\r\n            \"behaviorState\": \"NORMAL\"\r\n        },\r\n        {\r\n            \"lastSeen\": \"1586803599321\"\r\n        },\r\n        {\r\n            \"manufacturer\": \"GE Healthscare\"\r\n        },\r\n        {\r\n            \"riskScore\": \"0\"\r\n        },\r\n        {\r\n            \"vlan\": \"VLAN0204\"\r\n        },\r\n        {\r\n            \"osType\": \"Linux\"\r\n        },\r\n        {\r\n            \"osVersion\": \"3.29\"\r\n        },\r\n        {\r\n            \"swVersion\": \"L.01.09\"\r\n        },\r\n        {\r\n            \"ssid\": \"cloudpost\"\r\n        },\r\n        {\r\n            \"accessPoint\": \"94:B8:02:7B:A9:6A\"\r\n        },\r\n        {\r\n            \"category\": \"Facility Devices\"\r\n        },\r\n        {\r\n            \"categoryGuid\": \"DG-Facility Devices\"\r\n        },\r\n        {\r\n            \"alarmCount\": \"0\"\r\n        },\r\n        {\r\n            \"interface\":\"NA\"\r\n        },\r\n        {\r\n            \"networkEquipmentHostName\":\"" + discovery_cynerio + "\"\r\n        }\r\n    ],\r\n    \"payload\": \"Ordr Data\"\r\n}";
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

    public String getQueueRecordNum(String queue) {
        TextInput s = app().create().byXPath(TextInput.class, "//pre[@class='response-body']/span");
        String num;
        if (queue == "Discovery") {
            num = s.toString().substring(45, 56);
        } else {
            num = s.toString().substring(48, 59);
        }

        return num;
    }

    public void scrollRawDataBody(){
        app().create().byXPath(Anchor.class, "//button[normalize-space()='Add header']").scrollToVisible();
    }
    public void clickRawDataBody()  {

        app().create().byXPath(Anchor.class,"//a[normalize-space()='Raw']").waitToBe();
        app().create().byXPath(Anchor.class, "//a[normalize-space()='Raw']").click();
        app().create().byXPath(Anchor.class, "//a[normalize-space()='Raw']").click();
    }

    public void setRawDataBody(String body) {
        app().create().byXPath(Anchor.class,"//textarea[@id='post_body_ta']").waitToBe();
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
}
