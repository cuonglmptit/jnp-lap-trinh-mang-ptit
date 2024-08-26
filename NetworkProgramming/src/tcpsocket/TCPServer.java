/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcpsocket;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author DarkShadowDemon200x
 */
public class TCPServer {
//    public static void main(String[] args) throws IOException {
//        ServerSocket server = new ServerSocket(1309);
//        System.out.println("server running...at port 1309");
//        while (true) {            
//            Socket conn = server.accept();
//            System.out.println("ket noi thanh cong 1 client: "+conn);
//            //nhan du lieu
//            DataInputStream dis = new DataInputStream(conn.getInputStream());
//            int a = dis.readInt();
//            int b = dis.readInt();
//            System.out.format("nhan duoc (a, b): %d %d\n", a, b);
//            //gui du lieu
//            DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
//            dos.writeDouble(a+b);
//            //dong ket noi
//            conn.close();
//        }
//    }

    /*version 2 nhap lien tuc den khi co sum = 1309 thi ket thuc va xu ly nhieu client su dung Thread*/
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1309);
        System.out.println("Server running...at port 1309");

        while (true) {
            Socket conn = server.accept();
            System.out.println("Connected to client: " + conn);
            System.out.println("Socket ip:" +conn.getInetAddress()+" Port: "+conn.getPort());
        
            // Tạo một luồng mới để xử lý kết nối
            Thread clientHandler = new ClientHandler(conn);
            clientHandler.start();
        }
    }

    // Luồng con để xử lý từng kết nối riêng lẻ
    private static class ClientHandler extends Thread {

        private Socket conn;

        public ClientHandler(Socket conn) {
            this.conn = conn;
        }

        @Override
        public void run() {
            try {
                // Nhận dữ liệu
                DataInputStream dis = new DataInputStream(conn.getInputStream());
                while (true) {
                    int a = dis.readInt();
                    int b = dis.readInt();
                    System.out.format("Received data (a, b): %d %d\n", a, b);

                    // Xử lý dữ liệu và gửi kết quả
                    DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
                    dos.writeDouble(a + b);
                    
                    // Đóng kết nối
                    if(a+b == 1309){
                        conn.close();
                        break;
                    }
                }
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
