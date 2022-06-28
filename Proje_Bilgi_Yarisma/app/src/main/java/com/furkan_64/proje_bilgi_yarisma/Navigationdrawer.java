package com.furkan_64.proje_bilgi_yarisma;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Navigationdrawer extends AppCompatActivity {

    DrawerLayout cekmece;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigationdrawer);
        cekmece=findViewById(R.id.cekmecearkaplan);

    }
    public void Menutiklama(View view)
    {
        cekmeceyiac(cekmece);
    }

    public void cekmeceyiac(DrawerLayout cekmece) {
        cekmece.openDrawer(GravityCompat.START);
    }

    public void Logoyatiklama(View view)
    {
        cekmeceyikapat(cekmece);
    }

    public void cekmeceyikapat(DrawerLayout cekmece) {
        if(cekmece.isDrawerOpen(GravityCompat.START))
        {
            cekmece.closeDrawer(GravityCompat.START);
        }
    }

    public void Anasayfa_tiklama(View view)
    {
        Intent intent=new Intent(getApplicationContext(),HomePage.class);
        startActivity(intent);
    }

    public void Login_tiklama(View view)
    {
        Intent intent=new Intent(getApplicationContext(),Login.class);
        startActivity(intent);

    }

    public void hakkimizda_tiklama(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(Navigationdrawer.this);
        builder.setTitle("Bilgi Yarışması");
        builder.setMessage("Bu Proje 06.04.2022 Tarihinde Mobil Programlama Dersi Projesi İçin Furkan UĞUR Tarafından Yapılmıştır.");
        builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }


    public void Cikis_tiklama(View view)
    {
        AlertDialog.Builder uyaripenceresi=new AlertDialog.Builder(Navigationdrawer.this);

        uyaripenceresi.setTitle("Çıkış");
        uyaripenceresi.setMessage("Çıkış Yapılsın mı ?");
        uyaripenceresi.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finishAffinity();
                System.exit(0);
            }
        });
        uyaripenceresi.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        uyaripenceresi.show();
    }

    @Override
    protected void onPause() {
        cekmeceyikapat(cekmece);
        super.onPause();
    }
}