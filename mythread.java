package com.company;

import static com.company.Threadcolor.ANSI_RED;

public class mythread implements Runnable {
    @Override
    public void run() {
        System.out.println(ANSI_RED + "hello from my runnable");


    }
}
