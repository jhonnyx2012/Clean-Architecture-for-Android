package jhonnyx.clean.marvel.presentation.ui.activity;

import android.support.annotation.StringRes;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.core.presentation.ui.activity.BaseLoadingActivity;

import java.util.List;
import javax.inject.Inject;
import butterknife.BindView;
import jhonnyx.clean.marvel.MarvelApp;
import jhonnyx.clean.marvel.R;
import jhonnyx.clean.marvel.domain.model.Comic;
import jhonnyx.clean.marvel.presentation.presenter.contract.IComic;
import jhonnyx.clean.marvel.presentation.ui.adapter.ComicAdapter;
import jhonnyx.clean.marvel.presentation.ui.adapter.OnItemClickListener;
import jhonnyx.clean.marvel.util.Utilities;

public class ComicsActivity extends BaseLoadingActivity implements IComic.View,SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.list) RecyclerView list;
    @BindView(R.id.swipeRefreshLayout) SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.message) TextView tvMessage;
    @Inject ComicAdapter adapter;
    @Inject StaggeredGridLayoutManager layoutManager;
    @Inject IComic.Presenter presenter;

    @Override protected int getLayout() {return R.layout.activity_comics;}

    @Override public void injectDependencies() {
        MarvelApp.getApp(this).getCompoment().inject(this);
    }

    @Override public void initView() {
        getSupportActionBar().setTitle("");
        initSwipeRefreshView();
        initList();
        presenter.initialize(this);
    }

    private void initList() {
        adapter.setItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(Comic item) {
                Utilities.openURL(item.webUrl,ComicsActivity.this);
            }
        });
        list.setLayoutManager(layoutManager);
        list.setAdapter(adapter);
    }

    private void initSwipeRefreshView() {
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override public void onRefresh() {
        presenter.onRefreshComics();
    }

    @Override public void showProgress(boolean show) {
        if(show && !swipeRefreshLayout.isRefreshing())
            swipeRefreshLayout.setRefreshing(true);
        if(!show && swipeRefreshLayout.isRefreshing())
            swipeRefreshLayout.setRefreshing(false);
    }

    @Override public void setComicList(List<Comic> comicList) {
        adapter.setList(comicList);
        list.setVisibility(View.VISIBLE);
    }

    @Override public void showMessageError(@StringRes int idString) {
        list.setVisibility(View.GONE);
        tvMessage.setText(idString);
    }
}