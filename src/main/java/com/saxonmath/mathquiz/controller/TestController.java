package com.saxonmath.mathquiz.controller;

import com.saxonmath.mathquiz.dto.IncorrectQuestion;
import com.saxonmath.mathquiz.model.*;
import com.saxonmath.mathquiz.repository.UserRepository;
import com.saxonmath.mathquiz.service.BadgeService;
import com.saxonmath.mathquiz.service.TestService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class TestController {

    private final TestService testService;
    private final BadgeService badgeService;
    private final UserRepository userRepository;

    public TestController(TestService testService, BadgeService badgeService, UserRepository userRepository) {
        this.testService = testService;
        this.badgeService = badgeService;
        this.userRepository = userRepository;
    }

    @GetMapping("/tests")
    public String testsPage(Model model, Principal principal) {
        addUserToModel(model, principal);

        List<Test> easyTests = testService.getTestsByDifficulty(Test.Difficulty.EASY);
        List<Test> mediumTests = testService.getTestsByDifficulty(Test.Difficulty.MEDIUM);
        List<Test> hardTests = testService.getTestsByDifficulty(Test.Difficulty.HARD);

        model.addAttribute("easyTests", easyTests);
        model.addAttribute("mediumTests", mediumTests);
        model.addAttribute("hardTests", hardTests);

        return "tests";
    }

    @GetMapping("/tests/{id}")
    public String takeTest(@PathVariable Long id,
                           @RequestParam(defaultValue = "0") int page,
                           Model model, Principal principal, HttpSession session) {
        addUserToModel(model, principal);

        Optional<Test> testOpt = testService.getTestById(id);
        if (testOpt.isEmpty()) {
            return "redirect:/tests";
        }

        Test test = testOpt.get();
        Page<TestQuestion> questionsPage = testService.getTestQuestionsPage(id, page);
        int totalPages = testService.getTotalPages(id);

        model.addAttribute("test", test);
        model.addAttribute("questions", questionsPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("hasPrevious", page > 0);
        model.addAttribute("hasNext", page < totalPages - 1);
        model.addAttribute("isLastPage", page == totalPages - 1);

        // Get answers stored in session
        @SuppressWarnings("unchecked")
        Map<Long, String> sessionAnswers = (Map<Long, String>) session.getAttribute("testAnswers_" + id);
        if (sessionAnswers == null) {
            sessionAnswers = new HashMap<>();
        }
        model.addAttribute("sessionAnswers", sessionAnswers);

        return "take-test";
    }

    @PostMapping("/tests/{id}/save-answers")
    public String saveAnswers(@PathVariable Long id,
                              @RequestParam int currentPage,
                              @RequestParam(required = false) String action,
                              @RequestParam Map<String, String> allParams,
                              HttpSession session, Principal principal) {
        // Extract answers from params (keys like "answer_123")
        @SuppressWarnings("unchecked")
        Map<Long, String> sessionAnswers = (Map<Long, String>) session.getAttribute("testAnswers_" + id);
        if (sessionAnswers == null) {
            sessionAnswers = new HashMap<>();
        }

        for (Map.Entry<String, String> entry : allParams.entrySet()) {
            if (entry.getKey().startsWith("answer_")) {
                Long questionId = Long.parseLong(entry.getKey().substring(7));
                sessionAnswers.put(questionId, entry.getValue());
            }
        }
        session.setAttribute("testAnswers_" + id, sessionAnswers);

        if ("submit".equals(action)) {
            // Grade the test
            AppUser user = getUser(principal);
            if (user == null) return "redirect:/login";

            TestResult result = testService.gradeAndSaveTest(user.getId(), id, sessionAnswers);

            // Build list of incorrect questions for review
            List<TestQuestion> allQuestions = testService.getAllTestQuestions(id);
            List<IncorrectQuestion> incorrectQuestions = new ArrayList<>();
            for (TestQuestion q : allQuestions) {
                String userAnswer = sessionAnswers.get(q.getId());
                if (userAnswer == null || !userAnswer.equalsIgnoreCase(q.getCorrectAnswer())) {
                    incorrectQuestions.add(new IncorrectQuestion(
                        q.getQuestionText(), q.getOptionA(), q.getOptionB(),
                        q.getOptionC(), q.getOptionD(),
                        userAnswer != null ? userAnswer : "-",
                        q.getCorrectAnswer(), q.getHint(), q.getTopic()
                    ));
                }
            }
            session.setAttribute("incorrectQuestions_" + id, incorrectQuestions);

            // Check for badges
            List<Badge> newBadges = badgeService.checkAndAwardBadges(user.getId(), result);
            session.setAttribute("newBadges_" + id, newBadges);
            session.setAttribute("latestResult_" + id, result);

            // Clear test answers from session
            session.removeAttribute("testAnswers_" + id);

            return "redirect:/tests/" + id + "/result";
        } else if ("prev".equals(action)) {
            return "redirect:/tests/" + id + "?page=" + (currentPage - 1);
        } else {
            // next page
            return "redirect:/tests/" + id + "?page=" + (currentPage + 1);
        }
    }

    @GetMapping("/tests/{id}/result")
    public String testResult(@PathVariable Long id, Model model, Principal principal, HttpSession session) {
        addUserToModel(model, principal);
        AppUser user = getUser(principal);
        if (user == null) return "redirect:/login";

        Optional<Test> testOpt = testService.getTestById(id);
        if (testOpt.isEmpty()) return "redirect:/tests";

        Test test = testOpt.get();
        model.addAttribute("test", test);

        // Get result from session or DB
        @SuppressWarnings("unchecked")
        TestResult result = (TestResult) session.getAttribute("latestResult_" + id);
        if (result == null) {
            Optional<TestResult> resultOpt = testService.getLatestResult(user.getId(), id);
            if (resultOpt.isEmpty()) return "redirect:/tests";
            result = resultOpt.get();
        }

        double percentage = (double) result.getScore() / result.getTotalQuestions() * 100;

        model.addAttribute("result", result);
        model.addAttribute("percentage", Math.round(percentage));

        // Get new badges from session
        @SuppressWarnings("unchecked")
        List<Badge> newBadges = (List<Badge>) session.getAttribute("newBadges_" + id);
        if (newBadges == null) {
            newBadges = List.of();
        }
        model.addAttribute("newBadges", newBadges);

        // Get incorrect questions for review
        @SuppressWarnings("unchecked")
        List<IncorrectQuestion> incorrectQuestions = (List<IncorrectQuestion>) session.getAttribute("incorrectQuestions_" + id);
        if (incorrectQuestions == null) {
            incorrectQuestions = List.of();
        }
        model.addAttribute("incorrectQuestions", incorrectQuestions);

        // Clean up session
        session.removeAttribute("latestResult_" + id);
        session.removeAttribute("newBadges_" + id);
        session.removeAttribute("incorrectQuestions_" + id);

        return "test-result";
    }

    @GetMapping("/badges")
    public String badgesPage(Model model, Principal principal) {
        addUserToModel(model, principal);
        AppUser user = getUser(principal);
        if (user == null) return "redirect:/login";

        List<Badge> earnedBadges = badgeService.getUserBadges(user.getId());
        List<BadgeService.BadgeDefinition> allBadges = badgeService.getAllBadgeDefinitions();

        model.addAttribute("earnedBadges", earnedBadges);
        model.addAttribute("allBadges", allBadges);

        return "badges";
    }

    private void addUserToModel(Model model, Principal principal) {
        if (principal != null) {
            AppUser user = userRepository.findByUsername(principal.getName()).orElse(null);
            if (user != null) {
                model.addAttribute("user", user);
            }
        }
    }

    private AppUser getUser(Principal principal) {
        if (principal == null) return null;
        return userRepository.findByUsername(principal.getName()).orElse(null);
    }
}
