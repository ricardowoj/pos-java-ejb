/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package br.jsf;

import br.ejb.EjbRanking;
import br.model.Pessoa;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
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
@Named(value = "jsfProdutor")
@Dependent
public class JsfProdutor {

    @EJB
    private EjbRanking ejbRanking;
    
    @Resource(lookup = "java:comp/DefaultJMSConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "java/Topico")
    private Topic topico;
    
    public JsfProdutor() {
    }
    
    public ArrayList<Pessoa> getAll() {
        return ejbRanking.getAll();
    }

    public EjbRanking getEjbRanking() {
        return ejbRanking;
    }

    public void send() {
        try {
            ArrayList<Pessoa> pessoas = getAll();
            Connection conn = connectionFactory.createConnection();
            Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            ObjectMessage om = session.createObjectMessage();

            om.setObject(pessoas);
            JMSContext context = connectionFactory.createContext();

            context.createProducer().send(topico, om);
        } catch (Exception e) {
            System.out.println("ERRO");
            System.out.println(e.getMessage());
        }
    }
    
}
