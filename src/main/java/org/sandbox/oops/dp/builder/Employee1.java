package org.sandbox.oops.dp.builder;

/**
 * Telescoping constructor pattern
 */
public class Employee1 {

    private final String firstName; // mandatory
    private final String lastName; // mandatory
    private final int age; // mandatory
    private final String address; // optional
    private final String emailId; // optional
    private final Long mobileNo; // optional

    public Employee1(String firstName, String lastName, int age) {
        this(firstName, lastName, age, null, null, null);
    }

    public Employee1(String firstName, String lastName, int age, String address) {
        this(firstName, lastName, age, address, null, null);
    }

    public Employee1(String firstName, String lastName, int age, String address, String emailId, Long mobileNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.emailId = emailId;
        this.mobileNo = mobileNo;
    }
}
