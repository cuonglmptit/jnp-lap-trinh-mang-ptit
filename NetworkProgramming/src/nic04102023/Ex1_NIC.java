/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nic04102023;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 *
 * @author DarkShadowDemon200x
 */
public class Ex1_NIC {
    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> nics = NetworkInterface.getNetworkInterfaces();
        while(nics.hasMoreElements()){
            NetworkInterface nic = nics.nextElement();
            System.out.println(nic);
        }
    }
}
