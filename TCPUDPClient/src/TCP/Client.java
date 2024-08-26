/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author CuongAcQuy
 */
public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket sk = new Socket("localhost", 1309);
        ObjectInputStream ois = new ObjectInputStream(sk.getInputStream());
        ObjectOutputStream oos = new ObjectOutputStream(sk.getOutputStream());
        
        String msv = "B20DCCN100";
        oos.writeObject(msv);
        oos.flush();        
        
        Product917 quesPro = (Product917) ois.readObject();
        System.out.println(quesPro);
        
        String name = quesPro.getName();
        String soluong = String.valueOf(quesPro.getQuantity());
        
        String[] splitName = name.split("[\\s+]");
        name = splitName[splitName.length-1]+" ";
        for (int i = 1; i < splitName.length-1; i++) {
            name += splitName[i]+" ";
        }
        name += splitName[0];
        
        String newSL = "";
        for (int i = soluong.length()-1; i >= 0 ; i--) {
            newSL += soluong.charAt(i);
        }
        quesPro.setName(name);
        quesPro.setQuantity(Integer.parseInt(newSL));
        
        oos.writeObject(quesPro);
        oos.flush();
        
        ois.close();
        oos.close();
        sk.close();
    }
}
