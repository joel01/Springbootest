package com.joel.springbootest.controller;

import com.joel.springbootest.model.ContactMessage;
import com.joel.springbootest.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProfileController {

    @Autowired
    private ContactService contactService;

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
        contactService.saveMessage(message);
        return "Mensaje recibido de: " + message.getName() + " - " + message.getMessage();
    }

    @GetMapping("/messages")
    public List<ContactMessage> getAllMessages() {
        return contactService.getAllMessages();
    }
}
