package programs;

import java.util.Calendar;

public class LeapYear {
    public static void main(String args[]) {

	System.err.println("Is 2000 a leap year ? : " + isLeapYear(2000));
    }

    /*
     * A year is a leap year if its multiple of 400 or multiple of 4 but not 100
     */
    public static boolean isLeapYear(int year){
        return (year%400 == 0) || ((year%100) != 0 && (year%4 == 0));
    }

    public static boolean doesLeapYear(int year){
        Calendar cal = Calendar.getInstance(); //gets Calendar based on local timezone and locale
        cal.set(Calendar.YEAR, year); //setting the calendar year
        int noOfDays = cal.getActualMaximum(Calendar.DAY_OF_YEAR);
      
        if(noOfDays > 365){
            return true;
        }
      
        return false;
    }

}
