import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for SentimentAnalyzer class.
 */
public class SentimentAnalyzerTest {
    
    private SentimentAnalyzer analyzer;
    
    @BeforeEach
    public void setUp() {
        analyzer = new SentimentAnalyzer();
    }
    
    @Test
    public void testPositiveSentiment() {
        String text = "I love this product! It's absolutely amazing.";
        SentimentAnalyzer.SentimentResult result = analyzer.analyze(text);
        
        assertEquals("Positive", result.getSentiment());
        assertTrue(result.getScore() > 0);
    }
    
    @Test
    public void testNegativeSentiment() {
        String text = "This is terrible. I hate it completely.";
        SentimentAnalyzer.SentimentResult result = analyzer.analyze(text);
        
        assertEquals("Negative", result.getSentiment());
        assertTrue(result.getScore() < 0);
    }
    
    @Test
    public void testResultStructure() {
        String text = "Test text";
        SentimentAnalyzer.SentimentResult result = analyzer.analyze(text);
        
        assertNotNull(result);
        assertNotNull(result.getSentiment());
        assertTrue(result.getScore() >= -2.0 && result.getScore() <= 2.0);
    }
    
    @Test
    public void testScoreRange() {
        String text = "This is a test.";
        SentimentAnalyzer.SentimentResult result = analyzer.analyze(text);
        
        assertTrue(result.getScore() >= -2.0);
        assertTrue(result.getScore() <= 2.0);
    }
    
    @Test
    public void testBatchAnalyze() {
        java.util.List<String> texts = java.util.Arrays.asList(
            "I love this!",
            "This is terrible.",
            "It's okay."
        );
        
        java.util.List<SentimentAnalyzer.SentimentResult> results = analyzer.batchAnalyze(texts);
        
        assertEquals(3, results.size());
        
        for (SentimentAnalyzer.SentimentResult result : results) {
            assertNotNull(result.getSentiment());
            assertTrue(result.getScore() >= -2.0 && result.getScore() <= 2.0);
        }
    }
    
    @Test
    public void testEmptyText() {
        String text = "";
        SentimentAnalyzer.SentimentResult result = analyzer.analyze(text);
        
        // Empty text should still return a valid result structure
        assertNotNull(result);
        assertNotNull(result.getSentiment());
    }
}
