package com.ozbilgic.java.samples.ThreadSample;

/**
 * @author Vision2
 * @version 0.0.0.1
 * @since 18.12.2014
 */
public class Odev1 extends Thread {
    private String name;
    private ThreadGroup group;

    public Odev1(ThreadGroup group, String name) {
        super(group, name);
        this.name = name;
        this.group = group;
    }

    @Override
    public void run() {
        super.run();
        System.out.println("Grup ismi: " +group.getName()+" "+"İş parçasının ismi: "+name);
    }
}
