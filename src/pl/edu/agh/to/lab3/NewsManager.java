package pl.edu.agh.to.lab3;

import java.util.ArrayList;
import java.util.Collection;


public class NewsManager {

    private final Collection<News> sampleNews = new ArrayList<News>();

    public NewsManager() {
        sampleNews.add(new News("Obsolete news", 0));
        sampleNews.add(new News("Newest news", System.currentTimeMillis()));
        sampleNews.add(new News("One hour news", System.currentTimeMillis() - 60000));
        sampleNews.add(new News("Two hour news", System.currentTimeMillis() - 120000));
        sampleNews.add(new News("Another two hour news", System.currentTimeMillis() - 120000));
        sampleNews.add(new News("Another obsolete news", 100));
        sampleNews.add(new News("Super fresh news", System.currentTimeMillis() - 10));
    }


    public Collection<News> getAllNews() {
        return sampleNews;
    }

    public static String renderNI(News news) {
        return "News: " + news.information;
    }
}
