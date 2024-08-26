/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi;

import java.rmi.Naming;

/**
 *
 * @author CuongAcQuy
 */
public class RMIClient {

    public static void main(String[] args) {
        try {
            Hello hello = (Hello) Naming.lookup("rmi://localhost/1");
            System.out.println(hello.hello("Co cai con cac"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
