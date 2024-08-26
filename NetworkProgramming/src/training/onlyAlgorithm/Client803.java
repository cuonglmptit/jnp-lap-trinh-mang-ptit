/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package training.onlyAlgorithm;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author CuongAcQuy
 */
public class Client803 {

    public static void main(String[] args) {
        String ques = "reqID;Qnc8d5x78aldSGWWmaAAjyg3";

        StringTokenizer st = new StringTokenizer(ques, ";");
        String id = st.nextToken();
        String str = st.nextToken();

        LinkedHashMap<Character, Integer> ds = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if (ds.containsKey(tmp)) {
                ds.put(tmp, ds.get(tmp) + 1);
            } else {
                ds.put(tmp, 1);
            }
        }

        String ans = id+";";
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Character, Integer> entry : ds.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            if (val > max) {
                max = val;
            }
        }
        
        for (Map.Entry<Character, Integer> entry : ds.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            if(max == val){
                ans+=key+":";
                for (int i = 0; i < str.length(); i++) {
                    char tmp = str.charAt(i);
                    if(key == tmp) ans+=(i+1)+",";
                }
                break;
            }
        }
        System.out.println(ans);
    }
}
