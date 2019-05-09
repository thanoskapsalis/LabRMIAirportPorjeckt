
import java.rmi.*;
import java.util.ArrayList;

public interface Booking extends Remote {

    public void BookChecker(String departure, String destination, String depart_date, String arrival_date, int passengers,int token) throws RemoteException;

    public String Confirm() throws RemoteException;
    
    public ArrayList<String> FlightPreview() throws RemoteException;
}
