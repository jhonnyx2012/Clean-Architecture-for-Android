package jhonnyx.clean.marvel.presentation.presenter;

import android.support.annotation.NonNull;

import com.core.domain.usecase.UseCaseObserver;

import java.util.List;
import javax.inject.Inject;
import jhonnyx.clean.marvel.R;
import jhonnyx.clean.marvel.domain.model.Comic;
import jhonnyx.clean.marvel.domain.usecase.GetComicsUseCase;
import jhonnyx.clean.marvel.presentation.presenter.contract.IComic;

/**
 * Created by jhonnybarrios on 08-09-17.
 */

public class ComicsPresenter implements IComic.Presenter{
    private final GetComicsUseCase getUseCase;
    private IComic.View view;

    @Inject public ComicsPresenter(@NonNull GetComicsUseCase getUseCase) {
        this.getUseCase=getUseCase;
    }

    @Override public void initialize(IComic.View view) {
        this.view=view;
        onRefreshComics();
    }

    @Override public void onRefreshComics() {
        view.showProgress(true);
        getUseCase.execute(new UseCaseObserver<List<Comic>>() {
            @Override
            public void onNext(List<Comic> result) {
                if(result.isEmpty())
                    view.showMessageError(R.string.message_no_results);
                else
                    view.setComicList(result);
                view.showProgress(false);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                view.showProgress(false);
                view.showMessageError(R.string.message_problem);
            }
        });
    }
}
