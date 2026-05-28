package com.saxonmath.mathquiz.service;

import com.saxonmath.mathquiz.model.Test;
import com.saxonmath.mathquiz.model.TestQuestion;
import com.saxonmath.mathquiz.model.TestResult;
import com.saxonmath.mathquiz.repository.TestQuestionRepository;
import com.saxonmath.mathquiz.repository.TestRepository;
import com.saxonmath.mathquiz.repository.TestResultRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TestService {

    private final TestRepository testRepository;
    private final TestQuestionRepository testQuestionRepository;
    private final TestResultRepository testResultRepository;

    private static final int QUESTIONS_PER_PAGE = 10;

    public TestService(TestRepository testRepository, TestQuestionRepository testQuestionRepository,
                       TestResultRepository testResultRepository) {
        this.testRepository = testRepository;
        this.testQuestionRepository = testQuestionRepository;
        this.testResultRepository = testResultRepository;
    }

    public List<Test> getAllTests() {
        return testRepository.findAll();
    }

    public List<Test> getTestsByDifficulty(Test.Difficulty difficulty) {
        return testRepository.findByDifficultyOrderByNameAsc(difficulty);
    }

    public Optional<Test> getTestById(Long id) {
        return testRepository.findById(id);
    }

    public Page<TestQuestion> getTestQuestionsPage(Long testId, int page) {
        return testQuestionRepository.findByTestIdOrderByIdAsc(testId, PageRequest.of(page, QUESTIONS_PER_PAGE));
    }

    public List<TestQuestion> getAllTestQuestions(Long testId) {
        return testQuestionRepository.findByTestIdOrderByIdAsc(testId);
    }

    public long getQuestionCount(Long testId) {
        return testQuestionRepository.countByTestId(testId);
    }

    public int getTotalPages(Long testId) {
        long count = testQuestionRepository.countByTestId(testId);
        return (int) Math.ceil((double) count / QUESTIONS_PER_PAGE);
    }

    /**
     * Grade a test submission and save the result.
     */
    public TestResult gradeAndSaveTest(Long userId, Long testId, Map<Long, String> answers) {
        List<TestQuestion> questions = testQuestionRepository.findByTestIdOrderByIdAsc(testId);
        int score = 0;
        for (TestQuestion q : questions) {
            String userAnswer = answers.get(q.getId());
            if (userAnswer != null && userAnswer.equalsIgnoreCase(q.getCorrectAnswer())) {
                score++;
            }
        }

        int totalQuestions = questions.size();
        double percentage = (double) score / totalQuestions * 100;
        boolean passed = percentage >= 70;

        TestResult result = new TestResult(userId, testId, score, totalQuestions, LocalDateTime.now(), passed);
        return testResultRepository.save(result);
    }

    public List<TestResult> getUserResults(Long userId) {
        return testResultRepository.findByUserIdOrderByCompletedAtDesc(userId);
    }

    public Optional<TestResult> getLatestResult(Long userId, Long testId) {
        return testResultRepository.findTopByUserIdAndTestIdOrderByCompletedAtDesc(userId, testId);
    }
}
