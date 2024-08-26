/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcpsocket.testthuchanh;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author DarkShadowDemon200x
 */
public class TCPClientDataIOS {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 1309);
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        DataInputStream dis = new DataInputStream(client.getInputStream());
        //gui yeu cau
        String msv = "B20DCCN100;800";
        dos.writeUTF(msv);
        dos.flush();
        //nhan 2 so
        int a = dis.readInt();
        int b = dis.readInt();
        //tinh tong, tich
        int sum = a+b;
        int multiple = a*b;
        //gui lai cho server
//        dos.writeInt(sum + 1); // check ket qua sai
        dos.writeInt(sum);
        dos.flush();
        dos.writeInt(multiple);
        dos.flush();
//        System.out.println(dis.readUTF());
        client.close();
    }
}
