/*
 * This file defines an abstract class named Bag.
 * In this exercise, you will be writing a larger class according to
 * the TODOs we have left you. You may find the readings in chapter
 * 1. Introduction to Java helpful.
 */

public abstract class Bag {

    private String color;
    private int numberOfContents;
    private int capacity;
    private String[] contents;

    /*
     * The other attributes (private instance variables) should
     * be empty (e.g. numberOfContents is 0 and an empty String array for
     * its contents.)
     */
    public Bag(String colorInput, int capacityInput) {
        color = colorInput;
        numberOfContents = 0;
        capacity = capacityInput;
        contents = new String[0];
    }

    public String getColor() {
        return color;
    }

    public int getNumberOfContents() {
        return numberOfContents;
    }

    public int getCapacity() {
        return capacity;
    }


    public void setColor(String newColor){
        this.color = newColor;
    }


    /*
     *       This method should return true if the item was added
     *       and false otherwise.
     */
    public boolean addItem(String item){
        if (this.numberOfContents < capacity){
            numberOfContents ++;
            String[] newArr = new String[numberOfContents];
            for (int i = 0; i < numberOfContents - 1; i ++){
                newArr[i] = contents[i];
            }

            newArr[numberOfContents - 1] = item;
            this.contents = newArr;

            return true;
        }
        else {
            return false;
        }
    }


    /**
     * If there are no items in this Bag, return null.
     *
     * @return
     */
    public String popItem() {
        if (numberOfContents == 0) {
            return null;
        }

        String removedItem = this.contents[numberOfContents - 1];

        String[] newArr = new String[numberOfContents - 1];
        for (int i = 0; i < numberOfContents - 2; i ++){
            newArr[i] = contents[i];
        }
        this.contents = newArr;
        numberOfContents --;

        return removedItem;
    }

    /**
     * Increase this bag's capacity by n.
     *
     * @param n the amount to increase this Bag's capacity by
     */
    public void increaseCapacity(int n) {
        this.capacity += n;

    }

    /**
     * Return the details of this Bag.
     * This method requires you to have created the private
     * instance variables mentioned above.
     *
     * @return the color, numberOfContents, and capacity of the Bag object.
     */
    @Override
    public String toString() {
        return this.color + " Bag (" + this.numberOfContents + " / " +
                this.capacity + ")";
    }

    /*
     * Below we have defined an abstract method.
     * This method takes no arguments and does not return anything.
     * It increases the capacity of this Bag.
     *
     * You will need to implement this method in
     * HandBag.java and CrossbodyBag.java.
     *
     * We recommend you look at HandBag.java first.
     */
    public abstract void enhance();
}