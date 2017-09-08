package jhonnyx.clean.marvel.di.module;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import jhonnyx.clean.marvel.data.remote.ApiServiceFactory;
import jhonnyx.clean.marvel.data.repository.IMarvelRepository;
import jhonnyx.clean.marvel.data.repository.MarvelRepository;
import jhonnyx.clean.marvel.data.repository.mapper.ComicEntityToComicMapper;
import okhttp3.OkHttpClient;

/**
 * Created by jhonnybarrios on 01-09-17.
 */

@Module
public class NetworkModule {
    @Provides
    @Singleton
    public ApiServiceFactory provideApiFactory(OkHttpClient okHttpClient){
        return new ApiServiceFactory(okHttpClient);
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(){
        return new OkHttpClient();
    }

    @Provides
    @Singleton
    public IMarvelRepository providePPNApiRepository(ApiServiceFactory apiServiceFactory, ComicEntityToComicMapper mapper){
        return new MarvelRepository(apiServiceFactory, mapper);
    }
}