package com.furkan_64.proje_bilgi_yarisma;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SaveGame extends AppCompatActivity {

    EditText TxtAdi,TxtSoyadi,TxtYasi;
    TextView TxtScore;
    AppCompatButton BtnKaydet,BtnIptal;
    DatabaseReference dbreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_game);



        TxtAdi=findViewById(R.id.TxtAdi);
        TxtSoyadi=findViewById(R.id.TxtSoyadi);
        TxtYasi=findViewById(R.id.TxtYasi);
        TxtScore=findViewById(R.id.TxtScore);
        BtnIptal=findViewById(R.id.BtnIptal);
        BtnKaydet=findViewById(R.id.Btnkaydet);

        dbreference= FirebaseDatabase.getInstance().getReference().child("Scores");
        Bundle bnd=getIntent().getExtras();
        String x=bnd.getString("score");
        TxtScore.append(x);
        BtnKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               InsertData();
               Intent intent=new Intent(getApplicationContext(),HomePage.class);
               startActivity(intent);
            }
        });

        BtnIptal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),HomePage.class);
                startActivity(intent);
            }
        });
    }

    private void InsertData() {
        if(!TextUtils.isEmpty(TxtAdi.getText().toString()) &&!TextUtils.isEmpty(TxtSoyadi.getText().toString())||!TextUtils.isEmpty(TxtYasi.getText().toString()))
        {
            String name = TxtAdi.getText().toString();
            String surname = TxtSoyadi.getText().toString();
            String age = TxtYasi.getText().toString();
            String score = TxtScore.getText().toString();

            Scores scores=new Scores(name,surname,age,score);
            dbreference.push().setValue(scores);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Boş Alan Bırakmayınız",Toast.LENGTH_LONG).show();
        }



    }
}