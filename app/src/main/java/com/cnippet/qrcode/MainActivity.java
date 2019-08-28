package com.cnippet.qrcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void generator(View view) {
        Intent j1=new Intent();
        j1.setClass(MainActivity.this,Main2Activity.class);
        startActivity(j1);
    }

    public void scanner(View view) {
        Intent j1=new Intent();
        j1.setClass(MainActivity.this,Main3Activity.class);
        startActivity(j1);
    }
}
