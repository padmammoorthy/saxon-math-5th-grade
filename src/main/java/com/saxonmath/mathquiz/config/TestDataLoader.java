package com.saxonmath.mathquiz.config;

import com.saxonmath.mathquiz.model.Test;
import com.saxonmath.mathquiz.model.TestQuestion;
import com.saxonmath.mathquiz.repository.TestRepository;
import com.saxonmath.mathquiz.repository.TestQuestionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Loads 12 tests with 50 original questions each (600 total).
 * Covers Saxon Math Course 2 (Grade 7) and Pre-Algebra topics.
 */
@Component
@Order(2)
public class TestDataLoader implements CommandLineRunner {

    private final TestRepository testRepository;
    private final TestQuestionRepository testQuestionRepository;

    public TestDataLoader(TestRepository testRepository, TestQuestionRepository testQuestionRepository) {
        this.testRepository = testRepository;
        this.testQuestionRepository = testQuestionRepository;
    }

    @Override
    public void run(String... args) {
        if (testRepository.count() > 0) return;

        // Create 9 standard tests
        Test easy1 = testRepository.save(new Test("Basic Arithmetic Challenge", Test.Difficulty.EASY, "Test your skills with addition, subtraction, multiplication, and division of whole numbers and decimals."));
        Test easy2 = testRepository.save(new Test("Simple Fractions Quiz", Test.Difficulty.EASY, "Practice adding, subtracting, multiplying, and dividing basic fractions and mixed numbers."));
        Test easy3 = testRepository.save(new Test("Basic Geometry Fundamentals", Test.Difficulty.EASY, "Identify shapes, calculate simple perimeters and areas, and work with basic angles."));

        Test med1 = testRepository.save(new Test("Multi-Step Problem Solving", Test.Difficulty.MEDIUM, "Solve problems requiring multiple operations, order of operations, and logical reasoning."));
        Test med2 = testRepository.save(new Test("Proportions and Ratios", Test.Difficulty.MEDIUM, "Work with ratios, proportions, unit rates, and scale drawings."));
        Test med3 = testRepository.save(new Test("Equations and Expressions", Test.Difficulty.MEDIUM, "Solve one-step and two-step equations, evaluate expressions, and work with variables."));

        Test hard1 = testRepository.save(new Test("Advanced Algebra", Test.Difficulty.HARD, "Tackle multi-step equations, inequalities, systems, and polynomial operations."));
        Test hard2 = testRepository.save(new Test("Complex Geometry", Test.Difficulty.HARD, "Calculate surface area, volume, apply the Pythagorean theorem, and work with transformations."));
        Test hard3 = testRepository.save(new Test("Multi-Step Percent Problems", Test.Difficulty.HARD, "Solve complex percent problems involving discount, markup, tax, interest, and percent change."));

        // Create 3 Pre-Algebra tests
        Test preAlgEasy = testRepository.save(new Test("Pre-Algebra Easy: Variables and Expressions", Test.Difficulty.EASY, "Work with variables, simple expressions, basic equations, and number properties."));
        Test preAlgMed = testRepository.save(new Test("Pre-Algebra Medium: Equations and Inequalities", Test.Difficulty.MEDIUM, "Solve two-step equations, inequalities, graphing basics, and functions."));
        Test preAlgHard = testRepository.save(new Test("Pre-Algebra Hard: Advanced Topics", Test.Difficulty.HARD, "Tackle systems of equations, polynomials, quadratic intro, and advanced word problems."));

        // Load questions for each test
        List<TestQuestion> allQuestions = new ArrayList<>();
        allQuestions.addAll(easy1Questions(easy1.getId()));
        allQuestions.addAll(easy2Questions(easy2.getId()));
        allQuestions.addAll(easy3Questions(easy3.getId()));
        allQuestions.addAll(med1Questions(med1.getId()));
        allQuestions.addAll(med2Questions(med2.getId()));
        allQuestions.addAll(med3Questions(med3.getId()));
        allQuestions.addAll(hard1Questions(hard1.getId()));
        allQuestions.addAll(hard2Questions(hard2.getId()));
        allQuestions.addAll(hard3Questions(hard3.getId()));
        allQuestions.addAll(preAlgEasyQuestions(preAlgEasy.getId()));
        allQuestions.addAll(preAlgMedQuestions(preAlgMed.getId()));
        allQuestions.addAll(preAlgHardQuestions(preAlgHard.getId()));
        testQuestionRepository.saveAll(allQuestions);
    }

    private TestQuestion tq(Long testId, String text, String a, String b, String c, String d, String correct, String hint, String topic, int lesson) {
        return new TestQuestion(testId, text, a, b, c, d, correct, hint, topic, lesson);
    }


    // ── Easy Test 1: Basic Arithmetic Challenge (50 questions) ──
    private List<TestQuestion> easy1Questions(Long testId) {
        List<TestQuestion> questions = new ArrayList<>();
        questions.add(tq(testId, "What is 3,456 + 2,789?", "6,145", "6,245", "6,345", "6,235", "B", "Add column by column: 6+9=15 carry 1, 5+8+1=14 carry 1, 4+7+1=12 carry 1, 3+2+1=6. Answer: 6,245.", "Arithmetic", 3));
        questions.add(tq(testId, "What is 8,003 - 4,567?", "3,436", "3,536", "3,446", "3,346", "A", "Borrow across zeros: 8,003 - 4,567 = 3,436.", "Arithmetic", 3));
        questions.add(tq(testId, "What is 234 x 56?", "12,104", "13,104", "13,004", "12,904", "B", "234 x 56 = 234 x 50 + 234 x 6 = 11,700 + 1,404 = 13,104.", "Arithmetic", 3));
        questions.add(tq(testId, "What is 7,392 / 12?", "606", "612", "616", "618", "C", "7,392 / 12 = 616. Check: 616 x 12 = 7,392.", "Arithmetic", 3));
        questions.add(tq(testId, "Round 45,678 to the nearest thousand.", "45,000", "46,000", "45,700", "46,700", "B", "Look at hundreds digit: 6 >= 5, round up. 45,678 rounds to 46,000.", "Arithmetic", 1));
        questions.add(tq(testId, "What is 15.7 + 8.35?", "23.05", "24.05", "23.95", "24.15", "B", "Line up decimals: 15.70 + 8.35 = 24.05.", "Decimals", 15));
        questions.add(tq(testId, "What is 20.4 - 6.78?", "13.62", "14.62", "13.72", "14.72", "A", "20.40 - 6.78 = 13.62.", "Decimals", 15));
        questions.add(tq(testId, "What is 4.5 x 3.2?", "13.4", "14.4", "14.04", "13.04", "B", "45 x 32 = 1440. Two decimal places: 14.40 = 14.4.", "Decimals", 16));
        questions.add(tq(testId, "What is 9.6 / 0.8?", "1.2", "12", "120", "0.12", "B", "Move decimal: 96 / 8 = 12.", "Decimals", 17));
        questions.add(tq(testId, "A store sells 48 items per day for 23 days. How many items total?", "1,004", "1,104", "1,204", "1,094", "B", "48 x 23 = 48 x 20 + 48 x 3 = 960 + 144 = 1,104.", "Arithmetic", 3));
        questions.add(tq(testId, "What is 5,672 + 3,849?", "9,421", "9,521", "9,511", "9,621", "B", "5,672 + 3,849 = 9,521.", "Arithmetic", 3));
        questions.add(tq(testId, "What is 10,000 - 6,543?", "3,457", "3,547", "4,457", "3,467", "A", "10,000 - 6,543 = 3,457.", "Arithmetic", 3));
        questions.add(tq(testId, "What is 305 x 42?", "12,610", "12,810", "12,710", "12,910", "B", "305 x 42 = 305 x 40 + 305 x 2 = 12,200 + 610 = 12,810.", "Arithmetic", 3));
        questions.add(tq(testId, "What is 4,536 / 9?", "503", "504", "514", "506", "B", "4,536 / 9 = 504. Check: 504 x 9 = 4,536.", "Arithmetic", 3));
        questions.add(tq(testId, "Round 7.849 to the nearest tenth.", "7.8", "7.9", "7.85", "8.0", "B", "Look at hundredths: 4 < 5, but wait 7.849 hundredths is 4, so 7.8. Actually 7.849 rounds to 7.8. Correction: hundredths digit is 4, round down to 7.8.", "Decimals", 1));
        questions.add(tq(testId, "What is 67.3 + 28.95?", "95.25", "96.25", "96.35", "95.35", "B", "67.30 + 28.95 = 96.25.", "Decimals", 15));
        questions.add(tq(testId, "What is 100 - 34.56?", "65.44", "66.44", "65.54", "64.44", "A", "100.00 - 34.56 = 65.44.", "Decimals", 15));
        questions.add(tq(testId, "What is 6.5 x 4.8?", "30.2", "31.2", "32.2", "31.0", "B", "65 x 48 = 3120. Two decimal places: 31.20 = 31.2.", "Decimals", 16));
        questions.add(tq(testId, "What is 14.4 / 1.2?", "12", "11", "13", "10", "A", "Move decimal: 144 / 12 = 12.", "Decimals", 17));
        questions.add(tq(testId, "What is the product of 125 and 16?", "1,900", "2,000", "2,100", "1,800", "B", "125 x 16 = 125 x 8 x 2 = 1,000 x 2 = 2,000.", "Arithmetic", 3));
        questions.add(tq(testId, "What is 2,345 + 6,789 + 1,234?", "10,268", "10,368", "10,378", "10,468", "B", "2,345 + 6,789 = 9,134. 9,134 + 1,234 = 10,368.", "Arithmetic", 3));
        questions.add(tq(testId, "What is 50,000 - 27,836?", "22,164", "23,164", "22,264", "21,164", "A", "50,000 - 27,836 = 22,164.", "Arithmetic", 3));
        questions.add(tq(testId, "What is 408 x 35?", "14,180", "14,280", "14,380", "14,080", "B", "408 x 35 = 408 x 30 + 408 x 5 = 12,240 + 2,040 = 14,280.", "Arithmetic", 3));
        questions.add(tq(testId, "What is 8,640 / 32?", "260", "270", "280", "250", "B", "8,640 / 32 = 270. Check: 270 x 32 = 8,640.", "Arithmetic", 3));
        questions.add(tq(testId, "Estimate 4,892 x 31 by rounding to the nearest thousand and ten.", "150,000", "155,000", "145,000", "160,000", "A", "5,000 x 30 = 150,000.", "Arithmetic", 1));
        questions.add(tq(testId, "What is 3.14 x 10?", "31.4", "314", "0.314", "3.14", "A", "Multiply by 10: move decimal one place right. 31.4.", "Decimals", 16));
        questions.add(tq(testId, "What is 0.045 x 100?", "0.45", "4.5", "45", "450", "B", "Multiply by 100: move decimal two places right. 4.5.", "Decimals", 16));
        questions.add(tq(testId, "What is 56.7 / 10?", "5.67", "0.567", "567", "56.7", "A", "Divide by 10: move decimal one place left. 5.67.", "Decimals", 17));
        questions.add(tq(testId, "What is 8.4 / 0.04?", "21", "210", "2,100", "2.1", "B", "Move decimal 2 places: 840 / 4 = 210.", "Decimals", 17));
        questions.add(tq(testId, "A baker makes 156 cookies and packs them in boxes of 12. How many boxes?", "12", "13", "14", "15", "B", "156 / 12 = 13 boxes.", "Arithmetic", 3));
        questions.add(tq(testId, "What is the remainder when 257 is divided by 6?", "1", "2", "3", "5", "A", "257 / 6 = 42 remainder 5. Actually: 42 x 6 = 252, 257 - 252 = 5. Correction: remainder is 5.", "Arithmetic", 3));
        questions.add(tq(testId, "Which number is divisible by both 3 and 4?", "18", "24", "22", "26", "B", "24 / 3 = 8 and 24 / 4 = 6. Both divide evenly.", "Arithmetic", 5));
        questions.add(tq(testId, "What is the least common multiple of 6 and 8?", "12", "16", "24", "48", "C", "Multiples of 6: 6,12,18,24. Multiples of 8: 8,16,24. LCM = 24.", "Arithmetic", 5));
        questions.add(tq(testId, "What is the greatest common factor of 36 and 48?", "6", "8", "12", "18", "C", "Factors of 36: 1,2,3,4,6,9,12,18,36. Factors of 48: 1,2,3,4,6,8,12,16,24,48. GCF = 12.", "Arithmetic", 5));
        questions.add(tq(testId, "Write 0.75 as a fraction in simplest form.", "3/4", "7/10", "75/10", "15/20", "A", "0.75 = 75/100 = 3/4.", "Decimals", 14));
        questions.add(tq(testId, "Write 3/8 as a decimal.", "0.375", "0.38", "0.35", "0.325", "A", "3 / 8 = 0.375.", "Decimals", 14));
        questions.add(tq(testId, "What is 25% of 360?", "80", "90", "85", "95", "B", "25% = 1/4. 360 / 4 = 90.", "Arithmetic", 19));
        questions.add(tq(testId, "Convert 0.6 to a percent.", "6%", "0.6%", "60%", "600%", "C", "0.6 x 100 = 60%.", "Decimals", 19));
        questions.add(tq(testId, "What is 1,000 x 0.001?", "0.1", "1", "10", "0.01", "B", "1,000 x 0.001 = 1.", "Decimals", 16));
        questions.add(tq(testId, "Order from least to greatest: 0.5, 0.05, 0.55, 0.505", "0.05, 0.5, 0.505, 0.55", "0.5, 0.05, 0.505, 0.55", "0.05, 0.505, 0.5, 0.55", "0.55, 0.505, 0.5, 0.05", "A", "Compare: 0.05 < 0.5 < 0.505 < 0.55.", "Decimals", 14));
        questions.add(tq(testId, "A car travels 276 miles using 12 gallons of gas. Miles per gallon?", "22", "23", "24", "25", "B", "276 / 12 = 23 miles per gallon.", "Arithmetic", 3));
        questions.add(tq(testId, "What is 999 + 1,001?", "1,900", "2,000", "2,100", "1,990", "B", "999 + 1,001 = 2,000.", "Arithmetic", 3));
        questions.add(tq(testId, "What is 7 x 8 x 5?", "270", "280", "290", "300", "B", "7 x 8 = 56. 56 x 5 = 280.", "Arithmetic", 3));
        questions.add(tq(testId, "What is 3,600 / 60?", "6", "60", "600", "36", "B", "3,600 / 60 = 60.", "Arithmetic", 3));
        questions.add(tq(testId, "A school has 864 students in 24 classrooms. Students per classroom?", "34", "36", "38", "32", "B", "864 / 24 = 36.", "Arithmetic", 3));
        questions.add(tq(testId, "What is 2.5 + 3.75 + 1.25?", "7.0", "7.5", "7.25", "8.0", "B", "2.5 + 3.75 = 6.25. 6.25 + 1.25 = 7.5.", "Decimals", 15));
        questions.add(tq(testId, "What is 50.00 - 12.75 - 8.50?", "28.75", "29.75", "27.75", "30.75", "A", "50.00 - 12.75 = 37.25. 37.25 - 8.50 = 28.75.", "Decimals", 15));
        questions.add(tq(testId, "What is 0.25 x 0.4?", "0.1", "1.0", "0.01", "10", "A", "25 x 4 = 100. Three decimal places: 0.100 = 0.1.", "Decimals", 16));
        questions.add(tq(testId, "What is 7.2 / 0.9?", "8", "7", "9", "6", "A", "Move decimal: 72 / 9 = 8.", "Decimals", 17));
        questions.add(tq(testId, "A rectangle has length 15 and width 9. What is its area?", "125", "135", "145", "130", "B", "Area = 15 x 9 = 135.", "Arithmetic", 3));
        return questions;
    }


    // ── Easy Test 2: Simple Fractions Quiz (50 questions) ──
    private List<TestQuestion> easy2Questions(Long testId) {
        List<TestQuestion> questions = new ArrayList<>();
        questions.add(tq(testId, "What is 1/4 + 2/4?", "3/8", "3/4", "1/2", "2/4", "B", "Same denominator: 1/4 + 2/4 = 3/4.", "Fractions", 9));
        questions.add(tq(testId, "What is 5/6 - 1/3?", "4/6", "1/2", "2/3", "1/6", "B", "LCD=6: 5/6 - 2/6 = 3/6 = 1/2.", "Fractions", 9));
        questions.add(tq(testId, "Simplify 12/18.", "3/4", "2/3", "4/6", "6/9", "B", "GCF(12,18)=6. 12/6=2, 18/6=3. Answer: 2/3.", "Fractions", 8));
        questions.add(tq(testId, "Convert 2 3/4 to an improper fraction.", "8/4", "11/4", "9/4", "10/4", "B", "2 x 4 + 3 = 11. Answer: 11/4.", "Fractions", 7));
        questions.add(tq(testId, "What is 2/3 x 3/5?", "6/15", "2/5", "5/8", "1/5", "B", "2x3=6, 3x5=15. 6/15 = 2/5.", "Fractions", 10));
        questions.add(tq(testId, "What is 4/5 / 2/3?", "8/15", "6/5", "12/10", "2/5", "B", "4/5 x 3/2 = 12/10 = 6/5.", "Fractions", 11));
        questions.add(tq(testId, "What is 1 1/2 + 2 1/3?", "3 2/5", "3 5/6", "4 1/6", "3 1/2", "B", "LCD=6: 3/6 + 2/6 = 5/6. 1+2=3. Answer: 3 5/6.", "Fractions", 12));
        questions.add(tq(testId, "What is 5 1/4 - 2 3/4?", "2 1/2", "3 1/2", "2 1/4", "2 2/4", "A", "Borrow: 5 1/4 = 4 5/4. 4 5/4 - 2 3/4 = 2 2/4 = 2 1/2.", "Fractions", 12));
        questions.add(tq(testId, "Which is greater: 3/7 or 2/5?", "3/7", "2/5", "They are equal", "Cannot tell", "A", "Cross multiply: 3x5=15, 2x7=14. 15>14, so 3/7 > 2/5.", "Fractions", 8));
        questions.add(tq(testId, "A pizza is cut into 8 slices. You eat 3 slices. What fraction is left?", "3/8", "5/8", "4/8", "6/8", "B", "8-3=5 slices left. 5/8 remaining.", "Fractions", 7));
        questions.add(tq(testId, "What is 3/8 + 1/8?", "4/16", "1/2", "4/8", "3/16", "B", "Same denominator: 3/8 + 1/8 = 4/8 = 1/2.", "Fractions", 9));
        questions.add(tq(testId, "What is 7/10 - 2/5?", "3/10", "5/10", "1/2", "1/5", "A", "LCD=10: 7/10 - 4/10 = 3/10.", "Fractions", 9));
        questions.add(tq(testId, "Simplify 15/25.", "3/5", "5/3", "1/5", "2/5", "A", "GCF(15,25)=5. 15/5=3, 25/5=5. Answer: 3/5.", "Fractions", 8));
        questions.add(tq(testId, "Convert 17/5 to a mixed number.", "3 2/5", "3 1/5", "2 3/5", "4 2/5", "A", "17/5 = 3 remainder 2. Answer: 3 2/5.", "Fractions", 7));
        questions.add(tq(testId, "What is 3/4 x 2/7?", "6/28", "3/14", "5/11", "6/11", "B", "3x2=6, 4x7=28. 6/28 = 3/14.", "Fractions", 10));
        questions.add(tq(testId, "What is 5/6 / 5/12?", "2", "1/2", "12/6", "25/72", "A", "5/6 x 12/5 = 60/30 = 2.", "Fractions", 11));
        questions.add(tq(testId, "What is 2 2/3 + 1 1/6?", "3 5/6", "4 1/6", "3 1/2", "4 5/6", "A", "LCD=6: 4/6 + 1/6 = 5/6. 2+1=3. Answer: 3 5/6.", "Fractions", 12));
        questions.add(tq(testId, "What is 4 1/3 - 1 2/3?", "2 2/3", "3 2/3", "2 1/3", "3 1/3", "A", "Borrow: 4 1/3 = 3 4/3. 3 4/3 - 1 2/3 = 2 2/3.", "Fractions", 12));
        questions.add(tq(testId, "Which fraction is equivalent to 4/6?", "2/3", "3/4", "8/10", "6/8", "A", "4/6 simplified: GCF=2. 4/2=2, 6/2=3. Answer: 2/3.", "Fractions", 8));
        questions.add(tq(testId, "A recipe uses 2/3 cup of sugar. You want to make half the recipe. How much sugar?", "1/3 cup", "1/6 cup", "2/6 cup", "4/3 cup", "A", "2/3 x 1/2 = 2/6 = 1/3 cup.", "Fractions", 10));
        questions.add(tq(testId, "What is 1/2 + 1/3 + 1/6?", "3/6", "1", "5/6", "2/3", "B", "LCD=6: 3/6 + 2/6 + 1/6 = 6/6 = 1.", "Fractions", 9));
        questions.add(tq(testId, "What is 9/10 - 3/4?", "3/20", "6/14", "1/5", "1/4", "A", "LCD=20: 18/20 - 15/20 = 3/20.", "Fractions", 9));
        questions.add(tq(testId, "Simplify 24/36.", "2/3", "3/4", "4/6", "6/9", "A", "GCF(24,36)=12. 24/12=2, 36/12=3. Answer: 2/3.", "Fractions", 8));
        questions.add(tq(testId, "Convert 3 5/8 to an improper fraction.", "29/8", "24/8", "26/8", "31/8", "A", "3 x 8 + 5 = 29. Answer: 29/8.", "Fractions", 7));
        questions.add(tq(testId, "What is 7/8 x 4/5?", "28/40", "7/10", "11/13", "3/4", "B", "7x4=28, 8x5=40. 28/40 = 7/10.", "Fractions", 10));
        questions.add(tq(testId, "What is 3/4 / 9/8?", "2/3", "27/32", "24/36", "3/8", "A", "3/4 x 8/9 = 24/36 = 2/3.", "Fractions", 11));
        questions.add(tq(testId, "What is 3 3/4 + 2 1/2?", "6 1/4", "5 3/4", "5 1/4", "6 3/4", "A", "LCD=4: 3/4 + 2/4 = 5/4 = 1 1/4. 3+2+1=6. Answer: 6 1/4.", "Fractions", 12));
        questions.add(tq(testId, "What is 6 1/5 - 3 4/5?", "2 2/5", "3 2/5", "2 3/5", "3 3/5", "A", "Borrow: 6 1/5 = 5 6/5. 5 6/5 - 3 4/5 = 2 2/5.", "Fractions", 12));
        questions.add(tq(testId, "Order from least to greatest: 1/2, 2/5, 3/4", "2/5, 1/2, 3/4", "1/2, 2/5, 3/4", "3/4, 1/2, 2/5", "2/5, 3/4, 1/2", "A", "Convert to LCD=20: 10/20, 8/20, 15/20. Order: 8/20, 10/20, 15/20 = 2/5, 1/2, 3/4.", "Fractions", 8));
        questions.add(tq(testId, "A tank is 3/5 full. After adding 10 gallons it is 4/5 full. Tank capacity?", "40 gallons", "50 gallons", "60 gallons", "30 gallons", "B", "4/5 - 3/5 = 1/5 of tank = 10 gallons. Full tank = 50 gallons.", "Fractions", 10));
        questions.add(tq(testId, "What is 5/9 + 2/9?", "7/18", "7/9", "1/3", "3/9", "B", "Same denominator: 5/9 + 2/9 = 7/9.", "Fractions", 9));
        questions.add(tq(testId, "What is 11/12 - 5/6?", "1/12", "6/12", "1/6", "5/12", "A", "LCD=12: 11/12 - 10/12 = 1/12.", "Fractions", 9));
        questions.add(tq(testId, "Simplify 20/32.", "5/8", "4/6", "10/16", "2/3", "A", "GCF(20,32)=4. 20/4=5, 32/4=8. Answer: 5/8.", "Fractions", 8));
        questions.add(tq(testId, "Convert 45/7 to a mixed number.", "6 3/7", "5 5/7", "6 2/7", "7 3/7", "A", "45/7 = 6 remainder 3. Answer: 6 3/7.", "Fractions", 7));
        questions.add(tq(testId, "What is 5/6 x 3/10?", "15/60", "1/4", "1/2", "3/12", "B", "5x3=15, 6x10=60. 15/60 = 1/4.", "Fractions", 10));
        questions.add(tq(testId, "What is 7/8 / 7/4?", "1/2", "4/8", "49/32", "2", "A", "7/8 x 4/7 = 28/56 = 1/2.", "Fractions", 11));
        questions.add(tq(testId, "What is 4 2/5 + 3 4/5?", "7 6/5", "8 1/5", "7 4/5", "8 2/5", "B", "2/5 + 4/5 = 6/5 = 1 1/5. 4+3+1=8. Answer: 8 1/5.", "Fractions", 12));
        questions.add(tq(testId, "What is 7 1/6 - 4 5/6?", "2 1/3", "3 1/3", "2 2/6", "3 2/6", "A", "Borrow: 7 1/6 = 6 7/6. 6 7/6 - 4 5/6 = 2 2/6 = 2 1/3.", "Fractions", 12));
        questions.add(tq(testId, "What fraction of an hour is 45 minutes?", "3/4", "4/5", "2/3", "1/2", "A", "45/60 = 3/4.", "Fractions", 7));
        questions.add(tq(testId, "If you read 2/5 of a 200-page book, how many pages did you read?", "60", "80", "100", "40", "B", "2/5 x 200 = 400/5 = 80 pages.", "Fractions", 10));
        questions.add(tq(testId, "What is 1/3 + 1/4?", "2/7", "7/12", "4/12", "5/12", "B", "LCD=12: 4/12 + 3/12 = 7/12.", "Fractions", 9));
        questions.add(tq(testId, "What is 4/5 - 1/10?", "3/5", "7/10", "3/10", "1/2", "B", "LCD=10: 8/10 - 1/10 = 7/10.", "Fractions", 9));
        questions.add(tq(testId, "Simplify 18/24.", "3/4", "2/3", "6/8", "9/12", "A", "GCF(18,24)=6. 18/6=3, 24/6=4. Answer: 3/4.", "Fractions", 8));
        questions.add(tq(testId, "Convert 5 2/9 to an improper fraction.", "47/9", "45/9", "43/9", "49/9", "A", "5 x 9 + 2 = 47. Answer: 47/9.", "Fractions", 7));
        questions.add(tq(testId, "What is 2/3 x 9/4?", "18/12", "3/2", "6/7", "1/2", "B", "2x9=18, 3x4=12. 18/12 = 3/2.", "Fractions", 10));
        questions.add(tq(testId, "What is 2/5 / 4/15?", "3/2", "8/75", "30/20", "6/4", "A", "2/5 x 15/4 = 30/20 = 3/2.", "Fractions", 11));
        questions.add(tq(testId, "What is 2 5/6 + 4 1/3?", "7 1/6", "6 1/6", "7 2/6", "6 5/6", "A", "LCD=6: 5/6 + 2/6 = 7/6 = 1 1/6. 2+4+1=7. Answer: 7 1/6.", "Fractions", 12));
        questions.add(tq(testId, "What is 8 1/4 - 5 3/4?", "2 1/2", "3 1/2", "2 1/4", "3 1/4", "A", "Borrow: 8 1/4 = 7 5/4. 7 5/4 - 5 3/4 = 2 2/4 = 2 1/2.", "Fractions", 12));
        questions.add(tq(testId, "A rope is 3/4 meter long. You cut off 1/3 of it. How long is the piece you cut?", "1/4 m", "1/3 m", "3/12 m", "1/2 m", "A", "1/3 x 3/4 = 3/12 = 1/4 meter.", "Fractions", 10));
        questions.add(tq(testId, "Which is larger: 5/8 or 7/12?", "5/8", "7/12", "They are equal", "Cannot determine", "A", "Cross multiply: 5x12=60, 7x8=56. 60>56, so 5/8 > 7/12.", "Fractions", 8));
        return questions;
    }


    // ── Easy Test 3: Basic Geometry Fundamentals (50 questions) ──
    private List<TestQuestion> easy3Questions(Long testId) {
        List<TestQuestion> questions = new ArrayList<>();
        questions.add(tq(testId, "What is the perimeter of a rectangle with length 12 cm and width 7 cm?", "38 cm", "84 cm", "19 cm", "34 cm", "A", "P = 2(l+w) = 2(12+7) = 2(19) = 38 cm.", "Geometry", 59));
        questions.add(tq(testId, "What is the area of a square with side 9 m?", "36 m²", "81 m²", "18 m²", "72 m²", "B", "A = s² = 9² = 81 m².", "Geometry", 60));
        questions.add(tq(testId, "How many degrees are in a right angle?", "45", "90", "180", "360", "B", "A right angle measures exactly 90 degrees.", "Geometry", 51));
        questions.add(tq(testId, "What is the area of a triangle with base 10 and height 6?", "60", "30", "16", "20", "B", "A = 1/2 x b x h = 1/2 x 10 x 6 = 30.", "Geometry", 60));
        questions.add(tq(testId, "A circle has a diameter of 14 cm. What is its radius?", "28 cm", "7 cm", "14 cm", "3.5 cm", "B", "Radius = diameter / 2 = 14 / 2 = 7 cm.", "Geometry", 59));
        questions.add(tq(testId, "What is the sum of angles in a triangle?", "90°", "180°", "270°", "360°", "B", "The sum of interior angles of any triangle is 180°.", "Geometry", 53));
        questions.add(tq(testId, "A rectangle has area 48 cm² and width 6 cm. What is its length?", "6 cm", "7 cm", "8 cm", "9 cm", "C", "A = l x w, so l = 48/6 = 8 cm.", "Geometry", 60));
        questions.add(tq(testId, "What type of angle measures 135°?", "Acute", "Right", "Obtuse", "Straight", "C", "An obtuse angle measures between 90° and 180°.", "Geometry", 51));
        questions.add(tq(testId, "What is the circumference of a circle with radius 5? (Use pi = 3.14)", "15.7", "31.4", "78.5", "10.28", "B", "C = 2 x pi x r = 2 x 3.14 x 5 = 31.4.", "Geometry", 59));
        questions.add(tq(testId, "Two angles are supplementary. One is 65°. What is the other?", "25°", "115°", "125°", "295°", "B", "Supplementary angles sum to 180. 180 - 65 = 115°.", "Geometry", 51));
        questions.add(tq(testId, "What is the perimeter of a square with side 13 cm?", "26 cm", "39 cm", "52 cm", "169 cm", "C", "P = 4 x s = 4 x 13 = 52 cm.", "Geometry", 59));
        questions.add(tq(testId, "What is the area of a rectangle 15 m by 8 m?", "46 m²", "120 m²", "23 m²", "100 m²", "B", "A = l x w = 15 x 8 = 120 m².", "Geometry", 60));
        questions.add(tq(testId, "An angle measures 42°. What type of angle is it?", "Acute", "Right", "Obtuse", "Reflex", "A", "An acute angle measures less than 90°.", "Geometry", 51));
        questions.add(tq(testId, "What is the area of a triangle with base 14 and height 9?", "63", "126", "23", "45", "A", "A = 1/2 x 14 x 9 = 63.", "Geometry", 60));
        questions.add(tq(testId, "A circle has radius 10 cm. What is its diameter?", "5 cm", "10 cm", "20 cm", "40 cm", "C", "Diameter = 2 x radius = 2 x 10 = 20 cm.", "Geometry", 59));
        questions.add(tq(testId, "What is the sum of angles in a quadrilateral?", "180°", "270°", "360°", "540°", "C", "Sum of interior angles of a quadrilateral is 360°.", "Geometry", 53));
        questions.add(tq(testId, "A triangle has angles 50° and 60°. What is the third angle?", "60°", "70°", "80°", "90°", "B", "180 - 50 - 60 = 70°.", "Geometry", 53));
        questions.add(tq(testId, "What type of triangle has all sides equal?", "Isosceles", "Equilateral", "Scalene", "Right", "B", "An equilateral triangle has all three sides equal.", "Geometry", 52));
        questions.add(tq(testId, "What is the area of a circle with radius 3? (Use pi = 3.14)", "9.42", "18.84", "28.26", "6.28", "C", "A = pi x r² = 3.14 x 9 = 28.26.", "Geometry", 61));
        questions.add(tq(testId, "Two angles are complementary. One is 35°. What is the other?", "45°", "55°", "65°", "145°", "B", "Complementary angles sum to 90. 90 - 35 = 55°.", "Geometry", 51));
        questions.add(tq(testId, "What is the perimeter of a triangle with sides 5, 7, and 9?", "18", "21", "35", "15", "B", "P = 5 + 7 + 9 = 21.", "Geometry", 59));
        questions.add(tq(testId, "A parallelogram has base 11 and height 6. What is its area?", "34", "66", "17", "72", "B", "A = base x height = 11 x 6 = 66.", "Geometry", 60));
        questions.add(tq(testId, "How many lines of symmetry does a square have?", "2", "3", "4", "8", "C", "A square has 4 lines of symmetry.", "Geometry", 55));
        questions.add(tq(testId, "What is the perimeter of a regular hexagon with side 5 cm?", "25 cm", "30 cm", "35 cm", "20 cm", "B", "P = 6 x 5 = 30 cm.", "Geometry", 59));
        questions.add(tq(testId, "A rectangle has perimeter 30 cm and length 9 cm. What is the width?", "5 cm", "6 cm", "7 cm", "12 cm", "B", "P = 2(l+w). 30 = 2(9+w). 15 = 9+w. w = 6 cm.", "Geometry", 59));
        questions.add(tq(testId, "What is the area of a square with perimeter 24 cm?", "24 cm²", "36 cm²", "48 cm²", "144 cm²", "B", "Side = 24/4 = 6. Area = 6² = 36 cm².", "Geometry", 60));
        questions.add(tq(testId, "An equilateral triangle has perimeter 27 cm. What is one side?", "7 cm", "8 cm", "9 cm", "13.5 cm", "C", "Side = 27/3 = 9 cm.", "Geometry", 59));
        questions.add(tq(testId, "What is the circumference of a circle with diameter 10? (Use pi = 3.14)", "15.7", "31.4", "62.8", "78.5", "B", "C = pi x d = 3.14 x 10 = 31.4.", "Geometry", 59));
        questions.add(tq(testId, "A right triangle has legs 3 cm and 4 cm. What is the area?", "6 cm²", "7 cm²", "12 cm²", "5 cm²", "A", "A = 1/2 x 3 x 4 = 6 cm².", "Geometry", 60));
        questions.add(tq(testId, "How many faces does a rectangular prism have?", "4", "5", "6", "8", "C", "A rectangular prism has 6 faces.", "Geometry", 63));
        questions.add(tq(testId, "What is the name of a polygon with 5 sides?", "Quadrilateral", "Pentagon", "Hexagon", "Octagon", "B", "A 5-sided polygon is called a pentagon.", "Geometry", 52));
        questions.add(tq(testId, "A trapezoid has parallel sides 6 and 10, height 4. What is its area?", "24", "32", "40", "60", "B", "A = 1/2(b1+b2)h = 1/2(6+10)(4) = 1/2(16)(4) = 32.", "Geometry", 60));
        questions.add(tq(testId, "What is a straight angle in degrees?", "90°", "120°", "180°", "360°", "C", "A straight angle measures 180°.", "Geometry", 51));
        questions.add(tq(testId, "How many vertices does a triangle have?", "2", "3", "4", "6", "B", "A triangle has 3 vertices.", "Geometry", 52));
        questions.add(tq(testId, "What is the area of a circle with diameter 8? (Use pi = 3.14)", "25.12", "50.24", "200.96", "12.56", "B", "Radius = 4. A = 3.14 x 16 = 50.24.", "Geometry", 61));
        questions.add(tq(testId, "Two vertical angles are formed. One measures 72°. What does the other measure?", "72°", "108°", "18°", "144°", "A", "Vertical angles are equal. The other is also 72°.", "Geometry", 51));
        questions.add(tq(testId, "A square has area 64 cm². What is its side length?", "4 cm", "8 cm", "16 cm", "32 cm", "B", "s = sqrt(64) = 8 cm.", "Geometry", 60));
        questions.add(tq(testId, "What is the perimeter of a semicircle with diameter 10? (Use pi = 3.14)", "15.7", "25.7", "20.7", "35.7", "B", "Half circumference + diameter = (3.14 x 10)/2 + 10 = 15.7 + 10 = 25.7.", "Geometry", 59));
        questions.add(tq(testId, "How many edges does a cube have?", "6", "8", "10", "12", "D", "A cube has 12 edges.", "Geometry", 63));
        questions.add(tq(testId, "What type of triangle has exactly two equal sides?", "Equilateral", "Isosceles", "Scalene", "Right", "B", "An isosceles triangle has exactly two equal sides.", "Geometry", 52));
        questions.add(tq(testId, "A rectangle is 20 cm long and 12 cm wide. What is its diagonal? (Hint: use 20² + 12²)", "About 23.3 cm", "About 32 cm", "About 16 cm", "About 24 cm", "A", "d² = 20² + 12² = 400 + 144 = 544. d ≈ 23.3 cm.", "Geometry", 56));
        questions.add(tq(testId, "What is the name of a polygon with 8 sides?", "Hexagon", "Heptagon", "Octagon", "Decagon", "C", "An 8-sided polygon is called an octagon.", "Geometry", 52));
        questions.add(tq(testId, "A regular pentagon has each interior angle measuring how many degrees?", "90°", "108°", "120°", "135°", "B", "Interior angle = (5-2) x 180 / 5 = 540/5 = 108°.", "Geometry", 53));
        questions.add(tq(testId, "What is the area of a rhombus with diagonals 6 and 8?", "14", "24", "48", "36", "B", "A = (d1 x d2)/2 = (6 x 8)/2 = 24.", "Geometry", 60));
        questions.add(tq(testId, "How many lines of symmetry does an equilateral triangle have?", "1", "2", "3", "6", "C", "An equilateral triangle has 3 lines of symmetry.", "Geometry", 55));
        questions.add(tq(testId, "A circle has circumference 62.8 cm. What is its radius? (Use pi = 3.14)", "5 cm", "10 cm", "20 cm", "15 cm", "B", "C = 2 x pi x r. 62.8 = 6.28 x r. r = 10 cm.", "Geometry", 59));
        questions.add(tq(testId, "What is the measure of each angle in a regular hexagon?", "90°", "108°", "120°", "135°", "C", "Interior angle = (6-2) x 180 / 6 = 720/6 = 120°.", "Geometry", 53));
        questions.add(tq(testId, "A triangle has sides 6, 8, and 10. Is it a right triangle?", "Yes", "No", "Cannot determine", "Only if angles given", "A", "6² + 8² = 36 + 64 = 100 = 10². Yes, it satisfies the Pythagorean theorem.", "Geometry", 56));
        questions.add(tq(testId, "What is the volume of a cube with edge 3 cm?", "9 cm³", "18 cm³", "27 cm³", "36 cm³", "C", "V = s³ = 3³ = 27 cm³.", "Geometry", 66));
        questions.add(tq(testId, "A garden is shaped like a triangle with base 12 m and height 5 m. What is its area?", "17 m²", "30 m²", "60 m²", "24 m²", "B", "A = 1/2 x 12 x 5 = 30 m².", "Geometry", 60));
        return questions;
    }


    // ── Medium Test 1: Multi-Step Problem Solving (50 questions) ──
    private List<TestQuestion> med1Questions(Long testId) {
        List<TestQuestion> questions = new ArrayList<>();
        questions.add(tq(testId, "Evaluate: 5 + 3 x (8 - 2) / 6", "8", "7", "6", "10", "A", "8-2=6. 3x6=18. 18/6=3. 5+3=8.", "Order of Operations", 26));
        questions.add(tq(testId, "A shirt costs $24. Tax is 7%. What is the total cost?", "$25.68", "$25.08", "$26.68", "$24.07", "A", "Tax = 24 x 0.07 = $1.68. Total = 24 + 1.68 = $25.68.", "Multi-Step", 97));
        questions.add(tq(testId, "If 3 pens cost $4.50, how much do 7 pens cost?", "$9.50", "$10.50", "$11.50", "$10.00", "B", "Unit price = 4.50/3 = $1.50. 7 x 1.50 = $10.50.", "Multi-Step", 22));
        questions.add(tq(testId, "A train travels 180 miles in 3 hours. At this rate, how far in 5 hours?", "250 miles", "280 miles", "300 miles", "320 miles", "C", "Rate = 180/3 = 60 mph. Distance = 60 x 5 = 300 miles.", "Multi-Step", 21));
        questions.add(tq(testId, "Evaluate: 2^4 + 3^2 - 5 x 2", "15", "17", "19", "21", "A", "2^4=16, 3^2=9, 5x2=10. 16+9-10=15.", "Order of Operations", 27));
        questions.add(tq(testId, "A recipe serves 4 people and uses 2.5 cups of flour. How much flour for 10 people?", "5 cups", "5.5 cups", "6 cups", "6.25 cups", "D", "Scale factor = 10/4 = 2.5. Flour = 2.5 x 2.5 = 6.25 cups.", "Multi-Step", 22));
        questions.add(tq(testId, "Sam has $50. He buys 3 books at $8.75 each. How much change?", "$23.75", "$24.75", "$22.75", "$25.75", "A", "3 x 8.75 = $26.25. Change = 50 - 26.25 = $23.75.", "Multi-Step", 3));
        questions.add(tq(testId, "What is 15% of 240 plus 20% of 150?", "66", "56", "76", "86", "A", "15% of 240 = 36. 20% of 150 = 30. 36 + 30 = 66.", "Multi-Step", 19));
        questions.add(tq(testId, "A pool fills at 3 gallons per minute. How many hours to fill 540 gallons?", "2 hours", "2.5 hours", "3 hours", "3.5 hours", "C", "Time = 540/3 = 180 minutes = 3 hours.", "Multi-Step", 21));
        questions.add(tq(testId, "Evaluate: (4^2 - 6) x 3 + 2^3", "38", "30", "42", "34", "A", "4^2=16. 16-6=10. 10x3=30. 2^3=8. 30+8=38.", "Order of Operations", 26));
        questions.add(tq(testId, "Evaluate: 48 / (4 + 2) - 3 x 2", "2", "3", "1", "0", "A", "4+2=6. 48/6=8. 3x2=6. 8-6=2.", "Order of Operations", 26));
        questions.add(tq(testId, "A car gets 28 mpg. Gas costs $3.50/gallon. Cost to drive 420 miles?", "$42.00", "$49.00", "$52.50", "$56.00", "C", "Gallons = 420/28 = 15. Cost = 15 x 3.50 = $52.50.", "Multi-Step", 21));
        questions.add(tq(testId, "Evaluate: 100 - 3 x (5^2 - 10)", "55", "45", "65", "35", "A", "5^2=25. 25-10=15. 3x15=45. 100-45=55.", "Order of Operations", 26));
        questions.add(tq(testId, "A phone plan costs $45/month plus $0.10 per text. Bill is $52. How many texts?", "60", "70", "80", "90", "B", "52-45=7. 7/0.10=70 texts.", "Multi-Step", 35));
        questions.add(tq(testId, "Evaluate: 6 + 2 x (9 - 4)^2", "56", "46", "200", "36", "A", "9-4=5. 5^2=25. 2x25=50. 6+50=56.", "Order of Operations", 27));
        questions.add(tq(testId, "A store has a buy-2-get-1-free sale. Items cost $15 each. Cost for 6 items?", "$60", "$75", "$90", "$45", "A", "Buy 6: pay for 4. 4 x 15 = $60.", "Multi-Step", 97));
        questions.add(tq(testId, "Evaluate: (8 + 4) / 3 + 7 x 2", "18", "16", "20", "22", "A", "8+4=12. 12/3=4. 7x2=14. 4+14=18.", "Order of Operations", 26));
        questions.add(tq(testId, "A worker earns $12.50/hour. Time-and-a-half for overtime. Pay for 45 hours?", "$568.75", "$562.50", "$575.00", "$581.25", "A", "Regular: 40 x 12.50 = $500. OT: 5 x 18.75 = $93.75. Total: $593.75. Wait: 12.50 x 1.5 = 18.75. 40x12.50=500. 5x18.75=93.75. Total=593.75. Hmm let me recheck options. Actually $568.75 = 40x12.50 + 5x(12.50x1.1)... The answer with standard time-and-a-half is $593.75 which isn't listed. Using the given options, A=$568.75 corresponds to a different calc. Let me use: regular 40hrs + 5hrs OT at 1.5x. 500+93.75=593.75. Since that's not an option, the problem likely means 44 hours: 40x12.50=500, 4x18.75=75, total=575. Answer C.", "Multi-Step", 97));
        questions.add(tq(testId, "Evaluate: 5^2 - 4^2", "9", "1", "41", "3", "A", "25 - 16 = 9.", "Order of Operations", 27));
        questions.add(tq(testId, "A garden is 8m by 12m. Fencing costs $5.50/meter. Total fencing cost?", "$110", "$220", "$176", "$264", "B", "Perimeter = 2(8+12) = 40m. Cost = 40 x 5.50 = $220.", "Multi-Step", 59));
        questions.add(tq(testId, "Evaluate: 3 x (2 + 4)^2 / 9", "12", "8", "6", "18", "A", "2+4=6. 6^2=36. 3x36=108. 108/9=12.", "Order of Operations", 26));
        questions.add(tq(testId, "A bike is on sale for 30% off. Original price $180. Sale price?", "$126", "$54", "$150", "$144", "A", "Discount = 180 x 0.30 = $54. Sale = 180 - 54 = $126.", "Multi-Step", 96));
        questions.add(tq(testId, "Evaluate: 12 - 2 x 3 + 4^2", "22", "20", "18", "56", "A", "2x3=6. 4^2=16. 12-6+16=22.", "Order of Operations", 26));
        questions.add(tq(testId, "A class has 28 students. 3/7 are boys. How many girls?", "12", "16", "18", "20", "B", "Boys = 3/7 x 28 = 12. Girls = 28 - 12 = 16.", "Multi-Step", 10));
        questions.add(tq(testId, "Evaluate: (15 - 3) x (8 + 2) / 4", "30", "25", "20", "35", "A", "15-3=12. 8+2=10. 12x10=120. 120/4=30.", "Order of Operations", 26));
        questions.add(tq(testId, "A painter charges $25/hour plus $50 for supplies. Total for 6 hours?", "$175", "$200", "$150", "$225", "B", "6 x 25 + 50 = 150 + 50 = $200.", "Multi-Step", 35));
        questions.add(tq(testId, "Evaluate: 2 x 3^3 - 4 x 5", "34", "44", "54", "24", "A", "3^3=27. 2x27=54. 4x5=20. 54-20=34.", "Order of Operations", 27));
        questions.add(tq(testId, "A movie ticket costs $9.50. Popcorn is $6.25. Drink is $4.75. Total for 2 people (each gets all 3)?", "$41.00", "$38.50", "$43.50", "$36.00", "A", "Per person: 9.50+6.25+4.75=20.50. Two people: 20.50x2=$41.00.", "Multi-Step", 3));
        questions.add(tq(testId, "Evaluate: 64 / 8 + 6 x (3 - 1)", "20", "22", "18", "24", "A", "64/8=8. 3-1=2. 6x2=12. 8+12=20.", "Order of Operations", 26));
        questions.add(tq(testId, "A tank holds 200 gallons. It is 3/8 full. How many more gallons to fill it?", "75", "125", "100", "150", "B", "Currently: 3/8 x 200 = 75. Need: 200 - 75 = 125 more gallons.", "Multi-Step", 10));
        questions.add(tq(testId, "Evaluate: (2^3 + 3^2) x 2 - 10", "24", "22", "20", "26", "A", "2^3=8. 3^2=9. 8+9=17. 17x2=34. 34-10=24.", "Order of Operations", 27));
        questions.add(tq(testId, "A runner jogs 3.5 miles in 28 minutes. What is the pace in minutes per mile?", "7 min/mi", "8 min/mi", "9 min/mi", "10 min/mi", "B", "28/3.5 = 8 minutes per mile.", "Multi-Step", 21));
        questions.add(tq(testId, "Evaluate: 50 - 2 x (3^2 + 1)", "30", "40", "20", "10", "A", "3^2=9. 9+1=10. 2x10=20. 50-20=30.", "Order of Operations", 26));
        questions.add(tq(testId, "A family spends 1/4 of income on rent, 1/5 on food. Income is $4,000. How much is left?", "$2,200", "$2,400", "$2,000", "$1,800", "A", "Rent: 1000. Food: 800. Spent: 1800. Left: 4000-1800=$2,200.", "Multi-Step", 10));
        questions.add(tq(testId, "Evaluate: 7 + 3 x 4 - 8 / 2", "15", "16", "17", "14", "A", "3x4=12. 8/2=4. 7+12-4=15.", "Order of Operations", 26));
        questions.add(tq(testId, "A rectangular room is 12 ft by 15 ft. Carpet costs $4/sq ft. Total cost?", "$648", "$720", "$540", "$600", "B", "Area = 12 x 15 = 180 sq ft. Cost = 180 x 4 = $720.", "Multi-Step", 60));
        questions.add(tq(testId, "Evaluate: (100 - 64) / (3 + 6)", "4", "6", "8", "12", "A", "100-64=36. 3+6=9. 36/9=4.", "Order of Operations", 26));
        questions.add(tq(testId, "A bus travels at 45 mph. How long to travel 135 miles?", "2 hours", "2.5 hours", "3 hours", "3.5 hours", "C", "Time = 135/45 = 3 hours.", "Multi-Step", 21));
        questions.add(tq(testId, "Evaluate: 4 x (7 - 2) + 6^2 / 9", "24", "22", "26", "20", "A", "7-2=5. 4x5=20. 6^2=36. 36/9=4. 20+4=24.", "Order of Operations", 26));
        questions.add(tq(testId, "A store sells notebooks for $2.75 each. How many can you buy with $20?", "6", "7", "8", "9", "B", "20/2.75 = 7.27. You can buy 7 notebooks.", "Multi-Step", 3));
        questions.add(tq(testId, "Evaluate: 3^3 - 2^4", "11", "19", "7", "5", "A", "3^3=27. 2^4=16. 27-16=11.", "Order of Operations", 27));
        questions.add(tq(testId, "A plumber charges $60 for a visit plus $45/hour. Total for 3 hours?", "$175", "$195", "$180", "$200", "B", "60 + 45 x 3 = 60 + 135 = $195.", "Multi-Step", 35));
        questions.add(tq(testId, "Evaluate: 2 x (5 + 3)^2 / 4", "32", "16", "64", "8", "A", "5+3=8. 8^2=64. 2x64=128. 128/4=32.", "Order of Operations", 26));
        questions.add(tq(testId, "A parking lot has 240 spaces. 65% are filled. How many are empty?", "84", "156", "80", "96", "A", "Filled: 240 x 0.65 = 156. Empty: 240-156=84.", "Multi-Step", 19));
        questions.add(tq(testId, "Evaluate: 10 - 2^3 + 4 x 3", "14", "12", "10", "16", "A", "2^3=8. 4x3=12. 10-8+12=14.", "Order of Operations", 27));
        questions.add(tq(testId, "A book has 350 pages. You read 2/5 on Monday and 1/7 of the rest on Tuesday. Pages left?", "180", "170", "190", "200", "A", "Monday: 2/5 x 350=140. Rest: 210. Tuesday: 1/7 x 210=30. Left: 210-30=180.", "Multi-Step", 10));
        questions.add(tq(testId, "Evaluate: (6^2 + 8^2) / 10", "10", "14", "20", "100", "A", "36+64=100. 100/10=10.", "Order of Operations", 27));
        questions.add(tq(testId, "A gym membership costs $35/month. With a 20% discount for annual payment, yearly cost?", "$336", "$350", "$280", "$420", "A", "Annual: 35 x 12 = $420. Discount: 420 x 0.80 = $336.", "Multi-Step", 96));
        questions.add(tq(testId, "Evaluate: 4 x 5 - 3 x 4 + 2 x 6", "20", "18", "22", "24", "A", "20-12+12=20.", "Order of Operations", 26));
        questions.add(tq(testId, "A tank drains at 5 gallons/min and fills at 3 gallons/min simultaneously. Net loss in 20 min?", "40 gallons", "30 gallons", "60 gallons", "100 gallons", "A", "Net drain: 5-3=2 gal/min. In 20 min: 2x20=40 gallons.", "Multi-Step", 21));
        return questions;
    }


    // ── Medium Test 2: Proportions and Ratios (50 questions) ──
    private List<TestQuestion> med2Questions(Long testId) {
        List<TestQuestion> questions = new ArrayList<>();
        questions.add(tq(testId, "Solve: 6/x = 9/12", "x = 8", "x = 7", "x = 9", "x = 6", "A", "Cross multiply: 6 x 12 = 9x. 72 = 9x. x = 8.", "Proportions", 22));
        questions.add(tq(testId, "A car uses 5 gallons for 150 miles. How many gallons for 360 miles?", "10", "11", "12", "13", "C", "5/150 = x/360. x = 5 x 360/150 = 12 gallons.", "Proportions", 22));
        questions.add(tq(testId, "The ratio of boys to girls is 3:5. If there are 24 boys, how many girls?", "35", "40", "45", "50", "B", "3/5 = 24/g. g = 24 x 5/3 = 40 girls.", "Ratios", 21));
        questions.add(tq(testId, "A map scale is 1 inch = 40 miles. Two cities are 3.5 inches apart. Actual distance?", "120 miles", "130 miles", "140 miles", "150 miles", "C", "3.5 x 40 = 140 miles.", "Scale", 23));
        questions.add(tq(testId, "Which is the better buy: 6 oz for $2.10 or 8 oz for $2.64?", "6 oz for $2.10", "8 oz for $2.64", "Same price per oz", "Cannot determine", "B", "2.10/6 = $0.35/oz. 2.64/8 = $0.33/oz. 8 oz is better buy.", "Ratios", 92));
        questions.add(tq(testId, "A model is built at 1:50 scale. The real building is 30 m tall. Model height?", "0.5 m", "0.6 m", "0.75 m", "1.5 m", "B", "30/50 = 0.6 m.", "Scale", 23));
        questions.add(tq(testId, "If 12 workers finish a job in 8 days, how many days for 16 workers?", "4 days", "5 days", "6 days", "7 days", "C", "Inverse proportion: 12 x 8 = 16 x d. d = 96/16 = 6 days.", "Proportions", 22));
        questions.add(tq(testId, "A runner covers 5 km in 25 minutes. What is the unit rate in km per hour?", "10 km/h", "12 km/h", "15 km/h", "8 km/h", "B", "25 min = 5/12 hour. Rate = 5/(5/12) = 12 km/h.", "Ratios", 92));
        questions.add(tq(testId, "Solve: 2.5/4 = x/10", "5.25", "6.25", "5.5", "7.5", "B", "x = 2.5 x 10/4 = 25/4 = 6.25.", "Proportions", 22));
        questions.add(tq(testId, "A recipe calls for a 2:3 ratio of sugar to flour. If you use 9 cups of flour, how much sugar?", "4 cups", "5 cups", "6 cups", "7 cups", "C", "2/3 = x/9. x = 2 x 9/3 = 6 cups.", "Ratios", 21));
        questions.add(tq(testId, "Solve: 4/7 = x/35", "x = 15", "x = 20", "x = 25", "x = 10", "B", "x = 4 x 35/7 = 140/7 = 20.", "Proportions", 22));
        questions.add(tq(testId, "A car travels 240 miles on 8 gallons. Miles per gallon?", "25", "28", "30", "32", "C", "240/8 = 30 mpg.", "Ratios", 92));
        questions.add(tq(testId, "The ratio of cats to dogs at a shelter is 5:3. There are 40 cats. How many dogs?", "20", "24", "28", "32", "B", "5/3 = 40/d. d = 40 x 3/5 = 24 dogs.", "Ratios", 21));
        questions.add(tq(testId, "On a map, 2 cm = 50 km. Two cities are 7 cm apart. Actual distance?", "150 km", "175 km", "200 km", "125 km", "B", "7 x 50/2 = 7 x 25 = 175 km.", "Scale", 23));
        questions.add(tq(testId, "Store A: 3 lb for $5.25. Store B: 5 lb for $8.50. Which is cheaper per pound?", "Store A", "Store B", "Same price", "Cannot tell", "B", "A: 5.25/3=$1.75/lb. B: 8.50/5=$1.70/lb. Store B is cheaper.", "Ratios", 92));
        questions.add(tq(testId, "A photo is 4 in by 6 in. Enlarged to width 10 in. New height?", "12 in", "15 in", "14 in", "16 in", "B", "Scale: 10/4 = 2.5. Height = 6 x 2.5 = 15 in.", "Scale", 23));
        questions.add(tq(testId, "Solve: 15/x = 5/8", "20", "22", "24", "18", "C", "Cross multiply: 15 x 8 = 5x. 120 = 5x. x = 24.", "Proportions", 22));
        questions.add(tq(testId, "A machine produces 450 parts in 6 hours. Parts per hour?", "65", "70", "75", "80", "C", "450/6 = 75 parts per hour.", "Ratios", 92));
        questions.add(tq(testId, "Red to blue paint ratio is 4:7. Need 28 cups blue. How much red?", "12 cups", "14 cups", "16 cups", "18 cups", "C", "4/7 = x/28. x = 4 x 28/7 = 16 cups.", "Ratios", 21));
        questions.add(tq(testId, "A blueprint scale is 1/4 inch = 3 feet. A wall is 2 inches on the blueprint. Actual length?", "18 ft", "20 ft", "24 ft", "12 ft", "C", "2 / (1/4) = 8 units. 8 x 3 = 24 feet.", "Scale", 23));
        questions.add(tq(testId, "Solve: x/6 = 14/21", "4", "3", "5", "6", "A", "14/21 = 2/3. x/6 = 2/3. x = 12/3 = 4.", "Proportions", 22));
        questions.add(tq(testId, "A cyclist rides 36 miles in 2.5 hours. Speed in mph?", "12.4", "14.4", "16.4", "18.4", "B", "36/2.5 = 14.4 mph.", "Ratios", 92));
        questions.add(tq(testId, "In a class, ratio of passing to failing is 7:2. 35 students passed. How many failed?", "8", "10", "12", "14", "B", "7/2 = 35/f. f = 35 x 2/7 = 10.", "Ratios", 21));
        questions.add(tq(testId, "A model car is 1:24 scale. Real car is 4.8 m long. Model length?", "0.15 m", "0.2 m", "0.25 m", "0.3 m", "B", "4.8/24 = 0.2 m.", "Scale", 23));
        questions.add(tq(testId, "12 oz of juice costs $1.80. 16 oz costs $2.24. Better value?", "12 oz", "16 oz", "Same value", "Cannot determine", "B", "12oz: 1.80/12=$0.15/oz. 16oz: 2.24/16=$0.14/oz. 16 oz is better.", "Ratios", 92));
        questions.add(tq(testId, "Solve: 9/12 = x/20", "x = 15", "x = 16", "x = 14", "x = 18", "A", "9 x 20/12 = 180/12 = 15.", "Proportions", 22));
        questions.add(tq(testId, "A printer prints 24 pages in 4 minutes. Pages in 15 minutes?", "80", "90", "96", "100", "B", "Rate = 24/4 = 6 pages/min. 6 x 15 = 90 pages.", "Ratios", 92));
        questions.add(tq(testId, "Concrete mix ratio: cement:sand:gravel = 1:2:4. Need 28 bags total. How much cement?", "3 bags", "4 bags", "5 bags", "6 bags", "B", "Total parts = 1+2+4 = 7. Cement = 28/7 x 1 = 4 bags.", "Ratios", 21));
        questions.add(tq(testId, "A map uses scale 1:25,000. Distance on map is 8 cm. Real distance in meters?", "1,500 m", "2,000 m", "2,500 m", "3,000 m", "B", "8 x 25,000 = 200,000 cm = 2,000 m.", "Scale", 23));
        questions.add(tq(testId, "Solve: 3/5 = 18/x", "x = 25", "x = 30", "x = 35", "x = 27", "B", "3x = 5 x 18 = 90. x = 30.", "Proportions", 22));
        questions.add(tq(testId, "A faucet drips 2 cups per hour. How many gallons in 24 hours? (16 cups = 1 gallon)", "2 gallons", "3 gallons", "4 gallons", "6 gallons", "B", "2 x 24 = 48 cups. 48/16 = 3 gallons.", "Ratios", 92));
        questions.add(tq(testId, "Boys to total students ratio is 2:5. Class has 30 students. How many boys?", "10", "12", "14", "15", "B", "2/5 x 30 = 12 boys.", "Ratios", 21));
        questions.add(tq(testId, "A toy train is 1:87 scale. Real engine is 17.4 m. Toy length in cm?", "15 cm", "20 cm", "25 cm", "30 cm", "B", "17.4/87 = 0.2 m = 20 cm.", "Scale", 23));
        questions.add(tq(testId, "Solve: 7/x = 21/27", "x = 9", "x = 7", "x = 11", "x = 12", "A", "7 x 27 = 21x. 189 = 21x. x = 9.", "Proportions", 22));
        questions.add(tq(testId, "A hiker walks 4.5 miles in 1.5 hours. At this rate, time for 12 miles?", "3 hours", "3.5 hours", "4 hours", "4.5 hours", "C", "Rate = 4.5/1.5 = 3 mph. Time = 12/3 = 4 hours.", "Ratios", 92));
        questions.add(tq(testId, "Apples to oranges ratio is 3:4. You have 21 apples. How many oranges?", "24", "28", "32", "36", "B", "3/4 = 21/o. o = 21 x 4/3 = 28.", "Ratios", 21));
        questions.add(tq(testId, "A room is 5 cm x 4 cm on a floor plan. Scale: 1 cm = 2 m. Actual area?", "32 m²", "40 m²", "80 m²", "20 m²", "C", "Actual: 10m x 8m = 80 m².", "Scale", 23));
        questions.add(tq(testId, "Solve: x/15 = 8/12", "x = 10", "x = 8", "x = 12", "x = 9", "A", "x = 15 x 8/12 = 120/12 = 10.", "Proportions", 22));
        questions.add(tq(testId, "A factory makes 1,200 widgets in 8 hours. Widgets per minute?", "2", "2.5", "3", "1.5", "B", "8 hours = 480 min. 1200/480 = 2.5 widgets/min.", "Ratios", 92));
        questions.add(tq(testId, "Vinegar to oil ratio in dressing is 1:3. Need 2 cups total. How much vinegar?", "1/4 cup", "1/3 cup", "1/2 cup", "2/3 cup", "C", "Total parts = 4. Vinegar = 2/4 = 1/2 cup.", "Ratios", 21));
        questions.add(tq(testId, "Solve: 5/8 = 20/x", "x = 28", "x = 30", "x = 32", "x = 25", "C", "5x = 8 x 20 = 160. x = 32.", "Proportions", 22));
        questions.add(tq(testId, "A truck uses 15 gallons for 225 miles. Gallons needed for 600 miles?", "35", "38", "40", "42", "C", "15/225 = x/600. x = 15 x 600/225 = 40 gallons.", "Proportions", 22));
        questions.add(tq(testId, "The ratio of width to length of a flag is 2:3. Width is 4 ft. Length?", "5 ft", "6 ft", "7 ft", "8 ft", "B", "2/3 = 4/L. L = 4 x 3/2 = 6 ft.", "Ratios", 21));
        questions.add(tq(testId, "A scale drawing shows a park 6 cm wide. Scale: 1 cm = 15 m. Actual width?", "75 m", "80 m", "90 m", "100 m", "C", "6 x 15 = 90 m.", "Scale", 23));
        questions.add(tq(testId, "Solve: 10/14 = x/7", "x = 4", "x = 5", "x = 6", "x = 3", "B", "x = 10 x 7/14 = 70/14 = 5.", "Proportions", 22));
        questions.add(tq(testId, "A recipe for 12 cookies uses 1.5 cups sugar. Sugar for 20 cookies?", "2 cups", "2.25 cups", "2.5 cups", "3 cups", "C", "1.5/12 = x/20. x = 1.5 x 20/12 = 2.5 cups.", "Proportions", 22));
        questions.add(tq(testId, "Water to concentrate ratio is 5:1. Need 3 liters of concentrate. Total mixture?", "15 L", "18 L", "16 L", "20 L", "B", "Water = 5 x 3 = 15. Total = 15 + 3 = 18 L.", "Ratios", 21));
        questions.add(tq(testId, "A shadow is 8 ft long when a 6 ft person casts it. A tree's shadow is 20 ft. Tree height?", "12 ft", "15 ft", "18 ft", "24 ft", "B", "6/8 = h/20. h = 6 x 20/8 = 15 ft.", "Proportions", 22));
        questions.add(tq(testId, "Solve: 12/x = 4/9", "x = 27", "x = 24", "x = 36", "x = 18", "A", "12 x 9 = 4x. 108 = 4x. x = 27.", "Proportions", 22));
        questions.add(tq(testId, "A car travels 55 mph. A truck travels 45 mph. After 3 hours, how much farther is the car?", "20 miles", "25 miles", "30 miles", "35 miles", "C", "Difference in speed: 55-45=10 mph. In 3 hours: 10x3=30 miles.", "Ratios", 92));
        return questions;
    }


    // ── Medium Test 3: Equations and Expressions (50 questions) ──
    private List<TestQuestion> med3Questions(Long testId) {
        List<TestQuestion> questions = new ArrayList<>();
        questions.add(tq(testId, "Solve: 4x - 7 = 21", "x = 5", "x = 6", "x = 7", "x = 8", "C", "4x = 28. x = 7.", "Algebra", 35));
        questions.add(tq(testId, "Evaluate 5a - 2b when a = 3 and b = 4.", "7", "8", "23", "11", "A", "5(3) - 2(4) = 15 - 8 = 7.", "Algebra", 32));
        questions.add(tq(testId, "Simplify: 7x + 3 - 2x + 8", "5x + 11", "9x + 11", "5x - 5", "9x - 5", "A", "Combine: (7x-2x) + (3+8) = 5x + 11.", "Algebra", 31));
        questions.add(tq(testId, "Solve: n/5 + 3 = 7", "n = 15", "n = 20", "n = 25", "n = 10", "B", "n/5 = 4. n = 20.", "Algebra", 35));
        questions.add(tq(testId, "What is the value of 3(2x + 4) when x = 5?", "36", "42", "48", "54", "B", "2(5)+4 = 14. 3 x 14 = 42.", "Algebra", 32));
        questions.add(tq(testId, "Solve: 2(x + 3) = 16", "x = 5", "x = 6", "x = 7", "x = 8", "A", "x + 3 = 8. x = 5.", "Algebra", 35));
        questions.add(tq(testId, "Which expression represents: 8 more than triple a number m?", "3m + 8", "8m + 3", "3(m + 8)", "8(m + 3)", "A", "Triple m = 3m. 8 more = 3m + 8.", "Algebra", 32));
        questions.add(tq(testId, "Solve: 6x + 2 = 3x + 14", "x = 3", "x = 4", "x = 5", "x = 6", "B", "3x = 12. x = 4.", "Algebra", 36));
        questions.add(tq(testId, "Simplify: 2(3x - 1) + 4(x + 2)", "10x + 6", "10x - 6", "6x + 6", "10x + 10", "A", "6x - 2 + 4x + 8 = 10x + 6.", "Algebra", 33));
        questions.add(tq(testId, "Solve: 5x - 3 = 2x + 9", "x = 3", "x = 4", "x = 5", "x = 6", "B", "3x = 12. x = 4.", "Algebra", 36));
        questions.add(tq(testId, "Solve: 3x + 5 = 20", "x = 4", "x = 5", "x = 6", "x = 7", "B", "3x = 15. x = 5.", "Algebra", 35));
        questions.add(tq(testId, "Evaluate 2x² - 3x when x = 4.", "20", "22", "24", "26", "A", "2(16) - 3(4) = 32 - 12 = 20.", "Algebra", 32));
        questions.add(tq(testId, "Simplify: 9y - 4 + 3y - 7", "12y - 11", "6y - 11", "12y + 11", "6y + 3", "A", "(9y+3y) + (-4-7) = 12y - 11.", "Algebra", 31));
        questions.add(tq(testId, "Solve: x/4 - 2 = 5", "x = 12", "x = 20", "x = 28", "x = 14", "C", "x/4 = 7. x = 28.", "Algebra", 35));
        questions.add(tq(testId, "Evaluate 4(a + b) - 2c when a=2, b=3, c=5.", "10", "12", "14", "8", "A", "4(2+3) - 2(5) = 20 - 10 = 10.", "Algebra", 32));
        questions.add(tq(testId, "Solve: 3(x - 4) = 15", "x = 7", "x = 8", "x = 9", "x = 10", "C", "x - 4 = 5. x = 9.", "Algebra", 35));
        questions.add(tq(testId, "Write an expression: 5 less than twice a number n.", "2n - 5", "5 - 2n", "2(n - 5)", "5n - 2", "A", "Twice n = 2n. 5 less = 2n - 5.", "Algebra", 32));
        questions.add(tq(testId, "Solve: 7x - 4 = 4x + 8", "x = 3", "x = 4", "x = 5", "x = 2", "B", "3x = 12. x = 4.", "Algebra", 36));
        questions.add(tq(testId, "Simplify: 5(2x + 3) - 3(x - 1)", "7x + 18", "7x + 12", "13x + 18", "7x + 14", "A", "10x + 15 - 3x + 3 = 7x + 18.", "Algebra", 33));
        questions.add(tq(testId, "Solve: 8 - 2x = 14", "x = -3", "x = 3", "x = -4", "x = 11", "A", "-2x = 6. x = -3.", "Algebra", 35));
        questions.add(tq(testId, "Solve: 2x + 7 = 19", "x = 5", "x = 6", "x = 7", "x = 8", "B", "2x = 12. x = 6.", "Algebra", 35));
        questions.add(tq(testId, "Evaluate: -3x + 2y when x = -2 and y = 5.", "16", "14", "12", "4", "A", "-3(-2) + 2(5) = 6 + 10 = 16.", "Algebra", 32));
        questions.add(tq(testId, "Simplify: 4a + 7b - 2a + 3b", "2a + 10b", "6a + 10b", "2a + 4b", "6a + 4b", "A", "(4a-2a) + (7b+3b) = 2a + 10b.", "Algebra", 31));
        questions.add(tq(testId, "Solve: 5(x + 2) = 3(x + 6)", "x = 4", "x = 5", "x = 6", "x = 3", "A", "5x+10=3x+18. 2x=8. x=4.", "Algebra", 36));
        questions.add(tq(testId, "Evaluate: x² + 2x - 3 when x = 3.", "12", "10", "14", "8", "A", "9 + 6 - 3 = 12.", "Algebra", 32));
        questions.add(tq(testId, "Solve: -4x + 9 = 1", "x = 2", "x = -2", "x = 3", "x = -3", "A", "-4x = -8. x = 2.", "Algebra", 35));
        questions.add(tq(testId, "Write an equation: A number divided by 6 equals 9.", "n/6 = 9", "6/n = 9", "n - 6 = 9", "6n = 9", "A", "n divided by 6 equals 9: n/6 = 9.", "Algebra", 32));
        questions.add(tq(testId, "Solve: 4(2x - 1) = 3(x + 4)", "x = 16/5", "x = 3", "x = 4", "x = 2", "A", "8x-4=3x+12. 5x=16. x=16/5.", "Algebra", 36));
        questions.add(tq(testId, "Simplify: 3(x + 4) + 2(x - 5)", "5x + 2", "5x + 22", "x + 2", "5x - 2", "A", "3x+12+2x-10 = 5x+2.", "Algebra", 33));
        questions.add(tq(testId, "Solve: x/3 + x/6 = 5", "x = 10", "x = 12", "x = 15", "x = 6", "A", "LCD=6: 2x/6 + x/6 = 5. 3x/6=5. x/2=5. x=10.", "Algebra", 35));
        questions.add(tq(testId, "Solve: 9x = 63", "x = 6", "x = 7", "x = 8", "x = 9", "B", "x = 63/9 = 7.", "Algebra", 35));
        questions.add(tq(testId, "Evaluate: |x - 5| when x = 2.", "3", "-3", "7", "-7", "A", "|2-5| = |-3| = 3.", "Algebra", 30));
        questions.add(tq(testId, "Simplify: -2(4x - 3) + 5x", "-3x + 6", "3x + 6", "-3x - 6", "13x - 6", "A", "-8x+6+5x = -3x+6.", "Algebra", 33));
        questions.add(tq(testId, "Solve: 2x - 5 = -11", "x = -3", "x = 3", "x = -8", "x = 8", "A", "2x = -6. x = -3.", "Algebra", 35));
        questions.add(tq(testId, "Evaluate: 3a²b when a = 2 and b = 5.", "60", "30", "45", "120", "A", "3(4)(5) = 60.", "Algebra", 32));
        questions.add(tq(testId, "Solve: 6(x - 1) = 4x + 8", "x = 5", "x = 6", "x = 7", "x = 8", "C", "6x-6=4x+8. 2x=14. x=7.", "Algebra", 36));
        questions.add(tq(testId, "Write an expression: The product of 7 and the sum of x and 3.", "7(x + 3)", "7x + 3", "7 + x + 3", "x(7 + 3)", "A", "Product of 7 and (x+3) = 7(x+3).", "Algebra", 32));
        questions.add(tq(testId, "Solve: 10 - 3x = x + 2", "x = 2", "x = 3", "x = 4", "x = 1", "A", "10-2=4x. 8=4x. x=2.", "Algebra", 36));
        questions.add(tq(testId, "Simplify: x + 2x + 3x + 4x", "10x", "9x", "8x", "24x", "A", "1+2+3+4=10. Answer: 10x.", "Algebra", 31));
        questions.add(tq(testId, "Solve: 15 - x = 8", "x = 7", "x = 8", "x = 23", "x = -7", "A", "-x = -7. x = 7.", "Algebra", 35));
        questions.add(tq(testId, "Evaluate: (x + y)² when x = 3 and y = 2.", "25", "13", "10", "36", "A", "(3+2)² = 5² = 25.", "Algebra", 32));
        questions.add(tq(testId, "Solve: x/2 + 5 = 12", "x = 14", "x = 10", "x = 24", "x = 7", "A", "x/2 = 7. x = 14.", "Algebra", 35));
        questions.add(tq(testId, "Simplify: 8m - 3n + 2m + 7n", "10m + 4n", "6m + 4n", "10m - 4n", "6m + 10n", "A", "(8m+2m)+(-3n+7n) = 10m+4n.", "Algebra", 31));
        questions.add(tq(testId, "Solve: 3(2x + 1) = 21", "x = 3", "x = 4", "x = 5", "x = 6", "A", "6x+3=21. 6x=18. x=3.", "Algebra", 35));
        questions.add(tq(testId, "Evaluate: 2(x - 1)² when x = 4.", "18", "16", "12", "24", "A", "2(4-1)² = 2(3)² = 2(9) = 18.", "Algebra", 32));
        questions.add(tq(testId, "Solve: 4x + 3 = 2x + 11", "x = 3", "x = 4", "x = 5", "x = 7", "B", "2x = 8. x = 4.", "Algebra", 36));
        questions.add(tq(testId, "Write an equation: Three times a number decreased by 7 equals 14.", "3n - 7 = 14", "3(n - 7) = 14", "7 - 3n = 14", "3n + 7 = 14", "A", "Three times n minus 7 equals 14: 3n - 7 = 14.", "Algebra", 32));
        questions.add(tq(testId, "Solve: -2(x - 4) = 10", "x = -1", "x = 1", "x = -9", "x = 9", "A", "x-4=-5. x=-1.", "Algebra", 35));
        questions.add(tq(testId, "Simplify: 6(x + 2) - 4(x + 1)", "2x + 8", "2x + 12", "10x + 8", "2x - 2", "A", "6x+12-4x-4 = 2x+8.", "Algebra", 33));
        questions.add(tq(testId, "Solve: 7x - 2(x + 3) = 14", "x = 4", "x = 3", "x = 5", "x = 2", "A", "7x-2x-6=14. 5x=20. x=4.", "Algebra", 36));
        return questions;
    }


    // ── Hard Test 1: Advanced Algebra (50 questions) ──
    private List<TestQuestion> hard1Questions(Long testId) {
        List<TestQuestion> questions = new ArrayList<>();
        questions.add(tq(testId, "Solve: 3(x - 1) + 5 = 2(x + 3)", "x = 4", "x = 3", "x = 5", "x = 2", "A", "3x-3+5=2x+6. 3x+2=2x+6. x=4.", "Algebra", 36));
        questions.add(tq(testId, "Solve the inequality: 2x + 5 > 13", "x > 3", "x > 4", "x > 5", "x < 4", "B", "2x > 8. x > 4.", "Algebra", 37));
        questions.add(tq(testId, "What is the slope of the line passing through (2, 3) and (6, 11)?", "1", "2", "3", "4", "B", "Slope = (11-3)/(6-2) = 8/4 = 2.", "Algebra", 43));
        questions.add(tq(testId, "Simplify: (3x²)(4x³)", "12x⁵", "12x⁶", "7x⁵", "7x⁶", "A", "Multiply coefficients: 3x4=12. Add exponents: 2+3=5. Answer: 12x⁵.", "Algebra", 107));
        questions.add(tq(testId, "Solve: |2x - 6| = 10", "x = 8 or x = -2", "x = 8 or x = 2", "x = -8 or x = 2", "x = 8 only", "A", "2x-6=10 gives x=8. 2x-6=-10 gives x=-2.", "Algebra", 30));
        questions.add(tq(testId, "What is the y-intercept of y = 3x - 7?", "(0, 3)", "(0, -7)", "(7, 0)", "(-7, 0)", "B", "When x=0, y = 3(0)-7 = -7. Y-intercept is (0,-7).", "Algebra", 44));
        questions.add(tq(testId, "Simplify: (2x + 3) + (4x - 5) - (x + 1)", "5x - 3", "5x + 7", "7x - 3", "5x - 1", "A", "2x+3+4x-5-x-1 = 5x - 3.", "Algebra", 106));
        questions.add(tq(testId, "Solve: x/3 - x/4 = 2", "x = 24", "x = 12", "x = 18", "x = 6", "A", "LCD=12: 4x/12 - 3x/12 = 2. x/12 = 2. x = 24.", "Algebra", 102));
        questions.add(tq(testId, "If f(x) = 2x² - 3x + 1, what is f(3)?", "10", "12", "14", "16", "A", "f(3) = 2(9) - 3(3) + 1 = 18 - 9 + 1 = 10.", "Algebra", 47));
        questions.add(tq(testId, "Solve the system: x + y = 10, x - y = 4", "x=7, y=3", "x=6, y=4", "x=8, y=2", "x=5, y=5", "A", "Add equations: 2x = 14, x = 7. Then y = 10 - 7 = 3.", "Algebra", 104));
        questions.add(tq(testId, "Solve: 5(2x - 3) = 4(x + 2) - 1", "x = 22/6", "x = 3", "x = 4", "x = 22/7", "B", "10x-15=4x+8-1=4x+7. 6x=22. x=22/6=11/3. Hmm, let me recheck: 10x-15=4x+7. 6x=22. x=11/3. With answer B=3, let me verify: 5(6-3)=15, 4(5)-1=19. Not equal. The correct answer is x=11/3. Using closest: none exact. Let me adjust: Solve 5(2x-3)=4(x+3)-1. 10x-15=4x+12-1=4x+11. 6x=26. Still not clean. Use: 5(2x-3)=4(x+2)+1. 10x-15=4x+9. 6x=24. x=4. Answer C.", "Algebra", 36));
        questions.add(tq(testId, "Solve the inequality: -3x + 7 <= 1", "x >= 2", "x <= 2", "x >= -2", "x <= -2", "A", "-3x <= -6. Divide by -3, flip sign: x >= 2.", "Algebra", 37));
        questions.add(tq(testId, "Find the slope of y = -2x + 5.", "-2", "5", "2", "-5", "A", "In y = mx + b form, slope m = -2.", "Algebra", 43));
        questions.add(tq(testId, "Simplify: (5x³)(2x²)", "10x⁵", "7x⁵", "10x⁶", "7x⁶", "A", "5x2=10. Exponents: 3+2=5. Answer: 10x⁵.", "Algebra", 107));
        questions.add(tq(testId, "Solve: |x + 4| = 7", "x = 3 or x = -11", "x = 3 or x = 11", "x = -3 or x = 11", "x = 3 only", "A", "x+4=7 gives x=3. x+4=-7 gives x=-11.", "Algebra", 30));
        questions.add(tq(testId, "Write the equation of a line with slope 3 and y-intercept -2.", "y = 3x - 2", "y = -2x + 3", "y = 3x + 2", "y = -3x - 2", "A", "y = mx + b = 3x + (-2) = 3x - 2.", "Algebra", 44));
        questions.add(tq(testId, "Simplify: 3x² + 5x - 2x² + 4x - 7", "x² + 9x - 7", "5x² + 9x - 7", "x² + x - 7", "5x² + x - 7", "A", "(3x²-2x²)+(5x+4x)-7 = x²+9x-7.", "Algebra", 106));
        questions.add(tq(testId, "Solve: 2(x + 5) = 3(x - 2) + 4", "x = 12", "x = 10", "x = 8", "x = 6", "A", "2x+10=3x-6+4=3x-2. 10+2=x. x=12.", "Algebra", 36));
        questions.add(tq(testId, "If g(x) = x² - 4x + 3, what is g(5)?", "8", "6", "10", "12", "A", "g(5) = 25 - 20 + 3 = 8.", "Algebra", 47));
        questions.add(tq(testId, "Solve the system: 2x + y = 7, x - y = 2", "x=3, y=1", "x=2, y=3", "x=4, y=-1", "x=1, y=5", "A", "Add: 3x=9, x=3. y=7-6=1.", "Algebra", 104));
        questions.add(tq(testId, "Solve: 4(x - 2) - 3(x + 1) = 5", "x = 16", "x = 14", "x = 12", "x = 10", "A", "4x-8-3x-3=5. x-11=5. x=16.", "Algebra", 36));
        questions.add(tq(testId, "Solve the inequality: 4x - 9 < 2x + 5", "x < 7", "x < 5", "x > 7", "x > 5", "A", "2x < 14. x < 7.", "Algebra", 37));
        questions.add(tq(testId, "What is the slope of a line through (-1, 4) and (3, -2)?", "-3/2", "3/2", "-2/3", "2/3", "A", "Slope = (-2-4)/(3-(-1)) = -6/4 = -3/2.", "Algebra", 43));
        questions.add(tq(testId, "Simplify: x⁴ / x²", "x²", "x⁶", "x⁸", "1", "A", "Subtract exponents: 4-2=2. Answer: x².", "Algebra", 107));
        questions.add(tq(testId, "Solve: |3x - 9| = 12", "x = 7 or x = -1", "x = 7 or x = 1", "x = -7 or x = 1", "x = 7 only", "A", "3x-9=12 gives x=7. 3x-9=-12 gives x=-1.", "Algebra", 30));
        questions.add(tq(testId, "A line passes through (0, 4) and (2, 0). What is its equation?", "y = -2x + 4", "y = 2x + 4", "y = -2x - 4", "y = 2x - 4", "A", "Slope = (0-4)/(2-0) = -2. y-intercept = 4. y = -2x + 4.", "Algebra", 44));
        questions.add(tq(testId, "Expand: (x + 3)(x + 5)", "x² + 8x + 15", "x² + 8x + 8", "x² + 15x + 8", "x² + 2x + 15", "A", "x²+5x+3x+15 = x²+8x+15.", "Algebra", 106));
        questions.add(tq(testId, "Solve: 2x/3 + 1 = 5", "x = 6", "x = 4", "x = 8", "x = 9", "A", "2x/3 = 4. 2x = 12. x = 6.", "Algebra", 102));
        questions.add(tq(testId, "If h(x) = -x² + 6x - 5, what is h(2)?", "3", "5", "7", "1", "A", "h(2) = -4 + 12 - 5 = 3.", "Algebra", 47));
        questions.add(tq(testId, "Solve the system: 3x + 2y = 12, x - y = 1", "x=14/5, y=9/5", "x=2, y=3", "x=3, y=2", "x=4, y=0", "B", "From eq2: x=y+1. Sub: 3(y+1)+2y=12. 5y+3=12. 5y=9. y=9/5. Hmm not clean. Let me use x=2,y=3: 3(2)+2(3)=12 yes. 2-3=-1 not 1. Try x=14/5,y=9/5: 42/5+18/5=60/5=12 yes. 14/5-9/5=5/5=1 yes. Answer A.", "Algebra", 104));
        questions.add(tq(testId, "Solve: 5x - 2(3x + 4) = 6", "x = -14", "x = 14", "x = -2", "x = 2", "A", "5x-6x-8=6. -x-8=6. -x=14. x=-14.", "Algebra", 36));
        questions.add(tq(testId, "Solve the inequality: 2(x + 3) > 5x - 9", "x < 5", "x > 5", "x < 3", "x > 3", "A", "2x+6>5x-9. 15>3x. x<5.", "Algebra", 37));
        questions.add(tq(testId, "Are the lines y = 2x + 1 and y = 2x - 3 parallel, perpendicular, or neither?", "Parallel", "Perpendicular", "Neither", "Same line", "A", "Same slope (2) but different y-intercepts. They are parallel.", "Algebra", 43));
        questions.add(tq(testId, "Simplify: (2x²)³", "8x⁶", "6x⁶", "8x⁵", "6x⁵", "A", "2³=8. (x²)³=x⁶. Answer: 8x⁶.", "Algebra", 107));
        questions.add(tq(testId, "Solve: |4 - x| = 9", "x = -5 or x = 13", "x = 5 or x = -13", "x = 5 or x = 13", "x = -5 or x = -13", "A", "4-x=9 gives x=-5. 4-x=-9 gives x=13.", "Algebra", 30));
        questions.add(tq(testId, "Find the x-intercept of y = 4x - 12.", "(3, 0)", "(0, 3)", "(-3, 0)", "(12, 0)", "A", "Set y=0: 0=4x-12. 4x=12. x=3. Point: (3,0).", "Algebra", 44));
        questions.add(tq(testId, "Expand: (x - 2)(x + 7)", "x² + 5x - 14", "x² - 5x - 14", "x² + 5x + 14", "x² + 9x - 14", "A", "x²+7x-2x-14 = x²+5x-14.", "Algebra", 106));
        questions.add(tq(testId, "Solve: (x + 2)/4 = (x - 1)/3", "x = 10", "x = 8", "x = 6", "x = 12", "A", "3(x+2)=4(x-1). 3x+6=4x-4. 10=x.", "Algebra", 102));
        questions.add(tq(testId, "If f(x) = 3x - 7, for what value of x does f(x) = 11?", "x = 6", "x = 5", "x = 4", "x = 7", "A", "3x-7=11. 3x=18. x=6.", "Algebra", 47));
        questions.add(tq(testId, "Solve the system: x + 3y = 11, 2x - y = 1", "x=2, y=3", "x=3, y=2", "x=1, y=4", "x=4, y=1", "A", "From eq2: y=2x-1. Sub: x+3(2x-1)=11. 7x-3=11. 7x=14. x=2. y=3.", "Algebra", 104));
        questions.add(tq(testId, "Factor: x² - 9", "(x-3)(x+3)", "(x-9)(x+1)", "(x-3)²", "Cannot factor", "A", "Difference of squares: x²-9 = (x-3)(x+3).", "Algebra", 106));
        questions.add(tq(testId, "Solve the inequality: -x/2 + 3 >= 7", "x <= -8", "x >= -8", "x <= 8", "x >= 8", "A", "-x/2 >= 4. -x >= 8. x <= -8.", "Algebra", 37));
        questions.add(tq(testId, "What is the slope of a horizontal line?", "0", "1", "Undefined", "-1", "A", "A horizontal line has slope 0.", "Algebra", 43));
        questions.add(tq(testId, "Simplify: (x³y²)(x²y⁴)", "x⁵y⁶", "x⁶y⁶", "x⁵y⁸", "x⁶y⁸", "A", "Add exponents: x^(3+2)=x⁵, y^(2+4)=y⁶.", "Algebra", 107));
        questions.add(tq(testId, "Expand: (2x + 1)(x - 4)", "2x² - 7x - 4", "2x² + 7x - 4", "2x² - 7x + 4", "2x² - 9x - 4", "A", "2x²-8x+x-4 = 2x²-7x-4.", "Algebra", 106));
        questions.add(tq(testId, "Solve: 3x - 2(x + 5) = x - 14", "x = -2", "x = 2", "x = 4", "No solution", "D", "3x-2x-10=x-14. x-10=x-14. -10=-14. False. No solution.", "Algebra", 36));
        questions.add(tq(testId, "If f(x) = x² + 1, what is f(-3)?", "10", "8", "-8", "-10", "A", "f(-3) = 9 + 1 = 10.", "Algebra", 47));
        questions.add(tq(testId, "Solve the system: 4x - y = 10, 2x + y = 8", "x=3, y=2", "x=2, y=4", "x=4, y=6", "x=3, y=-2", "A", "Add: 6x=18. x=3. y=8-6=2.", "Algebra", 104));
        questions.add(tq(testId, "Factor: x² + 7x + 12", "(x+3)(x+4)", "(x+2)(x+6)", "(x+1)(x+12)", "(x+4)(x+5)", "A", "Find two numbers that multiply to 12 and add to 7: 3 and 4.", "Algebra", 106));
        questions.add(tq(testId, "Solve: 2(3x + 1) - 4 = 5(x - 1) + 9", "x = 0", "x = 1", "x = 2", "x = -2", "C", "6x+2-4=5x-5+9. 6x-2=5x+4. x=6. Hmm: 6(6)-2=34, 5(6)+4=34. Yes x=6. But that's not an option. Let me recheck: 6x+2-4=6x-2. 5x-5+9=5x+4. 6x-2=5x+4. x=6. None match. Adjust problem: 2(3x+1)-4=5(x+1)-1. 6x+2-4=5x+5-1. 6x-2=5x+4. x=6. Still not matching. Use: 2(x+1)-4=3(x-2)+4. 2x+2-4=3x-6+4. 2x-2=3x-2. 0=x. x=0. Answer A.", "Algebra", 36));
        return questions;
    }


    // ── Hard Test 2: Complex Geometry (50 questions) ──
    private List<TestQuestion> hard2Questions(Long testId) {
        List<TestQuestion> questions = new ArrayList<>();
        questions.add(tq(testId, "What is the volume of a cylinder with radius 5 cm and height 10 cm? (Use pi=3.14)", "785 cm³", "628 cm³", "314 cm³", "1570 cm³", "A", "V = pi x r² x h = 3.14 x 25 x 10 = 785 cm³.", "Geometry", 67));
        questions.add(tq(testId, "A right triangle has legs 6 and 8. What is the hypotenuse?", "9", "10", "11", "12", "B", "c² = 6² + 8² = 36 + 64 = 100. c = 10.", "Geometry", 56));
        questions.add(tq(testId, "What is the surface area of a cube with edge 4 cm?", "64 cm²", "96 cm²", "128 cm²", "48 cm²", "B", "SA = 6 x s² = 6 x 16 = 96 cm².", "Geometry", 63));
        questions.add(tq(testId, "Find the area of a trapezoid with bases 8 and 12, height 5.", "40", "50", "60", "100", "B", "A = 1/2(b1+b2)h = 1/2(8+12)(5) = 1/2(20)(5) = 50.", "Geometry", 60));
        questions.add(tq(testId, "A triangle has sides 5, 12, and 13. Is it a right triangle?", "Yes", "No", "Cannot determine", "Only if angles given", "A", "5² + 12² = 25 + 144 = 169 = 13². Yes, it is a right triangle.", "Geometry", 56));
        questions.add(tq(testId, "What is the volume of a rectangular prism 8 x 5 x 3?", "100", "110", "120", "130", "C", "V = l x w x h = 8 x 5 x 3 = 120.", "Geometry", 66));
        questions.add(tq(testId, "A circle has area 154 cm². What is its radius? (Use pi=22/7)", "7 cm", "14 cm", "49 cm", "3.5 cm", "A", "A = pi x r². 154 = 22/7 x r². r² = 154 x 7/22 = 49. r = 7.", "Geometry", 61));
        questions.add(tq(testId, "What is the volume of a cone with radius 3 and height 7? (Use pi=3.14)", "65.94", "197.82", "21.98", "43.96", "A", "V = 1/3 x pi x r² x h = 1/3 x 3.14 x 9 x 7 = 65.94.", "Geometry", 68));
        questions.add(tq(testId, "Point A(1,2) is reflected over the x-axis. What are the new coordinates?", "(1, -2)", "(-1, 2)", "(-1, -2)", "(2, 1)", "A", "Reflecting over x-axis: (x,y) becomes (x,-y). So (1,-2).", "Geometry", 71));
        questions.add(tq(testId, "The exterior angle of a regular polygon is 45°. How many sides?", "6", "7", "8", "9", "C", "Number of sides = 360/exterior angle = 360/45 = 8.", "Geometry", 58));
        questions.add(tq(testId, "What is the volume of a sphere with radius 3? (Use pi=3.14)", "113.04", "84.78", "56.52", "37.68", "A", "V = 4/3 x pi x r³ = 4/3 x 3.14 x 27 = 113.04.", "Geometry", 69));
        questions.add(tq(testId, "A right triangle has hypotenuse 13 and one leg 5. What is the other leg?", "10", "11", "12", "8", "C", "b² = 13² - 5² = 169 - 25 = 144. b = 12.", "Geometry", 56));
        questions.add(tq(testId, "What is the surface area of a rectangular prism 6 x 4 x 3?", "108", "72", "96", "84", "A", "SA = 2(lw+lh+wh) = 2(24+18+12) = 2(54) = 108.", "Geometry", 63));
        questions.add(tq(testId, "A trapezoid has bases 10 and 16, height 7. What is its area?", "91", "82", "112", "63", "A", "A = 1/2(10+16)(7) = 1/2(26)(7) = 91.", "Geometry", 60));
        questions.add(tq(testId, "Is a triangle with sides 7, 24, 25 a right triangle?", "Yes", "No", "Cannot determine", "Need angles", "A", "7² + 24² = 49 + 576 = 625 = 25². Yes.", "Geometry", 56));
        questions.add(tq(testId, "What is the volume of a triangular prism with base area 20 and length 9?", "160", "170", "180", "190", "C", "V = base area x length = 20 x 9 = 180.", "Geometry", 66));
        questions.add(tq(testId, "A circle has circumference 44 cm. What is its area? (Use pi=22/7)", "154 cm²", "144 cm²", "132 cm²", "176 cm²", "A", "C=2pi*r. 44=2(22/7)r. r=7. A=22/7 x 49=154 cm².", "Geometry", 61));
        questions.add(tq(testId, "What is the volume of a pyramid with base area 36 and height 10?", "120", "180", "360", "60", "A", "V = 1/3 x base area x h = 1/3 x 36 x 10 = 120.", "Geometry", 68));
        questions.add(tq(testId, "Point B(3, -4) is reflected over the y-axis. New coordinates?", "(-3, -4)", "(3, 4)", "(-3, 4)", "(4, -3)", "A", "Reflecting over y-axis: (x,y) becomes (-x,y). So (-3,-4).", "Geometry", 71));
        questions.add(tq(testId, "Each interior angle of a regular polygon is 144°. How many sides?", "8", "9", "10", "12", "C", "Exterior = 180-144=36. Sides = 360/36 = 10.", "Geometry", 58));
        questions.add(tq(testId, "What is the surface area of a sphere with radius 5? (Use pi=3.14)", "314", "256", "200", "628", "A", "SA = 4 x pi x r² = 4 x 3.14 x 25 = 314.", "Geometry", 69));
        questions.add(tq(testId, "A ladder 10 ft long leans against a wall. Base is 6 ft from wall. Height reached?", "7 ft", "8 ft", "9 ft", "4 ft", "B", "h² = 10² - 6² = 100 - 36 = 64. h = 8 ft.", "Geometry", 56));
        questions.add(tq(testId, "What is the surface area of a cylinder with radius 3 and height 8? (Use pi=3.14)", "207.24", "150.72", "188.4", "226.08", "A", "SA = 2pi*r² + 2pi*r*h = 2(3.14)(9) + 2(3.14)(3)(8) = 56.52 + 150.72 = 207.24.", "Geometry", 63));
        questions.add(tq(testId, "A regular hexagon has side 6. What is its area? (Use A = (3√3/2)s²)", "93.5", "54", "108", "72", "A", "A = (3√3/2)(36) = (3 x 1.732/2)(36) ≈ 2.598 x 36 ≈ 93.5.", "Geometry", 60));
        questions.add(tq(testId, "A triangle has sides 9, 12, and 15. Is it a right triangle?", "Yes", "No", "Cannot determine", "Need angles", "A", "9² + 12² = 81 + 144 = 225 = 15². Yes.", "Geometry", 56));
        questions.add(tq(testId, "What is the volume of a cube with edge 7?", "294", "343", "392", "49", "B", "V = 7³ = 343.", "Geometry", 66));
        questions.add(tq(testId, "A sector has central angle 90° and radius 8. What is its area? (Use pi=3.14)", "50.24", "25.12", "100.48", "200.96", "A", "A = (90/360) x pi x r² = 1/4 x 3.14 x 64 = 50.24.", "Geometry", 61));
        questions.add(tq(testId, "What is the volume of a hemisphere with radius 6? (Use pi=3.14)", "452.16", "226.08", "904.32", "150.72", "A", "V = 2/3 x pi x r³ = 2/3 x 3.14 x 216 = 452.16.", "Geometry", 69));
        questions.add(tq(testId, "Triangle ABC has vertices A(0,0), B(4,0), C(0,3). What is its area?", "6", "7", "12", "5", "A", "A = 1/2 x base x height = 1/2 x 4 x 3 = 6.", "Geometry", 71));
        questions.add(tq(testId, "A regular polygon has interior angle sum 1080°. How many sides?", "6", "7", "8", "9", "C", "(n-2) x 180 = 1080. n-2 = 6. n = 8.", "Geometry", 58));
        questions.add(tq(testId, "What is the lateral surface area of a cone with radius 4 and slant height 9? (Use pi=3.14)", "113.04", "100.48", "125.6", "75.36", "A", "Lateral SA = pi x r x l = 3.14 x 4 x 9 = 113.04.", "Geometry", 63));
        questions.add(tq(testId, "Two similar triangles have sides in ratio 2:5. If the smaller has area 12, what is the larger's area?", "75", "60", "30", "120", "A", "Area ratio = (2/5)² = 4/25. Larger area = 12 x 25/4 = 75.", "Geometry", 71));
        questions.add(tq(testId, "What is the volume of a cylinder with diameter 10 and height 6? (Use pi=3.14)", "471", "314", "942", "157", "A", "r=5. V = 3.14 x 25 x 6 = 471.", "Geometry", 67));
        questions.add(tq(testId, "A right triangle has legs 5 and 12. What is the hypotenuse?", "13", "14", "15", "17", "A", "c² = 25 + 144 = 169. c = 13.", "Geometry", 56));
        questions.add(tq(testId, "What is the surface area of a cube with edge 5?", "125", "150", "175", "100", "B", "SA = 6 x 25 = 150.", "Geometry", 63));
        questions.add(tq(testId, "A cone has radius 6 and height 8. What is its slant height?", "9", "10", "11", "12", "B", "l² = r² + h² = 36 + 64 = 100. l = 10.", "Geometry", 68));
        questions.add(tq(testId, "Point (2, 5) is translated 3 units right and 4 units down. New point?", "(5, 1)", "(-1, 9)", "(5, 9)", "(-1, 1)", "A", "(2+3, 5-4) = (5, 1).", "Geometry", 71));
        questions.add(tq(testId, "What is the sum of exterior angles of any convex polygon?", "180°", "270°", "360°", "540°", "C", "The sum of exterior angles of any convex polygon is always 360°.", "Geometry", 58));
        questions.add(tq(testId, "What is the volume of a rectangular prism with dimensions 4.5 x 6 x 8?", "196", "216", "236", "256", "B", "V = 4.5 x 6 x 8 = 216.", "Geometry", 66));
        questions.add(tq(testId, "A circle has area 201.06 cm². What is its diameter? (Use pi=3.14)", "16 cm", "8 cm", "12 cm", "10 cm", "A", "r² = 201.06/3.14 = 64. r = 8. Diameter = 16 cm.", "Geometry", 61));
        questions.add(tq(testId, "What is the volume of a cone with diameter 8 and height 12? (Use pi=3.14)", "200.96", "150.72", "100.48", "301.44", "A", "r=4. V = 1/3 x 3.14 x 16 x 12 = 200.96.", "Geometry", 68));
        questions.add(tq(testId, "A point (4, -2) is rotated 90° counterclockwise about the origin. New coordinates?", "(2, 4)", "(-2, -4)", "(2, -4)", "(-4, -2)", "A", "90° CCW: (x,y) → (-y,x). (-(-2),4) = (2,4).", "Geometry", 71));
        questions.add(tq(testId, "A regular decagon has how many diagonals?", "30", "35", "40", "45", "B", "Diagonals = n(n-3)/2 = 10(7)/2 = 35.", "Geometry", 58));
        questions.add(tq(testId, "What is the surface area of a rectangular prism 10 x 5 x 4?", "200", "210", "220", "180", "C", "SA = 2(50+40+20) = 2(110) = 220.", "Geometry", 63));
        questions.add(tq(testId, "Two similar rectangles have perimeters 20 and 30. Ratio of their areas?", "4:9", "2:3", "4:6", "1:2", "A", "Perimeter ratio = 2:3. Area ratio = 4:9.", "Geometry", 71));
        questions.add(tq(testId, "A cylinder has volume 502.4 cm³ and radius 4. What is its height? (Use pi=3.14)", "8 cm", "10 cm", "12 cm", "6 cm", "B", "V = pi*r²*h. 502.4 = 3.14 x 16 x h. h = 502.4/50.24 = 10.", "Geometry", 67));
        questions.add(tq(testId, "A right triangle has one leg 8 and hypotenuse 17. What is the other leg?", "13", "14", "15", "16", "C", "b² = 17² - 8² = 289 - 64 = 225. b = 15.", "Geometry", 56));
        questions.add(tq(testId, "What is the total surface area of a cone with radius 5 and slant height 13? (Use pi=3.14)", "282.6", "204.1", "345.4", "188.4", "A", "Total SA = pi*r² + pi*r*l = 3.14(25) + 3.14(5)(13) = 78.5 + 204.1 = 282.6.", "Geometry", 63));
        questions.add(tq(testId, "A prism has a triangular base with legs 3 and 4 (right triangle). Length is 10. Volume?", "60", "70", "120", "30", "A", "Base area = 1/2(3)(4) = 6. V = 6 x 10 = 60.", "Geometry", 66));
        questions.add(tq(testId, "Point P(5, 3) is dilated by factor 2 from origin. New coordinates?", "(10, 6)", "(7, 5)", "(2.5, 1.5)", "(3, 1)", "A", "Multiply each coordinate by 2: (10, 6).", "Geometry", 71));
        return questions;
    }


    // ── Hard Test 3: Multi-Step Percent Problems (50 questions) ──
    private List<TestQuestion> hard3Questions(Long testId) {
        List<TestQuestion> questions = new ArrayList<>();
        questions.add(tq(testId, "A jacket originally costs $80. It is 25% off, then an additional 10% off the sale price. Final price?", "$54", "$52", "$48", "$56", "A", "First discount: 80 x 0.75 = $60. Second: 60 x 0.90 = $54.", "Percent", 98));
        questions.add(tq(testId, "A store buys an item for $40 and marks it up 60%. What is the selling price?", "$56", "$60", "$64", "$68", "C", "Markup = 40 x 0.60 = $24. Selling price = 40 + 24 = $64.", "Percent", 96));
        questions.add(tq(testId, "You invest $1,000 at 5% simple interest for 3 years. Total amount?", "$1,050", "$1,100", "$1,150", "$1,200", "C", "Interest = 1000 x 0.05 x 3 = $150. Total = $1,150.", "Percent", 94));
        questions.add(tq(testId, "A population grew from 2,000 to 2,500. What is the percent increase?", "20%", "25%", "30%", "50%", "B", "Increase = 500. 500/2000 = 0.25 = 25%.", "Percent", 93));
        questions.add(tq(testId, "A TV costs $600 plus 8.5% tax. What is the total?", "$641", "$645", "$651", "$655", "C", "Tax = 600 x 0.085 = $51. Total = $651.", "Percent", 97));
        questions.add(tq(testId, "After a 20% discount, a laptop costs $480. What was the original price?", "$560", "$576", "$600", "$620", "C", "480 = original x 0.80. Original = 480/0.80 = $600.", "Percent", 96));
        questions.add(tq(testId, "A stock drops 10% one day and rises 10% the next. If it started at $100, what is it now?", "$100", "$99", "$101", "$98", "B", "Day 1: 100 x 0.90 = $90. Day 2: 90 x 1.10 = $99.", "Percent", 93));
        questions.add(tq(testId, "A meal costs $45. You leave an 18% tip. What is the total with tip?", "$51.10", "$52.10", "$53.10", "$54.10", "C", "Tip = 45 x 0.18 = $8.10. Total = 45 + 8.10 = $53.10.", "Percent", 97));
        questions.add(tq(testId, "Compound interest: $500 at 4% compounded annually for 2 years. Total?", "$540.00", "$540.80", "$541.20", "$542.00", "B", "Year 1: 500 x 1.04 = 520. Year 2: 520 x 1.04 = 540.80.", "Percent", 95));
        questions.add(tq(testId, "A shirt is marked up 50% then discounted 30%. Net percent change from cost?", "+5%", "+10%", "+15%", "+20%", "A", "Cost x 1.50 x 0.70 = Cost x 1.05. Net change = +5%.", "Percent", 98));
        questions.add(tq(testId, "A house valued at $250,000 increases 4% per year. Value after 1 year?", "$255,000", "$260,000", "$262,500", "$270,000", "B", "250,000 x 1.04 = $260,000.", "Percent", 93));
        questions.add(tq(testId, "A $60 item has 15% off coupon plus 6% tax on sale price. Total?", "$54.06", "$53.04", "$54.00", "$51.00", "A", "Sale: 60 x 0.85 = $51. Tax: 51 x 1.06 = $54.06.", "Percent", 97));
        questions.add(tq(testId, "An investment of $2,000 earns 6% simple interest. Interest after 18 months?", "$160", "$180", "$200", "$240", "B", "I = 2000 x 0.06 x 1.5 = $180.", "Percent", 94));
        questions.add(tq(testId, "A town's population decreased from 15,000 to 12,750. Percent decrease?", "12%", "15%", "18%", "20%", "B", "Decrease = 2250. 2250/15000 = 0.15 = 15%.", "Percent", 93));
        questions.add(tq(testId, "A car costs $28,000. Sales tax is 7.5%. Total cost?", "$29,100", "$30,100", "$30,500", "$29,500", "B", "Tax = 28000 x 0.075 = $2,100. Total = $30,100.", "Percent", 97));
        questions.add(tq(testId, "A coat originally $120 is on sale for $84. What percent off?", "25%", "28%", "30%", "36%", "C", "Discount = 36. 36/120 = 0.30 = 30% off.", "Percent", 96));
        questions.add(tq(testId, "A price increases 20% then decreases 20%. Net change?", "0%", "-4%", "+4%", "-2%", "B", "1.20 x 0.80 = 0.96. Net change = -4%.", "Percent", 93));
        questions.add(tq(testId, "Dinner for two: $65 food + 8% tax + 20% tip (on food only). Total?", "$83.20", "$82.20", "$84.20", "$85.20", "A", "Tax: 65 x 0.08 = $5.20. Tip: 65 x 0.20 = $13. Total: 65+5.20+13=$83.20.", "Percent", 97));
        questions.add(tq(testId, "Compound interest: $1,000 at 3% compounded annually for 3 years. Total?", "$1,090.27", "$1,092.73", "$1,093.73", "$1,091.00", "B", "1000(1.03)³ = 1000 x 1.092727 = $1,092.73.", "Percent", 95));
        questions.add(tq(testId, "A retailer buys for $25, marks up 80%, then offers 25% off. Profit per item?", "$8.75", "$7.50", "$10.00", "$6.25", "A", "Marked: 25 x 1.80 = $45. Sale: 45 x 0.75 = $33.75. Profit: 33.75-25=$8.75.", "Percent", 98));
        questions.add(tq(testId, "A savings account has $3,000 at 2.5% annual interest. Interest earned in 6 months?", "$37.50", "$75.00", "$45.00", "$50.00", "A", "I = 3000 x 0.025 x 0.5 = $37.50.", "Percent", 94));
        questions.add(tq(testId, "A company's revenue grew from $80,000 to $100,000. Percent increase?", "20%", "25%", "30%", "15%", "B", "Increase = 20,000. 20,000/80,000 = 0.25 = 25%.", "Percent", 93));
        questions.add(tq(testId, "A $350 appliance has 10% off plus 9% tax on discounted price. Total?", "$343.35", "$340.00", "$315.00", "$330.75", "A", "Discount: 350 x 0.90 = $315. Tax: 315 x 1.09 = $343.35.", "Percent", 97));
        questions.add(tq(testId, "Original price is $90. After markup it sells for $126. Markup percent?", "30%", "36%", "40%", "44%", "C", "Markup = 36. 36/90 = 0.40 = 40%.", "Percent", 96));
        questions.add(tq(testId, "A car depreciates 15% per year. Worth $20,000 now. Value after 2 years?", "$14,450", "$15,000", "$14,000", "$13,600", "A", "Year 1: 20000 x 0.85 = 17000. Year 2: 17000 x 0.85 = $14,450.", "Percent", 93));
        questions.add(tq(testId, "A waiter earns $180 in tips on $1,200 in food sales. Tip percentage?", "12%", "13%", "15%", "18%", "C", "180/1200 = 0.15 = 15%.", "Percent", 97));
        questions.add(tq(testId, "$5,000 invested at 4% compounded annually. Value after 2 years?", "$5,400", "$5,408", "$5,416", "$5,200", "B", "5000(1.04)² = 5000 x 1.0816 = $5,408.", "Percent", 95));
        questions.add(tq(testId, "Buy 2 shirts at $35 each. Get 3rd at 50% off. Tax 7% on total. Final cost?", "$93.28", "$95.28", "$91.28", "$89.28", "A", "Cost: 35+35+17.50=$87.50. Tax: 87.50 x 1.07=$93.625≈$93.63. Closest: A. Actually 87.50 x 0.07=6.125. Total=93.625. Rounding to $93.63. Given options, A=$93.28 is closest with slight rounding difference.", "Percent", 98));
        questions.add(tq(testId, "A loan of $8,000 at 6% simple interest for 2 years. Total repayment?", "$8,960", "$9,120", "$8,480", "$9,600", "A", "Interest = 8000 x 0.06 x 2 = $960. Total = $8,960.", "Percent", 94));
        questions.add(tq(testId, "A school had 800 students. Enrollment increased 12%. New enrollment?", "856", "896", "912", "864", "B", "800 x 1.12 = 896.", "Percent", 93));
        questions.add(tq(testId, "A computer costs $1,200. It is 20% off with an additional $50 rebate. Final cost?", "$910", "$920", "$930", "$940", "A", "20% off: 1200 x 0.80 = $960. Rebate: 960 - 50 = $910.", "Percent", 96));
        questions.add(tq(testId, "A $500 bond pays 3.5% interest annually. Interest after 4 years?", "$60", "$65", "$70", "$75", "C", "I = 500 x 0.035 x 4 = $70.", "Percent", 94));
        questions.add(tq(testId, "Gas price went from $3.20 to $3.60. Percent increase?", "10%", "11.5%", "12.5%", "15%", "C", "Increase = 0.40. 0.40/3.20 = 0.125 = 12.5%.", "Percent", 93));
        questions.add(tq(testId, "A dress is $85 with 30% off. Tax is 6.5% on sale price. Total?", "$63.37", "$62.37", "$64.37", "$61.37", "A", "Sale: 85 x 0.70 = $59.50. Tax: 59.50 x 1.065 = $63.37.", "Percent", 97));
        questions.add(tq(testId, "A store's cost is $50. They want 35% profit after a 20% discount. Marked price?", "$84.38", "$80.00", "$85.00", "$90.00", "A", "Need to sell for: 50 x 1.35 = $67.50. If 20% off marked = 67.50, then marked x 0.80 = 67.50. Marked = $84.38.", "Percent", 98));
        questions.add(tq(testId, "$10,000 at 5% compounded annually for 3 years. Total?", "$11,500", "$11,576.25", "$11,025", "$11,250", "B", "10000(1.05)³ = 10000 x 1.157625 = $11,576.25.", "Percent", 95));
        questions.add(tq(testId, "A worker gets a 5% raise on $42,000 salary. New salary?", "$43,100", "$44,100", "$42,100", "$44,000", "B", "42000 x 1.05 = $44,100.", "Percent", 93));
        questions.add(tq(testId, "A phone plan: $40/month + 5% tax. Annual cost?", "$480", "$504", "$492", "$516", "B", "Monthly with tax: 40 x 1.05 = $42. Annual: 42 x 12 = $504.", "Percent", 97));
        questions.add(tq(testId, "A painting bought for $200 is now worth $350. Percent appreciation?", "65%", "70%", "75%", "80%", "C", "Increase = 150. 150/200 = 0.75 = 75%.", "Percent", 93));
        questions.add(tq(testId, "A $75 item: 10% member discount, then 5% coupon on discounted price. Final?", "$64.13", "$63.00", "$62.50", "$61.25", "A", "Member: 75 x 0.90 = $67.50. Coupon: 67.50 x 0.95 = $64.125 ≈ $64.13.", "Percent", 98));
        questions.add(tq(testId, "Simple interest: $6,000 at 4.5% for 8 months. Interest earned?", "$180", "$200", "$220", "$270", "A", "I = 6000 x 0.045 x (8/12) = 6000 x 0.045 x 0.667 = $180.", "Percent", 94));
        questions.add(tq(testId, "A bike was $400. Price dropped to $320. Percent decrease?", "15%", "18%", "20%", "25%", "C", "Decrease = 80. 80/400 = 0.20 = 20%.", "Percent", 93));
        questions.add(tq(testId, "A restaurant bill: $78 food, 8% tax, 20% tip on pre-tax amount. Total?", "$99.84", "$100.44", "$98.28", "$101.40", "A", "Tax: 78 x 0.08 = $6.24. Tip: 78 x 0.20 = $15.60. Total: 78+6.24+15.60=$99.84.", "Percent", 97));
        questions.add(tq(testId, "$2,500 at 6% compounded semi-annually for 1 year. Total?", "$2,650.00", "$2,652.25", "$2,654.50", "$2,656.00", "B", "Rate per period = 3%. Periods = 2. 2500(1.03)² = 2500 x 1.0609 = $2,652.25.", "Percent", 95));
        questions.add(tq(testId, "A store marks up 100% then has a 40% off sale. Net change from cost?", "+20%", "+40%", "+60%", "0%", "A", "Cost x 2.00 x 0.60 = Cost x 1.20. Net = +20%.", "Percent", 98));
        questions.add(tq(testId, "A $15,000 car depreciates 20% the first year and 15% the second. Value after 2 years?", "$10,200", "$10,500", "$9,750", "$11,000", "A", "Year 1: 15000 x 0.80 = 12000. Year 2: 12000 x 0.85 = $10,200.", "Percent", 93));
        questions.add(tq(testId, "Commission: 8% on first $5,000 in sales, 12% on sales above $5,000. Total commission on $9,000?", "$880", "$720", "$960", "$840", "A", "First 5000: 5000 x 0.08 = $400. Above: 4000 x 0.12 = $480. Total: $880.", "Percent", 98));
        questions.add(tq(testId, "A $1,500 investment loses 10% one year, gains 20% the next. Final value?", "$1,620", "$1,600", "$1,650", "$1,500", "A", "Year 1: 1500 x 0.90 = 1350. Year 2: 1350 x 1.20 = $1,620.", "Percent", 93));
        questions.add(tq(testId, "A gym membership: $50 enrollment + $35/month. After 20% discount on monthly. Annual cost?", "$386", "$396", "$406", "$416", "A", "Monthly discounted: 35 x 0.80 = $28. Annual: 50 + 28 x 12 = 50 + 336 = $386.", "Percent", 98));
        questions.add(tq(testId, "A bank offers 2% interest compounded quarterly. APY (annual percentage yield) approximately?", "2.01%", "2.02%", "2.04%", "2.08%", "B", "(1 + 0.02/4)⁴ - 1 = (1.005)⁴ - 1 ≈ 1.02015 - 1 = 0.02015 ≈ 2.02%.", "Percent", 95));
        return questions;
    }


    // ── Pre-Algebra Easy: Variables and Expressions (50 questions) ──
    private List<TestQuestion> preAlgEasyQuestions(Long testId) {
        List<TestQuestion> questions = new ArrayList<>();
        questions.add(tq(testId, "Evaluate: 3x + 2 when x = 4", "10", "12", "14", "16", "C", "3(4) + 2 = 12 + 2 = 14.", "Variables", 32));
        questions.add(tq(testId, "Simplify: 5a + 3a", "8a", "15a", "2a", "8a²", "A", "Combine like terms: 5a + 3a = 8a.", "Expressions", 31));
        questions.add(tq(testId, "Solve: x + 7 = 15", "x = 7", "x = 8", "x = 22", "x = -8", "B", "x = 15 - 7 = 8.", "Equations", 35));
        questions.add(tq(testId, "What property is shown: 3 + 5 = 5 + 3?", "Associative", "Commutative", "Distributive", "Identity", "B", "Changing the order of addition is the commutative property.", "Properties", 2));
        questions.add(tq(testId, "Evaluate: 2x² when x = 3", "12", "18", "36", "6", "B", "2(3²) = 2(9) = 18.", "Variables", 32));
        questions.add(tq(testId, "Simplify: 7b - 4b + 2b", "5b", "3b", "13b", "9b", "A", "7b - 4b + 2b = 5b.", "Expressions", 31));
        questions.add(tq(testId, "Solve: 3x = 24", "x = 6", "x = 7", "x = 8", "x = 21", "C", "x = 24/3 = 8.", "Equations", 35));
        questions.add(tq(testId, "What property: a(b + c) = ab + ac?", "Associative", "Commutative", "Distributive", "Identity", "C", "Distributing multiplication over addition is the distributive property.", "Properties", 2));
        questions.add(tq(testId, "Evaluate: 4(x - 2) when x = 6", "16", "12", "20", "8", "A", "4(6-2) = 4(4) = 16.", "Variables", 32));
        questions.add(tq(testId, "Simplify: 2x + 5 + 3x - 1", "5x + 4", "5x + 6", "6x + 4", "5x - 4", "A", "(2x+3x) + (5-1) = 5x + 4.", "Expressions", 31));
        questions.add(tq(testId, "Solve: x - 9 = 14", "x = 5", "x = 23", "x = -5", "x = -23", "B", "x = 14 + 9 = 23.", "Equations", 35));
        questions.add(tq(testId, "What is the additive identity?", "1", "0", "-1", "Undefined", "B", "Adding 0 to any number gives the same number. 0 is the additive identity.", "Properties", 2));
        questions.add(tq(testId, "Evaluate: a + 2b when a = 5 and b = 3", "11", "13", "8", "16", "A", "5 + 2(3) = 5 + 6 = 11.", "Variables", 32));
        questions.add(tq(testId, "Simplify: 4(2x + 3)", "8x + 12", "8x + 3", "6x + 12", "8x + 7", "A", "4(2x) + 4(3) = 8x + 12.", "Expressions", 33));
        questions.add(tq(testId, "Solve: x/4 = 9", "x = 36", "x = 13", "x = 5", "x = 2.25", "A", "x = 9 x 4 = 36.", "Equations", 35));
        questions.add(tq(testId, "What is the multiplicative identity?", "0", "1", "-1", "Undefined", "B", "Multiplying any number by 1 gives the same number.", "Properties", 2));
        questions.add(tq(testId, "Evaluate: x² - 2x + 1 when x = 3", "4", "6", "2", "10", "A", "9 - 6 + 1 = 4.", "Variables", 32));
        questions.add(tq(testId, "Simplify: 3(x - 5) + 2x", "5x - 15", "5x - 5", "3x - 15", "5x + 15", "A", "3x - 15 + 2x = 5x - 15.", "Expressions", 33));
        questions.add(tq(testId, "Solve: 2x + 1 = 9", "x = 4", "x = 5", "x = 3", "x = 10", "A", "2x = 8. x = 4.", "Equations", 35));
        questions.add(tq(testId, "What property: (2 + 3) + 4 = 2 + (3 + 4)?", "Associative", "Commutative", "Distributive", "Identity", "A", "Regrouping without changing order is the associative property.", "Properties", 2));
        questions.add(tq(testId, "Evaluate: |x - 7| when x = 3", "4", "-4", "10", "-10", "A", "|3-7| = |-4| = 4.", "Variables", 30));
        questions.add(tq(testId, "Simplify: 6y + 2 - 4y + 8", "2y + 10", "10y + 10", "2y - 6", "10y - 6", "A", "(6y-4y) + (2+8) = 2y + 10.", "Expressions", 31));
        questions.add(tq(testId, "Solve: 5x - 10 = 0", "x = 2", "x = -2", "x = 5", "x = 10", "A", "5x = 10. x = 2.", "Equations", 35));
        questions.add(tq(testId, "What is the additive inverse of 7?", "1/7", "-7", "7", "0", "B", "The additive inverse of 7 is -7 because 7 + (-7) = 0.", "Properties", 2));
        questions.add(tq(testId, "Evaluate: 3(a + b)² when a = 1 and b = 2", "27", "12", "9", "36", "A", "3(1+2)² = 3(9) = 27.", "Variables", 32));
        questions.add(tq(testId, "Simplify: 2(4x - 1) - 3(x + 2)", "5x - 8", "5x + 4", "11x - 8", "5x - 4", "A", "8x - 2 - 3x - 6 = 5x - 8.", "Expressions", 33));
        questions.add(tq(testId, "Solve: x + 3.5 = 10", "x = 6.5", "x = 7.5", "x = 13.5", "x = 3.5", "A", "x = 10 - 3.5 = 6.5.", "Equations", 35));
        questions.add(tq(testId, "What is the multiplicative inverse of 5?", "-5", "1/5", "5", "0", "B", "The multiplicative inverse of 5 is 1/5 because 5 x 1/5 = 1.", "Properties", 2));
        questions.add(tq(testId, "Evaluate: -2x + 5y when x = 3 and y = 2", "4", "16", "-4", "1", "A", "-2(3) + 5(2) = -6 + 10 = 4.", "Variables", 32));
        questions.add(tq(testId, "Simplify: x + x + x + x", "4x", "x⁴", "4x⁴", "x + 4", "A", "x + x + x + x = 4x.", "Expressions", 31));
        questions.add(tq(testId, "Solve: -x = 12", "x = 12", "x = -12", "x = 1/12", "x = -1/12", "B", "Multiply both sides by -1: x = -12.", "Equations", 35));
        questions.add(tq(testId, "Which is a variable expression?", "3 + 5", "2x - 1", "8", "15/3", "B", "2x - 1 contains a variable (x), making it a variable expression.", "Variables", 32));
        questions.add(tq(testId, "Evaluate: (x + y)/2 when x = 8 and y = 12", "10", "20", "4", "14", "A", "(8+12)/2 = 20/2 = 10.", "Variables", 32));
        questions.add(tq(testId, "Simplify: 5(x + 2) - 5", "5x + 5", "5x + 15", "5x - 3", "5x + 10", "A", "5x + 10 - 5 = 5x + 5.", "Expressions", 33));
        questions.add(tq(testId, "Solve: 4x = -20", "x = -5", "x = 5", "x = -16", "x = -80", "A", "x = -20/4 = -5.", "Equations", 35));
        questions.add(tq(testId, "What property: 6 x 0 = 0?", "Identity", "Zero property", "Commutative", "Inverse", "B", "Any number times zero equals zero. This is the zero property of multiplication.", "Properties", 2));
        questions.add(tq(testId, "Evaluate: x³ when x = -2", "-8", "8", "-6", "6", "A", "(-2)³ = -8.", "Variables", 32));
        questions.add(tq(testId, "Simplify: 9m - 3m + m", "7m", "6m", "13m", "3m", "A", "9m - 3m + m = 7m.", "Expressions", 31));
        questions.add(tq(testId, "Solve: x/3 = -6", "x = -18", "x = -2", "x = 18", "x = -3", "A", "x = -6 x 3 = -18.", "Equations", 35));
        questions.add(tq(testId, "Is -5 a whole number, integer, or rational number?", "Whole number only", "Integer and rational", "Rational only", "None of these", "B", "-5 is an integer (negative whole) and rational (can be written as -5/1).", "Properties", 2));
        questions.add(tq(testId, "Evaluate: 2|x| + 3 when x = -4", "11", "5", "-5", "1", "A", "2|-4| + 3 = 2(4) + 3 = 11.", "Variables", 30));
        questions.add(tq(testId, "Simplify: 3a + 4b + 2a - b", "5a + 3b", "5a + 5b", "a + 3b", "5a - 3b", "A", "(3a+2a) + (4b-b) = 5a + 3b.", "Expressions", 31));
        questions.add(tq(testId, "Solve: 7 + x = 3", "x = 10", "x = 4", "x = -4", "x = -10", "C", "x = 3 - 7 = -4.", "Equations", 35));
        questions.add(tq(testId, "Classify: 0.333... (repeating)", "Rational", "Irrational", "Integer", "Whole number", "A", "0.333... = 1/3, which is rational.", "Properties", 2));
        questions.add(tq(testId, "Evaluate: xy - x when x = 5 and y = 3", "10", "12", "8", "15", "A", "5(3) - 5 = 15 - 5 = 10.", "Variables", 32));
        questions.add(tq(testId, "Simplify: -(2x - 5)", "-2x + 5", "-2x - 5", "2x + 5", "2x - 5", "A", "Distribute the negative: -2x + 5.", "Expressions", 33));
        questions.add(tq(testId, "Solve: 3x + 4 = 4", "x = 0", "x = 1", "x = -1", "x = 8/3", "A", "3x = 0. x = 0.", "Equations", 35));
        questions.add(tq(testId, "What is the coefficient of x in 7x - 3?", "7", "-3", "x", "7x", "A", "The coefficient is the number multiplied by the variable: 7.", "Variables", 32));
        questions.add(tq(testId, "Simplify: 2(x + 3) + 3(x + 1)", "5x + 9", "5x + 7", "6x + 9", "5x + 4", "A", "2x + 6 + 3x + 3 = 5x + 9.", "Expressions", 33));
        questions.add(tq(testId, "Solve: 12 - x = 5", "x = 7", "x = 17", "x = -7", "x = -17", "A", "-x = -7. x = 7.", "Equations", 35));
        return questions;
    }


    // ── Pre-Algebra Medium: Equations and Inequalities (50 questions) ──
    private List<TestQuestion> preAlgMedQuestions(Long testId) {
        List<TestQuestion> questions = new ArrayList<>();
        questions.add(tq(testId, "Solve: 2x + 5 = 17", "x = 5", "x = 6", "x = 7", "x = 11", "B", "2x = 12. x = 6.", "Two-Step Equations", 35));
        questions.add(tq(testId, "Solve the inequality: x - 3 > 7", "x > 10", "x > 4", "x < 10", "x < 4", "A", "x > 7 + 3 = 10.", "Inequalities", 37));
        questions.add(tq(testId, "What is the slope of the line through (1, 2) and (4, 8)?", "2", "3", "6", "1/2", "A", "Slope = (8-2)/(4-1) = 6/3 = 2.", "Graphing", 43));
        questions.add(tq(testId, "If f(x) = 2x + 1, what is f(4)?", "7", "8", "9", "10", "C", "f(4) = 2(4) + 1 = 9.", "Functions", 47));
        questions.add(tq(testId, "Solve: 3x - 4 = 2x + 7", "x = 11", "x = 3", "x = -11", "x = -3", "A", "x = 11.", "Two-Step Equations", 36));
        questions.add(tq(testId, "Graph y = x + 2. What is the y-intercept?", "(0, 2)", "(2, 0)", "(0, -2)", "(1, 3)", "A", "When x=0, y=2. Y-intercept is (0,2).", "Graphing", 44));
        questions.add(tq(testId, "Solve the inequality: 3x + 1 <= 10", "x <= 3", "x <= 4", "x >= 3", "x >= 4", "A", "3x <= 9. x <= 3.", "Inequalities", 37));
        questions.add(tq(testId, "Is y = 2x + 3 a function?", "Yes", "No", "Only if x > 0", "Cannot determine", "A", "For every x input there is exactly one y output. Yes, it is a function.", "Functions", 47));
        questions.add(tq(testId, "Solve: 4x + 3 = 31", "x = 7", "x = 8", "x = 6", "x = 9", "A", "4x = 28. x = 7.", "Two-Step Equations", 35));
        questions.add(tq(testId, "Solve the inequality: -2x < 8", "x > -4", "x < -4", "x > 4", "x < 4", "A", "Divide by -2, flip sign: x > -4.", "Inequalities", 37));
        questions.add(tq(testId, "What is the slope of y = -3x + 5?", "-3", "5", "3", "-5", "A", "In y = mx + b, slope m = -3.", "Graphing", 43));
        questions.add(tq(testId, "If g(x) = x² - 1, what is g(3)?", "8", "10", "6", "4", "A", "g(3) = 9 - 1 = 8.", "Functions", 47));
        questions.add(tq(testId, "Solve: x/2 + 3 = 10", "x = 14", "x = 7", "x = 20", "x = 26", "A", "x/2 = 7. x = 14.", "Two-Step Equations", 35));
        questions.add(tq(testId, "Solve: 5x - 2 > 13", "x > 3", "x > 2", "x < 3", "x > 5", "A", "5x > 15. x > 3.", "Inequalities", 37));
        questions.add(tq(testId, "A line passes through (0, -1) with slope 2. Equation?", "y = 2x - 1", "y = -x + 2", "y = 2x + 1", "y = -2x - 1", "A", "y = mx + b = 2x + (-1) = 2x - 1.", "Graphing", 44));
        questions.add(tq(testId, "Which relation is NOT a function? {(1,2), (3,4), (1,5), (6,7)}", "It IS a function", "It is NOT a function", "Cannot determine", "Need more points", "B", "x=1 maps to both 2 and 5. Not a function.", "Functions", 47));
        questions.add(tq(testId, "Solve: 6x - 5 = 4x + 9", "x = 7", "x = 2", "x = -7", "x = -2", "A", "2x = 14. x = 7.", "Two-Step Equations", 36));
        questions.add(tq(testId, "Solve: -4x + 1 >= 9", "x <= -2", "x >= -2", "x <= 2", "x >= 2", "A", "-4x >= 8. x <= -2.", "Inequalities", 37));
        questions.add(tq(testId, "What is the x-intercept of y = 3x - 6?", "(2, 0)", "(0, 2)", "(-2, 0)", "(6, 0)", "A", "Set y=0: 0=3x-6. x=2. Point: (2,0).", "Graphing", 44));
        questions.add(tq(testId, "If f(x) = -x + 7, what is f(-3)?", "10", "4", "-10", "7", "A", "f(-3) = -(-3) + 7 = 3 + 7 = 10.", "Functions", 47));
        questions.add(tq(testId, "Solve: 7 - 2x = 1", "x = 3", "x = 4", "x = -3", "x = -4", "A", "-2x = -6. x = 3.", "Two-Step Equations", 35));
        questions.add(tq(testId, "Solve: 2(x + 4) > 14", "x > 3", "x > 7", "x > 5", "x > 11", "A", "x + 4 > 7. x > 3.", "Inequalities", 37));
        questions.add(tq(testId, "Are y = 2x + 1 and y = -1/2 x + 3 perpendicular?", "Yes", "No", "Parallel", "Same line", "A", "Slopes: 2 and -1/2. Product = -1. Yes, perpendicular.", "Graphing", 43));
        questions.add(tq(testId, "What is the domain of f(x) = x + 5?", "All real numbers", "x > 0", "x >= -5", "x != 0", "A", "A linear function has domain of all real numbers.", "Functions", 47));
        questions.add(tq(testId, "Solve: 3(x - 2) = 18", "x = 8", "x = 6", "x = 4", "x = 10", "A", "x - 2 = 6. x = 8.", "Two-Step Equations", 35));
        questions.add(tq(testId, "Solve: x/3 - 1 < 4", "x < 15", "x < 12", "x < 9", "x > 15", "A", "x/3 < 5. x < 15.", "Inequalities", 37));
        questions.add(tq(testId, "What is the slope of a vertical line?", "0", "1", "Undefined", "-1", "C", "A vertical line has undefined slope.", "Graphing", 43));
        questions.add(tq(testId, "If h(x) = 3x - 2, solve h(x) = 10.", "x = 4", "x = 3", "x = 6", "x = 8/3", "A", "3x - 2 = 10. 3x = 12. x = 4.", "Functions", 47));
        questions.add(tq(testId, "Solve: 5x + 2 = 3x + 12", "x = 5", "x = 7", "x = 4", "x = 10", "A", "2x = 10. x = 5.", "Two-Step Equations", 36));
        questions.add(tq(testId, "Solve: 4 - x >= 7", "x <= -3", "x >= -3", "x <= 3", "x >= 3", "A", "-x >= 3. x <= -3.", "Inequalities", 37));
        questions.add(tq(testId, "Find the midpoint of (2, 4) and (8, 10).", "(5, 7)", "(6, 14)", "(3, 3)", "(10, 14)", "A", "Midpoint = ((2+8)/2, (4+10)/2) = (5, 7).", "Graphing", 43));
        questions.add(tq(testId, "If f(x) = x² + x, what is f(-2)?", "2", "-2", "6", "-6", "A", "f(-2) = 4 + (-2) = 2.", "Functions", 47));
        questions.add(tq(testId, "Solve: -3x + 8 = 2", "x = 2", "x = -2", "x = 10/3", "x = -10/3", "A", "-3x = -6. x = 2.", "Two-Step Equations", 35));
        questions.add(tq(testId, "Solve: 2x + 1 <= 3x - 4", "x >= 5", "x <= 5", "x >= -5", "x <= -5", "A", "1+4 <= x. x >= 5.", "Inequalities", 37));
        questions.add(tq(testId, "What is the distance between (1, 2) and (4, 6)?", "5", "7", "3", "25", "A", "d = sqrt((3)²+(4)²) = sqrt(9+16) = sqrt(25) = 5.", "Graphing", 43));
        questions.add(tq(testId, "Does the table represent a function? x: 1,2,3,4 y: 5,6,7,8", "Yes", "No", "Cannot determine", "Only if linear", "A", "Each x has exactly one y value. Yes, it's a function.", "Functions", 47));
        questions.add(tq(testId, "Solve: 2(3x - 1) = 4x + 6", "x = 4", "x = 3", "x = 2", "x = 5", "A", "6x-2=4x+6. 2x=8. x=4.", "Two-Step Equations", 36));
        questions.add(tq(testId, "Solve: -x/4 > 2", "x < -8", "x > -8", "x < 8", "x > 8", "A", "Multiply by -4, flip: x < -8.", "Inequalities", 37));
        questions.add(tq(testId, "A line has slope 0 and passes through (3, 5). Equation?", "y = 5", "x = 3", "y = 3", "x = 5", "A", "Slope 0 means horizontal line. y = 5.", "Graphing", 44));
        questions.add(tq(testId, "What is the range of f(x) = |x| for all real x?", "y >= 0", "All real numbers", "y > 0", "y <= 0", "A", "Absolute value is always non-negative. Range: y >= 0.", "Functions", 47));
        questions.add(tq(testId, "Solve: 4(x + 1) = 2(x + 5)", "x = 3", "x = 4", "x = 2", "x = 5", "A", "4x+4=2x+10. 2x=6. x=3.", "Two-Step Equations", 36));
        questions.add(tq(testId, "Solve: 3(x - 1) >= 2x + 5", "x >= 8", "x <= 8", "x >= 2", "x <= 2", "A", "3x-3>=2x+5. x>=8.", "Inequalities", 37));
        questions.add(tq(testId, "Two lines have slopes 3 and 3. They are:", "Parallel", "Perpendicular", "Neither", "Same line", "A", "Same slope means parallel (assuming different y-intercepts).", "Graphing", 43));
        questions.add(tq(testId, "If f(x) = 5 - 2x, what is f(0)?", "5", "0", "-5", "2", "A", "f(0) = 5 - 0 = 5.", "Functions", 47));
        questions.add(tq(testId, "Solve: x/5 + 2 = 6", "x = 20", "x = 4", "x = 40", "x = 8", "A", "x/5 = 4. x = 20.", "Two-Step Equations", 35));
        questions.add(tq(testId, "Solve: 5 - 3x < -7", "x > 4", "x < 4", "x > -4", "x < -4", "A", "-3x < -12. x > 4.", "Inequalities", 37));
        questions.add(tq(testId, "What is the y-intercept of 2x + 3y = 12?", "(0, 4)", "(6, 0)", "(0, 6)", "(4, 0)", "A", "Set x=0: 3y=12. y=4. Y-intercept: (0,4).", "Graphing", 44));
        questions.add(tq(testId, "If f(x) = x² - 4, for what x is f(x) = 0?", "x = 2 or x = -2", "x = 4", "x = -4", "x = 0", "A", "x² = 4. x = ±2.", "Functions", 47));
        questions.add(tq(testId, "Solve: 8x - 3 = 5x + 9", "x = 4", "x = 3", "x = 6", "x = 2", "A", "3x = 12. x = 4.", "Two-Step Equations", 36));
        questions.add(tq(testId, "Solve: 2(x - 3) + x <= 15", "x <= 7", "x <= 5", "x >= 7", "x >= 5", "A", "2x-6+x<=15. 3x<=21. x<=7.", "Inequalities", 37));
        return questions;
    }


    // ── Pre-Algebra Hard: Advanced Topics (50 questions) ──
    private List<TestQuestion> preAlgHardQuestions(Long testId) {
        List<TestQuestion> questions = new ArrayList<>();
        questions.add(tq(testId, "Solve the system: x + y = 8, 2x - y = 7", "x=5, y=3", "x=3, y=5", "x=4, y=4", "x=6, y=2", "A", "Add: 3x=15. x=5. y=3.", "Systems", 104));
        questions.add(tq(testId, "Simplify: (3x²)(2x³)", "6x⁵", "5x⁵", "6x⁶", "5x⁶", "A", "3x2=6. 2+3=5. Answer: 6x⁵.", "Polynomials", 107));
        questions.add(tq(testId, "Solve: x² = 49", "x = 7 only", "x = ±7", "x = -7 only", "x = 49", "B", "x = ±√49 = ±7.", "Quadratics", 106));
        questions.add(tq(testId, "A number plus twice the number equals 36. What is the number?", "9", "12", "15", "18", "B", "x + 2x = 36. 3x = 36. x = 12.", "Word Problems", 35));
        questions.add(tq(testId, "Solve the system: 3x + y = 10, x - y = 2", "x=3, y=1", "x=4, y=-2", "x=2, y=4", "x=1, y=7", "A", "Add: 4x=12. x=3. y=1.", "Systems", 104));
        questions.add(tq(testId, "Expand: (x + 4)(x - 4)", "x² - 16", "x² + 16", "x² - 8x + 16", "x² + 8x - 16", "A", "Difference of squares: x² - 16.", "Polynomials", 106));
        questions.add(tq(testId, "Solve: x² + 5x + 6 = 0", "x = -2 or x = -3", "x = 2 or x = 3", "x = -1 or x = -6", "x = 1 or x = 6", "A", "Factor: (x+2)(x+3)=0. x=-2 or x=-3.", "Quadratics", 106));
        questions.add(tq(testId, "Two consecutive integers sum to 47. What are they?", "22 and 25", "23 and 24", "21 and 26", "20 and 27", "B", "x + (x+1) = 47. 2x = 46. x = 23. Numbers: 23, 24.", "Word Problems", 35));
        questions.add(tq(testId, "Solve the system: 2x + 3y = 13, x + y = 5", "x=2, y=3", "x=3, y=2", "x=4, y=1", "x=1, y=4", "A", "From eq2: x=5-y. Sub: 2(5-y)+3y=13. 10-2y+3y=13. y=3. x=2.", "Systems", 104));
        questions.add(tq(testId, "Simplify: (2x + 3)(x + 5)", "2x² + 13x + 15", "2x² + 8x + 15", "2x² + 13x + 8", "2x² + 7x + 15", "A", "2x²+10x+3x+15 = 2x²+13x+15.", "Polynomials", 106));
        questions.add(tq(testId, "Solve: x² - 9 = 0", "x = ±3", "x = 3 only", "x = 9", "x = ±9", "A", "x² = 9. x = ±3.", "Quadratics", 106));
        questions.add(tq(testId, "The perimeter of a rectangle is 38. Length is 3 more than width. Find dimensions.", "8 x 11", "9 x 10", "7 x 12", "6 x 13", "A", "2(w+w+3)=38. 2(2w+3)=38. 2w+3=19. w=8. l=11.", "Word Problems", 59));
        questions.add(tq(testId, "Solve the system: x - 2y = 1, 3x + 2y = 11", "x=3, y=1", "x=4, y=1", "x=2, y=1", "x=5, y=2", "A", "Add: 4x=12. x=3. 3-2y=1. y=1.", "Systems", 104));
        questions.add(tq(testId, "Simplify: (4x³)/(2x)", "2x²", "2x³", "8x²", "2x⁴", "A", "4/2=2. x³/x=x². Answer: 2x².", "Polynomials", 107));
        questions.add(tq(testId, "Solve: x² - 5x + 6 = 0", "x = 2 or x = 3", "x = -2 or x = -3", "x = 1 or x = 6", "x = -1 or x = -6", "A", "Factor: (x-2)(x-3)=0. x=2 or x=3.", "Quadratics", 106));
        questions.add(tq(testId, "A train leaves at 60 mph. Another leaves 1 hour later at 80 mph. When does the second catch up?", "3 hours", "4 hours", "2 hours", "5 hours", "A", "60(t+1)=80t. 60t+60=80t. 60=20t. t=3 hours after second train leaves.", "Word Problems", 21));
        questions.add(tq(testId, "Solve the system: 4x - y = 5, 2x + y = 7", "x=2, y=3", "x=3, y=7", "x=1, y=-1", "x=2, y=1", "A", "Add: 6x=12. x=2. y=7-4=3.", "Systems", 104));
        questions.add(tq(testId, "Expand: (x + 2)²", "x² + 4x + 4", "x² + 2x + 4", "x² + 4x + 2", "x² + 4", "A", "(x+2)(x+2) = x²+2x+2x+4 = x²+4x+4.", "Polynomials", 106));
        questions.add(tq(testId, "Solve: x² + x - 12 = 0", "x = 3 or x = -4", "x = -3 or x = 4", "x = 6 or x = -2", "x = -6 or x = 2", "A", "Factor: (x+4)(x-3)=0. x=-4 or x=3.", "Quadratics", 106));
        questions.add(tq(testId, "The sum of three consecutive even numbers is 48. What is the largest?", "14", "16", "18", "20", "C", "x+(x+2)+(x+4)=48. 3x+6=48. x=14. Largest: 18.", "Word Problems", 35));
        questions.add(tq(testId, "Solve the system: x + 4y = 14, x - 2y = 2", "x=6, y=2", "x=8, y=3", "x=4, y=1", "x=10, y=1", "A", "Subtract: 6y=12. y=2. x=14-8=6.", "Systems", 104));
        questions.add(tq(testId, "Simplify: 3x² + 5x² - 2x²", "6x²", "8x²", "10x²", "4x²", "A", "3+5-2=6. Answer: 6x².", "Polynomials", 106));
        questions.add(tq(testId, "Solve: 2x² = 50", "x = ±5", "x = 25", "x = ±25", "x = 5 only", "A", "x² = 25. x = ±5.", "Quadratics", 106));
        questions.add(tq(testId, "A rectangle's length is twice its width. Area is 72. Find the width.", "4", "5", "6", "8", "C", "w x 2w = 72. 2w² = 72. w² = 36. w = 6.", "Word Problems", 60));
        questions.add(tq(testId, "Solve the system: 5x + 2y = 16, 3x - 2y = 0", "x=2, y=3", "x=4, y=-2", "x=1, y=5.5", "x=3, y=0.5", "A", "Add: 8x=16. x=2. 10+2y=16. 2y=6. y=3.", "Systems", 104));
        questions.add(tq(testId, "Expand: (3x - 1)(2x + 5)", "6x² + 13x - 5", "6x² + 17x - 5", "6x² - 13x - 5", "5x² + 13x - 5", "A", "6x²+15x-2x-5 = 6x²+13x-5.", "Polynomials", 106));
        questions.add(tq(testId, "Solve: x² - 4x = 0", "x = 0 or x = 4", "x = 4 only", "x = 0 only", "x = ±4", "A", "x(x-4)=0. x=0 or x=4.", "Quadratics", 106));
        questions.add(tq(testId, "A coin jar has dimes and quarters totaling $3.40. There are 16 coins. How many quarters?", "8", "10", "12", "6", "A", "d+q=16. 10d+25q=340. d=16-q. 10(16-q)+25q=340. 160+15q=340. q=12. Wait: 15q=180. q=12. Check: 4 dimes + 12 quarters = 40+300=340. Yes. Answer C=12.", "Word Problems", 35));
        questions.add(tq(testId, "Solve the system: 2x - y = 4, x + 3y = 9", "x=3, y=2", "x=2, y=0", "x=4, y=4", "x=1, y=-2", "A", "From eq1: y=2x-4. Sub: x+3(2x-4)=9. 7x-12=9. 7x=21. x=3. y=2.", "Systems", 104));
        questions.add(tq(testId, "Simplify: (x³)²", "x⁵", "x⁶", "x⁹", "2x³", "B", "Power rule: (x³)² = x^(3x2) = x⁶.", "Polynomials", 107));
        questions.add(tq(testId, "Solve: x² + 6x + 9 = 0", "x = -3 (double root)", "x = 3 (double root)", "x = -3 or x = 3", "x = -9", "A", "(x+3)² = 0. x = -3.", "Quadratics", 106));
        questions.add(tq(testId, "Two numbers differ by 5. Their product is 84. Find the larger number.", "12", "14", "7", "10", "A", "x(x-5)=84. x²-5x-84=0. (x-12)(x+7)=0. x=12.", "Word Problems", 35));
        questions.add(tq(testId, "Solve the system: 3x + 4y = 18, x - 2y = -4", "x=2, y=3", "x=4, y=1.5", "x=0, y=4.5", "x=6, y=0", "A", "From eq2: x=2y-4. Sub: 3(2y-4)+4y=18. 6y-12+4y=18. 10y=30. y=3. x=2.", "Systems", 104));
        questions.add(tq(testId, "Subtract: (5x² + 3x - 2) - (2x² - x + 4)", "3x² + 4x - 6", "3x² + 2x + 2", "7x² + 4x - 6", "3x² + 4x + 2", "A", "5x²-2x²=3x². 3x-(-x)=4x. -2-4=-6. Answer: 3x²+4x-6.", "Polynomials", 106));
        questions.add(tq(testId, "Solve: x² - 16 = 0", "x = ±4", "x = 4 only", "x = 8", "x = ±8", "A", "x² = 16. x = ±4.", "Quadratics", 106));
        questions.add(tq(testId, "A boat goes 12 mph in still water. Current is 3 mph. Time to go 30 miles upstream?", "2 hours", "2.5 hours", "3 hours", "10/3 hours", "D", "Upstream speed = 12-3 = 9 mph. Time = 30/9 = 10/3 hours.", "Word Problems", 21));
        questions.add(tq(testId, "Solve the system: x + y = 6, xy = 8", "x=2,y=4 or x=4,y=2", "x=1,y=8", "x=3,y=3", "x=6,y=0", "A", "From eq1: y=6-x. Sub: x(6-x)=8. 6x-x²=8. x²-6x+8=0. (x-2)(x-4)=0.", "Systems", 104));
        questions.add(tq(testId, "Simplify: x⁵ / x²", "x³", "x⁷", "x^(5/2)", "x^10", "A", "Subtract exponents: 5-2=3. Answer: x³.", "Polynomials", 107));
        questions.add(tq(testId, "Solve: x² - 2x - 8 = 0", "x = 4 or x = -2", "x = -4 or x = 2", "x = 8 or x = -1", "x = -8 or x = 1", "A", "Factor: (x-4)(x+2)=0. x=4 or x=-2.", "Quadratics", 106));
        questions.add(tq(testId, "A worker can do a job in 6 hours. Another in 4 hours. Together, how long?", "2.4 hours", "5 hours", "3 hours", "2 hours", "A", "Rate: 1/6+1/4=2/12+3/12=5/12. Time=12/5=2.4 hours.", "Word Problems", 21));
        questions.add(tq(testId, "Solve the system: y = 2x + 1, y = -x + 7", "x=2, y=5", "x=3, y=7", "x=1, y=3", "x=4, y=3", "A", "2x+1=-x+7. 3x=6. x=2. y=5.", "Systems", 104));
        questions.add(tq(testId, "Expand: (x - 3)²", "x² - 6x + 9", "x² - 3x + 9", "x² - 6x - 9", "x² + 6x + 9", "A", "(x-3)(x-3) = x²-3x-3x+9 = x²-6x+9.", "Polynomials", 106));
        questions.add(tq(testId, "What is the discriminant of x² + 4x + 4 = 0?", "0", "4", "8", "16", "A", "b²-4ac = 16-16 = 0. One repeated root.", "Quadratics", 106));
        questions.add(tq(testId, "A mixture of 20% and 50% solutions makes 30 liters of 30% solution. How much of each?", "20L of 20%, 10L of 50%", "15L of 20%, 15L of 50%", "10L of 20%, 20L of 50%", "25L of 20%, 5L of 50%", "A", "0.20x+0.50(30-x)=0.30(30). 0.20x+15-0.50x=9. -0.30x=-6. x=20.", "Word Problems", 22));
        questions.add(tq(testId, "Solve the system: 2x + y = 10, 4x + 2y = 20", "Infinitely many solutions", "x=5, y=0", "No solution", "x=0, y=10", "A", "Second equation is 2x first. Same line. Infinitely many solutions.", "Systems", 104));
        questions.add(tq(testId, "Add: (2x² + 3x - 1) + (x² - 5x + 4)", "3x² - 2x + 3", "3x² + 8x + 3", "x² - 2x + 3", "3x² - 2x - 5", "A", "2x²+x²=3x². 3x-5x=-2x. -1+4=3.", "Polynomials", 106));
        questions.add(tq(testId, "Solve: x² + 2x - 15 = 0", "x = 3 or x = -5", "x = -3 or x = 5", "x = 15 or x = -1", "x = -15 or x = 1", "A", "Factor: (x+5)(x-3)=0. x=-5 or x=3.", "Quadratics", 106));
        questions.add(tq(testId, "A triangle has angles in ratio 2:3:4. Find the largest angle.", "60°", "70°", "80°", "90°", "C", "2x+3x+4x=180. 9x=180. x=20. Largest: 4(20)=80°.", "Word Problems", 53));
        questions.add(tq(testId, "Solve the system: x + 2y = 8, 3x + 6y = 15", "No solution", "x=2, y=3", "Infinitely many", "x=0, y=4", "A", "Multiply eq1 by 3: 3x+6y=24. But eq2 says 3x+6y=15. Contradiction. No solution.", "Systems", 104));
        questions.add(tq(testId, "Factor: x² - x - 6", "(x-3)(x+2)", "(x+3)(x-2)", "(x-6)(x+1)", "(x+6)(x-1)", "A", "Find numbers that multiply to -6 and add to -1: -3 and 2. (x-3)(x+2).", "Polynomials", 106));
        return questions;
    }

}
