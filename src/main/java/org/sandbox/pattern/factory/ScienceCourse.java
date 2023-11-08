package org.sandbox.pattern.factory;

public class ScienceCourse implements Course {
    @Override
    public void enroll(String student) {
        System.out.println("Enrolled" + student + "in science course");
    }
}
