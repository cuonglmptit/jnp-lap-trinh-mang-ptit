
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
import java.util.StringTokenizer;

/**
 *
 * @author CuongAcQuy
 */
public class Server_UDP_931 {
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
        InetAddress addr = InetAddress.getByName("localhost");
        DatagramSocket socket = new DatagramSocket(1309, addr);
        System.out.println("UDP server started...at: "+addr+":"+1309);

        while (true) {            
            byte[] receiveBuf = new byte[65536];
            DatagramPacket receivePack = new DatagramPacket(receiveBuf, receiveBuf.length);
            socket.receive(receivePack);
            
            String msv = new String(receivePack.getData()).trim();
            System.out.println("Nhận được req của sv: "+msv);
            
            String ques = "";
            for (int i = 0; i < 10; i++) {
                ques+=(char)('A' +Math.random()*('z'-'A'+1));
            }
            ques+=";";
            
            for (int i = 0; i < 50; i++) {
                if(i<49) ques+=(int) (-500+Math.random()*1000)+",";
                else ques+=(int)(Math.random()*1000);
            }
            
            DatagramPacket sendPack = new DatagramPacket(ques.getBytes(), ques.getBytes().length, receivePack.getAddress(), receivePack.getPort());
            socket.send(sendPack);
            System.out.println("Đã gửi cho sv: "+msv+" câu hỏi: "+ques);
            
            receiveBuf = new byte[65536];
            DatagramPacket receivedAnsPack = new DatagramPacket(receiveBuf, receiveBuf.length);
            socket.receive(receivedAnsPack);
            String ans = new String(receivedAnsPack.getData()).trim();
            System.out.println("Nhận được kết quả: "+ans);
            
            if(checkDapAn(ques, ans)){
                System.out.println("Đúng, pass!\n");
            }else{
                System.out.println("Sai, failed!\n");
            }
            
        }
    }

    private static boolean checkDapAn(String ques, String ans) {
        StringTokenizer st = new StringTokenizer(ans, ";,", false);
        String quesID = st.nextToken();
                
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        while(st.hasMoreTokens()){
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp<min) min = tmp;
            if(tmp>max) max = tmp;
        }
        String checkAns = quesID+";"+max+","+min;
        return checkAns.equals(ans);
    }
}
