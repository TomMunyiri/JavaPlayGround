package org.example;

import java.util.HashMap;

public class Strings {
    public static void main(String[] args) {
        /*String accountNo = "6777557691";
        System.out.println("Sub string is: " + accountNo.substring(3));*/
        HashMap<String, String> requesJson = new HashMap<>();
        //requesJson.put("idnumber","3267327823");
        String idNumber = requesJson.getOrDefault("idnumber", "").trim();
        System.out.println("ID Number is: "+idNumber);
    }
}
