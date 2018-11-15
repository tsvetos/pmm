package com.example.seve0.tareaenvios;

public class Destino {
    private int zona, precio;
    private String continente;

    public Destino(int zona) {
        this.zona = zona;
        setZona(zona);
    }

    public void setZona(int zona) {
        this.zona = zona;
        if(zona == 1)
            setPrecioContinente(30, "Asia y Oceanía");
        else if(zona == 2)
            setPrecioContinente(20, "Ámerica y África");
        else
            setPrecioContinente(10, "Europa");
    }

    private void setPrecioContinente(int p, String s){
        this.precio = p;
        this.continente = s;
    }

    public int getZona() {
        return zona;
    }

    public int getPrecio() {
        return precio;
    }

    public String getContinente() {
        return continente;
    }

    @Override
    public String toString(){
        return continente;
    }
}
