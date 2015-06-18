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
 * @author miguel
 */
@ManagedBean
@ViewScoped
public class personalDisponibleBean implements Serializable{

    private List<Disponible> lista;
    private String mes;
    private Integer anio;

    /**
     * Creates a new instance of personalDisponibleBean
     */
    public personalDisponibleBean()  {
        lista = new ArrayList<Disponible>();
    }

    public void listar() {
        Session session = null;
        List<SigPersonaldisponible> list = null;

        try {
            lista.clear();
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from SigPersonaldisponible r where r.vcMesDisponible=:mes AND r.iAnioDisponible =:anio");
            query.setParameter("mes", mes);
            query.setParameter("anio", anio);
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

    public List<SigPersonaldisponible> aniosTotales() {
        Session session = null;
        List<SigPersonaldisponible> list = null;
        try {
        session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT DISTINCT d.iAnioDisponible FROM SigPersonaldisponible d ORDER BY d.iAnioDisponible ASC");
        list = (List<SigPersonaldisponible>) query.list();
        }catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
        }
        
        return list;
    }
    
   

    /**
     * @return the mes
     */
    public String getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(String mes) {
        this.mes = mes;
    }

    /**
     * @return the anio
     */
    

    /**
     * @return the lista
     */
    public List<Disponible> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<Disponible> lista) {
        this.lista = lista;
    }

    /**
     * @return the anio
     */
    public Integer getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(Integer anio) {
        this.anio = anio;
    }

}
