package com.sherwinca.entidades;
// Generated 06-01-2015 11:32:31 PM by Hibernate Tools 3.6.0


import java.math.BigDecimal;

/**
 * SigPresupuestounidades generated by hbm2java
 */
public class SigPresupuestounidades  implements java.io.Serializable {


     private int SPkPresupuesto;
     private String vcNmbuniPresupuesto;
     private BigDecimal DMontoPresupuesto;
     private int IAnioPresupuesto;

    public SigPresupuestounidades() {
    }

    public SigPresupuestounidades(int SPkPresupuesto, String vcNmbuniPresupuesto, BigDecimal DMontoPresupuesto, int IAnioPresupuesto) {
       this.SPkPresupuesto = SPkPresupuesto;
       this.vcNmbuniPresupuesto = vcNmbuniPresupuesto;
       this.DMontoPresupuesto = DMontoPresupuesto;
       this.IAnioPresupuesto = IAnioPresupuesto;
    }
   
    public int getSPkPresupuesto() {
        return this.SPkPresupuesto;
    }
    
    public void setSPkPresupuesto(int SPkPresupuesto) {
        this.SPkPresupuesto = SPkPresupuesto;
    }
    public String getVcNmbuniPresupuesto() {
        return this.vcNmbuniPresupuesto;
    }
    
    public void setVcNmbuniPresupuesto(String vcNmbuniPresupuesto) {
        this.vcNmbuniPresupuesto = vcNmbuniPresupuesto;
    }
    public BigDecimal getDMontoPresupuesto() {
        return this.DMontoPresupuesto;
    }
    
    public void setDMontoPresupuesto(BigDecimal DMontoPresupuesto) {
        this.DMontoPresupuesto = DMontoPresupuesto;
    }
    public int getIAnioPresupuesto() {
        return this.IAnioPresupuesto;
    }
    
    public void setIAnioPresupuesto(int IAnioPresupuesto) {
        this.IAnioPresupuesto = IAnioPresupuesto;
    }




}

