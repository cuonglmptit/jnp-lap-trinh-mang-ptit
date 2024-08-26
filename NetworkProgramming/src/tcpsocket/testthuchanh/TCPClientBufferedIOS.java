/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcpsocket.testthuchanh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author DarkShadowDemon200x
 */
public class TCPClientBufferedIOS {

    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 808);

        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        
        String msv = "B20DCCN100;600";
        bw.write(msv);
        bw.newLine();
        bw.flush();
        System.out.println("Da gui: "+msv);
        
        String ques = br.readLine();
        System.out.println("Nhan duoc: " + ques);
        
        String[] edu = ques.split("[,]");
        for (String string : edu) {
            String isedu = string.trim();
            if(isedu.endsWith(".edu")){
                bw.write(isedu);
                bw.newLine();
                bw.flush();
                System.out.println("Da gui: "+isedu);
            }
        }
        client.close();
    }
}
