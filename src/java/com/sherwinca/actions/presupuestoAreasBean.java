package com.sherwinca.actions;
/*--*/
import com.sherwinca.entidades.HibernateUtil;
import com.sherwinca.entidades.Presupuesto;
import com.sherwinca.entidades.SigPresupuestounidades;
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
public class presupuestoAreasBean implements java.io.Serializable{
    
    private List<Presupuesto> lista = new ArrayList();
    private int anio1=1990,anio2=1991;

    /**
     * Creates a new instance of presupuestoAreasBean
     */
    public presupuestoAreasBean() {
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
    
    
    public List<Presupuesto> getLista() {
        return lista;
    }

    public void setLista(List<Presupuesto> lista) {
        this.lista = lista;
    } 
    
    
    
    
public void mostrarPresupuesto(int anio){
       lista.clear();
       Session session;
        List<SigPresupuestounidades> list;
        try {
            
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from SigPresupuestounidades r where r.IAnioPresupuesto=:anio");
            query.setParameter("anio", anio);
            System.out.println("query "+query);
            System.out.println("anio " +anio);
            list = (List<SigPresupuestounidades>) query.list();
            for (SigPresupuestounidades elem : list) {
                Presupuesto row = new Presupuesto();
                row.setArea(elem.getVcNmbuniPresupuesto());
                row.setPresupuesto(elem.getDMontoPresupuesto());
                lista.add(row);
             }

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
        }

    }
    
}
