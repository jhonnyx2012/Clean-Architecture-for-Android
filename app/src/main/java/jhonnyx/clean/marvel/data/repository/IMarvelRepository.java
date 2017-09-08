package jhonnyx.clean.marvel.data.repository;

import java.util.List;
import io.reactivex.Observable;
import jhonnyx.clean.marvel.domain.model.Comic;

/**
 * Created by jhonnybarrios on 01-09-17.
 */

public interface IMarvelRepository {
    Observable<List<Comic>> getComics();
}