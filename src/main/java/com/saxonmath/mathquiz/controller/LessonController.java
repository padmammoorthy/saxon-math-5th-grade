package com.saxonmath.mathquiz.controller;

import com.saxonmath.mathquiz.model.LessonContent;
import com.saxonmath.mathquiz.repository.UserRepository;
import com.saxonmath.mathquiz.service.LessonContentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class LessonController {

    private final LessonContentService lessonContentService;
    private final UserRepository userRepository;

    private static final int LESSONS_PER_PAGE = 12;

    public LessonController(LessonContentService lessonContentService, UserRepository userRepository) {
        this.lessonContentService = lessonContentService;
        this.userRepository = userRepository;
    }

    @GetMapping("/lessons")
    public String lessonsIndex(@RequestParam(defaultValue = "0") int page, Model model, Principal principal) {
        addUserToModel(model, principal);
        List<LessonContent> allLessons = lessonContentService.getAllLessons();

        int totalLessons = allLessons.size();
        int totalPages = (int) Math.ceil((double) totalLessons / LESSONS_PER_PAGE);
        int start = page * LESSONS_PER_PAGE;
        int end = Math.min(start + LESSONS_PER_PAGE, totalLessons);

        List<LessonContent> pageLessons = allLessons.subList(start, end);

        model.addAttribute("lessons", pageLessons);
        model.addAttribute("allLessons", allLessons); // for TOC
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("hasPrevious", page > 0);
        model.addAttribute("hasNext", page < totalPages - 1);
        model.addAttribute("activeNav", "lessons");

        return "lessons";
    }

    @GetMapping("/lessons/{slug}")
    public String lessonDetail(@PathVariable String slug, Model model, Principal principal) {
        addUserToModel(model, principal);
        List<LessonContent> allLessons = lessonContentService.getAllLessons();
        Optional<LessonContent> lesson = lessonContentService.getLessonBySlug(slug);
        if (lesson.isEmpty()) {
            return "redirect:/lessons";
        }
        model.addAttribute("lesson", lesson.get());
        model.addAttribute("allLessons", allLessons); // for TOC sidebar
        model.addAttribute("activeNav", "lessons");
        return "lesson-detail";
    }

    private void addUserToModel(Model model, Principal principal) {
        if (principal != null) {
            userRepository.findByUsername(principal.getName()).ifPresent(user -> model.addAttribute("user", user));
        }
    }
}
