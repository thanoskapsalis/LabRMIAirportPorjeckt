
import java.rmi.*;

public interface Booking extends Remote {

    public void BookChecker(String departure, String destination, String depart_date, String arrival_date, int passengers,int token) throws RemoteException;

    public boolean Confirn() throws RemoteException;
}
