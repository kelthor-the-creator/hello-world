package com.company;


import static com.company.Threadcolor.ANSI_GREEN;
import static com.company.Threadcolor.ANSI_RED;
import static com.company.Threadcolor.ANSI_YELLOW;
import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte0.runnable;
import java.util.concurrent.*;

public class Main {


    public static void main(String[] args) {
        final Thread t = new Thread();



        t.start();


        new Thread(){
            public void run() {
                System.out.println(ANSI_YELLOW+"Thread Running");
            }

    }.start();
        Thread myThreadrun = new Thread (new mythread()){
            @Override
            public void run() {
                System.out.println(ANSI_RED+ "ananymous method");
            }
        };
        myThreadrun.start();


        System.out.println(ANSI_GREEN+"hello from main");






    }



}