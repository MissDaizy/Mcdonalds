package com.diana_ukrainsky.mcdonalds.ui.menu_item_list.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.diana_ukrainsky.mcdonalds.data.model.MenuItem;
import com.diana_ukrainsky.mcdonalds.databinding.MenuListItemBinding;
import com.diana_ukrainsky.mcdonalds.ui.callback.CustomItemClickListener;
import com.diana_ukrainsky.mcdonalds.ui.callback.MenuItemDiffCallback;

import java.util.ArrayList;
import java.util.List;

public class MenuItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private MenuListItemBinding menuListItemBinding;
    private List<MenuItem> menuItemList;
    private CustomItemClickListener customItemClickListener;

    private Context context;

    private static final int RECIPE_IMAGE_WIDTH=1000;
    private static final int RECIPE_IMAGE_HEIGHT=1000;

    public MenuItemAdapter(Context context) {
        this.customItemClickListener= (CustomItemClickListener) context;
        this.menuItemList = new ArrayList<>();
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        menuListItemBinding = MenuListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(menuListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MenuItem menuItem = menuItemList.get(position);

        MyViewHolder myViewHolder = (MyViewHolder) holder;
        setListeners(myViewHolder,menuItem);
        myViewHolder.menuListItemBinding.menuListItemTXTTitle.setText(menuItem.getItem());
        myViewHolder.menuListItemBinding.menuListItemTXTCalories.setText(""+menuItem.getCalories());
    }

    private void setListeners(MyViewHolder myViewHolder, MenuItem menuItem) {
        myViewHolder.menuListItemBinding.menuListItemCVMenuItemCard.setOnClickListener(v->{
            customItemClickListener.onClick(menuItem);
        });
    }

    @Override
    public int getItemCount() {
        return menuItemList.size();
    }

    public void updateRecipeListItems(List<MenuItem> menuItems) {
        final MenuItemDiffCallback diffCallback = new MenuItemDiffCallback(this.menuItemList, menuItems);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);

        this.menuItemList.clear();
        this.menuItemList.addAll(menuItems);
        this.notifyDataSetChanged();
        diffResult.dispatchUpdatesTo(this);
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        private MenuListItemBinding menuListItemBinding;

        public MyViewHolder(MenuListItemBinding menuListItemBinding) {
            super(menuListItemBinding.getRoot());
            this.menuListItemBinding = menuListItemBinding;

        }
    }
}
