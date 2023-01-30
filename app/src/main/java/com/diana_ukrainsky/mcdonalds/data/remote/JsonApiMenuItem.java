package com.diana_ukrainsky.mcdonalds.data.remote;

import com.diana_ukrainsky.mcdonalds.data.model.MenuItem;
import com.diana_ukrainsky.mcdonalds.data.model.MenuItemDetails;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonApiMenuItem {
    // The List of menu items
    @GET("eb45e4d55e58098c1537")
    Observable<List<MenuItem>> getAllMenuItems();

    // More details of a specific menu item
    @GET("{menuItemUrlId}")
    Observable<MenuItemDetails> getMenuItemDetails(
            @Path("menuItemUrlId") String id
    );
}
