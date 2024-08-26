/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package training;

import UDP.Product937;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

/**
 *
 * @author CuongAcQuy
 */
public class Server_UDP_937 {

    public static void main(String[] args) throws SocketException, IOException, ClassNotFoundException {
        InetAddress ip = InetAddress.getByName("localhost");
        DatagramSocket sk = new DatagramSocket(1309, ip);
        System.out.println("Server UDP running at port 1309...");

        while (true) {
            byte[] receiBuf = new byte[65536];
            DatagramPacket revceiPack = new DatagramPacket(receiBuf, receiBuf.length);
            sk.receive(revceiPack);
            ByteArrayInputStream bais = new ByteArrayInputStream(revceiPack.getData());
            ObjectInputStream ois = new ObjectInputStream(bais);
            Product937 ques = (Product937) ois.readObject();
            System.out.println("Nhận được req của sv: " + ques);

            ques.setId("1");
            ques.setName("T520 thinkpad lenovo");
            ques.setQuantity(1899);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(ques);

            byte[] sendBuf = baos.toByteArray();
            DatagramPacket sendPack = new DatagramPacket(sendBuf, sendBuf.length, revceiPack.getAddress(), revceiPack.getPort());
            sk.send(sendPack);
            System.out.println("Đã gửi :" + ques + " cho sv: " + ques.getCode());

            receiBuf = new byte[65536];
            revceiPack = new DatagramPacket(receiBuf, receiBuf.length);
            sk.receive(revceiPack);
            bais = new ByteArrayInputStream(revceiPack.getData());
            ois = new ObjectInputStream(bais);
            Product937 receiPro = (Product937) ois.readObject();

            System.out.println("Nhận được ans: " + receiPro+"\n");
        }
    }
}
