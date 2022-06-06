/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ejb;

import br.model.Pessoa;
import java.util.ArrayList;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 *
 * @author ricar
 */

@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup",
            propertyValue = "java/Topico"),
    @ActivationConfigProperty(propertyName = "destinationType",
            propertyValue = "javax.jms.Topic")
})
public class EjbConsumidorRanking implements MessageListener {

    @Override
    public void onMessage(Message msg) {
        System.out.println("(Topico) Mensagem recebida pelo " + this.getClass().getSimpleName());
        try {
            ObjectMessage tn = (ObjectMessage) msg;
            ArrayList<Pessoa> pessoas = new ArrayList();
            pessoas = (ArrayList<Pessoa>) tn.getObject();
            System.out.println("------RANKING------");
            for (Pessoa pessoa : pessoas) {
                System.err.println(pessoa.getNome().toString() + ": " + pessoa.getPontuacao() + " ponto(s)");
            }
        } catch (Exception e) {
            System.out.println("ERRO");
            System.out.println(e.getMessage());
        }
    }
    
}
