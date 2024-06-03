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
                ".weather { font-size: 24px; margin-top: 20px; color: #4682b4; }" +
                "</style>" +
                "</head>" +
                "<body onload=\"startClock(); getWeather();\">" +
                "<h1>Hello World</h1>" +
                "<div class=\"clock\" id=\"clock\"></div>" +
                "<div class=\"weather\" id=\"weather\"></div>" +
                "<script>" +
                "function startClock() {" +
                "  setInterval(() => {" +
                "    const now = new Date();" +
                "    const timeString = now.toLocaleTimeString();" +
                "    document.getElementById('clock').textContent = timeString;" +
                "  }, 1000);" +
                "}" +
                "function getWeather() {" +
                "  fetch('https://api.openweathermap.org/data/2.5/weather?q=YOUR_CITY&appid=YOUR_API_KEY&units=metric')" +
                "    .then(response => response.json())" +
                "    .then(data => {" +
                "      const weatherDiv = document.getElementById('weather');" +
                "      const weather = `Weather in ${data.name}: ${data.weather[0].description}, ${data.main.temp}°C`;" +
                "      weatherDiv.textContent = weather;" +
                "    })" +
                "    .catch(error => {" +
                "      console.error('Error fetching weather data:', error);" +
                "    });" +
                "}" +
                "</script>" +
                "</body>" +
                "</html>";
    }    
}
