package com.music.app.util;

interface interface1{
    void display();

   /* default void print() {
        System.out.println("print1");
    }*/
}

interface interface2{
    void display();
    /*default void print() {
        System.out.println("print2");
    }*/
}

public class SameInterfaceMethod implements  interface1, interface2{
    @Override
    public void display() {
        System.out.println("display");
    }

    public static void main(String[] args) {
        interface1 i = new SameInterfaceMethod();
        i.display();

        interface2 ii = new SameInterfaceMethod();
        ii.display();
    }
}

