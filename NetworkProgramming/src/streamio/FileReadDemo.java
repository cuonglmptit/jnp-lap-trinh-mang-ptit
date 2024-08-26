/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package streamio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DarkShadowDemon200x
 */
public class FileReadDemo {

    public static void main(String[] args) {
        String file = "C:\\Users\\cle13\\Documents\\NetBeansProjects\\NetworkPrograming\\src\\streamio\\newfile.txt";
        String file2 = "C:\\Users\\cle13\\Documents\\NetBeansProjects\\NetworkPrograming\\src\\streamio\\newfile2.txt";
//        try (FileInputStream fis = new FileInputStream(file); 
//                FileOutputStream fos = new FileOutputStream(file2)){
//            
//            byte[] data = new byte[1024];
//            while(fis.available() > 0) fis.read(data);
//            
//            fos.write(new String(data,"BIG5").trim().getBytes());
//            System.out.println(new String(data, "BIG5"));
//        } catch (Exception e) {
//        }
        
        FileInputStream fis = null;
        try {
            
            fis = new FileInputStream(file);
            System.out.println("file exist");
//            byte[] data = new byte[1024];
//            while (fis.available() > 0) {                
//                fis.read(data);
//            }
//            System.out.println(new String(data));
//            
            int data = 0;
            while((data = fis.read()) != -1)
                System.out.print((char) data);
        } catch (FileNotFoundException ex) {
            System.out.println("file not exist");
            Logger.getLogger(FileReadDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileReadDemo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fis != null) 
                try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(FileReadDemo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
