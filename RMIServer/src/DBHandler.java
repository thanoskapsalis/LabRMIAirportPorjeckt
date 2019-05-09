import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class DBHandler {
    Data_toBook togo;
    Data_toBook toreturn;

    public DBHandler(Data_toBook togo, Data_toBook toreturn) {
        this.togo = togo;
        this.toreturn = toreturn;
        run();
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


        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
