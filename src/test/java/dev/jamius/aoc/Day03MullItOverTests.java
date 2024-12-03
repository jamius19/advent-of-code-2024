package dev.jamius.aoc;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;

public class Day03MullItOverTests {
    static String INPUT_PATH = "/input/day3.txt";

    public static String getInput() throws Exception {
        var bf = new BufferedReader(
                new FileReader(
                        Day02RedNosedReports.class.getResource(INPUT_PATH).getPath()
                )
        );

        String line = bf.readLine();

        bf.close();

        return line;
    }

    @Test
    public void testPartOne() throws Exception {
        var input = getInput();
        var mul = Day03MullItOver.partOne(input);

        System.out.println(mul);
    }

    @Test
    public void testPartTwo() throws Exception {
        var input = getInput();
        var mul = Day03MullItOver.partTwo(input);

        System.out.println(mul);
    }
}
