
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author CuongAcQuy
 */
public class NewClass {
    public static void main(String[] args) throws ParseException {
        String data = "9-13-2002";
        System.out.println(data);
        Date simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy").parse(data);
        System.out.println(simpleDateFormat);
        String a = new SimpleDateFormat("dd/MM/yyyy").format(simpleDateFormat);
        System.out.println(a);
        
    }
}
