package com.example.talyta.app;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Talyta on 13/04/2017.
 */

public class Reports extends Fragment {



   // String cate,date;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_reportl, container, false);

        //Intent i = getIntent();
       // cate = i.getStringExtra("Categoria");
        ListView lv = (ListView)rootView.findViewById(R.id.listView);

        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

        HashMap<String, String> item = new HashMap<String, String>();
        item.put("Categoria", Report.msg_text);
        item.put("Data", Report.data_final);
        list.add(item);

        String[] from = new String[] {"Categoria", "Data"};
        int[] to = new int [] {android.R.id.text1, android.R.id.text2};

        SimpleAdapter adapter = new SimpleAdapter(this.getContext(), list, android.R.layout.simple_list_item_2,from, to);
        lv.setAdapter(adapter);
        return rootView;
    }
}




