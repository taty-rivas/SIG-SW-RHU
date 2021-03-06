package com.sherwinca.entidades;
// Generated 06-01-2015 11:32:31 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * SigPerfiles generated by hbm2java
 */
public class SigPerfiles  implements java.io.Serializable {


     private int SPkPerfil;
     private String vcNmbPerfil;
     private String vcDescripcionPerfil;
     private Set sigUsuarios = new HashSet(0);
     private Set sigModulos = new HashSet(0);

    public SigPerfiles() {
    }

	
    public SigPerfiles(int SPkPerfil, String vcNmbPerfil) {
        this.SPkPerfil = SPkPerfil;
        this.vcNmbPerfil = vcNmbPerfil;
    }
    public SigPerfiles(int SPkPerfil, String vcNmbPerfil, String vcDescripcionPerfil, Set sigUsuarios, Set sigModulos) {
       this.SPkPerfil = SPkPerfil;
       this.vcNmbPerfil = vcNmbPerfil;
       this.vcDescripcionPerfil = vcDescripcionPerfil;
       this.sigUsuarios = sigUsuarios;
       this.sigModulos = sigModulos;
    }
   
    public int getSPkPerfil() {
        return this.SPkPerfil;
    }
    
    public void setSPkPerfil(int SPkPerfil) {
        this.SPkPerfil = SPkPerfil;
    }
    public String getVcNmbPerfil() {
        return this.vcNmbPerfil;
    }
    
    public void setVcNmbPerfil(String vcNmbPerfil) {
        this.vcNmbPerfil = vcNmbPerfil;
    }
    public String getVcDescripcionPerfil() {
        return this.vcDescripcionPerfil;
    }
    
    public void setVcDescripcionPerfil(String vcDescripcionPerfil) {
        this.vcDescripcionPerfil = vcDescripcionPerfil;
    }
    public Set getSigUsuarios() {
        return this.sigUsuarios;
    }
    
    public void setSigUsuarios(Set sigUsuarios) {
        this.sigUsuarios = sigUsuarios;
    }
    public Set getSigModulos() {
        return this.sigModulos;
    }
    
    public void setSigModulos(Set sigModulos) {
        this.sigModulos = sigModulos;
    }




}


