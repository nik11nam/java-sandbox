package org.assessment.ub2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PriceCheck {

    public static void main(String[] args) {
        int mismatchCount = priceCheck(Arrays.asList("eggs","milk", "cheese"),
                Arrays.asList(2.89f, 3.29f, 5.79f),
                Arrays.asList("eggs", "eggs", "cheese", "milk"),
                Arrays.asList(2.89f, 2.99f, 5.97f, 3.29f));

        System.out.println(mismatchCount);
    }

    public static int priceCheck(List<String> products, List<Float> productPrices,
                                 List<String> productSold, List<Float> soldPrice) {
        Map<String, Float> productPriceMap = getProductPriceMap(products, productPrices);

        int mismatchCount = 0;
        for (int i=0; i < productSold.size(); i++) {
            final String soldProduct = productSold.get(i);
            Float actualPrice = soldPrice.get(i);
            Float expectedPrice = productPriceMap.get(soldProduct);

            if (!actualPrice.equals(expectedPrice)) {
                mismatchCount++;
            }
        }
        return mismatchCount;
    }

    private static Map<String, Float> getProductPriceMap(List<String> products, List<Float> productPrices) {
        Map<String, Float> productPriceMap = IntStream.range(0, products.size())
                .boxed()
                .collect(Collectors.toMap(products::get, productPrices::get, (a, b) -> b));
        return productPriceMap;
    }



}
