package training;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.LinkedHashSet;
import java.util.Set;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author CuongAcQuy
 */
public class Client_TCP_915 {

    public static void main(String[] args) throws IOException {
        Socket sk = new Socket("localhost", 1309);
        BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(sk.getOutputStream()));

        String msv = "B20DCCN100;915\n";
        bw.write(msv);
        bw.flush();

        String ques = br.readLine();
        System.out.println(ques);

        Set<String> st = new LinkedHashSet();
        String ans = "";
        for (int i = 0; i < ques.length(); i++) {
            char tmp = ques.charAt(i);
            if ((tmp >= 'A' && tmp <= 'Z') || (tmp >= 'a' && tmp <= 'z')) {
                st.add(String.valueOf(tmp));
            }
        }

        for (String string : st) {
            ans += string;
        }
        System.out.println(ans);
        bw.write(ans);
        bw.newLine();
        bw.flush();
        
        br.close();
        bw.close();
        sk.close();
    }
}
