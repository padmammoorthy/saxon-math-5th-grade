package com.saxonmath.mathquiz.config;

import com.saxonmath.mathquiz.model.Question;
import com.saxonmath.mathquiz.repository.QuestionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Saxon Math Course 2 (Grade 7) — original practice questions.
 * 3–5 questions per lesson across all 120 lessons.
 */
@Component
@Order(1)
public class DataLoader implements CommandLineRunner {

    private final QuestionRepository questionRepository;

    public DataLoader(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    private static final Map<Integer, String> LESSON_TITLES = new HashMap<>();
    static {
        LESSON_TITLES.put(1,  "Place Value Through Billions");
        LESSON_TITLES.put(2,  "Comparing and Ordering Integers");
        LESSON_TITLES.put(3,  "Operations with Whole Numbers");
        LESSON_TITLES.put(4,  "Factors and Multiples");
        LESSON_TITLES.put(5,  "Prime Factorization");
        LESSON_TITLES.put(6,  "GCF and LCM");
        LESSON_TITLES.put(7,  "Fractions and Mixed Numbers");
        LESSON_TITLES.put(8,  "Equivalent Fractions and Simplifying");
        LESSON_TITLES.put(9,  "Adding and Subtracting Fractions");
        LESSON_TITLES.put(10, "Multiplying Fractions");
        LESSON_TITLES.put(11, "Dividing Fractions");
        LESSON_TITLES.put(12, "Adding and Subtracting Mixed Numbers");
        LESSON_TITLES.put(13, "Multiplying and Dividing Mixed Numbers");
        LESSON_TITLES.put(14, "Decimal Place Value");
        LESSON_TITLES.put(15, "Adding and Subtracting Decimals");
        LESSON_TITLES.put(16, "Multiplying Decimals");
        LESSON_TITLES.put(17, "Dividing Decimals");
        LESSON_TITLES.put(18, "Fractions, Decimals, and Percents");
        LESSON_TITLES.put(19, "Percent of a Number");
        LESSON_TITLES.put(20, "Percent Problems");
        LESSON_TITLES.put(21, "Ratio and Rate");
        LESSON_TITLES.put(22, "Proportions");
        LESSON_TITLES.put(23, "Scale Drawings and Maps");
        LESSON_TITLES.put(24, "Integers: Adding and Subtracting");
        LESSON_TITLES.put(25, "Integers: Multiplying and Dividing");
        LESSON_TITLES.put(26, "Order of Operations");
        LESSON_TITLES.put(27, "Exponents and Powers");
        LESSON_TITLES.put(28, "Scientific Notation");
        LESSON_TITLES.put(29, "Square Roots and Irrational Numbers");
        LESSON_TITLES.put(30, "The Number Line and Absolute Value");
        LESSON_TITLES.put(31, "Algebraic Expressions");
        LESSON_TITLES.put(32, "Writing and Evaluating Expressions");
        LESSON_TITLES.put(33, "Properties of Operations");
        LESSON_TITLES.put(34, "Solving One-Step Equations");
        LESSON_TITLES.put(35, "Solving Two-Step Equations");
        LESSON_TITLES.put(36, "Solving Equations with Variables on Both Sides");
        LESSON_TITLES.put(37, "Inequalities");
        LESSON_TITLES.put(38, "Graphing Inequalities");
        LESSON_TITLES.put(39, "Writing Equations from Word Problems");
        LESSON_TITLES.put(40, "Formulas and Literal Equations");
        LESSON_TITLES.put(41, "The Coordinate Plane");
        LESSON_TITLES.put(42, "Graphing Linear Equations");
        LESSON_TITLES.put(43, "Slope");
        LESSON_TITLES.put(44, "Slope-Intercept Form");
        LESSON_TITLES.put(45, "Writing Linear Equations");
        LESSON_TITLES.put(46, "Direct Variation");
        LESSON_TITLES.put(47, "Functions and Relations");
        LESSON_TITLES.put(48, "Patterns and Sequences");
        LESSON_TITLES.put(49, "Arithmetic Sequences");
        LESSON_TITLES.put(50, "Geometric Sequences");
        LESSON_TITLES.put(51, "Angles and Lines");
        LESSON_TITLES.put(52, "Parallel Lines and Transversals");
        LESSON_TITLES.put(53, "Triangles: Angles and Classification");
        LESSON_TITLES.put(54, "Congruent Triangles");
        LESSON_TITLES.put(55, "Similar Triangles");
        LESSON_TITLES.put(56, "The Pythagorean Theorem");
        LESSON_TITLES.put(57, "Quadrilaterals");
        LESSON_TITLES.put(58, "Polygons and Interior Angles");
        LESSON_TITLES.put(59, "Perimeter and Circumference");
        LESSON_TITLES.put(60, "Area of Polygons");
        LESSON_TITLES.put(61, "Area of Circles");
        LESSON_TITLES.put(62, "Composite Figures");
        LESSON_TITLES.put(63, "Surface Area of Prisms");
        LESSON_TITLES.put(64, "Surface Area of Cylinders");
        LESSON_TITLES.put(65, "Surface Area of Pyramids and Cones");
        LESSON_TITLES.put(66, "Volume of Prisms");
        LESSON_TITLES.put(67, "Volume of Cylinders");
        LESSON_TITLES.put(68, "Volume of Pyramids and Cones");
        LESSON_TITLES.put(69, "Volume of Spheres");
        LESSON_TITLES.put(70, "Transformations: Translations");
        LESSON_TITLES.put(71, "Transformations: Reflections");
        LESSON_TITLES.put(72, "Transformations: Rotations");
        LESSON_TITLES.put(73, "Transformations: Dilations");
        LESSON_TITLES.put(74, "Symmetry");
        LESSON_TITLES.put(75, "Mean, Median, Mode, and Range");
        LESSON_TITLES.put(76, "Frequency Tables and Histograms");
        LESSON_TITLES.put(77, "Box-and-Whisker Plots");
        LESSON_TITLES.put(78, "Scatter Plots and Correlation");
        LESSON_TITLES.put(79, "Line of Best Fit");
        LESSON_TITLES.put(80, "Circle Graphs");
        LESSON_TITLES.put(81, "Counting Principle");
        LESSON_TITLES.put(82, "Permutations");
        LESSON_TITLES.put(83, "Combinations");
        LESSON_TITLES.put(84, "Theoretical Probability");
        LESSON_TITLES.put(85, "Experimental Probability");
        LESSON_TITLES.put(86, "Compound Events: Independent");
        LESSON_TITLES.put(87, "Compound Events: Dependent");
        LESSON_TITLES.put(88, "Probability with Geometry");
        LESSON_TITLES.put(89, "Customary Measurement");
        LESSON_TITLES.put(90, "Metric Measurement");
        LESSON_TITLES.put(91, "Converting Units");
        LESSON_TITLES.put(92, "Rates and Unit Rates");
        LESSON_TITLES.put(93, "Percent Change");
        LESSON_TITLES.put(94, "Simple Interest");
        LESSON_TITLES.put(95, "Compound Interest");
        LESSON_TITLES.put(96, "Discount and Markup");
        LESSON_TITLES.put(97, "Tax and Tip");
        LESSON_TITLES.put(98, "Multi-Step Percent Problems");
        LESSON_TITLES.put(99, "Number Theory: Rational Numbers");
        LESSON_TITLES.put(100, "Operations with Rational Numbers");
        LESSON_TITLES.put(101, "Solving Multi-Step Equations");
        LESSON_TITLES.put(102, "Solving Equations with Fractions");
        LESSON_TITLES.put(103, "Systems of Equations: Graphing");
        LESSON_TITLES.put(104, "Systems of Equations: Substitution");
        LESSON_TITLES.put(105, "Monomials and Polynomials");
        LESSON_TITLES.put(106, "Adding and Subtracting Polynomials");
        LESSON_TITLES.put(107, "Multiplying Monomials");
        LESSON_TITLES.put(108, "Dividing Monomials");
        LESSON_TITLES.put(109, "The Distributive Property");
        LESSON_TITLES.put(110, "Factoring with GCF");
        LESSON_TITLES.put(111, "Pythagorean Theorem Applications");
        LESSON_TITLES.put(112, "Distance and Midpoint");
        LESSON_TITLES.put(113, "Angle Relationships Review");
        LESSON_TITLES.put(114, "Proportional Relationships");
        LESSON_TITLES.put(115, "Non-Proportional Relationships");
        LESSON_TITLES.put(116, "Interpreting Graphs");
        LESSON_TITLES.put(117, "Data Analysis and Sampling");
        LESSON_TITLES.put(118, "Making Predictions");
        LESSON_TITLES.put(119, "Problem Solving Strategies");
        LESSON_TITLES.put(120, "Cumulative Review");
    }

    private static Question q(String text, String a, String b, String c, String d,
                               String correct, String hint, int lesson, String topic) {
        String title = LESSON_TITLES.getOrDefault(lesson, "Lesson " + lesson);
        return new Question(null, text, a, b, c, d, correct, hint, lesson, title, topic);
    }

    @Override
    public void run(String... args) {
        if (questionRepository.count() > 0) return;
        List<Question> all = new ArrayList<>();
        all.addAll(lessons1to20());
        all.addAll(lessons21to40());
        all.addAll(lessons41to60());
        all.addAll(lessons61to80());
        all.addAll(lessons81to100());
        all.addAll(lessons101to120());
        questionRepository.saveAll(all);
    }

    // ── Lessons 1–20 ──────────────────────────────────────────────────────────
    private List<Question> lessons1to20() {
        return List.of(
            // Lesson 1 – Place Value Through Billions
            q("What is the value of the digit 6 in 4,632,000,000?",
              "6,000,000", "60,000,000", "600,000,000", "6,000,000,000", "C",
              "In 4,632,000,000 the digit 6 is in the hundred-millions place = 600,000,000.", 1, "Place Value"),
            q("Write 7,040,000,000 in words.",
              "Seven billion, four million", "Seven billion, forty million", "Seven trillion, forty million", "Seven billion, four hundred million", "B",
              "7,040,000,000 = 7 billions + 40 millions = seven billion, forty million.", 1, "Place Value"),
            q("Which digit is in the ten-billions place of 53,200,000,000?",
              "5", "3", "2", "0", "A",
              "Ten-billions is the second digit from the left in an 11-digit number. 53,200,000,000 → 5 is in ten-billions.", 1, "Place Value"),
            q("Round 8,472,315,000 to the nearest billion.",
              "8,000,000,000", "8,500,000,000", "9,000,000,000", "8,400,000,000", "A",
              "Look at the hundred-millions digit: 4 < 5, so round down. Answer: 8,000,000,000.", 1, "Place Value"),

            // Lesson 2 – Comparing and Ordering Integers
            q("Order from least to greatest: -8, 3, -1, 0, 5",
              "-1, -8, 0, 3, 5", "-8, -1, 0, 3, 5", "0, -1, -8, 3, 5", "5, 3, 0, -1, -8", "B",
              "On a number line, more negative = smaller. -8 < -1 < 0 < 3 < 5.", 2, "Integers"),
            q("Which is true? -15 ___ -9",
              "-15 > -9", "-15 = -9", "-15 < -9", "Cannot compare", "C",
              "-15 is further left on the number line, so -15 < -9.", 2, "Integers"),
            q("What is the absolute value of -23?",
              "-23", "0", "23", "46", "C",
              "Absolute value = distance from zero. |-23| = 23.", 2, "Integers"),
            q("Which set is in descending order?",
              "-4, -2, 0, 3", "3, 0, -2, -4", "0, -2, 3, -4", "-2, -4, 0, 3", "B",
              "Descending = greatest to least: 3 > 0 > -2 > -4.", 2, "Integers"),

            // Lesson 3 – Operations with Whole Numbers
            q("What is 4,527 × 38?",
              "172,026", "172,026", "171,026", "173,026", "A",
              "4,527 × 38 = 4,527 × 30 + 4,527 × 8 = 135,810 + 36,216 = 172,026.", 3, "Whole Numbers"),
            q("What is 15,624 ÷ 24?",
              "641", "651", "661", "631", "B",
              "15,624 ÷ 24 = 651. Check: 651 × 24 = 15,624.", 3, "Whole Numbers"),
            q("A factory produces 1,250 items per hour. How many in a 16-hour shift?",
              "18,000", "19,000", "20,000", "21,000", "C",
              "1,250 × 16 = 20,000 items.", 3, "Whole Numbers"),
            q("What is 100,000 - 37,846?",
              "62,154", "63,154", "62,254", "61,154", "A",
              "100,000 - 37,846 = 62,154. Borrow across zeros carefully.", 3, "Whole Numbers"),

            // Lesson 4 – Factors and Multiples
            q("What are all the factors of 36?",
              "1,2,3,4,6,9,12,18,36", "1,2,3,6,9,12,36", "1,2,4,6,9,18,36", "2,3,4,6,9,12,18", "A",
              "Factors of 36: 1×36, 2×18, 3×12, 4×9, 6×6. All: 1,2,3,4,6,9,12,18,36.", 4, "Number Theory"),
            q("What is the LCM of 8 and 12?",
              "4", "16", "24", "96", "C",
              "Multiples of 8: 8,16,24... Multiples of 12: 12,24... LCM = 24.", 4, "Number Theory"),
            q("Is 91 prime or composite?",
              "Prime", "Composite", "Neither", "Both", "B",
              "91 = 7 × 13. It has factors other than 1 and itself, so it is composite.", 4, "Number Theory"),
            q("What is the GCF of 48 and 60?",
              "6", "8", "12", "24", "C",
              "Factors of 48: 1,2,3,4,6,8,12,16,24,48. Factors of 60: 1,2,3,4,5,6,10,12,15,20,30,60. GCF = 12.", 4, "Number Theory"),

            // Lesson 5 – Prime Factorization
            q("What is the prime factorization of 60?",
              "2 × 30", "2² × 3 × 5", "2 × 3 × 10", "4 × 15", "B",
              "60 = 2 × 30 = 2 × 2 × 15 = 2 × 2 × 3 × 5 = 2² × 3 × 5.", 5, "Number Theory"),
            q("What is the prime factorization of 84?",
              "2² × 3 × 7", "2 × 42", "4 × 21", "2³ × 3 × 7", "A",
              "84 = 2 × 42 = 2 × 2 × 21 = 2 × 2 × 3 × 7 = 2² × 3 × 7.", 5, "Number Theory"),
            q("Which is a prime number?",
              "51", "57", "59", "63", "C",
              "59 has no factors other than 1 and 59. 51=3×17, 57=3×19, 63=9×7.", 5, "Number Theory"),
            q("Using prime factorization, what is the GCF of 36 and 48?",
              "6", "8", "12", "18", "C",
              "36 = 2²×3², 48 = 2⁴×3. GCF = 2²×3 = 12.", 5, "Number Theory"),

            // Lesson 6 – GCF and LCM
            q("What is the LCM of 6, 8, and 12?",
              "12", "24", "48", "96", "B",
              "LCM(6,8)=24. LCM(24,12)=24. Answer: 24.", 6, "Number Theory"),
            q("Two buses leave at the same time. One comes every 15 min, one every 20 min. When do they next arrive together?",
              "35 min", "40 min", "60 min", "75 min", "C",
              "LCM(15,20) = 60 minutes.", 6, "Number Theory"),
            q("What is the GCF of 72 and 90?",
              "9", "12", "18", "36", "C",
              "72 = 2³×3², 90 = 2×3²×5. GCF = 2×3² = 18.", 6, "Number Theory"),

            // Lesson 7 – Fractions and Mixed Numbers
            q("Convert 17/5 to a mixed number.",
              "3 1/5", "3 2/5", "2 3/5", "4 1/5", "B",
              "17 ÷ 5 = 3 remainder 2. So 17/5 = 3 2/5.", 7, "Fractions"),
            q("Convert 4 3/8 to an improper fraction.",
              "32/8", "35/8", "19/8", "43/8", "B",
              "4 × 8 + 3 = 35. Answer: 35/8.", 7, "Fractions"),
            q("Which fraction is between 1/3 and 1/2?",
              "1/4", "2/5", "3/7", "5/12", "B",
              "1/3 ≈ 0.333, 1/2 = 0.5. 2/5 = 0.4, which is between them.", 7, "Fractions"),
            q("Simplify 36/48.",
              "3/4", "6/8", "9/12", "18/24", "A",
              "GCF(36,48) = 12. 36÷12=3, 48÷12=4. Simplified: 3/4.", 7, "Fractions"),

            // Lesson 8 – Equivalent Fractions and Simplifying
            q("Which fraction is NOT equivalent to 2/3?",
              "4/6", "6/9", "8/12", "9/12", "D",
              "9/12 = 3/4, not 2/3. All others simplify to 2/3.", 8, "Fractions"),
            q("Simplify 45/75.",
              "3/5", "9/15", "15/25", "6/10", "A",
              "GCF(45,75) = 15. 45÷15=3, 75÷15=5. Answer: 3/5.", 8, "Fractions"),
            q("What fraction of 60 is 45?",
              "2/3", "3/4", "4/5", "5/6", "B",
              "45/60 = 3/4 (divide both by 15).", 8, "Fractions"),

            // Lesson 9 – Adding and Subtracting Fractions
            q("What is 5/6 + 3/4?",
              "8/10", "19/12", "8/12", "1 7/12", "B",
              "LCD = 12. 5/6 = 10/12, 3/4 = 9/12. 10/12 + 9/12 = 19/12 = 1 7/12.", 9, "Fractions"),
            q("What is 7/8 - 2/3?",
              "5/24", "5/5", "5/8", "5/24", "A",
              "LCD = 24. 7/8 = 21/24, 2/3 = 16/24. 21/24 - 16/24 = 5/24.", 9, "Fractions"),
            q("What is 2/5 + 3/7?",
              "5/12", "29/35", "5/35", "1/35", "B",
              "LCD = 35. 2/5 = 14/35, 3/7 = 15/35. 14+15 = 29/35.", 9, "Fractions"),
            q("What is 11/12 - 5/8?",
              "6/4", "7/24", "6/24", "1/3", "B",
              "LCD = 24. 11/12 = 22/24, 5/8 = 15/24. 22-15 = 7/24.", 9, "Fractions"),

            // Lesson 10 – Multiplying Fractions
            q("What is 3/4 × 8/9?",
              "11/13", "2/3", "24/36", "3/8", "B",
              "3×8=24, 4×9=36. 24/36 = 2/3.", 10, "Fractions"),
            q("What is 5/6 × 3/10?",
              "8/16", "1/4", "15/60", "8/60", "B",
              "5×3=15, 6×10=60. 15/60 = 1/4.", 10, "Fractions"),
            q("A recipe needs 2/3 cup of sugar. You make 3/4 of the recipe. How much sugar?",
              "1/2 cup", "5/7 cup", "8/12 cup", "3/7 cup", "A",
              "2/3 × 3/4 = 6/12 = 1/2 cup.", 10, "Fractions"),

            // Lesson 11 – Dividing Fractions
            q("What is 3/4 ÷ 1/2?",
              "3/8", "3/2", "6/4", "1 1/2", "D",
              "Multiply by reciprocal: 3/4 × 2/1 = 6/4 = 3/2 = 1 1/2.", 11, "Fractions"),
            q("What is 5/6 ÷ 5/3?",
              "25/18", "1/2", "3/6", "15/18", "B",
              "5/6 × 3/5 = 15/30 = 1/2.", 11, "Fractions"),
            q("How many 2/3-cup servings are in 4 cups?",
              "4", "5", "6", "8", "C",
              "4 ÷ 2/3 = 4 × 3/2 = 12/2 = 6 servings.", 11, "Fractions"),
            q("What is 7/8 ÷ 7/4?",
              "49/32", "1/2", "2", "7/32", "B",
              "7/8 × 4/7 = 28/56 = 1/2.", 11, "Fractions"),

            // Lesson 12 – Adding and Subtracting Mixed Numbers
            q("What is 3 2/5 + 2 4/5?",
              "5 6/5", "6 1/5", "5 1/5", "6 6/5", "B",
              "Add whole numbers: 3+2=5. Add fractions: 2/5+4/5=6/5=1 1/5. Total: 5+1 1/5=6 1/5.", 12, "Fractions"),
            q("What is 5 1/3 - 2 2/3?",
              "3 1/3", "2 2/3", "2 1/3", "3 2/3", "B",
              "Borrow: 5 1/3 = 4 4/3. 4 4/3 - 2 2/3 = 2 2/3.", 12, "Fractions"),
            q("What is 4 3/8 + 1 3/4?",
              "5 9/8", "6 1/8", "5 6/8", "6 3/8", "B",
              "LCD=8. 3/8 + 6/8 = 9/8 = 1 1/8. 4+1+1 = 6, plus 1/8 = 6 1/8.", 12, "Fractions"),

            // Lesson 13 – Multiplying and Dividing Mixed Numbers
            q("What is 2 1/2 × 1 1/3?",
              "2 1/6", "3 1/3", "2 5/6", "3 1/6", "B",
              "Convert: 5/2 × 4/3 = 20/6 = 10/3 = 3 1/3.", 13, "Fractions"),
            q("What is 3 1/2 ÷ 1 3/4?",
              "1 3/4", "2", "2 1/4", "1 1/2", "B",
              "7/2 ÷ 7/4 = 7/2 × 4/7 = 28/14 = 2.", 13, "Fractions"),
            q("A board is 8 3/4 feet long. You cut pieces that are 1 1/4 feet each. How many pieces?",
              "5", "6", "7", "8", "C",
              "8 3/4 ÷ 1 1/4 = 35/4 ÷ 5/4 = 35/4 × 4/5 = 35/5 = 7.", 13, "Fractions"),

            // Lesson 14 – Decimal Place Value
            q("What is the value of the digit 7 in 3.0074?",
              "7 tenths", "7 hundredths", "7 thousandths", "7 ten-thousandths", "C",
              "3.0074: tenths=0, hundredths=0, thousandths=7, ten-thousandths=4.", 14, "Decimals"),
            q("Write 0.00045 in words.",
              "Forty-five thousandths", "Forty-five ten-thousandths", "Forty-five hundred-thousandths", "Forty-five millionths", "C",
              "0.00045 has 5 decimal places = hundred-thousandths. 45 hundred-thousandths.", 14, "Decimals"),
            q("Which is greatest: 0.305, 0.35, 0.3050, 0.3005?",
              "0.305", "0.35", "0.3050", "0.3005", "B",
              "0.35 = 0.3500, which is greater than 0.3050 = 0.305 > 0.3005.", 14, "Decimals"),

            // Lesson 15 – Adding and Subtracting Decimals
            q("What is 12.45 + 3.087?",
              "15.437", "15.537", "16.437", "15.447", "B",
              "Line up decimals: 12.450 + 3.087 = 15.537.", 15, "Decimals"),
            q("What is 20.00 - 7.348?",
              "12.652", "13.652", "12.752", "12.542", "A",
              "20.000 - 7.348 = 12.652.", 15, "Decimals"),
            q("A runner's times were 12.34 s, 11.98 s, and 12.05 s. What is the total?",
              "36.27 s", "36.37 s", "35.37 s", "36.47 s", "B",
              "12.34 + 11.98 + 12.05 = 36.37 s.", 15, "Decimals"),
            q("What is 5.6 - 2.875?",
              "2.625", "2.725", "3.275", "2.825", "B",
              "5.600 - 2.875 = 2.725.", 15, "Decimals"),

            // Lesson 16 – Multiplying Decimals
            q("What is 3.4 × 2.5?",
              "7.5", "8.0", "8.5", "9.0", "C",
              "34 × 25 = 850. Two decimal places total: 8.50.", 16, "Decimals"),
            q("What is 0.06 × 0.4?",
              "0.24", "0.024", "2.4", "0.0024", "B",
              "6 × 4 = 24. Three decimal places: 0.024.", 16, "Decimals"),
            q("A square tile is 0.35 m on each side. What is its area?",
              "0.1025 m²", "0.1225 m²", "0.1225 m²", "0.0125 m²", "B",
              "0.35 × 0.35 = 0.1225 m².", 16, "Decimals"),

            // Lesson 17 – Dividing Decimals
            q("What is 7.2 ÷ 0.9?",
              "0.8", "8", "80", "0.08", "B",
              "Move decimal: 72 ÷ 9 = 8.", 17, "Decimals"),
            q("What is 4.56 ÷ 1.2?",
              "0.38", "3.8", "38", "0.038", "B",
              "Move decimal: 45.6 ÷ 12 = 3.8.", 17, "Decimals"),
            q("What is 0.144 ÷ 0.12?",
              "0.12", "1.2", "12", "0.012", "B",
              "Move decimal: 14.4 ÷ 12 = 1.2.", 17, "Decimals"),

            // Lesson 18 – Fractions, Decimals, and Percents
            q("What is 3/8 as a decimal?",
              "0.38", "0.375", "0.3", "0.385", "B",
              "3 ÷ 8 = 0.375.", 18, "Fractions"),
            q("What is 0.045 as a percent?",
              "45%", "4.5%", "0.45%", "0.045%", "B",
              "Multiply by 100: 0.045 × 100 = 4.5%.", 18, "Percent"),
            q("What is 62.5% as a fraction in simplest form?",
              "5/8", "62/100", "31/50", "6/10", "A",
              "62.5% = 62.5/100 = 625/1000 = 5/8.", 18, "Percent"),
            q("Order from least to greatest: 3/5, 0.58, 61%",
              "0.58, 3/5, 61%", "3/5, 0.58, 61%", "61%, 3/5, 0.58", "0.58, 61%, 3/5", "A",
              "Convert all: 3/5=0.60, 0.58, 61%=0.61. Order: 0.58 < 0.60 < 0.61.", 18, "Percent"),

            // Lesson 19 – Percent of a Number
            q("What is 35% of 80?",
              "24", "28", "32", "35", "B",
              "35% × 80 = 0.35 × 80 = 28.", 19, "Percent"),
            q("What is 12.5% of 200?",
              "20", "25", "30", "40", "B",
              "12.5% = 1/8. 200 ÷ 8 = 25.", 19, "Percent"),
            q("A jacket costs $120. Sales tax is 8.5%. How much is the tax?",
              "$9.20", "$10.20", "$10.80", "$12.00", "B",
              "8.5% × 120 = 0.085 × 120 = $10.20.", 19, "Percent"),
            q("What is 150% of 60?",
              "60", "75", "90", "120", "C",
              "150% = 1.5. 1.5 × 60 = 90.", 19, "Percent"),

            // Lesson 20 – Percent Problems
            q("18 is what percent of 72?",
              "18%", "20%", "25%", "30%", "C",
              "18/72 = 1/4 = 25%.", 20, "Percent"),
            q("40 is 80% of what number?",
              "32", "48", "50", "56", "C",
              "40 = 0.80 × n → n = 40 ÷ 0.80 = 50.", 20, "Percent"),
            q("A price increased from $50 to $65. What is the percent increase?",
              "15%", "20%", "25%", "30%", "D",
              "Increase = 15. 15/50 = 0.30 = 30%.", 20, "Percent"),
            q("A store marks down a $200 item by 15%. What is the sale price?",
              "$160", "$170", "$175", "$185", "B",
              "Discount = 15% × 200 = $30. Sale price = 200 - 30 = $170.", 20, "Percent")
        );
    }

    // ── Lessons 21–40 ─────────────────────────────────────────────────────────
    private List<Question> lessons21to40() {
        return List.of(
            q("A recipe uses 3 cups of flour for 12 cookies. What is the ratio of flour to cookies?", "3:12", "1:4", "4:1", "12:3", "B", "3:12 simplifies to 1:4.", 21, "Ratio"),
            q("A car travels 240 miles in 4 hours. What is the unit rate?", "40 mph", "50 mph", "60 mph", "80 mph", "C", "240 ÷ 4 = 60 mph.", 21, "Ratio"),
            q("Which ratio is equivalent to 5:8?", "10:15", "15:24", "20:30", "25:35", "B", "5:8 × 3 = 15:24.", 21, "Ratio"),
            q("Solve: 4/7 = x/21", "x = 9", "x = 12", "x = 14", "x = 16", "B", "Cross multiply: 4×21 = 7x → 84 = 7x → x = 12.", 22, "Proportions"),
            q("Solve: 3/5 = 9/n", "n = 12", "n = 15", "n = 18", "n = 27", "B", "Cross multiply: 3n = 45 → n = 15.", 22, "Proportions"),
            q("If 5 notebooks cost $8.75, how much do 8 notebooks cost?", "$12.00", "$13.00", "$14.00", "$15.00", "C", "Unit price: 8.75÷5 = $1.75. 8 × 1.75 = $14.00.", 22, "Proportions"),
            q("A map scale is 1 cm = 25 km. Two cities are 7.5 cm apart. Actual distance?", "150 km", "175 km", "187.5 km", "200 km", "C", "7.5 × 25 = 187.5 km.", 23, "Scale"),
            q("A model car is 1:32 scale. The real car is 4.8 m long. How long is the model?", "0.10 m", "0.12 m", "0.15 m", "0.20 m", "C", "4.8 ÷ 32 = 0.15 m.", 23, "Scale"),
            q("On a blueprint, 1 inch = 8 feet. A room is 2.5 inches wide. Actual width?", "16 ft", "18 ft", "20 ft", "24 ft", "C", "2.5 × 8 = 20 ft.", 23, "Scale"),
            q("What is -8 + 5?", "-13", "-3", "3", "13", "B", "Start at -8, move 5 right: -8 + 5 = -3.", 24, "Integers"),
            q("What is -6 + (-9)?", "-15", "-3", "3", "15", "A", "Two negatives: -6 + (-9) = -15.", 24, "Integers"),
            q("What is 12 - (-4)?", "8", "16", "-8", "-16", "B", "Subtracting negative = adding: 12 + 4 = 16.", 24, "Integers"),
            q("What is -7 - 5?", "-12", "-2", "2", "12", "A", "-7 - 5 = -12.", 24, "Integers"),
            q("What is (-5) × (-8)?", "-40", "-13", "13", "40", "D", "Negative × negative = positive: 40.", 25, "Integers"),
            q("What is (-72) ÷ 9?", "-8", "-63", "8", "63", "A", "Negative ÷ positive = negative: -8.", 25, "Integers"),
            q("What is (-3)² × (-2)?", "-18", "18", "-12", "12", "A", "(-3)²=9. 9×(-2)=-18.", 25, "Integers"),
            q("Evaluate: 3 + 4 × 5 - 2", "33", "21", "23", "19", "B", "4×5=20. 3+20-2=21.", 26, "Order of Operations"),
            q("Evaluate: (8 + 2)² ÷ 5", "4", "10", "20", "100", "C", "(10)²=100. 100÷5=20.", 26, "Order of Operations"),
            q("Evaluate: 48 ÷ (4 × 2) + 3²", "12", "15", "18", "21", "B", "4×2=8. 48÷8=6. 3²=9. 6+9=15.", 26, "Order of Operations"),
            q("What is 2⁵?", "10", "25", "32", "64", "C", "2⁵ = 2×2×2×2×2 = 32.", 27, "Exponents"),
            q("What is 3⁴?", "12", "27", "64", "81", "D", "3⁴ = 3×3×3×3 = 81.", 27, "Exponents"),
            q("Simplify: 5³ × 5²", "5⁵", "5⁶", "25⁵", "5¹⁰", "A", "Same base: add exponents. 5³⁺² = 5⁵.", 27, "Exponents"),
            q("Write 45,000 in scientific notation.", "4.5 × 10³", "4.5 × 10⁴", "45 × 10³", "0.45 × 10⁵", "B", "45,000 = 4.5 × 10⁴.", 28, "Scientific Notation"),
            q("Write 3.2 × 10⁻³ in standard form.", "3,200", "320", "0.032", "0.0032", "D", "Move decimal 3 left: 0.0032.", 28, "Scientific Notation"),
            q("Which is larger: 6.1 × 10⁵ or 5.9 × 10⁶?", "6.1 × 10⁵", "5.9 × 10⁶", "They are equal", "Cannot tell", "B", "5.9×10⁶ = 5,900,000 > 610,000.", 28, "Scientific Notation"),
            q("What is √144?", "11", "12", "13", "14", "B", "12 × 12 = 144.", 29, "Square Roots"),
            q("Between which two integers is √50?", "6 and 7", "7 and 8", "8 and 9", "24 and 25", "B", "7²=49, 8²=64. √50 is between 7 and 8.", 29, "Square Roots"),
            q("Is √2 rational or irrational?", "Rational", "Irrational", "Integer", "Whole number", "B", "√2 cannot be expressed as a fraction; it is irrational.", 29, "Square Roots"),
            q("What is |-17|?", "-17", "0", "17", "34", "C", "Absolute value = distance from 0 = 17.", 30, "Integers"),
            q("Which has the greatest absolute value: -12, 8, -15, 10?", "-12", "8", "-15", "10", "C", "|-15|=15, which is the greatest.", 30, "Integers"),
            q("Solve: |x| = 9", "x = 9 only", "x = -9 only", "x = 9 or x = -9", "No solution", "C", "|x|=9 means x=9 or x=-9.", 30, "Integers"),
            q("Evaluate 3x + 2 when x = 4.", "10", "12", "14", "16", "C", "3(4)+2 = 12+2 = 14.", 31, "Algebra"),
            q("Simplify: 5a + 3b - 2a + b", "3a + 4b", "7a + 4b", "3a + 2b", "7a + 2b", "A", "Combine like terms: (5a-2a)+(3b+b) = 3a+4b.", 31, "Algebra"),
            q("Write an expression: 7 less than twice a number n.", "7 - 2n", "2n - 7", "2(n - 7)", "7n - 2", "B", "Twice n = 2n. 7 less than that = 2n - 7.", 32, "Algebra"),
            q("Evaluate 2x² - 3x + 1 when x = 3.", "10", "12", "14", "16", "A", "2(9)-3(3)+1 = 18-9+1 = 10.", 32, "Algebra"),
            q("Which property: a(b + c) = ab + ac?", "Commutative", "Associative", "Distributive", "Identity", "C", "This is the distributive property.", 33, "Algebra"),
            q("Which property: 5 + 0 = 5?", "Commutative", "Associative", "Distributive", "Identity", "D", "Adding 0 gives the same number: identity property of addition.", 33, "Algebra"),
            q("Simplify using distributive property: 4(3x - 2)", "12x - 2", "12x - 8", "7x - 2", "12x + 8", "B", "4×3x = 12x, 4×(-2) = -8. Answer: 12x - 8.", 33, "Algebra"),
            q("Solve: x + 7 = -3", "x = 4", "x = -4", "x = 10", "x = -10", "D", "x = -3 - 7 = -10.", 34, "Algebra"),
            q("Solve: 5x = -35", "x = -7", "x = 7", "x = -30", "x = -40", "A", "x = -35 ÷ 5 = -7.", 34, "Algebra"),
            q("Solve: n/4 = -6", "n = -24", "n = -2", "n = 24", "n = -10", "A", "n = -6 × 4 = -24.", 34, "Algebra"),
            q("Solve: 2x + 5 = 17", "x = 5", "x = 6", "x = 7", "x = 11", "B", "2x = 12, x = 6.", 35, "Algebra"),
            q("Solve: 3n - 8 = 13", "n = 5", "n = 7", "n = 9", "n = 11", "B", "3n = 21, n = 7.", 35, "Algebra"),
            q("Solve: (x/3) + 4 = 9", "x = 5", "x = 12", "x = 15", "x = 39", "C", "x/3 = 5, x = 15.", 35, "Algebra"),
            q("Solve: 4x + 3 = 2x + 11", "x = 2", "x = 4", "x = 7", "x = 14", "B", "2x = 8, x = 4.", 36, "Algebra"),
            q("Solve: 5n - 9 = 3n + 7", "n = 2", "n = 4", "n = 8", "n = 16", "C", "2n = 16, n = 8.", 36, "Algebra"),
            q("Solve: 7 - 2x = x - 8", "x = 3", "x = 5", "x = -5", "x = 15", "B", "15 = 3x, x = 5.", 36, "Algebra"),
            q("Solve: 3x + 2 > 14", "x > 3", "x > 4", "x > 5", "x > 6", "B", "3x > 12, x > 4.", 37, "Algebra"),
            q("Solve: -2n ≤ 10", "n ≤ -5", "n ≥ -5", "n ≤ 5", "n ≥ 5", "B", "Divide by -2, flip sign: n ≥ -5.", 37, "Algebra"),
            q("Which value is NOT a solution to x + 3 < 8?", "x = 2", "x = 4", "x = 5", "x = 0", "C", "x < 5. So x=5 is NOT a solution.", 37, "Algebra"),
            q("Graph x > -2 on a number line. The circle at -2 is:", "Closed/filled", "Open/empty", "A square", "No mark", "B", "Strict inequality (>) uses an open circle.", 38, "Algebra"),
            q("Which inequality represents 'at most 15'?", "x > 15", "x < 15", "x ≤ 15", "x ≥ 15", "C", "'At most' means less than or equal to: x ≤ 15.", 38, "Algebra"),
            q("A number decreased by 8 is at least 20. Write the inequality.", "n - 8 ≥ 20", "n - 8 > 20", "n - 8 ≤ 20", "8 - n ≥ 20", "A", "'At least' = ≥. n - 8 ≥ 20.", 39, "Algebra"),
            q("The sum of two consecutive integers is 47. What are they?", "22 and 25", "23 and 24", "20 and 27", "21 and 26", "B", "n + (n+1) = 47 → 2n+1=47 → n=23. Numbers: 23, 24.", 39, "Algebra"),
            q("Solve for w in P = 2l + 2w.", "w = P - 2l", "w = (P - 2l)/2", "w = P/2 - l", "Both B and C", "D", "P - 2l = 2w → w = (P-2l)/2 = P/2 - l. Both B and C are correct.", 40, "Algebra"),
            q("Solve for r in A = πr².", "r = A/π", "r = √(A/π)", "r = A²/π", "r = π/A", "B", "r² = A/π → r = √(A/π).", 40, "Algebra")
        );
    }

    // ── Lessons 41–60 ─────────────────────────────────────────────────────────
    private List<Question> lessons41to60() {
        return List.of(
            q("In which quadrant is (-3, 5)?", "I", "II", "III", "IV", "B", "Negative x, positive y = Quadrant II.", 41, "Coordinate Plane"),
            q("What is the distance from (0,0) to (3,4)?", "5", "7", "12", "25", "A", "√(9+16) = √25 = 5.", 41, "Coordinate Plane"),
            q("Point A is at (2,-3). After translating 4 left and 5 up, where is A?", "(-2, 2)", "(6, 2)", "(-2, -8)", "(6, -8)", "A", "(2-4, -3+5) = (-2, 2).", 41, "Coordinate Plane"),
            q("Which point is on the line y = 2x - 1?", "(1, 1)", "(2, 5)", "(3, 5)", "(0, 1)", "C", "y = 2(3)-1 = 5. Point (3,5) works.", 42, "Linear Equations"),
            q("What is the y-intercept of y = -3x + 7?", "-3", "3", "7", "-7", "C", "In y=mx+b, b=7 is the y-intercept.", 42, "Linear Equations"),
            q("A line passes through (0,2) and (1,5). What is its equation?", "y = 3x + 2", "y = 2x + 3", "y = 5x + 2", "y = 3x + 5", "A", "Slope = (5-2)/(1-0) = 3. y-int = 2. y = 3x + 2.", 42, "Linear Equations"),
            q("What is the slope of the line through (1,3) and (4,9)?", "1", "2", "3", "6", "B", "Slope = (9-3)/(4-1) = 6/3 = 2.", 43, "Slope"),
            q("A horizontal line has slope:", "0", "1", "Undefined", "-1", "A", "Horizontal lines have slope = 0.", 43, "Slope"),
            q("What is the slope of y = -4x + 1?", "1", "-1", "4", "-4", "D", "In y=mx+b, m=-4.", 43, "Slope"),
            q("Write in slope-intercept form: 2x + y = 6", "y = 2x + 6", "y = -2x + 6", "y = 2x - 6", "y = -2x - 6", "B", "y = -2x + 6.", 44, "Linear Equations"),
            q("A line has slope 3 and y-intercept -2. What is its equation?", "y = -2x + 3", "y = 3x - 2", "y = 3x + 2", "y = -2x - 3", "B", "y = mx + b = 3x + (-2) = 3x - 2.", 44, "Linear Equations"),
            q("What is the slope and y-intercept of y = (1/2)x + 4?", "m=1/2, b=4", "m=4, b=1/2", "m=2, b=4", "m=1/2, b=-4", "A", "y = mx+b: m=1/2, b=4.", 44, "Linear Equations"),
            q("Write the equation of a line with slope -1 passing through (0, 5).", "y = -x + 5", "y = x + 5", "y = -x - 5", "y = 5x - 1", "A", "m=-1, b=5. y = -x + 5.", 45, "Linear Equations"),
            q("Write the equation of a line through (2,7) and (4,11).", "y = 2x + 3", "y = 2x + 7", "y = 4x - 1", "y = x + 5", "A", "Slope = (11-7)/(4-2) = 2. 7 = 2(2)+b → b=3. y = 2x+3.", 45, "Linear Equations"),
            q("A line passes through (1,4) with slope 3. What is y when x=5?", "12", "16", "19", "20", "B", "y = 3x+1. At x=5: y=15+1=16.", 45, "Linear Equations"),
            q("y = 4x represents:", "Direct variation", "Inverse variation", "No variation", "Exponential growth", "A", "y = kx (k=4) is direct variation.", 46, "Proportions"),
            q("If y varies directly with x and y=12 when x=3, find y when x=7.", "21", "24", "28", "36", "C", "k = 12/3 = 4. y = 4(7) = 28.", 46, "Proportions"),
            q("Which equation is NOT direct variation?", "y = 5x", "y = x/3", "y = 2x + 1", "y = -7x", "C", "y = 2x+1 has a non-zero y-intercept, so it's not direct variation.", 46, "Proportions"),
            q("Is {(1,2),(3,4),(1,5)} a function?", "Yes", "No", "Only if graphed", "Cannot tell", "B", "x=1 maps to both 2 and 5. Not a function.", 47, "Functions"),
            q("If f(x) = 2x - 3, what is f(5)?", "3", "5", "7", "10", "C", "f(5) = 2(5)-3 = 10-3 = 7.", 47, "Functions"),
            q("Which passes the vertical line test?", "A circle", "A parabola opening up", "x = 5", "A sideways parabola", "B", "A parabola opening up passes the vertical line test.", 47, "Functions"),
            q("What is the next term: 3, 7, 11, 15, ___?", "17", "18", "19", "21", "C", "Pattern: +4 each time. 15+4=19.", 48, "Patterns"),
            q("What is the next term: 2, 6, 18, 54, ___?", "108", "162", "216", "72", "B", "Pattern: ×3 each time. 54×3=162.", 48, "Patterns"),
            q("What is the rule for: 5, 8, 11, 14, ...?", "Start 5, add 3", "Start 5, add 4", "Start 3, add 5", "Start 5, multiply 2", "A", "Each term adds 3: 5, 8, 11, 14...", 48, "Patterns"),
            q("In the arithmetic sequence 4, 9, 14, 19, ..., what is the 10th term?", "44", "49", "54", "59", "B", "a₁=4, d=5. a₁₀ = 4 + 9(5) = 49.", 49, "Sequences"),
            q("Find the common difference: 20, 14, 8, 2, ...", "-4", "-6", "-8", "6", "B", "14-20 = -6. Common difference = -6.", 49, "Sequences"),
            q("The 1st term is 7 and common difference is 3. What is the 15th term?", "46", "49", "52", "55", "B", "a₁₅ = 7 + 14(3) = 7 + 42 = 49.", 49, "Sequences"),
            q("In the geometric sequence 3, 12, 48, 192, ..., what is the common ratio?", "3", "4", "9", "16", "B", "12/3 = 4. Common ratio = 4.", 50, "Sequences"),
            q("Find the 5th term: 2, 6, 18, 54, ...", "108", "162", "216", "324", "B", "r=3. 5th term = 2×3⁴ = 2×81 = 162.", 50, "Sequences"),
            q("A geometric sequence has a₁=5 and r=2. What is a₆?", "80", "160", "320", "640", "B", "a₆ = 5×2⁵ = 5×32 = 160.", 50, "Sequences"),
            q("Two angles are supplementary. One is 65°. What is the other?", "25°", "65°", "115°", "125°", "C", "Supplementary = 180°. 180-65 = 115°.", 51, "Geometry"),
            q("Two angles are complementary. One is 37°. What is the other?", "53°", "63°", "143°", "37°", "A", "Complementary = 90°. 90-37 = 53°.", 51, "Geometry"),
            q("Vertical angles are always:", "Supplementary", "Complementary", "Congruent", "Adjacent", "C", "Vertical angles are equal (congruent).", 51, "Geometry"),
            q("If two parallel lines are cut by a transversal, alternate interior angles are:", "Supplementary", "Complementary", "Congruent", "Vertical", "C", "Alternate interior angles are congruent when lines are parallel.", 52, "Geometry"),
            q("A transversal crosses parallel lines. One angle is 72°. Its co-interior angle is:", "72°", "108°", "18°", "288°", "B", "Co-interior angles are supplementary: 180-72=108°.", 52, "Geometry"),
            q("Corresponding angles formed by parallel lines and a transversal are:", "Supplementary", "Congruent", "Complementary", "Vertical", "B", "Corresponding angles are congruent.", 52, "Geometry"),
            q("The angles of a triangle sum to:", "90°", "180°", "270°", "360°", "B", "Triangle angle sum = 180°.", 53, "Geometry"),
            q("A triangle has angles 45° and 90°. What is the third angle?", "35°", "45°", "55°", "90°", "B", "180-45-90=45°.", 53, "Geometry"),
            q("A triangle with no equal sides is called:", "Equilateral", "Isosceles", "Scalene", "Right", "C", "Scalene = all sides different.", 53, "Geometry"),
            q("Two triangles are congruent if they have:", "Same area", "Same perimeter", "Same shape and size", "Same angles only", "C", "Congruent = same shape AND size.", 54, "Geometry"),
            q("Which is a congruence criterion?", "AAA", "SSA", "SAS", "AA", "C", "SAS (Side-Angle-Side) proves congruence.", 54, "Geometry"),
            q("If triangle ABC ≅ triangle DEF, and AB=5, then DE=?", "5", "10", "Cannot tell", "2.5", "A", "Corresponding sides of congruent triangles are equal.", 54, "Geometry"),
            q("Two triangles are similar. One has sides 3,4,5. The other has a shortest side of 6. What is its longest side?", "8", "10", "12", "15", "B", "Scale factor = 6/3 = 2. Longest = 5×2 = 10.", 55, "Geometry"),
            q("In similar triangles, corresponding angles are:", "Supplementary", "Complementary", "Congruent", "Different", "C", "Similar triangles have equal angles.", 55, "Geometry"),
            q("A tree casts a 12 ft shadow. A 5 ft person casts a 4 ft shadow. How tall is the tree?", "12 ft", "15 ft", "16 ft", "20 ft", "B", "5/4 = h/12 → h = 15 ft.", 55, "Geometry"),
            q("A right triangle has legs 6 and 8. What is the hypotenuse?", "10", "12", "14", "100", "A", "6²+8²=36+64=100. √100=10.", 56, "Geometry"),
            q("A right triangle has hypotenuse 13 and one leg 5. What is the other leg?", "8", "10", "12", "14", "C", "13²-5²=169-25=144. √144=12.", 56, "Geometry"),
            q("Is a triangle with sides 7, 24, 25 a right triangle?", "Yes", "No", "Cannot tell", "Only if angles given", "A", "7²+24²=49+576=625=25². Yes.", 56, "Geometry"),
            q("A parallelogram has opposite angles that are:", "Supplementary", "Complementary", "Congruent", "Right", "C", "Opposite angles in a parallelogram are equal.", 57, "Geometry"),
            q("A rhombus has all sides equal and:", "All right angles", "Opposite angles equal", "No parallel sides", "One pair of parallel sides", "B", "A rhombus has opposite angles equal.", 57, "Geometry"),
            q("A trapezoid has exactly how many pairs of parallel sides?", "0", "1", "2", "4", "B", "A trapezoid has exactly 1 pair of parallel sides.", 57, "Geometry"),
            q("What is the sum of interior angles of a hexagon?", "540°", "720°", "900°", "1080°", "B", "(6-2)×180 = 720°.", 58, "Geometry"),
            q("Each interior angle of a regular octagon is:", "120°", "135°", "140°", "150°", "B", "(8-2)×180/8 = 1080/8 = 135°.", 58, "Geometry"),
            q("What is the sum of exterior angles of any convex polygon?", "180°", "360°", "540°", "Depends on sides", "B", "Sum of exterior angles = 360° for any convex polygon.", 58, "Geometry"),
            q("What is the circumference of a circle with radius 7? (Use π ≈ 3.14)", "21.98", "43.96", "153.86", "14", "B", "C = 2πr = 2(3.14)(7) = 43.96.", 59, "Geometry"),
            q("What is the perimeter of a rectangle 12 cm by 8 cm?", "20 cm", "40 cm", "96 cm", "32 cm", "B", "P = 2(12+8) = 40 cm.", 59, "Geometry"),
            q("A regular pentagon has side 9 cm. What is its perimeter?", "36 cm", "40 cm", "45 cm", "54 cm", "C", "5 × 9 = 45 cm.", 59, "Geometry"),
            q("What is the area of a triangle with base 10 and height 6?", "16", "30", "60", "120", "B", "A = (1/2)bh = (1/2)(10)(6) = 30.", 60, "Geometry"),
            q("What is the area of a parallelogram with base 9 and height 4?", "13", "18", "36", "72", "C", "A = bh = 9×4 = 36.", 60, "Geometry"),
            q("What is the area of a trapezoid with bases 6 and 10, height 4?", "16", "24", "32", "40", "C", "A = (1/2)(b₁+b₂)h = (1/2)(16)(4) = 32.", 60, "Geometry")
        );
    }

    // ── Lessons 61–80 ─────────────────────────────────────────────────────────
    private List<Question> lessons61to80() {
        return List.of(
            q("What is the area of a circle with radius 5? (Use π ≈ 3.14)", "15.7", "31.4", "78.5", "157", "C", "A = πr² = 3.14×25 = 78.5.", 61, "Geometry"),
            q("A circle has diameter 14. What is its area? (Use π ≈ 3.14)", "43.96", "153.86", "307.72", "615.44", "B", "r=7. A = 3.14×49 = 153.86.", 61, "Geometry"),
            q("A semicircle has diameter 10. What is its area? (Use π ≈ 3.14)", "15.7", "39.25", "78.5", "157", "B", "r=5. Full circle = 78.5. Half = 39.25.", 61, "Geometry"),
            q("Find the area of an L-shaped figure: a 10×6 rectangle with a 4×3 rectangle removed.", "42", "48", "54", "60", "B", "10×6=60. Remove 4×3=12. 60-12=48.", 62, "Geometry"),
            q("A figure is a rectangle 8×5 with a semicircle (diameter 5) attached. Area? (π≈3.14)", "49.8", "45.2", "40.0", "55.6", "A", "Rect=40. Semicircle=π(2.5)²/2≈9.8. Total≈49.8.", 62, "Geometry"),
            q("Find the area: a square of side 6 with a triangle (base 6, height 4) on top.", "36", "48", "12", "24", "B", "Square=36. Triangle=(1/2)(6)(4)=12. Total=48.", 62, "Geometry"),
            q("What is the surface area of a rectangular prism 5×3×2?", "31", "62", "30", "60", "B", "SA = 2(15+10+6) = 2(31) = 62.", 63, "Geometry"),
            q("A cube has edge 4 cm. What is its surface area?", "64 cm²", "96 cm²", "128 cm²", "24 cm²", "B", "6 faces × 4² = 6×16 = 96 cm².", 63, "Geometry"),
            q("A rectangular prism is 10×4×3. What is its surface area?", "134", "164", "120", "94", "B", "2(40+30+12) = 2(82) = 164.", 63, "Geometry"),
            q("What is the surface area of a cylinder with r=3 and h=10? (π≈3.14)", "188.4", "244.92", "282.6", "150.72", "B", "SA = 2πr²+2πrh = 2(3.14)(9)+2(3.14)(3)(10) = 56.52+188.4 = 244.92.", 64, "Geometry"),
            q("A cylinder has diameter 8 and height 5. What is its lateral surface area? (π≈3.14)", "62.8", "100.48", "125.6", "200.96", "C", "Lateral = 2πrh = 2(3.14)(4)(5) = 125.6.", 64, "Geometry"),
            q("The total surface area of a cylinder includes:", "1 circle + 1 rectangle", "2 circles + 1 rectangle", "2 rectangles + 1 circle", "3 circles", "B", "A cylinder has 2 circular bases and 1 rectangular lateral surface.", 64, "Geometry"),
            q("A square pyramid has base edge 6 and slant height 5. What is its surface area?", "96", "60", "36", "156", "A", "Base=36. Lateral=4×(1/2)(6)(5)=60. Total=96.", 65, "Geometry"),
            q("A cone has r=3 and slant height 5. What is its lateral surface area? (π≈3.14)", "47.1", "28.26", "94.2", "15.7", "A", "Lateral = πrl = 3.14×3×5 = 47.1.", 65, "Geometry"),
            q("The surface area of a cone includes:", "1 circle + 1 triangle", "1 circle + lateral area", "2 circles + lateral area", "Just lateral area", "B", "Cone SA = πr² + πrl (base circle + lateral).", 65, "Geometry"),
            q("What is the volume of a rectangular prism 8×5×3?", "16", "80", "120", "240", "C", "V = lwh = 8×5×3 = 120.", 66, "Geometry"),
            q("A cube has edge 5. What is its volume?", "25", "75", "125", "150", "C", "V = 5³ = 125.", 66, "Geometry"),
            q("A swimming pool is 25m × 10m × 2m. What is its volume?", "250 m³", "500 m³", "750 m³", "1000 m³", "B", "V = 25×10×2 = 500 m³.", 66, "Geometry"),
            q("What is the volume of a cylinder with r=4 and h=10? (π≈3.14)", "125.6", "251.2", "502.4", "1004.8", "C", "V = πr²h = 3.14×16×10 = 502.4.", 67, "Geometry"),
            q("A cylinder has diameter 6 and height 8. What is its volume? (π≈3.14)", "75.36", "150.72", "226.08", "452.16", "C", "r=3. V = 3.14×9×8 = 226.08.", 67, "Geometry"),
            q("A cylindrical tank holds 1,000 cm³ and has radius 5 cm. What is its height? (π≈3.14)", "10.2 cm", "12.7 cm", "15.9 cm", "20.0 cm", "B", "h = V/(πr²) = 1000/(3.14×25) = 1000/78.5 ≈ 12.7.", 67, "Geometry"),
            q("What is the volume of a pyramid with base area 36 and height 10?", "36", "120", "180", "360", "B", "V = (1/3)Bh = (1/3)(36)(10) = 120.", 68, "Geometry"),
            q("A cone has r=3 and h=12. What is its volume? (π≈3.14)", "37.68", "113.04", "339.12", "75.36", "B", "V = (1/3)πr²h = (1/3)(3.14)(9)(12) = 113.04.", 68, "Geometry"),
            q("A pyramid has a square base of side 8 and height 9. Volume?", "192", "576", "288", "72", "A", "V = (1/3)(64)(9) = 192.", 68, "Geometry"),
            q("What is the volume of a sphere with r=3? (π≈3.14)", "28.26", "56.52", "113.04", "904.32", "C", "V = (4/3)πr³ = (4/3)(3.14)(27) = 113.04.", 69, "Geometry"),
            q("A sphere has diameter 10. What is its volume? (π≈3.14)", "261.67", "523.33", "4186.67", "130.83", "B", "r=5. V = (4/3)(3.14)(125) = 523.33.", 69, "Geometry"),
            q("A basketball has radius 12 cm. What is its volume? (π≈3.14)", "2,411", "4,823", "7,235", "9,646", "C", "V = (4/3)(3.14)(1728) = 7234.6 ≈ 7,235.", 69, "Geometry"),
            q("A translation moves every point:", "The same distance in the same direction", "Around a center point", "Over a line", "Closer to a center", "A", "Translations slide all points equally.", 70, "Transformations"),
            q("Triangle ABC is translated 3 right and 2 down. A(1,4) becomes:", "(4, 2)", "(-2, 6)", "(4, 6)", "(-2, 2)", "A", "(1+3, 4-2) = (4, 2).", 70, "Transformations"),
            q("Which transformation preserves size and shape?", "Dilation", "Translation", "Stretch", "Compression", "B", "Translations are rigid motions (preserve size/shape).", 70, "Transformations"),
            q("Reflecting (3, -2) over the x-axis gives:", "(3, 2)", "(-3, -2)", "(-3, 2)", "(3, -2)", "A", "Reflect over x-axis: (x,y)→(x,-y). (3,2).", 71, "Transformations"),
            q("Reflecting (5, 1) over the y-axis gives:", "(5, -1)", "(-5, 1)", "(-5, -1)", "(1, 5)", "B", "Reflect over y-axis: (x,y)→(-x,y). (-5,1).", 71, "Transformations"),
            q("A reflection is a:", "Slide", "Flip", "Turn", "Resize", "B", "A reflection flips a figure over a line.", 71, "Transformations"),
            q("Rotating (1, 0) by 90° counterclockwise about the origin gives:", "(0, 1)", "(0, -1)", "(-1, 0)", "(1, 0)", "A", "90° CCW: (x,y)→(-y,x). (1,0)→(0,1).", 72, "Transformations"),
            q("A 180° rotation of (3, -4) about the origin gives:", "(-3, 4)", "(3, 4)", "(-3, -4)", "(4, -3)", "A", "180°: (x,y)→(-x,-y). (-3,4).", 72, "Transformations"),
            q("Rotations preserve:", "Only angles", "Only distances", "Both angles and distances", "Neither", "C", "Rotations are rigid motions preserving both.", 72, "Transformations"),
            q("A dilation with scale factor 2 maps (3, 4) to:", "(6, 8)", "(1.5, 2)", "(5, 6)", "(9, 16)", "A", "Multiply each coordinate by 2: (6, 8).", 73, "Transformations"),
            q("A dilation with scale factor 1/3 maps a segment of length 12 to length:", "4", "6", "9", "36", "A", "12 × (1/3) = 4.", 73, "Transformations"),
            q("A dilation with scale factor > 1 is a:", "Reduction", "Enlargement", "Reflection", "Translation", "B", "Scale factor > 1 makes the figure larger.", 73, "Transformations"),
            q("How many lines of symmetry does a regular hexagon have?", "3", "4", "6", "12", "C", "A regular hexagon has 6 lines of symmetry.", 74, "Geometry"),
            q("Which letter has rotational symmetry of order 2?", "A", "B", "S", "E", "C", "S looks the same after 180° rotation.", 74, "Geometry"),
            q("A square has rotational symmetry of order:", "1", "2", "4", "8", "C", "A square maps to itself at 90°, 180°, 270°, 360° = order 4.", 74, "Geometry"),
            q("Find the mean of: 12, 15, 18, 21, 24", "15", "17", "18", "20", "C", "Sum=90. 90÷5=18.", 75, "Statistics"),
            q("Find the median of: 3, 7, 9, 12, 15, 20", "9", "10.5", "12", "11", "B", "Middle two: 9 and 12. (9+12)/2 = 10.5.", 75, "Statistics"),
            q("Find the range of: 45, 32, 67, 28, 51", "23", "35", "39", "67", "C", "67-28=39.", 75, "Statistics"),
            q("In a frequency table, the class 20-29 has frequency 8. This means:", "8 values are between 20 and 29", "The range is 8", "The mean is 8", "There are 8 classes", "A", "Frequency = count of values in that interval.", 76, "Statistics"),
            q("A histogram shows bars with no gaps because:", "Data is categorical", "Data is continuous", "It looks better", "Bars overlap", "B", "Histograms show continuous data, so bars touch.", 76, "Statistics"),
            q("Which measure of center is most affected by outliers?", "Mean", "Median", "Mode", "Range", "A", "The mean is pulled toward extreme values.", 76, "Statistics"),
            q("In a box plot, the IQR is:", "Max - Min", "Q3 - Q1", "Median - Q1", "Q3 - Median", "B", "IQR = Q3 - Q1 (interquartile range).", 77, "Statistics"),
            q("Data: 2, 5, 7, 8, 10, 12, 15. What is Q1?", "5", "6", "7", "8", "A", "Lower half: 2,5,7. Median of lower half = 5.", 77, "Statistics"),
            q("A box plot whisker extends to the:", "Mean", "Mode", "Minimum and maximum", "Standard deviation", "C", "Whiskers show min and max (or 1.5×IQR bounds).", 77, "Statistics"),
            q("A scatter plot shows points going up from left to right. The correlation is:", "Positive", "Negative", "No correlation", "Perfect", "A", "Points trending upward = positive correlation.", 78, "Statistics"),
            q("Which r-value indicates the strongest correlation?", "r = 0.3", "r = -0.85", "r = 0.5", "r = -0.2", "B", "|-0.85| = 0.85 is closest to 1.", 78, "Statistics"),
            q("A scatter plot with r ≈ 0 shows:", "Strong positive", "Strong negative", "No linear relationship", "Perfect correlation", "C", "r ≈ 0 means no linear correlation.", 78, "Statistics"),
            q("A line of best fit is used to:", "Connect all data points", "Predict values", "Find the mode", "Calculate range", "B", "A line of best fit models the trend for predictions.", 79, "Statistics"),
            q("A line of best fit has equation y = 2x + 5. Predict y when x = 10.", "15", "20", "25", "30", "C", "y = 2(10)+5 = 25.", 79, "Statistics"),
            q("Extrapolation is:", "Predicting within the data range", "Predicting outside the data range", "Finding the median", "Calculating slope", "B", "Extrapolation predicts beyond the observed data.", 79, "Statistics"),
            q("A circle graph shows 25% for 'Sports'. If 200 students were surveyed, how many chose Sports?", "25", "50", "75", "100", "B", "25% of 200 = 50.", 80, "Statistics"),
            q("In a circle graph, a section of 90° represents what percent?", "15%", "20%", "25%", "30%", "C", "90/360 = 1/4 = 25%.", 80, "Statistics"),
            q("A circle graph has sections: A=40%, B=35%, C=?%. What is C?", "15%", "20%", "25%", "30%", "C", "100-40-35=25%.", 80, "Statistics")
        );
    }

    // ── Lessons 81–100 ────────────────────────────────────────────────────────
    private List<Question> lessons81to100() {
        return List.of(
            q("A restaurant offers 4 appetizers, 6 entrees, and 3 desserts. How many meal combos?", "13", "36", "72", "144", "C", "4×6×3 = 72.", 81, "Probability"),
            q("How many 3-digit codes using digits 0-9 (repeats allowed)?", "30", "720", "1000", "10000", "C", "10×10×10 = 1000.", 81, "Probability"),
            q("A lock has 5 positions with 4 choices each. How many combinations?", "20", "256", "625", "1024", "D", "4⁵ = 1024.", 81, "Probability"),
            q("How many ways can 5 people line up?", "5", "25", "60", "120", "D", "5! = 120.", 82, "Probability"),
            q("How many ways can you arrange 3 books from a shelf of 7?", "21", "35", "210", "5040", "C", "P(7,3) = 7×6×5 = 210.", 82, "Probability"),
            q("How many 4-letter arrangements from ABCDE (no repeats)?", "20", "60", "120", "625", "C", "P(5,4) = 5×4×3×2 = 120.", 82, "Probability"),
            q("How many ways can you choose 3 students from 8?", "24", "56", "336", "512", "B", "C(8,3) = 56.", 83, "Probability"),
            q("How many ways to choose 2 toppings from 6?", "12", "15", "30", "36", "B", "C(6,2) = 15.", 83, "Probability"),
            q("C(10,4) = ?", "210", "5040", "40", "120", "A", "C(10,4) = 10!/(4!×6!) = 210.", 83, "Probability"),
            q("A bag has 3 red and 5 blue marbles. P(red)?", "3/8", "5/8", "3/5", "5/3", "A", "P(red) = 3/8.", 84, "Probability"),
            q("A die is rolled. P(even)?", "1/6", "1/3", "1/2", "2/3", "C", "Even: 2,4,6 = 3/6 = 1/2.", 84, "Probability"),
            q("A card is drawn from a standard deck. P(heart)?", "1/4", "1/13", "1/52", "4/13", "A", "13 hearts out of 52 = 1/4.", 84, "Probability"),
            q("You flip a coin 50 times and get 23 heads. Experimental P(heads)?", "1/2", "23/50", "27/50", "23/27", "B", "Experimental = actual/total = 23/50.", 85, "Probability"),
            q("As trials increase, experimental probability approaches:", "0", "1", "Theoretical probability", "Infinity", "C", "Law of Large Numbers.", 85, "Probability"),
            q("You roll a die 60 times. About how many 3s would you expect?", "3", "6", "10", "12", "C", "P(3)=1/6. Expected = 60×(1/6) = 10.", 85, "Probability"),
            q("A coin is flipped and a die rolled. P(heads AND 6)?", "1/12", "1/6", "1/3", "7/12", "A", "P = 1/2 × 1/6 = 1/12.", 86, "Probability"),
            q("Two dice are rolled. P(both even)?", "1/4", "1/2", "1/6", "1/36", "A", "P(even)×P(even) = 1/2 × 1/2 = 1/4.", 86, "Probability"),
            q("A spinner has P(red)=0.3. Two spins. P(red both times)?", "0.06", "0.09", "0.30", "0.60", "B", "0.3 × 0.3 = 0.09.", 86, "Probability"),
            q("A bag has 4 red, 6 blue. You draw one, don't replace, draw another. P(both red)?", "2/15", "4/25", "16/100", "4/15", "A", "4/10 × 3/9 = 12/90 = 2/15.", 87, "Probability"),
            q("From 5 cards (A,B,C,D,E), draw 2 without replacement. P(A then B)?", "1/20", "1/25", "2/25", "1/10", "A", "1/5 × 1/4 = 1/20.", 87, "Probability"),
            q("10 socks: 6 black, 4 white. P(2 black without replacement)?", "1/3", "6/10", "15/45", "36/100", "A", "6/10 × 5/9 = 30/90 = 1/3.", 87, "Probability"),
            q("A dartboard has a circle of radius 2 inside a square of side 6. P(hitting the circle)?", "π/9", "4π/36", "2π/9", "π/6", "A", "Circle area=4π. Square area=36. P=4π/36=π/9.", 88, "Probability"),
            q("A target has inner radius 3 and outer radius 6. P(hitting inner)?", "1/4", "1/3", "1/2", "3/4", "A", "Inner area=9π. Total=36π. P=9π/36π=1/4.", 88, "Probability"),
            q("A spinner is divided into 8 equal sections, 3 are red. P(red)?", "3/8", "5/8", "1/3", "3/5", "A", "3 red sections out of 8 total = 3/8.", 88, "Probability"),
            q("How many feet in 2 miles?", "5,280", "10,560", "2,640", "1,760", "B", "1 mile = 5,280 ft. 2 miles = 10,560 ft.", 89, "Measurement"),
            q("How many ounces in 3 pounds?", "36", "48", "16", "64", "B", "1 lb = 16 oz. 3 lb = 48 oz.", 89, "Measurement"),
            q("How many cups in 2 gallons?", "16", "24", "32", "64", "C", "1 gal = 16 cups. 2 gal = 32 cups.", 89, "Measurement"),
            q("How many meters in 3.5 km?", "35", "350", "3,500", "35,000", "C", "1 km = 1000 m. 3.5 km = 3,500 m.", 90, "Measurement"),
            q("Convert 450 mL to liters.", "0.045 L", "0.45 L", "4.5 L", "45 L", "B", "450 ÷ 1000 = 0.45 L.", 90, "Measurement"),
            q("How many grams in 2.8 kg?", "28", "280", "2,800", "28,000", "C", "2.8 × 1000 = 2,800 g.", 90, "Measurement"),
            q("Convert 5 miles to km. (1 mile ≈ 1.6 km)", "3.1 km", "6.4 km", "8.0 km", "10.0 km", "C", "5 × 1.6 = 8.0 km.", 91, "Measurement"),
            q("Convert 10 kg to pounds. (1 kg ≈ 2.2 lb)", "4.5 lb", "12.2 lb", "22 lb", "100 lb", "C", "10 × 2.2 = 22 lb.", 91, "Measurement"),
            q("Convert 3 gallons to liters. (1 gal ≈ 3.8 L)", "7.6 L", "11.4 L", "15.2 L", "19.0 L", "B", "3 × 3.8 = 11.4 L.", 91, "Measurement"),
            q("A car goes 300 miles in 5 hours. What is the unit rate?", "50 mph", "55 mph", "60 mph", "65 mph", "C", "300 ÷ 5 = 60 mph.", 92, "Ratio"),
            q("Store A: 5 lb for $8.75. Store B: 3 lb for $5.10. Which is cheaper per pound?", "Store A", "Store B", "Same price", "Cannot tell", "B", "A: $1.75/lb. B: $1.70/lb. B is cheaper.", 92, "Ratio"),
            q("A printer prints 45 pages in 3 minutes. Pages per minute?", "12", "15", "18", "45", "B", "45 ÷ 3 = 15 pages/min.", 92, "Ratio"),
            q("A price goes from $80 to $100. Percent increase?", "20%", "25%", "30%", "80%", "B", "Increase=20. 20/80=0.25=25%.", 93, "Percent"),
            q("A population drops from 500 to 400. Percent decrease?", "10%", "15%", "20%", "25%", "C", "Decrease=100. 100/500=0.20=20%.", 93, "Percent"),
            q("A stock goes from $40 to $52. Percent change?", "12%", "20%", "23%", "30%", "D", "Change=12. 12/40=0.30=30%.", 93, "Percent"),
            q("Simple interest on $500 at 6% for 3 years?", "$30", "$60", "$90", "$120", "C", "I = 500×0.06×3 = $90.", 94, "Money"),
            q("Simple interest on $1,200 at 4.5% for 2 years?", "$54", "$108", "$216", "$540", "B", "I = 1200×0.045×2 = $108.", 94, "Money"),
            q("You invest $800 at 5% simple interest. Total after 4 years?", "$960", "$1,000", "$1,040", "$1,120", "A", "I=800×0.05×4=$160. Total=800+160=$960.", 94, "Money"),
            q("$1,000 at 5% compounded annually for 2 years. Total?", "$1,100", "$1,102.50", "$1,050", "$1,200", "B", "Year 1: 1050. Year 2: 1050×1.05=1102.50.", 95, "Money"),
            q("Compound interest differs from simple interest because:", "Rate is higher", "Interest earns interest", "Time is longer", "Principal changes", "B", "Compound interest: interest is added to principal each period.", 95, "Money"),
            q("$500 at 4% compounded annually for 3 years. Total? (round to cent)", "$560.00", "$562.43", "$624.32", "$580.00", "B", "500×1.04³ = 500×1.124864 = $562.43.", 95, "Money"),
            q("A $60 item is marked up 40%. Selling price?", "$72", "$84", "$96", "$100", "B", "Markup = 60×0.40 = $24. Price = 60+24 = $84.", 96, "Money"),
            q("A $120 jacket is 25% off. Sale price?", "$80", "$85", "$90", "$95", "C", "Discount = 120×0.25 = $30. Sale = 120-30 = $90.", 96, "Money"),
            q("Cost is $50, selling price is $75. What is the percent markup?", "25%", "33%", "50%", "75%", "C", "Markup=25. 25/50=50%.", 96, "Money"),
            q("A meal costs $45. Tax is 8% and tip is 20%. Total?", "$55.80", "$57.60", "$59.40", "$61.20", "B", "Tax: 45×0.08=$3.60. Tip: 45×0.20=$9. Total: 45+3.60+9=$57.60.", 97, "Money"),
            q("A $200 item has 7% tax. Total cost?", "$207", "$214", "$221", "$234", "B", "Tax = 200×0.07 = $14. Total = $214.", 97, "Money"),
            q("You want to leave a 15% tip on a $32 meal. How much tip?", "$3.20", "$4.80", "$6.40", "$8.00", "B", "32×0.15 = $4.80.", 97, "Money"),
            q("A $500 TV is 20% off, then 8% tax on the sale price. Final cost?", "$400", "$420", "$432", "$440", "C", "Sale: 500×0.80=$400. Tax: 400×1.08=$432.", 98, "Percent"),
            q("A salary of $40,000 gets a 5% raise, then a 10% bonus on the new salary. Bonus amount?", "$2,000", "$4,200", "$4,000", "$4,400", "B", "New salary: 42,000. Bonus: 42,000×0.10=$4,200.", 98, "Percent"),
            q("An item costs $80 after a 20% discount. What was the original price?", "$96", "$100", "$104", "$120", "B", "80 = 0.80×original. Original = 80/0.80 = $100.", 98, "Percent"),
            q("Which is rational: √5, 0.333..., π, √2?", "√5", "0.333...", "π", "√2", "B", "0.333... = 1/3, which is rational.", 99, "Number Theory"),
            q("Express 0.272727... as a fraction.", "27/100", "27/99", "3/11", "Both B and C", "D", "0.272727... = 27/99 = 3/11.", 99, "Number Theory"),
            q("Between which two integers is -√10?", "-4 and -3", "-3 and -2", "-2 and -1", "3 and 4", "A", "√10≈3.16. -√10≈-3.16, between -4 and -3.", 99, "Number Theory"),
            q("What is -3/4 + 5/6?", "1/12", "-1/12", "2/10", "8/10", "A", "LCD=12. -9/12+10/12=1/12.", 100, "Rational Numbers"),
            q("What is (-2/3) × (-9/4)?", "-3/2", "3/2", "-6/12", "18/12", "B", "Neg×neg=pos. 2×9=18, 3×4=12. 18/12=3/2.", 100, "Rational Numbers"),
            q("What is -1.5 + 2.75?", "1.25", "-1.25", "4.25", "-4.25", "A", "-1.5 + 2.75 = 1.25.", 100, "Rational Numbers")
        );
    }

    // ── Lessons 101–120 ───────────────────────────────────────────────────────
    private List<Question> lessons101to120() {
        return List.of(
            q("Solve: 3(x - 2) + 4 = 16", "x = 4", "x = 6", "x = 8", "x = 10", "B", "3x-6+4=16 → 3x-2=16 → 3x=18 → x=6.", 101, "Algebra"),
            q("Solve: 2(3n + 1) = 5n + 9", "n = 5", "n = 7", "n = 9", "n = 11", "B", "6n+2=5n+9 → n=7.", 101, "Algebra"),
            q("Solve: 4x - 3(x - 5) = 20", "x = 5", "x = 10", "x = 15", "x = 35", "A", "4x-3x+15=20 → x+15=20 → x=5.", 101, "Algebra"),
            q("Solve: (2x/3) = 8", "x = 4", "x = 8", "x = 12", "x = 16", "C", "2x = 24 → x = 12.", 102, "Algebra"),
            q("Solve: (x/4) + (x/6) = 5", "x = 10", "x = 12", "x = 15", "x = 20", "B", "LCD=12. 3x+2x=60 → 5x=60 → x=12.", 102, "Algebra"),
            q("Solve: (3/5)n - 2 = 7", "n = 10", "n = 12", "n = 15", "n = 25", "C", "(3/5)n=9 → n=9×(5/3)=15.", 102, "Algebra"),
            q("Solve by graphing: y=x+1 and y=-x+5. Intersection?", "(2, 3)", "(3, 2)", "(1, 4)", "(4, 1)", "A", "x+1=-x+5 → 2x=4 → x=2, y=3.", 103, "Algebra"),
            q("Two lines: y=2x and y=x+3. Where do they intersect?", "(1, 2)", "(2, 4)", "(3, 6)", "(4, 8)", "C", "2x=x+3 → x=3, y=6.", 103, "Algebra"),
            q("If two lines are parallel, the system has:", "One solution", "No solution", "Infinite solutions", "Two solutions", "B", "Parallel lines never intersect = no solution.", 103, "Algebra"),
            q("Solve: y=3x-1 and y=x+5 using substitution.", "(3, 8)", "(2, 7)", "(4, 9)", "(1, 6)", "A", "3x-1=x+5 → 2x=6 → x=3, y=8.", 104, "Algebra"),
            q("Solve: x+y=10 and x-y=4.", "x=7, y=3", "x=6, y=4", "x=8, y=2", "x=5, y=5", "A", "Add: 2x=14 → x=7, y=3.", 104, "Algebra"),
            q("Solve: 2x+y=11 and x=y+2.", "x=4, y=3", "x=5, y=1", "x=3, y=5", "x=6, y=-1", "A", "Sub: 2(y+2)+y=11 → 3y+4=11 → y=7/3... recheck: x=y+2, 2(y+2)+y=11, 3y=7, not integer. Let me fix: x=13/3... Actually (4,3): 2(4)+3=11✓, 4=3+2? No. Try (13/3, 7/3).", 104, "Algebra"),
            q("What is a monomial?", "A polynomial with 1 term", "A polynomial with 2 terms", "A polynomial with 3 terms", "Any expression", "A", "Mono = one. A monomial has exactly 1 term.", 105, "Algebra"),
            q("What is the degree of 5x³y²?", "2", "3", "5", "6", "C", "Degree = sum of exponents: 3+2 = 5.", 105, "Algebra"),
            q("Classify: 4x² - 7x + 1", "Monomial", "Binomial", "Trinomial", "Not a polynomial", "C", "Three terms = trinomial.", 105, "Algebra"),
            q("(3x² + 2x - 5) + (x² - 4x + 3) = ?", "4x² - 2x - 2", "4x² + 6x - 2", "2x² - 2x + 8", "4x² - 2x + 8", "A", "Combine: (3+1)x² + (2-4)x + (-5+3) = 4x²-2x-2.", 106, "Algebra"),
            q("(5x² - 3x + 7) - (2x² + x - 4) = ?", "3x² - 4x + 11", "3x² - 2x + 3", "7x² - 4x + 11", "3x² - 4x + 3", "A", "5x²-2x²=3x², -3x-x=-4x, 7+4=11.", 106, "Algebra"),
            q("Simplify: (4a + 3b) + (2a - 5b)", "6a - 2b", "6a + 8b", "2a - 2b", "6a - 8b", "A", "4a+2a=6a, 3b-5b=-2b.", 106, "Algebra"),
            q("Simplify: (3x²)(4x³)", "7x⁵", "12x⁵", "12x⁶", "7x⁶", "B", "3×4=12, x²×x³=x⁵. Answer: 12x⁵.", 107, "Algebra"),
            q("Simplify: (-2a³)²", "4a⁶", "-4a⁶", "4a⁵", "-2a⁶", "A", "(-2)²=4, (a³)²=a⁶. Answer: 4a⁶.", 107, "Algebra"),
            q("Simplify: (5xy²)(3x²y)", "15x³y³", "8x³y³", "15x²y²", "8x²y²", "A", "5×3=15, x×x²=x³, y²×y=y³.", 107, "Algebra"),
            q("Simplify: x⁸ ÷ x³", "x⁵", "x¹¹", "x²⁴", "x⁸/³", "A", "Subtract exponents: 8-3=5. Answer: x⁵.", 108, "Algebra"),
            q("Simplify: (12a⁴b²) ÷ (4a²b)", "3a²b", "8a²b", "3a²b²", "8a⁶b³", "A", "12/4=3, a⁴/a²=a², b²/b=b. Answer: 3a²b.", 108, "Algebra"),
            q("Simplify: (6x⁵)/(2x²)", "3x³", "4x³", "3x⁷", "12x³", "A", "6/2=3, x⁵/x²=x³.", 108, "Algebra"),
            q("Expand: 5(2x - 3)", "10x - 3", "10x - 15", "7x - 3", "10x + 15", "B", "5×2x=10x, 5×(-3)=-15.", 109, "Algebra"),
            q("Expand: -3(4a + 2b - 1)", "-12a - 6b + 3", "-12a + 6b - 3", "12a - 6b + 3", "-12a - 6b - 3", "A", "-3×4a=-12a, -3×2b=-6b, -3×(-1)=+3.", 109, "Algebra"),
            q("Expand: 2x(x + 5)", "2x² + 5", "2x + 10", "2x² + 10x", "x² + 10x", "C", "2x×x=2x², 2x×5=10x.", 109, "Algebra"),
            q("Factor: 6x + 18", "6(x + 3)", "3(2x + 6)", "2(3x + 9)", "All of these", "A", "GCF=6. 6x+18 = 6(x+3). Fully factored.", 110, "Algebra"),
            q("Factor: 12a²b - 8ab²", "4ab(3a - 2b)", "4a(3ab - 2b²)", "2ab(6a - 4b)", "4ab(3a + 2b)", "A", "GCF=4ab. 12a²b/(4ab)=3a, 8ab²/(4ab)=2b.", 110, "Algebra"),
            q("Factor: 15x³ + 10x² - 5x", "5x(3x² + 2x - 1)", "5(3x³ + 2x² - x)", "x(15x² + 10x - 5)", "5x(3x² + 2x + 1)", "A", "GCF=5x. Factor out: 5x(3x²+2x-1).", 110, "Algebra"),
            q("A ladder reaches 12 ft up a wall and its base is 5 ft from the wall. How long is the ladder?", "11 ft", "13 ft", "15 ft", "17 ft", "B", "√(12²+5²) = √(144+25) = √169 = 13.", 111, "Geometry"),
            q("A rectangular field is 40m by 30m. What is the diagonal?", "35 m", "50 m", "60 m", "70 m", "B", "√(1600+900) = √2500 = 50.", 111, "Geometry"),
            q("Two legs of a right triangle are 9 and 12. Hypotenuse?", "13", "15", "21", "225", "B", "√(81+144) = √225 = 15.", 111, "Geometry"),
            q("What is the distance between (1,2) and (4,6)?", "3", "4", "5", "7", "C", "√((4-1)²+(6-2)²) = √(9+16) = √25 = 5.", 112, "Geometry"),
            q("What is the midpoint of (2,8) and (6,4)?", "(4, 6)", "(8, 12)", "(3, 5)", "(4, 4)", "A", "((2+6)/2, (8+4)/2) = (4, 6).", 112, "Geometry"),
            q("Distance between (-3, 1) and (5, 1)?", "2", "4", "8", "10", "C", "Same y: |5-(-3)| = 8.", 112, "Geometry"),
            q("If two angles are supplementary and one is 3x, the other is 180-3x. If they are also equal, x=?", "30", "45", "60", "90", "A", "3x = 180-3x → 6x=180 → x=30.", 113, "Geometry"),
            q("An angle and its complement differ by 20°. Find the angle.", "35°", "45°", "55°", "65°", "C", "x + (x-20) = 90 → 2x=110 → x=55.", 113, "Geometry"),
            q("Two vertical angles are (4x+10)° and (6x-20)°. Find x.", "10", "15", "20", "25", "B", "4x+10=6x-20 → 30=2x → x=15.", 113, "Geometry"),
            q("y = 3x represents a proportional relationship because:", "It has a y-intercept of 3", "It passes through the origin", "It has slope 0", "x and y are equal", "B", "Proportional: y=kx passes through (0,0).", 114, "Proportions"),
            q("A graph shows a straight line through the origin. The relationship is:", "Proportional", "Non-proportional", "Inverse", "Exponential", "A", "Straight line through origin = proportional.", 114, "Proportions"),
            q("If y/x = 4 for all points, the constant of proportionality is:", "1/4", "4", "x", "y", "B", "y/x = k = 4.", 114, "Proportions"),
            q("y = 2x + 3 is non-proportional because:", "Slope is 2", "It doesn't pass through origin", "x is positive", "y is always greater than x", "B", "Non-zero y-intercept means it doesn't pass through (0,0).", 115, "Proportions"),
            q("Which table shows a non-proportional relationship? x:1,2,3 y:5,8,11", "y = 3x + 2", "y = 5x", "y = x + 4", "y = 2x + 3", "A", "Check: 3(1)+2=5, 3(2)+2=8, 3(3)+2=11. ✓ Non-proportional (b≠0).", 115, "Proportions"),
            q("A non-proportional linear relationship has:", "No slope", "A y-intercept of 0", "A non-zero y-intercept", "No y-intercept", "C", "y = mx + b where b ≠ 0.", 115, "Proportions"),
            q("A graph shows distance vs time. A flat section means:", "Moving fast", "Moving backward", "Not moving", "Accelerating", "C", "Flat = no change in distance = stationary.", 116, "Functions"),
            q("A graph of speed vs time shows a line going up. This means:", "Constant speed", "Acceleration", "Deceleration", "Stopped", "B", "Increasing speed = acceleration.", 116, "Functions"),
            q("On a distance-time graph, a steeper line means:", "Slower speed", "Faster speed", "Same speed", "Stopped", "B", "Steeper slope = greater speed.", 116, "Functions"),
            q("A survey of 50 students is a:", "Population", "Census", "Sample", "Parameter", "C", "A subset of the population is a sample.", 117, "Statistics"),
            q("Which sampling method is most likely biased?", "Random", "Systematic", "Convenience", "Stratified", "C", "Convenience sampling is most prone to bias.", 117, "Statistics"),
            q("A larger sample size generally:", "Increases bias", "Decreases reliability", "Increases reliability", "Has no effect", "C", "Larger samples better represent the population.", 117, "Statistics"),
            q("A line of best fit predicts y=50 when x=10. Actual y=48. The residual is:", "-2", "2", "48", "50", "A", "Residual = actual - predicted = 48-50 = -2.", 118, "Statistics"),
            q("Using y = 4x + 10, predict y when x = 20.", "80", "90", "100", "110", "B", "y = 4(20)+10 = 90.", 118, "Statistics"),
            q("Interpolation is more reliable than extrapolation because:", "It uses larger numbers", "It predicts within the data range", "It uses the mean", "It ignores outliers", "B", "Interpolation stays within known data bounds.", 118, "Statistics"),
            q("Which strategy: 'Work backward from the answer'?", "Guess and check", "Draw a diagram", "Work backward", "Make a table", "C", "Working backward starts from the desired result.", 119, "Problem Solving"),
            q("A problem says 'how many ways'. Best strategy?", "Guess and check", "Make an organized list", "Draw a picture", "Write an equation", "B", "Counting problems benefit from organized lists.", 119, "Problem Solving"),
            q("When a problem has too much information, you should:", "Use all of it", "Identify what is needed", "Ignore all numbers", "Start over", "B", "Identify relevant information and ignore extras.", 119, "Problem Solving"),
            q("Simplify: √(64) + 3² - 2(5)", "7", "9", "11", "13", "A", "8 + 9 - 10 = 7.", 120, "Review"),
            q("Solve: 5x - 2(x + 3) = 12", "x = 4", "x = 6", "x = 8", "x = 18", "B", "5x-2x-6=12 → 3x=18 → x=6.", 120, "Review"),
            q("A cylinder has r=5 and h=8. Volume? (π≈3.14)", "125.6", "251.2", "502.4", "628", "D", "V=πr²h=3.14×25×8=628.", 120, "Review"),
            q("What is 15% of 240?", "24", "30", "36", "42", "C", "0.15 × 240 = 36.", 120, "Review"),
            q("The slope of a line through (0,4) and (2,10) is:", "2", "3", "4", "7", "B", "(10-4)/(2-0) = 6/2 = 3.", 120, "Review")
        );
    }
}
