package com.company;

public class prime_nums {
    public static int n = 15;

    public static boolean siv(int n){
        for(int i = 2; i<n; i++)
            if(n%i==0){
                return false;

            }
return true;
    }


    public static void main(String[] args) {
    for(int i = 2; i<=n; i++)
        if(siv(i)){
            System.out.println(i);

        }    }
}
