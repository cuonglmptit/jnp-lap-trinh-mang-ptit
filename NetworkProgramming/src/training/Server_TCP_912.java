/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package training;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author CuongAcQuy
 */
public class Server_TCP_912 {

    public static void main(String[] args) throws IOException {
        ServerSocket sv = new ServerSocket(1309);
        while (true) {
            Socket sk = sv.accept();
            new ClientHandler(sk).start();
        }
    }

    private static class ClientHandler extends Thread {

        Socket sk;

        public ClientHandler(Socket sk) {
            this.sk = sk;
        }

        @Override
        public void run() {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(sk.getOutputStream()));

                String msv = br.readLine();
                System.out.println("Nhận được yêu cầu từ sv: " + msv);

                String ques = "";
                for (int i = 0; i < 100; i++) {
                    ques += (char) (' ' + Math.random() * (126 - ' ' + 1));
                }
                bw.write(ques);
                bw.newLine();
                bw.flush();
                System.out.println("Đã gửi cho sv " + msv + " câu hỏi: " + ques);

                String ans1 = br.readLine();
                String ans2 = br.readLine();
                System.out.println("Nhận được đáp án: s1: " + ans1 + " s2: " + ans2);
                if (checkDapAn(ques, ans1, ans2)) {
                    System.out.println("Đúng, pass!\n");
                } else {
                    System.out.println("Sai, failed!\n");
                }

                br.close();
                bw.close();
                sk.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private boolean checkDapAn(String ques, String ans1, String ans2) {
            String checkAns1 = "";
            String checkAns2 = "";
            for (int i = 0; i < ques.length(); i++) {
                char tmp = ques.charAt(i);
                if ((tmp >= 'A' && tmp <= 'Z') || (tmp >= 'a' && tmp <= 'z') || (tmp >= '0' && tmp <= '9')) {
                    checkAns1 += tmp;
                } else {
                    checkAns2 += tmp;
                }
            }

            return (checkAns1.equals(ans1) && checkAns2.equals(ans2));
        }

    }
}
