package days;

import utils.FileReader;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class DaySolution implements MultipartDaySolution {
    private static final Pattern DAY_NUMBER_PATTERN = Pattern.compile("(?<number>\\d+)$");

    protected final List<String> input;

    protected DaySolution(String filePath) {
        try {
            this.input = FileReader.readLines(new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read input file", e);
        }
    }

    @Override
    public String toString() {
        return String.format(
                "Day %s:\n  > Part 1: %s\n  > Part 2: %s",
                getDayNumberFromClassName(),
                part1(),
                part2()
        );
    }

    private int getDayNumberFromClassName() {
        Matcher matcher = DAY_NUMBER_PATTERN.matcher(this.getClass().getName());

        if (!matcher.find()) {
            throw new RuntimeException(String.format("Invalid class name %s: Does not have a day number!", this.getClass().getName()));
        }

        return Integer.parseInt(matcher.group("number"));
    }
}
