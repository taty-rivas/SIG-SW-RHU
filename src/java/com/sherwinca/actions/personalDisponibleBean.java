/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sherwinca.actions;


import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.sherwinca.entidades.SigPersonaldisponible;

/**
 *
 * @author Miguel
 */
@ManagedBean
@ViewScoped
public class personalDisponibleBean {
     private static List<SigPersonaldisponible> lista = new ArrayList();

    public  List<SigPersonaldisponible> getLista() {
        return lista;
    }

    public void setLista(List<SigPersonaldisponible> lista) {
        this.lista = lista;
    }
    
    public void listar(){
        SigPersonaldisponible rot = new SigPersonaldisponible ();
        /*PARA LLENAR LA LISTA HAREMOS CICLOS PARA CADA UNO DE LOS CAMPOS */
        
        
        
        rot.setSPkDisponible(20);
        rot.setVcNmbempDisponible("Carlos");
        rot.setVcApDisponible("Vasquez solis");
       /* rot.setDtHoraDisponible("03-25-2015");*/
        rot.setVcMesDisponible("Abril");
        rot.setVcAreaDisponible("Ventas");
      
        
        lista.add(rot);
        
        rot = new SigPersonaldisponible ();
        
        rot.setSPkDisponible(20);
        rot.setVcNmbempDisponible("Miguel");
        rot.setVcApDisponible("Marchelli hernandes");
       /* rot.setDtHoraDisponible("03-25-2015");*/
        rot.setVcMesDisponible("Abril");
        rot.setVcAreaDisponible("Ventas");
        
        lista.add(rot);
    }
    /**
     * Creates a new instance of personalDisponibleBean
     */
    public personalDisponibleBean() {
        SigPersonaldisponible disponible = new SigPersonaldisponible();
    }
    
}
