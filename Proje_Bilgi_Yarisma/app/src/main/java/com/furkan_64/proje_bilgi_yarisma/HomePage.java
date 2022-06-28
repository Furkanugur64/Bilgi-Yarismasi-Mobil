package com.furkan_64.proje_bilgi_yarisma;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class HomePage extends AppCompatActivity {

    AppCompatButton Btnoyun,Btnskorlar,Btnhakkinda,Btncikis,Btnodul;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        Btnoyun=(AppCompatButton) findViewById(R.id.Btnoyun);
        Btnskorlar=(AppCompatButton) findViewById(R.id.Btnskorlar);
        Btnhakkinda=(AppCompatButton) findViewById(R.id.Btnhakkinda);
        Btncikis =(AppCompatButton) findViewById(R.id.Btncikis);
        Btnodul=(AppCompatButton) findViewById(R.id.btnodul);

        Btnoyun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(HomePage.this,Game_Intro.class);
                startActivity(intent);
            }
        });

        Btnodul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePage.this,Score.class);
                startActivity(intent);
            }
        });
        Btnhakkinda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(HomePage.this);
                builder.setTitle("Bilgi Yarışması");
                builder.setMessage("Bu Proje 06.04.2022 Tarihinde Mobil Programlama Dersi Projesi İçin Furkan UĞUR Tarafından Yapılmıştır.");
                builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();

            }
        });

        Btnskorlar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePage.this,MapsActivity.class);
                startActivity(intent);

            }
        });
        Btncikis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(HomePage.this,MainActivity.class));
                finish();
            }
        });

    }
}