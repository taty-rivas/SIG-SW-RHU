/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sherwinca.actions;

import com.sherwinca.entidades.HibernateUtil;
import com.sherwinca.entidades.SigUsuario;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Miguel
 */
@ManagedBean
@SessionScoped
public class loginBean implements Serializable {

    private SigUsuario user;
    private String username;
    private String password;
    private String tituloBarra;
    private String navigationCase;
    private boolean disable;
    private final static String USER_DEFAULT_MSG = "Iniciar Sesión";
    private final static Integer PERFIL_ESTRATEGICO=1;
    private final static Integer PERFIL_TACTICO=2;
    private final static Integer PERFIL_ADMIN=3;

    /**
     * Creates a new instance of loginBean
     */
    public loginBean() {
        user = new SigUsuario();
        tituloBarra = USER_DEFAULT_MSG;
    }

    public void cerrarDialog() {
        RequestContext rc = RequestContext.getCurrentInstance();
        rc.execute("dlg2.hide()");
    }

    public void colocarUsuario() {
        if (user!=null){
        setTituloBarra(user.getVcNmbUsuario());
        }
        setDisable(false);
    }

    public String cerrarSesion() {
        //setTituloBarra(USER_DEFAULT_MSG);
        FacesContext context = FacesContext.getCurrentInstance(); 
        context.getExternalContext().getSessionMap().put("loginBean", null);
        setNavigationCase("cerrarsesion");
        return getNavigationCase();

    }

    public String iniciarSesion() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("FROM SigUsuario x WHERE x.vcNmbUsuario=:user");
            query.setParameter("user", username);
            user = (SigUsuario) query.uniqueResult();
            if (user == null) {
                errorUsuario();
                return "";
            } else {
                if (user.getVcPasswordUsuario().equals(password)) {
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.getExternalContext().getSessionMap().put("Usuario", user);
                    if (user.getSigPerfiles().getSPkPerfil()==PERFIL_ESTRATEGICO) {
                        colocarUsuario();
                        setDisable(true);
                        setNavigationCase("estrategico");
                        return getNavigationCase();
                    } else if(user.getSigPerfiles().getSPkPerfil() == PERFIL_TACTICO) {
                        colocarUsuario();
                        setDisable(true);
                        setNavigationCase("tactico");
                        return getNavigationCase();
                    }
                } else {
                    errorPassword();
                    return "";

                }

            }
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    public void errorUsuario() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error, Usuario no encontrado en el sistema", null));
    }

    public void errorPassword() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error, Password invalido", null));
    }

    /**
     * @return the user
     */
    public SigUsuario getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(SigUsuario user) {
        this.user = user;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the tituloBarra
     */
    public String getTituloBarra() {
        return tituloBarra;
    }

    /**
     * @param tituloBarra the tituloBarra to set
     */
    public void setTituloBarra(String tituloBarra) {
        this.tituloBarra = tituloBarra;
    }

    /**
     * @return the navigationCase
     */
    public String getNavigationCase() {
        return navigationCase;
    }

    /**
     * @param navigationCase the navigationCase to set
     */
    public void setNavigationCase(String navigationCase) {
        this.navigationCase = navigationCase;
    }

    /**
     * @return the disable
     */
    public boolean isDisable() {
        return disable;
    }

    /**
     * @param disable the disable to set
     */
    public void setDisable(boolean disable) {
        this.disable = disable;
    }

}
