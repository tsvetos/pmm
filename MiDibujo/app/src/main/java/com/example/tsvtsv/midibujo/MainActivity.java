package com.example.tsvtsv.midibujo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    View vista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // MiDibujo mio= new MiDibujo(this);
        setContentView(R.layout.activity_main);
        vista = (View)findViewById(R.id.drawing_area);
       // setContentView(mio);

    }

   /* public class MiDibujo extends View {
        private ShapeDrawable miDrawable;

        public MiDibujo(Context contexto) {
            super(contexto);
        }

        public MiDibujo (Context c, AttributeSet a){
            super(c,a);
        }

        @Override
        protected void onDraw(Canvas canvas) {

            Paint pincel1 = new Paint();
            pincel1.setColor(Color.RED);
            pincel1.setStyle(Paint.Style.STROKE);
            pincel1.setTextSize(60);
            pincel1.setTextAlign(Paint.Align.CENTER);


            canvas.drawCircle(540, 792, 450, pincel1);



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


            canvas.drawRect(x,y , (ancho/3)+x,  y + alto, paint);

            //Cuadrado derecha


            paint.setColor(Color.parseColor("#000000"));

            canvas.drawRect(50, 50, 200, 200, paint);
            canvas.drawRect(1000, 50, 850, 200, paint);
            canvas.drawRect(50, 1100, 200, 900, paint);

        }


    } */


}



