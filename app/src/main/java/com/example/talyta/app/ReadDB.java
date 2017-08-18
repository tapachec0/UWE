package com.example.talyta.app;

/**
 * Created by aluno on 21/04/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

public class ReadDB extends AppCompatActivity{

    private Context context = MyApp.getContext();
    private DBase_denuncias db = new DBase_denuncias(context);

    public SQLiteDatabase database = db.getReadableDatabase();

    public ReadDB (Context context){
        if (db != null){
            db = new DBase_denuncias(context);
        }
    }

    public void addItem(){
        //String sql = "INSERT INTO denuncia (data, categoria) VALUE ('"+Report.data_final+"', '"+ Report.msg_text+");";


        String sql = "INSERT INTO denuncia (data) VALUES ('"+Report.data_final+"');";
        String sql2 = "INSERT INTO denuncia (categoria) VALUES ('"+Report.msg_text+"');";


        SQLiteDatabase database = db.getReadableDatabase();
        database.execSQL(sql);
        database.execSQL(sql2);


        //it.putExtra("Data", sql);
      //  it.putExtra("Categoria", sql2);


    }



}


        /*
        Intent intent = new Intent(Intent.ACTION_SENDTO)
                .setData(new Uri.Builder().scheme("mailto").build());
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"talytapacheco.1c2015@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, Report.msg_text);
        intent.putExtra(Intent.EXTRA_TEXT, Report.info.getText().toString());
        */





