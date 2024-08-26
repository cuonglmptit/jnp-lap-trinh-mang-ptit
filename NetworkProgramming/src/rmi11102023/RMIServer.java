///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package rmi11102023;
//
//import java.nio.channels.AlreadyBoundException;
//
///**
// *
// * @author DarkShadowDemon200x
// */
//public class RMIServer {
//
//    public static void main(String[] args) throws AlreadyBoundException {
//        try {
////tao doi tuong CalculatorImpl
//            CalculatorImpl cal = new CalculatorImpl();
//            System.out.println("Exporting Calculator ! ");
////thong bao su hien dien của cal la doi tuong co kha nang remote cho JVM
//            UnicastRemoteObject.exportObject(cal); // ???
////dang ky doi tuong voi trinh quan ly rmi
//            Naming.bind("rmi://localhost/cal", cal);
//            System.out.println("Register Calculator!");
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//
//}
