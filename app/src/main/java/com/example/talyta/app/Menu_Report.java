package com.example.talyta.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Menu_Report extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String[] water_list= new String[] {"Sewerage", "Dengue focus Area"};
    private String[] pollution_list = new String [] {"Noise pollution", "Visual pollution"};
    private String[] animal_list= new String[] {"Wild animal in urban area"};
    private String[] tree_list =  new String[] {"Illegal tree cutting", "Forest fire"};

    Intent it;
    Spinner water, pollution, animal, tree;
    String text;

    int check = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_report);

        water = (Spinner)findViewById(R.id.water);
        ArrayAdapter adapter_w = new ArrayAdapter <String> (this, android.R.layout.simple_spinner_item, water_list);
        adapter_w.setDropDownViewResource(android.R.layout.simple_spinner_item);
        water.setAdapter(adapter_w);
        water.setOnItemSelectedListener(this);

        pollution = (Spinner)findViewById(R.id.pollution);
        ArrayAdapter adapter_p = new ArrayAdapter <String> (this, android.R.layout.simple_spinner_item, pollution_list);
        adapter_p.setDropDownViewResource(android.R.layout.simple_spinner_item);
        pollution.setAdapter(adapter_p);
        pollution.setOnItemSelectedListener(this);

        tree = (Spinner)findViewById(R.id.tree);
        ArrayAdapter adapter_t = new ArrayAdapter <String> (this, android.R.layout.simple_spinner_item, tree_list);
        adapter_t.setDropDownViewResource(android.R.layout.simple_spinner_item);
        tree.setAdapter(adapter_t);
        tree.setOnItemSelectedListener(this);

        animal = (Spinner)findViewById(R.id.animal);
        ArrayAdapter adapter_a = new ArrayAdapter <String> (this, android.R.layout.simple_spinner_item, animal_list);
        adapter_a.setDropDownViewResource(android.R.layout.simple_spinner_item);
        animal.setAdapter(adapter_a);
        animal.setOnItemSelectedListener(this);

    }



    @Override
    public void onItemSelected(AdapterView parent, View v, int pos, long id)
    {
        if(++check > 4 ) {
                      switch (parent.getId()) {
                        case R.id.water:
                            text = water.getItemAtPosition(pos).toString();
                            it = new Intent(this, Report.class);
                            it.putExtra("Key", text);
                            startActivity(it);
                            break;
                        case R.id.pollution:
                            text = pollution.getItemAtPosition(pos).toString();
                            it = new Intent(this, Report.class);
                            it.putExtra("Key", text);
                            startActivity(it);
                            break;
                        case R.id.animal:
                            text = animal.getItemAtPosition(pos).toString();
                            it = new Intent(this, Report.class);
                            it.putExtra("Key", text);
                            startActivity(it);
                            break;
                        case R.id.tree:
                            text = tree.getItemAtPosition(pos).toString();
                            it = new Intent(this, Report.class);
                            it.putExtra("Key", text);
                            startActivity(it);
                            break;

            }
        }


    }

    @Override
    public void onNothingSelected(AdapterView parent)
    {

    }
}
