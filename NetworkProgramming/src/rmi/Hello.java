/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rmi;
import java.rmi.*;

/**
 *
 * @author CuongAcQuy
 */
public interface Hello extends Remote{
   public String hello(String name) throws RemoteException;
}
