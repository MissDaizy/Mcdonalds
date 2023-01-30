package com.diana_ukrainsky.mcdonalds.ui.callback;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import com.diana_ukrainsky.mcdonalds.data.model.MenuItem;

import java.util.List;

public class MenuItemDiffCallback extends DiffUtil.Callback {
    private final List<MenuItem> mOldMenuItemList;
    private final List<MenuItem> mNewMenuItemList;

    public MenuItemDiffCallback(List<MenuItem> oldRecipeList, List<MenuItem> newRecipeList) {
        this.mOldMenuItemList = oldRecipeList;
        this.mNewMenuItemList = newRecipeList;
    }

    @Override
    public int getOldListSize() {
        return mOldMenuItemList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewMenuItemList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldMenuItemList.get(oldItemPosition).equals(mNewMenuItemList.get(
                newItemPosition));
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        final MenuItem oldRecipe = mOldMenuItemList.get(oldItemPosition);
        final MenuItem newRecipe = mNewMenuItemList.get(newItemPosition);

        return oldRecipe.equals(newRecipe);
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
