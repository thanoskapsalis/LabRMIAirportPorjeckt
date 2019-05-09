import java.io.Serializable;

/**
 *
 * @author nick
 */
public class Data_toBook implements Serializable {

    String date;
    String time;
    String departure;
    String destination;
    String flightID;
    int seat;
    int ticketprice;
    boolean answer;
    String flag;
    int token;

    public Data_toBook(String departure, String date, String destianation, int seat,int token) {
        this.date = date;
        this.departure = departure;
        this.destination = destianation;
        this.seat = seat;
        this.token=token;
    }

    public Data_toBook(String flag) {
        this.flag = flag;
    }

    public Data_toBook(String flag, int token){
        this.flag=flag;
        this.token=token;
    }

    public boolean getAnswer() {
        return answer;
    }

    public String toString() {
        return departure + " " + date + " " + destination + " " + seat + " " + token;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public int getSeat() {
        return seat;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDate() {
        return date;
    }

    public String getDestination() {
        return destination;
    }

    public int getToken() {
        return token;
    }
}