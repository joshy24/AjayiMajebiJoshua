package com.epicteck.ajayimajebijoshua.utils;

import com.google.gson.Gson;

/**
 * Created by Josh on 6/11/2018.
 */

public class FilterGson {
    private static Gson gson = new Gson();
    public static Gson getGson(){
        return gson;
    }
}
