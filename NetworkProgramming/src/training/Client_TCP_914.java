/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package training;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author CuongAcQuy
 */
public class Client_TCP_914 {
    public static void main(String[] args) throws IOException {
        Socket sk = new Socket("localhost",1309);
        DataInputStream dis = new DataInputStream(sk.getInputStream());
        DataOutputStream dos = new DataOutputStream(sk.getOutputStream());
        
        String msv = "B20DCCN100;914";
        dos.writeUTF(msv);
        dos.flush();
        
        String ques = dis.readUTF();
        int s = dis.readInt();
        
        String ans = "";
        for (int i = 0; i < ques.length(); i++) {
            ans += (char) ('A' + (ques.charAt(i) -'A' + s)%26);
        }
        dos.writeUTF(ans);
        dos.flush();
        dis.close();
        dos.close();
        sk.close();
    }
}
