package org.example;

import org.json.JSONArray;
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
        String agentId=null;
        if(agentId.isEmpty()){
            System.out.println("is empty");
        }else{
            System.out.println("is not empty");
        }
        System.out.println(contains("MIRINDA 300ML"));
        System.out.println(measureUnit("TRAD-MF-01", ""));
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
