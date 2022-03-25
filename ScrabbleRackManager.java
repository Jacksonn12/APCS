import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Class ScrabbleRackManager randomly generates a scrabble tile rack and prints the words that can be played from the letters in the rack
 * @version 3/25/22
 * @author 22niedel
 */
public class ScrabbleRackManager {
    ArrayList<ArrayList<String>> dictionary;
    ArrayList<String> tileRack;
    private String alpha;

    /** class constructor */
    public ScrabbleRackManager() {
        alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        dictionary = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            dictionary.add(new ArrayList<String>());
        }
            buildDictionary();
            buildTileRack();
    }

    private void buildDictionary() {
            try {
                Scanner filein = new Scanner(new File("SCRABBLE.txt"));
                while (filein.hasNext()) {
                    String temp = filein.nextLine();
                    dictionary.get(alpha.indexOf(temp.charAt(0))).add(temp);
                }
                filein.close();
            }
            catch(Exception e) {
                System.out.println("Error opening file here: " + e);
            }
        }

    private void buildTileRack() {
        tileRack = new ArrayList<>();
        String[] rackLets = {"A","A", "A", "A", "A", "A", "A", "A", "A", "B", "B", "C", "C", "D", "D", "D", "D", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "F", "F", "G", "G", "G", "H", "H", "I", "I", "I", "I", "I", "I", "I", "I", "I", "J", "K", "L", "L", "L", "L", "M", "M", "N", "N", "N", "N", "N", "N", "O", "O", "O", "O", "O", "O", "O", "O", "P", "P", "Q", "R", "R", "R", "R", "R", "R", "S", "S", "S", "S", "T", "T", "T", "T", "T", "T", "U", "U", "U", "U", "V", "V", "W", "W", "X", "Y", "Y", "Z"," " ," "};
        ArrayList<String> allTiles = new ArrayList<>();
        for(String item : rackLets)
            allTiles.add(item);
        Collections.shuffle(allTiles);
        for(int i = 0; i < 7; i++) {
            tileRack.add(allTiles.remove((int)(Math.random()*allTiles.size())));
        }

    }
    /** displays the contents of the player's tile rack */
    public void printRack() {
        System.out.println("The letters in this rack are " + tileRack);
    }

    /** builds and returns an ArrayList of String objects that are values pulled from
     * the dictionary/database based on the available letters in the user's tile
     * rack
     * @return returns the plays
     */
    public ArrayList<String> getPlaylist(){
        ArrayList<String> plays = new ArrayList<>();
        for(ArrayList<String> bucket : dictionary){
            for (String word : bucket) {
                if (isPlayable(word))
                    plays.add(word);
            }
        }
        return plays;
    }

    /** print all of the playable words based on the letters in the tile rack */
    private boolean isPlayable(String word) {
        ArrayList<String> rackCopy = new ArrayList<>(tileRack);
        String[] blank = {"A", "B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        for (int i = 0; i < word.length(); i++) {
            if (!(rackCopy.remove("" + word.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    /**
     * printMatches prints the words created from the letters in the rack if any words can be played
     * it also denotes a bingo when all seven letters are played in a single word
     */
    public void printMatches() {
        ArrayList<String> plays = getPlaylist();
        boolean bingo = false;
        System.out.println("You can play the following words from the letters in your rack: ");
        if(plays.size() == 0)
            System.out.println("Sorry, no words can be played from these tiles.");
        for(int i = 0; i < plays.size(); i ++) {
            String word = plays.get(i);
            if(word.length() == 7) {
                word += "*";
                bingo = true;
            }
            System.out.printf(String.format("%-10s", word));
            if((i+1) % 10 == 0)
                System.out.println();
        }
        if(bingo)
            System.out.println("\n* Denotes Bingo");
    }
    /** main method for the class; use only 3 command lines in main
     * @param args command line arguments if needed
     */
    public static void main(String[] args){
        ScrabbleRackManager app = new ScrabbleRackManager();
        app.printRack();
        app.printMatches();
    }

}
