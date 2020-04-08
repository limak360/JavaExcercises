package pl.kamiljacko.threads;

import static pl.kamiljacko.threads.Deadlock.lock1;
import static pl.kamiljacko.threads.Deadlock.lock2;

public class Deadlock {
    public static String lock1 = "Try";
    public static String lock2 = "Go";

    public static void main(String[] args) {

        new Thread1().start();
        new Thread2().start();
    }
}

class Thread1
        extends Thread {

    @Override
    public void run() {
        synchronized (lock1) {
            try {
                System.out.println("Thread1 has lock1");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println("Thread1 is waiting for lock2");
            synchronized (lock2) {
                System.out.println("Thread1 has lock1 and lock2");
            }
            System.out.println("Thread1 released lock2");
        }
        System.out.println("Thread1 released lock1");
    }
}

class Thread2
        extends Thread {

    @Override
    public void run() {
        synchronized (lock2) {  //solution  lock on lock1 then on lock2
            try {
                System.out.println("Thread2 has lock2");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println("Thread2 is waiting for lock1");
            synchronized (lock1) {
                System.out.println("Thread2 has lock2 and lock1");
            }
            System.out.println("Thread2 released lock1");
        }
        System.out.println("Thread2 released lock2");
    }
}