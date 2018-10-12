package com.cheng20231.mvpuntiltestdemo.Untils;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;

public interface JSONParserData {
    void parse (JSONObject jsonObject) throws JSONException, ParseException, InstantiationException, IllegalAccessException;
}
