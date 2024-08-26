/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi11102023;
import java.rmi.*;
/**
 *
 * @author DarkShadowDemon200x
 */
public class CalculatorImpl implements Calculator{
    public int addNum(int a, int b) throws RemoteException {
        System.out.println("Client request to calculate");
        return (a + b);
    }

}
