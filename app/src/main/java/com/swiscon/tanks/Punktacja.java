package com.swiscon.tanks;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.graphics.Typeface;

public class Punktacja {
    int zycie_1,zycie_2;    // stan zycia zawodnikow 0-100
    int sila_1, sila_2;     // sila strzalow
    int kat_1, kat_2;       // kat wystrzalu
    int x1,y1,x2,y2;        // obszar wyswietlania punktacji
    Paint pedzel;           //  pedzel do rysowania
    int kolor_tla;

    // ----------- konstruktor klasy tworz nowy obiekt pain i wspolrzedne obszaru punktacji --------
    public Punktacja(int x1, int y1, int x2, int y2){
        pedzel = new Paint();
        this.x1=x1;this.y1=y1;this.x2=x2;this.y2=y2;};
    //---------------------- metoda ukazująca punktacje na ekranie ---------------------------------
    void PokazPunktacje( Tank t1, Tank t2,Canvas canvas){
        pedzel.setStrokeWidth(1);
        pedzel.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
        //this.pedzel.setColor(kolor_tla);
      //  pedzel.setColor(Color.BLACK);
       // canvas.drawRect(x1,y1,x2,y2,pedzel);
        pedzel.setColor(Color.WHITE);
       // canvas.drawLine(0, 10, 800, 70, pedzel);
        pedzel.setTextSize(14);
        canvas.drawText("PLAYER 1",x1+30,3*(y1+y2)/4,pedzel);
        canvas.drawText("PLAYER 2",x2-80,3*(y1+y2)/4,pedzel);

        //canvas.drawText(Integer.toString(20),200,40,pedzel);
        PokazSile(canvas,t1);
        PokazZycie(t1,t2,canvas);
    };
    void PokazSile(Canvas canvas,Tank t){
        int ds=150;
        int xsila = (int)(150.0f*((float)t.V/100.0f));
        int xx1=(x1+x2)/2-ds/2; int yy1 = (y1+y2)/4;
        int xx2=(x1+x2)/2+ds/2; int yy2 = 3*(y1+y2)/4;
        pedzel.setColor(Color.WHITE);
        pedzel.setStyle(Paint.Style.STROKE);
        canvas.drawRect(xx1,yy1,xx2,yy2,pedzel);
        pedzel.setStyle(Paint.Style.FILL);

        pedzel.setColor(Color.DKGRAY);
        canvas.drawRect(xx1+1,yy1+1,xx2-1,yy2,pedzel);
        pedzel.setColor(kolor_tla);
        canvas.drawRect(xx1+1+xsila,yy1+1,xx2,yy2,pedzel);
    }

    void PokazZycie(Tank t1, Tank t2,Canvas canvas) {
        int x = 120; int y = (y1+y2)/2;
        //t1.ZYCIE_T=3;
        for(int i=0; i<5; i++) {
            x = 120+i*20;
            pedzel.setColor(Color.WHITE);
            pedzel.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(x, y, 7, pedzel);
            canvas.drawCircle(x, y, 6, pedzel);
            pedzel.setStyle(Paint.Style.FILL);
            if (t1.ZYCIE_T>i) pedzel.setColor(Color.DKGRAY); else pedzel.setColor(kolor_tla);
            canvas.drawCircle(x, y, 5, pedzel);
        }
        //t2.ZYCIE_T=2;
        for(int i=0; i<5; i++) {
            x = 680-i*20;
            pedzel.setColor(Color.WHITE);
            pedzel.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(x, y, 7, pedzel);
            canvas.drawCircle(x, y, 6, pedzel);
            pedzel.setStyle(Paint.Style.FILL);
            if (t2.ZYCIE_T>i) pedzel.setColor(Color.DKGRAY); else pedzel.setColor(kolor_tla);
            canvas.drawCircle(x, y, 5, pedzel);
        }

    }

}
