package com.furkan_64.proje_bilgi_yarisma;


import static com.furkan_64.proje_bilgi_yarisma.Game_Intro.listdifficult;
import static com.furkan_64.proje_bilgi_yarisma.Game_Intro.listeasy;
import static com.furkan_64.proje_bilgi_yarisma.Game_Intro.listmiddle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game extends AppCompatActivity {

    CountDownTimer countDownTimer,timer2;

    int timerValue=20,timervalue2=5;
    int questionCount=1;
    TextView Txttimer,card_question,optiona,optionb,optionc,optiond,Txtcekil;
    CardView cardA,cardB,cardC,cardD;
    List<ModelClass> easyQuestionList;
    List<ModelClass> middleQuestionList;
    List<ModelClass> difficultQuestionList;
    ModelClass modelClass;
    ImageView imgback,Btnseyirci,Btnyariyariya,Btnzamandurdurma;
    int index=0;
    LinearLayout nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        Hooks();

        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Game.this,HomePage.class);
                startActivity(intent);
            }
        });
        Txtcekil.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                AlertDialog.Builder uyaripenceresi=new AlertDialog.Builder(Game.this);

                uyaripenceresi.setTitle("Uyarı");
                uyaripenceresi.setMessage("Çekilmek İstiyor Musunuz ?");
                uyaripenceresi.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String totalscore="";
                        if(questionCount==1)
                        {
                            totalscore="500";
                        }
                        if(questionCount==2)
                        {
                            totalscore="1000";
                        }
                        if(questionCount==3)
                        {
                            totalscore="2500";
                        }
                        if(questionCount==4)
                        {
                            totalscore="7500";
                        }
                        if(questionCount==5)
                        {
                            totalscore="15000";
                        }
                        if(questionCount==6)
                        {
                            totalscore="50000";
                        }
                        if(questionCount==7)
                        {
                            totalscore="75000";
                        }
                        if(questionCount==8)
                        {
                            totalscore="150000";
                        }
                        if(questionCount==9)
                        {
                            totalscore="250000";
                        }if(questionCount==10)
                        {
                            totalscore="1000000";
                        }

                        Intent intent=new Intent(Game.this,SaveGame.class);
                        intent.putExtra("score",totalscore);
                        startActivity(intent);
                    }
                });
                uyaripenceresi.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        countDownTimer.start();
                    }
                });
                uyaripenceresi.show();
            }
        });
        easyQuestionList=listeasy;
        middleQuestionList=listmiddle;
        difficultQuestionList=listdifficult;

        Collections.shuffle(easyQuestionList);
        Collections.shuffle(middleQuestionList);
        Collections.shuffle(difficultQuestionList);

        modelClass=listeasy.get(index);
        nextBtn.setClickable(false);
        setAllData();

        timer2=new CountDownTimer(5000,1000) {
            @Override
            public void onTick(long l) {
                countDownTimer.cancel();
                timervalue2--;
                Txttimer.setText(" ");
                if(timervalue2==0)
                {
                    WrongAnswer();
                }
            }

            @Override
            public void onFinish() {

            }
        }.start();
        timer2.cancel();
        countDownTimer=new CountDownTimer(20000,1000) {
            @Override
            public void onTick(long l) {
                timerValue=timerValue-1;
                Txttimer.setText(String.valueOf(timerValue));

               if(timerValue==0)
               {
                   Dialog dialog=new Dialog(Game.this);
                   dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                   dialog.setContentView(R.layout.activity_time_out_dialog);

                   dialog.findViewById(R.id.btn_menu).setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View view) {
                           Intent intent=new Intent(Game.this,HomePage.class);
                           startActivity(intent);
                       }
                   });
                   dialog.show();
               }

            }

            @Override
            public void onFinish() {

            }
        }.start();

        Btnzamandurdurma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                Btnzamandurdurma.setClickable(false);
            }
        });

        Btnseyirci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Btnseyirci.setClickable(false);
                timerValue+=7;
                Txttimer.setText(String.valueOf(timerValue));
                Random rnd = new Random();
                int sayi = rnd.nextInt(40)+60;
                String answer="";
                if(modelClass.getaA().equals(modelClass.getAns()))
                {
                    answer="A";
                }
                if(modelClass.getaB().equals(modelClass.getAns()))
                {
                    answer="B";
                }
                if(modelClass.getaC().equals(modelClass.getAns()))
                {
                    answer="C";
                }if(modelClass.getaD().equals(modelClass.getAns()))
                {
                    answer="D";
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(Game.this);
                builder.setTitle("Seyirci Jokeri");
                builder.setMessage("Seyircilerimiz %"+sayi+" Oranında Cevabın "+answer+" Olduğunu Düşünüyor.");
                builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();


            }
        });


        Btnyariyariya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Btnyariyariya.setClickable(false);
                if(modelClass.getaA().equals(modelClass.getAns())||modelClass.getaC().equals(modelClass.getAns()))
                {
                    optionb.setText("");
                    optiond.setText("");
                }
                else if(modelClass.getaB().equals(modelClass.getAns())||modelClass.getaD().equals(modelClass.getAns()))
                {
                    optiona.setText("");
                    optionc.setText("");
                }
            }
        });

    }



    private void setAllData() {
        card_question.setText(modelClass.getQuestion());
        optiona.setText(modelClass.getaA());
        optionb.setText(modelClass.getaB());
        optionc.setText(modelClass.getaC());
        optiond.setText(modelClass.getaD());
    }

    private void Hooks() {
        nextBtn=findViewById(R.id.nextBtn);
        Txttimer= findViewById(R.id.Txttimer);
        card_question=findViewById(R.id.card_question);
        optiona=findViewById(R.id.optiona);
        optionb=findViewById(R.id.optionb);
        optionc=findViewById(R.id.optionc);
        optiond=findViewById(R.id.optiond);

        cardA=findViewById(R.id.cardA);
        cardB=findViewById(R.id.cardB);
        cardC=findViewById(R.id.cardC);
        cardD=findViewById(R.id.cardD);

        imgback=findViewById(R.id.imgback);
        Txtcekil=findViewById(R.id.Txtcekil);

        Btnseyirci=findViewById(R.id.Btnseyirci);
        Btnyariyariya=findViewById(R.id.Btnyariyariya);
        Btnzamandurdurma=findViewById(R.id.Btnzamandurdurma);
    }


    public void Correct(CardView cardx)
    {
        countDownTimer.cancel();
        timerValue=20;
        cardx.setCardBackgroundColor(getResources().getColor(R.color.green));
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nextBtn.setClickable(false);
                countDownTimer.start();
                index++;
                enableButton();
                if(questionCount<=4)
                {
                    modelClass=listeasy.get(index);
                }
                else if(questionCount>4 && questionCount<=7)
                {
                    modelClass=listmiddle.get(index);
                }
                else if(questionCount>7&&questionCount<=9)
                {
                    modelClass=listdifficult.get(index);
                }
                else
                {
                    GameSaved();
                }
                questionCount++;
                resetColor();
                setAllData();
            }
        });

    }



    private void GameSaved() {
        Intent intent=new Intent(Game.this,SaveGame.class);
        intent.putExtra("score","1000000");
        startActivity(intent);
    }

    public void enableButton()
    {
        cardA.setClickable(true);
        cardB.setClickable(true);
        cardC.setClickable(true);
        cardD.setClickable(true);
    }

    public void disableButton()
    {
        cardA.setClickable(false);
        cardB.setClickable(false);
        cardC.setClickable(false);
        cardD.setClickable(false);
    }

    public void resetColor()
    {
        cardA.setCardBackgroundColor(getResources().getColor(R.color.white));
        cardB.setCardBackgroundColor(getResources().getColor(R.color.white));
        cardC.setCardBackgroundColor(getResources().getColor(R.color.white));
        cardD.setCardBackgroundColor(getResources().getColor(R.color.white));
    }

    public void OptianAClick(View view) {
        nextBtn.setClickable(true);
        disableButton();
        if(modelClass.getaA().equals(modelClass.getAns()))
        {
            cardA.setCardBackgroundColor(getResources().getColor(R.color.green));

            if(index<listeasy.size()-1 ||index<listmiddle.size()-1||index<listdifficult.size()-1)
            {
                nextBtn.setClickable(true);
                Correct(cardA);
            }
            else
            {
                GameSaved();
            }
        }
        else
        {
            nextBtn.setClickable(false);
            countDownTimer.cancel();
            timer2.start();
            Check();
            cardA.setCardBackgroundColor(getResources().getColor(R.color.red));


        }
    }

    public void OptianBClick(View view) {

        nextBtn.setClickable(true);
        disableButton();
        if(modelClass.getaB().equals(modelClass.getAns()))
        {
            cardB.setCardBackgroundColor(getResources().getColor(R.color.green));

            if(index<listeasy.size()-1 ||index<listmiddle.size()-1||index<listdifficult.size()-1)
            {
               Correct(cardB);
            }
            else
            {
                GameSaved();
            }
        }
        else
        {
            nextBtn.setClickable(false);
            countDownTimer.cancel();
            timer2.start();
            Check();
            cardB.setCardBackgroundColor(getResources().getColor(R.color.red));

        }
    }

    public void OptianCClick(View view) {
        nextBtn.setClickable(true);
        disableButton();
        if(modelClass.getaC().equals(modelClass.getAns()))
        {
            cardC.setCardBackgroundColor(getResources().getColor(R.color.green));

            if(index<listeasy.size()-1 ||index<listmiddle.size()-1||index<listdifficult.size()-1)
            {
                Correct(cardC);
            }
            else
            {
                GameSaved();
            }
        }
        else
        {
            nextBtn.setClickable(false);
            countDownTimer.cancel();
            timer2.start();
            Check();
            cardC.setCardBackgroundColor(getResources().getColor(R.color.red));

        }
    }

    public void OptianDClick(View view) {
        nextBtn.setClickable(true);
        disableButton();
        if(modelClass.getaD().equals(modelClass.getAns()))
        {
            cardD.setCardBackgroundColor(getResources().getColor(R.color.green));

            if(index<listeasy.size()-1 ||index<listmiddle.size()-1||index<listdifficult.size()-1)
            {

                Correct(cardD );
            }
            else
            {
                GameSaved();
            }
        }
        else
        {
            nextBtn.setClickable(false);
            countDownTimer.cancel();
            timer2.start();
            Check();
            cardD.setCardBackgroundColor(getResources().getColor(R.color.red));

        }
    }

    public void Check()
    {
        if(modelClass.getaA().equals(modelClass.getAns()))
        {
            cardA.setCardBackgroundColor(getResources().getColor(R.color.green));
        }
        if(modelClass.getaB().equals(modelClass.getAns()))
        {
            cardB.setCardBackgroundColor(getResources().getColor(R.color.green));
        }
        if(modelClass.getaC().equals(modelClass.getAns()))
        {
            cardC.setCardBackgroundColor(getResources().getColor(R.color.green));
        }
        if(modelClass.getaD().equals(modelClass.getAns()))
        {
            cardD.setCardBackgroundColor(getResources().getColor(R.color.green));
        }
    }
    public void WrongAnswer()
    {
        Dialog dialog=new Dialog(Game.this);
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
        dialog.setContentView(R.layout.activity_lose_game);

        dialog.findViewById(R.id.btn_repeat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Game.this,Game.class);
                startActivity(intent);
            }
        });

        dialog.findViewById(R.id.btn_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Game.this,HomePage.class);
                startActivity(intent);
            }
        });
        dialog.show();
    }
}