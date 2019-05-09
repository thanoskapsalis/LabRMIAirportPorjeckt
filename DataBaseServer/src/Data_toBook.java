/*Nikos Potaris
icsd15173*/

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

    public Data_toBook(String departure, String date, String destianation, int seat) {
        this.date = date;
        this.departure = departure;
        this.destination = destianation;
        this.seat = seat;
    }

    public Data_toBook(String flag) {
        this.flag = flag;
    }

    public boolean getAnswer() {
        return answer;
    }

    public String toString() {
        return departure + " " + date + " " + destination + " " + seat;
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

}
