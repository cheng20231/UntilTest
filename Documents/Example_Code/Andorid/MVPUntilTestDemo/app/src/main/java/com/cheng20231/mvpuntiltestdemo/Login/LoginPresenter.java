package com.cheng20231.mvpuntiltestdemo.Login;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.cheng20231.mvpuntiltestdemo.Model.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LoginPresenter {

    Context mContext;
    SharedPreferences mSPF;
    LoginInterFace mShowInterface;
    HashMap<String, String> mUserData;

    final String DEFAULT_ALERT_TITLE = "測試訊息";
    final String USER_DATA_KEY = "User_data_Key";
    final String USER_DATA_EMPTY = "User_data_empty";

    public LoginPresenter(Context context) {
        mContext = context;
        mSPF = PreferenceManager.getDefaultSharedPreferences(mContext);
        mUserData = new HashMap<>();
    }

    public void attachView(LoginInterFace showInterface){
        mShowInterface = showInterface;
    }


    public void loginEvent(String account, String password){
        String jsonString = mSPF.getString(USER_DATA_KEY, USER_DATA_EMPTY);

        if (jsonString.equals(USER_DATA_EMPTY)){
            mShowInterface.showAlert(DEFAULT_ALERT_TITLE,"請輸入帳號" );
            return;
        }

        if (!jsonString.contains(account)){
            mShowInterface.showAlert(DEFAULT_ALERT_TITLE,"此帳號不存在" );
            return;
        }

        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            if (jsonObject.getString(account).equals(password)){
                mShowInterface.showAlert(DEFAULT_ALERT_TITLE,account+",登入成功!" );
            }
            else{
                mShowInterface.showAlert(DEFAULT_ALERT_TITLE,"密碼輸入錯誤!!!" );
            }
        }
        catch (JSONException e){
            e.printStackTrace();
        }



    }


    public boolean isExistUser(String account){
        if (mUserData == null){
            return false;
        }

        if (mUserData.size() == 0){
            return false;
        }

        return mUserData.containsKey(account);
    }

    public void registerEvent(String account, String password){

        if (isExistUser(account)){
            mShowInterface.showAlert(DEFAULT_ALERT_TITLE,"此帳號已經註冊" );
        }
        else {
            mUserData.put(account, password);
            mSPF.edit().putString(USER_DATA_KEY, (new JSONObject(mUserData)).toString()).commit();
            mShowInterface.showAlert(DEFAULT_ALERT_TITLE,"註冊成功!!!" );
        }
    }

}
