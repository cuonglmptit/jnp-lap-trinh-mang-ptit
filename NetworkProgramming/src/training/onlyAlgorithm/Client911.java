/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package training.onlyAlgorithm;

import java.math.BigInteger;

/**
 *
 * @author CuongAcQuy
 */
public class Client911 {
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Phương thức tính LCM dựa trên GCD
    public static int findLCM(int a, int b) {
        return (a * b) / findGCD(a, b);
    }
    public static void main(String[] args) {
        int a = (int) (Math.random()*10000);
        int b = (int) (Math.random()*10000);
        
        System.out.println("a: "+a);
        System.out.println("b: "+b);
        
        BigInteger a1 = new BigInteger(String.valueOf(a));
        BigInteger b1 = new BigInteger(String.valueOf(b));
        System.out.println("a1: "+a1);
        System.out.println("b1: "+b1);
        
        BigInteger gcdBig = a1.gcd(b1);
        System.out.println("gcdBig: "+gcdBig);
        BigInteger lcmBig = ((a1.multiply(b1)).divide(gcdBig));
        System.out.println("lcmbig: "+lcmBig);
        
        System.out.println("gcdNor: "+findGCD(a, b));
        System.out.println("lcmNor: "+findLCM(a, b));
    }
}
