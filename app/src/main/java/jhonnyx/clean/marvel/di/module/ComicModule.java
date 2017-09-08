package jhonnyx.clean.marvel.di.module;

import android.content.Context;
import android.support.v7.widget.StaggeredGridLayoutManager;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import jhonnyx.clean.marvel.domain.usecase.GetComicsUseCase;
import jhonnyx.clean.marvel.presentation.presenter.ComicsPresenter;
import jhonnyx.clean.marvel.presentation.presenter.contract.IComic;
import jhonnyx.clean.marvel.presentation.ui.adapter.ComicAdapter;

/**
 * Created by jhonnybarrios on 01-09-17.
 */

@Module
public class ComicModule {
    @Provides
    @Singleton
    public IComic.Presenter provideComicPresenter(GetComicsUseCase getUseCase){
        return new ComicsPresenter(getUseCase);
    }

    @Provides
    @Singleton
    public ComicAdapter provideComicAdapter(Context context){
        return new ComicAdapter(context);
    }

    @Provides
    @Singleton
    public StaggeredGridLayoutManager provideStaggeredGridLayoutManager(){
        return new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
    }
}