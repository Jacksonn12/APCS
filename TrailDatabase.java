/**
 * The TrailDatabase class imports the trail waypoints to create the database,
   runs a user-input based program and sorts the data in the database
 * @author 22niedel
 * @version 4/30/2022
 */

import java.util.*;
import java.io.File;

/**
 * this class sorts apptrail data and deals with database input
 */
public class TrailDatabase {
    private ArrayList<Waypoint> database;
    private int searchTerm;
    private boolean asc;

    public TrailDatabase() {
        database = new ArrayList<>();
        populateDatabase();
    }

    /**
     * getSearchTerm takes in the user input to search for the correct parameter to sort by
     */
    public void getSearchTerm() {
        System.out.println("+ Menu of search terms to use for sorting waypoints +\n" +
                "\tTY: by type\n" +
                "\tNA: by name\n" +
                "\tST: by state\n" +
        "\tDS: by distance to Springer\n" +
        "\tDK: by distance to Katahdin\n" +
        "\tEL: by elevation\n");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your preferred sort by term or 'Q' to quit:");
        String term = in.nextLine();
        if(term.equals("TY"))
            searchTerm =  1;
        else if(term.equals("NA"))
            searchTerm = 2;
        else if(term.equals("ST"))
            searchTerm = 3;
        else if(term.equals("DS"))
            searchTerm = 4;
        else if(term.equals("DK"))
            searchTerm = 5;
        else if(term.equals("EL"))
            searchTerm = 6;
        else
            searchTerm = 0;
        if(searchTerm != 0) {
            System.out.print("Enter 'A' to sort in ascending order or 'D' to sort in descending order: ");
            term = in.nextLine();
            asc = (term.toLowerCase().equals("a")) ? true : false;
        }
    }

    /**
     * prints the sorted database
     */
    public void printDatabase() {
        for (Waypoint w : database)
            System.out.println(w);
    }

    /**
     * selection sort sorts the data by search term and in ascending or descending order based on
       user input
     */
    private void selectionSort() {
        WaypointComparator wc = new WaypointComparator(searchTerm, asc);
        Waypoint toSwap;
        int index;
        for(int out = 0; out < database.size(); out++) {
            index = out;
            toSwap = database.get(out);
            for(int in = out + 1; in < database.size(); in++) {
                Waypoint temp = database.get(in);
                if(wc.compare(temp, toSwap) < 0) {
                    toSwap = new Waypoint(temp);
                    index = in;
                }
            }
            database.set(index, database.get(out));
            database.set(out, toSwap);
        }
    }


    /**
     * Imports all data out off the apptrailDB.text file
     */
    public void populateDatabase() {
        try {
            Scanner in = new Scanner(new File("apptrailDB.txt"));
            while (in.hasNext()) {
                String[] line = in.nextLine().split("\t");
                database.add(new Waypoint(line[0], line[1], line[2], Double.parseDouble(line[5]), Double.parseDouble(line[6]), Integer.parseInt(line[7])));
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * calls the method that sorts the data
     */
        public void sortDB() {
            selectionSort();
        }

    /**
     * main entry point for TrailDatabase class
     * @param args
     */
        public static void main (String[]args){
            TrailDatabase db = new TrailDatabase();
            System.out.println("*** Welcome to the Appalachian Trail Database ***");
            while(true) {
                db.getSearchTerm();
                if (db.searchTerm == 0)
                    break;
                db.sortDB();
                db.printDatabase();
            }
            System.out.println("End of program");
        }
    }
