package com.example.tsvtsv.androidmenu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.View;

public class MiDibujo extends View {
    private ShapeDrawable miDrawable;

    public MiDibujo(Context contexto) {
        super(contexto);
    }

    public MiDibujo (Context c, AttributeSet a){
        super(c,a);
    }

    @Override
    protected void onDraw(Canvas canvas) {





        super.onDraw(canvas);
        int ancho = getWidth();
        int alto = getHeight();
        int radius;
        radius = 100;
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);


        paint.setColor(Color.parseColor("#000000"));

        paint.setColor(Color.parseColor("#FF0000"));

        int x = getWidth()/2;
        int y = getHeight()/2;
        ancho = 200;
        alto = 100;



        //Cuadrado derecha


        paint.setColor(Color.parseColor("#000000"));


        canvas.drawRect(50, 1100, 200, 900, paint);

    }
}
