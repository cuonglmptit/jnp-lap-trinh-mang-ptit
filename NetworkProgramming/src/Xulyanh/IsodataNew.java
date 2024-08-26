/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Xulyanh;

import java.util.Scanner;

/**
 *
 * @author DarkShadowDemon200x
 */
public class IsodataNew {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        int L = 10;

//        int m = n;
        double sum = 0;
//        int[][] a = new int[n][m];
        int size = 760;
//        int size = n * m;
//        int[] count = new int[L];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                a[i][j] = sc.nextInt();
//                count[a[i][j]]++;
//            }
//        }

        int[] count = {20, 40, 30, 50, 70, 60, 120, 250, 100, 20};
        double tuSoTrai = 0;
        double mauSoTrai = 0;
        double tuSoPhai = 0;
        double mauSoPhai = 0;

        double[] p = new double[L];
        double[] rp = new double[L];
//        double[] p = {0.5, 0.167 ,0.133 ,0.1, 0.067, 0.033};
//        double[] rp = {0, 0.167, 0.267, 0.3, 0.267, 0.167};
        for (int i = 0; i < L; i++) {
            p[i] = (double) count[i] / size;
            rp[i] = i * p[i];
        }
        double sumipi=0, sumpi=0;
        for (int i = 0; i <= L - 1; i++) {
            sumipi += i * p[i];
            sumpi += p[i];
        }
        double t0 = 5;
//        double t0 = 4.5;
        
        for (int i = 0; i < L; i++) {
            p[i] = (double) count[i] / size;
            rp[i] = i * p[i];
            if (i <= t0) {
                tuSoTrai += rp[i];
                mauSoTrai += p[i];
            } else {
                tuSoPhai += rp[i];
                mauSoPhai += p[i];
            }
            sum += p[i];
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
        System.out.println("");
        System.out.println(tFirst);
        while (Math.abs(tFirst - tAfter) > delta) {
            tFirst = tAfter;
            tuSoTrai = 0;
            mauSoTrai = 0;
            tuSoPhai = 0;
            mauSoPhai = 0;
            for (int i = 0; i < L; i++) {
                if (i <= tAfter) {
                    tuSoTrai += rp[i];
                    mauSoTrai += p[i];
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

//        System.out.println(tAfter);
        System.out.println("Isodata threshold = " + (int) tAfter);
        
        for (int i = 0; i < 10; i++) {
            tuSoTrai = 0;
            mauSoTrai = 0;
            tuSoPhai = 0;
            mauSoPhai = 0;
            for (int j = 0; j < L; j++) {
                if (j <= i) {
                    tuSoTrai += rp[j];
                    mauSoTrai += p[j];
                } else {
                    tuSoPhai += rp[j];
                    mauSoPhai += p[j];
                }
            }

            if (tuSoTrai == 0 && mauSoTrai == 0) {
                tAfter = 0.5 * (tuSoPhai / mauSoPhai);
            } else if (tuSoPhai == 0 && mauSoPhai == 0) {
                tAfter = 0.5 * (tuSoTrai / mauSoTrai);
            } else {
                tAfter = 0.5 * (tuSoTrai / mauSoTrai + tuSoPhai / mauSoPhai);
            }
            System.out.println("KQ: "+tAfter);
        }
    }
}
