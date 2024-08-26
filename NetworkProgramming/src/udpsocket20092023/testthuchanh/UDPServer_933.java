/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udpsocket20092023.testthuchanh;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;

/**
 *
 * @author CuongAcQuy
 */
public class UDPServer_933 {
    public static void main(String[] args) throws Exception {
        InetAddress ip = InetAddress.getByName("localhost");
        DatagramSocket socket = new DatagramSocket(1309, ip);
        System.out.println("UDP server started...at: "+ip+":"+1309);
        //Nhan msv
        byte[] receiBuf = new byte[65536];
        DatagramPacket receiPacket  = new DatagramPacket(receiBuf, receiBuf.length);
        socket.receive(receiPacket);
        System.out.println("(Server) Nhận được yêu cầu đề từ: "+new String(receiPacket.getData()).trim());
        //Tao student va gui cho sv
        Student student = new Student(String.valueOf((int)(100*Math.random())), "B20DCCN"+String.valueOf((int)(100*Math.random())), "Con cac", "lol@gmai.com");
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(student);
        oos.flush();
        
        byte[] sendBuf = baos.toByteArray();
        DatagramPacket sendPacket = new DatagramPacket(sendBuf, sendBuf.length, receiPacket.getAddress(), receiPacket.getPort());
        socket.send(sendPacket);
        System.out.println("(Server) Đã gửi đề bài: "+student);
        //Nhan lai ket qua cua sv
        receiBuf = new byte[65536];//refresh bo dem
        receiPacket = new DatagramPacket(receiBuf, receiBuf.length);
        socket.receive(receiPacket);
        ByteArrayInputStream bais = new ByteArrayInputStream(receiPacket.getData());
        ObjectInputStream ois = new ObjectInputStream(bais);
        
        Student studentReceived = (Student) ois.readObject();
        System.out.println("(Server) Nhận được kết quả: "+studentReceived);
    }
}
