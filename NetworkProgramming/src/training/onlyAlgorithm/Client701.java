/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package training.onlyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 *
 * @author CuongAcQuy
 */
public class Client701 {
    public static void main(String[] args) {
        String ques = "1,3,9,19,33,20";
        
        StringTokenizer st = new StringTokenizer(ques, ",");
        ArrayList<Integer> ds = new ArrayList<>();
        while (st.hasMoreTokens()) {            
            ds.add(Integer.parseInt(st.nextToken()));
        }
        System.out.println(ds);
        Collections.sort(ds);
        System.out.println(ds);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < ds.size(); i++) {
            for (int j = i+1; j < ds.size()-1; j++) {
                int a = ds.get(i); int b = ds.get(j);
                if(Math.abs(a-b)<min) min = Math.abs(a-b);
            }
        }
        int index1 = 0, index2 = 0;
        for (int i = 0; i < ds.size(); i++) {
            for (int j = i+1; j < ds.size()-1; j++) {
                int a = ds.get(i); int b = ds.get(j);
                if(Math.abs(a-b) == min){
                    index1 = ds.get(i);
                    index2 = ds.get(j);
                }
            }
        }
        String ans = min+","+index1+","+index2;
        System.out.println(ans);
    }
}
