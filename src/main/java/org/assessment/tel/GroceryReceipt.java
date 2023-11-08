package org.assessment.tel;

import java.util.*;

// Grocery receipt
public class GroceryReceipt {

    Map<String, Double> prices;
    Map<String, Integer> discounts;

    public GroceryReceipt(Map<String, Double> prices, Map<String, Integer> discounts) {
        this.prices = prices;
        this.discounts = discounts;
    }

    public List<Grocery> calculate(List<Node> boughtItems) {
        // Find total count per item
        Map<String, Integer> itemCount = new HashMap<>();
        for (Node item: boughtItems) {
            if (itemCount.containsKey(item.getFruit())) {
                int newQuantity = itemCount.get(item.getFruit()) + item.getCount();
                itemCount.put(item.getFruit(), newQuantity);
            } else {
                itemCount.put(item.getFruit(), item.getCount());
            }
        }

        // Apply Discount
        List<Grocery> groceries = new ArrayList<>();
        for (String fruit: itemCount.keySet()) {
            int quantity = itemCount.get(fruit);
            Double price = prices.get(fruit);
            Integer discount = discounts.get(fruit);

            double total = quantity * price;
            if (discount != null) {
                total = total * ((100 - discount) * 0.01);
            }

            Grocery grocery = new Grocery(fruit, price, total);
            groceries.add(grocery);
        }

        Collections.sort(groceries, Comparator.comparing(Grocery::getFruit));

        return groceries;
    }

    public static void main(String[] args) {
        Map<String, Double> prices = new HashMap<>();
        prices.put("Banana", 10.0);
        prices.put("Apple", 15.0);
        prices.put("Mango", 20.0);

        Map<String, Integer> discounts = new HashMap<>();
        discounts.put("Apple", 20);

        List<Node> boughtItems = new ArrayList<>();
        boughtItems.add(new Node("Apple", 5));
        boughtItems.add(new Node("Banana", 6));
        boughtItems.add(new Node("Banana", 3));

        GroceryReceipt receipt = new GroceryReceipt(prices, discounts);
        List<Grocery> items = receipt.calculate(boughtItems);

        items.forEach(item -> System.out.println(item));
    }
}
