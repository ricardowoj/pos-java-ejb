/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gui;

import bri.ICalculadora;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author ricar
 */
public class ClienteEjb {

    public int somar(int a, int b) {

        Properties props = new Properties();
        props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
        props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
        props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
        props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
        props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
        props.setProperty("com.sun.corba.ee.transport.ORBWaitForResponseTimeout", "5000");
        props.setProperty("com.sun.corba.ee.transport.ORBTCPConnectTimeouts", "100:500:100:500");
        props.setProperty("com.sun.corba.ee.transport.ORBTCPTimeouts", "500:2000:50:1000");

        InitialContext ejbRemoteContext;
        try {            
            ejbRemoteContext = new InitialContext(props);
        } catch (NamingException ex) {
            System.out.println("ERRO");
            System.out.println(ex.getMessage());
            return -1;
        }

        ICalculadora ejbRemote;
        try {
            ejbRemote = (ICalculadora) ejbRemoteContext.lookup("java:global/ejb-aula4Pratica3Web-1.0-SNAPSHOT/EjbCalculadora");
            int x = ejbRemote.somar(a, b);
            return x;
        } catch (NamingException ex) {
            System.out.println("ERRo");
            System.out.println(ex.getMessage());
            return -2;
        }
    }
}
