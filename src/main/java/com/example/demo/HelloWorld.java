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
                "  fetch('https://api.openweathermap.org/data/2.5/weather?q=Lyndhurst,Melbourne&appid=b5811da374af1ff311a213b0eef3ecc8&units=metric')" +
                "    .then(response => {" +
                "      if (!response.ok) {" +
                "        throw new Error('Network response was not ok ' + response.statusText);" +
                "      }" +
                "      return response.json();" +
                "    })" +
                "    .then(data => {" +
                "      const weatherDiv = document.getElementById('weather');" +
                "      if (data.weather && data.weather.length > 0) {" +
                "        const weather = `Weather in ${data.name}: ${data.weather[0].description}, ${data.main.temp}°C`;" +
                "        weatherDiv.textContent = weather;" +
                "      } else {" +
                "        weatherDiv.textContent = 'Weather data not available';" +
                "      }" +
                "    })" +
                "    .catch(error => {" +
                "      console.error('Error fetching weather data:', error);" +
                "      document.getElementById('weather').textContent = 'Error fetching weather data';" +
                "    });" +
                "}" +
                "</script>" +
                "</body>" +
                "</html>";
    }
}
