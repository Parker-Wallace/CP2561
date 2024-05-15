package Assignments.A1Exceptions;

public class WeightConverter {
    public static void main(String[] args) {
        try {
            System.out.println(poundsToKilos(2.2));}
        catch(AssertionError e){
            System.err.println(e);
        }
        try {
            System.out.println(poundsToKilos(-5.2));}
        catch(AssertionError e){
            System.err.println(e);
        }
        try {
            System.out.println(kilosToPounds(6.1));}
        catch(AssertionError e){
            System.err.println(e);
        }
        try {
            System.out.println(kilosToPounds(-4.0));}
        catch(AssertionError e){
            System.err.println(e);
        }




    }

    public static Double poundsToKilos(Double pounds) {
    assert pounds >=0: "cannot convert negative weight";
    return pounds/2.205;
    }

    public static Double kilosToPounds(Double kilos) {
        assert kilos >= 0: "cannot convert negative weight";
        return kilos * 2.205;
    }
}
