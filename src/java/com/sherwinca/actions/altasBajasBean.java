/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sherwinca.actions;

import com.sherwinca.entidades.AltaBaja;
import com.sherwinca.entidades.HibernateUtil;
import com.sherwinca.entidades.SigAltasbajas;
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
public class altasBajasBean implements Serializable{
    private List<AltaBaja> lista = new ArrayList();
    public String vcMes; /*CAPTURA LA SELECCION DEL COMBOBOX MES DE TACTICO.XHTML*/
    private int anio; /*CAPTURA LA SELECCION DEL COMBOBOX ANIO DE TACTICO.XHTML*/
    /**
     * Creates a new instance of altasBajasBean
     */
    public altasBajasBean() {
    }

    public List<AltaBaja> getLista() {
        return lista;
    }

    public void setLista(List<AltaBaja> lista) {
        this.lista = lista;
    }

    public String getVcMes() {
        return vcMes;
    }

    public void setVcMes(String vcMes) {
        this.vcMes = vcMes;
    }

    
    public void listarAltaBaja(){
        Session session = null;
        List<SigAltasbajas> list = null;
        lista.clear();
        try {            
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from SigAltasbajas r where  r.iAnioAb =:anio" );
            
            query.setParameter("anio", anio);
            list = (List<SigAltasbajas>) query.list();
            
            for (SigAltasbajas elem : list) {            
                AltaBaja row = new AltaBaja();                              
                row.setNombre(elem.getVcNmbempAb());
                row.setApellido(elem.getVcApAb());
                row.setArea(elem.getVcAreaAb());
                
                row.setMes(elem.getVcMesAb());
                row.setAnio(elem.getiAnioAb());
                switch(elem.getIEstadoAb()){
                    case 0:
                          row.setEstado("Despido");
                          break;
                    case 1:
                           row.setEstado("Contratacion");
                           break;
                  
                }
                 lista.add(row);

            }

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
        }
    }
    
    
    public List<SigAltasbajas> aniosTotalesAltasBajas() {
        Session session = null;
        List<SigAltasbajas> list = null;
        try {
        session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT DISTINCT d.iAnioAb FROM SigAltasbajas d ORDER BY d.iAnioAb ASC");
        list = (List<SigAltasbajas>) query.list();
        }catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
        }
        
        return list;
    }

    /**
     * @return the anio
     */
    public int getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }
}