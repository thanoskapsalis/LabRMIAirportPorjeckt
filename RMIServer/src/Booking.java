/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author nick
 */
public interface Booking extends Remote {
    
    public void BookChecker(String departure,String destination,String depart_date,String arrival_date,int passengers,int token) throws RemoteException;
    public String Confirm() throws RemoteException;
    public ArrayList<String> FlightPreview() throws RemoteException;
    public void cleanup() throws  RemoteException;
    public void BookFlight(String FlightID,int passengers) throws RemoteException;
        
    
}
