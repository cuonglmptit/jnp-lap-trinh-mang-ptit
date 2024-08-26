/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package streamio;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author DarkShadowDemon200x
 */
public class FileReaderWriter {

    public static void main(String[] args) throws IOException {
        File inputFile = new File("C:\\Users\\cle13\\Documents\\NetBeansProjects\\NetworkPrograming\\src\\streamio\\againnewfile.txt");
//        File outputFile = new File("C:\\Users\\cle13\\Documents\\NetBeansProjects\\NetworkPrograming\\src\\streamio\\againnewfile.txt");
        FileReader in = new FileReader(inputFile);
//        FileWriter out = new FileWriter(outputFile);
        int c;
        while ((c = in.read()) != -1) {
            System.out.print((char)c);
//            out.write(c);
        }
        System.out.println("FileReader is used to read a file and FileWriter is used for writing.");
        in.close();
//        out.close();
    }
}
