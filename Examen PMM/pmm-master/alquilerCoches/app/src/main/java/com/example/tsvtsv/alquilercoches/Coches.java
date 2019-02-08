package com.example.tsvtsv.alquilercoches;

import java.io.Serializable;

public class Coches implements Serializable {
    private int id;
    private String modelo;
    private String fabricante;
    private String precio;

    public Coches (int id, String modelo, String fabricate, String precio) {
        this.id = id;
        this.modelo = modelo;
        this.fabricante = fabricate;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getPrecio() {
        return precio;
    }
}
