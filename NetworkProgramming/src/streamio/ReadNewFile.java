/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package streamio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author DarkShadowDemon200x
 */
public class ReadNewFile {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String file = "C:\\Users\\cle13\\Documents\\NetBeansProjects\\NetworkPrograming\\src\\streamio\\newfile.txt";
        FileInputStream fis = new FileInputStream(file);

        byte[] data = new byte[1024];
        while (fis.available() > 0) {
            fis.read(data);
        }
        System.out.println(new String(data, "UTF-8"));

    }
}
