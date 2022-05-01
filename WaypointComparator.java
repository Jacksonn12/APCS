/**
 * WaypointComparator class also implements waypoint comparator to compare and
   place in the correct order, each element of a waypoint except the name
 * @author 22niedel
 * @version 4/30/22
 */

import java.util.Comparator;

/**
 * constructor for class Waypoint comparator
 */
public class WaypointComparator implements Comparator<Waypoint> {
    private int category;
    private boolean asc;

    /**
     * copy constructor that gives category and asc single letter variables
     * @param c category
     * @param a asc
     */
    public WaypointComparator(int c, boolean a) {
        category = c;
        asc = a;
    }

    public WaypointComparator(int c) {
        category = c;
        asc = true;
    }

    public WaypointComparator() {
        category = 4;
        asc = true;
    }

    /**
     * allows program to go through each waypoint and compare it to another
       in order to sort the waypoint in the way that the user inputs
     * @param one
     * @param two
     * @return
     */
    public int compare(Waypoint one, Waypoint two) {
        int diff = 0;
        if(category == 1)
            diff = one.getType().compareTo(two.getType());
        else if(category == 2)
            diff = one.getName().compareTo(two.getName());
        else if(category == 3)
            diff = one.getState().compareTo(two.getState());
        else if (category == 4) {
            Double d1 = one.getToSpringer();
            Double d2 = two.getToSpringer();
            diff= d1.compareTo(d2);
        }
        else if (category == 5) {
            Double d1 = one.getToKatahdin();
            Double d2 = two.getToKatahdin();
            diff= d1.compareTo(d2);
        }
        else if(category == 6)
            diff = one.getElevation() - two.getElevation();

        return(asc) ? diff : -diff;
    }
}
