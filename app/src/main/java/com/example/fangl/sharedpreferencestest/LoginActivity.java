package com.example.fangl.sharedpreferencestest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText account;
    private EditText passWord;
    private Button login;
    private CheckBox checkBox;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pref = getSharedPreferences("loginInfo",MODE_PRIVATE);
        account = (EditText)findViewById(R.id.account);
        passWord = (EditText)findViewById(R.id.password);
        checkBox = (CheckBox)findViewById(R.id.remember);
        login = (Button)findViewById(R.id.login);
        boolean isRemember = pref.getBoolean("remember_loginInfo",false);
        if(isRemember){
            // 记住账号密码
            String accountText = pref.getString("account","");
            String passwordText = pref.getString("password","");
            account.setText(accountText);
            passWord.setText(passwordText);
            checkBox.setChecked(true);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ac = account.getText().toString();
                String ps = passWord.getText().toString();

                editor = getSharedPreferences("loginInfo",MODE_PRIVATE).edit();
                if(ac.equals("admin") && ps.equals("12345") ){
                    if(checkBox.isChecked()){
                        editor.putString("account",ac);
                        editor.putString("password",ps);
                        editor.putBoolean("remember_loginInfo",true);
                    }else{
                        editor.clear();
                    }
                    editor.apply();
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this,"账号或密码错误",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
