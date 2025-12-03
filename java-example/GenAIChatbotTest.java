import java.util.List;
import java.util.Map;

/**
 * Simple test suite for GenAIChatbot
 * Note: In production, use JUnit or TestNG for better testing framework
 */
public class GenAIChatbotTest {
    
    private static int testsPassed = 0;
    private static int testsFailed = 0;
    
    public static void main(String[] args) {
        System.out.println("Running GenAIChatbot Tests...");
        System.out.println("=".repeat(50));
        
        testInitialization();
        testChatAddsToHistory();
        testHelloResponse();
        testHowAreYouResponse();
        testPythonKeywordResponse();
        testJavaKeywordResponse();
        testCompareKeywordResponse();
        testGenericResponse();
        testGetHistory();
        testClearHistory();
        testCustomModelName();
        
        System.out.println("=".repeat(50));
        System.out.println(String.format("Tests passed: %d", testsPassed));
        System.out.println(String.format("Tests failed: %d", testsFailed));
        
        if (testsFailed == 0) {
            System.out.println("All tests passed! ✓");
            System.exit(0);
        } else {
            System.out.println("Some tests failed! ✗");
            System.exit(1);
        }
    }
    
    private static void testInitialization() {
        GenAIChatbot bot = new GenAIChatbot();
        assertTrue("History should be empty on initialization", 
                   bot.getHistory().size() == 0);
        System.out.println("✓ testInitialization");
    }
    
    private static void testChatAddsToHistory() {
        GenAIChatbot bot = new GenAIChatbot();
        bot.chat("Hello");
        assertTrue("History should have 2 entries after one chat", 
                   bot.getHistory().size() == 2);
        System.out.println("✓ testChatAddsToHistory");
    }
    
    private static void testHelloResponse() {
        GenAIChatbot bot = new GenAIChatbot();
        String response = bot.chat("Hello");
        assertTrue("Response should contain 'Java-based GenAI chatbot'", 
                   response.contains("Java-based GenAI chatbot"));
        System.out.println("✓ testHelloResponse");
    }
    
    private static void testHowAreYouResponse() {
        GenAIChatbot bot = new GenAIChatbot();
        String response = bot.chat("How are you?");
        assertTrue("Response should contain 'functioning well'", 
                   response.contains("functioning well"));
        System.out.println("✓ testHowAreYouResponse");
    }
    
    private static void testPythonKeywordResponse() {
        GenAIChatbot bot = new GenAIChatbot();
        String response = bot.chat("Tell me about Python");
        assertTrue("Response should contain 'Python'", 
                   response.contains("Python"));
        System.out.println("✓ testPythonKeywordResponse");
    }
    
    private static void testJavaKeywordResponse() {
        GenAIChatbot bot = new GenAIChatbot();
        String response = bot.chat("Tell me about Java");
        assertTrue("Response should contain 'Java'", 
                   response.contains("Java"));
        System.out.println("✓ testJavaKeywordResponse");
    }
    
    private static void testCompareKeywordResponse() {
        GenAIChatbot bot = new GenAIChatbot();
        String response = bot.chat("Compare the languages");
        assertTrue("Response should contain 'Python' and 'Java'", 
                   response.contains("Python") && response.contains("Java"));
        System.out.println("✓ testCompareKeywordResponse");
    }
    
    private static void testGenericResponse() {
        GenAIChatbot bot = new GenAIChatbot();
        String message = "Random message";
        String response = bot.chat(message);
        assertTrue("Response should contain the original message", 
                   response.contains(message));
        System.out.println("✓ testGenericResponse");
    }
    
    private static void testGetHistory() {
        GenAIChatbot bot = new GenAIChatbot();
        bot.chat("First message");
        bot.chat("Second message");
        List<Map<String, String>> history = bot.getHistory();
        assertTrue("History should have 4 entries (2 messages * 2)", 
                   history.size() == 4);
        System.out.println("✓ testGetHistory");
    }
    
    private static void testClearHistory() {
        GenAIChatbot bot = new GenAIChatbot();
        bot.chat("Message");
        assertTrue("History should not be empty before clear", 
                   bot.getHistory().size() > 0);
        bot.clearHistory();
        assertTrue("History should be empty after clear", 
                   bot.getHistory().size() == 0);
        System.out.println("✓ testClearHistory");
    }
    
    private static void testCustomModelName() {
        GenAIChatbot bot = new GenAIChatbot("gpt-4");
        // Model name is private, but we can verify bot works
        String response = bot.chat("test");
        assertTrue("Bot with custom model should respond", 
                   response != null && !response.isEmpty());
        System.out.println("✓ testCustomModelName");
    }
    
    private static void assertTrue(String message, boolean condition) {
        if (condition) {
            testsPassed++;
        } else {
            testsFailed++;
            System.out.println("✗ FAILED: " + message);
        }
    }
}
