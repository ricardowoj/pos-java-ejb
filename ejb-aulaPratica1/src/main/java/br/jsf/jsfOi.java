/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package br.jsf;

import br.ejb.EjbOlaMUndo;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author ricar
 */
@Named(value = "jsfOi")
@RequestScoped
public class jsfOi {

    @EJB
    private EjbOlaMUndo ejbOlaMUndo;

    /**
     * Creates a new instance of jsfOi
     */
    public jsfOi() {
    }
    
    public String getOi() {
        return ejbOlaMUndo.getOi();
    }
}
