/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udpsocket20092023;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author DarkShadowDemon200x
 */
public class UDPClient {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket client = new DatagramSocket();
        String strReq = "tat server";
        //send req
        byte[] data =  strReq.getBytes();
        DatagramPacket reqPacket = new DatagramPacket(data, data.length, InetAddress.getByName("localhost"), 1309);
        client.send(reqPacket);
        System.out.println("send req success");
        
        //receive res
        byte[] buf = new byte[1024];
        DatagramPacket resPacket = new DatagramPacket(buf, buf.length);
        client.receive(resPacket);
        System.out.println("received reverse str: " + new String(resPacket.getData()).trim() );
    }
}
