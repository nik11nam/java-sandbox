package org.sandbox.oops.dp.builder;

/**
 * https://dzone.com/articles/the-builder-pattern-for-class-with-many-constructo
 */
public class Employee {

    private final String firstName; // mandatory
    private final String lastName; // mandatory
    private final int age; // mandatory
    private final String address; // optional
    private final String emailId; // optional
    private final Long mobileNo; // optional

    /**
     * Private constructor to prevent the object initialization
     */
    private Employee(EmployeeBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.address = builder.address;
        this.emailId = builder.emailId;
        this.mobileNo = builder.mobileNo;
    }

    public static class EmployeeBuilder {
        private final String firstName; // mandatory
        private final String lastName; // mandatory
        private final int age; // mandatory
        private String address; // optional
        private String emailId; // optional
        private Long mobileNo; // optional

        public EmployeeBuilder(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public EmployeeBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public EmployeeBuilder setEmailId(String emailId) {
            this.emailId = emailId;
            return this;
        }

        public EmployeeBuilder setMobileNo(Long mobileNo) {
            this.mobileNo = mobileNo;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getEmailId() {
        return emailId;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", emailId='" + emailId + '\'' +
                ", mobileNo=" + mobileNo +
                '}';
    }

    public static void main(String[] args) {
        Employee employee = new Employee.EmployeeBuilder("Nikhil", "Koshi", 38)
                .setAddress("7 Bright Hill Drive")
                .build();
        System.out.println(employee);
    }
}
