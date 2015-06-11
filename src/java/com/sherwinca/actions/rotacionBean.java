package com.sherwinca.actions;

import com.sherwinca.entidades.HibernateUtil;
import com.sherwinca.entidades.Rotacion;
import com.sherwinca.entidades.SigRotacionrrhh;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author HP
 */
@ManagedBean
@ViewScoped
public class rotacionBean implements Serializable {

    private static List<Rotacion> lista = new ArrayList();
    private Date finicial,ffinal;

    /**
     * Creates a new instance of rotacionBean
     */
    public rotacionBean() {
    }

    public Date getFinicial() {
        return finicial;
    }

    public void setFinicial(Date finicial) {
        this.finicial = finicial;
    }

    public Date getFfinal() {
        return ffinal;
    }

    public void setFfinal(Date ffinal) {
        this.ffinal = ffinal;
    }
    
    

    public List<Rotacion> getLista() {
        return lista;
    }

    public void setLista(List<Rotacion> lista) {
        this.lista = lista;
    }

   
    private Date date;

     
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Date Selected", format.format(event.getObject())));
    }
     
    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
         
        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }
 
    public Date getDate() {
        return date;
    }
 
    public void setDate(Date date) {
        this.date = date;
    }
    
    public void mostrarRotacion(){
        Session session = null;
        List<SigRotacionrrhh> list = null;
        String DatePattern = "yyyy-MM-dd";
        SimpleDateFormat df = new SimpleDateFormat(DatePattern);
        String startDate = df.format(finicial);
        String endDate = df.format(ffinal);
        try {
            
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from SigRotacionrrhh r where r.dtRotRotrrhh BETWEEN '"+startDate+"' AND '"+endDate+"'" );
            
            list = (List<SigRotacionrrhh>) query.list();

            for (SigRotacionrrhh elem : list) {

                Rotacion rot = new Rotacion();
                rot.setNombre(elem.getVcNmbRotrrhh());
                rot.setApellido(elem.getVcApRotrrhh());
                rot.setMotivo(elem.getITiporotRotrrhh());
                rot.setArea(elem.getVcAreaRotrrhh());
                rot.setFecha(elem.getDtRotRotrrhh());

                lista.add(rot);

            }

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
        }

    }
}
