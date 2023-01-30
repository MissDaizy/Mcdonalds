package com.diana_ukrainsky.mcdonalds.ui.menu_item_details.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.diana_ukrainsky.mcdonalds.R;
import com.diana_ukrainsky.mcdonalds.common.Constants;
import com.diana_ukrainsky.mcdonalds.data.model.MenuItem;
import com.diana_ukrainsky.mcdonalds.data.model.MenuItemDetails;
import com.diana_ukrainsky.mcdonalds.databinding.ActivityMenuItemDetailsBinding;
import com.diana_ukrainsky.mcdonalds.ui.menu_item_details.MenuItemViewModel;
import com.diana_ukrainsky.mcdonalds.util.ImageUtil;
import com.google.gson.Gson;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MenuItemDetailsActivity extends AppCompatActivity   {
    private static final int HEIGHT =1000 ;
    private static final int WIDTH =1000 ;
    private MenuItemViewModel menuItemViewModel;

    private ActivityMenuItemDetailsBinding activityMenuItemDetailsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_item_details);

        activityMenuItemDetailsBinding = ActivityMenuItemDetailsBinding.inflate(getLayoutInflater());
        View view = activityMenuItemDetailsBinding.getRoot();
        setContentView(view);

        setUI();
    }

    private void setUI() {
        MenuItem menuItem=getItemData();
        MenuItemDetails menuItemDetails = getItemDetails();
        setMenuItemUI(menuItem);
        setMenuItemDetailsUI(menuItemDetails);
    }

    private MenuItem getItemData() {
        Bundle bundle = getIntent ().getExtras ();
        String selectedItemJson = bundle.getString (Constants.SELECTED_ITEM);
        MenuItem selectedItem = new Gson().fromJson (selectedItemJson, MenuItem.class);
        return  selectedItem;
    }

    private MenuItemDetails getItemDetails() {
        Bundle bundle = getIntent ().getExtras ();
        String itemDetailsJson = bundle.getString (Constants.ITEM_DETAILS);
        MenuItemDetails menuItemDetails = new Gson().fromJson (itemDetailsJson, MenuItemDetails.class);
        return menuItemDetails;
    }

    private void setMenuItemUI(MenuItem selectedItem) {
        activityMenuItemDetailsBinding.recipeListItemTXTTitle.setText(selectedItem.getItem());
    }

    private void setMenuItemDetailsUI(MenuItemDetails menuItemDetails) {
        activityMenuItemDetailsBinding.fragmentRecipeDetailsTXTDescription.setText(menuItemDetails.getDescription());
        setImageUI(menuItemDetails.getImageUrl());
    }

    private void setImageUI(String imageUrl) {
        ImageUtil.setImage(this,imageUrl,activityMenuItemDetailsBinding.recipeListItemIMGRecipeImage,WIDTH,HEIGHT);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}