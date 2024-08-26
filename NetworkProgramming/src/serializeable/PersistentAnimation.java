/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serializeable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author DarkShadowDemon200x
 */
public class PersistentAnimation implements Serializable, Runnable {

    transient private Thread animator;
    private int animationSpeed;

    public PersistentAnimation(int animationSpeed) {
        this.animationSpeed = animationSpeed;
        startAnimation();
    }

    @Override
    public void run() {
        System.out.println("PersistentAnimation thread is started");
    }
    // Provide your own writeObject method

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }
    // Provide your own readObject method

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        // our "pseudo-constructor"
        in.defaultReadObject();
        // now we are a "live" object again, so let's run rebuild and start
        startAnimation();
    }

    private void startAnimation() {
        animator = new Thread(this);
        animator.start();
    }
}
