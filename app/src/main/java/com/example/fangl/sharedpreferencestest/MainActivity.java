package com.example.fangl.sharedpreferencestest;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = (EditText)findViewById(R.id.inputText);
        initEdit();
        Button saveData = (Button)findViewById(R.id.save_data);
        saveData.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.save_data:

                SharedPreferences.Editor  editor = getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("data1",edit.getText().toString());
                editor.apply();

                break;
            default:

        }
    }

    private void initEdit(){

        SharedPreferences sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
        String content = sharedPreferences.getString("data1","");
        edit.setText(content);

    }

}
