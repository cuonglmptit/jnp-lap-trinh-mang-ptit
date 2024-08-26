/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author CuongAcQuy
 */
public class Client {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException, ClassNotFoundException {
        DatagramSocket sk = new DatagramSocket();
        
        String msv = "B20DCCN100";
        Product937 sendPro = new Product937();
        sendPro.setCode(msv);
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(sendPro);
        
        byte[] sendBuf = baos.toByteArray();
        DatagramPacket sendPack = new DatagramPacket(sendBuf, sendBuf.length, InetAddress.getByName("localhost"), 1309);
        sk.send(sendPack);
        
        byte[] receiBuf = new byte[65536];
        DatagramPacket receiPack = new DatagramPacket(receiBuf, receiBuf.length);
        sk.receive(receiPack);
        ByteArrayInputStream bais = new ByteArrayInputStream(receiPack.getData());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Product937 quesPro = (Product937) ois.readObject();
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
        
        baos = new ByteArrayOutputStream();
        oos = new ObjectOutputStream(baos);
        oos.writeObject(quesPro);
        
        sendBuf = baos.toByteArray();
        sendPack = new DatagramPacket(sendBuf, sendBuf.length, receiPack.getAddress(), receiPack.getPort());
        sk.send(sendPack);
        
        bais.close();
        ois.close();
        baos.close();
        oos.close();
        sk.close();
    }
}
