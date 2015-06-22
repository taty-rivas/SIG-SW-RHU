/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sherwinca.actions;

import com.sherwinca.entidades.Expediente;
import com.sherwinca.entidades.HibernateUtil;
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
    private String unidadOrganizativa;
    private Integer anio;/*CAPTURA LA SELECCION DEL COMBOBOX ANIO DE TACTICO.XHTML*/
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

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    
    
    public void listarCostos(){
        lista.clear();
        Session session = null;
        List<SigFaltasgraves> list = null;
  
        try {            
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from SigFaltasgraves r where  r.iAnioFaltas =:anio"
                    + " and r.vcAreaFaltas =:unidadOrganizativa " );
            
            query.setParameter("anio", anio);
            query.setParameter("unidadOrganizativa", unidadOrganizativa);
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
    
    public List<SigFaltasgraves> listarUnidades(){
        Session session = null;
        List<SigFaltasgraves> list = null;
        try {
        session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT DISTINCT d.vcAreaFaltas FROM SigFaltasgraves d ORDER BY d.vcAreaFaltas ASC");
        list = (List<SigFaltasgraves>) query.list();
        }catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
        }
        
        return list;
    }
     
     
    public List<SigFaltasgraves> aniosTotalesExpediente() {
        Session session = null;
        List<SigFaltasgraves> list = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("SELECT DISTINCT d.iAnioFaltas "
                    + "FROM SigFaltasgraves d ORDER BY d.iAnioFaltas ASC");
            list = (List<SigFaltasgraves>) query.list();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
        }

        return list;
    }

    public String getUnidadOrganizativa() {
        return unidadOrganizativa;
    }

    public void setUnidadOrganizativa(String unidadOrganizativa) {
        this.unidadOrganizativa = unidadOrganizativa;
    }
     
     
}
