package com.swiscon.tanks;

import android.graphics.Bitmap;
import android.graphics.Canvas;
//import android.graphics.Color;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.ImageView;
import android.content.Context;
//import androidx.core.content.res.ResourcesCompat;
//import android.content.res.Resources;
//import android.app.Activity;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.content.ContextCompat;

public class Game {
    int GRACZ;
    int GRA_AKTYWNA;
    int kolor_tla, kolor_gor, kolor_pocisku;
    Bitmap bitmap ;//=
    Canvas canvas ;//= new Canvas(output);
    ImageView img;
    Paint pedzel;
    Context context;
    Tank tank_1, tank_2;
    Punktacja punktacja;
    public Game(ImageView img_){
        img = img_;
        bitmap = Bitmap.createBitmap(800,450, Bitmap.Config.ARGB_8888);
        img.setImageBitmap(bitmap);
        canvas = new Canvas(bitmap);
        pedzel = new Paint();
        //------------- stworzenie i ustawienia czolgów -----------------
        tank_1 = new Tank();
        tank_1.set(100,10,45); tank_1.D_T = 20;
        tank_2 = new Tank();
        tank_2.set(700,10,135); tank_2.D_T = 20;
        tank_1.ZYCIE_T = 3;  tank_2.ZYCIE_T = 2;
        tank_1.Vmax = 100;      tank_1.V = 80;
        tank_2.Vmax = 100;      tank_2.V = 80;
        //-----------------  stworzenie i ustalenie punktacji ------------------------
        punktacja = new Punktacja(0,0,800,20);
        // punktacja.zycie_1 = 100;    punktacja.zycie_2 = 100;
        // punktacja.sila_1 = 50;      punktacja.sila_2 = 50;
        //punktacja.kolor_tla = kolor_tla;
    }

    void PierwszeUruchomienie(){
       // img =  (ImageView)findViewById(R.id.imageView);


      //  GenerujPlansze();

    };

    //-------------metoda swobodnego opadania czolgu -------------
    void Spad(){
int kolor_test; int y=0; tank_1.Y_T = 40;
       kolor_test = bitmap.getPixel(tank_1.X_T,tank_1.Y_T);
       int x = tank_1.X_T;
       while(bitmap.getPixel(x,tank_1.Y_T)==kolor_tla) {
           x = tank_1.X_T-tank_1.D_T;
           tank_1.Y_T++;
           while ((bitmap.getPixel(x,tank_1.Y_T)==kolor_tla)&&(x<(tank_1.X_T+tank_1.D_T))){
              x++;
               //   pedzel.setARGB(255, 0,0,255); //Czarny + przezroczystość
               //   canvas.drawLine(0, 30, 320, 30, pedzel);
           }
       };
        tank_1.Y_T--;

    };

    void GenerujPlansze(){
        pedzel.setColor(kolor_tla );
        pedzel.setStrokeWidth(2);
        for(int i=0; i<800; i++){                   // Generowanie gor
            float y_ = (float)200+(float)Math.cos(2*6.28*i/800)*(float)Math.sin(6.28*i/800)*100;
            pedzel.setColor(kolor_tla);
            canvas.drawLine(i, 0, i, y_, pedzel);
            pedzel.setColor(kolor_gor );
            canvas.drawLine(i, y_, i, 450, pedzel);
        }
        Spad();
        tank_1.pokaz(canvas,tank_1.KOLOR_T);
        //tank_2.pokaz(canvas, tank_1.KOLOR_T);     // wyswietlenie czolgow
        punktacja.PokazPunktacje(tank_1,tank_2,canvas);
        //  img.draw(canvas);
    };
}
