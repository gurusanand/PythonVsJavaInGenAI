#!/usr/bin/env python3
"""
Unit tests for GenAI Chatbot
"""

import unittest
from genai_chatbot import GenAIChatbot


class TestGenAIChatbot(unittest.TestCase):
    """Test cases for GenAIChatbot class"""
    
    def setUp(self):
        """Set up test fixtures"""
        self.chatbot = GenAIChatbot()
    
    def test_initialization(self):
        """Test chatbot initialization"""
        self.assertEqual(self.chatbot.model_name, "gpt-3.5-turbo")
        self.assertEqual(len(self.chatbot.conversation_history), 0)
    
    def test_chat_adds_to_history(self):
        """Test that chat adds messages to history"""
        response = self.chatbot.chat("Hello")
        self.assertEqual(len(self.chatbot.conversation_history), 2)
        self.assertEqual(self.chatbot.conversation_history[0]["role"], "user")
        self.assertEqual(self.chatbot.conversation_history[1]["role"], "assistant")
    
    def test_hello_response(self):
        """Test response to hello message"""
        response = self.chatbot.chat("Hello")
        self.assertIn("Python-based GenAI chatbot", response)
    
    def test_how_are_you_response(self):
        """Test response to 'how are you' message"""
        response = self.chatbot.chat("How are you?")
        self.assertIn("functioning well", response)
    
    def test_python_keyword_response(self):
        """Test response when message contains 'python'"""
        response = self.chatbot.chat("Tell me about Python")
        self.assertIn("Python", response)
        self.assertIn("GenAI", response)
    
    def test_java_keyword_response(self):
        """Test response when message contains 'java'"""
        response = self.chatbot.chat("Tell me about Java")
        self.assertIn("Java", response)
    
    def test_compare_keyword_response(self):
        """Test response when message contains 'compare'"""
        response = self.chatbot.chat("Compare the languages")
        self.assertIn("Python", response)
        self.assertIn("Java", response)
    
    def test_generic_response(self):
        """Test response to generic message"""
        message = "Random message"
        response = self.chatbot.chat(message)
        self.assertIn(message, response)
    
    def test_get_history(self):
        """Test getting conversation history"""
        self.chatbot.chat("First message")
        self.chatbot.chat("Second message")
        history = self.chatbot.get_history()
        self.assertEqual(len(history), 4)  # 2 messages * 2 (user + assistant)
    
    def test_clear_history(self):
        """Test clearing conversation history"""
        self.chatbot.chat("Message")
        self.assertGreater(len(self.chatbot.conversation_history), 0)
        self.chatbot.clear_history()
        self.assertEqual(len(self.chatbot.conversation_history), 0)
    
    def test_custom_model_name(self):
        """Test initialization with custom model name"""
        custom_bot = GenAIChatbot(model_name="gpt-4")
        self.assertEqual(custom_bot.model_name, "gpt-4")


if __name__ == "__main__":
    unittest.main()
