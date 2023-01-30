package com.diana_ukrainsky.mcdonalds.repository;

import com.diana_ukrainsky.mcdonalds.data.model.MenuItem;
import com.diana_ukrainsky.mcdonalds.data.model.MenuItemDetails;
import com.diana_ukrainsky.mcdonalds.data.remote.ApiService;
import com.diana_ukrainsky.mcdonalds.data.remote.JsonApiMenuItem;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class Repository {
    private static Repository INSTANCE = null;

    private JsonApiMenuItem jsonApiMenuItem;
    public static Repository getInstance() {
        if (INSTANCE == null)
            INSTANCE = new Repository();

        return INSTANCE;
    }
    private Repository( ) {
        this.jsonApiMenuItem = ApiService.getInstance().getJsonApiMenuItem();
    }

    public Observable<List<MenuItem>> getAllMenuItems(){
        return jsonApiMenuItem.getAllMenuItems();
    }
    public Observable<MenuItemDetails> getMenuItemDetails(String menuItemUrlId){
        return jsonApiMenuItem.getMenuItemDetails(menuItemUrlId);
    }
}
