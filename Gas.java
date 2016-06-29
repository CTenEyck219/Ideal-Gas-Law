/*
 * Created by: Cameron Wildey
 * Date: 3/2/16
 * Class: CIS 219 Ideal gas pressure
 * This java class represents the user input for temperature and 
 * volume of the container that the gas is housed in. 
 * It will set T (temp) and V (volume) to a default value and allow the
 * user to find the Ideal Gas Pressure from the two variables mentioned above
*/

import java.text.*;

public class Gas {
    public static double N = 1.0;//moles
    public static double R = 0.7302;//gas constant
    
    //setting the attributes for gas
    private double T;//temperature
    private double V;//volume of the container
    
    
    //no-arg constructor
    
    Gas() {
        T = 0.0;//default if there is no user input
        V = 0.0;//default if there is no user input
    }//end of no arg constructor
    
    
/*
* multiple arg constructor that sets
* all private attributes
*/
    
    Gas(double i, double j) {
        T = i;
        V = j;
    }//end of overloaded constructor
    
    //getter for temperature
    public double getTemp() {
        return(T);
    }//end getter
    
    //getter for volume
    public double getVolume() {
        return(V);
    }//end getter
    
    //getter for temperature in Kelvin
    public double getKelvin() {
        return(T + 460.0);
    }//end getter
    
    //setter for temperature
    public void setTemp(double i) {
        T = i;
    }//end setter
    
    //setter for volume
    public void setVolume(double j) {
        V = j;
    }
    //method that calculates gas pressure
    public double gasInAtmospheres() {
       return((N * R * getKelvin()) / V);
    }//end calculation method
    
    //print method
    public String toString() {
        //setting the ideal gas pressure to two decimal places to the right
        DecimalFormat mine = new DecimalFormat("#0.00");
        String output = new String();
        output = "For an ideal gas at " + getKelvin() + " K in a " + getVolume()
                + " cu ft container, the pressure is " + 
                mine.format(gasInAtmospheres());
        return(output);
    }//end print method
}
