# Quick Reference Guide

## Command Cheat Sheet

### Python

| Task | Command |
|------|---------|
| Run chatbot | `python genai_chatbot.py` |
| Run tests | `python test_genai_chatbot.py` |
| Install deps | `pip install -r requirements.txt` |
| Make executable | `chmod +x genai_chatbot.py` |

### Java

| Task | Command |
|------|---------|
| Compile main | `javac GenAIChatbot.java` |
| Run chatbot | `java GenAIChatbot` |
| Compile tests | `javac GenAIChatbotTest.java GenAIChatbot.java` |
| Run tests | `java GenAIChatbotTest` |
| Clean | `rm *.class` |

## Key Differences at a Glance

```
Python                          Java
------                          ----
Dynamic typing                  Static typing
Indentation-based               Brace-based
def keyword                     public/private keywords
No compilation                  Compilation required
.py files                       .java → .class files
pip for packages                Maven/Gradle for packages
__init__ constructor            Constructor with class name
List[Dict]                      List<Map<String, String>>
f-strings                       String.format()
```

## Code Snippets

### Python: Create and Use Chatbot
```python
from genai_chatbot import GenAIChatbot

bot = GenAIChatbot()
response = bot.chat("Hello!")
print(response)
history = bot.get_history()
bot.clear_history()
```

### Java: Create and Use Chatbot
```java
GenAIChatbot bot = new GenAIChatbot();
String response = bot.chat("Hello!");
System.out.println(response);
List<Map<String, String>> history = bot.getHistory();
bot.clearHistory();
```

## Interactive Commands

Both implementations support these commands:

| Command | Description |
|---------|-------------|
| `history` | Show conversation history |
| `clear` | Clear conversation history |
| `exit` or `quit` | Exit the program |

## File Structure

```
Python Implementation
├── genai_chatbot.py       (141 lines)
├── test_genai_chatbot.py  (83 lines)
├── requirements.txt       (3 lines)
└── README.md

Java Implementation
├── GenAIChatbot.java      (173 lines)
├── GenAIChatbotTest.java  (144 lines)
└── README.md
```

## Typical Use Cases

### Python Is Better For:
✓ Quick prototypes  
✓ Data science integration  
✓ Latest AI libraries  
✓ Jupyter notebooks  
✓ Research projects  

### Java Is Better For:
✓ Enterprise apps  
✓ Type-safe code  
✓ High performance  
✓ Large teams  
✓ Long-term maintenance  

## Common Patterns

### Error Handling

**Python:**
```python
try:
    response = bot.chat(message)
except Exception as e:
    print(f"Error: {e}")
```

**Java:**
```java
try {
    String response = bot.chat(message);
} catch (Exception e) {
    System.out.println("Error: " + e.getMessage());
}
```

### Iteration

**Python:**
```python
for msg in bot.get_history():
    print(f"{msg['role']}: {msg['content']}")
```

**Java:**
```java
for (Map<String, String> msg : bot.getHistory()) {
    System.out.println(msg.get("role") + ": " + msg.get("content"));
}
```

## Performance

| Metric | Python | Java |
|--------|--------|------|
| Startup | ~100ms | ~200ms |
| Response | <1ms | <1ms |
| Memory | ~20MB | ~50MB |
| LOC | 141 | 173 |

## Next Steps

1. Read [GETTING_STARTED.md](GETTING_STARTED.md)
2. Review [COMPARISON.md](COMPARISON.md)
3. Check [BENCHMARKS.md](BENCHMARKS.md)
4. Try both implementations
5. Choose based on your needs
