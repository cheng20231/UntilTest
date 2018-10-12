package com.cheng20231.mvpuntiltestdemo.Untils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class JSONParser {

    public static <T extends JSONParserData> List<T> parse(Class<T> clazz, JSONArray jsonArray)
            throws JSONException, ParseException, InstantiationException, IllegalAccessException{

        List<T> list = new ArrayList<>();

        for (int i = 0 ; i < jsonArray.length(); i++){
            list.add(parse(clazz, jsonArray.getJSONObject(i)));
        }

        return list;
    }

    public static <T extends JSONParserData> T parse (Class<T> clazz, JSONObject jsonObject)
            throws JSONException, ParseException, InstantiationException, IllegalAccessException{

        T data = clazz.newInstance();
        data.parse(jsonObject);

        return data;
    }
}
