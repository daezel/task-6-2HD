package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloWorld {

    @GetMapping("/")
    public String hello() {
        return "<html>" +
                "<head>" +
                "<title>Hello World</title>" +
                "<style>" +
                "body { font-family: Arial, sans-serif; text-align: center; padding-top: 50px; background-color: #f0f8ff; }" +
                "h1 { color: #4682b4; }" +
                ".clock { font-size: 48px; margin-top: 20px; color: #333; }" +
                ".message { font-size: 24px; margin-top: 20px; color: #333; }" +
                ".quote { font-size: 20px; margin-top: 20px; color: #4682b4; }" +
                "</style>" +
                "</head>" +
                "<body onload=\"startClock(); displayMessage(); displayQuote();\">" +
                "<h1>Hello World</h1>" +
                "<div class=\"clock\" id=\"clock\"></div>" +
                "<div class=\"message\" id=\"message\"></div>" +
                "<div class=\"quote\" id=\"quote\"></div>" +
                "<script>" +
                "function startClock() {" +
                "  setInterval(() => {" +
                "    const now = new Date();" +
                "    const timeString = now.toLocaleTimeString();" +
                "    document.getElementById('clock').textContent = timeString;" +
                "  }, 1000);" +
                "}" +
                "function displayMessage() {" +
                "  const now = new Date();" +
                "  const hours = now.getHours();" +
                "  let message;" +
                "  if (hours < 12) {" +
                "    message = 'Good Morning!';" +
                "  } else if (hours < 18) {" +
                "    message = 'Good Afternoon!';" +
                "  } else {" +
                "    message = 'Good Evening!';" +
                "  }" +
                "  document.getElementById('message').textContent = message;" +
                "}" +
                "function displayQuote() {" +
                "  const quotes = [" +
                "    'The best way to predict the future is to invent it.'," +
                "    'Life is 10% what happens to us and 90% how we react to it.'," +
                "    'The only way to do great work is to love what you do.'," +
                "    'You miss 100% of the shots you don’t take.'," +
                "    'Success is not the key to happiness. Happiness is the key to success.'" +
                "  ];" +
                "  const randomIndex = Math.floor(Math.random() * quotes.length);" +
                "  const randomQuote = quotes[randomIndex];" +
                "  document.getElementById('quote').textContent = randomQuote;" +
                "}" +
                "</script>" +
                "</body>" +
                "</html>";
    }
}
