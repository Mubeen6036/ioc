package com.example.ioc.utils;

import java.time.LocalDate;

public class Helper {
    public static void method1() throws Exception{
        System.out.println("method 1 started");
        System.out.println(Thread.currentThread().getName());
        Thread.currentThread().sleep(600);
        System.out.println("method 1 Ended");
    }
    public static void method2() throws Exception{
        System.out.println("method 2 started");
        System.out.println(Thread.currentThread().getName());
        Thread.currentThread().sleep(100);
        System.out.println("method 2 Ended");
        System.out.println("method 2 Ended");
    }

    public static void main(String[] args){
        try{

            LocalDate lc = LocalDate.now();
            System.out.println(lc.toString());


            Helper2 helper2 = new Helper2();
            Runnable r1 = ()->{try{helper2.method1();}catch(Exception e){}};
            Thread t1 = new Thread(r1);
            Runnable r2 = ()->{try{helper2.method2();}catch(Exception e){}};
            Thread t2 = new Thread(r2);
            t1.start();
            t2.start();

            Runnable r3 = ()->{try{helper2.method1();}catch(Exception e){}};
            Thread t3 = new Thread(r3);
            Runnable r4 = ()->{try{helper2.method2();}catch(Exception e){}};
            Thread t4 = new Thread(r4);
            t3.start();
            t4.start();

            Runnable r5 = ()->{try{helper2.method1();}catch(Exception e){}};
            Thread t5 = new Thread(r5);
            Runnable r6 = ()->{try{helper2.method2();}catch(Exception e){}};
            Thread t6 = new Thread(r6);
            t5.start();
            t6.start();

            Runnable r7 = ()->{try{helper2.method1();}catch(Exception e){}};
            Thread t7 = new Thread(r7);
            Runnable r8 = ()->{try{helper2.method2();}catch(Exception e){}};
            Thread t8 = new Thread(r8);
            t7.start();
            t8.start();

//            Thread.currentThread().sleep(1000);
//            t1.notify();
//            synchronized(t1){
//                t1.notifyAll();
//            }
//            Thread.currentThread().sleep(1000);
        }catch(Exception e) {

        }
    }

}

