/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package br.ejb;

import br.crud.CrudNumeroAleatorio;
import br.model.NumeroAleatorio;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author ricar
 */
@Stateless
public class EjbNumeroAleatorio {

    public int getOne() {
        return new CrudNumeroAleatorio().getOne();
    }
}
