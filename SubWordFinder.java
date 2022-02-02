import java.util.*;
import java.io.*;

/**
 *  SubWordFinder is a program that imports words_all_os.txt file to search through each
 *  word to find and print words that have two words inside of one, called sub words
 * @author 22niedel
 * @version 1/1/2022
 */
public class SubWordFinder implements WordFinder {
    private ArrayList<ArrayList<String>> dictionary;
    private String alpha = "abcdefghijklmnopqrstuvwxyz";

    /**
     * SubWordFinder creates an ArrayList called dictionary to be filled with what is imported
     * from populateDictionary
      */
    public SubWordFinder() {
        dictionary = new ArrayList<>();
        for(int i = 0; i < alpha.length(); i++) {
            dictionary.add(new ArrayList<String>());
        }
        populateDictionary();
    }

    /**
     * populateDictionary uses a Scanner to populate the ArrayList with every word from
     * the file words_all_os.txt
     */
    public void populateDictionary() {
        try {
            Scanner in = new Scanner(new File("words_all_os.txt"));
            while(in.hasNext()) {
                String word = in.nextLine();
                dictionary.get(alpha.indexOf(word.charAt(0))).add(word);
            }
            in.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * indexOf is a binary Search method that searches for and validates sub word objects
     * within the dictionary
     * @param dict
     * @param word
     * @return
     */
    private int indexOf(ArrayList<String> dict, String word) {
        int min = 0, max = dict.size()-1, mid;
        while(min <= max) {
            mid = (min + max) / 2;
            if (dict.get(mid).compareTo(word) < 0) {
                min = mid + 1;
            }
            else if (dict.get(mid).compareTo(word) > 0) {
                max = mid -1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * inDictionary looks through the whole dictioanry to determine if the word exists
     * or not
     * @param word The item to be searched for in dictionary
     * @return
     */
    public boolean inDictionary(String word) {
        int index = alpha.indexOf(word.charAt(0));
        ArrayList<String> bucket = dictionary.get(index);
        return indexOf(bucket, word) > 0;
    }

    /**
     * Retrieves all subword objects from the dictionary
     */
    public ArrayList<SubWord> getSubWords() {
        ArrayList<SubWord> subwords = new ArrayList<>();
        for(ArrayList<String> bucket : dictionary) {
            for(String word : bucket) {
                for(int i = 3; i < word.length()-2; i++) {
                    String sub1 = word.substring(0,i);
                    String sub2 = word.substring(i);
                if(inDictionary(sub1) && inDictionary(sub2)) {
                    subwords.add(new SubWord(word, sub1, sub2));
                    }
                }
            }
        }
        return subwords;
    }

    /**
     * prints the full dictionary if needed
     */
    public void printDictionary() {
        for(ArrayList<String> bucket : dictionary)
            System.out.println(bucket);
    }

    /**
     * main entrypoint for class SubWordFinder
     * @param args
     */
    public static void main(String[] args) {
        SubWordFinder app = new SubWordFinder();
        for(SubWord a : app.getSubWords()) {
            System.out.println(a);
        }
        System.out.println(app.getSubWords().size());
    }
}
