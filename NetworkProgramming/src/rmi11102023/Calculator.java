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
public interface Calculator extends Remote{
    public int addNum(int a, int b) throws RemoteException;
}
