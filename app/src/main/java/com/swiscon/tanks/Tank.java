package com.swiscon.tanks;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Tank {
    int X_T,Y_T;        // pozycja
    int KAT_T;          // kąt strzału
    int V, Vmax;        // prędkość, prędkość max
    int KOLOR_T;        // kolor czołgu
    int ZYCIE_T;        // ilość żyć - 0 to koniec gry
    int DL_T, D_T;      // długość lufy, długość czołgu
    Paint pedzel;       //
    //---------------------------------  konstruktor -----------------------------------------------
    public Tank(){pedzel = new Paint();};
    //----------------------- metoda ustawiajaca wspolrzedne czolgu i kat lufy ---------------------
    public void set(int x, int y, int kat){
        X_T = x ; Y_T = y; KAT_T = kat;
    };
    //-------------------------- metoda rysujaca  czołg na kanwie ----------------------------------
    void pokaz(Canvas canvas, int kolor){

     //   pedzel.setARGB(255, 255,255,0); //Czerwony
        pedzel.setColor(kolor);//KOLOR_T);
        pedzel.setStrokeWidth(2);
        canvas.drawLine(X_T-D_T, Y_T, X_T+D_T, Y_T, pedzel); //Rysujemy według podanych współrzędnych za pomocą pędzla
        canvas.drawLine(X_T-D_T/2, Y_T-2, X_T+D_T/2, Y_T-2, pedzel); //Rysujemy według podanych współrzędnych za pomocą pędzla

        canvas.drawLine(X_T-D_T/2, Y_T-4, X_T+D_T/2, Y_T-4, pedzel); //Rysujemy według podanych współrzędnych za pomocą pędzla
DL_T=D_T;
        canvas.drawLine(    X_T,  Y_T-4,
                    X_T+(float)(DL_T*Math.cos(Math.toRadians(KAT_T))),
                    Y_T-(float)(DL_T*Math.sin(Math.toRadians(KAT_T)))-4, pedzel); //Rysujemy według podanych współrzędnych za pomocą pędzla
    };
    void lewo(){};
    void prawo(){};
    void kat_plus(){};
    void kat_minus(){};

}
