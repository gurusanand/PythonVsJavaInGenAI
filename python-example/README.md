# Python Sentiment Analysis Example

This is a Python implementation of a sentiment analysis tool using the TextBlob library, which provides a simple API for Natural Language Processing (NLP) tasks.

## Features

- Sentiment polarity analysis (positive, negative, neutral)
- Subjectivity scoring
- Batch text analysis
- Command-line interface

## Setup

1. Install Python 3.7 or higher
2. Install dependencies:
   ```bash
   pip install -r requirements.txt
   ```

3. Download required NLP corpora (first time only):
   ```bash
   python -m textblob.download_corpora
   ```

## Usage

### Run with default examples:
```bash
python sentiment_analyzer.py
```

### Analyze custom text:
```bash
python sentiment_analyzer.py "Your custom text here"
```

### Run tests:
```bash
python -m unittest test_sentiment_analyzer -v
```

## Example Output

```
Text 1: I love this product! It's absolutely amazing...
  Sentiment: Positive
  Polarity: 0.650 (range: -1 to 1)
  Subjectivity: 0.850 (range: 0 to 1)
```

## Key Python Advantages for GenAI

- **Rich Ecosystem**: Extensive libraries (TextBlob, NLTK, spaCy, transformers)
- **Simplicity**: Concise, readable code
- **Rapid Development**: Quick prototyping and iteration
- **Community**: Large AI/ML community and resources
