package org.example;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DatePlay {

    private static final Map<String, String> monthAbbreviations = new HashMap<>();

    static {
        monthAbbreviations.put("JAN", "01");
        monthAbbreviations.put("FEB", "02");
        monthAbbreviations.put("MAR", "03");
        monthAbbreviations.put("APR", "04");
        monthAbbreviations.put("MAY", "05");
        monthAbbreviations.put("JUN", "06");
        monthAbbreviations.put("JUL", "07");
        monthAbbreviations.put("AUG", "08");
        monthAbbreviations.put("SEP", "09");
        monthAbbreviations.put("OCT", "10");
        monthAbbreviations.put("NOV", "11");
        monthAbbreviations.put("DEC", "12");
    }
    public static String calculateAge(String dateString) {
        // Convert month abbreviation to numerical representation
        String[] dateParts = dateString.split("-");
        dateParts[1] = monthAbbreviations.get(dateParts[1].toUpperCase());

        // Join the modified date parts
        String modifiedDateString = String.join("-", dateParts);
        System.out.println(modifiedDateString);

        // Define the date format of the input string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy");

        // Parse the modified input string into a LocalDate object
        LocalDate birthDate = LocalDate.parse(modifiedDateString, formatter);
        System.out.println(birthDate);

        // Get the current date
        LocalDate currentDate = LocalDate.now();
        System.out.println(currentDate);

        // Calculate the age
        Period period = Period.between(birthDate, currentDate);

        // Build and return the result string
        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();

        return years + " years, " + months + " months, " + days + " days";
    }

    public static void main(String[] args) {
        try {
            String birthDateString = "15-JUL-47";
            String age = calculateAge(birthDateString);
            System.out.println("Age: " + age);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getLocalizedMessage());
        }
    }
}
