package com.diana_ukrainsky.mcdonalds.repository;

import com.diana_ukrainsky.mcdonalds.data.model.MenuItem;
import com.diana_ukrainsky.mcdonalds.data.model.MenuItemDetails;
import com.diana_ukrainsky.mcdonalds.data.remote.JsonApiMenuItem;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.core.Observable;

@Singleton
public class Repository {
    private JsonApiMenuItem jsonApiMenuItem;

    @Inject
    public Repository(JsonApiMenuItem jsonApiMenuItem) {
        this.jsonApiMenuItem = jsonApiMenuItem;
    }

    public Observable<List<MenuItem>> getAllMenuItems(){
        return jsonApiMenuItem.getAllMenuItems();
    }
    public Observable<MenuItemDetails> getMenuItemDetails(String menuItemUrlId){
        return jsonApiMenuItem.getMenuItemDetails(menuItemUrlId);
    }
}
