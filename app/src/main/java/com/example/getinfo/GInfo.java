package com.example.getinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class GInfo extends AppCompatActivity {
     private TextView txt_display;
     private SharedPreferences pref;
     private String full_name,user_name,email,phone_no,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ginfo);
        txt_display=findViewById(R.id.txt_display);
        pref=getSharedPreferences("info",MODE_PRIVATE);
        full_name=pref.getString("full_name","");
        user_name=pref.getString("user_name","");
        email=pref.getString("email","");
        phone_no=pref.getString("phone_no","");
        password=pref.getString("password","");

        System.out.println("get_data::"+full_name+"\n"+user_name+"\n"+email+"\n"+phone_no+"\n"+password);
        txt_display.setText(full_name+"\n"+user_name+"\n"+email+"\n"+phone_no+"\n"+password);
    }
}