package jhonnyx.clean.marvel.data.repository.mapper;

import java.util.ArrayList;
import javax.inject.Inject;
import jhonnyx.clean.core.data.repository.mapper.Mapper;
import jhonnyx.clean.marvel.data.entity.ComicEntity;
import jhonnyx.clean.marvel.data.entity.Url;
import jhonnyx.clean.marvel.domain.model.Comic;

/**
 * Created by jhonnybarrios on 08-09-17.
 */

public class ComicEntityToComicMapper extends Mapper<ComicEntity, Comic>{

    @Inject
    ComicEntityToComicMapper() {}

    @Override
    public Comic map(ComicEntity value) {
        Comic comic = new Comic();
        comic.id=value.id;
        comic.price=getPrice(value);
        comic.thumbnailUrl=getThumbnailUrl(value);
        comic.title=value.title;
        comic.webUrl=getWebUrl(value);
        return comic;
    }

    private String getThumbnailUrl(ComicEntity value) {
        if(value.thumbnailUrl==null)
            return value.thumbnail.path+"."+value.thumbnail.extension;
        return value.thumbnailUrl;
    }

    private String getPrice(ComicEntity value) {
        if(value.price!=null)return value.price;
        String printPrice=(value.prices == null || value.prices.size() == 0)?
                null:value.prices.get(0).price;
        return printPrice==null||printPrice.equals("0")?"Bushed":"$"+printPrice;
    }

    private String getWebUrl(ComicEntity value) {
        String webUrl=value.webUrl;
        if(webUrl==null) {
            ArrayList<Url> urls=value.urls;
            webUrl=(urls == null || urls.size() == 0)?null:urls.get(0).url;
        }
        return webUrl;
    }

    @Override
    public ComicEntity reverseMap(Comic value) {
        throw new UnsupportedOperationException();
    }
}
