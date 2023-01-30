package com.diana_ukrainsky.mcdonalds.ui.menu_item_list;


import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.diana_ukrainsky.mcdonalds.common.Constants;
import com.diana_ukrainsky.mcdonalds.data.model.MenuItem;
import com.diana_ukrainsky.mcdonalds.repository.Repository;
import com.diana_ukrainsky.mcdonalds.ui.menu_item_details.MenuItemViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;

public class MenuItemListViewModel extends ViewModel {

    // Variable the Menu Item List
    private MutableLiveData<List<MenuItem>> menuItemLiveData;
    // Variable of the filtered Menu Item List
    private MutableLiveData<List<MenuItem>> filteredMenuItemLiveData;
    // Variable of the Selected Menu Item
    private MutableLiveData<MenuItem> selectedMenuItem;
    // Variable for hiding and showing the loading spinner
    private MutableLiveData<Boolean> loading;
    private MutableLiveData<String> currentSearchTextLiveData;
    private PublishSubject<List<MenuItem>> menuItemsSubject;
    private CompositeDisposable disposables;
    private Repository repository;
    private FilterType selectedFilter;


    public MenuItemListViewModel() {
        this.repository = Repository.getInstance();

        init();
        subscribeSubject();
    }

    private void init() {
        menuItemLiveData = new MutableLiveData<>();
        filteredMenuItemLiveData = new MutableLiveData<>();
        selectedMenuItem = new MutableLiveData<>();
        loading = new MutableLiveData<>();
        currentSearchTextLiveData = new MutableLiveData<>("");

        menuItemsSubject = PublishSubject.create();
        disposables = new CompositeDisposable();
        selectedFilter = FilterType.ALL;
    }

    private void subscribeSubject() {
        Disposable disposable =
                repository.getAllMenuItems()
                        .subscribeOn(Schedulers.io())
                        .subscribe(menuItemsSubject::onNext, throwable -> {
                            Log.e(Constants.LOG, "From SubscribeSubject error: " + throwable.getMessage());
                        });
        disposables.add(disposable);
    }

    public MutableLiveData<List<MenuItem>> getMenuItemLiveData() {
        return menuItemLiveData;
    }

    public MutableLiveData<List<MenuItem>> getFilteredMenuItemLiveData() {
        return filteredMenuItemLiveData;
    }

    public MutableLiveData<MenuItem> getSelectedMenuItem() {
        return selectedMenuItem;
    }

    public MutableLiveData<Boolean> getLoading() {
        return loading;
    }

    public MutableLiveData<String> getCurrentSearchTextLiveData() {
        return currentSearchTextLiveData;
    }

    public void getMenuItems() {
        menuItemsSubject
                .debounce(400, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                // No need to map
                .subscribe(new Observer<List<MenuItem>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        loading.setValue(true);
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(@NonNull List<MenuItem> menuItems) {
                        loading.setValue(false);
                        menuItemLiveData.setValue(menuItems);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e(Constants.LOG, "getMenuItems error: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        // Nothing to do here
                    }
                });
    }


    public void onEventMenuItemList(MenuItemListEvent event, Object object) {
        switch (event) {
            case FILTER_LIST: {
                selectedFilter = (FilterType) object;
                filterList();
                break;
            }
            case SEARCH: {
                String searchQuery=(String)object;
               searchMenuItems(searchQuery.toLowerCase());
               if(filteredMenuItemLiveData.getValue()!=null) {
                   if(filteredMenuItemLiveData.getValue().isEmpty())
                       loading.setValue(false);
               }

               break;
            }
        }
    }

    private void filterList() {
        List<MenuItem> filteredMenuItems;
        if (menuItemLiveData.getValue() == null)
            return;
        else if (filteredMenuItemLiveData.getValue() == null)
            filteredMenuItems = menuItemLiveData.getValue();
        else
            filteredMenuItems = filteredMenuItemLiveData.getValue();

         filterCases(filteredMenuItems);
    }
        private void filterCases(List<MenuItem> filteredMenuItems) {
        switch (selectedFilter) {
            case ALL:
                currentSearchTextLiveData.setValue("");
                filteredMenuItemLiveData.setValue(menuItemLiveData.getValue());
                break;
            case ASC_CALORIES:
                Collections.sort(filteredMenuItems, new MenuItem.SortByCalories().reversed());
                filteredMenuItemLiveData.setValue(filteredMenuItems);
                break;
            case DESC_CALORIES:
                Collections.sort(filteredMenuItems, new MenuItem.SortByCalories());
                filteredMenuItemLiveData.setValue(filteredMenuItems);
                break;
            case NAME:
                Collections.sort(filteredMenuItems, new MenuItem.SortByTitle());
                filteredMenuItemLiveData.setValue(filteredMenuItems);
                break;
        }
    }
    public void disposeComposite() {
        disposables.dispose();
    }

    public void searchMenuItems(String searchQuery) {
        currentSearchTextLiveData.setValue(searchQuery);
        List<MenuItem> filteredMenuItems = new ArrayList<>();
        if (menuItemLiveData.getValue() != null) {
            for (MenuItem menuItem : menuItemLiveData.getValue()) {
                if (menuItem.getItem().toLowerCase().contains(searchQuery)) {
                    filteredMenuItems.add(menuItem);
                }
            }
            filteredMenuItemLiveData.setValue(filteredMenuItems);
        }
    }
}
