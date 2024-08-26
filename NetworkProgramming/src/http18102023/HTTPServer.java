/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package http18102023;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author DarkShadowDemon200x
 */
public class HTTPServer {

    public static void main(String[] args) throws IOException {
        InetAddress addr = InetAddress.getByName("192.168.137.1");
        ServerSocket server = new ServerSocket(Integer.parseInt("1309"), 50, addr);
        System.out.println("server started 1309 ...");
        while (true) {
            System.out.println("");
            Socket conn = server.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = br.readLine();
            System.out.println("Kết nối với 1 thằng: " + conn.getInetAddress());
            while (line != null && !line.isEmpty()) {
                System.out.println(line);
                line = br.readLine();
            }

            String status = "HTTP/1.1 200 OK \r\n\r\n";
            BufferedReader f = new BufferedReader(new FileReader("C:\\Users\\CuongAcQuy\\Documents\\NetBeansProjects\\NetworkPrograming\\src\\http18102023\\newhtml.html"));
            OutputStream os = conn.getOutputStream();
            String l = f.readLine();
            os.write((status).getBytes());
            os.flush();
            while (l != null && !l.isEmpty()) {
//                System.out.println(l);
                os.write((l + "\n").getBytes());
                l = f.readLine();
            }
            os.flush();
            System.out.println(conn);
            System.out.println("close..." + conn);
            br.close();
            os.close();
            conn.close();
        }
    }
}
