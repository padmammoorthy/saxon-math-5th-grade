import re

lesson_titles = {
    1: "Numbers Through 999",
    2: "Adding Two-Digit Numbers",
    3: "Subtracting Two-Digit Numbers",
    4: "Multiplication Facts (x2, x5, x10)",
    5: "Division Facts (div2, div5, div10)",
    6: "Comparing Numbers",
    7: "Rounding to Nearest Ten",
    8: "Rounding to Nearest Hundred",
    9: "Adding Three-Digit Numbers",
    10: "Subtracting Three-Digit Numbers",
    11: "Multiplication Facts (x3, x4)",
    12: "Division Facts (div3, div4)",
    13: "Multiplication Facts (x6, x7)",
    14: "Multiplication Facts (x8, x9)",
    15: "Estimating Sums",
    16: "Estimating Differences",
    17: "Fractions: Parts of a Whole",
    18: "Fractions: Parts of a Set",
    19: "Equivalent Fractions",
    20: "Comparing Fractions",
    21: "Adding Fractions (Same Denominator)",
    22: "Subtracting Fractions (Same Denominator)",
    23: "Mixed Numbers",
    24: "Decimals: Tenths",
    25: "Decimals: Hundredths",
    26: "Adding Decimals",
    27: "Subtracting Decimals",
    28: "Multiplying by Multiples of 10",
    29: "Multiplying Two-Digit Numbers",
    30: "Dividing Two-Digit Numbers",
    31: "Lines and Angles",
    32: "Perimeter",
    33: "Area",
    34: "Time: Reading Clocks",
    35: "Calendar and Elapsed Time",
    36: "Money: Counting and Making Change",
    37: "Multiplication: Three-Digit by One-Digit",
    38: "Division with Remainders",
    39: "Graphs: Bar and Pictographs",
    40: "Probability",
    41: "Multiplying Two-Digit by Two-Digit",
    42: "Long Division: Two-Digit Divisor",
    43: "Adding Unlike Denominators",
    44: "Subtracting Unlike Denominators",
    45: "Multiplying Fractions",
    46: "Dividing Fractions",
    47: "Decimals: Thousandths",
    48: "Multiplying Decimals",
    49: "Dividing Decimals",
    50: "Percent Basics",
    51: "Finding Percent of a Number",
    52: "Ratio and Proportion",
    53: "Geometry: Triangles",
    54: "Geometry: Quadrilaterals",
    55: "Geometry: Circles",
    56: "Volume",
    57: "Coordinate Plane",
    58: "Integers: Introduction",
    59: "Adding Integers",
    60: "Subtracting Integers",
    61: "Order of Operations (PEMDAS)",
    62: "Exponents",
    63: "Square Roots",
    64: "Prime and Composite Numbers",
    65: "Greatest Common Factor (GCF)",
    66: "Least Common Multiple (LCM)",
    67: "Simplifying Fractions",
    68: "Fractions to Decimals",
    69: "Decimals to Fractions",
    70: "Measurement: Length (Customary)",
    71: "Measurement: Length (Metric)",
    72: "Measurement: Weight (Customary)",
    73: "Measurement: Capacity (Customary)",
    74: "Measurement: Metric Mass and Capacity",
    75: "Temperature",
    76: "Mean, Median, Mode",
    77: "Range",
    78: "Line Plots and Stem-and-Leaf",
    79: "Patterns and Sequences",
    80: "Input/Output Tables",
    81: "Algebraic Expressions",
    82: "Solving One-Step Equations (Add/Subtract)",
    83: "Solving One-Step Equations (Mult/Divide)",
    84: "Inequalities",
    85: "Word Problems with Equations",
    86: "Geometry: Symmetry",
    87: "Transformations: Translations",
    88: "Transformations: Reflections",
    89: "Transformations: Rotations",
    90: "Similar and Congruent Figures",
    91: "Pythagorean Theorem",
    92: "Surface Area",
    93: "Circumference",
    94: "Area of a Circle",
    95: "Fractions, Decimals, Percents Conversion",
    96: "Rates and Unit Rates",
    97: "Scale Drawings",
    98: "Simple Interest",
    99: "Combinations and Permutations",
    100: "Review: All Operations",
    101: "Multi-Step Word Problems",
    102: "Mixed Number Operations",
    103: "Decimals: Multiplying by Powers of 10",
    104: "Decimals: Dividing by Powers of 10",
    105: "Scientific Notation",
    106: "Geometry: 3D Shapes",
    107: "Nets of 3D Shapes",
    108: "Angles in Polygons",
    109: "Statistics: Box Plots",
    110: "Statistics: Scatter Plots",
    111: "Probability: Compound Events",
    112: "Probability: Experimental vs Theoretical",
    113: "Number Theory: Divisibility Rules",
    114: "Fractions: Complex Fractions",
    115: "Algebra: Two-Step Equations",
    116: "Algebra: Graphing Linear Equations",
    117: "Geometry: Angle Relationships",
    118: "Geometry: Parallel Lines and Transversals",
    119: "Final Review: Number Sense",
    120: "Final Review: All Topics",
}

path = "src/main/java/com/saxonmath/mathquiz/config/DataLoader.java"

with open(path, 'r') as f:
    content = f.read()

count = 0

def replacer(m):
    global count
    lesson_num = int(m.group(1))
    topic = m.group(2)
    title = lesson_titles.get(lesson_num, "Lesson " + str(lesson_num))
    count += 1
    return ', ' + str(lesson_num) + ', "' + title + '", ' + topic + ')'

# Match pattern: , <number>, "Topic") at end of q() calls
# The topic string ends the call: , 42, "Division")
pattern = r',\s*(\d{1,3}),\s*("[\w &:()/,!.\-]+")\)'

new_content = re.sub(pattern, replacer, content)

with open(path, 'w') as f:
    f.write(new_content)

print("Replacements made:", count)
