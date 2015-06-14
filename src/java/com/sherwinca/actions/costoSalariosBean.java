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

/**
 *
 * @author Solis
 */
@ManagedBean
@ViewScoped
public class costoSalariosBean implements Serializable{
    private List<CostosSalarios> lista = new ArrayList();
    public String vcMes="ABRIL"; /*CAPTURA LA SELECCION DEL COMBOBOX MES DE TACTICO.XHTML*/
    public int iAnio=2014; /*CAPTURA LA SELECCION DEL COMBOBOX ANIO DE TACTICO.XHTML*/
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

    public int getiAnio() {
        return iAnio;
    }

    public void setiAnio(int iAnio) {
        this.iAnio = iAnio;
    }
    
    
    public void listarCostos(){
        Session session = null;
        List<SigCostossalarios> list = null;
  
        try {            
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from SigCostossalarios r where  r.iAniosalarios =:anio" );
            
            query.setParameter("anio", iAnio);
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
}
