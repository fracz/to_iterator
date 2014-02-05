package pl.edu.agh.to.lab3;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import pl.edu.agh.to.lab3.News;

public class NewsTest {
    @Test
    public void testNewsPromotion() {
        News news = new News("Some info", System.currentTimeMillis());
        assertTrue(news.isPromoted());
    }

    @Test
    public void testNewsIsNotPromotedAfterTwoDays() {
        long twoDaysAgo = System.currentTimeMillis() - 2 * 24 * 60 * 60 * 1000;
        News news = new News("Some info", twoDaysAgo);
        assertFalse(news.isPromoted());
    }
}
