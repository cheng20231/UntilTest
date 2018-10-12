package com.cheng20231.mvpuntiltestdemo.Model;

import android.os.Parcel;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;

public class User extends BaseModel{

    public String userAccount;
    public String userPassword;
    public String userName;

    public User(String userAccount, String userPassword, String userName) {
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.userName = userName;
    }

    public User(Parcel in) {
       userAccount = in.readString();
       userPassword = in.readString();
       userName = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel parcel) {
            return new User(parcel);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(userAccount);
        dest.writeString(userPassword);
        dest.writeString(userName);

    }

    @Override
    public void parse(JSONObject jsonObject) throws JSONException, ParseException, InstantiationException, IllegalAccessException {
        super.parse(jsonObject);
    }
}
