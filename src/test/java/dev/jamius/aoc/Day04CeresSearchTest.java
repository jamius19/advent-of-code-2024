package dev.jamius.aoc;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.*;

public class Day04CeresSearchTest {
    private static final String INPUT_PATH = "/input/day4.txt";

    private static int[][] getInput() throws Exception {
        var val = new LinkedList<int[]>();
        var bf = new BufferedReader(new FileReader(
                Day04CeresSearchTest.class.getResource(INPUT_PATH).getPath()
        ));

        for (var line = bf.readLine(); line != null; line = bf.readLine()) {
            int[] data = new int[line.length()];
            for (int i = 0; i < line.length(); i++) {
                data[i] = line.codePointAt(i);
            }

            val.add(data);
        }

        bf.close();

        return val.toArray(int[][]::new);
    }

    @Test
    public void partOneTest() throws Exception {
        var data = getInput();
        var count = Day04CeresSearch.partOne(data);

        assertThat(count).isEqualTo(2646);
    }

    @Test
    public void partTwoTest() throws Exception {
        var data = getInput();
        var count = Day04CeresSearch.partTwo(data);

        assertThat(count).isEqualTo(2000);
    }
}
