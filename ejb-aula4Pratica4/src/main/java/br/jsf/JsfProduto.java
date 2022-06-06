/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package br.jsf;

import br.data.model.Produto;
import br.ejb.EjbProduto;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author ricar
 */
@Named(value = "jsfProduto")
@RequestScoped
public class JsfProduto {

    @EJB
    private EjbProduto ejbProduto;

    /**
     * Creates a new instance of JsfProduto
     */
    public JsfProduto() {
    }
    
    public ArrayList<Produto> getAll() {
        return ejbProduto.getAll();
    }
}
