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
public class GradientCustom {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int[][] filter = {{0, -1, 0}, {-1, 4, -1}, {0, -1, 0}};
        oneDimension(a, n, filter);

//        int[][] Hx = {{-1, 0, 1}, {-1, 0, 1}, {-1, 0, 1}};
//        int[][] Hy = {{-1, -1, -1}, {0, 0, 0}, {1, 1, 1}};
        int[][] Hx = {{1, 0, -1}, {2, 0, -2}, {1, 0, -1}};
        int[][] Hy = {{1, 2, 1}, {0, 0, 0}, {-1, -2, -1}};
        twoDimension(a, n, Hx, Hy);
    }

    public static void oneDimension(int[][] image, int size, int[][] filter) {
        System.out.println("1 Chiều:");
        int[][] G = new int[size][size];
        //Gradient
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int sum = 0;
                for (int k = -filter.length / 2; k <= filter.length / 2; k++) {
                    for (int l = -filter.length / 2; l <= filter.length / 2; l++) {
                        if (i + k >= 0 && i + k < size && j + l >= 0 && j + l < size) {
                            sum += image[i + k][j + l] * filter[k + 1][l + 1];
                        }
                    }
                }
                G[i][j] = sum;
                System.out.print(String.format("%5d", G[i][j]));
            }
            System.out.println("");
        }
    }

    public static void twoDimension(int[][] image, int size, int[][] Hx, int[][] Hy) {
        System.out.println("Tính với 2 chiều:");
        int[][] Dx = new int[size][size];
        int[][] Dy = new int[size][size];
        //Tinh I*Hx
        System.out.println("I*Hx:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int sum = 0;
                for (int k = -Hx.length / 2; k <= Hx.length / 2; k++) {
                    for (int l = -Hx.length / 2; l <= Hx.length / 2; l++) {
                        if (i + k >= 0 && i + k < size && j + l >= 0 && j + l < size) {
                            sum += image[i + k][j + l] * Hx[k + 1][l + 1];
                        }
                    }
                }
                Dx[i][j] = sum;
                System.out.print(String.format("%5d", Dx[i][j]) + " ");
            }
            System.out.println("");
        }
        //Tinh I*Hy
        System.out.println("I*Hy:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int sum = 0;
                for (int k = -Hx.length / 2; k <= Hx.length / 2; k++) {
                    for (int l = -Hx.length / 2; l <= Hx.length / 2; l++) {
                        if (i + k >= 0 && i + k < size && j + l >= 0 && j + l < size) {
                            sum += image[i + k][j + l] * Hy[k + 1][l + 1];
                        }
                    }
                }
                Dy[i][j] = sum;
                System.out.print(String.format("%5d", Dy[i][j]) + " ");
            }
            System.out.println("");
        }
        //Tinh I*Hx + I*Hy
        System.out.println("I*Hx + I*Hy:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(String.format("%5d", Dx[i][j] + Dy[i][j]) + " ");
            }
            System.out.println("");
        }
    }
}
