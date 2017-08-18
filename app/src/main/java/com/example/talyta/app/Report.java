package com.example.talyta.app;

import android.icu.util.Calendar;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.Manifest;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.graphics.BitmapCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

public class Report extends AppCompatActivity {

    public static String data_final;
    public static String msg_text;
    public static MultiAutoCompleteTextView info;
    TextView msg;
    ImageView photo;
    private static  final int REQUEST_IMAGE_CAPTURE= 1;
    private static final int REQUEST_CAMERA_PERMISSION = 2;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        info = (MultiAutoCompleteTextView)findViewById(R.id.multiAutoCompleteTextView);
       msg = (TextView)findViewById(R.id.msg_text);
        photo = (ImageView) findViewById(R.id.photo);
        Intent i = getIntent();
        msg_text = i.getStringExtra("Key");
        msg.setText(msg_text);

        data_final = Data();
    }

    @TargetApi(24)
    public void TakePhoto(View v)
    {
        int permissionCheckStorage = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        if (permissionCheckStorage == PackageManager.PERMISSION_DENIED) {
            requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }
/*

        int hasCamera = checkSelfPermission(Manifest.permission.CAMERA);
        if(hasCamera != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(Report.this,
                    new String[]{Manifest.permission.CAMERA},
                    REQUEST_CAMERA_PERMISSION);
        }*/
        else
        {
            i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(i, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestcode, int resultcode, Intent data)
    {
        super.onActivityResult(requestcode,resultcode,data);
        if(requestcode == REQUEST_IMAGE_CAPTURE && resultcode == RESULT_OK)
        {
            Bitmap bitmap = (Bitmap)data.getExtras().get("data");
            photo.setImageBitmap(bitmap);
        }
    }

    @TargetApi(24)
    public String Data()
    {


        Calendar cal = Calendar.getInstance();
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);

        //String dayOfMonthStr = String.valueOf(dayOfMonth);
      //  Calendar data = Calendar.getInstance();

        String dia = Integer.toString(dayOfMonth);

        String mes = Integer.toString(month+1);
        if(mes.length()<2)
            mes ="0"+mes;

        String ano = Integer.toString(year);

        return data_final = dia + "/"+ mes + "/" + ano;
    }

    public void acaoAdd(View v)
    {
        ReadDB object = new ReadDB(MyApp.getContext());
        object.addItem();
        sendEmail(Report.info, Report.msg_text);

        Intent it = new Intent(MyApp.getContext(), Perfil.class);
        startActivity(it);
    }


    private void sendEmail(MultiAutoCompleteTextView assunto, String categoria)
    {
        /*
        Intent emailApp = new Intent(Intent.ACTION_SEND);
        emailApp.putExtra(Intent.EXTRA_EMAIL, new String[]{"talytapacheco.1c2015@gmail.com"});
        emailApp.putExtra(Intent.EXTRA_SUBJECT, categoria);
        emailApp.putExtra(Intent.EXTRA_TEXT, assunto.getText().toString());
        emailApp.setType("message/rfc822");
        startActivity(Intent.createChooser(emailApp, "Send Email Via"));
*/

        Intent i = new Intent(Intent.ACTION_SENDTO);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, categoria);
        i.putExtra(Intent.EXTRA_TEXT   , assunto.getText().toString());
        i.setData(Uri.parse("mailto:talytapacheco.1c2015@gmail.com"));
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }







}
