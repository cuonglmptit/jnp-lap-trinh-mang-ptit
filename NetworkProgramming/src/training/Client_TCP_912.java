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
import java.net.Socket;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author CuongAcQuy
 */
public class Client_TCP_912 {
    public static void main(String[] args) throws IOException {
        Socket sk = new Socket("localhost", 1309);
        BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(sk.getOutputStream()));

        String msv = "B20DCCN100;915\n";
        bw.write(msv);
        bw.flush();

        String ques = br.readLine();
        System.out.println(ques);

        String ans1 = "";
        String ans2 = "";
        for (int i = 0; i < ques.length(); i++) {
            char tmp = ques.charAt(i);
            if ((tmp >= 'A' && tmp <= 'Z') || (tmp >= 'a' && tmp <= 'z') || (tmp >= '0' && tmp <= '9')) {
                ans1+=tmp;
            }else{
                ans2+=tmp;
            }
        }


        bw.write(ans1);
        bw.newLine();
        bw.write(ans2);
        bw.newLine();
        bw.flush();
        
        br.close();
        bw.close();
        sk.close();
    }
}
