/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package ptit.cuongacquy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author CuongAcQuy
 */
@WebService(serviceName = "NumberS")
public class NumberS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    private HashMap<Integer, String> ds =new HashMap<>();
    @WebMethod(operationName = "getNumber")
    public String getNumber(@WebParam(name = "msv") String msv) {
        System.out.println("Nhận được câu hỏi của sv: "+msv);
        int id =(int) (Math.random() * 10000);
        String ques = "";
        for (int i = 0; i < 10; i++) {
            if(i<10-1)
            ques += String.valueOf(1000 + (int) (Math.random() * 100000))+',';
            else ques += String.valueOf(1000 + (int) (Math.random() * 100000));
        }
        this.ds.put(id, ques);
        System.out.println("Đã gửi câu hỏi: " +String.valueOf(id)+";"+ques);
        return String.valueOf(id)+";"+ques;
    }

    @WebMethod(operationName = "greatestNumber")
    public boolean greatestNumber(@WebParam(name = "id") int id,@WebParam(name = "number") String number) {
        String[] cacso = ds.get(id).split(",");
        ArrayList<String> check = new ArrayList<>();
        for (String string : cacso) {
            check.add(string);
        }
        Collections.sort(check, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                String x = o1+o2;
                String y = o2+o1;
                return -x.compareTo(y);
            }
        });
        String correct = "";
        for (String string : check) {
            correct+=string;
        }
        System.out.println("Nhận được: "+number);
        System.out.println("Đáp án đúng: "+correct);
        System.out.print("Kết quả: ");
        if(correct.equals(number)) System.out.println("Đúng!");
        else System.out.println("Sai!");
        return correct.equals(number);
    }
}
