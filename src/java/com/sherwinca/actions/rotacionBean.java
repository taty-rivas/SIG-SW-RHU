/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sherwinca.actions;

import com.sherwinca.entidades.Rotacion;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author HP
 */
@ManagedBean
@ViewScoped
public class rotacionBean {
    private static List<Rotacion> lista = new ArrayList();

    public  List<Rotacion> getLista() {
        return lista;
    }

    public void setLista(List<Rotacion> lista) {
        this.lista = lista;
    }
    
    public void listar(){
        Rotacion rot = new Rotacion ();
        rot.setNombre("tatiana");
        rot.setApellido("rivas");
        rot.setArea("IT");
        
        lista.add(rot);
        
        rot = new Rotacion ();
        rot.setNombre("tito");
        rot.setApellido("ortiz");
        rot.setArea("Laboratorio");
        
        lista.add(rot);
    }

    /**
     * Creates a new instance of rotacionBean
     */
    public rotacionBean() {
    }
    
}
