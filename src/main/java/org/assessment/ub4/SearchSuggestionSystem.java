package org.assessment.ub4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// https://thechanmoon.medium.com/leetcode-1268-search-suggestions-system-java-javascript-53a30cf69564
public class SearchSuggestionSystem {

    public static void main(String[] args) {
        SearchSuggestionSystem system = new SearchSuggestionSystem();

        List<String> products = Arrays.asList("mobile", "mouse", "moneypot", "monitor", "mousepad");
        String search = "mouse";

        // [
        // [mobile, moneypot, monitor],
        // [mobile, moneypot, monitor],
        // [mouse, mousepad],
        // [mouse, mousepad],
        // [mouse, mousepad]
        // ]


        System.out.println(system.getSuggestedProducts(products, search));

        products = Arrays.asList("mobile", "mouse", "moneypot", "monitor", "mousepad");
        search = "tate";

        // [[], [], [], []]

        System.out.println(system.getSuggestedProducts(products, search));
    }

    public List<List<String>> getSuggestedProducts(List<String> products, String searchWord) {
        List<List<String>> results = new ArrayList<>();
        final int MAX_NO = 3;

        Collections.sort(products);

        for (int i=0; i<searchWord.length(); i++) {
            List<String> tempList = new ArrayList<>();
            String searchChar = searchWord.substring(0, i+1);

            for (String product: products) {

                if (tempList.size() < MAX_NO &&
                    i < product.length() &&
                    product.substring(0, i+1).equals(searchChar)) {
                    tempList.add(product);
                }
            }

            // if (tempList.size() > 0) {
                results.add(tempList);
            // }
        }

        return results;
    }
}
