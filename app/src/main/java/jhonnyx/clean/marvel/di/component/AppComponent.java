package jhonnyx.clean.marvel.di.component;

/**
 * Created by jhonnybarrios on 01-09-17.
 */
import javax.inject.Singleton;
import dagger.Component;
import jhonnyx.clean.marvel.di.module.AppModule;
import jhonnyx.clean.marvel.di.module.ComicModule;
import jhonnyx.clean.marvel.di.module.NetworkModule;
import jhonnyx.clean.marvel.presentation.ui.activity.ComicsActivity;

@Singleton
@Component(modules ={AppModule.class, NetworkModule.class, ComicModule.class})
public interface AppComponent {
    /**
     * Indica que ComicsActivity requiere inyección desde este componente
     * @param target ComicsActivity
     */
    void inject(ComicsActivity target);
}