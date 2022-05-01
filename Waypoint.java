/**
 * class Waypoint implements the comparable waypoint to initialize and get
   each element of a waypoint, and compare names of waypoints
 * @author 22niedel
 * @version 4/30/22
 */

public class Waypoint implements Comparable<Waypoint>{
    private String type, name, state;
    private double toSpringer, toKatahdin;
    private int elevation;

    /**
     * initializes the components of each waypoint
     * @param t type
     * @param n name
     * @param s state
     * @param ts distance to Springer
     * @param tk distance to Katahdin
     * @param e elevation
     */
    public Waypoint(String t, String n, String s, double ts, double tk, int e) {
        type = t;
        name = n;
        state = s;
        toSpringer = ts;
        toKatahdin = tk;
        elevation = e;
    }

    /**
     * assigns the correct component to a Waypoint
     * @param temp
     */
    public Waypoint(Waypoint temp) {
        this(temp.type, temp.name, temp.state, temp.toSpringer, temp.toKatahdin, temp.elevation);
    }

    /**
     * gets the Type of Waypoint in the database
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * gets the Name of Waypoint
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * gets the State the Waypoint is in
     * @return
     */
    public String getState() {
        return state;
    }

    /**
     * gets the distance from the waypoint to Springer Mt.
     * @return distance toSpringer
     */
    public double getToSpringer() {
        return toSpringer;
    }

    /**
     * gets the distance from waypoint to Mt. Katahdin
     * @return distance toKatahdin
     */
    public double getToKatahdin() {
        return toKatahdin;
    }

    /**
     * gets the elevation of the waypoint
     * @return elevation
     */
    public int getElevation() {
        return elevation;
    }

    /**
     * puts together a comprehensible string that will show the user
       each of the components of the waypoint
     * @return
     */
    @Override
    public String toString() {
        return
                type +
                ", " + name +
                ", " + state +
                ", dist to Springer " + toSpringer +
                ", dist to Katahdin " + toKatahdin +
                ", elev " + elevation;
    }

    /**
     * allows the names of waypoints to be compared so that the data can be sorted
       by name
     * @param other
     * @return
     */
    public int compareTo(Waypoint other) {
        return (this.name.substring(0,1).compareTo(other.name.substring(0,1)))*-1;
    }
}
