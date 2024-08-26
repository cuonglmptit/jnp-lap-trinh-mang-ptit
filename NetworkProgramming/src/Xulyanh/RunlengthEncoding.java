/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Xulyanh;

import java.util.Scanner;

/**
 *
 * @author CuongAcQuy
 */
public class RunlengthEncoding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int indx = 0;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i)!=s.charAt(i-1)){
                System.out.print(String.valueOf(s.charAt(i-1))+(i-indx));
                indx = i;
            }
        }
        System.out.print(String.valueOf(s.charAt(s.length()-1))+(s.length()-indx));
    }
}

