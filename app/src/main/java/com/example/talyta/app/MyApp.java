package com.example.talyta.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by aluno on 24/04/2017.
 */

public class MyApp extends Application {
    private static MyApp instance;

    public MyApp(){
        instance = this;
    }

    public static Context getContext()
    {
        return instance;
    }
}
