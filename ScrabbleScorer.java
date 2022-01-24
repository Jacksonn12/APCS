import java.util.Scanner;
import java.util.*;
import java.util.Arrays;
import java.io.*;

/**
 * Scrabble scorer is a program that reads a users input and returns the number of points that
 a valid word would have in the game scrabble
 * @version 1/24/22
 * @author 22niedel
 */
public class ScrabbleScorer {
    private ArrayList<String> dictionary;
    private int[] points = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
    private String alpha;

    /**
     * Constructor for class Scrabble Scorer
     * Initializes dictionary and builds alphabet string
     * Calls buildDictionary to import words
     */
    public ScrabbleScorer() {
        dictionary = new ArrayList<>();
        alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        buildDictionary();
    }

    /**
     * buildDictionary uses a Scanner to open the scrabble word file
     * imports the valid scrabble words into the array list dictionary
     */
    public void buildDictionary() {
        // use try/catch
        Scanner sc = null;
        try {
            sc = new Scanner(new File("SCRABBLE_WORDS.txt"));
            while (sc.hasNext()) {
                dictionary.add(sc.next());
            }
            sc.close();
            Collections.sort(dictionary);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * isValidWord determines if a user input is a valid word in the dictionary array list
     * @param word
     * @return
     */
    public boolean isValidWord(String word) {
        return Collections.binarySearch(dictionary, word) >= 0;
    }

    /**
     * getWordScore parses through each letter of the word to get the assigned value
     * adds each individual score together to get the total word score
     * @param word
     * @return
     */
    public int getWordScore(String word) {
        int sum = 0;
        for (int i = 0; i < word.length(); i++) {
            int num = points[alpha.indexOf(word.charAt(i))];
            sum += num;
        }
        return sum; // sum of the point value of that word
    }

    /**
     * the main entry point for the program
     * user enters the word they played and the program either returns the word score or that the userWord is invalid
     * 
     * @param args
     */
    public static void main(String[] args) {
        ScrabbleScorer app = new ScrabbleScorer();
        System.out.println("* Welcome to the Scrabble Word Scorer app *");
        String userWord;
        Scanner userIn = new Scanner(System.in);
        try {
            while(true) {
                System.out.print("Enter a word to score or 0 to quit: ");
                userWord = userIn.nextLine().toUpperCase();
                if(userWord.equals("0"))
                    break;
                else {
                    if(app.isValidWord(userWord)) {
                        System.out.println(userWord);
                        System.out.println(app.getWordScore(userWord)+ " points");
                    }
                    else {
                        System.out.println(userWord + " is not a valid word in the dictionary");
                    }
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("Exiting the program thanks for playing");
    }
}
