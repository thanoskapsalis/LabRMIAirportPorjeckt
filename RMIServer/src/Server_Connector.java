/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.Naming;
import java.rmi.registry.Registry;

/**
 * @author nick
 */
public class Server_Connector {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RMIHandler handler;
        try {
            handler = new RMIHandler();
            System.out.println("ServerBooted");
            Registry r = java.rmi.registry.LocateRegistry.createRegistry(1099);
            Naming.rebind("//localhost/RMIServer", handler);


        } catch (Exception e) {
            System.out.println(e);

        }
    }

}
