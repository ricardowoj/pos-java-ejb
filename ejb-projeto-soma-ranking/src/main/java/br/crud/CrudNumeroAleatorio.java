/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.crud;

import br.model.NumeroAleatorio;
import java.util.ArrayList;

/**
 *
 * @author ricar
 */
public class CrudNumeroAleatorio {
    
    public int getOne() {
        return new NumeroAleatorio().getNumero();
    }
}
