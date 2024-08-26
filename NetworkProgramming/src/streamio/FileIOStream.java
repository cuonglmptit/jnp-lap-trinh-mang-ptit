/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package streamio;

/**
 *
 * @author DarkShadowDemon200x
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOStream {

    public static void main(String[] args) throws IOException {
        File inputFile = new File("C:\\Users\\cle13\\Documents\\NetBeansProjects\\NetworkPrograming\\src\\streamio\\newfile.txt");
        File outputFile = new File("C:\\Users\\cle13\\Documents\\NetBeansProjects\\NetworkPrograming\\src\\streamio\\outputnewfile.txt");
        FileInputStream in = new FileInputStream(inputFile);
        FileOutputStream out = new FileOutputStream(outputFile);
        int c;
        while ((c = in.read()) != -1) {
            System.out.println(c);
            out.write(c);
        }
        System.out.println("FileInputStream is used to read a file and FileOutPutStream is used for writing.");
        in.close();
        out.close();
    }
}
