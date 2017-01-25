package com.ccampos18.www.final_project;

import com.parse.Parse;

import android.app.Application;

/**
 * Created by ccampos18 on 1/23/2017.
 */

/**
 * Use_Parse class that connects to the parse library that the IOS application is currently using.
 * There is an application ID, server, and client key before being able to access all the variables
 * that are in the parse database.
 */
public class Use_Parse extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
        .applicationId("ZMoV75Ri5r0O1kiDr3wT7drPHasA2Otg1oqYio2p")
        .server("https://parseapi.back4app.com/")
        .clientKey("Hqrezmu0tI9FQbXPy0lMfR7RuvHnOdjnzHSeGCRY")
        .build());
    }
}
