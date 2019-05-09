/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nick
 */
public class DataStorage {
    String depart_date;
    String arrival_date;
    String departure;
    String destination;
    int passengers;
    int token;
    int price;
    String flightID;
    
    
    public DataStorage(String departure,String destination,String depart_date,String arrival_date,int passengers,int token)
    {
        this.departure=departure;
        this.destination=destination;
        this.depart_date=depart_date;
        this.arrival_date=arrival_date;
        this.passengers=passengers;
        this.token=token;
    }

    public DataStorage(String departure,String destination,String depart_date,String arrival_date,String flightID,int price)
    {
        this.departure=departure;
        this.destination=destination;
        this.depart_date=depart_date;
        this.arrival_date=arrival_date;
        this.flightID=flightID;
        this.price=price;
    }
    
    
    public String toString()
    {
        return flightID+"\t"+departure+"\t"+destination+"\t"+depart_date+"\t"+arrival_date+"\t"+price;
    }

    public int getToken() {
        return token;
    }
}
