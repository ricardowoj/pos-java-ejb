/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package br.jsf;

import br.ejb.EjbCompra;
import br.data.model.ItemCompra;
import br.data.model.Produto;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.EJB;

/**
 *
 * @author ricar
 */
@Named(value = "jsfCompra")
@SessionScoped
public class jsfCompra implements Serializable {

    @EJB
    private EjbCompra ejbCompra;

    /**
     * Creates a new instance of jsfCompra
     */
    public jsfCompra() {
    }
    
    public void add(Produto produto) {
        ejbCompra.add(produto);
    }
    
    public ArrayList<ItemCompra> getAll() {
        return ejbCompra.getAll();
    }
    
    public void limparLista() {
        ejbCompra.limparLista();
    }
        
}
