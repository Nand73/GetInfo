package com.example.getinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    Button signup_, login_;
    TextInputLayout full_var, user_varr, email_var, phone_var, passord_varr;
    RadioGroup RadioG;
    RadioButton RadioB1, RadioB2;
    TextView Gender;
    CheckBox CheckB1;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signup_ = findViewById(R.id.register_button);
        login_ = findViewById(R.id.login_button);
        full_var = findViewById(R.id.full_name);
        user_varr = findViewById(R.id.User_name);
        email_var = findViewById(R.id.Email_enter);
        phone_var = findViewById(R.id.phone_input);
        passord_varr = findViewById(R.id.password_input);
        RadioG = findViewById(R.id.radioGroup);
        RadioB1 = findViewById(R.id.rb1);
        RadioB2 = findViewById(R.id.rb2);
        Gender = findViewById(R.id.edtGender);
        CheckB1 = findViewById(R.id.checkbox);

        signup_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String full__ = full_var.getEditText().getText().toString();
                String user__ = user_varr.getEditText().getText().toString();
                String email__ = email_var.getEditText().getText().toString();
                String phone__ = phone_var.getEditText().getText().toString();
                String password__ = passord_varr.getEditText().getText().toString();


                if (!full__.isEmpty()) {
                    full_var.setError(null);
                    full_var.setErrorEnabled(false);
                    if (!user__.isEmpty()) {
                        user_varr.setError(null);
                        user_varr.setErrorEnabled(false);
                        if (!email__.isEmpty()) {
                            email_var.setError(null);
                            email_var.setErrorEnabled(false);
                            if (errors()) {

                                if (!password__.isEmpty()) {
                                    passord_varr.setError(null);
                                    passord_varr.setErrorEnabled(false);
                                    if (!email__.matches("\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b")) {
                                        if (error()) {


                                            String full__s = full_var.getEditText().getText().toString();
                                            String user__s = user_varr.getEditText().getText().toString();
                                            String email__s = email_var.getEditText().getText().toString();
                                            String phone__s = phone_var.getEditText().getText().toString();
                                            String password__s = passord_varr.getEditText().getText().toString();
                                            System.out.println("get_data::"+full__s+"\n"+user__s+"\n"+email__s+"\n"+phone__s+"\n"+password__s);
                                            pref=getSharedPreferences("info",MODE_PRIVATE);
                                            SharedPreferences.Editor editor=pref.edit();
                                            editor.putString("full__s",full__s);
                                            editor.putString("user__s",user__s);
                                            editor.putString("email__s",email__s);
                                            editor.putString("phone__s",phone__s);
                                            editor.putString("password__s",password__s);
                                            editor.commit();
                                            editor.apply();
                                            Intent intent=new Intent(getApplicationContext(),GInfo.class);
                                            startActivity(intent);


                                            Toast.makeText(MainActivity.this, "Register Successfully", Toast.LENGTH_SHORT).show();


                                        }
                                    } else {
                                        email_var.setError("invalid email");
                                    }
                                } else {
                                    passord_varr.setError("password ");
                                }

                            }

                        } else {
                            email_var.setError("Enter the email");
                        }
                    } else {
                        user_varr.setError("Enter your user name");
                    }

                } else {
                    full_var.setError("Please enter your name");
                }

            }
        });
    }
        private boolean errors () {
            if (phone_var.getEditText().getText().toString().length() == 0) {
                Toast.makeText(this, "please fill mobile no", Toast.LENGTH_SHORT).show();
                return false;
            }

            if (phone_var.getEditText().getText().toString().length() != 10) {
                Toast.makeText(this, "please enter the valid no", Toast.LENGTH_SHORT).show();
                return false;
            }
            return true;
        }
        private boolean error () {

            if (!RadioB1.isChecked() && !RadioB2.isChecked()) {
                Toast.makeText(this, "please select your gender", Toast.LENGTH_SHORT).show();
                return false;
            } else if (!CheckB1.isChecked()) {
                Toast.makeText(this, "please enter the terms and conditions", Toast.LENGTH_SHORT).show();
                return false;
            }
            return true;
        }



    }
