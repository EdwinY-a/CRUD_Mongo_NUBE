package com.example.examen_examen_mongo;

public class Automovil {
    int idAutomovil;
    String pais;
    String precio;
    String marca;
    String modelo;
    String trasmision;
    String cilindraje;
    String tipo;

    public Automovil(int idAutomovil, String pais, String precio, String marca, String modelo, String trasmision, String cilindraje, String tipo) {
        this.idAutomovil = idAutomovil;
        this.pais = pais;
        this.precio = precio;
        this.marca = marca;
        this.modelo = modelo;
        this.trasmision = trasmision;
        this.cilindraje = cilindraje;
        this.tipo = tipo;
    }

    public Automovil() {
    }

    public int getIdAutomovil() {
        return idAutomovil;
    }

    public void setIdAutomovil(int idAutomovil) {
        this.idAutomovil = idAutomovil;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTrasmision() {
        return trasmision;
    }

    public void setTrasmision(String trasmision) {
        this.trasmision = trasmision;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
