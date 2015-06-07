/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sherwinca.actions;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.sherwinca.entidades.SigPersonaldisponible;

/**
 *
 * @author Miguel
 */
@ManagedBean
@ViewScoped
public class personalDisponibleBean {

    /**
     * Creates a new instance of personalDisponibleBean
     */
    public personalDisponibleBean() {
        SigPersonaldisponible disponible = new SigPersonaldisponible();
    }
    
}
