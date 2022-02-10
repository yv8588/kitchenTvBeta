package com.example.kitchentvbeta;

public class Meal {
    private String name;
    private double price;
    private String image;
    private String category;
    private String about;
    /**
     *
     * @param name meal name.
     * @param price meals price.
     * @param image meals image.
     * @param category meal category .
     */
    public Meal(String name, double price, String image, String category,String about) {
        this.name=name;
        this.price=price;
        this.image=image;
        this.category=category;
    }
    public Meal(){

    }
    /**
     * @return the price.
     */
    public double getPrice() {
        return price;
    }
    /**
     * @return the category.
     */
    public String getCategory() {
        return category;
    }
    /**
     * @return the image.
     */
    public String getImage() {
        return image;
    }
    /**
     * @return the name.
     */
    public String getName() {
        return name;
    }
    /**
     * @return the meal description.
     */
    public String getAbout() {
        return about;
    }

    /**
     * sets meal category.
     * @param category the meals category
     */
    public void setCategory(String category) {
        this.category = category;
    }
    /**
     * sets the meals image.
     * @param image meal image.
     */
    public void setImage(String image) {
        this.image = image;
    }
    /**
     * sets the meal name
     * @param name meals name.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * sets meals price.
     * @param price meals price.
     */
    public void setPrice(double price) {
        this.price = price;
    }
    /**
     * sets meals description.
     * @param about meals description.
     */
    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public String toString() {
        return name+""+category+""+price;
    }
}
