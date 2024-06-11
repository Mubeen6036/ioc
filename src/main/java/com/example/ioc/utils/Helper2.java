package com.example.ioc.utils;

public class Helper2 {
    private volatile int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public synchronized void method1() throws Exception{
//        System.out.println("method 1 started");
//        //Thread.currentThread().sleep(600);
//        System.out.println(Thread.currentThread().getName());
//        this.wait(100);
//        //Thread.currentThread().sleep(600);
//        System.out.println("method 1 Ended");

        for(int i=0; i<5; i++){
            System.out.println(Thread.currentThread().getName());
            count++;
            System.out.println(count);
        }

    }
    public synchronized void method2() throws Exception{
//        System.out.println("method 2 started");
//        System.out.println(Thread.currentThread().getName());
//        Thread.currentThread().sleep(100);
//        System.out.println("method 2 Ended");
        for(int i=0; i<5; i++){
            System.out.println(Thread.currentThread().getName());
            count++;
            System.out.println(count);
            System.out.println(count);
        }
    }
}
