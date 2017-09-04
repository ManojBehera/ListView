package com.naitiks.listview;

/**
 * Created by Naitik on 9/4/2017.
 */

public class UserModel {
    private String name;

    public UserModel(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
