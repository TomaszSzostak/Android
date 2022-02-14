package com.swiscon.tanks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Bitmap;
import android.view.Window;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;

public class MainActivity extends AppCompatActivity {
    Bitmap bitmap ;//=
    Canvas canvas ;//= new Canvas(output);
    ImageView img;
    Game gra;           // Główna klasa gry
    // Metoda wykonywana po uruchomieniu aplikacji
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();                       // ukrycie gornej belki tytułowej
        setContentView(R.layout.activity_main);
        gra = new Game((ImageView)findViewById(R.id.imageView));
      //  gra.img =  (ImageView)findViewById(R.id.imageView);

        gra.kolor_tla =  ResourcesCompat.getColor(      getApplicationContext().getResources(),
                                                        R.color.tlo,
                                                        getApplicationContext().getTheme());
       // if (gra!=null) gra.PierwszeUruchomienie();

        gra.kolor_gor =  ResourcesCompat.getColor(      getApplicationContext().getResources(),
                R.color.gory,
                getApplicationContext().getTheme());
        gra.punktacja.kolor_tla = gra.kolor_tla;
        gra.tank_1.KOLOR_T =  ResourcesCompat.getColor(      getApplicationContext().getResources(),
                R.color.czolg1,
                getApplicationContext().getTheme());
        gra.tank_2.KOLOR_T =  ResourcesCompat.getColor(      getApplicationContext().getResources(),
                R.color.czolg2,
                getApplicationContext().getTheme());
        gra.kolor_pocisku =  ResourcesCompat.getColor(      getApplicationContext().getResources(),
                R.color.pocisk,
                getApplicationContext().getTheme());

//gra.pedzel.setColor(gra.kolor_tla );
        if (gra!=null) gra.GenerujPlansze();
        //getApplicationContext()
    }
//---------- metody glownej klasu OnClick -----------------------
public void Lewo(View view) {
    gra.tank_1.pokaz(gra.canvas, gra.kolor_tla);
        gra.tank_1.X_T-=5; gra.tank_1.Y_T--;
        gra.Spad();
        gra.tank_1.pokaz(gra.canvas, gra.tank_1.KOLOR_T);
}
    public void Prawo(View view) {
        gra.tank_1.pokaz(gra.canvas, gra.kolor_tla);
        gra.tank_1.X_T+=5; gra.tank_1.Y_T--;
        gra.Spad();
        gra.tank_1.pokaz(gra.canvas, gra.tank_1.KOLOR_T);
    }
    public void GoraLufa(View view) {
        gra.tank_1.pokaz(gra.canvas, gra.kolor_tla);

        gra.tank_1.KAT_T++;//X_T+=5; gra.tank_1.Y_T--;
        //gra.Spad();
        gra.tank_1.pokaz(gra.canvas, gra.tank_1.KOLOR_T);
        //gra.img. draw(gra.canvas);
    }
    public void DolLufa(View view) {
        gra.tank_1.pokaz(gra.canvas, gra.kolor_tla);

        gra.tank_1.KAT_T--;//X_T+=5; gra.tank_1.Y_T--;
        //gra.Spad();
        gra.tank_1.pokaz(gra.canvas, gra.tank_1.KOLOR_T);
        //gra.img. draw(gra.canvas);
    }
    public void SilaMinus(View view) {
        if (gra.tank_1.V>10) gra.tank_1.V -= 10;
        gra.punktacja.PokazSile(gra.canvas,gra.tank_1);
    }
    public void SilaPlus(View view) {
        if (gra.tank_1.V<100) gra.tank_1.V += 10;
        gra.punktacja.PokazSile(gra.canvas,gra.tank_1);
     ////   Paint pen = new Paint();
     //   canvas = new Canvas(gra.bitmap);

       // pen.setColor(Color.BLACK);
       // gra.canvas.drawCircle(gra.tank_1.X_T,200,5,pen);
       // canvas.drawCircle(gra.tank_1.X_T,250,5,pen);

    }
    // metoda wykonujaca wystrzal z lufy
    public void Strzal(View view) {

        //float i =0;
        // watek pocisku
        //new Thread(new Runnable() {
        //    @Override
        //    public void run() {
                float x = gra.tank_1.X_T;
                float y = gra.tank_1.Y_T;
                float vx = (float)Math.cos((float)Math.toRadians(gra.tank_1.KAT_T));
                float vy = (float)Math.sin((float)Math.toRadians(gra.tank_1.KAT_T));

                float xl = x+vx*gra.tank_1.DL_T;
                float yl = y-vy*gra.tank_1.DL_T;
                x = xl; y = yl-4;

                for(float i=0; i<10; i+=0.01f) {
                    gra.pedzel.setColor(gra.kolor_pocisku);
                    gra.canvas.drawCircle(x, y, 2, gra.pedzel);
                    x += vx;
                    y -= vy - i*i/2.0f ;
                    
                   for(int a=0; a<99;a++) for(int b=0; b<9999;b++)b++;
                  // repaint();
                   //gra.img.isDrawingCacheEnabled();
                }
        //    }
        //}).start();

        //gra.canvas.drawLine(x,y, x+60,y+60, gra.pedzel);
      //  gra.img.draw(gra.canvas);

    }



        public static Bitmap getBitmap(Canvas canvas) {
        // mBitmap is a private value inside Canvas.
        // time for some dirty reflection:
        try {
            java.lang.reflect.Field field = Canvas.class.getDeclaredField("mBitmap");
            field.setAccessible(true);
            return (Bitmap)field.get(canvas);
        }
        catch (Throwable t) {
            return null;
        }
    }
}