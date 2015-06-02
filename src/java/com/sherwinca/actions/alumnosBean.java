/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sherwinca.actions;

import com.sherwinca.entidades.Alumnos;
import com.sherwinca.entidades.NewHibernateUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author HP
 */
@ManagedBean
@ViewScoped
public class alumnosBean {
     private Alumnos alumno; 
    /**
     * Creates a new instance of alumnosBean
     */
    public alumnosBean() {
        alumno=new Alumnos();
    }
    
       public void insertarAlumno() {
        Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(alumno);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
     
     public List<Alumnos> mostrarAlumnos() {
        Session session = null;
        List<Alumnos> list = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Alumnos");
            list = (List<Alumnos>) query.list();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
        }
        return list;
    }
     
     
    /**
     * @return the alumno
     */
    public Alumnos getAlumno() {
        return alumno;
    }

    /**
     * @param alumno the alumno to set
     */
    public void setAlumno(Alumnos alumno) {
        this.alumno = alumno;
    }
    
}
