package org.assessment;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Blacklist {

    public static List<Integer> blacklist(List<String> blacklisted_ips, List<String> requests) {
        List<Integer> results = new ArrayList<>();
        Map<String, Integer> unblocked = new HashMap<>();
        for (String blacklistIp: blacklisted_ips) {
            Pattern pattern = Pattern.compile(blacklistIp);
            for (String ip: requests) {
                String[] splitStr = ip.split("\\.");
                if (splitStr.length != 4) {
                    continue;
                }

                Matcher matcher = pattern.matcher(ip);
                if (matcher.matches()) {
                    results.add(1);
                } else {
                    if (unblocked.containsKey(ip)) {
                        int count = unblocked.get(ip);
                        if (count == 2) {
                            results.add(1);
                            unblocked.put(ip, 0);
                        } else {
                            count++;
                            unblocked.put(ip, count);
                            results.add(0);
                        }
                    } else {
                        unblocked.put(ip, 1);
                        results.add(0);
                    }
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        List<String> blacklisted_ips = Arrays.asList("*.123.*", "34.*");

    }
}
