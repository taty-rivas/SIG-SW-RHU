package com.sherwinca.entidades;
// Generated 06-01-2015 11:32:31 PM by Hibernate Tools 3.6.0


import java.math.BigDecimal;

/**
 * SigInversioninsaforp generated by hbm2java
 */
public class SigInversioninsaforp  implements java.io.Serializable {


     private int SPkInversion;
     private String vcNmbuniInversion;
     private BigDecimal DMontoInversion;
     private int IAnioInversion;

    public SigInversioninsaforp() {
    }

    public SigInversioninsaforp(int SPkInversion, String vcNmbuniInversion, BigDecimal DMontoInversion, int IAnioInversion) {
       this.SPkInversion = SPkInversion;
       this.vcNmbuniInversion = vcNmbuniInversion;
       this.DMontoInversion = DMontoInversion;
       this.IAnioInversion = IAnioInversion;
    }
   
    public int getSPkInversion() {
        return this.SPkInversion;
    }
    
    public void setSPkInversion(int SPkInversion) {
        this.SPkInversion = SPkInversion;
    }
    public String getVcNmbuniInversion() {
        return this.vcNmbuniInversion;
    }
    
    public void setVcNmbuniInversion(String vcNmbuniInversion) {
        this.vcNmbuniInversion = vcNmbuniInversion;
    }
    public BigDecimal getDMontoInversion() {
        return this.DMontoInversion;
    }
    
    public void setDMontoInversion(BigDecimal DMontoInversion) {
        this.DMontoInversion = DMontoInversion;
    }
    public int getIAnioInversion() {
        return this.IAnioInversion;
    }
    
    public void setIAnioInversion(int IAnioInversion) {
        this.IAnioInversion = IAnioInversion;
    }




}


