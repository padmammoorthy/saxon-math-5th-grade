package com.saxonmath.mathquiz.service;

import com.saxonmath.mathquiz.model.Badge;
import com.saxonmath.mathquiz.model.Test;
import com.saxonmath.mathquiz.model.TestResult;
import com.saxonmath.mathquiz.repository.BadgeRepository;
import com.saxonmath.mathquiz.repository.TestRepository;
import com.saxonmath.mathquiz.repository.TestResultRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BadgeService {

    private final BadgeRepository badgeRepository;
    private final TestResultRepository testResultRepository;
    private final TestRepository testRepository;

    public BadgeService(BadgeRepository badgeRepository, TestResultRepository testResultRepository,
                        TestRepository testRepository) {
        this.badgeRepository = badgeRepository;
        this.testResultRepository = testResultRepository;
        this.testRepository = testRepository;
    }

    public List<Badge> getUserBadges(Long userId) {
        return badgeRepository.findByUserIdOrderByEarnedAtDesc(userId);
    }

    /**
     * Check and award badges after a test is completed.
     * Returns list of newly awarded badges.
     */
    public List<Badge> checkAndAwardBadges(Long userId, TestResult result) {
        List<Badge> newBadges = new ArrayList<>();
        List<TestResult> allResults = testResultRepository.findByUserId(userId);
        Test test = testRepository.findById(result.getTestId()).orElse(null);

        double percentage = (double) result.getScore() / result.getTotalQuestions() * 100;

        // "First Steps" - Complete your first test
        if (allResults.size() == 1) {
            Badge b = awardBadge(userId, "First Steps", "\uD83C\uDF1F", "Complete your first test");
            if (b != null) newBadges.add(b);
        }

        // "Speed Demon" - Complete a test (any score)
        Badge speedDemon = awardBadge(userId, "Speed Demon", "\uD83C\uDFCE\uFE0F", "Complete a test (any score)");
        if (speedDemon != null) newBadges.add(speedDemon);

        // "Quick Learner" - Score 80%+ on an easy test
        if (test != null && test.getDifficulty() == Test.Difficulty.EASY && percentage >= 80) {
            Badge b = awardBadge(userId, "Quick Learner", "\u26A1", "Score 80%+ on an easy test");
            if (b != null) newBadges.add(b);
        }

        // "Math Warrior" - Score 80%+ on a medium test
        if (test != null && test.getDifficulty() == Test.Difficulty.MEDIUM && percentage >= 80) {
            Badge b = awardBadge(userId, "Math Warrior", "\u2694\uFE0F", "Score 80%+ on a medium test");
            if (b != null) newBadges.add(b);
        }

        // "Math Genius" - Score 80%+ on a hard test
        if (test != null && test.getDifficulty() == Test.Difficulty.HARD && percentage >= 80) {
            Badge b = awardBadge(userId, "Math Genius", "\uD83E\uDDE0", "Score 80%+ on a hard test");
            if (b != null) newBadges.add(b);
        }

        // "Perfect Score" - Get 100% on any test
        if (percentage == 100) {
            Badge b = awardBadge(userId, "Perfect Score", "\uD83D\uDCAF", "Get 100% on any test");
            if (b != null) newBadges.add(b);
        }

        // "Hat Trick" - Complete 3 tests
        if (allResults.size() >= 3) {
            Badge b = awardBadge(userId, "Hat Trick", "\uD83C\uDFA9", "Complete 3 tests");
            if (b != null) newBadges.add(b);
        }

        // "Unstoppable" - Complete all 9 tests
        long distinctTests = allResults.stream().map(TestResult::getTestId).distinct().count();
        if (distinctTests >= 9) {
            Badge b = awardBadge(userId, "Unstoppable", "\uD83D\uDD25", "Complete all 9 tests");
            if (b != null) newBadges.add(b);
        }

        return newBadges;
    }

    private Badge awardBadge(Long userId, String name, String emoji, String description) {
        if (badgeRepository.existsByUserIdAndBadgeName(userId, name)) {
            return null; // Already has this badge
        }
        Badge badge = new Badge(userId, name, emoji, description, LocalDateTime.now());
        return badgeRepository.save(badge);
    }

    /**
     * Returns all possible badge definitions (for display purposes).
     */
    public List<BadgeDefinition> getAllBadgeDefinitions() {
        List<BadgeDefinition> defs = new ArrayList<>();
        defs.add(new BadgeDefinition("First Steps", "\uD83C\uDF1F", "Complete your first test"));
        defs.add(new BadgeDefinition("Quick Learner", "\u26A1", "Score 80%+ on an easy test"));
        defs.add(new BadgeDefinition("Math Warrior", "\u2694\uFE0F", "Score 80%+ on a medium test"));
        defs.add(new BadgeDefinition("Math Genius", "\uD83E\uDDE0", "Score 80%+ on a hard test"));
        defs.add(new BadgeDefinition("Perfect Score", "\uD83D\uDCAF", "Get 100% on any test"));
        defs.add(new BadgeDefinition("Hat Trick", "\uD83C\uDFA9", "Complete 3 tests"));
        defs.add(new BadgeDefinition("Unstoppable", "\uD83D\uDD25", "Complete all 9 tests"));
        defs.add(new BadgeDefinition("Speed Demon", "\uD83C\uDFCE\uFE0F", "Complete a test (any score)"));
        return defs;
    }

    public static class BadgeDefinition {
        private final String name;
        private final String emoji;
        private final String description;

        public BadgeDefinition(String name, String emoji, String description) {
            this.name = name;
            this.emoji = emoji;
            this.description = description;
        }

        public String getName() { return name; }
        public String getEmoji() { return emoji; }
        public String getDescription() { return description; }
    }
}
