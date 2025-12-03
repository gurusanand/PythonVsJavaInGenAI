# Architecture Overview

This document explains the architecture and design decisions for both Python and Java implementations.

## System Architecture

Both implementations follow a similar high-level architecture:

```
User Input → Sentiment Analyzer → NLP Library → Results Output
```

### Component Breakdown

1. **User Interface Layer**
   - Command-line interface (CLI)
   - Accepts text input (single or batch)
   - Displays formatted results

2. **Sentiment Analyzer Layer**
   - `SentimentAnalyzer` class (both implementations)
   - Orchestrates the sentiment analysis process
   - Provides methods: `analyze()` and `batch_analyze()`

3. **NLP Processing Layer**
   - **Python**: TextBlob (simplified wrapper around NLTK)
   - **Java**: Stanford CoreNLP (comprehensive NLP suite)

4. **Results Layer**
   - **Python**: Dictionary with polarity, subjectivity, sentiment
   - **Java**: SentimentResult object with score and sentiment

## Implementation Comparison

### Python Architecture

```
sentiment_analyzer.py
├── SentimentAnalyzer class
│   ├── __init__()
│   ├── analyze(text) → dict
│   └── batch_analyze(texts) → list[dict]
└── main() function
    └── CLI interface

Dependencies:
└── TextBlob
    └── NLTK (indirect)
```

**Key Features:**
- Simple, flat structure
- Duck typing (no explicit interfaces)
- Dictionary-based return values
- Minimal boilerplate

### Java Architecture

```
SentimentAnalyzer.java
├── SentimentAnalyzer class
│   ├── StanfordCoreNLP pipeline
│   ├── analyze(String) → SentimentResult
│   ├── batchAnalyze(List<String>) → List<SentimentResult>
│   ├── getSentimentValue(String) → int
│   └── mapSentimentValue(double) → String
├── SentimentResult inner class
│   ├── score: double
│   ├── sentiment: String
│   └── getters
└── main(String[]) method
    └── CLI interface

Dependencies:
└── Stanford CoreNLP
    ├── Models
    └── Pipeline components
```

**Key Features:**
- Structured, object-oriented design
- Strong typing with explicit classes
- Custom result objects
- More helper methods for processing

## Design Patterns

### Python Implementation

**Pattern**: Facade Pattern
- TextBlob acts as a simple facade over complex NLTK functionality
- Single-responsibility classes

**Pattern**: Strategy Pattern (implicit)
- Different analysis strategies can be swapped by changing the underlying library

### Java Implementation

**Pattern**: Builder Pattern
- StanfordCoreNLP uses properties for pipeline configuration
- Flexible, extensible setup

**Pattern**: Value Object Pattern
- SentimentResult is an immutable value object
- Encapsulates related data

**Pattern**: Facade Pattern
- SentimentAnalyzer provides a simplified interface to CoreNLP complexity

## Data Flow

### Python Data Flow

```
Text Input
    ↓
SentimentAnalyzer.analyze()
    ↓
TextBlob(text)
    ↓
blob.sentiment → (polarity, subjectivity)
    ↓
Sentiment Classification Logic
    ↓
Return dict{polarity, subjectivity, sentiment}
```

### Java Data Flow

```
Text Input
    ↓
SentimentAnalyzer.analyze()
    ↓
pipeline.process(text) → Annotation
    ↓
Iterate sentences → Extract sentiment values
    ↓
Average sentiment calculation
    ↓
Map to sentiment category
    ↓
Return SentimentResult(score, sentiment)
```

## Error Handling

### Python
- Relies on Python's exception handling
- TextBlob handles most edge cases internally
- Minimal explicit error handling needed

### Java
- Potential NullPointerException handling needed
- More verbose error checking
- Pipeline initialization errors possible

## Performance Considerations

### Python
- **Startup Time**: Fast (~1 second)
- **First Request**: Medium (library initialization)
- **Subsequent Requests**: Fast
- **Memory Usage**: Low to Medium
- **Concurrency**: Limited by GIL

### Java
- **Startup Time**: Slow (~10-30 seconds for CoreNLP)
- **First Request**: Slow (model loading)
- **Subsequent Requests**: Very Fast
- **Memory Usage**: High (JVM + models ~1-2GB)
- **Concurrency**: Excellent (true multi-threading)

## Scalability Analysis

### Python Scalability
- **Horizontal**: Good (multiple processes)
- **Vertical**: Limited (GIL constraint)
- **Best For**: 
  - Multiple independent instances
  - Async I/O patterns
  - Microservices architecture

### Java Scalability
- **Horizontal**: Excellent
- **Vertical**: Excellent (multi-threading)
- **Best For**:
  - High-throughput applications
  - Shared memory multi-threading
  - Enterprise load balancing

## Testing Strategy

### Python Tests
- unittest framework (built-in)
- Focus on behavior verification
- Easy to mock and patch
- Fast test execution

### Java Tests
- JUnit 5 framework
- Focus on contract verification
- Type-safe assertions
- Longer test setup time

## Extensibility

### Adding New Features

**Python Approach:**
```python
# Easy to extend with new methods
def analyze_emotions(self, text):
    # New functionality
    pass
```

**Java Approach:**
```java
// Extend with new methods, maintaining type safety
public EmotionResult analyzeEmotions(String text) {
    // New functionality
}
```

Both approaches support inheritance and composition, but:
- Python favors duck typing and composition
- Java favors interfaces and inheritance

## Deployment Considerations

### Python Deployment
- **Package Size**: Small (~50MB with dependencies)
- **Container Image**: ~200-300MB
- **Cold Start**: Fast
- **Best Platforms**: AWS Lambda, Cloud Functions, lightweight containers

### Java Deployment
- **Package Size**: Large (~500MB with models)
- **Container Image**: ~700MB-1GB
- **Cold Start**: Slow
- **Best Platforms**: Kubernetes, EC2, always-on services

## Conclusion

The architectural differences reflect the language philosophies:
- **Python**: Simplicity, readability, rapid development
- **Java**: Structure, type safety, enterprise robustness

Both architectures are valid and effective for sentiment analysis. The choice depends on:
- Team expertise
- Performance requirements
- Deployment environment
- Integration needs
