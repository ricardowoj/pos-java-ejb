/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package br.jsf;

import br.ejb.EjbNumeroAleatorio;
import br.model.NumeroAleatorio;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author ricar
 */
@Named(value = "jsfNumeroAleatorio")
@RequestScoped
public class JsfNumeroAleatorio {

    @EJB
    private EjbNumeroAleatorio ejbNumeroAleatorio;

    public JsfNumeroAleatorio() {
    }
    
    public int getOne() {
        return ejbNumeroAleatorio.getOne();
    }
    
}
