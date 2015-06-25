/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sherwinca.actions;

import com.sherwinca.entidades.CostosSalarios;
import com.sherwinca.entidades.HibernateUtil;
import com.sherwinca.entidades.PermisosLimites;
import com.sherwinca.entidades.SigCostossalarios;
import com.sherwinca.entidades.SigLimitepermiso;
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
public class costoSalariosBean implements Serializable {

    private List<CostosSalarios> lista = new ArrayList();
    public String vcMes; /*CAPTURA LA SELECCION DEL COMBOBOX MES DE TACTICO.XHTML*/

    private Integer anio;/*CAPTURA LA SELECCION DEL COMBOBOX ANIO DE TACTICO.XHTML*/


    /**
     * Creates a new instance of costoSalariosBean
     */
    public costoSalariosBean() {
    }

    public List<CostosSalarios> getLista() {
        return lista;
    }

    public void setLista(List<CostosSalarios> lista) {
        this.lista = lista;
    }

    public String getVcMes() {
        return vcMes;
    }

    public void setVcMes(String vcMes) {
        this.vcMes = vcMes;
    }

    public void listarCostos() {
        Session session = null;
        List<SigCostossalarios> list = null;
        lista.clear();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from SigCostossalarios r where  r.iAnioCostos =:anio and r.vcMesCostos=:mes");

            query.setParameter("anio", anio);
            query.setParameter("mes",vcMes);
            list = (List<SigCostossalarios>) query.list();

            for (SigCostossalarios elem : list) {
                CostosSalarios row = new CostosSalarios();
                row.setUnidad(elem.getVcNmbuniCostos());
                row.setCosto(elem.getDMontoCostos());
                row.setMes(elem.getVcMesCostos());
                row.setAnio(elem.getiAnioCostos());

                lista.add(row);

            }

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
        }

    }

    public List<SigCostossalarios> aniosTotalesCostos() {
        Session session = null;
        List<SigCostossalarios> list = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("SELECT DISTINCT d.iAnioCostos FROM SigCostossalarios d ORDER BY d.iAnioCostos ASC");
            list = (List<SigCostossalarios>) query.list();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
        }

        return list;
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
