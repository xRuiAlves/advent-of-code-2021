import days.MultipartDaySolution;
import days.day1.Day1;
import days.day2.Day2;
import days.day3.Day3;
import days.day4.Day4;

import java.util.List;

public class Main {
    private static final List<MultipartDaySolution> solutions = List.of(
            new Day1("input/day1.txt"),
            new Day2("input/day2.txt"),
            new Day3("input/day3.txt"),
            new Day4("input/day4.txt")
    );

    public static void main(String[] args) {
        solutions.forEach(System.out::println);
    }
}
