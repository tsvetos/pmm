package com.example.tsvtsv.solobici;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

public class Grafico {
    private Drawable drawable; // Imagen
    //Posición en la pantalla y velocidad de desplazamiento
    private double posX, posY, incX, incY;
    private int ancho, alto; // Dimensiones de la imagen
    private int angulo, rotacion;// Ángulo y velocidad rotación
    private int radioColision; // Para determinar si chocamos con algún objeto
    private View view;    // Vista donde dibujamos el gráfico
    public static final int maxVelocidad = 20;

    public Grafico(View view, Drawable drawable) {
        this.view = view;
        this.drawable = drawable;
        ancho = drawable.getIntrinsicWidth();
        alto = drawable.getIntrinsicHeight();
        radioColision = (alto + ancho) / 4;
    }

    public static double getMaxVelocidad() {
        return maxVelocidad;
    }

    public void dibujaGrafico(Canvas canvas) {
        canvas.save();
        int x = (int) (posX + ancho / 2);
        int y = (int) (posY + alto / 2);
        canvas.rotate((float) angulo, (float) x, (float) y);
        drawable.setBounds((int) posX, (int) posY, (int) posX + ancho,
                (int) posY + alto);
        drawable.draw(canvas);
        canvas.restore();
        //Calculo área donde no podrán solaparse/chocar
        //otros gráficos con este
        int rInval = (int) distanciaE(0, 0, ancho, alto) / 2 + maxVelocidad;
        view.invalidate(x - rInval, y - rInval, x + rInval, y + rInval);
    }


    public void incrementaPos() {
        posX += incX;
        // Si salimos de la pantalla, corregimos posición
        if (posX < -ancho / 2) {
            posX = view.getWidth() - ancho / 2;
        }
        if (posX > view.getWidth() - ancho / 2) {
            posX = -ancho / 2;
        }
        posY += incY;
        // Si salimos de la pantalla, corregimos posición
        if (posY < -alto / 2) {
            posY = view.getHeight() - alto / 2;
        }
        if (posY > view.getHeight() - alto / 2) {
            posY = -alto / 2;
        }
        angulo += rotacion; // Actualizamos ángulo
    }

    public double distancia(Grafico g) { return distanciaE(posX, posY, g.posX, g.posY); }

    public boolean verificaColision(Grafico g) {
        return (distancia(g) < (radioColision + g.radioColision)); }

    public static double distanciaE(double x, double y, double x2, double y2) {
        return Math.sqrt((x - x2) * (x - x2) + (y - y2) * (y - y2)); }


    public void setIncX(double incX) { this.incX = incX; }

    public void setIncY(double incY) { this.incY = incY; }

    public void setAngulo(int angulo) { this.angulo = angulo; }

    public void setRotacion(int rotacion) { this.rotacion = rotacion; }

    public int getAncho() { return ancho; }

    public int getAlto() { return alto; }

    public void setPosX(double posX) { this.posX = posX; }

    public void setPosY(double posY) { this.posY = posY; }

    public int getAngulo() { return angulo; }

    public double getIncX() { return incX;  }

    public double getIncY() { return incY; }
}