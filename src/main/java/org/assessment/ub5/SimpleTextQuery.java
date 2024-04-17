package org.assessment.ub5;

import java.util.*;

/**
 * Which sentences contain all of the words of the query
 */
public class SimpleTextQuery {

    public static List<List<Integer>> textQueries(List<String> sentences, List<String> queries) {
        // Split the sentences into terms and map them by index
        Map<Integer, Set<String>> sentenceMapByIndex = new HashMap<>();
        for (int i=0; i < sentences.size(); i++) {
            String[] sentenceArr = sentences.get(i).split(" ");
            Set<String> sentenceSet = new HashSet<>();
            for (int j=0; j < sentenceArr.length; j++) {
                sentenceSet.add(sentenceArr[j]);
            }
            sentenceMapByIndex.put(i, sentenceSet);
        }

        // Split the query into terms and map them by index
        Map<Integer, String[]> queriesMap = new HashMap<>();
        for (int i = 0; i < queries.size(); i++) {
            queriesMap.put(i, queries.get(i).split(" "));
        }

        List<List<Integer>> finalList = new ArrayList<>();
        for (int i=0; i < queries.size(); i++) {
            List<Integer> foundList = new ArrayList<>();

            for (int j=0; j < sentences.size(); j++) {
                String[] splitQuery = queriesMap.get(i);
                Set<String> sentenceSet = sentenceMapByIndex.get(j);

                boolean notFound = false;
                for (int k=0; k < splitQuery.length; k++) {
                    if (!sentenceSet.contains(splitQuery[k])) {
                        notFound = true;
                        break;
                    }
                }

                if (!notFound) {
                    foundList.add(j);
                }
            }

            if (foundList.size() > 0) {
                finalList.add(foundList);
            }
        }

        return finalList;
    }

    public static void main(String[] args) {
        List<String> sentences  = Arrays.asList("jim likes mary", "kate likes tom", "tom does not like jim");
        List<String> queries = Arrays.asList("jim tom", "likes");
        System.out.println(textQueries(sentences, queries));

        sentences  = Arrays.asList("chris and jennifer had a fight this morning",
                "chris went on a holiday",
                "jennifer is in prison");
        queries = Arrays.asList("chris jennifer", "jennifer", "prison");
        System.out.println(textQueries(sentences, queries));

    }

}
