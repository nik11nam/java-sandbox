package org.sandbox.pattern.builder;

public class Course {

    private String name;
    private String instructor;
    // Optional
    private long duration;
    private String assignment;

    private Course() { }

    private Course(Builder builder) {
        this.name = builder.name;
        this.instructor = builder.instructor;
        this.duration = builder.duration;
    }

    public static class Builder {
        private String name;
        private String instructor;
        // Optional
        private long duration;
        private String assignment;

        public Builder(String name, String instructor) {
            this.name = name;
            this.instructor = instructor;
        }

        public Builder setDuration(long duration) {
            this.duration = duration;
            return this;
        }

        public Builder setAssignment(String assignment) {
            this.assignment = assignment;
            return this;
        }

        public Course build() {
            return new Course(this);
        }
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", instructor='" + instructor + '\'' +
                ", duration=" + duration +
                ", assignment='" + assignment + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Course course =  new Course.Builder("maths", "Sir")
                .setDuration(10)
                .build();
        System.out.println(course);
    }
}
