package com.sherwinca.entidades;
// Generated 06-01-2015 11:32:31 PM by Hibernate Tools 3.6.0


import java.math.BigDecimal;

/**
 * SigCostossalarios generated by hbm2java
 */
public class SigCostossalarios  implements java.io.Serializable {


     private int SPkCostos;
     private String vcNmbuniCostos;
     private BigDecimal DMontoCostos;
     private String vcMesCostos;

    public SigCostossalarios() {
    }

    public SigCostossalarios(int SPkCostos, String vcNmbuniCostos, BigDecimal DMontoCostos, String vcMesCostos) {
       this.SPkCostos = SPkCostos;
       this.vcNmbuniCostos = vcNmbuniCostos;
       this.DMontoCostos = DMontoCostos;
       this.vcMesCostos = vcMesCostos;
    }
   
    public int getSPkCostos() {
        return this.SPkCostos;
    }
    
    public void setSPkCostos(int SPkCostos) {
        this.SPkCostos = SPkCostos;
    }
    public String getVcNmbuniCostos() {
        return this.vcNmbuniCostos;
    }
    
    public void setVcNmbuniCostos(String vcNmbuniCostos) {
        this.vcNmbuniCostos = vcNmbuniCostos;
    }
    public BigDecimal getDMontoCostos() {
        return this.DMontoCostos;
    }
    
    public void setDMontoCostos(BigDecimal DMontoCostos) {
        this.DMontoCostos = DMontoCostos;
    }
    public String getVcMesCostos() {
        return this.vcMesCostos;
    }
    
    public void setVcMesCostos(String vcMesCostos) {
        this.vcMesCostos = vcMesCostos;
    }




}


