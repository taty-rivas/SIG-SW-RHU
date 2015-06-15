package com.sherwinca.actions;

import com.sherwinca.entidades.Ausencias;
import com.sherwinca.entidades.HibernateUtil;
import com.sherwinca.entidades.SigGastoausentismo;
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
public class AusenciasBean implements java.io.Serializable {
    
    private List<Ausencias> lista = new ArrayList();
    private String mes1;

    /**
     * Creates a new instance of AusenciasBean
     */
    public AusenciasBean() {
    }

    public String getMes1() {
        return mes1;
    }

    public void setMes1(String mes1) {
        this.mes1 = mes1;
    }

    
    public List<Ausencias> getLista() {
        return lista;
    }

    public void setLista(List<Ausencias> lista) {
        this.lista = lista;
    }
    
    public void mostrarAusencias(String mes) {
        lista.clear();
        System.out.println("mes " +mes);
        Session session;
        List<SigGastoausentismo> list;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from SigGastoausentismo r where r.vcMesAusentismo=:mes" );
            query.setParameter("mes", mes);
            list = (List<SigGastoausentismo>) query.list();
            for (SigGastoausentismo elem : list) {
                Ausencias row = new Ausencias();
                row.setNombre(elem.getVcNmbempAusentismo());
                row.setApellidos(elem.getVcApAusentismo());
                row.setPermiso(elem.getITipopermisoAusentismo());
                row.setHoras(elem.getIHorasAusentismo());
                row.setArea(elem.getVcAreaAusentismo());
                lista.add(row);
            }
         } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }
}
