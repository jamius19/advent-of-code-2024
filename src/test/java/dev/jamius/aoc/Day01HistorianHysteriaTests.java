package dev.jamius.aoc;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day01HistorianHysteriaTests {
    static String INPUT_PATH = "/input/day1.txt";

    public static Day01Input getInput() throws Exception {
        BufferedReader bfReader = new BufferedReader(new FileReader(Day01HistorianHysteriaTests.class.getResource(INPUT_PATH).getPath()));
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();

        for (String line = bfReader.readLine(); line != null; line = bfReader.readLine()) {
            var values = line.split("\\s+");

            list1.add(Integer.parseInt(values[0]));
            list2.add(Integer.parseInt(values[1]));
        }

        bfReader.close();

        var arr1 = list1.stream().mapToInt(Integer::intValue).toArray();
        var arr2 = list2.stream().mapToInt(Integer::intValue).toArray();

        return new Day01Input(arr1, arr2);
    }

    @Test
    public void validReportPart01() throws Exception {
        var inputs = getInput();
        var similarityScore = Day01HistorianHysteria.similarityScore(inputs);

        System.out.println(similarityScore);
    }
}
