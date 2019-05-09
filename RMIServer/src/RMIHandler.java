/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * @author nick
 */
public class RMIHandler extends UnicastRemoteObject implements Booking {

    String flag;

    protected RMIHandler() throws RemoteException {
        super();
        System.out.println("New Booking Request");
    }

    @Override
    public void BookChecker(String departure, String destination, String depart_date, String arrival_date, int passengers, int token) throws RemoteException {
        DataStorage temp = new DataStorage(departure, destination, depart_date, arrival_date, passengers, token);
        Server_Connector.client.add(temp);
        Data_toBook togo = new Data_toBook(departure, depart_date, destination, passengers, temp.getToken());
        System.out.println("//////Successfully Saved/////");
        System.out.println(togo.toString());
        Data_toBook toreturn = new Data_toBook(destination, arrival_date, departure, passengers, temp.getToken());
        System.out.println("//////Successfully Saved return flight/////");
        System.out.println(toreturn.toString());
        DBHandler db_link = new DBHandler(togo, toreturn);
        flag = db_link.rmi();

    }

    @Override
    public String Confirm() throws RemoteException {
        return flag;
    }
    ArrayList<String> test_array= new ArrayList<>();


    public ArrayList<String> FlightPreview() {
        for(int i=0; i<DBHandler.full.size(); i++){
            test_array.add(DBHandler.full.get(i).toString());
        }
        return test_array;

    }

}
