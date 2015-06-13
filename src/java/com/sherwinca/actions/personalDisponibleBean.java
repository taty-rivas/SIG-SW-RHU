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
    private List<String> listaAnios = new ArrayList();
    private String vcMes; /*CAPTURA LA SELECCION DEL COMBOBOX MES DE TACTICO.XHTML*/
    private String iAnio; /*CAPTURA LA SELECCION DEL COMBOBOX ANIO DE TACTICO.XHTML*/
    
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

    public String getiAnio() {
        return iAnio;
    }

    public void setiAnio(String iAnio) {
        this.iAnio = iAnio;
    }

   


    public void listar(){
        Session session = null;
        List<SigPersonaldisponible> list = null;
  
        try {            
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from SigPersonaldisponible r where r.vcMesDisponible=:mes AND r.iAnioDisponible =:anio" );
            query.setParameter("mes", vcMes);
            query.setParameter("anio", iAnio);
            list = (List<SigPersonaldisponible>) query.list();
            lista.clear();
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
     public void listarAnios(){
         Session session = null;
        List<SigPersonaldisponible> list2 = null;
        
  
        try {            
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from SigPersonaldisponible r order by r.iAnioDisponible" );
            
            list2 = (List<SigPersonaldisponible>) query.list();
            lista.clear();
            for (SigPersonaldisponible elem : list2) {            
                
                listaAnios.add(String.valueOf(elem.getiAnioDisponible()));

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
