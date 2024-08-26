/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcpsocket.testthuchanh;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DarkShadowDemon200x
 */
public class TCPServerDataIOS {

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

        private Socket conn;

        public ClientHandler(Socket conn) {
            this.conn = conn;
        }

        @Override
        public void run() {
            try {
                DataInputStream dis = new DataInputStream(conn.getInputStream());
                DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
                String msv = dis.readUTF();
                System.out.println("Nhận được req của sinh viên: " + msv);
                //gui 2 so nguyen cho tinh toan
                int a = (int) (500 * Math.random()), b = (int) (500 * Math.random());

                dos.writeInt(a);
                dos.writeInt(b);
                
                int sum = dis.readInt(), multiple = dis.readInt();
                System.out.println("Đã gửi 2 số: a:"+a+" b: "+b);
                System.out.println("Nhận được tổng a+b: "+sum+" tích a*b: "+multiple);
                if(sum == a+b && multiple == a*b){
                    System.out.println("Kết quả đúng, pass!");
                    dos.writeUTF("Kết quả đúng, pass!");
                }else{
                    System.out.println("Kết quả sai, failed!");
                    dos.writeUTF("Kết quả sai, failed!");
                }
                //dong ket noi
                conn.close();
            } catch (IOException ex) {
                Logger.getLogger(TCPServerDataIOS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
