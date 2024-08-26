/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nic04102023;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

/**
 *
 * @author DarkShadowDemon200x
 */
public class MulticastClient {

    public static void main(String[] args) throws SocketException, IOException {
        MulticastSocket clientSocket = new MulticastSocket(1309);
        InetAddress groupAddress = InetAddress.getByName("224.2.2.3");
        clientSocket.joinGroup(groupAddress);

        byte[] buffer = new byte[1024];

        System.out.println("Client started...");
        while (true) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            clientSocket.receive(packet);

            String receivedMessage = new String(packet.getData()).trim();
            System.out.println("Received: " + receivedMessage);
        }
    }
}
