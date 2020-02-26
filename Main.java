package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

// https://www.youtube.com/watch?v=1Kxc6zlNJ6E
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

        // the answer is  Number of unique words are: 35108

        //*********************************** Solution 2  ***********************

      /* Path path = Paths.get(System.getProperty("user.dir"))
                .resolve("C:/Users/archa/OneDrive/Skrivebord/whale2 book.txt");

       BufferedReader reader = new BufferedReader(new FileReader(path.toFile()));

         int totalLines=0;
         int totalWords=0;

        Set<String> wordsFromTxt= new HashSet<>();
        String Line = reader.readLine();

        while(Line !=null)
        {
            System.out.println("Checking line:"+ Line);
            if(!Line.trim().equals(" "))
            {
                String [] words =Line.split("");
                totalWords += words.length;
                for (String word: words)
                {
                     String cleanedUpWord = word.toLowerCase()
                     .replace(",","")
                     .replace(":","")
                     .replace("\"","")
                     .replace("?","")
                      .replace("--","");
                    wordsFromTxt.add(cleanedUpWord);

                 }
            }
            totalLines ++;
              Line = reader.readLine();
        }
        System.out.println("wordsFromTxt");
        System.out.println();
        System.out.println(" Number of unique words are :"+wordsFromTxt.size()+" List of the words:  " wordsFromTxt);
        System.out.println();   */

// Answer is ****  Number of unique words are :53[,  , !, $, &, ', (, ), *, -, ., /, 0, 1, 2, 3, 4,
// 5, 6, 7, 8, 9, ;, =, [, ], _, a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z]

        System.out.println("**************************************");
        System.out.println("List of the most frequently occurring words from the book: ");
        System.out.println();

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


