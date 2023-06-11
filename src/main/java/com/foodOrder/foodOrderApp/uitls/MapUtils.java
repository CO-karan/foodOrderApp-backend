package com.foodOrder.foodOrderApp.uitls;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapUtils {

    private static <V> Map<String,V> mapOf(Map<String,V> copy,Object... keyValues){
        if(keyValues.length % 2 != 0) throw new IllegalArgumentException("invalid length of k,v");
        Map<String,V> map = new LinkedHashMap<>();
        for(int i = 0; i<keyValues.length;i++){
            if(i%2==1){
                map.put((String) keyValues[i-1], (V) keyValues[i]);
            }
        }
        return map;
    }


    public static <V> Map<String,V> mapOf(Object... keyValues){
        return mapOf(Collections.emptyMap(),keyValues);
    }
}
