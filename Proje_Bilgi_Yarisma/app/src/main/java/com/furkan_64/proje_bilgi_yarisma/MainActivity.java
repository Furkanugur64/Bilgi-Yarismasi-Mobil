package com.furkan_64.proje_bilgi_yarisma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView ImgLogo;
    AppCompatButton BtnGiris,BtnKayit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImgLogo=(ImageView) findViewById(R.id.ImgLogo);
        BtnGiris=(AppCompatButton) findViewById(R.id.BtnGiris);
        BtnKayit=(AppCompatButton) findViewById(R.id.BtnKayit);


        BtnGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gecisyap=new Intent(MainActivity.this,Login.class);
                startActivity(gecisyap);
            }
        });

        BtnKayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gecisyap=new Intent(MainActivity.this,Register.class);
                startActivity(gecisyap);
            }
        });
    }
}