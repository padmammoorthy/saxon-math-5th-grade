package com.saxonmath.mathquiz.dto;

public class IncorrectQuestion {
    private String questionText;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String userAnswer;
    private String correctAnswer;
    private String hint;
    private String topic;

    public IncorrectQuestion() {}

    public IncorrectQuestion(String questionText, String optionA, String optionB,
                             String optionC, String optionD, String userAnswer,
                             String correctAnswer, String hint, String topic) {
        this.questionText = questionText;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.userAnswer = userAnswer;
        this.correctAnswer = correctAnswer;
        this.hint = hint;
        this.topic = topic;
    }

    public String getQuestionText() { return questionText; }
    public String getOptionA() { return optionA; }
    public String getOptionB() { return optionB; }
    public String getOptionC() { return optionC; }
    public String getOptionD() { return optionD; }
    public String getUserAnswer() { return userAnswer; }
    public String getCorrectAnswer() { return correctAnswer; }
    public String getHint() { return hint; }
    public String getTopic() { return topic; }

    public String getUserAnswerText() {
        return switch (userAnswer) {
            case "A" -> optionA;
            case "B" -> optionB;
            case "C" -> optionC;
            case "D" -> optionD;
            default -> "(no answer)";
        };
    }

    public String getCorrectAnswerText() {
        return switch (correctAnswer) {
            case "A" -> optionA;
            case "B" -> optionB;
            case "C" -> optionC;
            case "D" -> optionD;
            default -> "";
        };
    }
}
