/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcpsocket.testthuchanh;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

/**
 *
 * @author DarkShadowDemon200x
 */
public class TCPClientIOS {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1", 1309);
        InputStream ios = new BufferedInputStream(client.getInputStream());
        OutputStream oos = new BufferedOutputStream(client.getOutputStream());

        String msv = "B20DCCN100;700";
        oos.write(msv.getBytes());
        oos.flush();
        System.out.println("Đã gửi: "+msv);
        
        byte[] buf = new byte[1024];
        ios.read(buf);
        String ques = new String(buf).trim();
        System.out.println("Nhận được ques: "+ques);
        
        int sum = 0;
        StringTokenizer st = new StringTokenizer(ques, "| ", false);
        while (st.hasMoreTokens()) {            
            sum += Integer.parseInt(st.nextToken().trim());
        }
        oos.write(String.valueOf(sum).getBytes());
        oos.flush();
        System.out.println("Đã gửi sum: "+sum);
        client.close();
    }
}
