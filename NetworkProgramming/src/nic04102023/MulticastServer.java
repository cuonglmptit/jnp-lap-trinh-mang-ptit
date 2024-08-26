/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nic04102023;

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
public class MulticastServer {

    public static void main(String[] args) throws SocketException, UnknownHostException, IOException, InterruptedException {
        DatagramSocket server = new DatagramSocket();
        System.out.println("Sertver started...");
        String strMess = "String from server";
        int i = 0;
        while (true) {
            byte[] data = (strMess + " "+i).getBytes();
            DatagramPacket message = new DatagramPacket(data, data.length, InetAddress.getByName("224.2.2.3"), 1309);
            server.send(message);
            System.out.println("send: "+ new String(message.getData()).trim());
            i++;
            Thread.sleep(2000);
        }
    }
}
