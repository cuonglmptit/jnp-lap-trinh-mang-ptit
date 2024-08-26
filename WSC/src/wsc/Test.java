/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wsc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author CuongAcQuy
 */
public class Test {

    public static void main(String[] args) {
        String ques = "5000;7602,9136,1090,343190,34319,7830,6179,10584,20166,28199,30250,32179,22544,3222,10320,30590,19279";
        StringTokenizer st = new StringTokenizer(ques, ";,");
        String id = st.nextToken();
        System.out.println("id: " + id);
        ArrayList<String> arrayList = new ArrayList<>();
        while (st.hasMoreTokens()) {
            arrayList.add(st.nextToken());
        }

        Collections.sort(arrayList, Collections.reverseOrder());

        System.out.println("sort t: " + arrayList);
        Collections.sort(arrayList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String n1 = o1 + o2;
                String n2 = o2 + o1;
                return -n1.compareTo(n2);
            }
        });
        
        System.out.println("sort c: " + arrayList);
        String ans = "";
        for (String string : arrayList) {
            ans+=string;
        }
        System.out.println("ans: " +ans);
    }
}
