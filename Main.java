package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static final int OCCURRENCES=2000;


    public static void main(String[] args) throws Exception {
        Set<String> words = new HashSet<String>();
        Scanner in = new Scanner(new File("C:/Users/archa/OneDrive/Skrivebord/whale2 book.txt"));
        while (in.hasNext()) {
            String word = in.next();
            word = word.toLowerCase();

            String cleanedUpWord = word.toLowerCase()

                    .replace(",", "")
                    .replace(":", "")
                    .replace("\"", "")
                    .replace("?", "")
                    .replace("--", "");

            words.add(cleanedUpWord);
            words.add(word);
        }
        System.out.println();
        System.out.println("Number of unique words are: " + words.size());
        System.out.println();
        System.out.println("Unique words are: " + words);


        /** Reading the book in to a Map */

        Scanner in2 = new Scanner(new File("C:/Users/archa/OneDrive/Skrivebord/whale2 book.txt"));
        Map<String, Integer> wordCountMap = getCountMap(in2);

        for (String word : wordCountMap.keySet()) {
            int count = wordCountMap.get(word);
            if (count > OCCURRENCES) {
                System.out.println(word + " occurs " +
                        count + " times.");
            }
        }

    }


        public static Map<String, Integer> getCountMap(Scanner in2) {
            Map<String, Integer> wordCountMap = new TreeMap<String, Integer>();

             while (in2.hasNext()) {
                String word = in2.next().toLowerCase();
                 if (wordCountMap.containsKey(word)) {
                     // seen this word before; increment count
                    int count = wordCountMap.get(word);
                  wordCountMap.put(word, count + 1);
                     } else {
                     // never seen this word before
                     wordCountMap.put(word, 1);
                         }
                 }

            return wordCountMap;
      }

    }


