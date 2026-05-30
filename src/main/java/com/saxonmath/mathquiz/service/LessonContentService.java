package com.saxonmath.mathquiz.service;

import com.saxonmath.mathquiz.model.LessonContent;
import com.saxonmath.mathquiz.model.LessonContent.Section;
import com.saxonmath.mathquiz.model.LessonContent.WorkedExample;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LessonContentService {

    private final List<LessonContent> lessons;

    public LessonContentService() {
        this.lessons = new ArrayList<>();
        lessons.addAll(buildLessons1to20());
        lessons.addAll(buildLessons21to40());
        lessons.addAll(buildLessons41to60());
        lessons.addAll(buildLessons61to80());
        lessons.addAll(buildLessons81to100());
        lessons.addAll(buildLessons101to120());
    }

    public List<LessonContent> getAllLessons() {
        return lessons;
    }

    public Optional<LessonContent> getLessonBySlug(String slug) {
        return lessons.stream().filter(l -> l.getSlug().equals(slug)).findFirst();
    }

    // ═══════════════════════════════════════════════════════════════════════════════
    // LESSONS 1–20: Number Sense, Fractions, Decimals, Percents
    // ═══════════════════════════════════════════════════════════════════════════════
    private List<LessonContent> buildLessons1to20() {
        List<LessonContent> list = new ArrayList<>();

        // Lesson 1
        list.add(new LessonContent("lesson-1-place-value", "Place Value Through Billions", "🔢",
            "Understand the value of each digit in numbers up to the billions place.",
            List.of(
                new Section("Understanding Place Value", "Each digit in a number has a value based on its position. Moving left, each place is 10 times greater.",
                    List.of(new WorkedExample("What is the value of the 7 in 3,742,000?", List.of("Identify the position: 7 is in the hundred-thousands place", "Multiply: 7 × 100,000 = 700,000"), "700,000"))),
                new Section("Reading Large Numbers", "Use commas to separate periods (billions, millions, thousands, ones) and read each group.",
                    List.of(new WorkedExample("Write 2,450,000,000 in words.", List.of("2 billion, 450 million", "Two billion, four hundred fifty million"), "Two billion, four hundred fifty million")))
            ),
            List.of("Each place value is 10 times the place to its right", "Commas separate periods for easier reading", "Zero is a placeholder that maintains place value")));

        // Lesson 2
        list.add(new LessonContent("lesson-2-comparing-ordering", "Comparing and Ordering Integers", "⚖️",
            "Compare integers using place value and order them on a number line.",
            List.of(
                new Section("Comparing Integers", "Compare digits from left to right. The first position where digits differ determines which number is greater.",
                    List.of(new WorkedExample("Compare 4,582 and 4,597.", List.of("Thousands digit: both 4", "Hundreds digit: both 5", "Tens digit: 8 < 9"), "4,582 < 4,597"))),
                new Section("Ordering Integers", "To order numbers, compare them in pairs and arrange from least to greatest or greatest to least.",
                    List.of(new WorkedExample("Order from least to greatest: 305, 350, 299.", List.of("Compare hundreds: 299 has 2 hundreds, others have 3", "Compare 305 and 350: tens differ, 0 < 5"), "299, 305, 350")))
            ),
            List.of("Compare digits from left to right", "Use < (less than) and > (greater than) symbols", "On a number line, numbers increase to the right")));

        // Lesson 3
        list.add(new LessonContent("lesson-3-operations-whole", "Operations with Whole Numbers", "➕",
            "Add, subtract, multiply, and divide whole numbers fluently.",
            List.of(
                new Section("Addition and Subtraction", "Line up digits by place value. Regroup (carry or borrow) when needed.",
                    List.of(new WorkedExample("Calculate 2,847 + 1,365.", List.of("Add ones: 7+5=12, write 2 carry 1", "Add tens: 4+6+1=11, write 1 carry 1", "Add hundreds: 8+3+1=12, write 2 carry 1, thousands: 2+1+1=4"), "4,212"))),
                new Section("Multiplication and Division", "Multiply using partial products or the standard algorithm. Divide using long division.",
                    List.of(new WorkedExample("Calculate 234 × 6.", List.of("6×4=24, write 4 carry 2", "6×3=18, plus 2=20, write 0 carry 2", "6×2=12, plus 2=14"), "1,404")))
            ),
            List.of("Always align digits by place value", "Check subtraction with addition", "Multiplication is repeated addition", "Division is the inverse of multiplication")));

        // Lesson 4
        list.add(new LessonContent("lesson-4-factors-multiples", "Factors and Multiples", "🔗",
            "Find all factors of a number and identify multiples.",
            List.of(
                new Section("Finding Factors", "Factors are numbers that divide evenly into a given number. Find factor pairs by testing divisors.",
                    List.of(new WorkedExample("Find all factors of 24.", List.of("1×24, 2×12, 3×8, 4×6", "List all factors: 1,2,3,4,6,8,12,24"), "1, 2, 3, 4, 6, 8, 12, 24"))),
                new Section("Finding Multiples", "Multiples are found by multiplying a number by 1, 2, 3, and so on.",
                    List.of(new WorkedExample("List the first five multiples of 7.", List.of("7×1=7, 7×2=14, 7×3=21", "7×4=28, 7×5=35"), "7, 14, 21, 28, 35")))
            ),
            List.of("Every number has 1 and itself as factors", "Multiples of a number go on forever", "A number is a factor of its multiples")));

        // Lesson 5
        list.add(new LessonContent("lesson-5-prime-factorization", "Prime Factorization", "🌳",
            "Break down composite numbers into their prime factors using factor trees.",
            List.of(
                new Section("Prime vs Composite", "A prime number has exactly two factors: 1 and itself. A composite number has more than two factors.",
                    List.of(new WorkedExample("Is 29 prime or composite?", List.of("Test divisibility by 2,3,5 (primes up to √29≈5.4)", "29÷2, 29÷3, 29÷5 all have remainders"), "29 is prime"))),
                new Section("Factor Trees", "Break a number into two factors repeatedly until all factors are prime.",
                    List.of(new WorkedExample("Find the prime factorization of 60.", List.of("60 = 2 × 30", "30 = 2 × 15", "15 = 3 × 5"), "2² × 3 × 5")))
            ),
            List.of("2 is the only even prime number", "Every composite number has a unique prime factorization", "Use a factor tree to find prime factors")));

        // Lesson 6
        list.add(new LessonContent("lesson-6-gcf-lcm", "GCF and LCM", "🎯",
            "Find the greatest common factor and least common multiple of two or more numbers.",
            List.of(
                new Section("Greatest Common Factor", "The GCF is the largest factor shared by two or more numbers. Use prime factorization or list factors.",
                    List.of(new WorkedExample("Find the GCF of 18 and 24.", List.of("18 = 2×3×3; 24 = 2×2×2×3", "Common primes: one 2 and one 3", "GCF = 2×3 = 6"), "6"))),
                new Section("Least Common Multiple", "The LCM is the smallest number that is a multiple of both numbers.",
                    List.of(new WorkedExample("Find the LCM of 4 and 6.", List.of("Multiples of 4: 4,8,12,16...", "Multiples of 6: 6,12,18...", "First common multiple: 12"), "12")))
            ),
            List.of("GCF is used to simplify fractions", "LCM is used to find common denominators", "GCF × LCM = product of the two numbers")));

        // Lesson 7
        list.add(new LessonContent("lesson-7-fractions-mixed", "Fractions and Mixed Numbers", "🥧",
            "Understand fractions as parts of a whole and convert between improper fractions and mixed numbers.",
            List.of(
                new Section("Understanding Fractions", "A fraction has a numerator (parts taken) and denominator (total equal parts).",
                    List.of(new WorkedExample("Convert 11/4 to a mixed number.", List.of("Divide: 11 ÷ 4 = 2 remainder 3", "Write as: 2 and 3/4"), "2 3/4"))),
                new Section("Converting Mixed to Improper", "Multiply the whole number by the denominator, add the numerator, keep the same denominator.",
                    List.of(new WorkedExample("Convert 3 2/5 to an improper fraction.", List.of("Multiply: 3 × 5 = 15", "Add numerator: 15 + 2 = 17", "Keep denominator: 17/5"), "17/5")))
            ),
            List.of("The denominator tells how many equal parts make a whole", "Improper fractions have numerator ≥ denominator", "Mixed numbers combine a whole number and a fraction")));

        // Lesson 8
        list.add(new LessonContent("lesson-8-equivalent-fractions", "Equivalent Fractions and Simplifying", "✂️",
            "Create equivalent fractions and reduce fractions to simplest form.",
            List.of(
                new Section("Equivalent Fractions", "Multiply or divide both numerator and denominator by the same nonzero number.",
                    List.of(new WorkedExample("Find a fraction equivalent to 3/4 with denominator 20.", List.of("4 × 5 = 20, so multiply numerator by 5", "3 × 5 = 15"), "15/20"))),
                new Section("Simplifying Fractions", "Divide numerator and denominator by their GCF.",
                    List.of(new WorkedExample("Simplify 18/24.", List.of("GCF of 18 and 24 is 6", "18÷6=3, 24÷6=4"), "3/4")))
            ),
            List.of("Equivalent fractions represent the same value", "Divide by the GCF to simplify in one step", "A fraction is in simplest form when GCF is 1")));

        // Lesson 9
        list.add(new LessonContent("lesson-9-add-subtract-fractions", "Adding and Subtracting Fractions", "➕",
            "Add and subtract fractions with like and unlike denominators.",
            List.of(
                new Section("Like Denominators", "When denominators are the same, add or subtract the numerators and keep the denominator.",
                    List.of(new WorkedExample("Calculate 3/8 + 2/8.", List.of("Same denominator: add numerators", "3+2=5, keep 8"), "5/8"))),
                new Section("Unlike Denominators", "Find the LCD, rewrite each fraction, then add or subtract.",
                    List.of(new WorkedExample("Calculate 1/3 + 1/4.", List.of("LCD of 3 and 4 is 12", "1/3 = 4/12, 1/4 = 3/12", "4/12 + 3/12 = 7/12"), "7/12")))
            ),
            List.of("You must have common denominators to add or subtract", "The LCD is the LCM of the denominators", "Always simplify your answer")));

        // Lesson 10
        list.add(new LessonContent("lesson-10-multiplying-fractions", "Multiplying Fractions", "✖️",
            "Multiply fractions by multiplying numerators and denominators.",
            List.of(
                new Section("Multiplying Fractions", "Multiply the numerators together and the denominators together. Simplify if possible.",
                    List.of(new WorkedExample("Calculate 2/3 × 4/5.", List.of("Numerators: 2×4=8", "Denominators: 3×5=15"), "8/15"))),
                new Section("Cross-Canceling", "Before multiplying, divide a numerator and a denominator by a common factor to simplify early.",
                    List.of(new WorkedExample("Calculate 3/8 × 4/9.", List.of("Cancel 3 and 9 by 3: becomes 1/8 × 4/3", "Cancel 4 and 8 by 4: becomes 1/2 × 1/3", "Multiply: 1/6"), "1/6")))
            ),
            List.of("No common denominator needed for multiplication", "Cross-cancel to simplify before multiplying", "A whole number can be written as a fraction over 1")));

        // Lesson 11
        list.add(new LessonContent("lesson-11-dividing-fractions", "Dividing Fractions", "➗",
            "Divide fractions by multiplying by the reciprocal.",
            List.of(
                new Section("The Reciprocal", "The reciprocal of a/b is b/a. To divide by a fraction, multiply by its reciprocal.",
                    List.of(new WorkedExample("Calculate 3/4 ÷ 2/5.", List.of("Reciprocal of 2/5 is 5/2", "Multiply: 3/4 × 5/2 = 15/8"), "15/8 or 1 7/8"))),
                new Section("Dividing with Whole Numbers", "Write the whole number as a fraction over 1, then use the reciprocal method.",
                    List.of(new WorkedExample("Calculate 6 ÷ 3/4.", List.of("Write 6 as 6/1", "Reciprocal of 3/4 is 4/3", "6/1 × 4/3 = 24/3 = 8"), "8")))
            ),
            List.of("Keep-Change-Flip: keep the first, change ÷ to ×, flip the second", "The reciprocal of a whole number n is 1/n", "Dividing by a fraction less than 1 gives a larger result")));

        // Lesson 12
        list.add(new LessonContent("lesson-12-add-sub-mixed", "Adding and Subtracting Mixed Numbers", "🧮",
            "Add and subtract mixed numbers, regrouping when necessary.",
            List.of(
                new Section("Adding Mixed Numbers", "Add the whole numbers and fractions separately. Simplify if the fraction is improper.",
                    List.of(new WorkedExample("Calculate 2 1/3 + 1 2/3.", List.of("Add wholes: 2+1=3", "Add fractions: 1/3+2/3=3/3=1", "Combine: 3+1=4"), "4"))),
                new Section("Subtracting with Regrouping", "If the fraction being subtracted is larger, borrow 1 from the whole number.",
                    List.of(new WorkedExample("Calculate 5 1/4 - 2 3/4.", List.of("1/4 < 3/4, so borrow: 5 1/4 = 4 5/4", "Subtract wholes: 4-2=2", "Subtract fractions: 5/4-3/4=2/4=1/2"), "2 1/2")))
            ),
            List.of("Add or subtract whole parts and fraction parts separately", "Borrow from the whole number when the fraction part is too small", "Always simplify the final answer")));

        // Lesson 13
        list.add(new LessonContent("lesson-13-mult-div-mixed", "Multiplying and Dividing Mixed Numbers", "🔄",
            "Convert mixed numbers to improper fractions before multiplying or dividing.",
            List.of(
                new Section("Multiplying Mixed Numbers", "Convert to improper fractions, multiply, then convert back.",
                    List.of(new WorkedExample("Calculate 2 1/2 × 1 1/3.", List.of("Convert: 5/2 × 4/3", "Multiply: 20/6", "Simplify: 10/3 = 3 1/3"), "3 1/3"))),
                new Section("Dividing Mixed Numbers", "Convert to improper fractions, then multiply by the reciprocal.",
                    List.of(new WorkedExample("Calculate 3 1/2 ÷ 1 1/4.", List.of("Convert: 7/2 ÷ 5/4", "Multiply by reciprocal: 7/2 × 4/5 = 28/10", "Simplify: 14/5 = 2 4/5"), "2 4/5")))
            ),
            List.of("Always convert mixed numbers to improper fractions first", "After multiplying or dividing, convert back to a mixed number", "Cross-cancel before multiplying to keep numbers small")));

        // Lesson 14
        list.add(new LessonContent("lesson-14-decimal-place-value", "Decimal Place Value", "🔵",
            "Understand place value for digits to the right of the decimal point.",
            List.of(
                new Section("Decimal Places", "Places to the right of the decimal are tenths, hundredths, thousandths, and so on.",
                    List.of(new WorkedExample("What is the value of 6 in 0.362?", List.of("6 is in the hundredths place", "Value = 6 × 0.01 = 0.06"), "0.06"))),
                new Section("Reading Decimals", "Read the number after the decimal and name the last place value.",
                    List.of(new WorkedExample("Write 0.045 in words.", List.of("45 in the thousandths place", "Forty-five thousandths"), "Forty-five thousandths")))
            ),
            List.of("The decimal point separates whole numbers from parts", "Each place to the right is 1/10 of the previous place", "Trailing zeros don't change a decimal's value")));

        // Lesson 15
        list.add(new LessonContent("lesson-15-add-sub-decimals", "Adding and Subtracting Decimals", "📐",
            "Add and subtract decimals by aligning decimal points.",
            List.of(
                new Section("Aligning Decimals", "Write numbers vertically with decimal points lined up. Fill empty places with zeros.",
                    List.of(new WorkedExample("Calculate 3.7 + 2.45.", List.of("Align: 3.70 + 2.45", "Add: 0+5=5, 7+4=11 carry 1, 3+2+1=6"), "6.15"))),
                new Section("Subtracting Decimals", "Align decimal points and subtract as with whole numbers.",
                    List.of(new WorkedExample("Calculate 5.2 - 1.83.", List.of("Align: 5.20 - 1.83", "Borrow and subtract: 20-83 needs regrouping", "5.20 - 1.83 = 3.37"), "3.37")))
            ),
            List.of("Always align decimal points vertically", "Use zeros as placeholders", "The decimal point in the answer lines up with the others")));

        // Lesson 16
        list.add(new LessonContent("lesson-16-multiplying-decimals", "Multiplying Decimals", "✖️",
            "Multiply decimals and place the decimal point correctly in the product.",
            List.of(
                new Section("Counting Decimal Places", "Multiply as whole numbers, then count total decimal places in both factors to place the decimal.",
                    List.of(new WorkedExample("Calculate 2.3 × 1.4.", List.of("Multiply 23 × 14 = 322", "Count decimal places: 1+1=2", "Place decimal: 3.22"), "3.22"))),
                new Section("Multiplying by Powers of 10", "Move the decimal point right for each zero in the power of 10.",
                    List.of(new WorkedExample("Calculate 0.056 × 1000.", List.of("1000 has 3 zeros", "Move decimal 3 places right"), "56")))
            ),
            List.of("Count total decimal places in both factors", "Multiplying by 10, 100, 1000 moves the decimal right", "Estimate first to check reasonableness")));

        // Lesson 17
        list.add(new LessonContent("lesson-17-dividing-decimals", "Dividing Decimals", "➗",
            "Divide decimals by making the divisor a whole number.",
            List.of(
                new Section("Dividing by a Whole Number", "Place the decimal point in the quotient directly above the decimal in the dividend.",
                    List.of(new WorkedExample("Calculate 8.4 ÷ 4.", List.of("4 goes into 8 twice, 4 goes into 4 once", "Place decimal above: 2.1"), "2.1"))),
                new Section("Dividing by a Decimal", "Move the decimal in the divisor to make it whole, move the same number of places in the dividend.",
                    List.of(new WorkedExample("Calculate 6.3 ÷ 0.9.", List.of("Move decimal 1 place: 63 ÷ 9", "63 ÷ 9 = 7"), "7")))
            ),
            List.of("Make the divisor a whole number by moving the decimal", "Move the decimal the same number of places in both numbers", "Add zeros to the dividend if needed to continue dividing")));

        // Lesson 18
        list.add(new LessonContent("lesson-18-frac-dec-pct", "Fractions, Decimals, and Percents", "🔄",
            "Convert between fractions, decimals, and percents.",
            List.of(
                new Section("Fraction to Decimal to Percent", "Divide numerator by denominator to get a decimal, then multiply by 100 for percent.",
                    List.of(new WorkedExample("Convert 3/8 to a decimal and percent.", List.of("3 ÷ 8 = 0.375", "0.375 × 100 = 37.5%"), "0.375 = 37.5%"))),
                new Section("Percent to Fraction", "Write the percent over 100 and simplify.",
                    List.of(new WorkedExample("Convert 45% to a fraction.", List.of("45/100", "GCF is 5: 45÷5=9, 100÷5=20"), "9/20")))
            ),
            List.of("Percent means 'per hundred'", "To convert decimal to percent, multiply by 100", "To convert percent to decimal, divide by 100")));

        // Lesson 19
        list.add(new LessonContent("lesson-19-percent-of-number", "Percent of a Number", "💯",
            "Calculate a given percent of a number using multiplication.",
            List.of(
                new Section("Finding a Percent", "Convert the percent to a decimal and multiply by the number.",
                    List.of(new WorkedExample("What is 25% of 80?", List.of("Convert: 25% = 0.25", "Multiply: 0.25 × 80 = 20"), "20"))),
                new Section("Using Proportions", "Set up percent/100 = part/whole and solve.",
                    List.of(new WorkedExample("What is 15% of 60?", List.of("15/100 = x/60", "Cross multiply: 100x = 900", "x = 9"), "9")))
            ),
            List.of("Percent of = decimal form × number", "50% means half, 25% means one quarter", "You can use proportions as an alternative method")));

        // Lesson 20
        list.add(new LessonContent("lesson-20-percent-problems", "Percent Problems", "📊",
            "Solve problems finding the percent, part, or whole.",
            List.of(
                new Section("Finding the Percent", "Divide the part by the whole and multiply by 100.",
                    List.of(new WorkedExample("12 is what percent of 48?", List.of("Divide: 12 ÷ 48 = 0.25", "Multiply by 100: 25%"), "25%"))),
                new Section("Finding the Whole", "Divide the part by the percent (as a decimal).",
                    List.of(new WorkedExample("30 is 60% of what number?", List.of("Convert: 60% = 0.60", "Divide: 30 ÷ 0.60 = 50"), "50")))
            ),
            List.of("Part = Percent × Whole", "Percent = Part ÷ Whole × 100", "Whole = Part ÷ Percent (as decimal)")));

        return list;
    }


    // ═══════════════════════════════════════════════════════════════════════════════
    // LESSONS 21–40: Ratios, Integers, Order of Operations, Algebra Basics
    // ═══════════════════════════════════════════════════════════════════════════════
    private List<LessonContent> buildLessons21to40() {
        List<LessonContent> list = new ArrayList<>();

        // Lesson 21
        list.add(new LessonContent("lesson-21-ratio-rate", "Ratio and Rate", "⚖️",
            "Understand ratios as comparisons and rates as ratios with different units.",
            List.of(
                new Section("Writing Ratios", "A ratio compares two quantities. It can be written as a:b, a/b, or 'a to b'.",
                    List.of(new WorkedExample("A class has 12 boys and 18 girls. Write the ratio of boys to girls in simplest form.", List.of("Ratio: 12:18", "GCF of 12 and 18 is 6", "Simplify: 2:3"), "2:3"))),
                new Section("Rates and Unit Rates", "A rate compares quantities with different units. A unit rate has a denominator of 1.",
                    List.of(new WorkedExample("A car travels 240 miles in 4 hours. Find the unit rate.", List.of("Rate: 240 miles / 4 hours", "Divide: 240 ÷ 4 = 60"), "60 miles per hour")))
            ),
            List.of("Ratios can be simplified like fractions", "A unit rate has 1 in the denominator", "Rates compare quantities with different units")));

        // Lesson 22
        list.add(new LessonContent("lesson-22-proportions", "Proportions", "🔗",
            "Solve proportions using cross multiplication.",
            List.of(
                new Section("Setting Up Proportions", "A proportion states that two ratios are equal: a/b = c/d.",
                    List.of(new WorkedExample("Solve: 3/5 = x/20.", List.of("Cross multiply: 5x = 3×20 = 60", "Divide: x = 60÷5 = 12"), "x = 12"))),
                new Section("Proportion Word Problems", "Set up equivalent ratios from the problem context and solve.",
                    List.of(new WorkedExample("If 4 notebooks cost $6, how much do 10 notebooks cost?", List.of("Set up: 4/6 = 10/x", "Cross multiply: 4x = 60", "x = 15"), "$15")))
            ),
            List.of("Cross products of a proportion are equal", "Keep units consistent on each side", "Check by substituting back into the original proportion")));

        // Lesson 23
        list.add(new LessonContent("lesson-23-scale-drawings", "Scale Drawings and Maps", "🗺️",
            "Use scale factors to find actual distances from maps and models.",
            List.of(
                new Section("Understanding Scale", "A scale relates a measurement on a drawing to the actual measurement.",
                    List.of(new WorkedExample("A map scale is 1 cm = 50 km. Two cities are 3.5 cm apart on the map. Find the actual distance.", List.of("Set up: 1 cm/50 km = 3.5 cm/x km", "x = 3.5 × 50 = 175"), "175 km"))),
                new Section("Scale Factor", "The scale factor is the ratio of the model size to the actual size.",
                    List.of(new WorkedExample("A model car is 1/24 scale. The real car is 12 feet long. How long is the model?", List.of("Model = actual × scale factor", "12 × (1/24) = 0.5 feet = 6 inches"), "6 inches")))
            ),
            List.of("Scale = drawing measurement / actual measurement", "Multiply drawing distance by scale to find actual distance", "Scale factor less than 1 means the model is smaller")));

        // Lesson 24
        list.add(new LessonContent("lesson-24-integers-add-sub", "Integers: Adding and Subtracting", "🌡️",
            "Add and subtract positive and negative integers using number line rules.",
            List.of(
                new Section("Adding Integers", "Same signs: add absolute values, keep the sign. Different signs: subtract absolute values, keep sign of the larger.",
                    List.of(new WorkedExample("Calculate (-7) + (-3).", List.of("Same signs (both negative)", "Add absolute values: 7+3=10", "Keep negative sign"), "-10"),
                        new WorkedExample("Calculate (-8) + 5.", List.of("Different signs: subtract 8-5=3", "Larger absolute value is 8 (negative)"), "-3"))),
                new Section("Subtracting Integers", "To subtract, add the opposite: a - b = a + (-b).",
                    List.of(new WorkedExample("Calculate 4 - (-6).", List.of("Add the opposite: 4 + 6", "4 + 6 = 10"), "10")))
            ),
            List.of("Subtracting is adding the opposite", "Same signs → add and keep sign", "Different signs → subtract and keep sign of larger absolute value")));

        // Lesson 25
        list.add(new LessonContent("lesson-25-integers-mult-div", "Integers: Multiplying and Dividing", "✖️",
            "Multiply and divide integers using sign rules.",
            List.of(
                new Section("Sign Rules for Multiplication", "Same signs give a positive product. Different signs give a negative product.",
                    List.of(new WorkedExample("Calculate (-4) × (-6).", List.of("Same signs (both negative)", "4 × 6 = 24, result is positive"), "24"))),
                new Section("Sign Rules for Division", "Same rules apply: same signs → positive, different signs → negative.",
                    List.of(new WorkedExample("Calculate (-36) ÷ 9.", List.of("Different signs (negative ÷ positive)", "36 ÷ 9 = 4, result is negative"), "-4")))
            ),
            List.of("Positive × Positive = Positive", "Negative × Negative = Positive", "Positive × Negative = Negative", "Same rules apply to division")));

        // Lesson 26
        list.add(new LessonContent("lesson-26-order-operations", "Order of Operations", "📋",
            "Evaluate expressions using PEMDAS: Parentheses, Exponents, Multiplication/Division, Addition/Subtraction.",
            List.of(
                new Section("PEMDAS", "Follow the order: Parentheses first, then Exponents, then Multiply/Divide left to right, then Add/Subtract left to right.",
                    List.of(new WorkedExample("Evaluate: 3 + 4 × 2².", List.of("Exponent first: 2²=4", "Multiply: 4×4=16", "Add: 3+16=19"), "19"))),
                new Section("Grouping Symbols", "Evaluate inside parentheses and brackets first, working from innermost out.",
                    List.of(new WorkedExample("Evaluate: 2 × (3 + 5) - 4.", List.of("Parentheses: 3+5=8", "Multiply: 2×8=16", "Subtract: 16-4=12"), "12")))
            ),
            List.of("PEMDAS: Parentheses, Exponents, Multiply/Divide, Add/Subtract", "Multiply and Divide from left to right (equal priority)", "Add and Subtract from left to right (equal priority)")));

        // Lesson 27
        list.add(new LessonContent("lesson-27-exponents", "Exponents and Powers", "⬆️",
            "Understand exponents as repeated multiplication and evaluate powers.",
            List.of(
                new Section("Understanding Exponents", "In aⁿ, the base a is multiplied by itself n times.",
                    List.of(new WorkedExample("Evaluate 3⁴.", List.of("3⁴ = 3×3×3×3", "9×3=27, 27×3=81"), "81"))),
                new Section("Special Exponents", "Any number to the power of 0 is 1. Any number to the power of 1 is itself.",
                    List.of(new WorkedExample("Evaluate 5⁰ and 7¹.", List.of("5⁰ = 1 (any nonzero number to the 0 power is 1)", "7¹ = 7"), "1 and 7")))
            ),
            List.of("The exponent tells how many times to multiply the base", "Any nonzero number to the 0 power equals 1", "Negative base with even exponent gives positive result")));

        // Lesson 28
        list.add(new LessonContent("lesson-28-scientific-notation", "Scientific Notation", "🔬",
            "Write very large or very small numbers in scientific notation.",
            List.of(
                new Section("Writing in Scientific Notation", "Move the decimal to get a number between 1 and 10, then multiply by the appropriate power of 10.",
                    List.of(new WorkedExample("Write 45,000,000 in scientific notation.", List.of("Move decimal 7 places left: 4.5", "4.5 × 10⁷"), "4.5 × 10⁷"))),
                new Section("Converting to Standard Form", "Move the decimal point right for positive exponents, left for negative exponents.",
                    List.of(new WorkedExample("Write 3.2 × 10⁻⁴ in standard form.", List.of("Negative exponent: move decimal 4 places left", "0.00032"), "0.00032")))
            ),
            List.of("Scientific notation: a × 10ⁿ where 1 ≤ a < 10", "Positive exponent = large number", "Negative exponent = small number (between 0 and 1)")));

        // Lesson 29
        list.add(new LessonContent("lesson-29-square-roots", "Square Roots and Irrational Numbers", "√",
            "Find square roots and distinguish between rational and irrational numbers.",
            List.of(
                new Section("Perfect Squares", "A perfect square is a number whose square root is a whole number.",
                    List.of(new WorkedExample("Find √144.", List.of("What number times itself equals 144?", "12 × 12 = 144"), "12"))),
                new Section("Estimating Square Roots", "For non-perfect squares, estimate between two consecutive whole numbers.",
                    List.of(new WorkedExample("Estimate √50.", List.of("7²=49 and 8²=64", "50 is between 49 and 64, closer to 49"), "≈ 7.07")))
            ),
            List.of("√ means 'what number squared gives this?'", "Perfect squares: 1,4,9,16,25,36,49,64,81,100,...", "Irrational numbers cannot be written as fractions")));

        // Lesson 30
        list.add(new LessonContent("lesson-30-number-line-abs", "The Number Line and Absolute Value", "📏",
            "Plot numbers on a number line and find absolute values.",
            List.of(
                new Section("The Number Line", "Numbers increase to the right and decrease to the left. Zero is in the middle.",
                    List.of(new WorkedExample("Plot -3, 0, and 2 on a number line and order them.", List.of("Left to right: -3, 0, 2", "Order from least to greatest: -3 < 0 < 2"), "-3, 0, 2"))),
                new Section("Absolute Value", "The absolute value |x| is the distance from x to 0 on the number line. It is always non-negative.",
                    List.of(new WorkedExample("Find |-7| and |4|.", List.of("|-7| = 7 (distance from -7 to 0 is 7)", "|4| = 4 (distance from 4 to 0 is 4)"), "7 and 4")))
            ),
            List.of("Absolute value is always zero or positive", "|a| = |-a| for any number a", "Distance between two points = |a - b|")));

        // Lesson 31
        list.add(new LessonContent("lesson-31-algebraic-expressions", "Algebraic Expressions", "🔤",
            "Identify parts of algebraic expressions: terms, coefficients, and constants.",
            List.of(
                new Section("Parts of an Expression", "A term is a number, variable, or product of both. The coefficient is the number multiplied by the variable. A constant has no variable.",
                    List.of(new WorkedExample("Identify the terms, coefficients, and constants in 3x + 5y - 7.", List.of("Terms: 3x, 5y, -7", "Coefficients: 3 and 5", "Constant: -7"), "3 terms; coefficients 3,5; constant -7"))),
                new Section("Like Terms", "Like terms have the same variable raised to the same power. Combine by adding coefficients.",
                    List.of(new WorkedExample("Simplify: 4x + 2y + 3x - y.", List.of("Combine x terms: 4x+3x=7x", "Combine y terms: 2y-y=y"), "7x + y")))
            ),
            List.of("A coefficient is the number in front of a variable", "Like terms have identical variable parts", "Constants are terms without variables")));

        // Lesson 32
        list.add(new LessonContent("lesson-32-writing-evaluating", "Writing and Evaluating Expressions", "✏️",
            "Translate words into algebraic expressions and evaluate them for given values.",
            List.of(
                new Section("Translating Words", "Key phrases: 'sum' means +, 'difference' means -, 'product' means ×, 'quotient' means ÷.",
                    List.of(new WorkedExample("Write an expression for 'five more than twice a number n'.", List.of("Twice a number: 2n", "Five more than: 2n + 5"), "2n + 5"))),
                new Section("Evaluating Expressions", "Substitute the given value for the variable and simplify using order of operations.",
                    List.of(new WorkedExample("Evaluate 3x² - 2x + 1 when x = 4.", List.of("Substitute: 3(4²) - 2(4) + 1", "3(16) - 8 + 1 = 48 - 8 + 1"), "41")))
            ),
            List.of("'More than' and 'increased by' mean addition", "'Less than' and 'decreased by' mean subtraction", "Substitute carefully and follow order of operations")));

        // Lesson 33
        list.add(new LessonContent("lesson-33-properties", "Properties of Operations", "🏛️",
            "Apply commutative, associative, distributive, and identity properties.",
            List.of(
                new Section("Commutative and Associative", "Commutative: order doesn't matter (a+b=b+a). Associative: grouping doesn't matter ((a+b)+c=a+(b+c)).",
                    List.of(new WorkedExample("Use properties to simplify: 7 + 13 + 3.", List.of("Commutative: rearrange as 7+3+13", "Associative: (7+3)+13 = 10+13"), "23"))),
                new Section("Distributive Property", "a(b+c) = ab + ac. Multiply the outside term by each term inside.",
                    List.of(new WorkedExample("Expand: 4(x + 3).", List.of("Distribute 4: 4·x + 4·3", "4x + 12"), "4x + 12")))
            ),
            List.of("Commutative: a+b=b+a and a×b=b×a", "Associative: (a+b)+c=a+(b+c)", "Distributive: a(b+c)=ab+ac")));

        // Lesson 34
        list.add(new LessonContent("lesson-34-one-step-equations", "Solving One-Step Equations", "🎯",
            "Solve equations using inverse operations in one step.",
            List.of(
                new Section("Addition and Subtraction Equations", "Use the inverse operation to isolate the variable.",
                    List.of(new WorkedExample("Solve: x + 7 = 15.", List.of("Subtract 7 from both sides", "x = 15 - 7 = 8"), "x = 8"))),
                new Section("Multiplication and Division Equations", "Divide to undo multiplication; multiply to undo division.",
                    List.of(new WorkedExample("Solve: 5x = 35.", List.of("Divide both sides by 5", "x = 35 ÷ 5 = 7"), "x = 7")))
            ),
            List.of("Do the same operation to both sides", "Addition undoes subtraction and vice versa", "Multiplication undoes division and vice versa")));

        // Lesson 35
        list.add(new LessonContent("lesson-35-two-step-equations", "Solving Two-Step Equations", "2️⃣",
            "Solve equations that require two inverse operations.",
            List.of(
                new Section("Two-Step Process", "First undo addition/subtraction, then undo multiplication/division.",
                    List.of(new WorkedExample("Solve: 3x + 5 = 20.", List.of("Subtract 5: 3x = 15", "Divide by 3: x = 5"), "x = 5"))),
                new Section("Variables with Subtraction", "Handle negative terms carefully.",
                    List.of(new WorkedExample("Solve: x/4 - 3 = 2.", List.of("Add 3: x/4 = 5", "Multiply by 4: x = 20"), "x = 20")))
            ),
            List.of("Undo operations in reverse order of PEMDAS", "Undo addition/subtraction first, then multiplication/division", "Always check by substituting back")));

        // Lesson 36
        list.add(new LessonContent("lesson-36-variables-both-sides", "Solving Equations with Variables on Both Sides", "↔️",
            "Move variable terms to one side and constants to the other.",
            List.of(
                new Section("Collecting Variables", "Subtract the smaller variable term from both sides to get variables on one side.",
                    List.of(new WorkedExample("Solve: 5x + 3 = 2x + 12.", List.of("Subtract 2x: 3x + 3 = 12", "Subtract 3: 3x = 9", "Divide by 3: x = 3"), "x = 3"))),
                new Section("Special Cases", "If variables cancel and you get a true statement, there are infinite solutions. A false statement means no solution.",
                    List.of(new WorkedExample("Solve: 2x + 4 = 2x + 7.", List.of("Subtract 2x: 4 = 7", "This is false"), "No solution")))
            ),
            List.of("Get all variable terms on one side", "Get all constants on the other side", "If variables cancel: true statement = infinite solutions, false = no solution")));

        // Lesson 37
        list.add(new LessonContent("lesson-37-inequalities", "Inequalities", "📐",
            "Write and solve one-step inequalities.",
            List.of(
                new Section("Writing Inequalities", "Use <, >, ≤, ≥ to show relationships. 'At least' means ≥, 'at most' means ≤.",
                    List.of(new WorkedExample("Solve: x + 4 > 10.", List.of("Subtract 4 from both sides", "x > 6"), "x > 6"))),
                new Section("Multiplying by Negatives", "When you multiply or divide by a negative number, flip the inequality sign.",
                    List.of(new WorkedExample("Solve: -3x ≤ 12.", List.of("Divide by -3 (flip the sign)", "x ≥ -4"), "x ≥ -4")))
            ),
            List.of("Solving inequalities is like solving equations", "Flip the sign when multiplying/dividing by a negative", "Solutions are a range of values, not a single number")));

        // Lesson 38
        list.add(new LessonContent("lesson-38-graphing-inequalities", "Graphing Inequalities", "📊",
            "Graph solutions of inequalities on a number line.",
            List.of(
                new Section("Number Line Graphs", "Use an open circle for < or > and a closed circle for ≤ or ≥. Shade in the direction of solutions.",
                    List.of(new WorkedExample("Graph x > 3 on a number line.", List.of("Open circle at 3 (not included)", "Shade to the right (values greater than 3)"), "Open circle at 3, arrow right"))),
                new Section("Compound Inequalities", "AND means both conditions must be true (between). OR means at least one is true.",
                    List.of(new WorkedExample("Graph -2 ≤ x < 5.", List.of("Closed circle at -2 (included)", "Open circle at 5 (not included)", "Shade between -2 and 5"), "Closed at -2, open at 5, shaded between")))
            ),
            List.of("Open circle = not included (< or >)", "Closed circle = included (≤ or ≥)", "Shade toward the solutions")));

        // Lesson 39
        list.add(new LessonContent("lesson-39-word-problems-equations", "Writing Equations from Word Problems", "📝",
            "Translate real-world situations into algebraic equations and solve.",
            List.of(
                new Section("Identifying the Variable", "Define what the variable represents, then translate the words into an equation.",
                    List.of(new WorkedExample("A number doubled and increased by 5 equals 17. Find the number.", List.of("Let n = the number", "Equation: 2n + 5 = 17", "Solve: 2n=12, n=6"), "n = 6"))),
                new Section("Age and Money Problems", "Set up equations based on relationships described in the problem.",
                    List.of(new WorkedExample("Sam has 3 times as many coins as Tom. Together they have 24. How many does Tom have?", List.of("Let t = Tom's coins, Sam has 3t", "t + 3t = 24 → 4t = 24", "t = 6"), "Tom has 6 coins")))
            ),
            List.of("Define your variable clearly", "Translate key phrases into operations", "Check your answer in the original problem context")));

        // Lesson 40
        list.add(new LessonContent("lesson-40-formulas", "Formulas and Literal Equations", "📐",
            "Use formulas and solve for a specific variable in a multi-variable equation.",
            List.of(
                new Section("Using Formulas", "Substitute known values into a formula and solve for the unknown.",
                    List.of(new WorkedExample("Find the area of a triangle with base 10 and height 6 using A = ½bh.", List.of("Substitute: A = ½(10)(6)", "A = ½(60) = 30"), "30 square units"))),
                new Section("Solving for a Variable", "Rearrange the formula to isolate the desired variable.",
                    List.of(new WorkedExample("Solve d = rt for t.", List.of("Divide both sides by r", "t = d/r"), "t = d/r")))
            ),
            List.of("A formula shows the relationship between variables", "Substitute known values and solve for the unknown", "You can rearrange formulas using inverse operations")));

        return list;
    }


    // ═══════════════════════════════════════════════════════════════════════════════
    // LESSONS 41–60: Coordinate Plane, Linear Equations, Functions, Geometry Basics
    // ═══════════════════════════════════════════════════════════════════════════════
    private List<LessonContent> buildLessons41to60() {
        List<LessonContent> list = new ArrayList<>();

        // Lesson 41
        list.add(new LessonContent("lesson-41-coordinate-plane", "The Coordinate Plane", "📍",
            "Plot and identify points using ordered pairs (x, y) on the coordinate plane.",
            List.of(
                new Section("Ordered Pairs", "The first number is the x-coordinate (horizontal), the second is the y-coordinate (vertical).",
                    "<svg width=\"260\" height=\"260\" viewBox=\"0 0 260 260\"><line x1=\"130\" y1=\"10\" x2=\"130\" y2=\"250\" stroke=\"#374151\" stroke-width=\"1.5\"/><line x1=\"10\" y1=\"130\" x2=\"250\" y2=\"130\" stroke=\"#374151\" stroke-width=\"1.5\"/><polygon points=\"130,10 125,20 135,20\" fill=\"#374151\"/><polygon points=\"250,130 240,125 240,135\" fill=\"#374151\"/><text x=\"252\" y=\"135\" font-size=\"11\" fill=\"#374151\">x</text><text x=\"133\" y=\"12\" font-size=\"11\" fill=\"#374151\">y</text><text x=\"45\" y=\"50\" font-size=\"11\" fill=\"#6b7280\">II (-,+)</text><text x=\"175\" y=\"50\" font-size=\"11\" fill=\"#6b7280\">I (+,+)</text><text x=\"45\" y=\"210\" font-size=\"11\" fill=\"#6b7280\">III (-,-)</text><text x=\"175\" y=\"210\" font-size=\"11\" fill=\"#6b7280\">IV (+,-)</text><circle cx=\"190\" cy=\"170\" r=\"6\" fill=\"#dc2626\"/><text x=\"198\" y=\"175\" font-size=\"11\" font-weight=\"bold\" fill=\"#dc2626\">(3,-2)</text><circle cx=\"50\" cy=\"50\" r=\"6\" fill=\"#4f46e5\"/><text x=\"58\" y=\"45\" font-size=\"11\" font-weight=\"bold\" fill=\"#4f46e5\">(-4,5)</text></svg>",
                    List.of(new WorkedExample("Plot the point (3, -2).", List.of("Move 3 units right from the origin", "Move 2 units down"), "(3, -2) is in Quadrant IV"))),
                new Section("Quadrants", "The axes divide the plane into four quadrants: I (+,+), II (-,+), III (-,-), IV (+,-).",
                    List.of(new WorkedExample("In which quadrant is (-4, 5)?", List.of("x is negative, y is positive", "Negative x, positive y = Quadrant II"), "Quadrant II")))
            ),
            List.of("The origin is (0, 0)", "x-coordinate: left/right; y-coordinate: up/down", "Points on an axis are not in any quadrant")));

        // Lesson 42
        list.add(new LessonContent("lesson-42-graphing-linear", "Graphing Linear Equations", "📈",
            "Graph linear equations by plotting points or using intercepts.",
            List.of(
                new Section("Using a Table of Values", "Choose x-values, calculate y-values, plot the points, and draw the line.",
                    List.of(new WorkedExample("Graph y = 2x - 1.", List.of("x=0: y=-1; x=1: y=1; x=2: y=3", "Plot (0,-1), (1,1), (2,3)", "Connect with a straight line"), "A line through (0,-1), (1,1), (2,3)"))),
                new Section("Using Intercepts", "Set y=0 to find x-intercept; set x=0 to find y-intercept.",
                    List.of(new WorkedExample("Find the intercepts of 3x + 2y = 6.", List.of("x-intercept: set y=0 → 3x=6 → x=2", "y-intercept: set x=0 → 2y=6 → y=3"), "x-int: (2,0), y-int: (0,3)")))
            ),
            List.of("A linear equation graphs as a straight line", "Two points determine a line", "Intercepts are where the line crosses the axes")));

        // Lesson 43
        list.add(new LessonContent("lesson-43-slope", "Slope", "⛰️",
            "Calculate the slope of a line as rise over run.",
            List.of(
                new Section("Finding Slope from Two Points", "Slope m = (y₂-y₁)/(x₂-x₁), which measures steepness and direction.",
                    List.of(new WorkedExample("Find the slope between (1, 2) and (4, 8).", List.of("Rise: 8-2=6", "Run: 4-1=3", "Slope = 6/3 = 2"), "m = 2"))),
                new Section("Types of Slope", "Positive slope rises left to right. Negative slope falls. Zero slope is horizontal. Undefined slope is vertical.",
                    List.of(new WorkedExample("Find the slope between (2, 5) and (2, 9).", List.of("Rise: 9-5=4", "Run: 2-2=0", "Division by zero"), "Undefined (vertical line)")))
            ),
            List.of("Slope = rise/run = (y₂-y₁)/(x₂-x₁)", "Positive slope goes up, negative goes down", "Horizontal lines have slope 0; vertical lines have undefined slope")));

        // Lesson 44
        list.add(new LessonContent("lesson-44-slope-intercept", "Slope-Intercept Form", "📐",
            "Write and interpret equations in y = mx + b form.",
            List.of(
                new Section("Identifying m and b", "In y = mx + b, m is the slope and b is the y-intercept.",
                    List.of(new WorkedExample("Identify the slope and y-intercept of y = -3x + 7.", List.of("m = -3 (slope)", "b = 7 (y-intercept)"), "Slope: -3, y-intercept: 7"))),
                new Section("Writing from Graph", "Find the y-intercept (where line crosses y-axis) and count rise/run for slope.",
                    List.of(new WorkedExample("A line crosses the y-axis at (0, 2) and passes through (3, 5). Write its equation.", List.of("b = 2", "Slope: (5-2)/(3-0) = 3/3 = 1"), "y = x + 2")))
            ),
            List.of("y = mx + b: m is slope, b is y-intercept", "The y-intercept is where x = 0", "Parallel lines have the same slope")));

        // Lesson 45
        list.add(new LessonContent("lesson-45-writing-linear", "Writing Linear Equations", "✍️",
            "Write the equation of a line given slope and a point, or two points.",
            List.of(
                new Section("Given Slope and a Point", "Use y = mx + b, substitute the point to find b.",
                    List.of(new WorkedExample("Write the equation with slope 2 through (1, 5).", List.of("y = 2x + b", "5 = 2(1) + b → b = 3"), "y = 2x + 3"))),
                new Section("Given Two Points", "First find the slope, then use one point to find b.",
                    List.of(new WorkedExample("Write the equation through (2, 3) and (4, 7).", List.of("Slope: (7-3)/(4-2) = 4/2 = 2", "3 = 2(2) + b → b = -1"), "y = 2x - 1")))
            ),
            List.of("Find slope first, then find b using a point", "Point-slope form: y - y₁ = m(x - x₁)", "Verify by checking that both points satisfy the equation")));

        // Lesson 46
        list.add(new LessonContent("lesson-46-direct-variation", "Direct Variation", "📏",
            "Identify and write direct variation equations of the form y = kx.",
            List.of(
                new Section("Identifying Direct Variation", "y varies directly with x if y = kx (the ratio y/x is constant).",
                    List.of(new WorkedExample("Does the table show direct variation? (1,3), (2,6), (3,9).", List.of("y/x: 3/1=3, 6/2=3, 9/3=3", "Constant ratio k=3"), "Yes, y = 3x"))),
                new Section("Solving Direct Variation Problems", "Find k from one pair, then use y = kx to find unknowns.",
                    List.of(new WorkedExample("If y varies directly with x and y=12 when x=4, find y when x=7.", List.of("k = y/x = 12/4 = 3", "y = 3(7) = 21"), "y = 21")))
            ),
            List.of("Direct variation: y = kx, where k is the constant of variation", "The graph passes through the origin", "k = y/x for any point on the line")));

        // Lesson 47
        list.add(new LessonContent("lesson-47-functions", "Functions and Relations", "🔀",
            "Determine if a relation is a function using the vertical line test.",
            List.of(
                new Section("What is a Function?", "A function assigns exactly one output (y) to each input (x). No x-value repeats with different y-values.",
                    List.of(new WorkedExample("Is {(1,2), (3,4), (1,5)} a function?", List.of("x=1 maps to both y=2 and y=5", "One input has two outputs"), "Not a function"))),
                new Section("Function Notation", "f(x) means the output of function f for input x. Read as 'f of x'.",
                    List.of(new WorkedExample("If f(x) = 2x + 3, find f(4).", List.of("Substitute x=4: 2(4)+3", "8+3=11"), "f(4) = 11")))
            ),
            List.of("A function has exactly one output for each input", "Vertical line test: if any vertical line hits the graph twice, it's not a function", "f(x) is another way to write y")));

        // Lesson 48
        list.add(new LessonContent("lesson-48-patterns-sequences", "Patterns and Sequences", "🔢",
            "Identify and extend number patterns and sequences.",
            List.of(
                new Section("Finding Patterns", "Look for a common difference (adding) or common ratio (multiplying) between terms.",
                    List.of(new WorkedExample("Find the next two terms: 3, 7, 11, 15, ...", List.of("Common difference: 7-3=4", "Next terms: 15+4=19, 19+4=23"), "19, 23"))),
                new Section("Writing Rules", "Express the pattern as a formula using the term number n.",
                    List.of(new WorkedExample("Write a rule for: 5, 8, 11, 14, ...", List.of("First term: 5, common difference: 3", "Rule: aₙ = 5 + 3(n-1) = 3n + 2"), "aₙ = 3n + 2")))
            ),
            List.of("Look for what changes between consecutive terms", "Arithmetic patterns have a constant difference", "Geometric patterns have a constant ratio")));

        // Lesson 49
        list.add(new LessonContent("lesson-49-arithmetic-sequences", "Arithmetic Sequences", "➕",
            "Find terms and write formulas for arithmetic sequences.",
            List.of(
                new Section("The nth Term Formula", "aₙ = a₁ + (n-1)d, where a₁ is the first term and d is the common difference.",
                    List.of(new WorkedExample("Find the 20th term of 4, 9, 14, 19, ...", List.of("a₁=4, d=5", "a₂₀ = 4 + (20-1)(5) = 4 + 95"), "99"))),
                new Section("Finding Missing Terms", "Use the formula to find any term or determine d.",
                    List.of(new WorkedExample("An arithmetic sequence has a₁=3 and a₅=19. Find d.", List.of("a₅ = a₁ + 4d", "19 = 3 + 4d → 4d = 16 → d = 4"), "d = 4")))
            ),
            List.of("Common difference d = any term minus the previous term", "Formula: aₙ = a₁ + (n-1)d", "Arithmetic sequences graph as a straight line")));

        // Lesson 50
        list.add(new LessonContent("lesson-50-geometric-sequences", "Geometric Sequences", "✖️",
            "Find terms and write formulas for geometric sequences.",
            List.of(
                new Section("The nth Term Formula", "aₙ = a₁ × rⁿ⁻¹, where a₁ is the first term and r is the common ratio.",
                    List.of(new WorkedExample("Find the 5th term of 2, 6, 18, 54, ...", List.of("a₁=2, r=3", "a₅ = 2 × 3⁴ = 2 × 81"), "162"))),
                new Section("Finding the Common Ratio", "Divide any term by the previous term to find r.",
                    List.of(new WorkedExample("Find r for the sequence 100, 50, 25, 12.5, ...", List.of("r = 50/100 = 0.5", "Check: 25/50 = 0.5 ✓"), "r = 0.5")))
            ),
            List.of("Common ratio r = any term ÷ previous term", "Formula: aₙ = a₁ × rⁿ⁻¹", "Geometric sequences grow (or shrink) by multiplication")));

        // Lesson 51
        list.add(new LessonContent("lesson-51-angles-lines", "Angles and Lines", "📐",
            "Classify angles and identify relationships between angles formed by intersecting lines.",
            List.of(
                new Section("Types of Angles", "Acute (<90°), right (=90°), obtuse (>90° and <180°), straight (=180°).",
                    "<svg width=\"400\" height=\"150\" viewBox=\"0 0 400 150\"><line x1=\"50\" y1=\"120\" x2=\"180\" y2=\"120\" stroke=\"#4f46e5\" stroke-width=\"2\"/><line x1=\"50\" y1=\"120\" x2=\"120\" y2=\"40\" stroke=\"#4f46e5\" stroke-width=\"2\"/><path d=\"M 80 120 A 30 30 0 0 1 72 95\" fill=\"none\" stroke=\"#f59e0b\" stroke-width=\"2\"/><text x=\"85\" y=\"105\" font-size=\"12\" fill=\"#f59e0b\">45° Acute</text><line x1=\"220\" y1=\"120\" x2=\"350\" y2=\"120\" stroke=\"#16a34a\" stroke-width=\"2\"/><line x1=\"220\" y1=\"120\" x2=\"220\" y2=\"30\" stroke=\"#16a34a\" stroke-width=\"2\"/><rect x=\"220\" y=\"100\" width=\"15\" height=\"15\" fill=\"none\" stroke=\"#16a34a\" stroke-width=\"1.5\"/><text x=\"240\" y=\"75\" font-size=\"12\" fill=\"#16a34a\">90° Right</text></svg>",
                    List.of(new WorkedExample("Classify an angle measuring 135°.", List.of("135° is greater than 90° but less than 180°"), "Obtuse angle"))),
                new Section("Angle Relationships", "Complementary angles sum to 90°. Supplementary angles sum to 180°. Vertical angles are equal.",
                    "<svg width=\"350\" height=\"120\" viewBox=\"0 0 350 120\"><line x1=\"20\" y1=\"100\" x2=\"160\" y2=\"100\" stroke=\"#4f46e5\" stroke-width=\"2\"/><line x1=\"20\" y1=\"100\" x2=\"100\" y2=\"30\" stroke=\"#dc2626\" stroke-width=\"2\"/><line x1=\"100\" y1=\"30\" x2=\"160\" y2=\"100\" stroke=\"#16a34a\" stroke-width=\"2\"/><text x=\"45\" y=\"90\" font-size=\"11\" fill=\"#4f46e5\">55°</text><text x=\"100\" y=\"90\" font-size=\"11\" fill=\"#16a34a\">35°</text><text x=\"55\" y=\"115\" font-size=\"11\" fill=\"#6b7280\">Complementary: 55°+35°=90°</text><line x1=\"200\" y1=\"60\" x2=\"340\" y2=\"60\" stroke=\"#4f46e5\" stroke-width=\"2\"/><line x1=\"270\" y1=\"60\" x2=\"230\" y2=\"10\" stroke=\"#dc2626\" stroke-width=\"2\"/><text x=\"235\" y=\"55\" font-size=\"11\" fill=\"#dc2626\">120°</text><text x=\"280\" y=\"55\" font-size=\"11\" fill=\"#4f46e5\">60°</text><text x=\"220\" y=\"80\" font-size=\"11\" fill=\"#6b7280\">Supplementary: 120°+60°=180°</text></svg>",
                    List.of(new WorkedExample("Two angles are supplementary. One is 65°. Find the other.", List.of("Supplementary sum to 180°", "180° - 65° = 115°"), "115°")))
            ),
            List.of("Complementary angles add to 90°", "Supplementary angles add to 180°", "Vertical angles are always equal")));

        // Lesson 52
        list.add(new LessonContent("lesson-52-parallel-transversals", "Parallel Lines and Transversals", "↗️",
            "Identify angle pairs formed when a transversal crosses parallel lines.",
            List.of(
                new Section("Angle Pairs", "Corresponding angles are equal. Alternate interior angles are equal. Co-interior angles sum to 180°.",
                    List.of(new WorkedExample("A transversal crosses parallel lines. One angle is 70°. Find its alternate interior angle.", List.of("Alternate interior angles are equal", "The angle is 70°"), "70°"))),
                new Section("Finding Unknown Angles", "Use angle relationships to find missing angles.",
                    List.of(new WorkedExample("Corresponding angles: one is 3x+10 and the other is 55°. Find x.", List.of("Corresponding angles are equal: 3x+10=55", "3x=45, x=15"), "x = 15")))
            ),
            List.of("Corresponding angles are in the same position at each intersection", "Alternate interior angles are on opposite sides of the transversal", "Co-interior (same-side interior) angles are supplementary")));

        // Lesson 53
        list.add(new LessonContent("lesson-53-triangles", "Triangles: Angles and Classification", "🔺",
            "Classify triangles by sides and angles, and use the angle sum property.",
            List.of(
                new Section("Triangle Angle Sum", "The three interior angles of any triangle always sum to 180°.",
                    "<svg width=\"300\" height=\"180\" viewBox=\"0 0 300 180\"><polygon points=\"150,20 50,160 250,160\" fill=\"none\" stroke=\"#4f46e5\" stroke-width=\"2.5\"/><text x=\"135\" y=\"15\" font-size=\"12\" fill=\"#dc2626\">70°</text><text x=\"30\" y=\"170\" font-size=\"12\" fill=\"#16a34a\">45°</text><text x=\"240\" y=\"170\" font-size=\"12\" fill=\"#f59e0b\">65°</text><text x=\"100\" y=\"178\" font-size=\"11\" fill=\"#6b7280\">45° + 65° + 70° = 180°</text></svg>",
                    List.of(new WorkedExample("A triangle has angles of 45° and 65°. Find the third angle.", List.of("Sum = 180°", "Third angle = 180° - 45° - 65° = 70°"), "70°"))),
                new Section("Classifying Triangles", "By sides: equilateral (all equal), isosceles (two equal), scalene (none equal). By angles: acute, right, obtuse.",
                    "<svg width=\"400\" height=\"140\" viewBox=\"0 0 400 140\"><polygon points=\"60,20 20,120 100,120\" fill=\"none\" stroke=\"#16a34a\" stroke-width=\"2\"/><text x=\"35\" y=\"135\" font-size=\"10\" fill=\"#16a34a\">Equilateral</text><polygon points=\"200,20 160,120 240,120\" fill=\"none\" stroke=\"#4f46e5\" stroke-width=\"2\"/><text x=\"175\" y=\"135\" font-size=\"10\" fill=\"#4f46e5\">Isosceles</text><polygon points=\"320,40 290,120 380,120\" fill=\"none\" stroke=\"#dc2626\" stroke-width=\"2\"/><text x=\"310\" y=\"135\" font-size=\"10\" fill=\"#dc2626\">Scalene</text></svg>",
                    List.of(new WorkedExample("Classify a triangle with sides 5, 5, 8 and angles 51°, 51°, 78°.", List.of("Two equal sides → isosceles", "All angles less than 90° → acute"), "Acute isosceles")))
            ),
            List.of("Angles in a triangle sum to 180°", "Equilateral triangles have three 60° angles", "The longest side is opposite the largest angle")));

        // Lesson 54
        list.add(new LessonContent("lesson-54-congruent-triangles", "Congruent Triangles", "🔷",
            "Identify congruent triangles using SSS, SAS, ASA, and AAS criteria.",
            List.of(
                new Section("Congruence Criteria", "Two triangles are congruent if they have the same shape and size. Use SSS, SAS, ASA, or AAS to prove congruence.",
                    List.of(new WorkedExample("Triangle ABC has AB=5, BC=7, AC=6. Triangle DEF has DE=5, EF=7, DF=6. Are they congruent?", List.of("All three sides are equal (SSS)", "AB=DE, BC=EF, AC=DF"), "Yes, by SSS"))),
                new Section("Corresponding Parts", "Corresponding parts of congruent triangles are congruent (CPCTC).",
                    List.of(new WorkedExample("If △ABC ≅ △XYZ and angle A = 40°, what is angle X?", List.of("Corresponding parts are congruent", "Angle X corresponds to angle A"), "40°")))
            ),
            List.of("SSS: three sides equal", "SAS: two sides and included angle equal", "ASA: two angles and included side equal")));

        // Lesson 55
        list.add(new LessonContent("lesson-55-similar-triangles", "Similar Triangles", "🔍",
            "Identify similar triangles and use proportions to find missing sides.",
            List.of(
                new Section("Similarity", "Similar triangles have equal angles and proportional sides.",
                    List.of(new WorkedExample("Triangle ABC ~ Triangle DEF. AB=6, DE=9, BC=8. Find EF.", List.of("Scale factor: 9/6 = 3/2", "EF = 8 × 3/2 = 12"), "EF = 12"))),
                new Section("AA Similarity", "If two angles of one triangle equal two angles of another, the triangles are similar.",
                    List.of(new WorkedExample("Triangle 1 has angles 50° and 60°. Triangle 2 has angles 50° and 70°. Are they similar?", List.of("Triangle 1 third angle: 180-50-60=70°", "Triangle 2 third angle: 180-50-70=60°", "Both have 50°, 60°, 70°"), "Yes, by AA similarity")))
            ),
            List.of("Similar triangles have the same shape but may differ in size", "Corresponding sides are proportional", "AA: two equal angles guarantee similarity")));

        // Lesson 56
        list.add(new LessonContent("lesson-56-pythagorean-theorem", "The Pythagorean Theorem", "📐",
            "Use a² + b² = c² to find missing sides of right triangles.",
            List.of(
                new Section("Finding the Hypotenuse", "The hypotenuse c is the longest side, opposite the right angle: c² = a² + b².",
                    "<svg width=\"250\" height=\"200\" viewBox=\"0 0 250 200\"><polygon points=\"40,170 40,40 200,170\" fill=\"#eef2ff\" stroke=\"#4f46e5\" stroke-width=\"2.5\"/><rect x=\"40\" y=\"150\" width=\"18\" height=\"18\" fill=\"none\" stroke=\"#4f46e5\" stroke-width=\"1.5\"/><text x=\"15\" y=\"110\" font-size=\"14\" font-weight=\"bold\" fill=\"#16a34a\">a=3</text><text x=\"100\" y=\"190\" font-size=\"14\" font-weight=\"bold\" fill=\"#16a34a\">b=4</text><text x=\"120\" y=\"95\" font-size=\"14\" font-weight=\"bold\" fill=\"#dc2626\">c=5</text><text x=\"50\" y=\"30\" font-size=\"11\" fill=\"#6b7280\">a² + b² = c²</text><text x=\"50\" y=\"45\" font-size=\"11\" fill=\"#6b7280\">9 + 16 = 25</text></svg>",
                    List.of(new WorkedExample("Find the hypotenuse of a right triangle with legs 3 and 4.", List.of("c² = 3² + 4² = 9 + 16 = 25", "c = √25 = 5"), "c = 5"))),
                new Section("Finding a Leg", "Rearrange: a² = c² - b².",
                    "<svg width=\"280\" height=\"180\" viewBox=\"0 0 280 180\"><polygon points=\"40,150 40,30 230,150\" fill=\"#f0fdf4\" stroke=\"#16a34a\" stroke-width=\"2.5\"/><rect x=\"40\" y=\"130\" width=\"18\" height=\"18\" fill=\"none\" stroke=\"#16a34a\" stroke-width=\"1.5\"/><text x=\"10\" y=\"95\" font-size=\"14\" font-weight=\"bold\" fill=\"#dc2626\">a=?</text><text x=\"110\" y=\"170\" font-size=\"14\" font-weight=\"bold\" fill=\"#16a34a\">b=5</text><text x=\"140\" y=\"80\" font-size=\"14\" font-weight=\"bold\" fill=\"#4f46e5\">c=13</text><text x=\"60\" y=\"25\" font-size=\"11\" fill=\"#6b7280\">a² = c² - b² = 169 - 25 = 144 → a = 12</text></svg>",
                    List.of(new WorkedExample("A right triangle has hypotenuse 13 and one leg 5. Find the other leg.", List.of("a² = 13² - 5² = 169 - 25 = 144", "a = √144 = 12"), "a = 12")))
            ),
            List.of("Only works for right triangles", "The hypotenuse is always the longest side", "Common Pythagorean triples: 3-4-5, 5-12-13, 8-15-17")));

        // Lesson 57
        list.add(new LessonContent("lesson-57-quadrilaterals", "Quadrilaterals", "⬜",
            "Classify quadrilaterals by their properties: sides, angles, and diagonals.",
            List.of(
                new Section("Types of Quadrilaterals", "Parallelogram, rectangle, rhombus, square, trapezoid, and kite each have specific properties.",
                    List.of(new WorkedExample("A quadrilateral has 4 right angles and 4 equal sides. What is it?", List.of("4 right angles → rectangle", "4 equal sides → rhombus", "Both → square"), "Square"))),
                new Section("Angle Sum", "The interior angles of any quadrilateral sum to 360°.",
                    List.of(new WorkedExample("Three angles of a quadrilateral are 90°, 80°, and 110°. Find the fourth.", List.of("Sum = 360°", "Fourth = 360 - 90 - 80 - 110 = 80°"), "80°")))
            ),
            List.of("Quadrilateral angles sum to 360°", "A square is both a rectangle and a rhombus", "Opposite angles of a parallelogram are equal")));

        // Lesson 58
        list.add(new LessonContent("lesson-58-polygons-angles", "Polygons and Interior Angles", "⬡",
            "Find the sum of interior angles and each angle of regular polygons.",
            List.of(
                new Section("Interior Angle Sum", "Sum = (n-2) × 180°, where n is the number of sides.",
                    List.of(new WorkedExample("Find the sum of interior angles of a hexagon.", List.of("n = 6", "Sum = (6-2) × 180° = 4 × 180° = 720°"), "720°"))),
                new Section("Regular Polygons", "In a regular polygon, all angles are equal: each angle = sum ÷ n.",
                    List.of(new WorkedExample("Find each interior angle of a regular pentagon.", List.of("Sum = (5-2) × 180° = 540°", "Each angle = 540° ÷ 5 = 108°"), "108°")))
            ),
            List.of("Interior angle sum = (n-2) × 180°", "Each angle of a regular polygon = (n-2)×180°/n", "Exterior angles of any polygon sum to 360°")));

        // Lesson 59
        list.add(new LessonContent("lesson-59-perimeter-circumference", "Perimeter and Circumference", "⭕",
            "Calculate the perimeter of polygons and the circumference of circles.",
            List.of(
                new Section("Perimeter", "Perimeter is the total distance around a shape. Add all side lengths.",
                    "<svg width=\"200\" height=\"140\" viewBox=\"0 0 200 140\"><rect x=\"30\" y=\"20\" width=\"140\" height=\"90\" fill=\"#eef2ff\" stroke=\"#4f46e5\" stroke-width=\"2.5\"/><text x=\"80\" y=\"15\" font-size=\"12\" font-weight=\"bold\" fill=\"#4f46e5\">8</text><text x=\"175\" y=\"70\" font-size=\"12\" font-weight=\"bold\" fill=\"#4f46e5\">5</text><text x=\"80\" y=\"125\" font-size=\"12\" font-weight=\"bold\" fill=\"#4f46e5\">8</text><text x=\"10\" y=\"70\" font-size=\"12\" font-weight=\"bold\" fill=\"#4f46e5\">5</text></svg>",
                    List.of(new WorkedExample("Find the perimeter of a rectangle with length 8 and width 5.", List.of("P = 2l + 2w", "P = 2(8) + 2(5) = 16 + 10"), "26 units"))),
                new Section("Circumference", "C = πd or C = 2πr, where d is diameter and r is radius.",
                    "<svg width=\"200\" height=\"200\" viewBox=\"0 0 200 200\"><circle cx=\"100\" cy=\"100\" r=\"70\" fill=\"#f0fdf4\" stroke=\"#16a34a\" stroke-width=\"2.5\"/><line x1=\"100\" y1=\"100\" x2=\"170\" y2=\"100\" stroke=\"#dc2626\" stroke-width=\"2\" stroke-dasharray=\"5,3\"/><circle cx=\"100\" cy=\"100\" r=\"3\" fill=\"#dc2626\"/><text x=\"120\" y=\"95\" font-size=\"12\" font-weight=\"bold\" fill=\"#dc2626\">r=7</text><text x=\"55\" y=\"185\" font-size=\"11\" fill=\"#6b7280\">C = 2πr = 43.96</text></svg>",
                    List.of(new WorkedExample("Find the circumference of a circle with radius 7. Use π ≈ 3.14.", List.of("C = 2πr = 2(3.14)(7)", "C = 43.96"), "43.96 units")))
            ),
            List.of("Perimeter = sum of all sides", "Circumference = πd = 2πr", "π ≈ 3.14 or 22/7")));

        // Lesson 60
        list.add(new LessonContent("lesson-60-area-polygons", "Area of Polygons", "📏",
            "Calculate the area of triangles, rectangles, parallelograms, and trapezoids.",
            List.of(
                new Section("Rectangles and Parallelograms", "Rectangle: A = lw. Parallelogram: A = bh (height is perpendicular to base).",
                    List.of(new WorkedExample("Find the area of a parallelogram with base 12 and height 5.", List.of("A = bh", "A = 12 × 5 = 60"), "60 square units"))),
                new Section("Triangles and Trapezoids", "Triangle: A = ½bh. Trapezoid: A = ½(b₁+b₂)h.",
                    List.of(new WorkedExample("Find the area of a trapezoid with bases 6 and 10, height 4.", List.of("A = ½(b₁+b₂)h", "A = ½(6+10)(4) = ½(16)(4) = 32"), "32 square units")))
            ),
            List.of("Area is measured in square units", "Height must be perpendicular to the base", "Triangle area is half the parallelogram area with same base and height")));

        return list;
    }


    // ═══════════════════════════════════════════════════════════════════════════════
    // LESSONS 61–80: Geometry (Area, Volume, Transformations), Statistics
    // ═══════════════════════════════════════════════════════════════════════════════
    private List<LessonContent> buildLessons61to80() {
        List<LessonContent> list = new ArrayList<>();

        // Lesson 61
        list.add(new LessonContent("lesson-61-area-circles", "Area of Circles", "⭕",
            "Calculate the area of a circle using A = πr².",
            List.of(
                new Section("Area Formula", "A = πr². Square the radius first, then multiply by π.",
                    "<svg width=\"220\" height=\"220\" viewBox=\"0 0 220 220\"><circle cx=\"110\" cy=\"110\" r=\"80\" fill=\"#ede9fe\" stroke=\"#7c3aed\" stroke-width=\"2.5\"/><line x1=\"110\" y1=\"110\" x2=\"190\" y2=\"110\" stroke=\"#dc2626\" stroke-width=\"2\"/><circle cx=\"110\" cy=\"110\" r=\"3\" fill=\"#dc2626\"/><text x=\"135\" y=\"105\" font-size=\"13\" font-weight=\"bold\" fill=\"#dc2626\">r = 5</text><text x=\"60\" y=\"205\" font-size=\"11\" fill=\"#6b7280\">A = πr² = 78.5</text><text x=\"60\" y=\"15\" font-size=\"12\" font-weight=\"bold\" fill=\"#7c3aed\">A = π × r²</text></svg>",
                    List.of(new WorkedExample("Find the area of a circle with radius 5. Use π ≈ 3.14.", List.of("A = πr² = 3.14 × 5²", "A = 3.14 × 25 = 78.5"), "78.5 square units"))),
                new Section("Given Diameter", "If given the diameter, divide by 2 to get the radius first.",
                    "<svg width=\"220\" height=\"220\" viewBox=\"0 0 220 220\"><circle cx=\"110\" cy=\"110\" r=\"80\" fill=\"#f0fdf4\" stroke=\"#16a34a\" stroke-width=\"2.5\"/><line x1=\"30\" y1=\"110\" x2=\"190\" y2=\"110\" stroke=\"#4f46e5\" stroke-width=\"2\" stroke-dasharray=\"6,3\"/><text x=\"85\" y=\"130\" font-size=\"13\" font-weight=\"bold\" fill=\"#4f46e5\">d = 12</text><text x=\"110\" y=\"90\" font-size=\"11\" fill=\"#dc2626\">r = 6</text><text x=\"55\" y=\"205\" font-size=\"11\" fill=\"#6b7280\">A = π(6²) = 113.04</text></svg>",
                    List.of(new WorkedExample("Find the area of a circle with diameter 12.", List.of("Radius = 12/2 = 6", "A = π(6²) = 36π ≈ 113.04"), "113.04 square units")))
            ),
            List.of("A = πr² (radius squared times pi)", "Always find the radius first if given diameter", "Area is in square units")));

        // Lesson 62
        list.add(new LessonContent("lesson-62-composite-figures", "Composite Figures", "🧩",
            "Find the area of figures made up of simpler shapes.",
            List.of(
                new Section("Breaking Apart Figures", "Divide a composite figure into rectangles, triangles, and circles. Find each area and add.",
                    List.of(new WorkedExample("Find the area of an L-shaped figure: a 10×4 rectangle with a 3×4 rectangle removed.", List.of("Full rectangle: 10×4=40", "Removed piece: 3×4=12", "Remaining: 40-12=28"), "28 square units"))),
                new Section("Adding Shapes", "Sometimes it's easier to add areas of simpler shapes together.",
                    List.of(new WorkedExample("A figure is a rectangle (8×5) with a semicircle (diameter 5) on one end.", List.of("Rectangle: 8×5=40", "Semicircle: ½π(2.5²)≈9.82", "Total ≈ 49.82"), "≈ 49.82 square units")))
            ),
            List.of("Break complex shapes into simpler ones", "Add areas for combined shapes, subtract for removed parts", "Be careful not to double-count overlapping regions")));

        // Lesson 63
        list.add(new LessonContent("lesson-63-surface-area-prisms", "Surface Area of Prisms", "📦",
            "Calculate the total surface area of rectangular and triangular prisms.",
            List.of(
                new Section("Rectangular Prisms", "SA = 2lw + 2lh + 2wh (sum of all six face areas).",
                    List.of(new WorkedExample("Find the surface area of a box: l=6, w=4, h=3.", List.of("SA = 2(6×4) + 2(6×3) + 2(4×3)", "SA = 48 + 36 + 24 = 108"), "108 square units"))),
                new Section("Triangular Prisms", "SA = 2(triangle area) + 3(rectangle areas). Find each face.",
                    List.of(new WorkedExample("A triangular prism has a base triangle with base 6, height 4, and the prism is 10 long. Triangle sides are 5, 5, 6.", List.of("2 triangles: 2×½(6)(4)=24", "3 rectangles: 5×10+5×10+6×10=160", "Total: 184"), "184 square units")))
            ),
            List.of("Surface area is the total area of all faces", "A prism has two identical bases and rectangular lateral faces", "Draw a net to visualize all faces")));

        // Lesson 64
        list.add(new LessonContent("lesson-64-surface-area-cylinders", "Surface Area of Cylinders", "🥫",
            "Calculate the surface area of a cylinder using SA = 2πr² + 2πrh.",
            List.of(
                new Section("Cylinder Surface Area", "Two circular bases plus the lateral surface (a rectangle when unrolled): SA = 2πr² + 2πrh.",
                    List.of(new WorkedExample("Find the surface area of a cylinder with r=3 and h=8.", List.of("Bases: 2π(3²) = 18π ≈ 56.52", "Lateral: 2π(3)(8) = 48π ≈ 150.72", "Total ≈ 207.24"), "≈ 207.24 square units"))),
                new Section("Lateral Surface Only", "Sometimes you only need the lateral (side) area: LA = 2πrh.",
                    List.of(new WorkedExample("Find the lateral area of a cylinder with r=5 and h=12.", List.of("LA = 2πrh = 2π(5)(12)", "LA = 120π ≈ 376.8"), "≈ 376.8 square units")))
            ),
            List.of("SA = 2πr² + 2πrh", "The lateral surface unrolls into a rectangle with width 2πr", "Lateral area alone = 2πrh")));

        // Lesson 65
        list.add(new LessonContent("lesson-65-sa-pyramids-cones", "Surface Area of Pyramids and Cones", "🔺",
            "Calculate the surface area of pyramids and cones using slant height.",
            List.of(
                new Section("Pyramids", "SA = base area + ½ × perimeter × slant height.",
                    List.of(new WorkedExample("Find the SA of a square pyramid: base side 6, slant height 5.", List.of("Base: 6²=36", "Lateral: ½(4×6)(5) = ½(24)(5)=60", "Total: 96"), "96 square units"))),
                new Section("Cones", "SA = πr² + πrl, where l is the slant height.",
                    List.of(new WorkedExample("Find the SA of a cone with r=4 and slant height 9.", List.of("Base: π(4²)=16π", "Lateral: π(4)(9)=36π", "Total: 52π ≈ 163.28"), "≈ 163.28 square units")))
            ),
            List.of("Slant height is the distance along the lateral face, not the vertical height", "Pyramid lateral area = ½ × perimeter × slant height", "Cone lateral area = πrl")));

        // Lesson 66
        list.add(new LessonContent("lesson-66-volume-prisms", "Volume of Prisms", "📦",
            "Calculate the volume of prisms using V = Bh (base area × height).",
            List.of(
                new Section("Rectangular Prisms", "V = lwh.",
                    List.of(new WorkedExample("Find the volume of a box: l=8, w=5, h=3.", List.of("V = lwh = 8×5×3", "V = 120"), "120 cubic units"))),
                new Section("Triangular Prisms", "V = (½ × base × height of triangle) × length of prism.",
                    List.of(new WorkedExample("Find the volume of a triangular prism: triangle base 6, triangle height 4, prism length 10.", List.of("Base area = ½(6)(4) = 12", "V = 12 × 10 = 120"), "120 cubic units")))
            ),
            List.of("Volume = Base area × height", "Volume is measured in cubic units", "Any face can be the 'base' as long as height is perpendicular to it")));

        // Lesson 67
        list.add(new LessonContent("lesson-67-volume-cylinders", "Volume of Cylinders", "🥫",
            "Calculate the volume of a cylinder using V = πr²h.",
            List.of(
                new Section("Cylinder Volume", "V = πr²h. Find the area of the circular base, then multiply by height.",
                    List.of(new WorkedExample("Find the volume of a cylinder with r=4 and h=10.", List.of("Base area = π(4²) = 16π", "V = 16π × 10 = 160π ≈ 502.4"), "≈ 502.4 cubic units"))),
                new Section("Working Backwards", "Given volume, solve for radius or height.",
                    List.of(new WorkedExample("A cylinder has volume 314 cm³ and radius 5. Find the height. (π≈3.14)", List.of("314 = 3.14 × 25 × h", "314 = 78.5h", "h = 4"), "h = 4 cm")))
            ),
            List.of("V = πr²h", "The base of a cylinder is a circle", "If given diameter, divide by 2 to get radius")));

        // Lesson 68
        list.add(new LessonContent("lesson-68-volume-pyramids-cones", "Volume of Pyramids and Cones", "🔺",
            "Calculate volumes using V = ⅓Bh for pyramids and V = ⅓πr²h for cones.",
            List.of(
                new Section("Pyramid Volume", "V = ⅓ × base area × height. A pyramid is ⅓ the volume of a prism with the same base and height.",
                    List.of(new WorkedExample("Find the volume of a square pyramid: base side 6, height 9.", List.of("Base area = 6² = 36", "V = ⅓(36)(9) = ⅓(324) = 108"), "108 cubic units"))),
                new Section("Cone Volume", "V = ⅓πr²h.",
                    List.of(new WorkedExample("Find the volume of a cone with r=3 and h=7.", List.of("V = ⅓π(3²)(7) = ⅓π(9)(7)", "V = ⅓(63π) = 21π ≈ 65.94"), "≈ 65.94 cubic units")))
            ),
            List.of("Pyramid/cone volume = ⅓ × corresponding prism/cylinder volume", "V(pyramid) = ⅓Bh", "V(cone) = ⅓πr²h")));

        // Lesson 69
        list.add(new LessonContent("lesson-69-volume-spheres", "Volume of Spheres", "🌍",
            "Calculate the volume of a sphere using V = 4/3 πr³.",
            List.of(
                new Section("Sphere Volume", "V = (4/3)πr³. Cube the radius, multiply by π, then by 4/3.",
                    List.of(new WorkedExample("Find the volume of a sphere with radius 6.", List.of("V = (4/3)π(6³) = (4/3)π(216)", "V = 288π ≈ 904.32"), "≈ 904.32 cubic units"))),
                new Section("Given Diameter", "Remember to halve the diameter to get the radius.",
                    List.of(new WorkedExample("A basketball has diameter 24 cm. Find its volume.", List.of("r = 12", "V = (4/3)π(12³) = (4/3)π(1728) = 2304π ≈ 7234.56"), "≈ 7234.56 cm³")))
            ),
            List.of("V = (4/3)πr³", "The radius is cubed (not squared)", "Surface area of a sphere = 4πr²")));

        // Lesson 70
        list.add(new LessonContent("lesson-70-translations", "Transformations: Translations", "➡️",
            "Slide figures on the coordinate plane without changing size or shape.",
            List.of(
                new Section("Translation Rules", "A translation moves every point the same distance and direction: (x,y) → (x+a, y+b).",
                    List.of(new WorkedExample("Translate point (3, 5) by (x+2, y-3).", List.of("New x: 3+2=5", "New y: 5-3=2"), "(5, 2)"))),
                new Section("Translating Shapes", "Apply the same rule to every vertex of the shape.",
                    List.of(new WorkedExample("Translate triangle with vertices (1,2), (4,2), (1,5) right 3 and up 1.", List.of("(1+3, 2+1)=(4,3)", "(4+3, 2+1)=(7,3)", "(1+3, 5+1)=(4,6)"), "(4,3), (7,3), (4,6)")))
            ),
            List.of("Translations preserve size and shape", "Every point moves the same distance and direction", "Written as (x,y) → (x+a, y+b)")));

        // Lesson 71
        list.add(new LessonContent("lesson-71-reflections", "Transformations: Reflections", "🪞",
            "Reflect figures across the x-axis, y-axis, or other lines.",
            List.of(
                new Section("Reflecting Across Axes", "Over x-axis: (x,y)→(x,-y). Over y-axis: (x,y)→(-x,y).",
                    List.of(new WorkedExample("Reflect (3, -4) over the x-axis.", List.of("Keep x, negate y", "(3, -(-4)) = (3, 4)"), "(3, 4)"))),
                new Section("Reflecting Across y = x", "Swap the coordinates: (x,y) → (y,x).",
                    List.of(new WorkedExample("Reflect (2, 7) over the line y = x.", List.of("Swap x and y coordinates"), "(7, 2)")))
            ),
            List.of("Reflections flip a figure over a line", "Over x-axis: negate y; over y-axis: negate x", "The reflection is the same distance from the line as the original")));

        // Lesson 72
        list.add(new LessonContent("lesson-72-rotations", "Transformations: Rotations", "🔄",
            "Rotate figures around the origin by 90°, 180°, or 270°.",
            List.of(
                new Section("Rotation Rules", "90° clockwise: (x,y)→(y,-x). 180°: (x,y)→(-x,-y). 90° counterclockwise: (x,y)→(-y,x).",
                    List.of(new WorkedExample("Rotate (3, 5) 90° clockwise about the origin.", List.of("Rule: (x,y)→(y,-x)", "(3,5)→(5,-3)"), "(5, -3)"))),
                new Section("180° Rotation", "Both coordinates are negated.",
                    List.of(new WorkedExample("Rotate (-2, 4) 180° about the origin.", List.of("Rule: (x,y)→(-x,-y)", "(-2,4)→(2,-4)"), "(2, -4)")))
            ),
            List.of("90° CW: (x,y)→(y,-x)", "180°: (x,y)→(-x,-y)", "90° CCW: (x,y)→(-y,x)")));

        // Lesson 73
        list.add(new LessonContent("lesson-73-dilations", "Transformations: Dilations", "🔎",
            "Enlarge or reduce figures using a scale factor from a center point.",
            List.of(
                new Section("Dilation from Origin", "Multiply each coordinate by the scale factor k: (x,y)→(kx,ky).",
                    List.of(new WorkedExample("Dilate (4, 6) by scale factor 2 from the origin.", List.of("Multiply each coordinate by 2", "(4×2, 6×2) = (8, 12)"), "(8, 12)"))),
                new Section("Scale Factor Effects", "k>1 enlarges, 0<k<1 reduces, k=1 stays the same.",
                    List.of(new WorkedExample("Dilate (10, 8) by scale factor ½.", List.of("(10×½, 8×½)", "(5, 4)"), "(5, 4)")))
            ),
            List.of("Scale factor > 1 enlarges the figure", "Scale factor between 0 and 1 shrinks the figure", "Dilations change size but preserve shape (similar figures)")));

        // Lesson 74
        list.add(new LessonContent("lesson-74-symmetry", "Symmetry", "🦋",
            "Identify line symmetry and rotational symmetry in figures.",
            List.of(
                new Section("Line Symmetry", "A figure has line symmetry if it can be folded along a line so both halves match exactly.",
                    List.of(new WorkedExample("How many lines of symmetry does a regular hexagon have?", List.of("Lines through opposite vertices: 3", "Lines through midpoints of opposite sides: 3"), "6 lines of symmetry"))),
                new Section("Rotational Symmetry", "A figure has rotational symmetry if it looks the same after a rotation less than 360°.",
                    List.of(new WorkedExample("What is the order of rotational symmetry for a square?", List.of("A square looks the same at 90°, 180°, 270°, 360°", "It maps onto itself 4 times"), "Order 4")))
            ),
            List.of("A line of symmetry divides a figure into mirror-image halves", "Regular polygons have n lines of symmetry", "Order of rotational symmetry = number of times figure maps to itself in 360°")));

        // Lesson 75
        list.add(new LessonContent("lesson-75-mean-median-mode", "Mean, Median, Mode, and Range", "📊",
            "Calculate measures of central tendency and spread for data sets.",
            List.of(
                new Section("Mean and Median", "Mean = sum ÷ count. Median = middle value when data is ordered.",
                    List.of(new WorkedExample("Find the mean and median of: 4, 7, 2, 9, 3.", List.of("Mean: (4+7+2+9+3)/5 = 25/5 = 5", "Ordered: 2,3,4,7,9 → median = 4"), "Mean=5, Median=4"))),
                new Section("Mode and Range", "Mode = most frequent value. Range = maximum - minimum.",
                    List.of(new WorkedExample("Find the mode and range of: 3, 5, 3, 8, 5, 3, 9.", List.of("Mode: 3 appears most (3 times)", "Range: 9-3=6"), "Mode=3, Range=6")))
            ),
            List.of("Mean is the average (sum ÷ count)", "Median is the middle value in ordered data", "Mode is the most frequent value; range is max minus min")));

        // Lesson 76
        list.add(new LessonContent("lesson-76-frequency-histograms", "Frequency Tables and Histograms", "📊",
            "Organize data into frequency tables and display with histograms.",
            List.of(
                new Section("Frequency Tables", "Group data into intervals and count how many values fall in each interval.",
                    List.of(new WorkedExample("Make a frequency table for test scores: 72,85,91,78,88,95,82,79,86,93 using intervals of 10.", List.of("70-79: 72,78,79 → frequency 3", "80-89: 85,88,82,86 → frequency 4", "90-99: 91,95,93 → frequency 3"), "3, 4, 3"))),
                new Section("Reading Histograms", "Bars show frequency for each interval. No gaps between bars.",
                    List.of(new WorkedExample("A histogram shows: 0-10: bar height 5, 10-20: bar height 8, 20-30: bar height 3. How many data points total?", List.of("Add all frequencies: 5+8+3=16"), "16 data points")))
            ),
            List.of("Frequency tables organize data into groups", "Histograms have no gaps between bars", "The height of each bar shows the frequency")));

        // Lesson 77
        list.add(new LessonContent("lesson-77-box-whisker", "Box-and-Whisker Plots", "📦",
            "Display data distribution using the five-number summary.",
            List.of(
                new Section("Five-Number Summary", "Minimum, Q1 (lower quartile), median, Q3 (upper quartile), maximum.",
                    List.of(new WorkedExample("Find the five-number summary: 2, 4, 6, 8, 10, 12, 14.", List.of("Min=2, Max=14, Median=8", "Q1=median of lower half (2,4,6)=4", "Q3=median of upper half (10,12,14)=12"), "2, 4, 8, 12, 14"))),
                new Section("Interquartile Range", "IQR = Q3 - Q1. It measures the spread of the middle 50% of data.",
                    List.of(new WorkedExample("Find the IQR from the summary: 2, 4, 8, 12, 14.", List.of("IQR = Q3 - Q1 = 12 - 4"), "IQR = 8")))
            ),
            List.of("The box shows the middle 50% of data (Q1 to Q3)", "The line inside the box is the median", "IQR = Q3 - Q1 measures spread")));

        // Lesson 78
        list.add(new LessonContent("lesson-78-scatter-plots", "Scatter Plots and Correlation", "📈",
            "Create scatter plots and identify positive, negative, or no correlation.",
            List.of(
                new Section("Types of Correlation", "Positive: both increase together. Negative: one increases as other decreases. None: no pattern.",
                    List.of(new WorkedExample("Hours studied: 1,2,3,4,5. Test scores: 60,65,75,80,90. What type of correlation?", List.of("As hours increase, scores increase", "Points trend upward"), "Positive correlation"))),
                new Section("Strength of Correlation", "Strong: points close to a line. Weak: points scattered but with a trend.",
                    List.of(new WorkedExample("Points are loosely scattered but generally trend downward. Describe the correlation.", List.of("Downward trend = negative", "Loosely scattered = weak"), "Weak negative correlation")))
            ),
            List.of("Positive correlation: both variables increase together", "Negative correlation: one increases as the other decreases", "No correlation: no visible pattern")));

        // Lesson 79
        list.add(new LessonContent("lesson-79-line-best-fit", "Line of Best Fit", "📉",
            "Draw and use a line of best fit to make predictions from scatter plot data.",
            List.of(
                new Section("Drawing the Line", "The line of best fit passes through the middle of the data with roughly equal points above and below.",
                    List.of(new WorkedExample("Data suggests the equation y = 2x + 10. Predict y when x = 8.", List.of("Substitute: y = 2(8) + 10", "y = 16 + 10 = 26"), "y = 26"))),
                new Section("Interpolation vs Extrapolation", "Interpolation predicts within the data range. Extrapolation predicts beyond it (less reliable).",
                    List.of(new WorkedExample("Data covers x = 1 to 10. Is predicting y at x = 15 interpolation or extrapolation?", List.of("x=15 is beyond the data range (1-10)"), "Extrapolation")))
            ),
            List.of("The line of best fit minimizes overall distance to all points", "Interpolation (within data) is more reliable than extrapolation", "Use the equation of the line to make predictions")));

        // Lesson 80
        list.add(new LessonContent("lesson-80-circle-graphs", "Circle Graphs", "🥧",
            "Read and create circle (pie) graphs to show parts of a whole.",
            List.of(
                new Section("Reading Circle Graphs", "Each sector represents a fraction or percent of the whole. All sectors sum to 100%.",
                    List.of(new WorkedExample("A circle graph shows: Math 30%, Science 25%, English 20%, History 15%, Other 10%. If 200 students were surveyed, how many chose Math?", List.of("30% of 200", "0.30 × 200 = 60"), "60 students"))),
                new Section("Creating Circle Graphs", "Convert each category to a percent, then to degrees (percent × 360°).",
                    List.of(new WorkedExample("15 out of 60 students chose pizza. What angle represents pizza on a circle graph?", List.of("Fraction: 15/60 = 1/4 = 25%", "Angle: 0.25 × 360° = 90°"), "90°")))
            ),
            List.of("All sectors must sum to 100% (or 360°)", "To find degrees: (part/whole) × 360°", "Circle graphs show parts of a whole")));

        return list;
    }


    // ═══════════════════════════════════════════════════════════════════════════════
    // LESSONS 81–100: Probability, Measurement, Financial Math, Rational Numbers
    // ═══════════════════════════════════════════════════════════════════════════════
    private List<LessonContent> buildLessons81to100() {
        List<LessonContent> list = new ArrayList<>();

        // Lesson 81
        list.add(new LessonContent("lesson-81-counting-principle", "Counting Principle", "🔢",
            "Use the fundamental counting principle to find the total number of outcomes.",
            List.of(
                new Section("Fundamental Counting Principle", "If one event has m outcomes and another has n outcomes, together they have m × n outcomes.",
                    List.of(new WorkedExample("A restaurant offers 3 appetizers and 5 entrees. How many different meals (1 appetizer + 1 entree)?", List.of("Multiply choices: 3 × 5"), "15 meals"))),
                new Section("Multiple Events", "Extend to any number of events by multiplying all choices.",
                    List.of(new WorkedExample("A password has 2 letters followed by 3 digits. How many possible passwords?", List.of("Letters: 26 × 26 = 676", "Digits: 10 × 10 × 10 = 1000", "Total: 676 × 1000"), "676,000")))
            ),
            List.of("Multiply the number of choices for each event", "Works for any number of independent events", "A tree diagram can visualize all outcomes")));

        // Lesson 82
        list.add(new LessonContent("lesson-82-permutations", "Permutations", "🔀",
            "Count arrangements where order matters using permutations.",
            List.of(
                new Section("Permutation Formula", "P(n,r) = n!/(n-r)! counts arrangements of r items from n total where order matters.",
                    List.of(new WorkedExample("How many ways can 3 students be arranged in a line from a group of 5?", List.of("P(5,3) = 5!/(5-3)! = 5!/2!", "= 120/2 = 60"), "60 ways"))),
                new Section("Factorial", "n! = n × (n-1) × (n-2) × ... × 1. By definition, 0! = 1.",
                    List.of(new WorkedExample("Calculate 6!.", List.of("6! = 6×5×4×3×2×1"), "720")))
            ),
            List.of("Permutations: order matters", "P(n,r) = n!/(n-r)!", "n! means n factorial")));

        // Lesson 83
        list.add(new LessonContent("lesson-83-combinations", "Combinations", "🤝",
            "Count selections where order does not matter using combinations.",
            List.of(
                new Section("Combination Formula", "C(n,r) = n!/[r!(n-r)!] counts ways to choose r items from n when order doesn't matter.",
                    List.of(new WorkedExample("How many ways can you choose 2 books from 6?", List.of("C(6,2) = 6!/(2!×4!)", "= 720/(2×24) = 720/48 = 15"), "15 ways"))),
                new Section("Permutation vs Combination", "If order matters, use permutations. If not, use combinations.",
                    List.of(new WorkedExample("Choosing a president and VP from 4 people vs choosing a 2-person committee from 4.", List.of("President/VP: order matters → P(4,2)=12", "Committee: order doesn't matter → C(4,2)=6"), "12 vs 6")))
            ),
            List.of("Combinations: order does NOT matter", "C(n,r) = n!/[r!(n-r)!]", "C(n,r) is always ≤ P(n,r)")));

        // Lesson 84
        list.add(new LessonContent("lesson-84-theoretical-probability", "Theoretical Probability", "🎲",
            "Calculate the probability of an event using P = favorable outcomes / total outcomes.",
            List.of(
                new Section("Basic Probability", "P(event) = number of favorable outcomes / total number of outcomes. Always between 0 and 1.",
                    List.of(new WorkedExample("What is the probability of rolling a 3 on a standard die?", List.of("Favorable outcomes: 1 (just the 3)", "Total outcomes: 6"), "1/6"))),
                new Section("Complement", "P(not A) = 1 - P(A).",
                    List.of(new WorkedExample("The probability of rain is 0.3. What is the probability of no rain?", List.of("P(no rain) = 1 - P(rain)", "1 - 0.3 = 0.7"), "0.7")))
            ),
            List.of("Probability ranges from 0 (impossible) to 1 (certain)", "P(event) = favorable / total", "P(not A) = 1 - P(A)")));

        // Lesson 85
        list.add(new LessonContent("lesson-85-experimental-probability", "Experimental Probability", "🧪",
            "Calculate probability based on actual experimental results.",
            List.of(
                new Section("From Experiments", "Experimental probability = number of times event occurred / total trials.",
                    List.of(new WorkedExample("A coin was flipped 50 times and landed heads 28 times. Find the experimental probability of heads.", List.of("P(heads) = 28/50", "Simplify: 14/25 = 0.56"), "14/25 or 56%"))),
                new Section("Comparing to Theoretical", "As trials increase, experimental probability approaches theoretical probability.",
                    List.of(new WorkedExample("Theoretical P(heads) = 0.5. After 50 flips, experimental P = 0.56. Are these close?", List.of("Difference: 0.56 - 0.50 = 0.06", "Relatively close; more trials would get closer"), "Yes, reasonably close")))
            ),
            List.of("Experimental probability is based on actual data", "More trials give results closer to theoretical probability", "Experimental and theoretical may differ for small samples")));

        // Lesson 86
        list.add(new LessonContent("lesson-86-independent-events", "Compound Events: Independent", "🎯",
            "Find the probability of two independent events both occurring.",
            List.of(
                new Section("Independent Events", "Events are independent if one doesn't affect the other. P(A and B) = P(A) × P(B).",
                    List.of(new WorkedExample("Find P(heads on a coin AND rolling 6 on a die).", List.of("P(heads) = 1/2", "P(6) = 1/6", "P(both) = 1/2 × 1/6 = 1/12"), "1/12"))),
                new Section("Multiple Independent Events", "Multiply probabilities for each independent event.",
                    List.of(new WorkedExample("A spinner has P(red)=1/4. What is P(red on two consecutive spins)?", List.of("Spins are independent", "P(red, red) = 1/4 × 1/4 = 1/16"), "1/16")))
            ),
            List.of("Independent: one event doesn't affect the other", "P(A and B) = P(A) × P(B) for independent events", "Coin flips and die rolls are independent")));

        // Lesson 87
        list.add(new LessonContent("lesson-87-dependent-events", "Compound Events: Dependent", "🔗",
            "Find the probability of dependent events where one affects the other.",
            List.of(
                new Section("Dependent Events", "Events are dependent if the first affects the second. P(A and B) = P(A) × P(B|A).",
                    List.of(new WorkedExample("A bag has 5 red and 3 blue marbles. Find P(red then blue) without replacement.", List.of("P(red first) = 5/8", "P(blue second) = 3/7 (one marble removed)", "P(both) = 5/8 × 3/7 = 15/56"), "15/56"))),
                new Section("With vs Without Replacement", "With replacement: events are independent. Without: events are dependent.",
                    List.of(new WorkedExample("Drawing 2 cards from a deck. P(ace then ace) without replacement.", List.of("P(first ace) = 4/52", "P(second ace) = 3/51", "P(both) = 4/52 × 3/51 = 12/2652 = 1/221"), "1/221")))
            ),
            List.of("Dependent: the first event changes the sample space for the second", "Without replacement makes events dependent", "P(A and B) = P(A) × P(B given A)")));

        // Lesson 88
        list.add(new LessonContent("lesson-88-probability-geometry", "Probability with Geometry", "🎯",
            "Use area ratios to find geometric probability.",
            List.of(
                new Section("Area-Based Probability", "P = area of favorable region / total area.",
                    List.of(new WorkedExample("A dart board is a circle with radius 10. The bullseye has radius 2. Find P(hitting bullseye).", List.of("Bullseye area: π(2²)=4π", "Total area: π(10²)=100π", "P = 4π/100π = 4/100"), "1/25 or 4%"))),
                new Section("Length-Based Probability", "For one-dimensional targets, P = favorable length / total length.",
                    List.of(new WorkedExample("A 12-inch ruler. A bug lands randomly. P(landing in the first 3 inches)?", List.of("Favorable: 3 inches", "Total: 12 inches", "P = 3/12 = 1/4"), "1/4 or 25%")))
            ),
            List.of("Geometric probability = favorable area / total area", "Assumes uniform random distribution", "Can use length for 1D problems")));

        // Lesson 89
        list.add(new LessonContent("lesson-89-customary-measurement", "Customary Measurement", "📏",
            "Convert between customary units of length, weight, and capacity.",
            List.of(
                new Section("Length Conversions", "12 inches = 1 foot, 3 feet = 1 yard, 5280 feet = 1 mile.",
                    List.of(new WorkedExample("Convert 7 feet to inches.", List.of("1 foot = 12 inches", "7 × 12 = 84"), "84 inches"))),
                new Section("Weight and Capacity", "16 oz = 1 lb, 2000 lb = 1 ton. 8 fl oz = 1 cup, 4 cups = 1 quart, 4 quarts = 1 gallon.",
                    List.of(new WorkedExample("Convert 3 gallons to quarts.", List.of("1 gallon = 4 quarts", "3 × 4 = 12"), "12 quarts")))
            ),
            List.of("12 in = 1 ft, 3 ft = 1 yd, 5280 ft = 1 mi", "16 oz = 1 lb, 2000 lb = 1 ton", "8 fl oz = 1 cup, 4 cups = 1 qt, 4 qt = 1 gal")));

        // Lesson 90
        list.add(new LessonContent("lesson-90-metric-measurement", "Metric Measurement", "📐",
            "Convert between metric units using powers of 10.",
            List.of(
                new Section("Metric Prefixes", "kilo (1000), hecto (100), deka (10), base, deci (0.1), centi (0.01), milli (0.001).",
                    List.of(new WorkedExample("Convert 3.5 km to meters.", List.of("1 km = 1000 m", "3.5 × 1000 = 3500"), "3500 m"))),
                new Section("Moving the Decimal", "Moving to a smaller unit: move decimal right. To a larger unit: move decimal left.",
                    List.of(new WorkedExample("Convert 450 cm to meters.", List.of("1 m = 100 cm", "Move decimal 2 places left: 4.50"), "4.5 m")))
            ),
            List.of("Metric system is based on powers of 10", "King Henry Died By Drinking Chocolate Milk (kilo, hecto, deka, base, deci, centi, milli)", "Moving to smaller units: multiply (move decimal right)")));

        // Lesson 91
        list.add(new LessonContent("lesson-91-converting-units", "Converting Units", "🔄",
            "Convert between customary and metric systems using conversion factors.",
            List.of(
                new Section("Using Conversion Factors", "Multiply by a fraction equal to 1 that converts the unit.",
                    List.of(new WorkedExample("Convert 5 miles to kilometers (1 mi ≈ 1.6 km).", List.of("5 mi × 1.6 km/mi", "= 8 km"), "8 km"))),
                new Section("Multi-Step Conversions", "Chain conversion factors for units that don't convert directly.",
                    List.of(new WorkedExample("Convert 2 hours to seconds.", List.of("2 hr × 60 min/hr = 120 min", "120 min × 60 sec/min = 7200 sec"), "7200 seconds")))
            ),
            List.of("1 inch ≈ 2.54 cm, 1 mile ≈ 1.6 km", "1 kg ≈ 2.2 lb, 1 liter ≈ 1.06 quarts", "Chain conversion factors for multi-step conversions")));

        // Lesson 92
        list.add(new LessonContent("lesson-92-rates-unit-rates", "Rates and Unit Rates", "⚡",
            "Calculate and compare unit rates to solve real-world problems.",
            List.of(
                new Section("Finding Unit Rates", "Divide to find the rate per one unit.",
                    List.of(new WorkedExample("A 12-pack of soda costs $4.80. Find the unit price.", List.of("$4.80 ÷ 12 cans", "= $0.40 per can"), "$0.40 per can"))),
                new Section("Comparing Rates", "Find unit rates for each option and compare.",
                    List.of(new WorkedExample("Store A: 5 lb for $8.75. Store B: 3 lb for $5.10. Which is the better deal?", List.of("Store A: $8.75÷5 = $1.75/lb", "Store B: $5.10÷3 = $1.70/lb"), "Store B ($1.70/lb)")))
            ),
            List.of("A unit rate has a denominator of 1", "Lower unit price = better deal", "Speed is a unit rate (distance per 1 unit of time)")));

        // Lesson 93
        list.add(new LessonContent("lesson-93-percent-change", "Percent Change", "📈",
            "Calculate percent increase and percent decrease.",
            List.of(
                new Section("Percent Change Formula", "Percent change = |new - original| / original × 100%.",
                    List.of(new WorkedExample("A price went from $40 to $50. Find the percent increase.", List.of("Change: 50-40=10", "Percent: 10/40 × 100% = 25%"), "25% increase"))),
                new Section("Percent Decrease", "Same formula; if new < original, it's a decrease.",
                    List.of(new WorkedExample("A population dropped from 800 to 600. Find the percent decrease.", List.of("Change: 800-600=200", "Percent: 200/800 × 100% = 25%"), "25% decrease")))
            ),
            List.of("Percent change = (change / original) × 100%", "Increase: new > original; Decrease: new < original", "Always divide by the ORIGINAL amount")));

        // Lesson 94
        list.add(new LessonContent("lesson-94-simple-interest", "Simple Interest", "💰",
            "Calculate simple interest using I = Prt.",
            List.of(
                new Section("Simple Interest Formula", "I = Prt, where P=principal, r=annual rate (decimal), t=time in years.",
                    List.of(new WorkedExample("Find the interest on $500 at 4% for 3 years.", List.of("I = 500 × 0.04 × 3", "I = 60"), "$60"))),
                new Section("Finding Total Amount", "Total = Principal + Interest.",
                    List.of(new WorkedExample("$1000 at 5% for 2 years. Find the total amount.", List.of("I = 1000 × 0.05 × 2 = 100", "Total = 1000 + 100 = 1100"), "$1,100")))
            ),
            List.of("I = Prt (Principal × rate × time)", "Rate must be in decimal form", "Time must be in years")));

        // Lesson 95
        list.add(new LessonContent("lesson-95-compound-interest", "Compound Interest", "📈",
            "Calculate compound interest using A = P(1 + r/n)^(nt).",
            List.of(
                new Section("Compound Interest Formula", "A = P(1 + r/n)^(nt), where n = number of times compounded per year.",
                    List.of(new WorkedExample("Find the amount after 2 years: $1000 at 6% compounded annually.", List.of("A = 1000(1 + 0.06/1)^(1×2)", "A = 1000(1.06)² = 1000(1.1236)", "A = 1123.60"), "$1,123.60"))),
                new Section("Comparing to Simple Interest", "Compound interest earns more because interest earns interest.",
                    List.of(new WorkedExample("Compare: $1000 at 6% for 2 years, simple vs compound (annually).", List.of("Simple: I=1000×0.06×2=$120, total=$1120", "Compound: $1123.60", "Difference: $3.60 more with compound"), "Compound earns $3.60 more")))
            ),
            List.of("Compound interest earns interest on interest", "More compounding periods = more interest earned", "A = P(1 + r/n)^(nt)")));

        // Lesson 96
        list.add(new LessonContent("lesson-96-discount-markup", "Discount and Markup", "🏷️",
            "Calculate sale prices using discounts and retail prices using markups.",
            List.of(
                new Section("Discount", "Sale price = original price - discount. Discount = original × discount rate.",
                    List.of(new WorkedExample("A $60 shirt is 25% off. Find the sale price.", List.of("Discount: 60 × 0.25 = $15", "Sale price: 60 - 15 = $45"), "$45"))),
                new Section("Markup", "Retail price = cost + markup. Markup = cost × markup rate.",
                    List.of(new WorkedExample("A store buys a hat for $12 and marks it up 50%. Find the selling price.", List.of("Markup: 12 × 0.50 = $6", "Selling price: 12 + 6 = $18"), "$18")))
            ),
            List.of("Discount reduces the price; markup increases it", "Sale price = original × (1 - discount rate)", "Retail price = cost × (1 + markup rate)")));

        // Lesson 97
        list.add(new LessonContent("lesson-97-tax-tip", "Tax and Tip", "🧾",
            "Calculate sales tax and tips, and find total costs.",
            List.of(
                new Section("Sales Tax", "Tax amount = price × tax rate. Total = price + tax.",
                    List.of(new WorkedExample("A $45 item has 8% sales tax. Find the total cost.", List.of("Tax: 45 × 0.08 = $3.60", "Total: 45 + 3.60 = $48.60"), "$48.60"))),
                new Section("Tips", "Tip = bill × tip rate. Total = bill + tip.",
                    List.of(new WorkedExample("A dinner bill is $32. You leave a 20% tip. Find the total.", List.of("Tip: 32 × 0.20 = $6.40", "Total: 32 + 6.40 = $38.40"), "$38.40")))
            ),
            List.of("Total cost = price + tax", "Common tip rates: 15%, 18%, 20%", "Tax and tip are calculated on the original amount")));

        // Lesson 98
        list.add(new LessonContent("lesson-98-multi-step-percent", "Multi-Step Percent Problems", "🔢",
            "Solve problems involving multiple percent calculations.",
            List.of(
                new Section("Successive Discounts", "Apply each discount to the result of the previous one, not the original.",
                    List.of(new WorkedExample("A $100 item is 20% off, then an additional 10% off. Find the final price.", List.of("First discount: 100 × 0.80 = $80", "Second discount: 80 × 0.90 = $72"), "$72 (not $70)"))),
                new Section("Percent Increase then Decrease", "A percent increase followed by the same percent decrease does NOT return to the original.",
                    List.of(new WorkedExample("A stock goes up 10% then down 10%. Starting at $100, what's the final value?", List.of("Up 10%: 100 × 1.10 = $110", "Down 10%: 110 × 0.90 = $99"), "$99 (not $100)")))
            ),
            List.of("Apply each percent change to the current value, not the original", "Two successive discounts of a% and b% ≠ one discount of (a+b)%", "Percent up then same percent down gives less than the start")));

        // Lesson 99
        list.add(new LessonContent("lesson-99-rational-numbers", "Number Theory: Rational Numbers", "🔢",
            "Understand rational numbers as ratios of integers and locate them on a number line.",
            List.of(
                new Section("What Are Rational Numbers?", "A rational number can be written as a/b where a and b are integers and b≠0. This includes fractions, decimals that terminate or repeat, and integers.",
                    List.of(new WorkedExample("Is 0.333... rational?", List.of("0.333... = 1/3", "It can be written as a fraction of integers"), "Yes, it equals 1/3"))),
                new Section("Ordering Rational Numbers", "Convert to the same form (decimals or fractions with common denominators) to compare.",
                    List.of(new WorkedExample("Order from least to greatest: -3/4, 0.5, -0.8, 2/3.", List.of("Convert: -3/4=-0.75, 0.5, -0.8, 2/3≈0.67", "Order: -0.8, -0.75, 0.5, 0.67"), "-0.8, -3/4, 0.5, 2/3")))
            ),
            List.of("Rational numbers = integers, fractions, terminating and repeating decimals", "Irrational numbers cannot be written as fractions (π, √2)", "Every integer is rational (n = n/1)")));

        // Lesson 100
        list.add(new LessonContent("lesson-100-operations-rational", "Operations with Rational Numbers", "➕",
            "Add, subtract, multiply, and divide rational numbers including negatives.",
            List.of(
                new Section("Adding and Subtracting", "Use fraction rules with attention to signs.",
                    List.of(new WorkedExample("Calculate -2/3 + 5/6.", List.of("LCD = 6: -4/6 + 5/6", "= 1/6"), "1/6"))),
                new Section("Multiplying and Dividing", "Multiply/divide as usual, then determine the sign.",
                    List.of(new WorkedExample("Calculate (-3/4) × (-2/5).", List.of("Negative × negative = positive", "3/4 × 2/5 = 6/20 = 3/10"), "3/10")))
            ),
            List.of("Same sign rules apply to rational number operations", "Find common denominators for addition/subtraction", "Multiply straight across; divide by the reciprocal")));

        return list;
    }


    // ═══════════════════════════════════════════════════════════════════════════════
    // LESSONS 101–120: Advanced Algebra, Polynomials, Applications, Review
    // ═══════════════════════════════════════════════════════════════════════════════
    private List<LessonContent> buildLessons101to120() {
        List<LessonContent> list = new ArrayList<>();

        // Lesson 101
        list.add(new LessonContent("lesson-101-multi-step-equations", "Solving Multi-Step Equations", "🧮",
            "Solve equations requiring multiple steps including combining like terms.",
            List.of(
                new Section("Combining Like Terms First", "Simplify each side before solving.",
                    List.of(new WorkedExample("Solve: 2x + 3x - 4 = 16.", List.of("Combine: 5x - 4 = 16", "Add 4: 5x = 20", "Divide by 5: x = 4"), "x = 4"))),
                new Section("Distributive Property First", "Distribute before collecting terms.",
                    List.of(new WorkedExample("Solve: 3(x + 2) - 4 = 11.", List.of("Distribute: 3x + 6 - 4 = 11", "Combine: 3x + 2 = 11", "Subtract 2, divide by 3: x = 3"), "x = 3")))
            ),
            List.of("Simplify each side first (distribute, combine like terms)", "Then isolate the variable using inverse operations", "Check by substituting back into the original equation")));

        // Lesson 102
        list.add(new LessonContent("lesson-102-equations-fractions", "Solving Equations with Fractions", "🔢",
            "Clear fractions from equations by multiplying by the LCD.",
            List.of(
                new Section("Clearing Fractions", "Multiply every term by the LCD to eliminate all fractions.",
                    List.of(new WorkedExample("Solve: x/3 + x/4 = 7.", List.of("LCD = 12. Multiply all terms by 12", "4x + 3x = 84", "7x = 84, x = 12"), "x = 12"))),
                new Section("Fractions with Variables", "Same approach works when the variable is in the numerator.",
                    List.of(new WorkedExample("Solve: (2x-1)/5 = 3.", List.of("Multiply both sides by 5: 2x-1=15", "Add 1: 2x=16", "Divide by 2: x=8"), "x = 8")))
            ),
            List.of("Multiply every term by the LCD to clear fractions", "This converts the equation to one with whole numbers", "Don't forget to multiply EVERY term")));

        // Lesson 103
        list.add(new LessonContent("lesson-103-systems-graphing", "Systems of Equations: Graphing", "📈",
            "Solve systems of two linear equations by finding where their graphs intersect.",
            List.of(
                new Section("Graphing to Find Solutions", "Graph both equations. The intersection point is the solution.",
                    List.of(new WorkedExample("Solve by graphing: y = x + 1 and y = -x + 5.", List.of("Line 1 passes through (0,1) with slope 1", "Line 2 passes through (0,5) with slope -1", "They intersect at (2, 3)"), "(2, 3)"))),
                new Section("Types of Solutions", "Intersecting lines: one solution. Parallel: no solution. Same line: infinite solutions.",
                    List.of(new WorkedExample("y = 2x + 1 and y = 2x + 3. How many solutions?", List.of("Same slope (2) but different y-intercepts", "Lines are parallel, never intersect"), "No solution")))
            ),
            List.of("The solution is the intersection point (x, y)", "Parallel lines (same slope, different intercept) have no solution", "The same line has infinitely many solutions")));

        // Lesson 104
        list.add(new LessonContent("lesson-104-systems-substitution", "Systems of Equations: Substitution", "🔄",
            "Solve systems by substituting one equation into the other.",
            List.of(
                new Section("Substitution Method", "Solve one equation for a variable, then substitute into the other.",
                    List.of(new WorkedExample("Solve: y = 2x and x + y = 9.", List.of("Substitute y=2x into second: x + 2x = 9", "3x = 9, x = 3", "y = 2(3) = 6"), "x=3, y=6"))),
                new Section("When to Rearrange", "If neither equation is solved for a variable, solve the simpler one first.",
                    List.of(new WorkedExample("Solve: 2x + y = 10 and 3x - y = 5.", List.of("From first: y = 10 - 2x", "Substitute: 3x - (10-2x) = 5", "5x - 10 = 5, 5x = 15, x = 3, y = 4"), "x=3, y=4")))
            ),
            List.of("Isolate one variable in one equation", "Substitute that expression into the other equation", "Solve, then back-substitute to find the other variable")));

        // Lesson 105
        list.add(new LessonContent("lesson-105-monomials-polynomials", "Monomials and Polynomials", "📝",
            "Identify and classify monomials, binomials, and trinomials by degree and terms.",
            List.of(
                new Section("Classifying Polynomials", "Monomial: 1 term. Binomial: 2 terms. Trinomial: 3 terms. Degree = highest exponent.",
                    List.of(new WorkedExample("Classify 4x³ - 2x + 7 and state its degree.", List.of("Three terms → trinomial", "Highest exponent is 3"), "Trinomial, degree 3"))),
                new Section("Standard Form", "Write terms in descending order of degree.",
                    List.of(new WorkedExample("Write in standard form: 5 + 3x² - x.", List.of("Descending degree: 3x² - x + 5"), "3x² - x + 5")))
            ),
            List.of("Degree = highest exponent in the polynomial", "Standard form: terms in descending degree order", "The degree of a constant is 0")));

        // Lesson 106
        list.add(new LessonContent("lesson-106-add-sub-polynomials", "Adding and Subtracting Polynomials", "➕",
            "Add and subtract polynomials by combining like terms.",
            List.of(
                new Section("Adding Polynomials", "Remove parentheses and combine like terms.",
                    List.of(new WorkedExample("Add: (3x² + 2x - 1) + (x² - 4x + 5).", List.of("Combine x²: 3x²+x²=4x²", "Combine x: 2x+(-4x)=-2x", "Combine constants: -1+5=4"), "4x² - 2x + 4"))),
                new Section("Subtracting Polynomials", "Distribute the negative sign, then combine like terms.",
                    List.of(new WorkedExample("Subtract: (5x² + 3x) - (2x² - x + 4).", List.of("Distribute negative: 5x²+3x-2x²+x-4", "Combine: 3x²+4x-4"), "3x² + 4x - 4")))
            ),
            List.of("Only combine terms with the same variable and exponent", "When subtracting, change all signs in the second polynomial", "Write the result in standard form")));

        // Lesson 107
        list.add(new LessonContent("lesson-107-multiplying-monomials", "Multiplying Monomials", "✖️",
            "Multiply monomials using the product rule for exponents.",
            List.of(
                new Section("Product Rule", "When multiplying same bases, add exponents: xᵃ × xᵇ = xᵃ⁺ᵇ.",
                    List.of(new WorkedExample("Simplify: 3x⁴ × 5x³.", List.of("Multiply coefficients: 3×5=15", "Add exponents: x⁴⁺³=x⁷"), "15x⁷"))),
                new Section("Power Rule", "When raising a power to a power, multiply exponents: (xᵃ)ᵇ = xᵃᵇ.",
                    List.of(new WorkedExample("Simplify: (2x³)².", List.of("Coefficient: 2²=4", "Variable: x³ˣ²=x⁶"), "4x⁶")))
            ),
            List.of("Product rule: xᵃ × xᵇ = xᵃ⁺ᵇ", "Power rule: (xᵃ)ᵇ = xᵃᵇ", "Multiply coefficients normally")));

        // Lesson 108
        list.add(new LessonContent("lesson-108-dividing-monomials", "Dividing Monomials", "➗",
            "Divide monomials using the quotient rule for exponents.",
            List.of(
                new Section("Quotient Rule", "When dividing same bases, subtract exponents: xᵃ ÷ xᵇ = xᵃ⁻ᵇ.",
                    List.of(new WorkedExample("Simplify: 12x⁵ ÷ 4x².", List.of("Divide coefficients: 12÷4=3", "Subtract exponents: x⁵⁻²=x³"), "3x³"))),
                new Section("Negative Exponents", "x⁻ⁿ = 1/xⁿ. A negative exponent means the base moves to the denominator.",
                    List.of(new WorkedExample("Simplify: x³ ÷ x⁷.", List.of("Subtract exponents: x³⁻⁷=x⁻⁴", "x⁻⁴ = 1/x⁴"), "1/x⁴")))
            ),
            List.of("Quotient rule: xᵃ ÷ xᵇ = xᵃ⁻ᵇ", "Negative exponent: x⁻ⁿ = 1/xⁿ", "x⁰ = 1 for any nonzero x")));

        // Lesson 109
        list.add(new LessonContent("lesson-109-distributive-property", "The Distributive Property", "📐",
            "Use the distributive property to multiply a monomial by a polynomial.",
            List.of(
                new Section("Distributing a Monomial", "Multiply the monomial by each term in the polynomial.",
                    List.of(new WorkedExample("Expand: 3x(2x² - 4x + 5).", List.of("3x × 2x² = 6x³", "3x × (-4x) = -12x²", "3x × 5 = 15x"), "6x³ - 12x² + 15x"))),
                new Section("Multiplying Binomials (FOIL)", "First, Outer, Inner, Last.",
                    List.of(new WorkedExample("Expand: (x + 3)(x + 5).", List.of("F: x·x=x²", "O: x·5=5x, I: 3·x=3x, L: 3·5=15", "Combine: x²+8x+15"), "x² + 8x + 15")))
            ),
            List.of("Distribute: multiply the outside term by every inside term", "FOIL works for multiplying two binomials", "Combine like terms after distributing")));

        // Lesson 110
        list.add(new LessonContent("lesson-110-factoring-gcf", "Factoring with GCF", "🔗",
            "Factor out the greatest common factor from polynomial expressions.",
            List.of(
                new Section("Finding the GCF", "Identify the largest factor common to all terms (number and variable parts).",
                    List.of(new WorkedExample("Factor: 12x³ + 8x².", List.of("GCF of 12 and 8: 4", "GCF of x³ and x²: x²", "GCF = 4x²"), "4x²(3x + 2)"))),
                new Section("Factoring Completely", "After factoring out the GCF, check if the remaining expression can be factored further.",
                    List.of(new WorkedExample("Factor: 6x² - 18x.", List.of("GCF = 6x", "6x(x - 3)"), "6x(x - 3)")))
            ),
            List.of("Factoring is the reverse of distributing", "Always look for a GCF first", "Check by distributing back to verify")));

        // Lesson 111
        list.add(new LessonContent("lesson-111-pythagorean-applications", "Pythagorean Theorem Applications", "📐",
            "Apply the Pythagorean theorem to real-world and geometric problems.",
            List.of(
                new Section("Real-World Problems", "Identify the right triangle in the situation and apply a²+b²=c².",
                    List.of(new WorkedExample("A ladder leans against a wall. The base is 6 ft from the wall and the ladder is 10 ft long. How high does it reach?", List.of("6² + h² = 10²", "36 + h² = 100", "h² = 64, h = 8"), "8 feet"))),
                new Section("Distance on Coordinate Plane", "The distance between two points forms the hypotenuse of a right triangle.",
                    List.of(new WorkedExample("Find the distance between (1, 2) and (4, 6).", List.of("Horizontal: 4-1=3, Vertical: 6-2=4", "d² = 3²+4² = 9+16 = 25", "d = 5"), "5 units")))
            ),
            List.of("Look for right triangles in real-world situations", "The hypotenuse is always the longest side", "Distance formula is based on the Pythagorean theorem")));

        // Lesson 112
        list.add(new LessonContent("lesson-112-distance-midpoint", "Distance and Midpoint", "📏",
            "Use the distance and midpoint formulas on the coordinate plane.",
            List.of(
                new Section("Distance Formula", "d = √[(x₂-x₁)² + (y₂-y₁)²].",
                    List.of(new WorkedExample("Find the distance between (-1, 3) and (5, -1).", List.of("d = √[(5-(-1))² + (-1-3)²]", "d = √[36 + 16] = √52 ≈ 7.21"), "√52 ≈ 7.21"))),
                new Section("Midpoint Formula", "Midpoint = ((x₁+x₂)/2, (y₁+y₂)/2).",
                    List.of(new WorkedExample("Find the midpoint of (2, 8) and (6, 4).", List.of("x: (2+6)/2 = 4", "y: (8+4)/2 = 6"), "(4, 6)")))
            ),
            List.of("Distance formula comes from the Pythagorean theorem", "Midpoint is the average of the coordinates", "Midpoint = ((x₁+x₂)/2, (y₁+y₂)/2)")));

        // Lesson 113
        list.add(new LessonContent("lesson-113-angle-relationships", "Angle Relationships Review", "🔄",
            "Review and apply all angle relationships: complementary, supplementary, vertical, and parallel line angles.",
            List.of(
                new Section("Angle Pair Review", "Complementary (sum 90°), supplementary (sum 180°), vertical (equal), linear pair (supplementary).",
                    List.of(new WorkedExample("Angles A and B are complementary. A = 3x and B = 2x + 10. Find both angles.", List.of("3x + 2x + 10 = 90", "5x = 80, x = 16", "A=48°, B=42°"), "A=48°, B=42°"))),
                new Section("Multi-Step Angle Problems", "Combine multiple angle relationships to find unknowns.",
                    List.of(new WorkedExample("Two parallel lines cut by a transversal. One angle is (4x+10)° and its alternate interior angle is (6x-20)°. Find x.", List.of("Alternate interior angles are equal", "4x+10 = 6x-20", "30 = 2x, x = 15"), "x = 15")))
            ),
            List.of("Complementary: sum = 90°", "Supplementary: sum = 180°", "Vertical angles are always equal")));

        // Lesson 114
        list.add(new LessonContent("lesson-114-proportional-relationships", "Proportional Relationships", "📊",
            "Identify proportional relationships in tables, graphs, and equations.",
            List.of(
                new Section("Identifying Proportional Relationships", "A relationship is proportional if y/x is constant for all pairs and the graph passes through the origin.",
                    List.of(new WorkedExample("Is this proportional? (2,6), (3,9), (5,15).", List.of("6/2=3, 9/3=3, 15/5=3", "Constant ratio of 3"), "Yes, y = 3x"))),
                new Section("Constant of Proportionality", "In y = kx, k is the constant of proportionality (unit rate).",
                    List.of(new WorkedExample("A car uses 2 gallons per 50 miles. Write the proportional equation for gallons g and miles m.", List.of("Rate: 2/50 = 1/25 gallons per mile", "g = (1/25)m"), "g = m/25")))
            ),
            List.of("Proportional: y/x is constant and graph passes through origin", "y = kx where k is the constant of proportionality", "Non-proportional relationships don't pass through the origin")));

        // Lesson 115
        list.add(new LessonContent("lesson-115-non-proportional", "Non-Proportional Relationships", "📉",
            "Identify and work with linear relationships that are not proportional.",
            List.of(
                new Section("Recognizing Non-Proportional", "If y = mx + b with b ≠ 0, the relationship is linear but not proportional.",
                    List.of(new WorkedExample("A gym charges $20/month plus a $50 signup fee. Is cost proportional to months?", List.of("Cost = 20m + 50", "b = 50 ≠ 0, doesn't pass through origin"), "Not proportional (linear with y-intercept 50)"))),
                new Section("Comparing Relationships", "Proportional: y=kx (through origin). Non-proportional linear: y=mx+b (b≠0).",
                    List.of(new WorkedExample("Table: (1,5), (2,8), (3,11). Proportional or not?", List.of("Differences: 8-5=3, 11-8=3 (constant → linear)", "5/1=5, 8/2=4, 11/3≈3.67 (not constant ratio)"), "Non-proportional linear (y = 3x + 2)")))
            ),
            List.of("Non-proportional linear: y = mx + b where b ≠ 0", "The graph is a line that does NOT pass through the origin", "Constant rate of change but not a constant ratio")));

        // Lesson 116
        list.add(new LessonContent("lesson-116-interpreting-graphs", "Interpreting Graphs", "📊",
            "Analyze and interpret real-world graphs including rate of change and trends.",
            List.of(
                new Section("Reading Graphs", "Identify what the axes represent, find key features like intercepts, and describe trends.",
                    List.of(new WorkedExample("A distance-time graph shows a horizontal segment from t=2 to t=4. What does this mean?", List.of("Horizontal = no change in distance", "The object is stationary during this time"), "The object is not moving between t=2 and t=4"))),
                new Section("Rate of Change from Graphs", "The slope of a segment represents the rate of change.",
                    List.of(new WorkedExample("A graph goes from (0, 0) to (3, 60). What is the rate of change?", List.of("Rise/run = 60/3 = 20", "20 units per time unit"), "20 units per time unit")))
            ),
            List.of("Steeper slope = faster rate of change", "Horizontal line = no change (constant value)", "Always read axis labels to understand units")));

        // Lesson 117
        list.add(new LessonContent("lesson-117-data-analysis-sampling", "Data Analysis and Sampling", "📋",
            "Understand sampling methods and how they affect data reliability.",
            List.of(
                new Section("Sampling Methods", "Random sampling gives every member an equal chance. Biased samples don't represent the population.",
                    List.of(new WorkedExample("A school surveys only honor students about homework time. Is this a good sample?", List.of("Honor students may study more than average", "This is a biased sample"), "No, it's biased toward high-achieving students"))),
                new Section("Population vs Sample", "A population is the entire group. A sample is a subset used to make inferences.",
                    List.of(new WorkedExample("A factory makes 10,000 widgets daily. They test 100. Identify population and sample.", List.of("Population: all 10,000 widgets", "Sample: the 100 tested"), "Population: 10,000; Sample: 100")))
            ),
            List.of("Random samples best represent the population", "Larger samples give more reliable results", "Biased samples lead to incorrect conclusions")));

        // Lesson 118
        list.add(new LessonContent("lesson-118-making-predictions", "Making Predictions", "🔮",
            "Use data, trends, and probability to make predictions.",
            List.of(
                new Section("Predictions from Data", "Use patterns in data or a line of best fit to predict future values.",
                    List.of(new WorkedExample("Sales have been: 100, 120, 140, 160. Predict next month's sales.", List.of("Pattern: increasing by 20 each month", "Next: 160 + 20 = 180"), "180"))),
                new Section("Predictions from Probability", "Use experimental probability to predict outcomes for larger samples.",
                    List.of(new WorkedExample("In 50 spins, red came up 15 times. Predict red in 200 spins.", List.of("P(red) = 15/50 = 0.30", "Expected in 200: 0.30 × 200 = 60"), "About 60 times")))
            ),
            List.of("Predictions assume current trends continue", "Larger samples make predictions more reliable", "Expected value = probability × number of trials")));

        // Lesson 119
        list.add(new LessonContent("lesson-119-problem-solving", "Problem Solving Strategies", "🧠",
            "Apply systematic strategies to solve multi-step mathematical problems.",
            List.of(
                new Section("Problem Solving Steps", "Understand the problem, make a plan, carry out the plan, check your answer.",
                    List.of(new WorkedExample("A rectangular garden is twice as long as it is wide. The perimeter is 36 m. Find the dimensions.", List.of("Let w = width, then length = 2w", "Perimeter: 2(w) + 2(2w) = 36 → 6w = 36", "w = 6, length = 12"), "6 m × 12 m"))),
                new Section("Choosing a Strategy", "Draw a diagram, make a table, work backwards, guess and check, or write an equation.",
                    List.of(new WorkedExample("Three consecutive integers sum to 72. Find them.", List.of("Let n = first integer: n + (n+1) + (n+2) = 72", "3n + 3 = 72, 3n = 69, n = 23"), "23, 24, 25")))
            ),
            List.of("Read the problem carefully and identify what's asked", "Choose an appropriate strategy", "Always check that your answer makes sense in context")));

        // Lesson 120
        list.add(new LessonContent("lesson-120-cumulative-review", "Cumulative Review", "🎓",
            "Review and connect major concepts from the entire course.",
            List.of(
                new Section("Number Sense and Operations", "Review operations with integers, fractions, decimals, and percents.",
                    List.of(new WorkedExample("Evaluate: -2/3 + 0.5 - 1/6.", List.of("Convert 0.5 = 1/2 = 3/6", "-2/3 = -4/6", "-4/6 + 3/6 - 1/6 = -2/6 = -1/3"), "-1/3"))),
                new Section("Algebra and Geometry", "Review solving equations, graphing, and geometric formulas.",
                    List.of(new WorkedExample("A circle has area 50.24 cm². Find the radius. (π≈3.14)", List.of("A = πr² → 50.24 = 3.14r²", "r² = 50.24/3.14 = 16", "r = 4"), "r = 4 cm")))
            ),
            List.of("Connect concepts across topics (fractions, algebra, geometry)", "Use estimation to check reasonableness", "Show your work clearly and organize your steps")));

        return list;
    }
}
