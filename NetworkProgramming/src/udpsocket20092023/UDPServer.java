/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udpsocket20092023;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author DarkShadowDemon200x
 */
public class UDPServer {

    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket server = new DatagramSocket(1309);
        System.out.println("server started at 1309...");
        
        while (true) {
            //receive
            byte[] buf = new byte[1024];
            DatagramPacket reqPacket = new DatagramPacket(buf, buf.length);
            server.receive(reqPacket);
            String strReq = new String(reqPacket.getData()).trim();
            System.out.println("received: " + strReq);
            //
            String strRes = new StringBuilder(strReq).reverse().toString();
            System.out.println("Nhan duoc tu ip"+ reqPacket.getAddress());
            DatagramPacket resPacket = new DatagramPacket(strRes.getBytes(), strRes.length(), reqPacket.getAddress(), reqPacket.getPort());
            server.send(resPacket);
            System.out.println("Gui"+ strRes);
            System.out.println("send reverse string: "+strRes);
            if(strReq.equalsIgnoreCase("tat server")) break;
        }
    }
}
