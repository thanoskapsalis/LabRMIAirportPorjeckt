import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class DBHandler {
    Data_toBook togo;
    Data_toBook toreturn;
    String RMIflag;
    public static ArrayList<DataStorage> full = new ArrayList<>();
    public static ArrayList<Data_toBook> retrieved = new ArrayList();


    public DBHandler(Data_toBook togo, Data_toBook toreturn) {
        this.togo = togo;
        this.toreturn = toreturn;
        run();
    }

    public DBHandler(String flightID, int passengers) {
        create_reservation(flightID,passengers);
    }

    private void create_reservation(String flightID,int passengers) {
        try {
            System.out.println("Booking Attempt");
            Socket socket = new Socket("192.168.1.4", 5555);
            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
            os.writeObject(new Data_toBook("OK"));
            os.writeObject(new Data_toBook("BOOK",flightID,passengers));
            Data_toBook confirm = (Data_toBook) is.readObject();
            System.out.println(confirm.getFlag());
            RMIflag=confirm.getFlag();

        }catch (Exception e){

        }

    }

    public void run() {
        try {
            System.out.println("Connecting to Database");
            Socket socket = new Socket("192.168.1.4", 5555);
            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
            os.writeObject(new Data_toBook("OK"));
            os.flush();
            os.writeObject(new Data_toBook("GO"));
            os.flush();
            os.writeObject(togo);
            os.flush();
            Data_toBook accept = (Data_toBook) is.readObject();
            if (accept.getFlag().equals("WAITING")) {
                System.out.println("Flight Successfully Sent to DBHandler");
                os.writeObject(new Data_toBook("RET"));
                os.flush();
                os.writeObject(toreturn);
                os.flush();
                System.out.println("Flight Successfully Sent to DBHandler");
            }
            Response(os, is);


        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void Response(ObjectOutputStream os, ObjectInputStream is) throws IOException, ClassNotFoundException {
        System.out.println("Waiting for response from the DB Server");
        Data_toBook response = (Data_toBook) is.readObject();

        if (response.getFlag().equals("OK")) {
            RMIflag = response.getFlag();
            RetrieveFlights(os, is);
            GroupFlights(retrieved);
        }

        if (response.getFlag().equals("NOseat"))
        {
            RMIflag = response.getFlag();
            System.out.println("Rejecetd");
        }

        if (response.getFlag().equals("NOflight"))
        {
            RMIflag = response.getFlag();
            System.out.println("Wrong Data");
        }


    }

    public String rmi() {return RMIflag;}


    private void RetrieveFlights(ObjectOutputStream os, ObjectInputStream is) throws IOException, ClassNotFoundException {
        Data_toBook data = (Data_toBook) is.readObject();
        System.out.println("Retrieving Flights Number: " + data.getToken());
        for (int i = 0; i < data.getToken(); i++) {
            retrieved.add((Data_toBook) is.readObject());
            //System.out.println(retrieved.get(i).toString());
        }


    }

    private void GroupFlights(ArrayList<Data_toBook> retrieved) {
        System.out.println("GROUPING");
        for (int i = 0; i < retrieved.size(); i++) {

            if (i % 2 == 0) {
                // System.out.println(i);
                full.add(new DataStorage(retrieved.get(i).getDeparture(), retrieved.get(i + 1).getDeparture(),
                        retrieved.get(i).getDate(), retrieved.get(i + 1).getDate(),
                        retrieved.get(i).getFlightID(), retrieved.get(i).getTicketprice()));
            }
            for (int j = 0; j < full.size(); j++) {
                System.out.println(full.get(j).toString());
            }
        }
    }
}
