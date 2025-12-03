import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.util.CoreMap;
import java.util.*;

/**
 * Sentiment Analysis using Java and Stanford CoreNLP
 * A GenAI application that analyzes sentiment of text
 */
public class SentimentAnalyzer {
    
    private StanfordCoreNLP pipeline;
    
    /**
     * Initialize the sentiment analyzer with Stanford CoreNLP pipeline.
     * 
     * Note: Pipeline initialization is expensive (~10-30 seconds). For production use,
     * consider implementing a singleton pattern or lazy initialization to avoid
     * repeated initialization overhead when multiple analyzer instances are needed.
     */
    public SentimentAnalyzer() {
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma,parse,sentiment");
        props.setProperty("parse.model", "edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz");
        this.pipeline = new StanfordCoreNLP(props);
    }
    
    /**
     * Analyze the sentiment of given text.
     * 
     * @param text The text to analyze
     * @return SentimentResult object containing sentiment information
     */
    public SentimentResult analyze(String text) {
        // Handle empty or whitespace-only text
        if (text == null || text.trim().isEmpty()) {
            return new SentimentResult(0.0, "Neutral");
        }
        
        Annotation annotation = pipeline.process(text);
        
        int totalSentiment = 0;
        int sentenceCount = 0;
        
        for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
            String sentiment = sentence.get(SentimentCoreAnnotations.SentimentClass.class);
            int sentimentValue = getSentimentValue(sentiment);
            totalSentiment += sentimentValue;
            sentenceCount++;
        }
        
        // Calculate average sentiment, defaulting to 0 (Neutral) if no sentences found
        double avgSentiment = sentenceCount > 0 ? (double) totalSentiment / sentenceCount : 0;
        String overallSentiment = mapSentimentValue(avgSentiment);
        
        return new SentimentResult(avgSentiment, overallSentiment);
    }
    
    /**
     * Convert Stanford sentiment string to numeric value.
     */
    private int getSentimentValue(String sentiment) {
        switch (sentiment.toLowerCase()) {
            case "very negative": return -2;
            case "negative": return -1;
            case "neutral": return 0;
            case "positive": return 1;
            case "very positive": return 2;
            default: return 0;
        }
    }
    
    /**
     * Map numeric sentiment value to category.
     */
    private String mapSentimentValue(double value) {
        if (value > 0.5) return "Positive";
        if (value < -0.5) return "Negative";
        return "Neutral";
    }
    
    /**
     * Analyze multiple texts in batch.
     * 
     * @param texts List of texts to analyze
     * @return List of sentiment results
     */
    public List<SentimentResult> batchAnalyze(List<String> texts) {
        List<SentimentResult> results = new ArrayList<>();
        for (String text : texts) {
            results.add(analyze(text));
        }
        return results;
    }
    
    /**
     * Inner class to store sentiment analysis results.
     */
    public static class SentimentResult {
        private double score;
        private String sentiment;
        
        public SentimentResult(double score, String sentiment) {
            this.score = score;
            this.sentiment = sentiment;
        }
        
        public double getScore() {
            return score;
        }
        
        public String getSentiment() {
            return sentiment;
        }
    }
    
    /**
     * Main method to demonstrate sentiment analysis.
     */
    public static void main(String[] args) {
        SentimentAnalyzer analyzer = new SentimentAnalyzer();
        
        // Sample texts for analysis
        List<String> sampleTexts = Arrays.asList(
            "I love this product! It's absolutely amazing and exceeded my expectations.",
            "This is the worst experience I've ever had. Completely disappointed.",
            "The item is okay. Nothing special but does the job.",
            "Artificial Intelligence is transforming how we work and live.",
            "I'm extremely happy with the customer service. They were very helpful!"
        );
        
        System.out.println("================================================================================");
        System.out.println("Java Sentiment Analysis - GenAI Example");
        System.out.println("================================================================================");
        System.out.println();
        
        for (int i = 0; i < sampleTexts.size(); i++) {
            String text = sampleTexts.get(i);
            SentimentResult result = analyzer.analyze(text);
            
            String displayText = text.length() > 60 ? text.substring(0, 60) + "..." : text;
            System.out.println("Text " + (i + 1) + ": " + displayText);
            System.out.println("  Sentiment: " + result.getSentiment());
            System.out.println("  Score: " + String.format("%.3f", result.getScore()) + " (range: -2 to 2)");
            System.out.println();
        }
        
        // Interactive mode
        if (args.length > 0) {
            String customText = String.join(" ", args);
            System.out.println("================================================================================");
            System.out.println("Custom Text Analysis:");
            System.out.println("================================================================================");
            SentimentResult result = analyzer.analyze(customText);
            System.out.println("Text: " + customText);
            System.out.println("  Sentiment: " + result.getSentiment());
            System.out.println("  Score: " + String.format("%.3f", result.getScore()));
        }
    }
}
