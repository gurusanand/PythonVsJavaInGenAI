# Getting Started with Python vs Java in GenAI

This guide will help you get started with both the Python and Java implementations in this repository.

## Prerequisites

### For Python
- Python 3.7 or higher
- pip (Python package manager)

### For Java
- Java Development Kit (JDK) 11 or higher
- javac and java commands available in PATH

## Installation

### Clone the Repository
```bash
git clone https://github.com/gurusanand/PythonVsJavaInGenAI.git
cd PythonVsJavaInGenAI
```

## Running the Examples

### Python Example

1. Navigate to the Python example directory:
```bash
cd python-example
```

2. (Optional) Install dependencies:
```bash
pip install -r requirements.txt
```

3. Run the chatbot:
```bash
python genai_chatbot.py
```

4. Run tests:
```bash
python test_genai_chatbot.py
```

### Java Example

1. Navigate to the Java example directory:
```bash
cd java-example
```

2. Compile the code:
```bash
javac GenAIChatbot.java
```

3. Run the chatbot:
```bash
java GenAIChatbot
```

4. Run tests:
```bash
javac GenAIChatbotTest.java GenAIChatbot.java
java GenAIChatbotTest
```

## Using the Chatbot

Both implementations provide the same interactive interface:

### Basic Usage
1. Type your message and press Enter
2. The chatbot will respond
3. Continue the conversation

### Commands
- `history` - View conversation history
- `clear` - Clear conversation history
- `exit` or `quit` - Exit the program

### Example Interaction
```
You: hello
Bot: Hello! I'm a [Python/Java]-based GenAI chatbot. How can I help you today?

You: compare python and java
Bot: [Comparison response]

You: history
--- Conversation History ---
User: hello
Assistant: Hello! I'm a [Python/Java]-based GenAI chatbot...
...

You: exit
Goodbye!
```

## Understanding the Code

### Python Implementation
- **File**: `python-example/genai_chatbot.py`
- **Key Features**:
  - Object-oriented design with `GenAIChatbot` class
  - Type hints for better code clarity
  - Simple conversation history management
  - Interactive command-line interface

### Java Implementation
- **File**: `java-example/GenAIChatbot.java`
- **Key Features**:
  - Object-oriented design with strong typing
  - List and Map for data structures
  - Scanner for user input
  - Robust error handling

## Extending the Examples

### Adding Real API Integration

#### Python with OpenAI
```python
import openai
import os

openai.api_key = os.getenv("OPENAI_API_KEY")

def _generate_response(self, message: str) -> str:
    response = openai.ChatCompletion.create(
        model=self.model_name,
        messages=self.conversation_history
    )
    return response.choices[0].message.content
```

#### Java with OpenAI
```java
// Use OpenAI Java SDK or HTTP client
import com.theokanning.openai.service.OpenAiService;

private String generateResponse(String message) {
    OpenAiService service = new OpenAiService(System.getenv("OPENAI_API_KEY"));
    ChatCompletionRequest request = ChatCompletionRequest.builder()
        .model(modelName)
        .messages(conversationHistory)
        .build();
    return service.createChatCompletion(request)
        .getChoices().get(0).getMessage().getContent();
}
```

### Adding Error Handling

#### Python
```python
def chat(self, user_message: str) -> str:
    try:
        # Add validation
        if not user_message or not user_message.strip():
            raise ValueError("Message cannot be empty")
        
        # Existing code...
        
    except Exception as e:
        return f"Error processing message: {str(e)}"
```

#### Java
```java
public String chat(String userMessage) {
    try {
        // Add validation
        if (userMessage == null || userMessage.trim().isEmpty()) {
            throw new IllegalArgumentException("Message cannot be empty");
        }
        
        // Existing code...
        
    } catch (Exception e) {
        return "Error processing message: " + e.getMessage();
    }
}
```

## Next Steps

1. **Read the Comparison**: Check out [COMPARISON.md](COMPARISON.md) for detailed analysis
2. **Review Benchmarks**: See [BENCHMARKS.md](BENCHMARKS.md) for performance metrics
3. **Experiment**: Try modifying the code to add new features
4. **Integrate APIs**: Add real GenAI API integration
5. **Deploy**: Package and deploy your chosen implementation

## Common Issues and Solutions

### Python Issues

**Issue**: `ModuleNotFoundError`
- **Solution**: Install required packages with `pip install -r requirements.txt`

**Issue**: Permission denied when running script
- **Solution**: Make it executable with `chmod +x genai_chatbot.py`

### Java Issues

**Issue**: `javac: command not found`
- **Solution**: Install JDK and ensure it's in your PATH

**Issue**: `Error: Could not find or load main class`
- **Solution**: Ensure you're in the correct directory and the .class file exists

**Issue**: Compilation errors
- **Solution**: Ensure you're using JDK 11 or higher

## Resources

### Python
- [Python Official Documentation](https://docs.python.org/)
- [OpenAI Python SDK](https://github.com/openai/openai-python)
- [LangChain Documentation](https://python.langchain.com/)

### Java
- [Java Official Documentation](https://docs.oracle.com/en/java/)
- [Spring AI](https://spring.io/projects/spring-ai)
- [LangChain4j](https://github.com/langchain4j/langchain4j)

## Support

For issues or questions:
1. Check the documentation in the `docs/` directory
2. Review the code comments
3. Open an issue on GitHub

## Contributing

Contributions are welcome! Please:
1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests
5. Submit a pull request
