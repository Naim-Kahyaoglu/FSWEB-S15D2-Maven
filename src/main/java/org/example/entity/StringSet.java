package org.example.entity;

import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;

public class StringSet {

    // Default text when no argument is provided
    private static final String DEFAULT_TEXT =
            "Carroll began writing the manuscript of the story the next day, although that earliest version is lost. "
                    + "The girls and Carroll took another boat trip a month later, when he elaborated the plot to the story of Alice, "
                    + "and in November he began working on the manuscript in earnest. To add the finishing touches he researched "
                    + "natural history in connection with the animals presented in the book and then had the book examined "
                    + "by other children—particularly those of George MacDonald. Though Carroll did add his own illustrations "
                    + "to the original copy, on publication he was advised to find a professional illustrator so the pictures "
                    + "were more appealing to its audiences. He subsequently approached John Tenniel to reinterpret "
                    + "Carroll's visions through his own artistic eye, telling him that the story had been well liked by the"
                    + " children.\n"
                    + "\n"
                    + "Carroll began planning a print edition of the Alice story in 1863. "
                    + "He wrote on 9 May 1863 that MacDonald's family had suggested he publish Alice."
                    + " A diary entry for 2 July says that he received a specimen page of the print edition around that date. "
                    + "On 26 November 1864, Carroll gave Alice the manuscript of Alice's Adventures Under Ground, with illustrations "
                    + "by Carroll, dedicating it as 'A Christmas Gift to a Dear Child in Memory of a Summer's Day.'"
                    + " The published version of Alice's Adventures in Wonderland is about twice the length of "
                    + "Alice's Adventures Under Ground and includes episodes, such as the Mad Tea-Party, "
                    + "that did not appear in the manuscript. The only known manuscript copy of Under Ground ";

    // Static method to find unique words in the default text
    public static Set<String> findUniqueWords() {
        // Call the existing method to process the default text
        return findUniqueWords(DEFAULT_TEXT);
    }

    // Method that processes the provided text
    public static Set<String> findUniqueWords(String text) {
        // Step 1: Remove punctuation (.,!?\"' characters) except for numbers and words
        text = text.replaceAll("[.,!?\"'-]", "");  // Make sure punctuation is handled well, keep valid characters

        // Step 2: Split the text into words by spaces or newline
        String[] words = text.split("\\s+");

        // Step 3: Create a set to store unique words, with custom comparator for sorting
        Set<String> uniqueWords = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // Check if one word is a number and the other isn't
                boolean o1IsNumber = o1.matches("\\d+");
                boolean o2IsNumber = o2.matches("\\d+");

                if (o1IsNumber && !o2IsNumber) {
                    return -1; // Numbers should come before words
                } else if (!o1IsNumber && o2IsNumber) {
                    return 1; // Words should come after numbers
                }

                // If both are numbers or both are words, compare them lexicographically
                return o1.compareTo(o2);
            }
        });

        // Step 4: Add all words to the set
        for (String word : words) {
            if (!word.isEmpty()) {
                uniqueWords.add(word.toLowerCase()); // Convert to lowercase to avoid case-sensitivity
            }
        }

        // Step 5: Return the sorted set of unique words
        return uniqueWords;
    }
}
