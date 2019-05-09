/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;

/**
 *
 * @author nick
 */
public class Data_toBook implements Serializable{
    String date;
    String time;
    String departure;
    String destination;
    String flightID;
    int seat;
    int ticketprice;
    boolean answer;
    String flag;
    
    
    public Data_toBook(String departure,String date,String destination,int seat)
    {
        this.date=date;
        this.departure=departure;
        this.destination=destination;
        this.seat=seat;
    }

    public Data_toBook(String flag){
        this.flag=flag;
    }

    public boolean getAnswer()
    {
        return answer;
    }
    public String toString()
    {
        return departure+" "+date+" "+destination+ " "+seat;
    }

    public String getFlag(){return flag;}
    public void setFlag(String flag){this.flag=flag;}

    
}
