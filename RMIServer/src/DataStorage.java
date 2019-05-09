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
    
    
    public DataStorage(String departure,String destination,String depart_date,String arrival_date,int passengers,int token)
    {
        this.departure=departure;
        this.destination=destination;
        this.depart_date=depart_date;
        this.arrival_date=arrival_date;
        this.passengers=passengers;
        this.token=token;
    }
    
    
    public String toString()
    {
        return departure+" "+destination+" "+token;
    }

    public int getToken() {
        return token;
    }
}
