package com.gn.test1;

public class Test {

    private volatile static boolean flag = true;

    private volatile static int i = 0;

    public static void main(String[] args) {
        Object lock = new Object();
        new Thread(() -> {
            synchronized (lock) {
                while (i < 100) {
                    if (!flag) {
                        i++;
                        System.out.println("a" + "   " + i);
                        flag = true;
                    }
                    try {
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();


        new Thread(() -> {
            synchronized (lock) {
                while (i < 100) {
                    if (flag) {
                        i++;
                        System.out.println("b" + "   " + i);
                        flag = false;
                    }
                    try {
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }
}
