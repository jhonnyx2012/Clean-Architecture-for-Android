package jhonnyx.clean.marvel.data.entity;

import java.util.ArrayList;

public class ComicEntity {
    public int id;
    public String title;
    public String description;
    public int pageCount;
    public String thumbnailUrl;
    public String price;
    public String date;
    public String webUrl;
    public String jsonCharacters;
    public String jsonCreators;
    public String jsonSeries;
    public Thumbnail thumbnail;
    public ArrayList<Url> urls;
    public Resource series;
    public ArrayList<Date> dates;
    public ArrayList<Price> prices;
    public Collection creators;
    public Collection characters;
}