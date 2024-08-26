/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package training;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CuongAcQuy
 */
public class Server_TCP_914 {

    public static class ClientHandler extends Thread{
        Socket sk;

        public ClientHandler(Socket sk) {
            this.sk = sk;
        }
        
        @Override
        public void run() {
            try {
                DataInputStream dis = new DataInputStream(sk.getInputStream());
                DataOutputStream dos = new DataOutputStream(sk.getOutputStream());
                
                //nhan msv
                String msv = dis.readUTF();
                System.out.println("Nhận được req của sv: " +msv);
                
                //gui cau hoi
                String ques = "";
//                for (int i = 'A'; i <= 'Z'; i++) {
//                    ques += (char) i;
//                }
                for (int i = 0; i < 10; i++) {
                    ques += String.valueOf((char)(Math.random()*26 + 'A'));
                }
                dos.writeUTF(ques);
                int s = (int) (Math.random()*100);
                dos.writeInt(s);
                dos.flush();
                System.out.println("Đã gửi cho sv "+msv+" câu hỏi: "+ques+" với s: "+s);
                
                //nhan ket qua
                String ans = dis.readUTF();
                System.out.println("Nhận được kết quả: "+ ans);
                if(checkDapAn(ques, s, ans)){
                    System.out.println("Đúng, pass!\n");
                }else{
                    System.out.println("Sai, failed!\n");
                }
                dis.close();
                dos.close();
                sk.close();
            } catch (Exception ex) {
                Logger.getLogger(Server_TCP_914.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        private boolean checkDapAn(String ques, int s, String ans) {
            if(ques.length() != ans.length()) return false;
            for (int i = 0; i < ques.length(); i++) {
                if('A' + (ques.charAt(i) - 'A' + s)%('Z'-'A'+1) != ans.charAt(i)) return false;
            }
            return true;
        }
        
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1309);
        while (true) {
            Socket sk = server.accept();
            new ClientHandler(sk).start();
        }

    }
}
