package jhonnyx.clean.marvel;

import android.app.Application;
import android.content.Context;
import jhonnyx.clean.marvel.di.component.AppComponent;
import jhonnyx.clean.marvel.di.component.DaggerAppComponent;
import jhonnyx.clean.marvel.di.module.AppModule;

/**
 * Created by jhonnybarrios on 01-09-17.
 */

public class MarvelApp extends Application {

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = initDagger(this);
    }

    private AppComponent initDagger(MarvelApp application) {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }

    public static MarvelApp getApp(Context context){
        return (MarvelApp) context.getApplicationContext();
    }

    public AppComponent getCompoment() {
        return component;
    }
}
