package com.framgia.fdms.data.model;

/**
 * Created by levutantuan on 3/31/17.
 */
public class User {

    public String mUserName;
    public String mPassWord;
    public String mFirstName;
    public String mLastName;
    public String mAddress;
    public String mRole;
    public String mDepartment;

    public User(String userName, String passWord, String firstName, String lastName, String address,
            String role, String department) {
        mUserName = userName;
        mPassWord = passWord;
        mFirstName = firstName;
        mLastName = lastName;
        mAddress = address;
        mRole = role;
        mDepartment = department;
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

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getRole() {
        return mRole;
    }

    public void setRole(String role) {
        mRole = role;
    }

    public String getDepartment() {
        return mDepartment;
    }

    public void setDepartment(String department) {
        mDepartment = department;
    }
}
