package com.diana_ukrainsky.mcdonalds.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MenuItemDetails {
    @SerializedName("id")
    private String id;
    @SerializedName("imageUrl")
    private String imageUrl;
    @SerializedName("description")
    private String description;
    @SerializedName("ingredients")
    private List<String> ingredients;

    public MenuItemDetails() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}
