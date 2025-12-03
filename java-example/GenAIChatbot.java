import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Java GenAI Chatbot Example
 * A simple implementation demonstrating GenAI capabilities using Java
 */
public class GenAIChatbot {
    
    private String modelName;
    private List<Map<String, String>> conversationHistory;
    
    /**
     * Initialize the chatbot
     * 
     * @param modelName Name of the model to use
     */
    public GenAIChatbot(String modelName) {
        this.modelName = modelName;
        this.conversationHistory = new ArrayList<>();
    }
    
    /**
     * Default constructor using gpt-3.5-turbo
     */
    public GenAIChatbot() {
        this("gpt-3.5-turbo");
    }
    
    /**
     * Send a message and get a response
     * 
     * @param userMessage The user's message
     * @return The chatbot's response
     */
    public String chat(String userMessage) {
        // Add user message to history
        Map<String, String> userMsg = new HashMap<>();
        userMsg.put("role", "user");
        userMsg.put("content", userMessage);
        conversationHistory.add(userMsg);
        
        // Simulate response (in production, this would call an actual API)
        String response = generateResponse(userMessage);
        
        // Add assistant response to history
        Map<String, String> assistantMsg = new HashMap<>();
        assistantMsg.put("role", "assistant");
        assistantMsg.put("content", response);
        conversationHistory.add(assistantMsg);
        
        return response;
    }
    
    /**
     * Generate a response based on the message
     * 
     * @param message The input message
     * @return Generated response
     */
    private String generateResponse(String message) {
        // Simulate AI response with simple logic
        String messageLower = message.toLowerCase();
        
        if (messageLower.contains("hello") || messageLower.contains("hi")) {
            return "Hello! I'm a Java-based GenAI chatbot. How can I help you today?";
        } else if (messageLower.contains("how are you")) {
            return "I'm functioning well! As an AI, I'm always ready to assist. What would you like to know?";
        } else if (messageLower.contains("java")) {
            return "Java is excellent for GenAI! It has libraries like DJL (Deep Java Library), Spring AI, and LangChain4j.";
        } else if (messageLower.contains("python")) {
            return "Python is also great for GenAI with libraries like OpenAI, LangChain, and HuggingFace Transformers.";
        } else if (messageLower.contains("compare")) {
            return "Python offers ease of use and more GenAI libraries, while Java provides strong typing, better performance, and enterprise-grade features.";
        } else {
            return String.format("I received your message: '%s'. This is a demo response from Java GenAI implementation.", message);
        }
    }
    
    /**
     * Get the conversation history
     * 
     * @return List of conversation messages
     */
    public List<Map<String, String>> getHistory() {
        return new ArrayList<>(conversationHistory);
    }
    
    /**
     * Clear the conversation history
     */
    public void clearHistory() {
        conversationHistory.clear();
    }
    
    /**
     * Main method to demonstrate the chatbot
     */
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("Java GenAI Chatbot Demo");
        System.out.println("==================================================");
        System.out.println("Type 'exit' or 'quit' to end the conversation");
        System.out.println("Type 'history' to see conversation history");
        System.out.println("Type 'clear' to clear conversation history");
        System.out.println("==================================================");
        
        GenAIChatbot chatbot = new GenAIChatbot();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            try {
                System.out.print("\nYou: ");
                String userInput = scanner.nextLine().trim();
                
                if (userInput.isEmpty()) {
                    continue;
                }
                
                if (userInput.equalsIgnoreCase("exit") || userInput.equalsIgnoreCase("quit")) {
                    System.out.println("\nGoodbye!");
                    break;
                }
                
                if (userInput.equalsIgnoreCase("history")) {
                    System.out.println("\n--- Conversation History ---");
                    for (Map<String, String> msg : chatbot.getHistory()) {
                        String role = msg.get("role");
                        String content = msg.get("content");
                        System.out.println(capitalize(role) + ": " + content);
                    }
                    continue;
                }
                
                if (userInput.equalsIgnoreCase("clear")) {
                    chatbot.clearHistory();
                    System.out.println("Conversation history cleared!");
                    continue;
                }
                
                String response = chatbot.chat(userInput);
                System.out.println("\nBot: " + response);
                
            } catch (Exception e) {
                System.out.println("\nError: " + e.getMessage());
            }
        }
        
        scanner.close();
    }
    
    /**
     * Capitalize the first letter of a string
     * 
     * @param str Input string
     * @return Capitalized string
     */
    private static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
