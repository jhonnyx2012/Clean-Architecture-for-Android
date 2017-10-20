package jhonnyx.clean.marvel.presentation.presenter.contract;

import android.support.annotation.StringRes;

import com.core.presentation.presenter.contracts.BaseViewPresenter;
import com.core.presentation.presenter.contracts.IProgressView;

import java.util.List;
import jhonnyx.clean.marvel.domain.model.Comic;

/**
 * Created by jhonnybarrios on 08-09-17.
 */

public interface IComic {
    interface Presenter extends BaseViewPresenter<View> {
        void onRefreshComics();
    }

    interface View extends IProgressView {
        void setComicList(List<Comic> comicList);
        void showMessageError(@StringRes int idString);
    }
}