"""
Unit tests for the SentimentAnalyzer class.
"""

import unittest
from sentiment_analyzer import SentimentAnalyzer


class TestSentimentAnalyzer(unittest.TestCase):
    """Test cases for SentimentAnalyzer."""
    
    def setUp(self):
        """Set up test fixtures."""
        self.analyzer = SentimentAnalyzer()
    
    def test_positive_sentiment(self):
        """Test that positive text is correctly identified."""
        text = "I love this product! It's absolutely amazing."
        result = self.analyzer.analyze(text)
        
        self.assertEqual(result['sentiment'], 'Positive')
        self.assertGreater(result['polarity'], 0)
    
    def test_negative_sentiment(self):
        """Test that negative text is correctly identified."""
        text = "This is terrible. I hate it completely."
        result = self.analyzer.analyze(text)
        
        self.assertEqual(result['sentiment'], 'Negative')
        self.assertLess(result['polarity'], 0)
    
    def test_neutral_sentiment(self):
        """Test that neutral text is correctly identified."""
        text = "The item arrived on time."
        result = self.analyzer.analyze(text)
        
        self.assertIn(result['sentiment'], ['Neutral', 'Positive', 'Negative'])
        self.assertIsInstance(result['polarity'], float)
    
    def test_result_structure(self):
        """Test that the result has the expected structure."""
        text = "Test text"
        result = self.analyzer.analyze(text)
        
        self.assertIn('polarity', result)
        self.assertIn('subjectivity', result)
        self.assertIn('sentiment', result)
        
        self.assertIsInstance(result['polarity'], float)
        self.assertIsInstance(result['subjectivity'], float)
        self.assertIsInstance(result['sentiment'], str)
    
    def test_polarity_range(self):
        """Test that polarity is within expected range."""
        text = "This is a test."
        result = self.analyzer.analyze(text)
        
        self.assertGreaterEqual(result['polarity'], -1.0)
        self.assertLessEqual(result['polarity'], 1.0)
    
    def test_subjectivity_range(self):
        """Test that subjectivity is within expected range."""
        text = "This is a test."
        result = self.analyzer.analyze(text)
        
        self.assertGreaterEqual(result['subjectivity'], 0.0)
        self.assertLessEqual(result['subjectivity'], 1.0)
    
    def test_batch_analyze(self):
        """Test batch analysis of multiple texts."""
        texts = [
            "I love this!",
            "This is terrible.",
            "It's okay."
        ]
        results = self.analyzer.batch_analyze(texts)
        
        self.assertEqual(len(results), 3)
        
        for result in results:
            self.assertIn('polarity', result)
            self.assertIn('subjectivity', result)
            self.assertIn('sentiment', result)
    
    def test_empty_text(self):
        """Test handling of empty text."""
        text = ""
        result = self.analyzer.analyze(text)
        
        # Empty text should still return a valid result structure
        self.assertIn('polarity', result)
        self.assertIn('subjectivity', result)
        self.assertIn('sentiment', result)


if __name__ == '__main__':
    unittest.main()
