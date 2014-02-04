package pl.edu.agh.to.lab3;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import pl.edu.agh.to.lab3.dataprovider.DataProvider;
import pl.edu.agh.to.lab3.entity.News;
import pl.edu.agh.to.lab3.entity.Photo;

public class ApplicationTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private PrintStream originalOut;

    private TestDataProvider testDataProvider = new TestDataProvider();

    private Application application = new Application(testDataProvider);

    @Test
    public void testDisplayingPromotedNews() {
        testDataProvider.addNews("PromotedNews", System.currentTimeMillis());
        application.displayPromotedItems();
        assertContentIsDisplayed("PromotedNews");
    }

    @Test
    public void testDisplayingPromotedPhoto() {
        testDataProvider.addPhoto("http://photoUrl", true);
        application.displayPromotedItems();
        assertContentIsDisplayed("http://photoUrl");
    }

    @Test
    public void testNotDisplayingPromotedPhoto() {
        testDataProvider.addPhoto("http://photoUrl", false);
        application.displayPromotedItems();
        assertContentIsNotDisplayed("http://photoUrl");
    }

    @Test
    public void testNotDisplayingPromotedNews() {
        testDataProvider.addPhoto("http://photoUrl", true);
        testDataProvider.addNews("NotPromotedNews", 0);
        application.displayPromotedItems();
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

    private static class TestDataProvider implements DataProvider {

        private final Collection<Photo> photos = new ArrayList<Photo>();

        private final Collection<News> news = new ArrayList<News>();

        @Override
        public Collection<Photo> getAllPhotos() {
            return photos;
        }

        @Override
        public Collection<News> getAllNews() {
            return news;
        }

        private void addPhoto(String url, boolean promoted) {
            Photo testPhoto = new Photo(url, promoted);
            photos.add(testPhoto);
        }

        private void addNews(String newsInfo, long publicationTimestamp) {
            News testNews = new News(newsInfo, publicationTimestamp);
            news.add(testNews);
        }
    }
}
