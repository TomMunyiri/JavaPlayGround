package org.example;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JSONPlay {
    public static void main(String[] args) {
        String jsonString = "[{\"MIN\":5,\"MAX\":\"7000000\",\"F100\":\"FLOAT_PULL\",\"F3\":\"400000\"},{\"MIN\":5,\"MAX\":\"7000000\",\"F100\":\"FLOAT_PUSH\",\"F3\":\"400000\"}]";
        //convertStringToJSONArray(jsonString);
        convertToHashMap();
        convertJSONArrayToString();
    }

    private static void convertJSONArrayToString() {
        String jsonString = "{\n" +
                "    \"RESP_DESC\": \"Success\",\n" +
                "    \"LOAN_ACCOUNT\": 0,\n" +
                "    \"CAPTURE_PEP_INFORMATION\": 0,\n" +
                "    \"LOYALITY_ACTUAL_BALANCE\": \"810\",\n" +
                "    \"ACTIVE\": 1,\n" +
                "    \"POWER_STATEMENT\": [\n" +
                "        {\n" +
                "            \"VOUCHER\": \"65207286677382645167\",\n" +
                "            \"PHONE_NO\": 6777557691\n" +
                "        },\n" +
                "        {\n" +
                "            \"VOUCHER\": \"27074260738702187986\",\n" +
                "            \"PHONE_NO\": 6777557691\n" +
                "        },\n" +
                "        {\n" +
                "            \"VOUCHER\": \"08499351427661190288\",\n" +
                "            \"PHONE_NO\": 6777557691\n" +
                "        }\n" +
                "    ],\n" +
                "    \"LAST_NAME\": \"Korir\",\n" +
                "    \"LANG\": \"en\",\n" +
                "    \"FIRST_NAME\": \"Benedict\",\n" +
                "    \"IS_MERCHANT\": 0,\n" +
                "    \"SECOND_NAME\": \"\",\n" +
                "    \"DEVICE_CHANGE\": 0,\n" +
                "    \"IS_SECONDARY_WALLET\": 0,\n" +
                "    \"CUG_NAME\": \"N/A\",\n" +
                "    \"EMAIL_ADDRESS\": \"null\",\n" +
                "    \"WATER_STATEMENT\": [\n" +
                "        {\n" +
                "            \"VOUCHER\": \"55316181714829431970\",\n" +
                "            \"PHONE_NO\": 6777557691\n" +
                "        },\n" +
                "        {\n" +
                "            \"VOUCHER\": \"37971611421767359260\",\n" +
                "            \"PHONE_NO\": 6777557691\n" +
                "        }\n" +
                "    ],\n" +
                "    \"AVAILABLE_BALANCE\": \"196.3\",\n" +
                "    \"ISLEAN\": 0,\n" +
                "    \"GENDER\": \"M\",\n" +
                "    \"COMPLETE_USSD_REGISTRATION\": 0,\n" +
                "    \"DATE_OF_BIRTH\": \"01-DEC-70\",\n" +
                "    \"TRIALS\": 0,\n" +
                "    \"PARTIAL_REGISTRATION\": 0,\n" +
                "    \"RESP_CODE\": \"00\",\n" +
                "    \"LINKED_ACCOUNTS\": [],\n" +
                "    \"ACTUAL_BALANCE\": \"207.3\",\n" +
                "    \"MWALLET_ACCOUNT\": \"6777162525001\",\n" +
                "    \"LOYALITY_POINT_BALANCE\": \"40.5\",\n" +
                "    \"AGENT_CODE\": \"\",\n" +
                "    \"ALTERNATE_PHONENUMBER\": \"\",\n" +
                "    \"LOYALITY_ACCOUNT\": \"2077557691007\",\n" +
                "    \"IN_CUG\": 0,\n" +
                "    \"PIN\": \"14ef102cd9f8bf5119c96d26d6ea64c6f0401f551a4e417107df9116c325b519\",\n" +
                "    \"CUSTOMER_NAME\": \"Benedict Korir\",\n" +
                "    \"CHANNEL\": \"USSD\",\n" +
                "    \"CUG_ACCEPTED\": 0,\n" +
                "    \"ONSCREEN_MESSAGE\": \"\",\n" +
                "    \"REFERRAL_CODE\": \"RFB02H\",\n" +
                "    \"LINKED_PLASTIC_CARDS\": [],\n" +
                "    \"LINKED_CARDS\": [],\n" +
                "    \"FIRST_LOGIN\": 0,\n" +
                "    \"OCCUPATION\": \"\",\n" +
                "    \"IDENTIFICATION_ID\": \"H545819\",\n" +
                "    \"PHONE_NUMBER\": \"6777557691\",\n" +
                "    \"REQUIRED_SECURITY_QUESTIONS\": 1,\n" +
                "    \"IS_AGENT\": 0,\n" +
                "    \"LOYALITY_AVAILABLE_BALANCE\": \"810\"\n" +
                "}";
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray solomonPowerStatementArray = jsonObject.has("POWER_STATEMENT") ? jsonObject.getJSONArray("POWER_STATEMENT") : new JSONArray();
        System.out.println("Power Statement: "+solomonPowerStatementArray.toString());
    }

    public static void convertStringToJSONArray(String jsonString) {
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            System.out.println("Length: " + jsonArray.length());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void convertToHashMap() {
        String inputData = "{MTI=0200, channel=MOBILE, destination=xml, field39=00, source=MOBILE, mode=online, field66=, field67=, field65=1425538, field26=APP, field48=Meter number lookup is Successful, field49=SBD, field24=MM, field68=Bill presentment for SOLOMON_POWER_PRESENTMENT, field69=, validationStatus=, direction=request, field127={MeterNumber: 07048787894,InitialAmount: 150.56,ConsumerAccount:C70550000,MinimumVendAmount: 5.71,Owing: 150.56,ConsumerFirstName:BEN,ConsumerSurname:HARRY\n" +
                "    }, field126=Customer Test 2, field102=6777557691001, field100=SOLOMON_POWER_PRESENTMENT, field121=6777557691, field120=6777557691, field78=, field0=0200, field32=APP, field54=, field37=100000106640, field38=100000094645, service=Bills, field57=100000094645, field3=180000, field2=6777557691, field74=SOLOMON_POWER_PRESENTMENT, field4=17\n" +
                "}";

        // Remove curly braces and split into key-value pairs
        String[] pairs = inputData.substring(1, inputData.length() - 1).split(", ");

        // Create a HashMap to store the key-value pairs
        Map<String, String> hashMap = new HashMap<>();

        // Iterate through the pairs, split into key and value, and put into the HashMap
        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            if (keyValue.length == 2) {
                hashMap.put(keyValue[0], keyValue[1]);
            }
        }

        String field127 = hashMap.get("field127");

        String field39 = "";
        if (hashMap.containsKey("field39")) {
            field39 = hashMap.get("field39").toString();
        }

        System.out.println(field127);
        System.out.println(hashMap);
        System.out.println(field39);
        try {
            // Create a JSONObject
            JSONObject jsonObject = new JSONObject(field127);

            // Print the JSONObject
            System.out.println(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
