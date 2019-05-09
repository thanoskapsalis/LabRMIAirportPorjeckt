/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author nick
 */
public class RMIHandler extends UnicastRemoteObject implements Booking {
    
    protected RMIHandler() throws RemoteException
    {
        super();
        System.out.println("New Booking Request");
    }

    @Override
    public void BookChecker(String departure, String destination, String depart_date, String arrival_date, int passengers) throws RemoteException {
       Data_toBook togo= new Data_toBook(departure,depart_date,destination,passengers);
       System.out.println("//////Successfully Saved/////");
       System.out.println(togo.toString());
       Data_toBook toreturn= new Data_toBook(destination,arrival_date,departure,passengers);
       System.out.println("//////Successfully Saved return flight/////");
       System.out.println(toreturn.toString());
       DBHandler db_link = new DBHandler(togo,toreturn);

    }

    @Override
    public boolean Confirn() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
    
    
    
}
