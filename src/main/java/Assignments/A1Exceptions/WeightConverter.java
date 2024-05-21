package Assignments.A1Exceptions;

/**
 * Converts weights between pounds and kilograms.
 * 
 * This class provides static methods to convert weights from pounds to kilograms and vice versa.
 */
public class WeightConverter {
    /**
     * Entry point of the WeightConverter application.
     * 
     * Demonstrates the conversion of weights between pounds and kilograms.
     * 
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        try {
            System.out.println(poundsToKilos(2.2));
        } catch (AssertionError e) {
            System.err.println(e);
        }
        try {
            System.out.println(poundsToKilos(-5.2));
        } catch (AssertionError e) {
            System.err.println(e);
        }
        try {
            System.out.println(kilosToPounds(6.1));
        } catch (AssertionError e) {
            System.err.println(e);
        }
        try {
            System.out.println(kilosToPounds(-4.0));
        } catch (AssertionError e) {
            System.err.println(e);
        }
    }

    /**
     * Converts weight from pounds to kilograms.
     * 
     * @param pounds The weight in pounds to be converted.
     * @return The equivalent weight in kilograms.
     * @throws AssertionError if the input weight is negative.
     */
    public static Double poundsToKilos(Double pounds) {
        assert pounds >= 0 : "cannot convert negative weight";
        return pounds / 2.205;
    }

    /**
     * Converts weight from kilograms to pounds.
     * 
     * @param kilos The weight in kilograms to be converted.
     * @return The equivalent weight in pounds.
     * @throws AssertionError if the input weight is negative.
     */
    public static Double kilosToPounds(Double kilos) {
        assert kilos >= 0 : "cannot convert negative weight";
        return kilos * 2.205;
    }
}
