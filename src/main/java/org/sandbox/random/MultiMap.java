package org.sandbox.random;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MultiMap  {

    public static void main(String[] args) {
        // 1. computeIfAbsent function
        Map<String, List<String>> map = new HashMap<>();

        Function<String, List<String>> ifAbsentFunction = (str) -> new ArrayList<>();

        map.computeIfAbsent("A", ifAbsentFunction).add("Apple");
        map.get("A").add("Apricot");

        map.computeIfAbsent("B", ifAbsentFunction).add("Banana");
        map.computeIfAbsent("C", ifAbsentFunction).add("Carrot");

        assert map.keySet().size() == 3;
        assert map.values().size() == 4;

        // 2. groupingBy collector
        List<BlogPost> blogPosts = Arrays.asList(new BlogPost("A", "abc", BlogPostType.NEWS, 10),
                new BlogPost("B", "cde", BlogPostType.REVIEW, 15));

        // Group blogs by type
        Map<BlogPostType, List<BlogPost>> blogsByType = blogPosts.stream()
                .collect(Collectors.groupingBy(BlogPost::getType));

        assert blogsByType.keySet().size() == 2;

        // Group by author, then by type
        Map<String, Map<BlogPostType, List<BlogPost>>> blogsByAuthorAndType = blogPosts.stream()
                .collect(Collectors.groupingBy(BlogPost::getAuthor, Collectors.groupingBy(BlogPost::getType)));
    }

    enum BlogPostType {
        NEWS, REVIEW, GUIDE
    }

    static class BlogPost {
        String title;
        String author;
        BlogPostType type;
        int likes;

        public BlogPost(String title, String author, BlogPostType type, int likes) {
            this.title = title;
            this.author = author;
            this.type = type;
            this.likes = likes;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public BlogPostType getType() {
            return type;
        }

        public int getLikes() {
            return likes;
        }
    }


}
