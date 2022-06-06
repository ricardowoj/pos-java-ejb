/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package br.jsf;

import bri.ICalculadora;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author ricar
 */
@Named(value = "jsfCalculadora")
@RequestScoped
public class JsfCalculadora {

    @EJB
    private ICalculadora ejbCalculadora;

    /**
     * Creates a new instance of JsfCalculadora
     */
    public JsfCalculadora() {
    }
    
    public void somar() {
        resultado = ejbCalculadora.somar(valorA, valorB);
    }
    
    private int valorA;
    private int valorB;
    private int resultado;

    public int getValorA() {
        return valorA;
    }

    public void setValorA(int valorA) {
        this.valorA = valorA;
    }

    public int getValorB() {
        return valorB;
    }

    public void setValorB(int valorB) {
        this.valorB = valorB;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
    
}
