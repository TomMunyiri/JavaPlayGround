package org.example;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Strings {
    public static void main(String[] args) {
        /*String accountNo = "6777557691";
        System.out.println("Sub string is: " + accountNo.substring(3));*/
        HashMap<String, String> requesJson = new HashMap<>();
        //requesJson.put("idnumber","3267327823");
        String idNumber = requesJson.getOrDefault("idnumber", "").trim();
        //System.out.println("ID Number is: "+idNumber);
        //containsString();
        //removeBeforeAfter();
        String agentId = null;
        /*if(agentId.isEmpty()){
            System.out.println("is empty");
        }else{
            System.out.println("is not empty");
        }*/
        splitField54();
        System.out.println(contains("MIRINDA 300ML"));
        System.out.println(measureUnit("TRAD-MF-01", ""));
        removeS();
        logRequest("agentId=900424&charges=false&installedVersion=v1.5.4&jwtToken=&password=0000&requestDest=ABC&requestOrigin=MPOS&requestTime=2023-10-20 15:37:37&setLanguage=ENGLISH&deviceId=20D86C94CBF2B146&latitude=0.321493&longitude=32.5773446&osVersion=31");
    }

    private static void splitField54(){
        String field54 = "Fredson Fenua|11001085";
        String[] parts = field54.split("\\|");

        if (parts.length > 0) {
            String name = parts[0];
            System.out.println(name); // This will print "Fredson Fenua"
        } else {
            // Handle the case where there is no '|' character in the string
            System.out.println("Customer");
        }
    }
    private static void removeS() {
        String originalString = "6777557691";

// Check if the string has at least 3 characters
        if (originalString.length() >= 3) {
            String modifiedString = originalString.substring(0, originalString.length() - 3);
            System.out.println("Modified string: " + modifiedString);
        } else {
            System.out.println("The string is too short to remove 3 characters.");
        }
    }

    private static void logRequest(String params) {
        try {
            // Split the query string into key-value pairs
            String[] pairs = params.split("&");

            // Create a JSONObject to store the key-value pairs
            JSONObject jsonObject = new JSONObject();

            for (String pair : pairs) {
                String[] keyValue = pair.split("=");
                if (keyValue.length == 2) {
                    try {
                        // Add the key-value pair to the JSONObject
                        jsonObject.put(keyValue[0], keyValue[1]);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            // Print the `JSONObject` object to the console.
            System.out.println(jsonObject.toString());
        } catch (JSONException e) {
            //Log.d(TAG, "logRequest: " + e.getLocalizedMessage());
        }
    }

    private static String contains(String productCode) {
        String caseType = "";
        if (productCode.contains(" WATER-500ML X 15") ||
                productCode.contains("PET:NIVANA WATER-1500ML")) {
            caseType = "BX-Box 21 to";
        } else if (productCode.contains("300ML")) {
            caseType = "CS-Case";
        } else {
            caseType = "CT-Carton";
        }

        return caseType;
    }

    public static String measureUnit(String prodCode, String cdCode) {
        String measure = "CT";

        List<String> cases = Arrays.asList("TRA-MD-01",
                //"TRA-MD-04",
                "TRA-MF-01",
                "TRA-MF-04",
                "TRA-MG-01",
                "TRA-MO-01",
                "TRA-MP-01",
                "TRA-PC-01",
                "TRA-PC-04",
                "TRA-TN-01",
                //"TRA-WS-44",
                "TRAD-MD-01",
                "TRAD-MF-01",
                "TRAD-PC-01");
        if (cases.contains(prodCode)) {
            measure = "CS";
        }
        if (cdCode.contentEquals("CBL-CD-259") || cdCode.contentEquals("CBL-CD-259")) {
            measure = "CR";
        }
        return measure;
    }

    private static void containsString() {
        String jsonString = "{\"message\":\"data set for messaging\",\"status\":\"200\",\"data\":\"[{\\\"RESP_DESC\\\":\\\"Contact(s) added successfully\\\",\\\"RESP_CODE\\\":\\\"00\\\"}]\"}";
        JSONObject jsonObject = new JSONObject(jsonString);
        String dataObj = String.valueOf(jsonObject.getString("data"));
        System.out.println("jsonOBJ: " + dataObj);
        JSONArray data_Array = new JSONArray(dataObj);
        JSONObject data = data_Array.getJSONObject(0);
        String respCode = data.getString("RESP_CODE");
        String respDesc = data.has("RESP_DESC") ? data.getString("RESP_DESC") : "No Desc";
        System.out.println("Resp Code: " + respCode);
        System.out.println("Resp Desc: " + respDesc);
    }

    private static void removeBeforeAfter() {
        String myString = "404404003001";
        String newString = "";
        newString = myString.substring(3, myString.length() - 3);
        System.out.println(newString);
    }
}
