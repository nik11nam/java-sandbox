package org.sandbox.pattern.factory;

public class MathsCourse implements Course {
    @Override
    public void enroll(String student) {
        System.out.println("Enrolled" + student + "in maths course");
    }
}
