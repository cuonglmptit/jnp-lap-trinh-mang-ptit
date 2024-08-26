/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serializeable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Calendar;

/**
 *
 * @author DarkShadowDemon200x
 */
public class DeserializeTime {

    public static void main(String[] args) {
        String filename = "C:\\Users\\cle13\\Documents\\NetBeansProjects\\NetworkPrograming\\src\\thuchanh1\\time.ser";
        if (args.length > 0) {
            filename = args[0];
        }
        // Deserialize the previously saved
        // PersistentTime object instance.
        PersistentTime time = null;
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);
            time = (PersistentTime) in.readObject();
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        // print out restored time
        System.out.println("Previously serialized time: " + time.getTime());
        // print out the current time
        System.out.println("Current time: " + Calendar.getInstance().getTime());
    }
}
