package com.example.kitchentvbeta;

public class Time {
    /**
     * makes a string time into int;
     * @param t time in string.
     * @return the time in int.
     */
    public static int TimetoInt(String t){
        int time=Integer.parseInt(t);
        return time;
    }

    /**
     * makes a int time to a string of the time.
     * @param t time i int.
     * @return the time in string.
     */
    public static String TimeToString(Integer t){
        String time=t.toString();
        return time;
    }
}
