package com.furkan_64.proje_bilgi_yarisma;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {
    ImageView ImgLogo;
    EditText TxtMailLogin,TxtSifreLogin;
    TextView LblKayit;
    AppCompatButton BtnGirisLogin;


    String mailtutucu;
    String sifretutucu;
    FirebaseAuth yetki;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImgLogo=(ImageView) findViewById(R.id.ImgLogo);
        TxtMailLogin=(EditText) findViewById(R.id.TxtMailLogin);
        TxtSifreLogin=(EditText) findViewById(R.id.TxtSifreLogin);
        LblKayit=(TextView) findViewById(R.id.LblKayit);
        BtnGirisLogin=(AppCompatButton) findViewById(R.id.BtnGirisLogin);

        //Firebasi Başlatma
        yetki=FirebaseAuth.getInstance();

        BtnGirisLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mailtutucu = TxtMailLogin.getText().toString();
                sifretutucu = TxtSifreLogin.getText().toString();
                if(TextUtils.isEmpty(mailtutucu)||TextUtils.isEmpty(sifretutucu))
                {
                    Toast.makeText(getApplicationContext(),"Alanlar Boş Geçilemez",Toast.LENGTH_LONG).show();
                }
                else
                {
                    girisYap();
                }
            }
        });


        LblKayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,Register.class));
            }
        });
    }

    private void girisYap()
    {
        yetki.signInWithEmailAndPassword(mailtutucu,sifretutucu).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> girisgorevi) {

                if(girisgorevi.isSuccessful())
                {
                    startActivity(new Intent(Login.this,HomePage.class));
                    finish();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception hata) {
                Toast.makeText(getApplicationContext(),"Giriş İşlemi Başarısız Oldu "+hata,Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser mevcutkullanici=yetki.getCurrentUser();

        if(mevcutkullanici!=null)
        {
            startActivity(new Intent(Login.this,HomePage.class));
            finish();
        }
    }
}