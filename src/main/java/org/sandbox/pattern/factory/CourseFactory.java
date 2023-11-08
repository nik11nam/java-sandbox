package org.sandbox.pattern.factory;

public class CourseFactory {
    public static Course createCourse(String type) {
        if ("Maths".equals(type)) {
            return new MathsCourse();
        } else if ("Science".equals(type)) {
            return new ScienceCourse();
        }
        throw new IllegalArgumentException("Invalid course type:" + type);
    }
}
