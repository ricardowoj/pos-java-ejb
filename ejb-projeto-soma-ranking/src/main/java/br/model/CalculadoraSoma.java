/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.model;

/**
 *
 * @author ricar
 */
public class CalculadoraSoma {
    private int numero01;
    private int numero02;
    private int resultado;

    public CalculadoraSoma() {
    }

    public CalculadoraSoma(int numero01, int numero02, int resultado) {
        this.numero01 = numero01;
        this.numero02 = numero02;
        this.resultado = resultado;
    }
    
    public Boolean validacaoSoma(CalculadoraSoma calculadoraSoma) {
        int somaSistema = calculadoraSoma.getNumero01() + calculadoraSoma.getNumero02();
        return somaSistema == calculadoraSoma.getResultado();
    }

    public int getNumero01() {
        return numero01;
    }

    public void setNumero01(int numero01) {
        this.numero01 = numero01;
    }

    public int getNumero02() {
        return numero02;
    }

    public void setNumero02(int numero02) {
        this.numero02 = numero02;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }


    
}
