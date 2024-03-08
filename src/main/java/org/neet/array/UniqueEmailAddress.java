package org.neet.array;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Input: emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * Output: 2
 * Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails.
 *
 * 1. Use HashSet to hold the unique valid addresses
 * 2. Split the email address by @ and apply rules for '.' and '+' operator
 *
 */
public class UniqueEmailAddress {

    public int getUniqueEmailCount(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            String formattedEmail = getFormattedEmail(email);
            uniqueEmails.add(formattedEmail);
        }
        return uniqueEmails.size();
    }

    private String getFormattedEmail(String email) {
        String[] emailArr = email.split("@");
        String localName = emailArr[0];
        String domainName = emailArr[1];

        // Remove chars after '+' in local name
        String[] localArr = localName.split("\\+");
        localName = localArr[0];

        // Remove all '.' from local name
        localName = localName.replace(".", "");

        return localName + "@" + domainName;
    }

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"};

        UniqueEmailAddress uea = new UniqueEmailAddress();
        System.out.println(uea.getUniqueEmailCount(emails));
    }

}
