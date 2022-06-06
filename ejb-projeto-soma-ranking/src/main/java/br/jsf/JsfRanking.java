/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package br.jsf;

import br.ejb.EjbRanking;
import br.model.CalculadoraSoma;
import br.model.Pessoa;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.faces.annotation.ManagedProperty;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.Topic;

/**
 *
 * @author ricar
 */
@Named(value = "jsfRanking")
@SessionScoped
public class JsfRanking extends JsfProdutor implements Serializable {

    @EJB
    private EjbRanking ejbRanking;
    
    private String nome;
    private int resultado;

    public JsfRanking() {
    }
    
    public void validarSoma() {
        Map<String, String> requestParamMap = FacesContext.getCurrentInstance().getExternalContext()
       .getRequestParameterMap();
        String numero01 = requestParamMap.get("form:numero01");
        String numero02 = requestParamMap.get("form:numero02");
        
        CalculadoraSoma calculadoraSoma = new CalculadoraSoma();
        calculadoraSoma.setNumero01(Integer.parseInt(numero01));
        calculadoraSoma.setNumero02(Integer.parseInt(numero02));
        calculadoraSoma.setResultado(resultado);
        Boolean validacao = calculadoraSoma.validacaoSoma(calculadoraSoma);
        if (nome.isBlank() || nome.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage("resultado", new FacesMessage("Nome é obrigatório!"));
            return;
        }
        
        if (validacao) {
            Pessoa pessoa = new Pessoa();
            pessoa.setNome(nome);
            add(pessoa); 
            FacesContext.getCurrentInstance().addMessage("resultado", new FacesMessage("Parabéns " + nome +", resultado está correto!" ));
            resultado = 0;
            send();
        } else {
            FacesContext.getCurrentInstance().addMessage("resultado", new FacesMessage("Que pena " + nome + " o resultado da soma está incorreto!"));
            resultado = 0;
        }
    }
    
    public void add(Pessoa pessoa) {
        ejbRanking.add(pessoa);
    }
    
    public void removerMensagem() {
        FacesContext context = FacesContext.getCurrentInstance();
        Iterator<FacesMessage> it = context.getMessages();
        while ( it.hasNext() ) {
            it.next();
            it.remove();
        }
    }
    
    public ArrayList<Pessoa> getAll() {
        return ejbRanking.getAll();
    }

    public EjbRanking getEjbRanking() {
        return ejbRanking;
    }

    public void setEjbRanking(EjbRanking ejbRanking) {
        this.ejbRanking = ejbRanking;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
    
}
