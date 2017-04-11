package com.framgia.fdms.data.model;

/**
 * Created by levutantuan on 4/10/17.
 */

public class Category {
    private String mTitle;

    public Category(String title) {
        mTitle = title;
    }

    public Category() {
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}