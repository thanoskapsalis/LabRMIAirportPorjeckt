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
    boolean answer;
    String flag;
    String hours;
    int token;
    int price;
    int passengers;

    public Data_toBook(String departure, String date, String destianation, int seat,int token) {
        this.date = date;
        this.departure = departure;
        this.destination = destianation;
        this.seat = seat;
        this.token=token;
    }
    
    public Data_toBook(String departure, String date, String destianation,int price,String flightID, String time) {
        this.date = date;
        this.departure = departure;
        this.destination = destianation;
        this.price=price;
        this.flightID=flightID;
        this.time=time;
    }

    public Data_toBook(String flag) {
        this.flag = flag;
    }
    
    public Data_toBook(String flag,String flightID,int passengers) {
        this.flag = flag;
        this.flightID=flightID;
        this.passengers=passengers;
    }

    public Data_toBook(String flag, int token){
        this.flag=flag;
        this.token=token;
    }

    public boolean getAnswer() {
        return answer;
    }

    public String toString() {
        return departure + " " + date + " " + destination + " " + price + " " + flightID + " " + time;
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

    public String getFlightID(){return  flightID;}

    public int getTicketprice(){return price;}
    
    public int getPassengers(){return passengers;}
    
    public String getTime(){return time;}
}