package jhonnyx.clean.marvel.di.module;

import android.content.Context;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import jhonnyx.clean.core.presentation.ui.fragment.LoadingDialogFragment;
import jhonnyx.clean.core.util.DialogHelper;
import jhonnyx.clean.marvel.MarvelApp;

/**
 * Created by jhonnybarrios on 01-09-17.
 */


@Module
public class AppModule{
    private MarvelApp application;

    public AppModule(MarvelApp application){
        this.application=application;
    }
    
    @Provides
    @Singleton
    public Context provideContext(){return  application;}

    @Provides
    public LoadingDialogFragment provideLoadingDialogFragment(){
        return new LoadingDialogFragment();
    } 

    @Provides
    public DialogHelper provideDialogHelper(){
        return new DialogHelper();
    }
}