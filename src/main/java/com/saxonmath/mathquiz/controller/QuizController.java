package com.saxonmath.mathquiz.controller;

import com.saxonmath.mathquiz.dto.AnswerResult;
import com.saxonmath.mathquiz.model.AppUser;
import com.saxonmath.mathquiz.model.Question;
import com.saxonmath.mathquiz.repository.UserRepository;
import com.saxonmath.mathquiz.service.QuizService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class QuizController {

    private final QuizService quizService;
    private final UserRepository userRepository;

    public QuizController(QuizService quizService, UserRepository userRepository) {
        this.quizService = quizService;
        this.userRepository = userRepository;
    }

    @GetMapping({"/", "/quiz"})
    public String quizPage(@RequestParam(defaultValue = "0") int page, Model model, Principal principal) {
        Page<Question> questionsPage = quizService.getQuestionsPage(page);

        model.addAttribute("questions", questionsPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", questionsPage.getTotalPages());
        model.addAttribute("hasPrevious", questionsPage.hasPrevious());
        model.addAttribute("hasNext", questionsPage.hasNext());

        // Add user profile info
        if (principal != null) {
            AppUser user = userRepository.findByUsername(principal.getName()).orElse(null);
            if (user != null) {
                model.addAttribute("user", user);
            }
        }

        return "quiz";
    }

    @PostMapping("/answer")
    @ResponseBody
    public ResponseEntity<AnswerResult> submitAnswer(
            @RequestParam Long questionId,
            @RequestParam String selectedAnswer) {
        AnswerResult result = quizService.checkAnswer(questionId, selectedAnswer);
        return ResponseEntity.ok(result);
    }
}
