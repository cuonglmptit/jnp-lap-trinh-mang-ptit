/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcpsocket.testthuchanh;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author CuongAcQuy
 */
public class NewClass {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 808);
        System.out.println("1");
        DataInputStream br = new DataInputStream(client.getInputStream());
        System.out.println("2");
        OutputStreamWriter bw = new OutputStreamWriter(client.getOutputStream());
        System.out.println("3");
        String msv = "B20DCCN100;600";
        bw.write(msv);
        bw.write("\n");
        bw.flush();
        System.out.println("Da gui: "+msv);
        String ques = new String(br.readLine());
        System.out.println("Nhan duoc: " + ques);
        
        String[] edu = ques.split("[,]");
        for (String string : edu) {
            String isedu = string.trim();
            if(isedu.endsWith(".edu")){
                bw.write(isedu);
                bw.write("\n");
                bw.flush();
                System.out.println("Da gui: "+isedu);
            }
        }
        client.close();
    }
}
