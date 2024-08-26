/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcpsocket.testthuchanh;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author DarkShadowDemon200x
 */
public class TCPClientObjectIOS {

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

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket client = new Socket("localhost", 1309);
        ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
        //gui yeu cau
        String msv = "B20DCCN100;139";
        oos.writeObject(msv);
        oos.flush();

        //nhan student
        TCPStudent student = (TCPStudent) ois.readObject();
        //chuyen gpa
        student.setGpaLetter(convertGPAToLetter(student.getGpa()));
        //gui lai cho server
//        // check ket qua sai
//        student.setGpaLetter(student.getGpaLetter().equals("A") ? "B" : "A");
//        oos.writeObject(student); 
        oos.writeObject(student);

        System.out.println(ois.readObject());
        client.close();
    }
}
