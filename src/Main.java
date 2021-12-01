import days.MultipartDaySolution;
import days.day1.Day1;

import java.util.List;

public class Main {
    private static final List<MultipartDaySolution> solutions = List.of(new Day1("input/day1.txt"));

    public static void main(String[] args) {
        solutions.forEach(System.out::println);
    }
}
