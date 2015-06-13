/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sherwinca.entidades;

/**
 *
 * @author Solis
 */
public class Disponible {
    String nombre, apellido, mes, area;
    int anio, horas;

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getMes() {
        return mes;
    }

    public String getArea() {
        return area;
    }

    public int getAnio() {
        return anio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
    
    
}
