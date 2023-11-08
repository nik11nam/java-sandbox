package org.assessment.tel;

public class Node {
    private String fruit;
    private int count;

    public Node(String item, int quantity) {
        this.fruit = item;
        this.count = quantity;
    }

    public String getFruit() {
        return fruit;
    }

    public int getCount() {
        return count;
    }
}
