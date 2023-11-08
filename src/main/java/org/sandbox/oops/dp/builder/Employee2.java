package org.sandbox.oops.dp.builder;

/**
 * JavaBean pattern
 * Two big disadvantages:
 * 1. The object state will be inconsistent unless all the attributes are set explicitly;
 * 2. JavaBean pattern makes a class mutable and requires extra efforts of developers to ensure thread safety
 */
public class Employee2 {

    private String firstName; // mandatory
    private String lastName; // mandatory
    private int age; // mandatory
    private String address; // optional
    private String emailId; // optional
    private Long mobileNo; // optional

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }
}
