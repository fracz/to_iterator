package pl.edu.agh.to.lab3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class NewsManager {

    private final Map<String, Collection<News>> sampleNews = new HashMap<String, Collection<News>>();

    public NewsManager() {
        addSampleNews("General", new News("Obsolete news", 0));
        addSampleNews("General", new News("Newest news", System.currentTimeMillis()));
        addSampleNews("General", new News("One hour news", System.currentTimeMillis() - 60000));
        addSampleNews("Category One", new News("Two hour news", System.currentTimeMillis() - 120000));
        addSampleNews("Category One", new News("Another two hour news", System.currentTimeMillis() - 120000));
        addSampleNews("Yet another category", new News("Another obsolete news", 100));
        addSampleNews("Yet another category", new News("Super fresh news", System.currentTimeMillis() - 10));
    }

    public Map<String, Collection<News>> getAllNews() {
        return sampleNews;
    }

    public Collection<String> getAllCategories() {
        return sampleNews.keySet();
    }

    private void addSampleNews(String category, News news) {
        if (!sampleNews.containsKey(category))
            sampleNews.put(category, new ArrayList<News>());
        sampleNews.get(category).add(news);
    }

    public static String renderNI(News news) {
        return "News: " + news.information;
    }
}
