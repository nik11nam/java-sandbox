package org.assessment.tel;

public class Grocery {
    private String fruit;
    private Double price;
    private Double total;

    public Grocery(String fruit, Double price, Double total) {
        this.fruit = fruit;
        this.price = price;
        this.total = total;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Grocery{" +
                "fruit='" + fruit + '\'' +
                ", price=" + price +
                ", total=" + total +
                '}';
    }
}
