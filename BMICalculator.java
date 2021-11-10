import java.text.DecimalFormat;
import java.util.Scanner;

/** Class BMICalculator calculates the BMI for user-input height and weight
 * @version 11/09/21
 * @author Jackson Niedel
 */
public class BMICalculator {
    /** Method computeBMI Converts English  to metric units, perform the BMI calculation
     * @param inches
     * @param pounds
     * @return
     */
    public static double computeBMI(int inches, int pounds) {
        if(inches <= 0 || pounds < 0)
            return 0;
        return pounds*.454 / Math.pow(inches*.0254, 2);
    }

    /** Method extractInt establishes the correct format for a user entering their height and weight
     * @param value
     * @return
     */
    public static int extractInt(String value) {
        int qtPos = value.indexOf("'");
        int dblQtPos = value.indexOf("\"");
        if (qtPos == -1 || dblQtPos == -1) {
            return -1;
        }

        int feet = Integer.parseInt(value.substring(0, qtPos));
        int inches = Integer.parseInt(value.substring(qtPos + 1, dblQtPos));

        if (inches < 0 || inches > 11 || feet < 0)
            return -1;

        return (feet * 12 + inches == 0) ? -1 : feet * 12 + inches;
    }

    /**
     * main entry point for BMI Calculator where the user inputs their height and weight and receives their BMI
     * @param args main line arguments
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        String height = " ";
        int weight = 0;
        while(true) {
            try {
                height = " ";
                while(extractInt(height) == -1) {
                    System.out.println("Enter height feet and inches (Ex:6'1\"): ");
                    height = in.nextLine();
                }
                System.out.print("Enter weight in pounds: ");
                weight = in.nextInt();
                in.nextLine();      // Scanners are weird, this handles the nextInt buffer
                System.out.println("Your BMI expressed as weight(kg)/height(m)^2: " + df.format(computeBMI(extractInt(height), weight)));

                System.out.println("Continue (Y/N): ");
                String cont = in.nextLine();
                if (cont.toLowerCase().equals("n"))
                    break;
            }
            catch (Exception e) {
                height =" ";
                weight = 0;
                System.out.println("Enter something valid");
            }
        }
        System.out.println("End of Program");
    }
}
