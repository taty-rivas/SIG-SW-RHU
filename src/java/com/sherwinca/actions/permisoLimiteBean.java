/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sherwinca.actions;

import com.sherwinca.entidades.Disponible;
import com.sherwinca.entidades.HibernateUtil;
import com.sherwinca.entidades.PermisosLimites;
import com.sherwinca.entidades.SigLimitepermiso;
import com.sherwinca.entidades.SigPersonaldisponible;
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
public class permisoLimiteBean implements Serializable {

    private List<PermisosLimites> lista;
    private Integer anio;
   


    /**
     * Creates a new instance of permisosLimiteBean
     */
    public permisoLimiteBean() {
        lista = new ArrayList();
    }

    public void listar() {
        Session session = null;
        List<SigLimitepermiso> list = null;

        try {
            lista.clear();
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from SigLimitepermiso r where r.iAnioLimite =:anio");
            query.setParameter("anio", getAnio());
            list = (List<SigLimitepermiso>) query.list();

            for (SigLimitepermiso elem : list) {
                PermisosLimites row = new PermisosLimites();
                row.setNombre(elem.getVcNmbempLimite());
                row.setApellido(elem.getVcApLimite());
                row.setArea(elem.getVcAreaLimite());
                row.setNopermiso(elem.getINopermisoLimite());
                row.setAnio(elem.getiAnioLimite());
                lista.add(row);

            }

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
        }

    }

    public List<SigPersonaldisponible> aniosTotalesPermisos() {
        Session session = null;
        List<SigPersonaldisponible> list = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("SELECT DISTINCT d.iAnioLimite FROM SigLimitepermiso d ORDER BY d.iAnioLimite ASC");
            list = (List<SigPersonaldisponible>) query.list();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
        }

        return list;
    }

    public List<PermisosLimites> getLista() {
        return lista;
    }

    public void setLista(List<PermisosLimites> lista) {
        this.lista = lista;
    }

    

  

    public void listarPermisos() {
        Session session = null;
        List<SigLimitepermiso> list = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from SigLimitepermiso r where  r.iAnioLimite =:anio");

            query.setParameter("anio", getAnio());
            list = (List<SigLimitepermiso>) query.list();

            for (SigLimitepermiso elem : list) {
                PermisosLimites row = new PermisosLimites();
                row.setNombre(elem.getVcNmbempLimite());
                row.setApellido(elem.getVcApLimite());
                row.setArea(elem.getVcAreaLimite());
                row.setNopermiso(elem.getINopermisoLimite());
                row.setAnio(elem.getiAnioLimite());

                lista.add(row);

            }

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
        }

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
