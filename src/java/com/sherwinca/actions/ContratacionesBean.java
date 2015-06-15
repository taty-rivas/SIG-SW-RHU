package com.sherwinca.actions;
/*--*/
import com.sherwinca.entidades.Contrataciones;
import com.sherwinca.entidades.HibernateUtil;
import com.sherwinca.entidades.SigPersonalcontratado;
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
public class ContratacionesBean implements java.io.Serializable {

    private List<Contrataciones> lista = new ArrayList();
    private int anio1=2000,anio2=2001;
    
    
    

    public ContratacionesBean() {
    }

    public List<Contrataciones> getLista() {
        return lista;
    }

    public void setLista(List<Contrataciones> lista) {
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
   
    public void mostrarContra(int anio) {
        lista.clear();
        Session session;
        List<SigPersonalcontratado> list;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from SigPersonalcontratado "
                    + "r where r.IAnioContratado=:anio");
            query.setParameter("anio",anio);
            list = (List<SigPersonalcontratado>) query.list();
        for (SigPersonalcontratado elem : list) {
                Contrataciones row = new Contrataciones();
                row.setNombres(elem.getVcNmbempContratado());
                row.setApellidos(elem.getVcApContratado());
                row.setArea(elem.getVcAreaContratado());
                lista.add(row);
            }
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } 
    }
}
