# Advent of Code 2021 - karakaz's solutions

### What is Advent of Code?

A yearly advent calendar with one or more programming puzzles each day.

Read more at: https://adventofcode.com/2021/about

### My approach

1. I read the initial presented problem.
2. Then I think about how to solve the problem.
3. When I have figured out how I will approach it I start implementing in code.
4. Then I write a test with the inputs from the problem and asserting the result.
   1. If my implementation is correct I construct a `main` method and set everything up ready to take in the real input.
   2. If my implementation is not correct I add more debug logging if necessary and figure out what is wrong with the code.
5. I request the real input and copy it into the input file and run the `main` method.
6. I get the result and submit it.

### Refinement

Sometimes I am not pleased with my initial implementation and will refine or re-implement it entirely. If that is the case I include my original and refined solutions.

### Puzzles with multiple parts

The design choice for one part may not be compatible with the next part, so then I may choose to scrap sections or all I had implemented and go in a different direction.

### My solutions


| Puzzle                                                                | Solution                                                                                                                                                                                                                                                                                                                    | Test                                                                                                                                         |
|-----------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------|
| [Day 1: Sonar Sweep](https://adventofcode.com/2021/day/1)             | <ul><li>[Original](https://github.com/Karakaz/advent-of-code-2021/blob/master/src/main/kotlin/io/karakaz/adventofcode/y2021/puzzle/day1/Day1Original.kt) </li><li>[Refined](https://github.com/Karakaz/advent-of-code-2021/blob/master/src/main/kotlin/io/karakaz/adventofcode/y2021/puzzle/day1/Day1Refined.kt) </li></ul> | [Day1Test](https://github.com/Karakaz/advent-of-code-2021/blob/master/src/test/kotlin/io/karakaz/adventofcode/y2021/puzzle/day1/Day1Test.kt) |
| [Day 2: Dive!](https://adventofcode.com/2021/day/2)                   | <ul><li>[Part 1](https://github.com/Karakaz/advent-of-code-2021/blob/master/src/main/kotlin/io/karakaz/adventofcode/y2021/puzzle/day2/Day2Part1.kt) </li><li>[Part 2](https://github.com/Karakaz/advent-of-code-2021/blob/master/src/main/kotlin/io/karakaz/adventofcode/y2021/puzzle/day2/Day2Part2.kt) </li></ul>         | [Day2Test](https://github.com/Karakaz/advent-of-code-2021/blob/master/src/test/kotlin/io/karakaz/adventofcode/y2021/puzzle/day2/Day2Test.kt) |
| [Day 3: Binary Diagnostic](https://adventofcode.com/2021/day/3)       | <ul><li>[Part 1](https://github.com/Karakaz/advent-of-code-2021/blob/master/src/main/kotlin/io/karakaz/adventofcode/y2021/puzzle/day3/Day3Part1.kt) </li><li>[Part 2](https://github.com/Karakaz/advent-of-code-2021/blob/master/src/main/kotlin/io/karakaz/adventofcode/y2021/puzzle/day3/Day3Part2.kt) </li></ul>         | [Day3Test](https://github.com/Karakaz/advent-of-code-2021/blob/master/src/test/kotlin/io/karakaz/adventofcode/y2021/puzzle/day3/Day3Test.kt) |
| [Day 4: Giant Squid](https://adventofcode.com/2021/day/4)             | <ul><li>[Original](https://github.com/Karakaz/advent-of-code-2021/blob/master/src/main/kotlin/io/karakaz/adventofcode/y2021/puzzle/day4/Day4Original.kt) </li><li>[Refined](https://github.com/Karakaz/advent-of-code-2021/blob/master/src/main/kotlin/io/karakaz/adventofcode/y2021/puzzle/day4/Day4Refined.kt) </li></ul> | [Day4Test](https://github.com/Karakaz/advent-of-code-2021/blob/master/src/test/kotlin/io/karakaz/adventofcode/y2021/puzzle/day4/Day4Test.kt) |
| [Day 5: Hydrothermal Venture](https://adventofcode.com/2021/day/5)    | [Solution](https://github.com/Karakaz/advent-of-code-2021/blob/master/src/main/kotlin/io/karakaz/adventofcode/y2021/puzzle/day5/Day5.kt)                                                                                                                                                                                    | [Day5Test](https://github.com/Karakaz/advent-of-code-2021/blob/master/src/test/kotlin/io/karakaz/adventofcode/y2021/puzzle/day5/Day5Test.kt) |
| [Day 6: Lanternfish](https://adventofcode.com/2021/day/6)             | <ul><li>[Part 1](https://github.com/Karakaz/advent-of-code-2021/blob/master/src/main/kotlin/io/karakaz/adventofcode/y2021/puzzle/day6/Day6Part1.kt) </li><li>[Part 2](https://github.com/Karakaz/advent-of-code-2021/blob/master/src/main/kotlin/io/karakaz/adventofcode/y2021/puzzle/day6/Day6Part2.kt) </li></ul>         | [Day6Test](https://github.com/Karakaz/advent-of-code-2021/blob/master/src/test/kotlin/io/karakaz/adventofcode/y2021/puzzle/day6/Day6Test.kt) |
| [Day 7: The Treachery of Whales](https://adventofcode.com/2021/day/7) | [Solution](https://github.com/Karakaz/advent-of-code-2021/blob/master/src/main/kotlin/io/karakaz/adventofcode/y2021/puzzle/day7/Day7.kt)                                                                                                                                                                                    | [Day7Test](https://github.com/Karakaz/advent-of-code-2021/blob/master/src/test/kotlin/io/karakaz/adventofcode/y2021/puzzle/day7/Day7Test.kt) |
| [Day 8: Seven Segment Search](https://adventofcode.com/2021/day/8)    | [Solution](https://github.com/Karakaz/advent-of-code-2021/blob/master/src/main/kotlin/io/karakaz/adventofcode/y2021/puzzle/day8/Day8.kt)                                                                                                                                                                                    | [Day8Test](https://github.com/Karakaz/advent-of-code-2021/blob/master/src/test/kotlin/io/karakaz/adventofcode/y2021/puzzle/day8/Day8Test.kt) |
| [Day 9: Smoke Basin](https://adventofcode.com/2021/day/9)             | <ul><li>[Part 1](https://github.com/Karakaz/advent-of-code-2021/blob/master/src/main/kotlin/io/karakaz/adventofcode/y2021/puzzle/day9/Day9Part1.kt) </li><li>[Part 2](https://github.com/Karakaz/advent-of-code-2021/blob/master/src/main/kotlin/io/karakaz/adventofcode/y2021/puzzle/day9/Day9Part2.kt) </li></ul>         | [Day9Test](https://github.com/Karakaz/advent-of-code-2021/blob/master/src/test/kotlin/io/karakaz/adventofcode/y2021/puzzle/day9/Day9Test.kt) |
| Day 10:                                                               |                                                                                                                                                                                                                                                                                                                             |                                                                                                                                              |
| Day 11:                                                               |                                                                                                                                                                                                                                                                                                                             |                                                                                                                                              |
| Day 12:                                                               |                                                                                                                                                                                                                                                                                                                             |                                                                                                                                              |
| Day 13:                                                               |                                                                                                                                                                                                                                                                                                                             |                                                                                                                                              |
| Day 14:                                                               |                                                                                                                                                                                                                                                                                                                             |                                                                                                                                              |
| Day 15:                                                               |                                                                                                                                                                                                                                                                                                                             |                                                                                                                                              |
| Day 16:                                                               |                                                                                                                                                                                                                                                                                                                             |                                                                                                                                              |
| Day 17:                                                               |                                                                                                                                                                                                                                                                                                                             |                                                                                                                                              |
| Day 18:                                                               |                                                                                                                                                                                                                                                                                                                             |                                                                                                                                              |
| Day 19:                                                               |                                                                                                                                                                                                                                                                                                                             |                                                                                                                                              |
| Day 20:                                                               |                                                                                                                                                                                                                                                                                                                             |                                                                                                                                              |
| Day 21:                                                               |                                                                                                                                                                                                                                                                                                                             |                                                                                                                                              |
| Day 22:                                                               |                                                                                                                                                                                                                                                                                                                             |                                                                                                                                              |
| Day 23:                                                               |                                                                                                                                                                                                                                                                                                                             |                                                                                                                                              |
| Day 24:                                                               |                                                                                                                                                                                                                                                                                                                             |                                                                                                                                              |
| Day 25:                                                               |                                                                                                                                                                                                                                                                                                                             |                                                                                                                                              |
