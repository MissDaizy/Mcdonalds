package com.diana_ukrainsky.mcdonalds.ui.menu_item_details;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.diana_ukrainsky.mcdonalds.common.Constants;
import com.diana_ukrainsky.mcdonalds.data.model.MenuItem;
import com.diana_ukrainsky.mcdonalds.data.model.MenuItemDetails;
import com.diana_ukrainsky.mcdonalds.repository.Repository;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;

public class MenuItemViewModel extends ViewModel {
    private MutableLiveData<MenuItemDetails> menuItemDetailsLiveData;
    private MutableLiveData<MenuItem> selectedItem;
    private Repository repository;
    private CompositeDisposable disposables;
    private PublishSubject<MenuItemDetails> menuItemDetailsSubject;



    public MenuItemViewModel( ) {
        this.repository = Repository.getInstance();


        init();
    }

    private void init() {
        menuItemDetailsLiveData = new MutableLiveData<>();
        selectedItem = new MutableLiveData<>();
        disposables = new CompositeDisposable();

        menuItemDetailsSubject = PublishSubject.create();
    }

    public void subscribeSubject(String menuItemUrl) {
        Disposable disposable =
                repository.getMenuItemDetails(menuItemUrl)
                        .subscribeOn(Schedulers.io())
                        .subscribe(menuItemDetailsSubject::onNext, throwable -> {
                            Log.e(Constants.LOG, "subscribeSubject error: " + throwable.getMessage());
                        });
        disposables.add(disposable);

    }

    public MutableLiveData<MenuItemDetails> getMenuItemDetailsLiveData() {
        return menuItemDetailsLiveData;
    }

    public MutableLiveData<MenuItem> getSelectedItem() {
        return selectedItem;
    }

    public void getMenuItemDetails() {
        menuItemDetailsSubject
                .debounce(400, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<MenuItemDetails>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(@NonNull MenuItemDetails menuItemDetails) {
                        menuItemDetailsLiveData.setValue(menuItemDetails);

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e(Constants.LOG, "getMenuItemDetails error: " + e.getMessage());

                    }

                    @Override
                    public void onComplete() {
                        // Nothing to do here

                    }
                });

    }

    public void onEventRecipeList(MenuItemEvent getMenuItemDetails, Object object) {
        switch (getMenuItemDetails) {
            case GET_MENU_ITEM_DETAILS:
                MenuItem menuItem = (MenuItem) object;
                selectedItem.setValue(menuItem);
                subscribeSubject(menuItem.getId());
                getMenuItemDetails();
                break;

        }

    }
}
