package com.bot.java_coach.model.dto;

public class CapitulosDto {
    private int id_capitulo;
    private int numeroCapitulo;
    private String nombreCapitulo;
    private int id_nivel;



    public CapitulosDto(int id_capitulo, int numeroCapitulo, String nombreCapitulo, int id_nivel){
        this.id_capitulo = id_capitulo;
        this.numeroCapitulo = numeroCapitulo;
        this.nombreCapitulo = nombreCapitulo;
        this.id_nivel = id_nivel;

    }

    public int getId_capitulo() {
        return id_capitulo;
    }

    public void setId_capitulo(int id_capitulo) {
        this.id_capitulo = id_capitulo;
    }

    public int getId_nivel() {
        return id_nivel;
    }

    public void setId_nivel(int id_nivel) {
        this.id_nivel = id_nivel;
    }

    public int getNumeroCapitulo() {
        return numeroCapitulo;
    }

    public void setNumeroCapitulo(int numeroCapitulo) {
        this.numeroCapitulo = numeroCapitulo;
    }

    public String getNombreCapitulo() {
        return nombreCapitulo;
    }

    public void setNombreCapitulo(String nombreCapitulo) {
        this.nombreCapitulo = nombreCapitulo;
    }



}
