package com.furkan_64.proje_bilgi_yarisma;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register extends AppCompatActivity {
    ImageView ImgLogo;
    EditText TxtMail, TxtSifre, TxtSifreTekrar;
    TextView LblGiris;
    AppCompatButton BtnKayitOl;

    String mailtutucu;
    String sifretutucu;
    String sifretekrartutucu;
    FirebaseAuth yetki;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        yetki=FirebaseAuth.getInstance();

        ImgLogo = (ImageView) findViewById(R.id.ImgLogo);
        TxtMail = (EditText) findViewById(R.id.TxtMail);
        TxtSifre = (EditText) findViewById(R.id.TxtSifre);
        TxtSifreTekrar = (EditText) findViewById(R.id.TxtSifreTekrar);
        LblGiris = (TextView) findViewById(R.id.LblGiris);
        BtnKayitOl = (AppCompatButton) findViewById(R.id.BtnKayitOl);



        BtnKayitOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              mailtutucu=TxtMail.getText().toString();
              sifretutucu=TxtSifre.getText().toString();
              sifretekrartutucu=TxtSifreTekrar.getText().toString();

              if(TextUtils.isEmpty(mailtutucu)||TextUtils.isEmpty(sifretekrartutucu)||TextUtils.isEmpty(sifretutucu))
              {
                  Toast.makeText(getApplicationContext(),"Alanlar Boş Geçilemez",Toast.LENGTH_LONG).show();
              }
              else
              {
                  if(!TxtSifre.getText().toString().equals(TxtSifreTekrar.getText().toString()))
                  {
                      Toast.makeText(getApplicationContext(),"Şifreler Eşleşmiyor",Toast.LENGTH_LONG).show();
                  }
                  else
                  {
                      kaydol();
                  }
              }
            }
        });

        LblGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register.this,Login.class));
            }
        });
    }

    private void kaydol()
    {
        yetki.createUserWithEmailAndPassword(mailtutucu,sifretutucu).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> kaydolmagorevi) {
                // Kayıt İşlemi Başarılı Olursa
                if(kaydolmagorevi.isSuccessful())
                {
                   startActivity(new Intent(Register.this,Login.class));
                   finish();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception hata) {
                // Kayıt İşlemi Başarısız Olursa
                Toast.makeText(getApplicationContext(),"Kayıt İşlemi Başarısız Oldu "+hata.getMessage(),Toast.LENGTH_LONG ).show();
            }
        });
    }
}