
import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Νίκος
 */
public class Flights {
    
    public static ArrayList<String> List = new ArrayList();
    Random rand = new Random();
    public Flights()
    {
        List.add("Athens"+":Samos"+":10/5/2019"+":10"+":12.30"+":69"+":fc"+rand.nextInt(10000));
        List.add("Samos"+":Athens"+":15/5/2019"+":10"+":15.45"+":45"+":0");
        List.add("Athens"+":Samos"+":10/5/2019"+":10"+":8.30"+":200"+":fc"+rand.nextInt(10000));
        List.add("Samos"+":Athens"+":15/5/2019"+":10"+":10.20"+":45"+":0");
        List.add("Athens"+":Samos"+":10/5/2019"+":10"+":11.00"+":85"+":fc"+rand.nextInt(10000));
        List.add("Samos"+":Athens"+":15/5/2019"+":10"+":12.15"+":45"+":0");
        List.add("Athens"+":Thesaloniki"+":10/8/2019"+":15"+":9.30"+":180"+":fc"+rand.nextInt(10000));
        List.add("Thesaloniki"+":Athens"+":15/8/2019"+":15"+":12.30"+":105"+":0");
        List.add("Volos"+":Kupros"+":10/8/2019"+":15"+":9.30"+":105"+":fc"+rand.nextInt(10000));
        List.add("Kupros"+":Volos"+":15/8/2019"+":15"+":12.30"+":105"+":0");
    }
    
    
    
}
