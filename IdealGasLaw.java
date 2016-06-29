/*
 * Created by: Cameron Wildey
 * Date: 3/2/16
 * Class: CIS 219 Ideal gas pressure
 * This program is to calculate the ideal gas pressure
 * with the formula p = ( N * R * (T + 460.0)) / V.
 * The user will be asked to input both the tempeture (T) as well as
 * the volume of the container the gas is housed in (V).
 * When this information is entered it will be stored in an array, 
 * the size of which will be expressed by the user.
 * The user will be asked to input the temperature and volume by way of
 * a JOptionPane.showInputDialog and when the information is entered it
 * will be pluged into the formula and the results will be shown 
 * via a JOptionPane.showMessageDialog.
*/

import javax.swing.*;
import java.awt.*;

public class IdealGasLaw { 
    
    public static void main(String[] args) {
        userIdealGas();
    }

    public static void userIdealGas() {
        
        //Joptionpane settings
        Font arrayFont = new Font("courier", Font.ROMAN_BASELINE, 14);
        JTextArea gasTextArea = new JTextArea();
        int max = 0;//ends for loop
        
        max = Integer.parseInt(JOptionPane.showInputDialog("How many sets "
                + "of data do you have to input? "));
        Gas [] gasPressure = new Gas[max];
        
        for (int i = 0; i < gasPressure.length; i++) {
            String inputString = null;
            double temperature = -9999;//To keep the compiler happy.
                              //Designed to look like a garbage value.
                              
            boolean done = false;
            while (! done) {
                try {
                inputString = JOptionPane.showInputDialog(
                "Enter the temperature");
                inputString = inputString.trim();
                temperature = Double.parseDouble(inputString);
                done = true;
            }//end of try
                catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, 
                        "Please enter a number!");
            }//end of catch
        }//end of while loop
            
            //checking for positive number on temperature input
            while (temperature < 0) {
                temperature = Double.parseDouble(JOptionPane.showInputDialog(
                "Enter the temperature"));
            }//end of while loop
            
            String inputString2 = null;
            double volume = -9999;//To keep the compiler happy.
                              //Designed to look like a garbage value.
                              
            boolean done2 = false;
            
            while (! done2) {
                try {
                inputString2 = JOptionPane.showInputDialog("Enter the Volume");
                inputString2 = inputString2.trim();
                volume = Double.parseDouble(inputString2);
                done2 = true;
            }//end of try
                catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, 
                        "Please enter a number!");
            }//end of catch
        }//end of while loop
            
            //checking for positive number on volume input
            while (volume < 0) {
                volume = Double.parseDouble(JOptionPane.showInputDialog(
                "Enter the Volume"));
            }//end of while loop
            
            Gas userGas = new Gas(temperature, volume);
            /*calls the constructor from the gas class and 
            sets the variables given by the user to the class
            attributes
            */
            
            //adds the userGas to gasPressure array
            gasPressure[i] = userGas;
            
            //sets the JTextArea to the array to print
            gasTextArea = new JTextArea(gasPressure[i].toString());
            gasTextArea.setFont(arrayFont);
            
            JOptionPane.showMessageDialog(null,gasTextArea, "Users Temp and "
                    + "Volume", JOptionPane.INFORMATION_MESSAGE, null);
        }//end of for loop
        
        System.exit(0);//exits all JOptionPane panes
    }
}