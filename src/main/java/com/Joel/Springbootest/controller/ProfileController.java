package com.joel.springbootest.controller;

import com.joel.springbootest.model.ContactMessage;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class ProfileController {
    @GetMapping("/profile")
    public String getProfile() {
        return """
            {
                "name": "Alex Park",
                "profession": "Backend Developer",
                "skills": ["Java", "Spring Boot", "Git", "API REST"],
                "contact": "alex.park@example.com"
            }
        """;
    }

    @PostMapping("/contact")
    public String saveMessage(@RequestBody ContactMessage message) {
        return "Mensaje recibido de: " + message.getName() + " - " + message.getMessage();
    }
}
