/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Xulyanh;

/**
 *
 * @author DarkShadowDemon200x
 */
import java.util.Scanner;

public class Isodata {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        int L = 10;

        double t0 = L/2;

//        int m = n;
        int size = 760;
//        int[][] a = new int[n][m];
        int[] count = {20, 40, 30, 50, 70, 60, 120, 250, 100, 20};
//        int[] count = new int[L];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                a[i][j] = sc.nextInt();
//                count[a[i][j]]++;
//                t0+=a[i][j]/(double)size;
//            }
//        }
        double tuSoTrai = 0;
        double mauSoTrai = 0;
        double tuSoPhai = 0;
        double mauSoPhai = 0;

        double[] p = new double[L];
        double[] rp = new double[L];
//        double[] p = {0.09,0.2,0.1,0.06,0.06,0.08,0.35,0.04,0.01,0.01};
//        double[] rp = {0,0.2,0.2,0.18,0.24,0.4,2.1,0.28,0.08,0.09};
        for (int i = 0; i < L; i++) {
            p[i] = (double) count[i] / size;
            rp[i] = i * p[i];
            if (i <= (int)t0) {
                tuSoTrai += rp[i];
                mauSoTrai += p[i];
            } else {
                tuSoPhai += rp[i];
                mauSoPhai += p[i];
            }
        }

        double delta = 0;
        double tFirst = t0;
        double tAfter = 0;
        if (tuSoTrai == 0 && mauSoTrai == 0) {
            tAfter = 0.5 * (tuSoPhai / mauSoPhai);
        } else if (tuSoPhai == 0 && mauSoPhai == 0) {
            tAfter = 0.5 * (tuSoTrai / mauSoTrai);
        } else {
            tAfter = 0.5 * (tuSoTrai / mauSoTrai + tuSoPhai / mauSoPhai);
        }
        System.out.println("tt " + tuSoTrai);
        System.out.println("mst " + mauSoTrai);
        System.out.println("tp " + tuSoPhai);
        System.out.println("msp " + mauSoPhai);
        System.out.println(tAfter);
        System.out.println("");
        
        while (Math.abs(tFirst - tAfter) > delta) {
            tFirst = tAfter;
            
            tuSoTrai = 0;
            mauSoTrai = 0;
            tuSoPhai = 0;
            mauSoPhai = 0;
            System.out.println("tafter b4 i: "+tAfter);
            for (int i = 0; i < L; i++) {
                if (i <= (int)tAfter) {
                    tuSoTrai += rp[i];
                    mauSoTrai += p[i];
                    System.out.println("Cong rp "+rp[i]);
                } else {
                    tuSoPhai += rp[i];
                    mauSoPhai += p[i];
                }
            }

            if (tuSoTrai == 0 && mauSoTrai == 0) {
                tAfter = 0.5 * (tuSoPhai / mauSoPhai);
            } else if (tuSoPhai == 0 && mauSoPhai == 0) {
                tAfter = 0.5 * (tuSoTrai / mauSoTrai);
            } else {
                tAfter = 0.5 * (tuSoTrai / mauSoTrai + tuSoPhai / mauSoPhai);
            }

            System.out.println("lzlz");
            System.out.println(tAfter);

            System.out.println("tt " + tuSoTrai);
            System.out.println("mst " + mauSoTrai);
            System.out.println("tp " + tuSoPhai);
            System.out.println("msp " + mauSoPhai);
            System.out.println("");
        }

        System.out.println(tAfter);
//            System.out.println("Isodata threshold = "+(int)(tAfter+(L/2-tAfter)));
    }
}
