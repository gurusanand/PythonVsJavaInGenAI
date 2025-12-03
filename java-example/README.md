# Java Sentiment Analysis Example

This is a Java implementation of a sentiment analysis tool using Stanford CoreNLP, a robust natural language processing framework.

## Features

- Sentiment analysis using Stanford CoreNLP
- Multi-sentence analysis with averaging
- Batch text processing
- Command-line interface

## Setup

### Prerequisites
- Java 11 or higher
- Maven 3.6 or higher

### Installation

1. Install dependencies:
   ```bash
   mvn clean install
   ```

## Usage

### Compile the project:
```bash
mvn compile
```

### Run with default examples:
```bash
mvn exec:java -Dexec.mainClass="SentimentAnalyzer"
```

### Analyze custom text:
```bash
mvn exec:java -Dexec.mainClass="SentimentAnalyzer" -Dexec.args="Your custom text here"
```

### Run tests:
```bash
mvn test
```

### Alternative: Direct Java execution
```bash
mvn package
java -cp target/sentiment-analyzer-1.0-SNAPSHOT.jar:~/.m2/repository/edu/stanford/nlp/stanford-corenlp/4.5.4/* SentimentAnalyzer
```

## Project Structure

```
java-example/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── SentimentAnalyzer.java
│   └── test/
│       └── java/
│           └── SentimentAnalyzerTest.java
├── pom.xml
└── README.md
```

## Example Output

```
Text 1: I love this product! It's absolutely amazing...
  Sentiment: Positive
  Score: 1.500 (range: -2 to 2)
```

## Key Java Advantages for GenAI

- **Performance**: Compiled language with strong runtime performance
- **Enterprise Ready**: Robust frameworks and production-grade libraries
- **Type Safety**: Strong typing helps catch errors early
- **Scalability**: Excellent for large-scale, distributed systems
- **Mature Ecosystem**: Stanford CoreNLP, DL4J, and other enterprise-grade tools
