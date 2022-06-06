/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.model;

import java.util.Random;

/**
 *
 * @author ricar
 */
public class NumeroAleatorio {
    //Numero aleatório de 0 a 100
    private int numero;
    
    Random gerador = new Random();

    public NumeroAleatorio() {
    }

    public int getNumero() {
        return gerador.nextInt(99);
    }
    
}
