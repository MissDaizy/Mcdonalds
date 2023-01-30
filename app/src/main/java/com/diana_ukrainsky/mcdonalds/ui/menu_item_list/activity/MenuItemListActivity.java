package com.diana_ukrainsky.mcdonalds.ui.menu_item_list.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.diana_ukrainsky.mcdonalds.R;
import com.diana_ukrainsky.mcdonalds.common.Constants;
import com.diana_ukrainsky.mcdonalds.data.model.MenuItem;
import com.diana_ukrainsky.mcdonalds.data.model.MenuItemDetails;
import com.diana_ukrainsky.mcdonalds.databinding.ActivityMenuItemListBinding;
import com.diana_ukrainsky.mcdonalds.ui.callback.CustomItemClickListener;
import com.diana_ukrainsky.mcdonalds.ui.menu_item_details.MenuItemEvent;
import com.diana_ukrainsky.mcdonalds.ui.menu_item_details.MenuItemViewModel;
import com.diana_ukrainsky.mcdonalds.ui.menu_item_details.activity.MenuItemDetailsActivity;
import com.diana_ukrainsky.mcdonalds.ui.menu_item_list.FilterType;
import com.diana_ukrainsky.mcdonalds.ui.menu_item_list.MenuItemListEvent;
import com.diana_ukrainsky.mcdonalds.ui.menu_item_list.MenuItemListViewModel;
import com.diana_ukrainsky.mcdonalds.ui.menu_item_list.adapter.MenuItemAdapter;
import com.google.gson.Gson;

import java.util.List;


public class MenuItemListActivity extends AppCompatActivity implements LifecycleOwner, CustomItemClickListener {
    private MenuItemListViewModel menuItemListViewModel;
    private MenuItemViewModel menuItemViewModel;
    private RecyclerView recyclerView;
    private MenuItemAdapter menuItemAdapter;
    private ProgressBar progressBar;

    private ActivityMenuItemListBinding activityMenuItemListBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_item_list);

        activityMenuItemListBinding = ActivityMenuItemListBinding.inflate(getLayoutInflater());
        View view = activityMenuItemListBinding.getRoot();
        setContentView(view);

        setViewModels();
        setObservers();

        setViews();
        setListeners();
        setRecyclerView();
        setAdapter();
        setMenuItemListUI();
    }

    private void setViewModels() {
        menuItemListViewModel = new ViewModelProvider(this).get(MenuItemListViewModel.class);
        menuItemViewModel = new ViewModelProvider(this).get(MenuItemViewModel.class);
    }

    private void setObservers() {
        menuItemListViewModel.getMenuItemLiveData().observe(this,menuItemListUpdateObserver);
        menuItemListViewModel.getFilteredMenuItemLiveData().observe(this,filteredMenuItemListUpdateObserver);
        menuItemViewModel.getMenuItemDetailsLiveData().observe(this,menuItemDetailsObserver);
        menuItemListViewModel.getCurrentSearchTextLiveData().observe(this,searchTextObserver);
        menuItemListViewModel.getLoading().observe(this, loadingObserver);
    }

    Observer<List<MenuItem>> menuItemListUpdateObserver = new Observer<List<MenuItem>>() {
        @Override
        public void onChanged(List<MenuItem> menuItemList) {
            menuItemAdapter.updateRecipeListItems(menuItemList);
        }
    };

    Observer<List<MenuItem>> filteredMenuItemListUpdateObserver = new Observer<List<MenuItem>>() {
        @Override
        public void onChanged(List<MenuItem> filteredMenuItems) {
            menuItemAdapter.updateRecipeListItems(filteredMenuItems);
        }
    };

    Observer<MenuItemDetails> menuItemDetailsObserver = new Observer<MenuItemDetails>() {
        @Override
        public void onChanged(MenuItemDetails menuItemDetails) {
            // Item with Details is ready
            startMenuItemActivity();
        }
    };

    Observer<String> searchTextObserver = new Observer<String>() {
        @Override
        public void onChanged(String searchText) {
            activityMenuItemListBinding.activityMenuItemListSVSearchView.setQuery(searchText,false);
        }
    };
    Observer<Boolean> loadingObserver = new Observer<Boolean>() {
        @Override
        public void onChanged(Boolean isLoading) {
            if (isLoading) {
                progressBar.setVisibility(View.VISIBLE);
            }
            else {
                progressBar.setVisibility(View.GONE);
            }
        }
    };
    private void setViews() {
        progressBar = activityMenuItemListBinding.activityMenuItemListPBProgressBar;
    }

    private void setMenuItemListUI() {
        menuItemListViewModel.getMenuItems();
    }

    private void setAdapter() {
        menuItemAdapter = new MenuItemAdapter(this);
        recyclerView.setAdapter(menuItemAdapter);
    }

    private void setRecyclerView() {
        recyclerView = activityMenuItemListBinding.activityMenuItemListRVRecyclerView;

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void setListeners() {
        setFilterButtonsListeners();
        activityMenuItemListBinding.activityMenuItemListSVSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                menuItemListViewModel.onEventMenuItemList(MenuItemListEvent.SEARCH,newText);
                return true;
            }
        });
    }
    private void setFilterButtonsListeners() {
        activityMenuItemListBinding.activityMenuItemListBTNAllFilter.setOnClickListener(v -> {
            menuItemListViewModel.onEventMenuItemList(MenuItemListEvent.FILTER_LIST, FilterType.ALL);
        });
        activityMenuItemListBinding.activityMenuItemListBTNAscCaloriesFilter.setOnClickListener(v -> {
            menuItemListViewModel.onEventMenuItemList(MenuItemListEvent.FILTER_LIST, FilterType.ASC_CALORIES);
        });
        activityMenuItemListBinding.activityMenuItemListBTNDescCaloriesFilter.setOnClickListener(v -> {
            menuItemListViewModel.onEventMenuItemList(MenuItemListEvent.FILTER_LIST, FilterType.DESC_CALORIES);
        });
        activityMenuItemListBinding.activityMenuItemListBTNTitleFilter.setOnClickListener(v -> {
            menuItemListViewModel.onEventMenuItemList(MenuItemListEvent.FILTER_LIST, FilterType.NAME);
        });
    }

    @Override
    public void onClick (Object object){
        menuItemViewModel
                .onEventRecipeList(
                        MenuItemEvent.GET_MENU_ITEM_DETAILS,
                        object
                );
    }

    private void startMenuItemActivity() {
        String selectedItemJson = new Gson().toJson (menuItemViewModel.getSelectedItem().getValue());
        String itemDetailsJson = new Gson().toJson (menuItemViewModel.getMenuItemDetailsLiveData().getValue());
        Intent intent = new Intent(this, MenuItemDetailsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Bundle bundle = new Bundle ();
        bundle.putString(Constants.SELECTED_ITEM,selectedItemJson);
        bundle.putString(Constants.ITEM_DETAILS,itemDetailsJson);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onDestroy () {
        super.onDestroy();
        // Destroy composite when fragment is destroyed.
        menuItemListViewModel.disposeComposite();
    }
}