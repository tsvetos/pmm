package com.example.tsvtsv.adaptadortitulares;


import java.io.Serializable;

public class Titular implements Serializable {

    private String titulo;
    private String subtitulo;
    int image;


    int getImagen(){
        return image;
    }

    public Titular(String tit, String sub, int img1){
        titulo = tit;
        subtitulo = sub;
        image = img1;

    }

    public String getTitulo(){
        return titulo;
    }

    public String getSubtitulo(){
        return subtitulo;
    }
}
