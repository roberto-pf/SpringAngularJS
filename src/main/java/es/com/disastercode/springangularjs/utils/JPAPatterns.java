package es.com.disastercode.springangularjs.utils;

public class JPAPatterns {

    public static String getContainsLikePattern(String value) {
        if (value == null || value.isEmpty()) {
            return "%";
        }
        else {
            return "%" + value.toLowerCase() + "%";
        }
    }
    
    public static String getEqualsLikePattern(String value) {
        if (value == null || value.isEmpty()) {
            return "%";
        }
        else {
            return value.toLowerCase();
        }
    }
}
