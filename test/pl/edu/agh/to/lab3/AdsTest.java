package pl.edu.agh.to.lab3;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AdsTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private PrintStream originalOut;

    private Collection<Photo> allPhotos = new ArrayList<Photo>();

    private Map<String, Collection<News>> allNews = new HashMap<String, Collection<News>>();

    private Ads advertismentBox = new Ads(allPhotos, allNews);

    @Test
    public void testDisplayingPromotedNews() {
        addNews("Sample", new News("PromotedNews", System.currentTimeMillis()));
        advertismentBox.displayPromotedItems();
        assertContentIsDisplayed("PromotedNews");
    }

    @Test
    public void testDisplayingPromotedPhoto() {
        allPhotos.add(new Photo("http://photoUrl", true));
        advertismentBox.displayPromotedItems();
        assertContentIsDisplayed("http://photoUrl");
    }

    @Test
    public void testNotDisplayingPromotedPhoto() {
        allPhotos.add(new Photo("http://photoUrl", false));
        advertismentBox.displayPromotedItems();
        assertContentIsNotDisplayed("http://photoUrl");
    }

    @Test
    public void testNotDisplayingPromotedNews() {
        allPhotos.add(new Photo("http://photoUrl", true));
        addNews("Sample", new News("NotPromotedNews", 0));
        advertismentBox.displayPromotedItems();
        assertContentIsNotDisplayed("NotPromotedNews");
    }

    private void assertContentIsDisplayed(String expectedContent) {
        assertTrue("Application did not contain expected content: " + expectedContent, outContent.toString().contains(expectedContent));
    }

    private void assertContentIsNotDisplayed(String expectedContent) {
        assertFalse("Application did contain expected content although it should not: " + expectedContent,
                outContent.toString().contains(expectedContent));
    }

    @Before
    public void redirectSystemOut() {
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void resetSystemOut() {
        System.setOut(originalOut);
    }

    private void addNews(String category, News news) {
        if (!allNews.containsKey(category))
            allNews.put(category, new ArrayList<News>());
        allNews.get(category).add(news);
    }
}
