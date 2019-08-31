package com.cnippet.qrcode;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dl = findViewById(R.id.dlayout);
        abdt = new ActionBarDrawerToggle(this,dl,R.string.open,R.string.close);
        dl.addDrawerListener(abdt);
        abdt.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = findViewById(R.id.navigationview);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(abdt.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
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

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            int id=item.getItemId();
            if(id==R.id.about){
                Intent j1=new Intent();
                j1.setClass(MainActivity.this,Main4Activity.class);
                startActivity(j1);
            }
            else if(id==R.id.guidelines){
                Intent j1=new Intent();
                j1.setClass(MainActivity.this,Main5Activity.class);
                startActivity(j1);
            }


            return false;
        }

}

