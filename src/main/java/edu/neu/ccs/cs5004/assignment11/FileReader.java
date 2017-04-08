package edu.neu.ccs.cs5004.assignment11;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jeremy on 4/8/17.
 */
class FileReader {
    /**
     * Given a file path in which the file only contains english words (one word in each line),
     * returns a list of string containing all words read from the file.
     *
     * @param filePath the file path in which the file only contains english words
     * @return a list of string containing all words read from the file
     */
    static String[] readWordsFromFile(String filePath) {
        Set<String> words = new HashSet<>();
        try (BufferedReader inputFile = new BufferedReader(new InputStreamReader(
                new FileInputStream(filePath), "UTF-8"))) {
            String word;
            while ((word = inputFile.readLine()) != null) {
                word = word.trim();
                if (word.equals("")) continue;
                words.add(word);
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("The file was not found : " + fnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println("Something went wrong! : " + ioe.getMessage());
        }
        return words.toArray(new String[words.size()]);
        // https://www.tutorialspoint.com/java/util/arraylist_toarray.htm
    }
}
