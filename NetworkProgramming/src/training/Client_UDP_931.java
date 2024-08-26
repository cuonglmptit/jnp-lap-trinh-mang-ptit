/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package training;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author CuongAcQuy
 */
public class Client_UDP_931 {

    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket socket = new DatagramSocket();

        String msv = "B20DCCN100";
//        byte[] sendBuf = new byte[65536];
        DatagramPacket sendPack = new DatagramPacket(msv.getBytes(), msv.getBytes().length, InetAddress.getByName("localhost"), 1309);
        socket.send(sendPack);
        
        byte[] receiveBuf = new byte[65536];
        DatagramPacket receivePack = new DatagramPacket(receiveBuf, receiveBuf.length);
        socket.receive(receivePack);
        String ques = new String(receivePack.getData()).trim();
        System.out.println(ques);

        String[] sta = ques.split("[;,]");

        String quesID = sta[0];

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 1; i < sta.length; i++) {
            int tmp = Integer.parseInt(sta[i]);
            if(tmp<min) min = tmp;
            if(tmp>max) max = tmp;
        }
        String ans = quesID+";"+max+","+min;
        System.out.println(ans);
        sendPack = new DatagramPacket(ans.getBytes(), ans.getBytes().length, receivePack.getAddress(), receivePack.getPort());
        socket.send(sendPack);
        
    }
}
