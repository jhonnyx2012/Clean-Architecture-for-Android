package com.core.presentation.ui.adapter.holder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.StringRes;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public String getString(@StringRes int idString) {
        return itemView.getContext().getString(idString);
    }

    public int getColor(int idColor) {
        return getContext().getResources().getColor(idColor);
    }

    public Context getContext() {
        return itemView.getContext();
    }

    public Drawable getVectorDrawable(int id) {
        return VectorDrawableCompat.create(getContext().getResources(), id, getContext().getTheme());
    }

    public Drawable getDrawable(int id) {
        return getContext().getResources().getDrawable(id);
    }

    public void bind(int position, T item){}
}