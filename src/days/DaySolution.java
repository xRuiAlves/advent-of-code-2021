package days;

import utils.FileReader;

import java.io.File;
import java.io.IOException;
import java.util.List;

public abstract class DaySolution implements MultipartDaySolution {
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
            "Part 1: %s\nPart 2: %s",
            part1(),
            part2()
        );
    }
}
