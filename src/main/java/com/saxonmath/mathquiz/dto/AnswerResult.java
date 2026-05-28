package com.saxonmath.mathquiz.dto;

public class AnswerResult {
    private Long questionId;
    private String selectedAnswer;
    private String correctAnswer;
    private boolean correct;
    private String hint;

    public AnswerResult() {}

    public AnswerResult(Long questionId, String selectedAnswer, String correctAnswer,
                        boolean correct, String hint) {
        this.questionId = questionId;
        this.selectedAnswer = selectedAnswer;
        this.correctAnswer = correctAnswer;
        this.correct = correct;
        this.hint = hint;
    }

    public Long getQuestionId() { return questionId; }
    public String getSelectedAnswer() { return selectedAnswer; }
    public String getCorrectAnswer() { return correctAnswer; }
    public boolean isCorrect() { return correct; }
    public String getHint() { return hint; }

    public void setQuestionId(Long questionId) { this.questionId = questionId; }
    public void setSelectedAnswer(String selectedAnswer) { this.selectedAnswer = selectedAnswer; }
    public void setCorrectAnswer(String correctAnswer) { this.correctAnswer = correctAnswer; }
    public void setCorrect(boolean correct) { this.correct = correct; }
    public void setHint(String hint) { this.hint = hint; }
}
