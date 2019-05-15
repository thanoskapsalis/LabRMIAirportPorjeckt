
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {

    public static String[] dataIn;
    public static String[] data;
    public static String[] dataF;
    public static ArrayList<Data_toBook> Odj = new ArrayList();
    public static int remainSeats;
    public static int okok = 0;

    public static void main(String[] args) {

        int not = 0;

        try {
            //orizoume tin porta epikoinonias
            ServerSocket server = new ServerSocket(5555);
            Flights flight = new Flights();
            int Kk = 0;
            while (true) {
                int i = 0;
                System.out.println("Accepting Connection...");
                System.out.println("Local Address :" + server.getInetAddress() + " Port:" + server.getLocalPort());
                Socket sock = server.accept();//apodoxi tis sundesis

                try {
                    //arxi is epikoinonias
                    InputStream inputStream = sock.getInputStream();
                    ObjectInputStream instream = new ObjectInputStream(inputStream);
                    OutputStream outputStream = sock.getOutputStream();
                    ObjectOutputStream outstream = new ObjectOutputStream(outputStream);

                    Data_toBook flag = (Data_toBook) instream.readObject();
                    System.out.println("The client says : " + flag.getFlag());
                    boolean flightFlag = false;

                    if (flag.getFlag().equals("OK")) {//elenxos tou eiserxomenou flag gia tin sunexisi tis diadikasias alios emfanisei minimatos lathous

                        while (true) {
                            Data_toBook message = (Data_toBook) instream.readObject();
                            System.out.println("The client says : " + message.getFlag());

                            if (message.getFlag().equals("GO")) {//elenxos tou eiserxomenou flag gia tin sunexisi tis diadikasias alios emfanisei minimatos lathous
                                System.out.println("GO");
                                Data_toBook message2 = (Data_toBook) instream.readObject();
                                System.out.println("The booking is : " + message2.toString());
                                Data_toBook sentWait = new Data_toBook("WAITING");//apostoli flag gia enoimerosi tou RMI server(client)
                                outstream.writeObject(sentWait);
                                outstream.flush();
                                for (int j = 0; j < flight.List.size(); j++) {//prospelasi olis tis listas ton ptiseon gia tous aparetitous elenxous

                                    dataIn = flight.List.get(j).split(":");//split tis listas me vasei to ":" gia tous aparetitous elenxous

                                    if (dataIn[0].equals(message2.getDeparture()) && dataIn[1].equals(message2.getDestination()) && dataIn[2].equals(message2.getDate())) {
                                        remainSeats = Integer.parseInt(dataIn[3]);
                                        if (remainSeats >= message2.getSeat()) {

                                            Data_toBook ok = new Data_toBook("OK", message2.getToken());
                                            outstream.writeObject(ok);
                                            outstream.flush();
                                            for (int k = 0; k < flight.List.size(); k++) {
                                                data = flight.List.get(k).split(":");

                                                if ((data[0].equals(dataIn[0]) && data[1].equals(dataIn[1])) || (data[0].equals(dataIn[1]) && data[1].equals(dataIn[0]))) {
                                                    okok++;
                                                }
                                            }
                                            Data_toBook start = new Data_toBook("START", okok);//apostoli flag gia enoimerosi tou server
                                            outstream.writeObject(start);
                                            outstream.flush();
                                            okok = 0;
                                            Odj.clear();
                                            int in = 0;
                                            for (int k = 0; k < flight.List.size(); k++) {

                                                dataF = flight.List.get(k).split(":");
                                                if ((dataF[0].equals(dataIn[0]) && dataF[1].equals(dataIn[1])) || (dataF[0].equals(dataIn[1]) && dataF[1].equals(dataIn[0]))) {

                                                    System.out.println(dataF[0] + "" + dataF[2] + "" + dataF[1] + "" + dataF[5] + "" + dataF[6]);
                                                    Odj.add(new Data_toBook(dataF[0], dataF[2], dataF[1], Integer.parseInt(dataF[5]), dataF[6], dataF[4]));
                                                    outstream.writeObject(Odj.get(in));
                                                    outstream.flush();
                                                    in++;
                                                }
                                            }
                                            flightFlag = true;//enoimerosi tou flag flightFlag
                                            Kk = j + 1;
                                            break;
                                        } else {//an den isuei o parapanw elenxos aposteloume katalilo flag ston RMI server
                                            System.out.println("Not enough seats");
                                            Data_toBook Notok = new Data_toBook("NOseat", message2.getToken());
                                            outstream.writeObject(Notok);
                                            outstream.flush();
                                        }
                                    } else {
                                        System.out.println("No flight found!!");
                                        not++;

                                    }

                                }
                                if (not == flight.List.size()) {//elenxos gia to an den uparxei i ptisi pou anazitithike kai apostoli katalilou flag
                                    Data_toBook Noflight = new Data_toBook("NOflight", message2.getToken());
                                    outstream.writeObject(Noflight);
                                    outstream.flush();
                                    not = 0;
                                }
                                i++;

                            } else if (message.getFlag().equals("RET")) {//an uparxei h ptisei tote proxorame ston elenxo tis epistrofis tis ptisis (apo tin stigmi pou einai paketo)
                                System.out.println("RET");
                                Data_toBook message3 = (Data_toBook) instream.readObject();
                                System.out.println("The booking is : " + message3.toString());
                                if (flightFlag == true) {
                                    dataIn = flight.List.get(Kk).split(":"); 
                                }
                                i++;

                            }
                            if (message.getFlag().equals("BOOK")) {//an to flag pou exoume lavei einai BOOK proxorame gia tin ulopoihsi tis kratisis
                                for (int g = 0; g < flight.List.size(); g++) {
                                    String[] dataIn = flight.List.get(g).split(":");

                                    if (message.getFlightID().equals(dataIn[6])) {//an to flightID tis ptisis pou anazitithike vrethei tote proxorame stin kratisi
                                        remainSeats = remainSeats - message.getPassengers();
                                        dataIn[3] = String.valueOf(remainSeats);
                                        //enoimerosi tis listas
                                        flight.List.set(g, dataIn[0] + ":" + dataIn[1] + ":" + dataIn[2] + ":" + dataIn[3] + ":" + dataIn[4] + ":" + dataIn[5] + ":" + dataIn[6]);
                                        flight.List.set(g+1, dataIn[1] + ":" + dataIn[0] + ":" + dataIn[2] + ":" + dataIn[3] + ":" + dataIn[4] + ":" + dataIn[5] + ":" + 0);
                                        Data_toBook Booked = new Data_toBook("FINE");//apostoli flag gia tin enoimerosi tis epitixis karatisis
                                        outstream.writeObject(Booked);
                                        outstream.flush();

                                    }
                                }
                                sock.close();//klisimo tou socket epikoinonias meta to peras tis xrisis
                            }

                            if (i == 2) {//an o metritis i isoute me duo(diladi uparxei to paketo tis ptisis pou anazitithike tote telrionei h epanalipsi kathos kai h epikoinonia)
                                break;
                            }
                        }

                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                System.out.println("Connection Closing...");

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
