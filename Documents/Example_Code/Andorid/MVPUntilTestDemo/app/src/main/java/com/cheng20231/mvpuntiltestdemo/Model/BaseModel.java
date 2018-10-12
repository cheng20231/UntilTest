package com.cheng20231.mvpuntiltestdemo.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.cheng20231.mvpuntiltestdemo.Untils.JSONParserData;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;

public class BaseModel implements JSONParserData, Parcelable {

    public BaseModel() {
    }

    public BaseModel(Parcel in) {
    }

    public static final Creator<BaseModel> CREATOR = new Creator<BaseModel>() {
        @Override
        public BaseModel createFromParcel(Parcel parcel) {
            return new BaseModel(parcel);
        }

        @Override
        public BaseModel[] newArray(int size) {
            return new BaseModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }

    @Override
    public void parse(JSONObject jsonObject) throws JSONException, ParseException, InstantiationException, IllegalAccessException {

    }
}
