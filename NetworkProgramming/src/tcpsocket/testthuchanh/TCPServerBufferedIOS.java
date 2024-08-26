package tcpsocket.testthuchanh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author DarkShadowDemon200x
 */
public class TCPServerBufferedIOS {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(808);
        System.out.println("Server started...at 808 TCP");
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Connected to a client..: " + socket);
            ClientHandler clientHandler = new ClientHandler(socket);
            clientHandler.start();
        }
    }

    public static class ClientHandler extends Thread {

        Socket conn;

        public ClientHandler(Socket conn) {
            this.conn = conn;
        }

        @Override
        public void run() {
            
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
                String msv = br.readLine().trim();
                System.out.println("Received: " + msv);
                
                String ques = "giHgWHwkLf0Rd0.io, I7jpjuRw13D.io, wXf6GP3KP.vn, MdpIzhxDVtTFTF.edu, "
                        + "TUHuMfn25chmw.vn, HHjE9.com, 4hJld2m2yiweto.vn, y2L4SQwH.vn, s2aUrZGdzS.com, 4hXfJe9giAA.edu";
                bw.write(ques);
                bw.newLine();
                bw.flush();
                System.out.println("Sent: " + ques);
                String ans = "";
                while ((ans = br.readLine()) != null) {
                    System.out.println(ans);
                }
                conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
