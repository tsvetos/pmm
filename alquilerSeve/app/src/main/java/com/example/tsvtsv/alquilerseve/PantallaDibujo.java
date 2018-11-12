package com.example.tsvtsv.alquilerseve;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PantallaDibujo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new EjemploView(this));
    }

    public class EjemploView extends View {
        private ShapeDrawable miDrawable;
        public EjemploView(Context contexto){
            super(contexto);
        }
        @Override
        protected void onDraw(Canvas canvas){

            int anchura = getWidth();
            int altura = getHeight();

            Paint pincel1 = new Paint();
            pincel1.setColor(Color.RED);
            pincel1.setStyle(Paint.Style.STROKE);
            pincel1.setTextSize(60);
            pincel1.setTextAlign(Paint.Align.CENTER);


            canvas.drawCircle(540,792,450,pincel1);


            canvas.drawText("MI CIRCULO",540,792,pincel1);



            //Otra forma

            int x = 500; int y = 1300;
            int ancho = 300, alto= 500;
            miDrawable = new ShapeDrawable(new OvalShape());
            miDrawable.getPaint().setColor(0xff0000ff);
            miDrawable.setBounds(x,y, x + ancho, y + alto);

            miDrawable.draw(canvas);
        }
    }
}