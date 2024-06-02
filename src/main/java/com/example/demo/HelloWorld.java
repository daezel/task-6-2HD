package com.example.demo;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloWorld {
    
    @GetMapping("/")
    public String hello(){
        return "<html>" +
                "<head>" +
                "<title>Hello World</title>" +
                "<style>" +
                "body { font-family: Arial, sans-serif; text-align: center; padding-top: 50px; }" +
                ".clock { font-size: 48px; margin-top: 20px; }" +
                "</style>" +
                "</head>" +
                "<body onload=\"startTime()\">" +
                "<h1>Hello World</h1>" +
                "<div class=\"clock\" id=\"clock\"></div>" +
                "<script>" +
                "function startTime() {" +
                "  const today = new Date();" +
                "  let h = today.getHours();" +
                "  let m = today.getMinutes();" +
                "  let s = today.getSeconds();" +
                "  m = checkTime(m);" +
                "  s = checkTime(s);" +
                "  document.getElementById('clock').innerHTML = h + ':' + m + ':' + s;" +
                "  setTimeout(startTime, 1000);" +
                "}" +
                "function checkTime(i) {" +
                "  if (i < 10) { i = '0' + i; }" +  // add zero in front of numbers < 10
                "  return i;" +
                "}" +
                "startTime();" +  // Call the function after defining it
                "</script>" +
                "</body>" +
                "</html>";
    }    
}



