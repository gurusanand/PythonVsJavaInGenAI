# Quick Start Guide

This guide will help you quickly run and compare both Python and Java implementations.

## Prerequisites

### For Python Example
- Python 3.7 or higher
- pip (Python package manager)

### For Java Example
- Java 11 or higher (Java 17 recommended)
- Maven 3.6 or higher

## Step-by-Step Instructions

### Running the Python Example

1. **Navigate to the Python example directory:**
   ```bash
   cd python-example
   ```

2. **Install dependencies:**
   ```bash
   pip install -r requirements.txt
   ```

3. **Download required NLP corpora (first time only):**
   ```bash
   python -m textblob.download_corpora
   ```

4. **Run the sentiment analyzer:**
   ```bash
   python sentiment_analyzer.py
   ```

5. **Try with custom text:**
   ```bash
   python sentiment_analyzer.py "I absolutely love this comparison project!"
   ```

### Running the Java Example

1. **Navigate to the Java example directory:**
   ```bash
   cd java-example
   ```

2. **Compile and install dependencies:**
   ```bash
   mvn clean install
   ```
   
   *Note: First run will download dependencies (approximately 500MB for Stanford CoreNLP models).*

3. **Run the sentiment analyzer:**
   ```bash
   mvn exec:java -Dexec.mainClass="SentimentAnalyzer"
   ```

4. **Try with custom text:**
   ```bash
   mvn exec:java -Dexec.mainClass="SentimentAnalyzer" -Dexec.args="I absolutely love this comparison project!"
   ```

## What to Observe

When running both examples, pay attention to:

1. **Setup Time**: How long it takes to set up and install dependencies
2. **Execution Speed**: How quickly the analysis completes
3. **Code Readability**: Compare the source code files
4. **Output Quality**: Compare the sentiment analysis results

## Expected Output

Both implementations will show:
- Sentiment classification (Positive/Negative/Neutral)
- Numerical sentiment scores
- Analysis of multiple sample texts

### Python Output Example
```
================================================================================
Python Sentiment Analysis - GenAI Example
================================================================================

Text 1: I love this product! It's absolutely amazing and exceeded my...
  Sentiment: Positive
  Polarity: 0.613 (range: -1 to 1)
  Subjectivity: 0.750 (range: 0 to 1)
```

### Java Output Example
```
================================================================================
Java Sentiment Analysis - GenAI Example
================================================================================

Text 1: I love this product! It's absolutely amazing and exceeded my...
  Sentiment: Positive
  Score: 1.500 (range: -2 to 2)
```

## Troubleshooting

### Python Issues

**Problem:** `ModuleNotFoundError: No module named 'textblob'`
**Solution:** Run `pip install -r requirements.txt`

**Problem:** `LookupError: Resource 'corpora/brown' not found`
**Solution:** Run `python -m textblob.download_corpora`

### Java Issues

**Problem:** `JAVA_HOME not set`
**Solution:** Set JAVA_HOME environment variable:
```bash
export JAVA_HOME=/path/to/java
```

**Problem:** Maven build fails
**Solution:** Ensure you have Java 11 or higher:
```bash
java -version
```

**Problem:** OutOfMemoryError during execution
**Solution:** Increase Maven memory:
```bash
export MAVEN_OPTS="-Xmx2g"
```

## Next Steps

After running both examples:
1. Review the source code in both implementations
2. Read the [detailed comparison](COMPARISON.md)
3. Consider which approach fits your project needs
4. Experiment by modifying the sample texts

## Performance Notes

- **Python**: Faster setup (seconds), good for rapid prototyping
- **Java**: Longer initial setup (minutes for first run), but better runtime performance

Both implementations achieve similar accuracy in sentiment analysis, demonstrating that the choice between Python and Java often comes down to project requirements rather than capability.
