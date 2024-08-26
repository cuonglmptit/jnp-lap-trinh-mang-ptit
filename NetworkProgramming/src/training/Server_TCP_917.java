/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package training;

import TCP.Product917;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CuongAcQuy
 */
public class Server_TCP_917 {
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

    private static class ClientHandler extends Thread {
        Socket conn;
        public ClientHandler(Socket conn) {
            this.conn = conn;
        }

        @Override
        public void run() {
            try {
                ObjectOutputStream oos = new ObjectOutputStream(conn.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(conn.getInputStream());
                String msv = (String) ois.readObject();

                System.out.println("Nhận được req của sinh viên: " + msv);
                //gui 1 instance student
                Product917 ques = new Product917("1", msv, "T520 thinkpad lenovo", 123456);
                oos.writeObject(ques);
                System.out.println("Đã gửi Student:" + ques);
                //Nhan ket qua
                Product917 ans = (Product917) ois.readObject();
                System.out.println("Nhận được kết quả: "+ans+"\n");
                ois.close();
                oos.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(Server_TCP_917.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
