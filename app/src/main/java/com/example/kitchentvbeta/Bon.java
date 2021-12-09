package com.example.kitchentvbeta;

import java.util.ArrayList;

public class Bon {
    private String time;
    private ArrayList<Meal> b;
    private String date;
    private boolean above;
    private String note;
    /**
     * creats new bon.
     * @param time the time the bon was created.
     * @param b the meals in the bon.
     * @param date the date the bon was created.
     * @param above
     */
    public Bon(String time, ArrayList<Meal> b, String date, boolean above, String note) {
        this.time=time;
        this.b=b;
        this.date=date;
        this.above=above;
        this.note=note;
    }
    /**
     * @return the meals in the bon.
     */
    public ArrayList<Meal> getB() {
        return b;
    }

    /**
     * @return the date of the bon.
     */
    public String getDate() {
        return date;
    }

    /**
     * @return the time of the bon.
     */
    public String getTime() {
        return time;
    }

    /**
     * @return if there is any perferation
     */
    public boolean isAbove() {
        return above;
    }
    /**
     *
     * @return the note of the bon.
     */
    public String getNote() {
        return note;
    }

    /**
     * sets the Array list of meals.
     * @param b the Array list of meals.
     */
    public void setB(ArrayList<Meal> b) {
        this.b = b;
    }

    /**
     * sets the date of the bon.
     * @param date the date the bon was created.
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * sets the time of the bon
     * @param time the time the bon was created.
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * sets if there is any perferation in this bon.
     * @param above
     */
    public void setAbove(boolean above) {
        this.above = above;
    }

    /**
     * sets new note/
     * @param note the new note.
     */
    public void setNote(String note) {
        this.note = note;
    }

    @Override
    /**
     * makes a string out of all the object parameters.
     */
    public String toString() {
        if (note == null) {
            return "Bon{" +
                    "time='" + time + '\'' +
                    ", b=" + b +
                    ", date='" + date + '\'' +
                    ", above=" + above +
                    '}';
        }
        else {
            return "Bon{" +
                    "time='" + time + '\'' +
                    ", b=" + b +
                    ", date='" + date + '\'' +
                    ", above=" + above + "notes"+note+
                    '}';
        }
    }
}
