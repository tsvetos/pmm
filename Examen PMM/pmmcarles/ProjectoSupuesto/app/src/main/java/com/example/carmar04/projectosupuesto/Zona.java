package com.example.carmar04.projectosupuesto;

import android.widget.ImageView;

import java.io.Serializable;

public class Zona implements Serializable{
    public String continente, nombre, envio;
    public int precio, peso;
    public boolean regalo, dedicatoria;
    public int imagen;

    public Zona(String continente, String nombre, int precio, int peso, String envio, boolean regalo, boolean dedicatoria, int imagen){
        this.continente = continente;
        this.nombre = nombre;
        this.precio = precio;
        this.peso = peso;
        this.envio = envio;
        this.regalo = regalo;
        this.dedicatoria = dedicatoria;
        this.imagen = imagen;
    }
    public void setContinente(String continente){
        this.continente = continente;
    }
    public String getContinente(){
        return this.continente;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setPrecio(int precio){
        this.precio = precio;
    }
    public int getPrecio(){
        return this.precio;
    }
    public void setPeso(int peso){
        this.peso = peso;
    }
    public int getPeso(){
        return this.peso;
    }
    public void setEnvio(String envio){
        this.envio = envio;
    }
    public String getEnvio(){
        return this.envio;
    }
    public void setRegalo(boolean regalo){
        this.regalo = regalo;
    }
    public boolean getRegalo(){
        return this.regalo;
    }
    public void setDedicatoria(boolean dedicatoria){
        this.dedicatoria = dedicatoria;
    }
    public boolean getDedicatoria(){
        return this.dedicatoria;
    }
    public void setImagen(int imagen){
        this.imagen = imagen;
    }
    public int getImagen(){
        return this.imagen;
    }
}