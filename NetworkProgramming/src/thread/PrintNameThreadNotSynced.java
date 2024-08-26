/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

/**
 *
 * @author DarkShadowDemon200x
 */
public class PrintNameThreadNotSynced extends Thread{
    private String name;
    public PrintNameThreadNotSynced(String name) {
        super(name);
        start();
    }
    @Override
    public void run(){
        String name = getName();
        for (int i = 0; i < 50; i++) {
            System.out.print(name);
        }
    }
    public static void main(String[] args) {
        PrintNameThreadNotSynced t1 = new PrintNameThreadNotSynced("A");
        PrintNameThreadNotSynced t2 = new PrintNameThreadNotSynced("B");
        PrintNameThreadNotSynced t3 = new PrintNameThreadNotSynced("C");
        PrintNameThreadNotSynced t4 = new PrintNameThreadNotSynced("D");
    }
}
