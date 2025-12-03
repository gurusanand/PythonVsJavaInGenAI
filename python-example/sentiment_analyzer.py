"""
Sentiment Analysis using Python
A simple GenAI application that analyzes sentiment of text using TextBlob
"""

from textblob import TextBlob
import sys


class SentimentAnalyzer:
    """
    A class to analyze sentiment of text using TextBlob library.
    """
    
    def __init__(self):
        """Initialize the sentiment analyzer."""
        pass
    
    def analyze(self, text):
        """
        Analyze the sentiment of the given text.
        
        Args:
            text (str): The text to analyze
            
        Returns:
            dict: A dictionary containing polarity, subjectivity, and sentiment
        """
        blob = TextBlob(text)
        polarity = blob.sentiment.polarity
        subjectivity = blob.sentiment.subjectivity
        
        # Determine sentiment category
        if polarity > 0.1:
            sentiment = "Positive"
        elif polarity < -0.1:
            sentiment = "Negative"
        else:
            sentiment = "Neutral"
        
        return {
            "polarity": polarity,
            "subjectivity": subjectivity,
            "sentiment": sentiment
        }
    
    def batch_analyze(self, texts):
        """
        Analyze sentiment for multiple texts.
        
        Args:
            texts (list): List of texts to analyze
            
        Returns:
            list: List of sentiment analysis results
        """
        return [self.analyze(text) for text in texts]


def main():
    """Main function to demonstrate sentiment analysis."""
    analyzer = SentimentAnalyzer()
    
    # Sample texts for analysis
    sample_texts = [
        "I love this product! It's absolutely amazing and exceeded my expectations.",
        "This is the worst experience I've ever had. Completely disappointed.",
        "The item is okay. Nothing special but does the job.",
        "Artificial Intelligence is transforming how we work and live.",
        "I'm extremely happy with the customer service. They were very helpful!"
    ]
    
    print("=" * 80)
    print("Python Sentiment Analysis - GenAI Example")
    print("=" * 80)
    print()
    
    for i, text in enumerate(sample_texts, 1):
        result = analyzer.analyze(text)
        print(f"Text {i}: {text[:60]}...")
        print(f"  Sentiment: {result['sentiment']}")
        print(f"  Polarity: {result['polarity']:.3f} (range: -1 to 1)")
        print(f"  Subjectivity: {result['subjectivity']:.3f} (range: 0 to 1)")
        print()
    
    # Interactive mode
    if len(sys.argv) > 1:
        custom_text = " ".join(sys.argv[1:])
        print("=" * 80)
        print("Custom Text Analysis:")
        print("=" * 80)
        result = analyzer.analyze(custom_text)
        print(f"Text: {custom_text}")
        print(f"  Sentiment: {result['sentiment']}")
        print(f"  Polarity: {result['polarity']:.3f}")
        print(f"  Subjectivity: {result['subjectivity']:.3f}")


if __name__ == "__main__":
    main()
