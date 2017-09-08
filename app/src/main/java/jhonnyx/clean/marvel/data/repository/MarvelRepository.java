package jhonnyx.clean.marvel.data.repository;

import android.support.annotation.NonNull;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import jhonnyx.clean.marvel.data.remote.response.ComicDataWrapper;
import jhonnyx.clean.marvel.data.remote.ApiServiceFactory;
import jhonnyx.clean.marvel.data.repository.mapper.ComicEntityToComicMapper;
import jhonnyx.clean.marvel.domain.model.Comic;
import jhonnyx.clean.marvel.util.Utilities;

/**
 * Created by jhonnybarrios on 01-09-17.
 */

public class MarvelRepository implements IMarvelRepository {
    private final ApiServiceFactory apiServiceFactory;
    private final ComicEntityToComicMapper mapper;

    @Inject
    public MarvelRepository(@NonNull ApiServiceFactory apiServiceFactory,
                            @NonNull ComicEntityToComicMapper mapper) {
        this.apiServiceFactory=apiServiceFactory;
        this.mapper=mapper;
    }

    @Override
    public Observable<List<Comic>> getComics() {
        long timeStamp=new Date().getTime();
        String filter=null;
        int offset= Utilities.getNewRandom();
        return apiServiceFactory.get().getComics(Utilities.getHash(timeStamp),timeStamp,offset,filter)
                .map(new Function<ComicDataWrapper, List<Comic>>() {
                    @Override
                    public List<Comic> apply(ComicDataWrapper comicDataWrapper) throws Exception {
                        return mapper.map(comicDataWrapper.data.results);
                    }
                });
    }
}