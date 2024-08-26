package Xulyanh;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DarkShadowDemon200x
 */
public class MedianFilter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0 && j - 1 >= 0 && i + 1 < a.length && j + 1 < a.length) {
                    ArrayList<Integer> median = new ArrayList<>();
                    for (int row = -1; row <= 1; row++) {
                        for (int col = -1; col <= 1; col++) {
                            median.add(a[row + i][col + j]);
                        }
                    }
                    Collections.sort(median);
                    System.out.print(median.get(median.size()/2) + " ");
                }
            }
            System.out.println("");
        }
    }
}
