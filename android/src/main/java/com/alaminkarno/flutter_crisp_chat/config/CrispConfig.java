package com.alaminkarno.flutter_crisp_chat.config;

import android.util.Log;

import java.util.Map;

public class CrispConfig {
    public String websiteId;
    public String tokenId = null;
    public User user = null;


    public static CrispConfig fromJson(Map<String, Object> json) {
        CrispConfig crispConfig = new CrispConfig();
        crispConfig.websiteId = (String) json.get("websiteId");
        try {
            if (json.containsKey("tokenId")) {
                Object tokenIdObj = json.get("tokenId");
                if (tokenIdObj != null) {
                    crispConfig.tokenId = tokenIdObj.toString();
                }
            }
        }catch (Exception e){
            Log.d("exception", e.toString());
        }
        if (json.containsKey("user")) {
            Object userObj = json.get("user");
            if (userObj != null) {
                crispConfig.user = User.fromJson((Map<String, Object>) userObj);
            }
        }
        return crispConfig;
    }
}
