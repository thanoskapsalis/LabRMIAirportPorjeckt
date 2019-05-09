
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static String[] dataIn;
    
    

    public static void main(String[] args) {

        try {
            //orizoume tin porta epikoinonias
            ServerSocket server = new ServerSocket(5555);
            Flights flight = new Flights();
            int Kk=0;
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
                                Data_toBook sentWait = new Data_toBook("WAITING");//stelnoume flag WAITING gia na dilosoume oti anoikse h epikoinonia
                                outstream.writeObject(sentWait);
                                outstream.flush();
                                for (int j = 0; j < flight.List.size(); j++) {
                                    
                                    dataIn = flight.List.get(j).split(":");
                                    
                                    if (dataIn[0].equals(message2.getDeparture()) && dataIn[1].equals(message2.getDestination()) && dataIn[2].equals(message2.getDate())) {
                                        System.out.println(message2.getDeparture());
                                        int remainSeats = Integer.parseInt(dataIn[3]);
                                        System.out.println("PRIN " + dataIn[3]);
                                        
                                        if (remainSeats >= message2.getSeat()) {
                                            remainSeats = remainSeats - message2.getSeat();
                                            dataIn[3] = String.valueOf(remainSeats);
                                            flight.List.set(j,dataIn[0]+":"+dataIn[1]+":"+dataIn[2]+":"+dataIn[3]);
                                            System.out.println("META " + dataIn[3]);
                                            flightFlag=true;
                                            Kk=j+1;
                                            break;
                                        } else {
                                            System.out.println("Not enough seats");
                                        }
                                    }
                                    else
                                        System.out.println("No flight found!!");

                                }
                                i++;

                            } else if (message.getFlag().equals("RET")) {
                                System.out.println("RET");
                                Data_toBook message3 = (Data_toBook) instream.readObject();
                                System.out.println("The booking is : " + message3.toString());
                                System.out.println(flightFlag);
                                if(flightFlag==true)
                                {
                                    dataIn = flight.List.get(Kk).split(":");
                                    int remainSeats = Integer.parseInt(dataIn[3]);
                                    System.out.println("PRIN " + dataIn[3]);
                                    remainSeats = remainSeats - message3.getSeat();
                                    dataIn[3] = String.valueOf(remainSeats);
                                    flight.List.set(Kk,dataIn[0]+":"+dataIn[1]+":"+dataIn[2]+":"+dataIn[3]);
                                    System.out.println("META " + dataIn[3]);    
                                }
                                i++;

                            }
                            
                            for (int j = 0; j < flight.List.size(); j++) {
                                System.out.println(flight.List.get(j));
                            }
                            
                            if (i == 2) {
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
