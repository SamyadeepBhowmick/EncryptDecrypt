package com.cnippet.qrcode;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonScan;
    private TextView textViewName;

    private IntentIntegrator qrScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        buttonScan = (Button) findViewById(R.id.buttonScan);
        textViewName = (TextView) findViewById(R.id.textViewName);

        qrScan = new IntentIntegrator(this);
        buttonScan.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null)
        {
            textViewName.post(new Runnable() {
                @Override
                public void run() {
                    Vibrator vibrator=(Vibrator)getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                    vibrator.vibrate(100);
                }
            });
            textViewName.setText(result.getContents());

            if (result.getContents() == null)
            {
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            }
        }
        else
            {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
    @Override
    public void onClick(View view) {
        qrScan.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        qrScan.setPrompt("");
        qrScan.setBeepEnabled(false);
        qrScan.setBarcodeImageEnabled(false);
        qrScan.initiateScan();
    }
}