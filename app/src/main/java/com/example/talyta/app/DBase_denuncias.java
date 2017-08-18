package com.example.talyta.app;

import android.content.Context;
import android.database.sqlite.*;
import android.database.Cursor.*;
import android.database.sqlite.*;


/**
 * Created by aluno on 21/04/2017.
 */

public class DBase_denuncias extends SQLiteOpenHelper {

    public static String TABLE_DENUNCIA =
            "CREATE TABLE denuncia ( " +
                    "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                    "categoria TEXT, "+
                    "data TEXT " +
                    ");";

    public DBase_denuncias(Context context) {
        super(context, "Denuncias.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_DENUNCIA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
