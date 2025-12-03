#!/usr/bin/env python3
"""
Python GenAI Chatbot Example
A simple implementation demonstrating GenAI capabilities using Python
"""

import os
import sys
from typing import List, Dict


class GenAIChatbot:
    """A simple GenAI chatbot implementation"""
    
    def __init__(self, model_name: str = "gpt-3.5-turbo"):
        """
        Initialize the chatbot
        
        Args:
            model_name: Name of the model to use
        """
        self.model_name = model_name
        self.conversation_history: List[Dict[str, str]] = []
        
    def chat(self, user_message: str) -> str:
        """
        Send a message and get a response
        
        Args:
            user_message: The user's message
            
        Returns:
            The chatbot's response
        """
        # Add user message to history
        self.conversation_history.append({
            "role": "user",
            "content": user_message
        })
        
        # Simulate response (in production, this would call an actual API)
        response = self._generate_response(user_message)
        
        # Add assistant response to history
        self.conversation_history.append({
            "role": "assistant",
            "content": response
        })
        
        return response
    
    def _generate_response(self, message: str) -> str:
        """
        Generate a response based on the message
        
        Args:
            message: The input message
            
        Returns:
            Generated response
        """
        # Simulate AI response with simple logic
        message_lower = message.lower()
        
        if "hello" in message_lower or "hi" in message_lower:
            return "Hello! I'm a Python-based GenAI chatbot. How can I help you today?"
        elif "how are you" in message_lower:
            return "I'm functioning well! As an AI, I'm always ready to assist. What would you like to know?"
        elif "python" in message_lower:
            return "Python is excellent for GenAI! It has rich libraries like OpenAI, LangChain, and HuggingFace Transformers."
        elif "java" in message_lower:
            return "Java is also capable for GenAI with libraries like DJL (Deep Java Library) and Spring AI."
        elif "compare" in message_lower:
            return "Python generally offers more GenAI libraries and easier syntax, while Java provides better performance and enterprise integration."
        else:
            return f"I received your message: '{message}'. This is a demo response from Python GenAI implementation."
    
    def get_history(self) -> List[Dict[str, str]]:
        """
        Get the conversation history
        
        Returns:
            List of conversation messages
        """
        return self.conversation_history
    
    def clear_history(self):
        """Clear the conversation history"""
        self.conversation_history = []


def main():
    """Main function to demonstrate the chatbot"""
    print("=" * 50)
    print("Python GenAI Chatbot Demo")
    print("=" * 50)
    print("Type 'exit' or 'quit' to end the conversation")
    print("Type 'history' to see conversation history")
    print("Type 'clear' to clear conversation history")
    print("=" * 50)
    
    chatbot = GenAIChatbot()
    
    while True:
        try:
            user_input = input("\nYou: ").strip()
            
            if not user_input:
                continue
                
            if user_input.lower() in ['exit', 'quit']:
                print("\nGoodbye!")
                break
            
            if user_input.lower() == 'history':
                print("\n--- Conversation History ---")
                for msg in chatbot.get_history():
                    role = msg['role'].capitalize()
                    content = msg['content']
                    print(f"{role}: {content}")
                continue
            
            if user_input.lower() == 'clear':
                chatbot.clear_history()
                print("Conversation history cleared!")
                continue
            
            response = chatbot.chat(user_input)
            print(f"\nBot: {response}")
            
        except KeyboardInterrupt:
            print("\n\nGoodbye!")
            break
        except Exception as e:
            print(f"\nError: {e}")


if __name__ == "__main__":
    main()
