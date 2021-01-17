package com.example.rmltest.shared_preference;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

public class AppPrefsManager {

    private SharedPreferences preferences;
    private static final String DB_NAME = "orko_user_db";
    private SharedPreferences.Editor editor;
    private Context mContext;
    private static final String IS_LOGIN = "is_login";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";


    @SuppressLint("CommitPrefEdits")
    public AppPrefsManager(Context context) {
        this.mContext = context;
        preferences = this.mContext.getSharedPreferences(DB_NAME, 0);
        editor = preferences.edit();

    }public AppPrefsManager(Context context,String username, String password) {
        this.mContext = context;
        preferences = this.mContext.getSharedPreferences(DB_NAME, 0);
        editor = preferences.edit();
        setUsername(username);
        setPassword(password);

    }

    public void  setIsLogin(boolean isLogin) {
        editor.putBoolean(IS_LOGIN, isLogin);
        editor.apply();
    }


    public boolean isLogin() {
        return preferences.getBoolean(IS_LOGIN, false);
    }

    public void setUsername(String username) {
        editor.putString(USERNAME, username);
        editor.apply();
    }


    public String getUsername() {
        return preferences.getString(USERNAME,"");
    }
    public void setPassword(String password) {
        editor.putString(PASSWORD, password);
        editor.apply();
    }


    public String getPassword() {
        return preferences.getString(PASSWORD,"");
    }


}
