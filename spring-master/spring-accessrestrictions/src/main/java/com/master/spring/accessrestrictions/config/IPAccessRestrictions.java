package com.master.spring.accessrestrictions.config;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2018/5/7.
 */
public class IPAccessRestrictions {
    public static Map<String,Integer> clientIP=new HashMap<>();

    public Map<String, Integer> getClientIP() {
        return clientIP;
    }

    public void setClientIP(Map<String, Integer> clientIP) {
        this.clientIP = clientIP;
    }
}
