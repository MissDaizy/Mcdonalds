package com.diana_ukrainsky.mcdonalds.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.Comparator;

public class MenuItem {
    @SerializedName("id")
    private String id;
    @SerializedName("Category")
    private String category;
    @SerializedName("Item")
    private String item;
    @SerializedName("Serving Size")
    private String servingSize;
    @SerializedName("Calories")
    private int calories;
    @SerializedName("Calories from Fat")
    private int caloriesFromFat;
    @SerializedName("Total Fat")
    private int totalFat;
    @SerializedName("Total Fat (% Daily Value)")
    private int totalFatPercentage;
    @SerializedName("Saturated Fat")
    private int saturatedFat;
    @SerializedName("Saturated Fat (% Daily Value)")
    private int saturatedFatPercentage;
    @SerializedName("Trans Fat")
    private int transFat;
    @SerializedName("Cholesterol")
    private int cholesterol;
    @SerializedName("Cholesterol (% Daily Value)")
    private int cholesterolPercentage;
    @SerializedName("Sodium")
    private int sodium;
    @SerializedName("Sodium (% Daily Value)")
    private int sodiumPercentage;
    @SerializedName("Carbohydrates")
    private int carbohydrates;
    @SerializedName("Carbohydrates (% Daily Value)")
    private int carbohydratesPercentage;
    @SerializedName("Dietary Fiber")
    private int dietaryFiber;
    @SerializedName("Dietary Fiber (% Daily Value)")
    private int dietaryFiberPercentage;
    @SerializedName("Sugars")
    private int sugars;
    @SerializedName("Protein")
    private int protein;
    @SerializedName("Vitamin A (% Daily Value)")
    private int vitaminA;
    @SerializedName("Vitamin C (% Daily Value)")
    private int vitaminC;
    @SerializedName("Calcium (% Daily Value)")
    private int calcium;
    @SerializedName("Iron (% Daily Value)")
    private int iron;

    public MenuItem() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getServingSize() {
        return servingSize;
    }

    public void setServingSize(String servingSize) {
        this.servingSize = servingSize;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getCaloriesFromFat() {
        return caloriesFromFat;
    }

    public void setCaloriesFromFat(int caloriesFromFat) {
        this.caloriesFromFat = caloriesFromFat;
    }

    public int getTotalFat() {
        return totalFat;
    }

    public void setTotalFat(int totalFat) {
        this.totalFat = totalFat;
    }

    public int getTotalFatPercentage() {
        return totalFatPercentage;
    }

    public void setTotalFatPercentage(int totalFatPercentage) {
        this.totalFatPercentage = totalFatPercentage;
    }

    public int getSaturatedFat() {
        return saturatedFat;
    }

    public void setSaturatedFat(int saturatedFat) {
        this.saturatedFat = saturatedFat;
    }

    public int getSaturatedFatPercentage() {
        return saturatedFatPercentage;
    }

    public void setSaturatedFatPercentage(int saturatedFatPercentage) {
        this.saturatedFatPercentage = saturatedFatPercentage;
    }

    public int getTransFat() {
        return transFat;
    }

    public void setTransFat(int transFat) {
        this.transFat = transFat;
    }

    public int getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(int cholesterol) {
        this.cholesterol = cholesterol;
    }

    public int getCholesterolPercentage() {
        return cholesterolPercentage;
    }

    public void setCholesterolPercentage(int cholesterolPercentage) {
        this.cholesterolPercentage = cholesterolPercentage;
    }

    public int getSodium() {
        return sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public int getSodiumPercentage() {
        return sodiumPercentage;
    }

    public void setSodiumPercentage(int sodiumPercentage) {
        this.sodiumPercentage = sodiumPercentage;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public int getCarbohydratesPercentage() {
        return carbohydratesPercentage;
    }

    public void setCarbohydratesPercentage(int carbohydratesPercentage) {
        this.carbohydratesPercentage = carbohydratesPercentage;
    }

    public int getDietaryFiber() {
        return dietaryFiber;
    }

    public void setDietaryFiber(int dietaryFiber) {
        this.dietaryFiber = dietaryFiber;
    }

    public int getDietaryFiberPercentage() {
        return dietaryFiberPercentage;
    }

    public void setDietaryFiberPercentage(int dietaryFiberPercentage) {
        this.dietaryFiberPercentage = dietaryFiberPercentage;
    }

    public int getSugars() {
        return sugars;
    }

    public void setSugars(int sugars) {
        this.sugars = sugars;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getVitaminA() {
        return vitaminA;
    }

    public void setVitaminA(int vitaminA) {
        this.vitaminA = vitaminA;
    }

    public int getVitaminC() {
        return vitaminC;
    }

    public void setVitaminC(int vitaminC) {
        this.vitaminC = vitaminC;
    }

    public int getCalcium() {
        return calcium;
    }

    public void setCalcium(int calcium) {
        this.calcium = calcium;
    }

    public int getIron() {
        return iron;
    }

    public void setIron(int iron) {
        this.iron = iron;
    }
    public static class SortByTitle implements Comparator<MenuItem> {
        // Used for sorting title
        public int compare(MenuItem m1, MenuItem m2) {
            return m1.getItem().compareTo(m2.getItem());
        }
    }
    public static class SortByCalories implements Comparator<MenuItem> {
        // Used for sorting in ascending order of
        // roll number
        public int compare(MenuItem m1, MenuItem m2) {
            return m1.getCalories() - m2.getCalories();
        }
    }
}
