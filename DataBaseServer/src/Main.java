
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        try {
            //orizoume tin porta epikoinonias
            ServerSocket server = new ServerSocket(5555);
            while (true) {
                int i=0;
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
                                i++;

                            } else if (message.getFlag().equals("RET")) {
                                System.out.println("RET");
                                Data_toBook message3 = (Data_toBook) instream.readObject();
                                System.out.println("The booking is : " + message3.toString());
                                i++;

                            }
                            if(i==2)
                                break;
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
