package com.example.guaytambofood;

import java.util.Date;

public class MenuP {
    public String bebidaApp ;
    public String fechaApp ;
    public byte[] fotoSegundoApp;
    public int idApp;
    public String platoFuerteApp;
    public float precioApp;
    public String sopaApp ;

    public MenuP(String bebidaApp, String fechaApp, byte[] fotoSegundoApp, int idApp, String platoFuerteApp, float precioApp, String sopaApp) {
        this.bebidaApp = bebidaApp;
        this.fechaApp = fechaApp;
        this.fotoSegundoApp = fotoSegundoApp;
        this.idApp = idApp;
        this.platoFuerteApp = platoFuerteApp;
        this.precioApp = precioApp;
        this.sopaApp = sopaApp;
    }
    public MenuP() {

    }


    public String getBebidaApp() {
        return bebidaApp;
    }

    public void setBebidaApp(String bebidaApp) {
        this.bebidaApp = bebidaApp;
    }

    public String getFechaApp() {
        return fechaApp;
    }

    public void setFechaApp(String fechaApp) {
        this.fechaApp = fechaApp;
    }

    public byte[] getFotoSegundoApp() {
        return fotoSegundoApp;
    }

    public void setFotoSegundoApp(byte[] fotoSegundoApp) {
        this.fotoSegundoApp = fotoSegundoApp;
    }

    public int getIdApp() {
        return idApp;
    }

    public void setIdApp(int idApp) {
        this.idApp = idApp;
    }

    public String getPlatoFuerteApp() {
        return platoFuerteApp;
    }

    public void setPlatoFuerteApp(String platoFuerteApp) {
        this.platoFuerteApp = platoFuerteApp;
    }

    public float getPrecioApp() {
        return precioApp;
    }

    public void setPrecioApp(float precioApp) {
        this.precioApp = precioApp;
    }

    public String getSopaApp() {
        return sopaApp;
    }

    public void setSopaApp(String sopaApp) {
        this.sopaApp = sopaApp;
    }







}
