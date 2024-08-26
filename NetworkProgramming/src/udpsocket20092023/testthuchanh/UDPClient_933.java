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
import java.net.InetAddress;

/**
 *
 * @author CuongAcQuy
 */
public class UDPClient_933 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        String msv = "B20DCCN100";
        
        byte[] sendBuf = new byte[65536];
        DatagramPacket sendPacket = new DatagramPacket(msv.getBytes(), msv.getBytes().length, InetAddress.getByName("localhost"), 1309);
        socket.send(sendPacket);
        System.out.println("(Client) Đã gửi yêu cầu ra đề bài: "+msv);
        
        byte[] receiBuf = new byte[65536];
        DatagramPacket receiPacket = new DatagramPacket(receiBuf, receiBuf.length);
        socket.receive(receiPacket);
        ByteArrayInputStream bais = new ByteArrayInputStream(receiPacket.getData());
        ObjectInputStream ois = new ObjectInputStream(bais);
        
        Student studentReceived = (Student) ois.readObject();
        System.out.println("(Client) Nhận được đề bài: "+studentReceived);
        
        studentReceived.setCode(new String(new StringBuilder(studentReceived.getCode()).reverse()));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(studentReceived);
        oos.flush();
        
        sendBuf = baos.toByteArray();
        sendPacket = new DatagramPacket(sendBuf, sendBuf.length, receiPacket.getAddress(), receiPacket.getPort());
        socket.send(sendPacket);
        System.out.println("(Client) Đã gửi kết quả: "+studentReceived);
    }
}
