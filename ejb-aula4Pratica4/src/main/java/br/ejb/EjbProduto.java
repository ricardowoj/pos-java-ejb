/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package br.ejb;

import br.data.crud.CrudProduto;
import br.data.model.Produto;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author ricar
 */
@Stateless
public class EjbProduto {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public ArrayList<Produto> getAll() {
        return new CrudProduto().getAll();
    }
}
