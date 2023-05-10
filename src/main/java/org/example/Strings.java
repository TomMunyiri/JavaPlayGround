package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class Strings {
    public static void main(String[] args) {
        /*String accountNo = "6777557691";
        System.out.println("Sub string is: " + accountNo.substring(3));*/
        HashMap<String, String> requesJson = new HashMap<>();
        //requesJson.put("idnumber","3267327823");
        String idNumber = requesJson.getOrDefault("idnumber", "").trim();
        //System.out.println("ID Number is: "+idNumber);
        containsString();
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
}
