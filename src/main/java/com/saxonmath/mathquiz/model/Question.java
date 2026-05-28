package com.saxonmath.mathquiz.model;

import jakarta.persistence.*;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String questionText;

    @Column(nullable = false)
    private String optionA;

    @Column(nullable = false)
    private String optionB;

    @Column(nullable = false)
    private String optionC;

    @Column(nullable = false)
    private String optionD;

    /** The correct answer: "A", "B", "C", or "D" */
    @Column(nullable = false)
    private String correctAnswer;

    /** Short explanation of how to solve the problem */
    @Column(nullable = false, length = 1000)
    private String hint;

    /** Lesson number from Saxon Math 5th grade */
    @Column(nullable = false)
    private int lessonNumber;

    /** Lesson title, e.g. "Place Value" */
    @Column(nullable = false)
    private String lessonTitle;

    /** Topic category, e.g. "Fractions", "Multiplication" */
    @Column(nullable = false)
    private String topic;

    public Question() {}

    public Question(Long id, String questionText, String optionA, String optionB,
                    String optionC, String optionD, String correctAnswer,
                    String hint, int lessonNumber, String lessonTitle, String topic) {
        this.id = id;
        this.questionText = questionText;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAnswer = correctAnswer;
        this.hint = hint;
        this.lessonNumber = lessonNumber;
        this.lessonTitle = lessonTitle;
        this.topic = topic;
    }

    public Long getId() { return id; }
    public String getQuestionText() { return questionText; }
    public String getOptionA() { return optionA; }
    public String getOptionB() { return optionB; }
    public String getOptionC() { return optionC; }
    public String getOptionD() { return optionD; }
    public String getCorrectAnswer() { return correctAnswer; }
    public String getHint() { return hint; }
    public int getLessonNumber() { return lessonNumber; }
    public String getLessonTitle() { return lessonTitle; }
    public String getTopic() { return topic; }

    public void setId(Long id) { this.id = id; }
    public void setQuestionText(String questionText) { this.questionText = questionText; }
    public void setOptionA(String optionA) { this.optionA = optionA; }
    public void setOptionB(String optionB) { this.optionB = optionB; }
    public void setOptionC(String optionC) { this.optionC = optionC; }
    public void setOptionD(String optionD) { this.optionD = optionD; }
    public void setCorrectAnswer(String correctAnswer) { this.correctAnswer = correctAnswer; }
    public void setHint(String hint) { this.hint = hint; }
    public void setLessonNumber(int lessonNumber) { this.lessonNumber = lessonNumber; }
    public void setLessonTitle(String lessonTitle) { this.lessonTitle = lessonTitle; }
    public void setTopic(String topic) { this.topic = topic; }
}
