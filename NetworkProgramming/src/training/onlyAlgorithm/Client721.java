/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package training.onlyAlgorithm;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author CuongAcQuy
 */
public class Client721 {
    public static void main(String[] args) {
        String ques = "dgU0o ch2k22lds0o";
        
        LinkedHashMap<Character, Integer> ds = new LinkedHashMap();
        
        for (int i = 0; i < ques.length(); i++) {
            char tmp = ques.charAt(i);
            if(ds.containsKey(tmp)){
                ds.put(tmp, ds.get(tmp)+1);
            }else{
                ds.put(tmp, 1);
            }
        }
        
        String ans = "";
        for (Map.Entry<Character, Integer> entry : ds.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            if(val>1) ans+=key+":"+val+",";
        }
        System.out.println(ans);
    }
}
