/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi;

import java.rmi.server.*;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
/**
 *
 * @author CuongAcQuy
 */
public class HelloImpl extends UnicastRemoteObject implements Hello {

    public HelloImpl() throws RemoteException {
        super();
    }

    private static final long serialVersionUID = 1L;

    @Override
    public String hello(String name) throws RemoteException {
        System.out.println("ten la: " + name);
        return "xin chao " + name;
    }

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://localhost/1", new HelloImpl());
            System.out.println("Server san sang");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
