package com.saxonmath.mathquiz.service;

import com.saxonmath.mathquiz.dto.AnswerResult;
import com.saxonmath.mathquiz.model.Question;
import com.saxonmath.mathquiz.repository.QuestionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

    private final QuestionRepository questionRepository;

    public QuizService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    private static final int PAGE_SIZE = 5;

    public Page<Question> getQuestionsPage(int pageNumber) {
        PageRequest pageable = PageRequest.of(pageNumber, PAGE_SIZE);
        return questionRepository.findAllByOrderByLessonNumberAscIdAsc(pageable);
    }

    public AnswerResult checkAnswer(Long questionId, String selectedAnswer) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new IllegalArgumentException("Question not found: " + questionId));

        boolean correct = question.getCorrectAnswer().equalsIgnoreCase(selectedAnswer);

        return new AnswerResult(
                questionId,
                selectedAnswer,
                question.getCorrectAnswer(),
                correct,
                question.getHint()
        );
    }
}
