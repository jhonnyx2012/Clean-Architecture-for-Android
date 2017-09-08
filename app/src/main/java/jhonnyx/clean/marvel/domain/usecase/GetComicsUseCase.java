package jhonnyx.clean.marvel.domain.usecase;

import android.support.annotation.NonNull;

import com.papinotas.core.domain.usecase.UseCase;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import jhonnyx.clean.marvel.data.repository.IMarvelRepository;
import jhonnyx.clean.marvel.domain.model.Comic;

/**
 * Created by jhonnybarrios on 08-09-17.
 */

public class GetComicsUseCase extends UseCase<List<Comic>> {

    private final IMarvelRepository repository;

    @Inject
    public GetComicsUseCase(@NonNull IMarvelRepository repository) {
        this.repository=repository;
    }

    @NotNull
    @Override
    protected Observable<List<Comic>> createObservableUseCase() {
        return repository.getComics();
    }
}