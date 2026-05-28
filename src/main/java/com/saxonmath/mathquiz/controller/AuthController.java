package com.saxonmath.mathquiz.controller;

import com.saxonmath.mathquiz.model.AppUser;
import com.saxonmath.mathquiz.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String processSignup(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String displayName,
            @RequestParam(defaultValue = "😊") String avatar,
            @RequestParam(defaultValue = "emoji") String avatarType,
            @RequestParam(required = false) String imageUrl,
            Model model) {

        if (userRepository.existsByUsername(username)) {
            model.addAttribute("error", "Username already taken");
            return "signup";
        }

        if (password.length() < 4) {
            model.addAttribute("error", "Password must be at least 4 characters");
            return "signup";
        }

        String finalAvatar = "emoji".equals(avatarType) ? avatar : imageUrl;
        if (finalAvatar == null || finalAvatar.isBlank()) {
            finalAvatar = "😊";
            avatarType = "emoji";
        }

        AppUser user = new AppUser(
                username,
                passwordEncoder.encode(password),
                displayName,
                finalAvatar,
                avatarType
        );
        userRepository.save(user);

        return "redirect:/login?registered";
    }
}
