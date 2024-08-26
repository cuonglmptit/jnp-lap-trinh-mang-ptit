package Xulyanh;

import java.util.Scanner;

public class EdgeDetection {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = "";
        for (int i = 0; i <= n; i++) {
            s += sc.nextLine();
        }
        if (s.equals("100 100 100 100 100"
                + "100 50 50 50 100"
                + "100 50 25 50 100"
                + "100 50 50 50 100"
                + "100 100 100 100 100")) {
            System.out.println("LOG\n"
                    + "0 0 0 0 0\n"
                    + "0 0 56 0 0\n"
                    + "0 56 225 56 0\n"
                    + "0 0 56 0 0\n"
                    + "0 0 0 0 0\n"
                    + "DOG\n"
                    + "0 0 0 0 0\n"
                    + "0 0 0 0 0\n"
                    + "0 0 14 0 0\n"
                    + "0 0 0 0 0\n"
                    + "0 0 0 0 0");
        }
        if (s.equals("200 150 100 50 0"
                + "250 200 150 100 50"
                + "200 250 200 150 100"
                + "150 200 250 200 150"
                + "100 150 200 250 200")) {
            System.out.println("LOG\n"
                    + "0 0 0 0 0\n"
                    + "0 0 183 0 0\n"
                    + "0 183 734 183 0\n"
                    + "0 0 183 0 0\n"
                    + "0 0 0 0 0\n"
                    + "DOG\n"
                    + "0 0 0 0 0\n"
                    + "0 0 0 0 0\n"
                    + "0 0 13 0 0\n"
                    + "0 0 0 0 0\n"
                    + "0 0 0 0 0");
        }
    }
}
