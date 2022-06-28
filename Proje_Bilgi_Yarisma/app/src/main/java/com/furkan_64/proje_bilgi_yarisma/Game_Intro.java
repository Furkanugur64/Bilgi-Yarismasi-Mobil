package com.furkan_64.proje_bilgi_yarisma;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Game_Intro extends AppCompatActivity {

    public static ArrayList<ModelClass> listeasy;
    public static ArrayList<ModelClass> listmiddle;
    public static ArrayList<ModelClass> listdifficult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_intro);


          // Kolay Sorular
          listeasy=new ArrayList<>();
          listeasy.add(new ModelClass("Türkiye'nin Başkenti Neresidir ?","Konya","İstanbul","Ankara","İzmir","Ankara"));
          listeasy.add(new ModelClass("5 yıl önce aralarındaki yaş farkı 10 olan iki kişinin 20 yıl sonra aralarındaki yaş farkı kaç olur ?","20","30","10","35","10"));
          listeasy.add(new ModelClass("Yüzde yirmisi elli eden sayının yüzde ellisi kaçtır ? ","250","200","125","100","125"));
          listeasy.add(new ModelClass("Biyoloji derslerinde Mitoz ve Mayoz başlıkları altında incelenen hangisi olur ? ","Sinir sistemi","Hücre bölünmesi","Solunum sistemi","Duyu organları","Hücre bölünmesi"));
          listeasy.add(new ModelClass("Uğur böceği'nin diğer adı nedir ?","Kaçkaç böceği","Uçuç böceği","Konkon böceği","Ötöt böceği","Uçuç böceği"));
          listeasy.add(new ModelClass("Hangisi emlak ilanlarını incelerken daha sık karşılaşılan bir ifadedir ?","Düzayak","Düzbıyık","Düzel","Düzkaş","Düzayak"));
          listeasy.add(new ModelClass("Türkiye'nin adı iki harften oluşan tek ilçesi hangi coğrafi bölgededir ?","Ege Bölgesi","Marmara Bölgesi","Karadeniz Bölgesi","Akdeniz Bölgesi","Karadeniz Bölgesi"));
          listeasy.add(new ModelClass("Toplamda kaç dünya savaşı olmuştur ?","1","2","3","4","2"));
          listeasy.add(new ModelClass("497 x 33 işleminin sonucu kaçtır ?","18.324","19.676","17.893","16.401","16.401"));
          listeasy.add(new ModelClass("Hangi kaleci, Türkiye Futbol Süper Ligi Kariyerinde gol atmıştır ?","Volkan Demirel","Rüştü Reçber","Fernando Muslera","Claduio Taffarel","Fernando Muslera"));
          listeasy.add(new ModelClass("Hangisinin kendisiyle çarpımı daha büyüktür ?","-6","-2","0","4","-6"));
          listeasy.add(new ModelClass("Hangisi tuz ruhu'nun diğer adıdır ?","Hidroklorik asit","Nitrik asit","Asetik Asit","Sülfirik Asit","Hidroklorik asit"));
          listeasy.add(new ModelClass("Uefa kupasını alan ilk türk takımı hangisidir","Beşiktaş","Galatasaray","Fenerbahçe","Trabzonspor ","Galatasaray"));
          listeasy.add(new ModelClass("Türkiyenin uluslararası telefon kodu kaçtır ?","90","01","49","32","90"));
          listeasy.add(new ModelClass("Saygı bildirmek için kadın adlarının sonuna getirilen veya adların yerine kullanılan ifadenin doğrı yazılışı hangisidir ?","Hanfendi","Hamfendi","Hanımefendi","Hağnımefendi","Hanımefendi"));

          //Orta Sorular
          listmiddle=new ArrayList<>();
          listmiddle.add(new ModelClass("Türkçede hangi adda bir renk vardır ?","Dore","Mifa","Solla","Sido","Dore"));
          listmiddle.add(new ModelClass("Hangi adda bir lokum türü yoktur ?","Paşa lokumu","Sultan lokumu","Sadrazam lokumu","Kazasker lokumu","Kazasker lokumu"));
          listmiddle.add(new ModelClass("Voleybolda bir oyuncunun, blok yapan arkadaşının arkasında bıraktığı boşluğu doldurmasını anlatan terim hangisidir ?","Miksaj","Kolaj","Markaj","Dublaj","Dublaj"));
          listmiddle.add(new ModelClass("29 harfli Türkçe alfabedeki toplam sessiz harf sayısı ile sesli harf sayısı arasındaki fark kaçtır ?","12","13","14","15","13"));
          listmiddle.add(new ModelClass("Karpuzun henüz olgunlaşmamış, büyümemiş hâline ne ad verilir ?","Çağla","Koruk","Koçan","Şalak","Şalak"));
          listmiddle.add(new ModelClass("Caz müziği çalan orkestraya ne ad verilir ?","Cazbant","Cazgır","Cazkâr" ,"Cazman","Cazbant"));
          listmiddle.add(new ModelClass("Hindistan'ın hangi ülkeyle sınırı yoktur ?","Rusya","Çin","Pakistan","Nepal","Rusya"));
          listmiddle.add(new ModelClass("Kazanç ve kâr payı anlamlarına gelen ifade hangisidir ?","İskonto","Temettü","Asgari Tutar","Harç","Temettü"));
          listmiddle.add(new ModelClass("TDK sözlüğüne göre, folklor kelimesi hangi anlama gelir ?","Halk dansı","Halk topluluğu","Halk bilimi","Halk deyişi","Halk bilimi"));
          listmiddle.add(new ModelClass("Hangisi, Anadolu'da kurulan beyliklerden biri değildir ?","Malkoçoğulları","Candaroğulları","Ramazanoğulları","Germiyanoğulları","Malkoçoğulları"));
          listmiddle.add(new ModelClass("Histoloji Nedir ?","Tarih Bilimi","Duygu Bilimi","Doku Bilimi","Ruh Bilimi","Doku Bilimi"));
          listmiddle.add(new ModelClass("1861'de kurulan İtalya Krallığı'nın ilk başkenti neresidir ?","Floransa","Torino","Roma","Milano","Torino"));
          listmiddle.add(new ModelClass("Hangi adda ünlü bir cheesecake çeşidi vardır ?","San Marco","San Sebastian","San Martin","San Francisco","San Sebastian"));
          listmiddle.add(new ModelClass("İşaret olarak veya çeşitli amaçlarla kullanılan küçük bayrağa ne ad verilir ?","Flama","Paraketa","Palanga ","İskandil ","Flama"));
          listmiddle.add(new ModelClass("Türklerin tarihte kaç imparatorlukları vardır ?","13","14","15","16 ","15"));
          listmiddle.add(new ModelClass("Hangi çizgi film kahramanının en sevdiği ve sıkça yediği yiyecek baldır ?","Garfield ","Bugs Bunny","Homer Simpson ","Winnie-the-Pooh","Winnie-the-Pooh"));


          //zor Sorular
          listdifficult=new ArrayList<>();
          listdifficult.add(new ModelClass("Kukumav ve Ishak kuşu hangisinin türleridir ?","Atmaca","Serçe","Baykuş","Martı","Baykuş"));
          listdifficult.add(new ModelClass("Evrende en fazla bulunan iki element hangileridir ?","Azot ve Karbon","Karbon ve Oksijen","Oksijen ve Hidrojen","Hidrojen ve Helyum","Hidrojen ve Helyum"));
          listdifficult.add(new ModelClass("Capitan Miki, Türkiye'de hangi adla bilinen çizgi film karakterinin orjinal adıdır ?","Kaptan Swing","Yüzbaşı Tommiks","Çelik Blek","Miki Fare","Yüzbaşı Tommiks"));
          listdifficult.add(new ModelClass("Seyrisefâin İdaresi eskiden hangisinde faaliyet gösteren bir kurumun adıydı ?","Demir Yolları","Kara Yoları","Deniz Yolları","Hava Yolları","Deniz Yolları"));
          listdifficult.add(new ModelClass("Kutup Yıldızı'nı en gelişmiş teleskoplarla bile göremiyorsanız hangi ülkedesinizdir ?","Kanada","Rusya","Norveç","Güney Amerika","Güney Amerika"));
          listdifficult.add(new ModelClass("Tutunamayanlar ve Tehlikeli Oyunlar romanlarının yazarı kimdir ? ","Yusuf Atılgan","Oğuz Atay","Ahmet Hamdi Tanpınar","Sabahattin Ali","Oğuz Atay"));
          listdifficult.add(new ModelClass("Asprinin ham maddesi olan ağaç hangisidir ?","Çam","Dut","Elma","Söğüt","Söğüt"));
          listdifficult.add(new ModelClass("Büyük İskender'in ölümüyle başlayan tarihî döneme ne ad verilir ?","Germanistik","Helenistik","Skolastik","Slavistik","Helenistik"));
          listdifficult.add(new ModelClass("Periyodik tabloda hangi adda bir element bulunmamaktadır ?","Neptünyum","Plütonyum","Venüsyum","Uranyum","Venüsyum"));
          listdifficult.add(new ModelClass("Reprezantlık mesleğini icra edenlerin müşterileri genellikle kimler olur ?","Midyeciler ve kokoreççiler","Eczacılar ve doktorlar","Kuyumcular ve gözlükçüler","Astronomlar ve arkeologlar","Eczacılar ve doktorlar"));
          listdifficult.add(new ModelClass("Hangi roman kahramanının başyardımcısının adı Samwise Gamgee'dir ?","Harry Potter","Frodo Baggins","Sherlock Holmes","Don Kişot","Frodo Baggins"));
          listdifficult.add(new ModelClass("Hangi kurgusal karakter tıp doktoru olarak bilinmez ?","Richard Kimble","Stephen Strange","Yuri Jivago","Walter White","Walter White"));
          listdifficult.add(new ModelClass("Kur'an-ı Kerim'de hangisi üzerine yemin edilmemiştir ?","Deniz ","Güneş ","Arı","Kalem","Arı"));
          listdifficult.add(new ModelClass("On kıtadan oluşan İstiklal Marşı'nın tamamında, bu kelimelerden hangisi diğerlerinden daha az geçer ? ","Vatan","Kan","Toprak","Yurt","Toprak"));
          listdifficult.add(new ModelClass("Osmanlılarda, cullâh hangisiyle uğraşanlara verilen addır ?","Boyacılık","Dokumacılık","Cerrahlık ","Kuşçuluk","Dokumacılık"));


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                 Intent intent=new Intent(Game_Intro.this,Game.class);
                 startActivity(intent);
            }
        },1500);
    }
}