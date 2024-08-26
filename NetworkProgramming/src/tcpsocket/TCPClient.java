/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcpsocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author DarkShadowDemon200x
 */
public class TCPClient {
//    public static void main(String[] args) throws IOException {
//        Socket client = new Socket("localhost", 1309);
//        System.out.println("ket noi thanh cong den server: "+client);
//        //gui du lieu yeu cau
//        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
//        dos.writeInt(100);
//        dos.writeInt(200);
//        //nhan du lieu dap tra
//        DataInputStream dis = new DataInputStream(client.getInputStream());
//        double sum = dis.readDouble();
//        System.out.println("sum: "+sum);
//        //dong ket noi
//        client.close();
//    }

    /*version 2 nhap tu ban phim*/
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 1309);
        System.out.println("Socket ip:" +client.getInetAddress()+" Port: "+client.getPort());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        DataInputStream dis = new DataInputStream(client.getInputStream());
        System.out.println("ket noi thanh cong den server: " + client);
        Scanner sc = new Scanner(System.in);
        while (true) {
            //gui du lieu yeu cau
            System.out.print("Nhap A: ");
            int a = sc.nextInt();
            System.out.print("Nhap B: ");
            int b = sc.nextInt();
            dos.writeInt(a);
            dos.writeInt(b);
            //nhan du lieu dap tra
            double sum = dis.readDouble();
            System.out.println("SUM: " + sum);
            //dong ket noi
            if (a + b == 1309) {
                client.close();
                break;
            }
        }

    }
}
