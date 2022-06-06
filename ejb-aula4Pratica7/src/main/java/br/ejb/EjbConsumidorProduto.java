/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ejb;

import br.model.Produto;
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
public class EjbConsumidorProduto implements MessageListener {

    @Override
    public void onMessage(Message msg) {
        System.out.println("(Topico) Mensagem recebida pelo " + this.getClass().getSimpleName());
        try {
            ObjectMessage tn = (ObjectMessage) msg;
            ArrayList<Produto> produtos = new ArrayList();
            produtos = (ArrayList<Produto>) tn.getObject();
            for (Produto produto : produtos) {
                System.err.println("Produto => " +produto.getCodigo() + ": " + produto.getDescricao());
            }
        } catch (Exception e) {
            System.out.println("ERRO");
            System.out.println(e.getMessage());
        }
    }
    
}
