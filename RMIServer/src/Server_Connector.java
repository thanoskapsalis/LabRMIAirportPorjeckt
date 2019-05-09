/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.Naming;
import java.rmi.registry.Registry;
import java.util.ArrayList;

/**
 * @author nick
 */
public class Server_Connector {

    public static ArrayList<DataStorage> client = new ArrayList();
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
