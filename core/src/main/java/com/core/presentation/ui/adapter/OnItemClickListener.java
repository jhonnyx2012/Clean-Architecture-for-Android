package com.core.presentation.ui.adapter;

import android.support.v7.widget.RecyclerView;

/**
 * Created by jhonnybarrios on 10/20/17.
 */

public abstract class OnItemClickListener<T>{
    public void onItemClick(RecyclerView.ViewHolder holder, int adapterPosition, T item){
        onItemClick(adapterPosition,item);
    }

    public abstract void onItemClick(int adapterPosition, T item);
}
