package com.test;

public interface sampleInterface{

    static void running(){
        System.out.println("Hello static interface method");
    }

    default void doSomthing(){
        System.out.println("Hello default interface method");
    }

    void nothing();

}
