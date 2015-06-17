/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sherwinca.actions;

import com.sherwinca.entidades.CapacitacionImpartida;
import com.sherwinca.entidades.CostosSalarios;
import com.sherwinca.entidades.HibernateUtil;
import com.sherwinca.entidades.SigCapacitacionimpartida;
import com.sherwinca.entidades.SigCostossalarios;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;


@ManagedBean
@ViewScoped
public class personalCapacitadoBean {
     private List<CapacitacionImpartida> lista = new ArrayList();
     private String unidadOrganizativa; /*CAPTURA LA SELECCION DEL COMBOBOX ANIO DE TACTICO.XHTML*/
    /**
     * Creates a new instance of personalCapacitadoBean
     */
    public personalCapacitadoBean() {
    }

    public List<CapacitacionImpartida> getLista() {
        return lista;
    }

    public void setLista(List<CapacitacionImpartida> lista) {
        this.lista = lista;
    }

           
    public void listarCapacitacion(){
        Session session = null;
        List<SigCapacitacionimpartida> list = null;
        lista.clear();
        try {            
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from SigCapacitacionimpartida r where  r.vcNmbuniCapacitacion =:unidad" );
            
            query.setParameter("unidad", getUnidadOrganizativa());
            list = (List<SigCapacitacionimpartida>) query.list();
            
            for (SigCapacitacionimpartida elem : list) {            
                CapacitacionImpartida row = new CapacitacionImpartida();                              
                row.setNombre(elem.getVcNmbempCapacitacion());
                row.setApellido(elem.getVcApCapacitacion());
                row.setUnidad(elem.getVcNmbuniCapacitacion());
                row.setCurso(elem.getVcNmbcursoCapacitacion());
                row.setDias(elem.getIDiasCapacitacion());
                row.setFaltas(elem.getIFaltasCapacitacion());
                row.setCosto(elem.getDCostoCapacitacion());
                
                lista.add(row);

            }

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
        }
    
    }
    public List<SigCapacitacionimpartida> listarUnidades(){
        Session session = null;
        List<SigCapacitacionimpartida> list = null;
        try {
        session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT DISTINCT d.vcNmbuniCapacitacion FROM SigCapacitacionimpartida d ORDER BY d.vcNmbuniCapacitacion ASC");
        list = (List<SigCapacitacionimpartida>) query.list();
        }catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
        }
        
        return list;
    }

    /**
     * @return the unidadOrganizativa
     */
    public String getUnidadOrganizativa() {
        return unidadOrganizativa;
    }

    /**
     * @param unidadOrganizativa the unidadOrganizativa to set
     */
    public void setUnidadOrganizativa(String unidadOrganizativa) {
        this.unidadOrganizativa = unidadOrganizativa;
    }

    
    /**
     * @return the unidadOrganizativa
     */
    
}
