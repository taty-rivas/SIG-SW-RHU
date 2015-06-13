/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sherwinca.actions;

import com.sherwinca.entidades.HibernateUtil;
import com.sherwinca.entidades.Insaforp;
import com.sherwinca.entidades.SigInversioninsaforp;
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
 * @author Taty
 */
@ManagedBean
@ViewScoped
public class InsaforpBean implements Serializable{
    
    public static List<Insaforp> lista = new ArrayList();

    /**
     * Creates a new instance of capacitacionesBean
     */
    public InsaforpBean() {
    }

    public static List<Insaforp> getLista() {
        return lista;
    }

    public static void setLista(List<Insaforp> lista) {
        InsaforpBean.lista = lista;
    }
    
    public void mostrarCapacitaciones(){
        
        Session session;
        List<SigInversioninsaforp> list;
        
        try {
            
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from sig_inversioninsaforp");
            
            list = (List<SigInversioninsaforp>) query.list();

            for (SigInversioninsaforp elem : list) {

                Insaforp insa = new Insaforp();
                insa.setArea(elem.getVcNmbuniInversion());
                insa.setInversion(elem.getDMontoInversion());
              lista.add(insa);

            }

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
        }

    }
    
    
    
    
}
