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
public class HistogramSmoothing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Đọc lược đồ xám
        int n = scanner.nextInt();
        int size = scanner.nextInt();
        int a[][] = new int[n][n];
        int[] histogram = new int[size];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scanner.nextInt();
                histogram[a[i][j]]++;
            }
        }
//        for (int i = 0; i < size; i++) {
//            histogram[i] = scanner.nextInt();
//        }

        // Làm trơn lược đồ xám với cửa sổ kích thước w=3 và w=5
        int[] smoothedHistogram3 = smoothHistogram(histogram, 3);
        int[] smoothedHistogram5 = smoothHistogram(histogram, 5);

        // In lược đồ xám đã làm trơn
        System.out.println("Smoothed Histogram w=3");
        printHistogram(smoothedHistogram3);

        System.out.println("Smoothed Histogram w=5");
        printHistogram(smoothedHistogram5);

        scanner.close();
    }

    // Phương thức để làm trơn lược đồ xám với cửa sổ kích thước w
    public static int[] smoothHistogram(int[] histogram, int w) {
        int[] smoothedHistogram = new int[histogram.length];

        for (int i = 0; i < histogram.length; i++) {
            int sum = 0;
            int count = 0;

            for (int j = i - w / 2; j <= i + w / 2; j++) {
                if (j >= 0 && j < histogram.length) {
                    sum += histogram[j];
                    count++;
                }
            }

            smoothedHistogram[i] = sum / count;
        }

        return smoothedHistogram;
    }

    // Phương thức để in lược đồ xám
    public static void printHistogram(int[] histogram) {
        for (int value : histogram) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

}
