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
    public String vcMes="ABRIL"; /*CAPTURA LA SELECCION DEL COMBOBOX MES DE TACTICO.XHTML*/
    public int iAnio=2014; /*CAPTURA LA SELECCION DEL COMBOBOX ANIO DE TACTICO.XHTML*/
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

    public int getiAnio() {
        return iAnio;
    }

    public void setiAnio(int iAnio) {
        this.iAnio = iAnio;
    }
    public void listarAltaBaja(){
        Session session = null;
        List<SigAltasbajas> list = null;
  
        try {            
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from SigAltasbajas r where  r.iAnioLimite =:anio" );
            
            query.setParameter("anio", iAnio);
            list = (List<SigAltasbajas>) query.list();
            
            for (SigAltasbajas elem : list) {            
                AltaBaja row = new AltaBaja();                              
                row.setNombre(elem.getVcNmbempAb());
                row.setApellido(elem.getVcApAb());
                row.setArea(elem.getVcAreaAb());
                row.setEstado(elem.getIEstadoAb());
                row.setMes(elem.getVcMesAb());
                row.setAnio(elem.getiAnioAb());
                
                lista.add(row);

            }

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
        }
    }
}