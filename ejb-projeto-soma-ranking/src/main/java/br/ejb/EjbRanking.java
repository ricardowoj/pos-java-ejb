/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatefulEjbClass.java to edit this template
 */
package br.ejb;

import br.model.Pessoa;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateful;

/**
 *
 * @author ricar
 */
@Stateful
public class EjbRanking {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private ArrayList<Pessoa> pessoas;

    public EjbRanking() {
        pessoas = new ArrayList<>();
    }
    
    public void add(Pessoa pessoa) {
        boolean achou = false;
        for (Pessoa pessoaLista : pessoas) {
            if(pessoaLista.getNome().equals(pessoa.getNome())) {
                pessoaLista.setPontuacao(pessoaLista.getPontuacao() + 1);
                achou = true;
                break;
            }
        }
        if(!achou) {
            pessoas.add(new Pessoa(pessoa.getNome(), 1));
        }
    }
    
    public ArrayList<Pessoa> getAll() {
        return pessoas;
    }
}
