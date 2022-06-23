package com.zinkworks;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {
    public static void main(String[] args) {
        // Map<key, value>
        Map<String, String> languages = new HashMap<>();
        languages.put("Java", "Compiled OOP, platform independent language");
        languages.put("Python", "Interpreted OOP, high-level language");
        languages.put("BASIC", "Beginners All Purposes Symbolic Instruction Code");

        System.out.println(languages.get("Python"));

        // Keys are unique, value will be overwritten if used again
        // Sout a put will either return null or previous put value
        System.out.println(languages.put("Java", "This course is about Java"));
        System.out.println(languages.get("Java"));

        // Can use contains to see if created already
        if (languages.containsKey("Java")) {
            System.out.println("Java is already in map");
        } else {
            languages.put("Java", "This course is about Java");
        }
        System.out.println("#################################");

        // Loop through keys to display contents of map
        for (String key: languages.keySet()) {
            System.out.println(key + ": " + languages.get(key));
        }
    }
}
