package pl.edu.agh.to.lab3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NewsManagerTest {

    private NewsManager newsManager = new NewsManager();

    @Test
    public void testThereAreThreeCategories() {
        assertEquals(3, newsManager.getAllCategories().size());
    }
}
