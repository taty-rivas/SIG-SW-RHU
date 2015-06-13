/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sherwinca.actions;


import com.sherwinca.entidades.Disponible;
import com.sherwinca.entidades.HibernateUtil;
import com.sherwinca.entidades.SigPersonaldisponible;
import java.io.Serializable;

import java.util.ArrayList;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;


/**
 *
 * @author Miguel
 */
@ManagedBean
@ViewScoped
public class personalDisponibleBean implements Serializable{
    
    private List<Disponible> lista = new ArrayList();
    private String vcMes; /*CAPTURA LA SELECCION DEL COMBOBOX MES DE TACTICO.XHTML*/
    private int iAnio; /*CAPTURA LA SELECCION DEL COMBOBOX ANIO DE TACTICO.XHTML*/
    
     public personalDisponibleBean() { /*CONSTRUCTOR*/
    }

    public List<Disponible> getLista() {
        return lista;
    }

    public void setLista(List<Disponible> lista) {
        this.lista = lista;
    }

    public String getVcMes() {
        return vcMes;
    }

    public void setVcMes(String vcMes) {
        this.vcMes = vcMes;
    }

    public int getiAnio() {
        return iAnio;
    }

    public void setiAnio(int iAnio) {
        this.iAnio = iAnio;
    }

    
     
     
    
 
    public void listar(){
        Session session = null;
        List<SigPersonaldisponible> list = null;
  
        try {            
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from SigPersonaldisponible r where r.vc_mes_disponible like'"+vcMes+"' AND r.i_anio_disponible ='"+iAnio+"'" );            
            list = (List<SigPersonaldisponible>) query.list();
            
            for (SigPersonaldisponible elem : list) {            
                Disponible row = new Disponible();                              
                row.setNombre(elem.getVcNmbempDisponible());
                row.setApellido(elem.getVcApDisponible());
                row.setArea(elem.getVcAreaDisponible());
                row.setHoras(elem.getiHoraDisponible());
                row.setMes(elem.getVcMesDisponible());
                
                lista.add(row);

            }

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
        }
    
    }
    
    
    
    /**
     * Creates a new instance of personalDisponibleBean
     */
   
    
}
