/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcpsocket.testthuchanh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author DarkShadowDemon200x
 */
public class ngu {

    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 808);
//        StringWriter sw = new StringWriter();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        bw.write("DucDepTrai");
        bw.newLine();
        bw.flush();

        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
//        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        String[] ss = s.split(",");
        for (String i : ss) {
            if (i.contains(".edu")) {
                bw.write(i);
                bw.newLine();
                bw.flush();
            }

        }
        bw.close();
        br.close();
        client.close();
    }
}
