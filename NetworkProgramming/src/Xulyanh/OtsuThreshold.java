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
public class OtsuThreshold {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
        int L = 10;
//        int[][] a = new int[n][m];
//        int[] count = new int[L];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                a[i][j] = sc.nextInt();
//                count[(int) a[i][j]]++;
//            }
//        }

        int[] count = {20, 40, 30, 50, 70, 60, 120, 250, 100, 20};
        double[] p = new double[L];
        double[] Pik = new double[L];
        double[] mk = new double[L];
        double[] o = new double[L];

//        for (int i = 0; i < L; i++) {
//            System.out.println(count[i] + " ");
//        }
        double size = 760;
//        double size = n*m;
        
        for (int i = 0; i < L; i++) {
            p[i] = (double) count[i] / (size);
            //Calculate Pi(k)
            if (i == 0) {
                Pik[i] = p[i];
            } else {
                Pik[i] = p[i] + Pik[i - 1];
            }
            //Calculate m(k)
            if (i == 0) {
                mk[i] = 0.0 * p[i];
            } else {
                mk[i] = i * p[i] + mk[i - 1];
            }

        }
        double mG = 0;

        for (int i = 0; i < L; i++) {
            mG += i * p[i];
        }

        double maxO = Double.MIN_VALUE;
        for (int i = 0; i < L; i++) {
            o[i] = Math.pow((mG * Pik[i] - mk[i]), 2) / (Pik[i] * (1 - Pik[i]));
            if(maxO < o[i]) maxO = o[i];
        }
        
        double sum = 0;
        int cnt = 0;
        for (int i = 0; i < L; i++) {
            o[i] = Math.pow((mG * Pik[i] - mk[i]), 2) / (Pik[i] * (1 - Pik[i]));
            if(maxO == o[i]){
                sum += i;
                cnt++;
            }
        }
        
        double meanO = sum/cnt;
        System.out.println("  i      pi        Pi(k)      m(k)       m(G)      os^2(k)");
        for (int i = 0; i < L; i++) {
            System.out.println(String.format("%3d", i) + "      " + (count[i]+"/"+size) + "    " + String.format("%.4f", Pik[i]) + "     " + String.format("%.4f", mk[i]) + "     " + String.format("%.4f", mG) + "    " + String.format("%.4f", o[i]));
        }
        System.out.println("Otsu threshold = "+meanO);
    }
}
