package com.cnippet.qrcode;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;


public class Main2Activity extends AppCompatActivity {
    EditText editText;
    Button button;
    String text2Qr,code;
    Spinner spinner;
    String[] codes={"Select Code","QR_CODE","AZTEC","CODABAR","CODE_39","CODE_93","CODE_128","DATA_MATRIX","EAN_8","EAN_13","ITF","MAXICODE","PDF_417","RSS_14","RSS_EXPANDED","UPC_A","UPC_E","UPC_EAN_EXTENSION"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText=(EditText)findViewById(R.id.editText);
        spinner=(Spinner)findViewById(R.id.spinner);

        ArrayAdapter year=new ArrayAdapter(this,android.R.layout.simple_spinner_item,codes);
        year.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(year);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                code=spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                code="";

            }
        });
    }

    public void generate(View view) {
        text2Qr=editText.getText().toString();

        if (text2Qr.length()==0) {

            Toast.makeText(Main2Activity.this,"Enter code in text field",Toast.LENGTH_LONG).show();



        }
        else
        {
            MultiFormatWriter writer = new MultiFormatWriter();
            //QRCodeWriter writer = new QRCodeWriter();
            try {
                BitMatrix bitMatrix = writer.encode(text2Qr, BarcodeFormat.valueOf(code), 516, 516);
                int width = bitMatrix.getWidth();
                int height = bitMatrix.getHeight();
                Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
                for (int x = 0; x < width; x++) {
                    for (int y = 0; y < height; y++) {
                        bmp.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE);
                    }
                }
                ((ImageView) findViewById(R.id.imageView)).setImageBitmap(bmp);

            } catch (WriterException e) {
                e.printStackTrace();
            }

        }

    }
}
