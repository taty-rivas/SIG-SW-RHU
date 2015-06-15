package com.sherwinca.actions;

import com.sherwinca.entidades.HibernateUtil;
import com.sherwinca.entidades.Insaforp;
import com.sherwinca.entidades.SigInversioninsaforp;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Taty
 */
@ManagedBean
@ViewScoped
public class InsaforpBean implements java.io.Serializable {
    
    private List<Insaforp> lista = new ArrayList();
    
    private int anio1=2000,anio2=2001;

    /**
     * Creates a new instance of capacitacionesBean
     */
    public InsaforpBean() {
    }

    public List<Insaforp> getLista() {
        return lista;
    }

    public void setLista(List<Insaforp> lista) {
        this.lista = lista;
    }

    public int getAnio1() {
        return anio1;
    }

    public void setAnio1(int anio1) {
        this.anio1 = anio1;
    }

    public int getAnio2() {
        return anio2;
    }

    public void setAnio2(int anio2) {
        this.anio2 = anio2;
    }
        
    public void mostrarInv(int anio){
        
        Session session;
        List<SigInversioninsaforp> list;
     
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from SigInversioninsaforp r where r.IAnioInversion="+anio);
            
            list = (List<SigInversioninsaforp>)  query.list();
           
            for (SigInversioninsaforp elem : list) {
                Insaforp row = new Insaforp();
                row.setArea(elem.getVcNmbuniInversion());
                row.setInversion(elem.getDMontoInversion());
                lista.add(row);
               
               }
           

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } 
      

    }
    
}
