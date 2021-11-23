import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

/**
 * BaseConverter opens a data file, reads, converts numbers, prints
 * @version 11/22/21
 * @author Jackson Niedel
 */
public class BaseConverter {
    // Constructor for class.
    public BaseConverter() {

    }

    /**
     * Convert a String num in fromBase to base-10 int.
     * @param num the input number
     * @param fromBase the input base
     */
    public int strToInt(String num, String fromBase) {
        int base = Integer.parseInt(fromBase);
        String alpha = "0123456789ABCDEF";
        int sum = 0, exp = 0;
        for (int i = num.length()-1; i >= 0; i--) {
        sum += alpha.indexOf(num.charAt(i)) * Math.pow(base, exp);
        exp++;
    }
             return sum;
    }

    /**
     * Converts a base-10 int to a String number of base toBase.
     * @param toBase the output base
     */

    public String intToStr(int num, int toBase) {
        String alpha = "0123456789ABCDEF";
        String toNum = "";

        while (num > 0) {
            toNum = alpha.charAt(num % toBase) + toNum;
            num /= toBase;
        }
        if (toNum.equals(""))
            return "0";
        return toNum;
    }

    /**
     * Opens the file stream, inputs data one line at a time, converts, prints
     * the result to the console window and writes data to the output stream.
     */
    public void inputConvertPrintWrite() {
        // create a Scanner that opens values10.dat
        //print each line to the screen
        Scanner sc = null;
        PrintWriter pw = null;
        try {
            sc = new Scanner(new File("datafiles/values10.dat"));
            pw = new PrintWriter(new File("datafiles/converted.dat"));
            while (sc.hasNext()) {
                String[] line = sc.nextLine().split("\t");
                // line = {"24A4B56" , "13" , "6"}
                int fromBase = Integer.parseInt(line[1]);
                int toBase = Integer.parseInt(line[2]);
                if(fromBase < 2 || fromBase > 16) {
                    System.out.println("Invalid input base" + fromBase);
                }
                else if(toBase < 2 || toBase > 16) {
                    System.out.println("Invalid output base" + toBase);
                }
                else {
                    System.out.println(line[0] + " base " + fromBase + " = " + intToStr(strToInt(line[0], line[1]), toBase)+ " base " + toBase);
                    pw.println(line[0] + "\t" + fromBase + "\t" + intToStr(strToInt(line[0], line[1]), toBase)+ "\t" + toBase);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        if (sc != null)
            sc.close();
        if(pw != null)
            pw.close();
        }
        /**
         * Main method for class BaseConverter
         * @param args command line arguments, if needed
         */
        public static void main (String[]args){
            BaseConverter app = new BaseConverter();
            app.inputConvertPrintWrite();
            //System.out.println(app.strToInt("21221201", "3"));
            //System.out.println(app.intToStr(5789324, 16));
        }
}