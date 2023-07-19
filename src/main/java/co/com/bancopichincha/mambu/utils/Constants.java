package co.com.bancopichincha.mambu.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static co.com.bancopichincha.mambu.utils.PropertiesManager.getValue;
import static co.com.bancopichincha.mambu.utils.PropertiesManager.setValue;

public class Constants {

    private Constants() {
        throw new IllegalStateException("Utility class");
    }


    public static Map<String, String> getHeader() {
		 Map<String, String> headers = new HashMap<>();
		 headers.put("Accept", getValue("accept"));
		 headers.put("Authorization", getValue("Authorization"));
		 headers.put("Idempotency-Key" , setValue("Idempotency-Key"));
		 return headers;
    }

}
