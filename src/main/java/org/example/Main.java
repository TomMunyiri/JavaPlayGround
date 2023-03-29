package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String mini = "2023-03-29 11:35 AM|CR|5|#Send Money to Tom Mwangi Munyiri - 75***91#Receive Money from WAIBALA WAIBALA - 72***83|100000100063|FT~2023-03-28 16:07 PM|DR|5|100000049809 P2P Waibala  Waibala - 72***83|100000100056|FT~2023-03-28 15:30 PM|CR|5|100000049745 P2P Tom Mwangi Munyiri - 75***91|100000100054|FT~";
        System.out.println(formatMiniStatement(mini));
    }

    public static String formatMiniStatement(String mini) {
        JSONArray miniArray = new JSONArray();
        String[] miniStrings = mini.split(Pattern.quote("~"));
        for (String miniString : miniStrings) {
            JSONObject miniStatement = new JSONObject();
            String[] miniItems = miniString.split(Pattern.quote("|"));
            miniStatement.put("date", miniItems[0]);
            miniStatement.put("naration", miniItems[3]);
            miniStatement.put("type", miniItems[1]);
            miniStatement.put("amount", miniItems[2]);
            miniStatement.put("transRef", miniItems[4]);
            String transactionType = miniItems[5];
            if ("FT".equalsIgnoreCase(transactionType)) {
                String drCr = miniItems[1];
                String narration = miniItems[3];
                String[] narrationStrings = narration.split(Pattern.quote("#"));
                try {
                    if ("CR".equalsIgnoreCase(drCr)) {
                        miniStatement.put("naration", narrationStrings[2]);
                    } else if ("DR".equalsIgnoreCase(drCr)) {
                        miniStatement.put("naration", narrationStrings[1]);
                    }
                } catch (Exception e) {
                    miniStatement.put("naration", miniItems[3]);
                }
            }
            miniArray.put(miniStatement);
        }
        return miniArray.toString();
    }
}