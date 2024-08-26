/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package networkprograming;

/**
 *
 * @author DarkShadowDemon200x
 */
public class Ex2 {

    public static void main(String[] args) {
        SharedData s = new SharedData();
        new Producer(s);
        new Consumer(s);
    }
}

class Producer extends Thread {

    SharedData sharedData;

    public Producer(SharedData sharedData) {
        this.sharedData = sharedData;
        this.start();
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            sharedData.produce((int) (Math.random() * 100));
        }
    }
}

class Consumer extends Thread {

    SharedData sharedData;

    public Consumer(SharedData sharedData) {
        this.sharedData = sharedData;
        this.start();
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            sharedData.consume();
        }
    }
}

class SharedData {

    int data;
    boolean produced = false;

    public synchronized void produce(int value) {
        if (produced) {// đã cung cấp giá trị
            try {
                this.wait();
            } catch (InterruptedException ex) {
            }
        }
        data = value; // 
        System.out.println("produce: " + value);
        produced = true;
        notify();
    }

    public synchronized void consume() {
        if (!produced) {// chưa cung cấp giá trị mới
            try {
                this.wait();
            } catch (InterruptedException ex) {
            }
        }
        System.out.println("consume: " + data);
        produced = false;
        notify();
    }
}
