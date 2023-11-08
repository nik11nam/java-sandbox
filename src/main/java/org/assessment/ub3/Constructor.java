package org.assessment.ub3;

public class Constructor {
    static String str;

    // Not a constructor
    public void Constructor() {
        System.out.print("Hello");
        str = "Hello World";
    }

    public static void main(String[] args) {
        Constructor c = new Constructor();
        System.out.println(str);
    }
}
