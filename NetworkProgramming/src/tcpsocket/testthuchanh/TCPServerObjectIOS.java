/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcpsocket.testthuchanh;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DarkShadowDemon200x
 */
public class TCPServerObjectIOS {

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

        private static String convertGPAToLetter(float gpa) {
            if (gpa > 3.7 && gpa <= 4) {
                return "A";
            } else if (gpa > 3.0 && gpa <= 3.7) {
                return "B";
            } else if (gpa > 2.0 && gpa <= 3.0) {
                return "C";
            } else if (gpa > 1.0 && gpa <= 2.0) {
                return "D";
            } else {
                return "F";
            }
        }

        @Override
        public void run() {
            try {
                ObjectInputStream ois = new ObjectInputStream(conn.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(conn.getOutputStream());
                String msv = (String) ois.readObject();

                System.out.println("Nhận được req của sinh viên: " + msv);
                //gui 1 instance student
                TCPStudent student = new TCPStudent((int) (Math.random() * 100), "B20DCCN" + (int) (Math.random() * 900), (float) (Math.random() + 3.0), null);
                oos.writeObject(student);
                System.out.println("Đã gửi Student:" + student);

                TCPStudent receivedStudent = (TCPStudent) ois.readObject();

                System.out.println("Nhận được student: " + receivedStudent);
                if (convertGPAToLetter(student.getGpa()).equals(receivedStudent.getGpaLetter())) {
                    System.out.println("Kết quả đúng, pass!");
                    oos.writeObject("Kết quả đúng, pass!");
                } else {
                    System.out.println("Kết quả sai, failed!");
                    oos.writeObject("Kết quả sai, failed!");
                }
                //dong ket noi
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(TCPServerObjectIOS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
