package com.framgia.fdms.data.model;

/**
 * Created by levutantuan on 3/31/17.
 */
public class User {

    public String mUserName;
    public String mPassWord;

    public User(String userName, String passWord) {
        mUserName = userName;
        mPassWord = passWord;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public String getPassWord() {
        return mPassWord;
    }

    public void setPassWord(String passWord) {
        mPassWord = passWord;
    }
}
