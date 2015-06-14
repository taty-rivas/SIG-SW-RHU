/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sherwinca.actions;

import com.sherwinca.entidades.CostosSalarios;
import com.sherwinca.entidades.Expediente;
import com.sherwinca.entidades.HibernateUtil;
import com.sherwinca.entidades.SigCostossalarios;
import com.sherwinca.entidades.SigFaltasgraves;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;


@ManagedBean
@ViewScoped
public class expedienteBean implements Serializable{
     private List<Expediente> lista = new ArrayList();
    public String vcMes="ABRIL"; /*CAPTURA LA SELECCION DEL COMBOBOX MES DE TACTICO.XHTML*/
    public int iAnio=2014; /*CAPTURA LA SELECCION DEL COMBOBOX ANIO DE TACTICO.XHTML*/
    /**
     * Creates a new instance of expedienteBean
     */
    public expedienteBean() {
    }

    public List<Expediente> getLista() {
        return lista;
    }

    public void setLista(List<Expediente> lista) {
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
    
    public void listarCostos(){
        Session session = null;
        List<SigFaltasgraves> list = null;
  
        try {            
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from SigFaltasgraves r where  r.iAnioFaltas =:anio" );
            
            query.setParameter("anio", iAnio);
            list = (List<SigFaltasgraves>) query.list();
            
            for (SigFaltasgraves elem : list) {            
                Expediente row = new Expediente();                              
                row.setNombre(elem.getVcNmbempFaltas());
                row.setApellido(elem.getVcApFaltas());
                row.setArea(elem.getVcAreaFaltas());
                row.setNofaltas(elem.getINoFallas());
                row.setMes(elem.getVcMesFaltas());
                row.setAnio(elem.getiAnioFaltas());
                
                lista.add(row);

            }

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
        }
    
    }
}
