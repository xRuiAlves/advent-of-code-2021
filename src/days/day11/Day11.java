package days.day11;

import days.DaySolution;

import java.util.Arrays;

public class Day11 extends DaySolution {
    private static final int PART_1_CYCLE_COUNT = 100;
    public Day11(String filePath) {
        super(filePath);
    }

    @Override
    public Object part1() {
        Map map = map();

        int flashCount = 0;
        for (int i = 0; i < PART_1_CYCLE_COUNT; ++i) {
            map.flash();
            flashCount += map.resetAndCountFlashes();
        }

        return flashCount;
    }

    @Override
    public Object part2() {
        Map map = map();

        for (int i = 0; i < Integer.MAX_VALUE; ++i) {
            map.flash();
            if (map.resetAndCountFlashes() == map.size()) {
                return i + 1;
            }
        }

        throw new RuntimeException("No simultaneous flash found!");
    }

    private Map map() {
        return new Map(input
            .stream()
            .map(line -> Arrays
                .stream(line.split(""))
                .mapToInt(Integer::parseInt)
                .toArray())
            .toArray(int[][]::new));
    }
}
