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
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author DarkShadowDemon200x
 */
public class TCPServerIOS {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1309);
        System.out.println("Server running at... port 1309");
        while (true) {
            Socket conn = server.accept();
            System.out.println("Connected to client: " + conn);
            // Tạo một luồng mới để xử lý kết nối
            Thread clientHandler = new ClientHandler(conn);
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
                InputStream ios = new BufferedInputStream(conn.getInputStream());
                OutputStream oos = new BufferedOutputStream(conn.getOutputStream());

                int length = 0;
                byte[] data = new byte[65536];
                length = ios.read(data);
                System.out.println("Nhận được msv: " + new String(data, 0, length).trim());

                String ques = "";
                for (int i = 0; i < 4; i++) {
                    if (i < 3) {
                        ques += (int)(Math.random() * 100) + "|";
                    }else{
                        ques += (int)(Math.random() * 100);
                    }
                }
                oos.write(ques.getBytes());
                oos.flush();
                System.out.println("Đã gửi ques: " + ques);

                length = ios.read(data);
                String sum = new String(data, 0, length).trim();
                System.out.println("Nhận được kết quả: " + sum);

                conn.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
