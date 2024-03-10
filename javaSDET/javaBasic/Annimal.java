package javaBasic;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public abstract class Annimal {
    // The hien tinh chat truu tuong trong OOP (Abstraction)

    // Constructor: khai tao
    public Annimal(String annimalName) {
        System.out.println("Annimal running...");
    }


    public void eat() {
        // Co phan than (body)
        System.out.println("Eat");
    }
    public abstract void sleep(); // ko co body

}
