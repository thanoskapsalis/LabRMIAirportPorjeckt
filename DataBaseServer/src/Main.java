
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
    public static ArrayList<Data_toBook> Odj = new ArrayList();
    public static int remainSeats;

    public static void main(String[] args) {

        int not=0;
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

                    if (flag.getFlag().equals("OK")) {

                        while (true) {
                            Data_toBook message = (Data_toBook) instream.readObject();
                            System.out.println("The client says : " + message.getFlag());

                            if (message.getFlag().equals("GO")) {
                                System.out.println("GO");
                                Data_toBook message2 = (Data_toBook) instream.readObject();
                                System.out.println("The booking is : " + message2.toString());
                                Data_toBook sentWait = new Data_toBook("WAITING");
                                outstream.writeObject(sentWait);
                                outstream.flush();
                                System.out.println("EEEEEEEEEEEEEEEEEEE  "+flight.List.size());
                                for (int j = 0; j < flight.List.size(); j++) {

                                    dataIn = flight.List.get(j).split(":");
                                    

                                    if (dataIn[0].equals(message2.getDeparture()) && dataIn[1].equals(message2.getDestination()) && dataIn[2].equals(message2.getDate())) {
                                        System.out.println(message2.getDeparture());
                                        remainSeats = Integer.parseInt(dataIn[3]);
                                        //System.out.println("PRIN " + dataIn[3]);

                                        System.out.println(message2.getToken());
                                        if (remainSeats >= message2.getSeat()) {
                                            Data_toBook ok = new Data_toBook("OK",message2.getToken());
                                            outstream.writeObject(ok);
                                            outstream.flush();
                                            
                                            Data_toBook start = new Data_toBook("START",flight.List.size());
                                            outstream.writeObject(start);
                                            outstream.flush();
                                            System.out.println(flight.List.size());
                                            for(int k=0; k<flight.List.size(); k++)
                                            {
                                                data= flight.List.get(k).split(":");
                                                //System.out.println(flight.List.get(k).toString());
                                                Odj.add(new Data_toBook(data[0],data[2],data[1],Integer.parseInt(data[5]),data[6]));
                                               
                                                System.out.println(Odj.get(k).toString());
                                                outstream.writeObject(Odj.get(k));
                                                outstream.flush();
                                            }
                                            
                                            //remainSeats = remainSeats - message2.getSeat();
                                            //dataIn[3] = String.valueOf(remainSeats);
                                            //flight.List.set(j,dataIn[0]+":"+dataIn[1]+":"+dataIn[2]+":"+dataIn[3]);
                                            //System.out.println("META " + dataIn[3]);
                                            flightFlag = true;
                                            Kk = j + 1;
                                            break;
                                        } else {
                                            System.out.println("Not enough seats");
                                            Data_toBook Notok = new Data_toBook("NOseat",message2.getToken());
                                            outstream.writeObject(Notok);
                                            outstream.flush();
                                        }
                                    } else {
                                        System.out.println("No flight found!!");
                                        not++;
                                        System.out.println(not);
                                        
                                    }

                                }
                                if(not==4)
                                {
                                    Data_toBook Noflight = new Data_toBook("NOflight",message2.getToken());
                                    outstream.writeObject(Noflight);
                                    outstream.flush();
                                }
                                i++;

                            } else if (message.getFlag().equals("RET")) {
                                System.out.println("RET");
                                Data_toBook message3 = (Data_toBook) instream.readObject();
                                System.out.println("The booking is : " + message3.toString());
                                System.out.println(flightFlag);
                                if (flightFlag == true) {
                                    dataIn = flight.List.get(Kk).split(":");
                                    //int remainSeats = Integer.parseInt(dataIn[3]);
                                    //System.out.println("PRIN " + dataIn[3]);
                                    //remainSeats = remainSeats - message3.getSeat();
                                    //dataIn[3] = String.valueOf(remainSeats);
                                    //flight.List.set(Kk,dataIn[0]+":"+dataIn[1]+":"+dataIn[2]+":"+dataIn[3]);
                                    //System.out.println("META " + dataIn[3]);    
                                }
                                i++;

                            }
                           // Data_toBook bookflag = (Data_toBook) instream.readObject();
                            //System.out.println("EGW TO LEW RE : " + bookflag.getFlag());
                            if(message.getFlag().equals("BOOK"))
                            {
                                System.out.println(message.getFlightID());
                                
                                 String[] dataIn = flight.List.get(Kk-1).split(":");
                                 
                                System.out.println(dataIn[6]);
                                if(message.getFlightID().equals(dataIn[6]))
                                {
                                    System.out.println("PRIN " + dataIn[3]);
                                    remainSeats = remainSeats - message.getPassengers();
                                    dataIn[3] = String.valueOf(remainSeats);
                                    flight.List.set(Kk-1,dataIn[0]+":"+dataIn[1]+":"+dataIn[2]+":"+dataIn[3]+":"+dataIn[4]+":"+dataIn[5]+":"+dataIn[6]);
                                    flight.List.set(Kk,dataIn[1]+":"+dataIn[0]+":"+dataIn[2]+":"+dataIn[3]+":"+dataIn[4]+":"+dataIn[5]+":"+0);
                                    System.out.println("META " + dataIn[3]);
                                    System.out.println(flight.List.get(Kk-1));
                                    System.out.println(flight.List.get(Kk));
                                    Data_toBook Booked = new Data_toBook("FINE");
                                    outstream.writeObject(Booked);
                                    outstream.flush();
                                    
                                }
                                
                            }
                            

                            for (int j = 0; j < flight.List.size(); j++) {
                                System.out.println(flight.List.get(j));
                            }

                            if (i == 2) {
                                break;
                            }
                        }

                    }
                    //if(flag.getFlag().equals("BOOK"))
                    //{
                        
                       // System.out.println("OKOKOK");
                    //}

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
